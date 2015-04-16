package labclass.applab.fhws.de.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.material.R;

import labclass.applab.fhws.de.model.PersonData;

/**
 * Created by Orrimp on 12/03/15.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView forename;
    private final TextView surname;


    public MyViewHolder(View itemView) {
        super(itemView);
        id = ((TextView) itemView.findViewById(R.id.item_id));
        forename = ((TextView) itemView.findViewById(R.id.forename));
        surname = ((TextView) itemView.findViewById(R.id.surname));
    }

    public void assignData(PersonData data) {
            this.id.setText("" + data.id);
            this.forename.setText(data.forename);
            this.surname.setText(data.surname);
    }
}
