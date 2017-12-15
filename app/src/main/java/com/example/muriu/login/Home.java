package com.example.muriu.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TextView username;
    protected Button logout_btn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (TextView) findViewById(R.id.name);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        logout_btn=(Button)findViewById(R.id.logout);
        logout_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
        progressDialog.setMessage("Logging out...");
        progressDialog.show();
        firebaseAuth.signOut();
        Intent homeActivity=new Intent(Home.this, Login.class);
        startActivity(homeActivity);
        //To finish your current acivity
    }
}