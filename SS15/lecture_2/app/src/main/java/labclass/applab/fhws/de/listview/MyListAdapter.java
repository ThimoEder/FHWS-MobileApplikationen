package labclass.applab.fhws.de.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.material.R;

import java.util.List;

import labclass.applab.fhws.de.model.PersonData;

/**
 * Created by Orrimp on 12/03/15.
 */
public class MyListAdapter extends ArrayAdapter<PersonData> {

    private final List<PersonData> personData;
    //There are other constructors to pass data in array form for example
    public MyListAdapter(Context context, int resource, List<PersonData> personData) {
        super(context, resource, personData);
        this.personData = personData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
