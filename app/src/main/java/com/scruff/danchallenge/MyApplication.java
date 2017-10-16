package com.scruff.danchallenge;

import android.app.Application;

import java.util.Map;

/**
 * Created by danstavy on 13/10/2017.
 */

public class MyApplication extends Application {
    // Create the instance
    private Map<String, State> stateMap;

    public Map<String, State> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, State> stateMap) {
        this.stateMap = stateMap;
    }

}