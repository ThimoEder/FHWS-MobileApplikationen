package labclass.applab.fhws.de.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.material.R;

import java.util.List;

import labclass.applab.fhws.de.recycleview.MyViewAdapter;
import labclass.applab.fhws.de.listview.MyListAdapter;
import labclass.applab.fhws.de.model.PersonData;
import labclass.applab.fhws.de.utils.Utils;


public class ManualListActivity extends Activity {

    private List<PersonData> personData = Utils.createData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initializeListView();
        initializeViewWithRecycler();
    }


    /**
     * Manually intialize a List view but not very efficient.
     * You can replace the MyListAdapter with the MyBaseAdapter
     */
    private void initializeListView() {
        setContentView(R.layout.listview_simple);

        final ListView listview = (ListView) findViewById(android.R.id.list);
        MyListAdapter adapter = new MyListAdapter(getBaseContext(), android.R.layout.simple_list_item_1, personData);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Item clicked: " + personData.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * We are using the RecycleView, which is very efficient in handling big datasets
     * Better handling of complicated views because of ViewHolder and the distinguishing between initialisation and the actual recycling
     */
    private void initializeViewWithRecycler() {
        setContentView(R.layout.listview_recycler);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //User the adapter with the Lollipop CardView
        RecyclerView.Adapter mAdapter = new MyViewAdapter(personData, R.layout.cardview_item_person);
        mRecyclerView.setAdapter(mAdapter);
    }
}
