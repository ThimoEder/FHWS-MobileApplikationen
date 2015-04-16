package labclass.applab.fhws.de.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.material.R;

import java.util.List;

import labclass.applab.fhws.de.model.PersonData;

/**
 * When implementing the BaseAdapter there a bit more to do then using already derived classes such as ArrayListAdapter
 * The overriden methods are called by the ListView
 */
public class MyBaseAdapter extends BaseAdapter {

    private final Context context;
    private final List<PersonData> personData;

    public MyBaseAdapter(Context context, List<PersonData> personData) {
        this.context = context;
        this.personData = personData;
    }

    @Override
    public int getCount() {
        return personData.size();
    }

    @Override
    public Object getItem(int position) {
        return personData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personData.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, null);
        }

        final TextView id = (TextView) convertView.findViewById(R.id.listview_item_id);
        final TextView forename = (TextView) convertView.findViewById(R.id.forename);
        final TextView surname = (TextView) convertView.findViewById(R.id.surname);

        PersonData p = personData.get(position);
        id.setText("" + p.id);
        forename.setText(p.forename);
        surname.setText(p.surname);

        return convertView;
    }
}
