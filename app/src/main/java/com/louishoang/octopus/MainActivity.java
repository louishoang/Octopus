package com.louishoang.octopus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
  private ListView mTentaclesListView;
  private TentacleList mTentacleList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTentaclesListView = (ListView)findViewById(R.id.tentacles_list_view);
    TentacleList.get(this).getTentacles();
  }
}
