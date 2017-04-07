package com.louishoang.octopus;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private ListView mTentaclesListView;
  private ArrayList<Tentacle> mTentacleList;
  private ArrayAdapter<Tentacle> mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTentaclesListView = (ListView)findViewById(R.id.tentacles_list_view);
    mTentacleList = TentacleList.get().getTentacles();
    mAdapter = new TenTacleAdapter(this, mTentacleList);
    mTentaclesListView.setAdapter(mAdapter);
  }

  private class TenTacleAdapter extends ArrayAdapter<Tentacle>{
    public TenTacleAdapter(@NonNull Context context, ArrayList<Tentacle> tentacles) {
      super(context, 0, tentacles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      // Get the data for this position
      Tentacle tentacle = TentacleList.get().getTentacles().get(position);


      //Check if an existing view is being used. otherwise inflate a view.
      if(convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_tentacle, parent, false);
      }
      // Populate data
      TextView tentacleName = (TextView)convertView.findViewById(R.id.tentacle_name);
      tentacleName.setText(tentacle.getName());

      TextView tentacleStatus = (TextView)convertView.findViewById(R.id.tentacle_is_on);
      tentacleStatus.setText(tentacle.getOn().toString());

      return convertView;
    }
  }
}
