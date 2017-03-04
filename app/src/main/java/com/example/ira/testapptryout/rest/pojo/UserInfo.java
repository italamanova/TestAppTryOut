package com.example.ira.testapptryout.rest.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ira on 26.02.17.
 */

public class UserInfo {
    @SerializedName("displayName")
    String displayName;

    public UserInfo(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
