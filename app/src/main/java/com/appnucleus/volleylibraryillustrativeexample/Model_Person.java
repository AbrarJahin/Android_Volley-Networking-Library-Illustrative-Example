package com.appnucleus.volleylibraryillustrativeexample;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Person
{
    // JSON Node names
    private static final String TAG_EMAIL           =   "email";
    private static final String TAG_PHONE           =   "phone";
    private static final String TAG_PHONE_HOME      =   "home";
    private static final String TAG_PHONE_MOBILE    =   "mobile";
    private static final String TAG_NAME            =   "name";

    //Model Elements
    private String Name         =   "";
    private String Email        =   "";
    private String Phone_Mobile =   "";
    private String Phone_Home   =   "";

    public Model_Person(String ReceivedResponceFromURL) throws JSONException
    {
        /*
          Received JSON's Format is like it -
            {
                "name" : "Ravi Tamada",
                "email" : "ravi8x@gmail.com",
                "phone" : {
                    "home" : "08947 000000",
                    "mobile" : "9999999999"
                }

            }
        */
        JSONObject  reader   = new JSONObject(ReceivedResponceFromURL);
        Name            =   reader.getString(TAG_NAME);
        Email           =   reader.getString(TAG_EMAIL);
        Phone_Mobile    =   reader.getJSONObject(TAG_PHONE).getString(TAG_PHONE_MOBILE);
        Phone_Home      =   reader.getJSONObject(TAG_PHONE).getString(TAG_PHONE_HOME);;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone_Mobile() {
        return Phone_Mobile;
    }

    public String getPhone_Home() {
        return Phone_Home;
    }
}
