package com.louishoang.octopus;

import java.util.UUID;

/**
 * Created by louishoang on 3/31/17.
 */

public class Tentacle {
  private UUID mId;
  private String mName;
  private Boolean mIsOn;

  public UUID getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public Boolean getOn() {
    return mIsOn;
  }

  public void setOn(Boolean on) {
    mIsOn = on;
  }
}
