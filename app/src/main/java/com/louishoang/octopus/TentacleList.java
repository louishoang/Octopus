package com.louishoang.octopus;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by louishoang on 3/31/17.
 */

public class TentacleList {
  private static TentacleList sTentacleList = null;
  private ArrayList<Tentacle> mTentacles = new ArrayList<Tentacle>();
  String LOG = "com.louishoang.octopus";


  private TentacleList(){
    for (int i = 1; i < 4; i++){
      Tentacle tentacle = new Tentacle();
      tentacle.setName("Item No " + Integer.toString(i));

      List<Boolean> list = Arrays.asList(true, false);
      Collections.shuffle(list);
      tentacle.setOn(list.get(0));
      mTentacles.add(tentacle);
    }
  };

  public static TentacleList get(){
    if (sTentacleList == null){
      sTentacleList = new TentacleList();
    }
    return sTentacleList;
  }

  public Tentacle getTentacle(UUID id){
    for (Tentacle t : mTentacles){
      if (t.getId() == id){
        return t;
      }
    }
    return null;
  }

  public ArrayList<Tentacle> getTentacles() {
    return mTentacles;
  }
}
