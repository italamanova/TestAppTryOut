package com.example.ira.testapptryout.rest;

import android.util.Log;

import com.example.ira.testapptryout.utils.Constants;
import com.example.ira.testapptryout.rest.pojo.AuthToken;
import com.example.ira.testapptryout.rest.pojo.User;
import com.example.ira.testapptryout.rest.pojo.UserInfo;
import com.example.ira.testapptryout.utils.Prefs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class RetrofitClient {
    private static final String TAG = "RetrofitClient";


    public static Endpoints getApiService(final Prefs prefs) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);


        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                String credentials = String.format("%smat", prefs.getAuthToken());
                Log.v(TAG, credentials);
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", credentials)
                        .build();
                return chain.proceed(newRequest);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        builder.interceptors().add(logging);
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(Endpoints.class);
    }

    public interface Endpoints {
        @POST("auth/login/")
        Call<AuthToken> log_in(@Body User user);

        @GET("users/")
        Call<UserInfo> get_profile();
    }

}
