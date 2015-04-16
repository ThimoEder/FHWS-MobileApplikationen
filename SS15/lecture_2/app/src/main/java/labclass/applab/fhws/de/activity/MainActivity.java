package labclass.applab.fhws.de.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.material.R;

import labclass.applab.fhws.de.fragments.AutoListFragment;
import labclass.applab.fhws.de.fragments.DetailFragment;
import labclass.applab.fhws.de.model.PersonData;

public class MainActivity extends Activity implements AutoListFragment.OnListItemClick, DetailFragment.OnDetailSaved{

    private DetailFragment detailFragment = new DetailFragment();
    private AutoListFragment listFragment = new AutoListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().add(R.id.frament_container, listFragment).commit();
    }

    @Override
    public void onMyListItemClick(PersonData data) {
        detailFragment.setData(data);
        getFragmentManager().beginTransaction().replace(R.id.frament_container, detailFragment).commit();
    }


    @Override
    public void onSave(PersonData data) {
        listFragment.onNewData(data);
        getFragmentManager().beginTransaction().replace(R.id.frament_container, listFragment).commit();
    }
}
