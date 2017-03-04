package com.example.ira.testapptryout.rest.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ira on 19.02.17.
 */

public class User {
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
