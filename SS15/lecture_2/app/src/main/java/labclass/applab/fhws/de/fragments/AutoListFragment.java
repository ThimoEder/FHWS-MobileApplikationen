package labclass.applab.fhws.de.fragments;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.material.R;

import java.util.List;

import labclass.applab.fhws.de.activity.MainActivity;
import labclass.applab.fhws.de.fragments.DetailFragment;
import labclass.applab.fhws.de.listview.MyListAdapter;
import labclass.applab.fhws.de.model.PersonData;
import labclass.applab.fhws.de.utils.Utils;

/**
 * Created by Orrimp on 15/04/15.
 */
public class AutoListFragment extends ListFragment implements AdapterView.OnItemClickListener{

    private MyListAdapter adapter;
    private OnListItemClick listener;

    public interface OnListItemClick {
        void onMyListItemClick(PersonData data);
    }

    public List<PersonData> personData = Utils.createData();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (OnListItemClick)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.listview_simple, container, false);
        adapter = new MyListAdapter(getActivity(), android.R.layout.simple_list_item_1, personData);

        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(this);   //getListView() is always there
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item clicked: " + personData.get(position).toString(), Toast.LENGTH_SHORT).show();
        if(listener != null){
            listener.onMyListItemClick(personData.get(position));
        }
    }

    public void onNewData(PersonData personData) {
        this.personData.add(personData);
        //Inform your adapter about the new data.
        this.adapter.notifyDataSetChanged();
    }
}
