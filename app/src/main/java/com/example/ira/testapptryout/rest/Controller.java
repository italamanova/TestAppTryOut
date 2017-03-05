package com.example.ira.testapptryout.rest;

import android.content.Context;
import android.media.ExifInterface;
import android.util.Log;

import com.example.ira.testapptryout.rest.pojo.AuthToken;
import com.example.ira.testapptryout.rest.pojo.User;
import com.example.ira.testapptryout.rest.pojo.UserInfo;
import com.example.ira.testapptryout.utils.Prefs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ira on 26.02.17.
 */

public class Controller {
    Context context;
    Prefs prefs;
    RetrofitClient.Endpoints api;

    public Controller(Context context) {
        this.context = context;
        prefs = new Prefs(context);
        api = RetrofitClient.getApiService(prefs);
    }


    User user_with_email = new User("baa@mail.com", "pass1");

    public void login() {
        Call<AuthToken> call = api.log_in(user_with_email);
//        try {
//
//            AuthToken token = call.execute().body();
//            prefs.removeAuthToken();
//            prefs.setAuthToken("Bearer " + token.getToken());
//        } catch (Exception e) {
//            Log.v("Token-error", e.toString());
//        }
        call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> token, Response<AuthToken> response) {
                if (response.isSuccessful()) {
                    AuthToken t = response.body();
                    Log.v("Token-success", t.getToken());
//                    prefs.removeAuthToken();
                    prefs.setAuthToken("Bearer " + t.getToken());

                } else {
                    Log.v("Token-error", response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void getProfile() {
        Call<UserInfo> call = api.get_profile();
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> token, Response<UserInfo> response) {
                if (response.isSuccessful()) {
                    UserInfo u = response.body();
                    Log.v("UserInfo-success", u.getDisplayName());


                } else {
                    Log.v("UserInfo-error", response.message());
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
