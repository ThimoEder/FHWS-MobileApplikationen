package labclass.applab.fhws.de.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import labclass.applab.fhws.de.model.PersonData;

/**
 * Created by Orrimp on 12/03/15.
 */
public class MyViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final List<PersonData> personData;
    private final int layout;


    public MyViewAdapter(List<PersonData> personData, int layout) {
        this.personData = personData;
        this.layout = layout;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myRecycleViewHolder, int position) {
        myRecycleViewHolder.assignData(personData.get(position));
    }

    @Override
    public long getItemId(int position) {
        return personData.get(position).id;
    }

    @Override
    public int getItemCount() {
        return personData.size();
    }
}