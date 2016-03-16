package com.example.teramino.playchess.Activity;

import com.firebase.client.Firebase;

/**
 * Created by teramino on 3/13/16.
 */
public class FirebaseClass extends android.app.Application {

    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
