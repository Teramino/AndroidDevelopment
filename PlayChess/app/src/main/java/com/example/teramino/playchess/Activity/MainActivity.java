package com.example.teramino.playchess.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teramino.playchess.R;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by teramino on 3/13/16.
 */
public class MainActivity  extends AppCompatActivity {

    public static String url = "https://playchess.firebaseio.com";

    public Firebase mRef = new Firebase(url);

    public EditText email;
    public EditText password;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);
        login = (Button) findViewById(R.id.loginButton);

    }

    public void createUser(View v){

        email.setText("");
        password.setText("");

        mRef.createUser(email.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error
            }
        });


        Intent intent = new Intent(this, ChessActivity.class);
        startActivity(intent);//pass the cuisine to the search activity for searching
    }


}
