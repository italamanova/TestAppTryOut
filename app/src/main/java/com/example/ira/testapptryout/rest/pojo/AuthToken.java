package com.example.ira.testapptryout.rest.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ira on 19.02.17.
 */

public class AuthToken {
    @SerializedName("token")
    String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
