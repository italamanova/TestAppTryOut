package com.example.ira.testapptryout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ira.testapptryout.rest.Controller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller(MainActivity.this);
        controller.login();
        Intent myIntent = new Intent(this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
