package labclass.applab.fhws.de.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.material.R;

import labclass.applab.fhws.de.model.PersonData;

public class DetailFragment extends Fragment {

    private PersonData personData;

    public interface OnDetailSaved {
        void onSave(PersonData data);
    }

    private OnDetailSaved listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (OnDetailSaved) activity;
    }

    /**
     * TODO Extend this method to have a full view to create a new user based on a template from personData instance
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.detail_view, null);

        final Button save = (Button) view.findViewById(R.id.save_button);
        final EditText newName = (EditText) view.findViewById(R.id.new_name);
        newName.setText(this.personData.surname);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSurname = newName.getText().toString();
                PersonData newPerson = new PersonData(personData.forename, newSurname, 999);
                listener.onSave(newPerson);
            }
        });
        return view;
    }

    public void setData(PersonData personData) {
        this.personData = personData;
    }
}
