package com.beacheslav.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestJava extends AppCompatActivity {
    private Button but;
    public final static String KEY_NEW_ID = "com.beacheslav.myapplication.presenter.navigator.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        but = (Button) findViewById(R.id.register_button);
//
//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(TestJava.this, RegistrationActivity.class);
//                startActivity(i);
//            }
//        });
    }
}
