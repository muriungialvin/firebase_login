package com.example.muriu.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    public Button mBtLogin;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

    mBtLogin = (Button) findViewById(R.id.login);

    mBtLogin.setOnClickListener(new View.OnClickListener() {
        @Overide
        public void onClick(View view){
            Login();
        }
    });
    }

    public void Login(){
        Intent intent = new Intent(this,Home.class );


        intent.putExtra("username",username.getText().toString());
        startActivity(intent);
    }

    public void create_account(View view){
        Intent intent = new Intent(this,Signup.class );
        startActivity(intent);
    }

}