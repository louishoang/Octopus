package com.louishoang.octopus;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by louishoang on 3/31/17.
 */

public class TentacleList {
  private static TentacleList sTentacleList = null;
  private ArrayList<Tentacle> mTentacles;

  private TentacleList(){};

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
