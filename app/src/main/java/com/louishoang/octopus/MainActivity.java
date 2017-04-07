package com.louishoang.octopus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    mAdapter = new ArrayAdapter<Tentacle>(this, R.layout.single_tentacle, R.id.tentacle_name, mTentacleList);
    mTentaclesListView.setAdapter(mAdapter);
  }
}
