package com.example.muriu.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    private Button mBtSignup;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.username);


        mBtSignup = (Button) findViewById(R.id.signup_activity);

        mBtSignup.setOnClickListener(new View.OnClickListener() {
            @Overide
            public void onClick(View view){
                Signup();
            }
        });
    }

    private void Signup(){
        Intent intent = new Intent(this,Home.class );
        intent.putExtra("username",username.getText().toString());
        startActivity(intent);
    }
}