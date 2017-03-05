package com.example.ira.testapptryout.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ira.testapptryout.R;
import com.example.ira.testapptryout.rest.Controller;
import com.example.ira.testapptryout.utils.Prefs;

public class MainActivity extends AppCompatActivity {

    Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = new Prefs(MainActivity.this);
        if (prefs.getAuthToken() == null) {
            Controller controller = new Controller(MainActivity.this);
            controller.login();
        }
        Intent myIntent = new Intent(this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
