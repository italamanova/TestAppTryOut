package com.example.ira.testapptryout.utils;

/**
 * Created by ira on 26.02.17.
 */

public class Constants {
    private static String HOST = "192.168.1.105";
    private static int PORT = 8080;
    private static String PROTOCOL = "http://";  //USE HTTPS IN PRODUCTION!!
    public static String BASE_URL = PROTOCOL + HOST + ":" + PORT + "/activity/api/";
    public static String AUTH_STATUS_OK = "OK";
}
