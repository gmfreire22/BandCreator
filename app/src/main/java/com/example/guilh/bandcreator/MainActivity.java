package com.example.guilh.bandcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cadastro, login;
    Intent intent_login;
    Intent intent_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cadastro = (Button) findViewById(R.id.Cadastrar_se);
        login = (Button) findViewById(R.id.login);
        intent_login = new Intent(this, Login.class);
        intent_signup = new Intent(this, SignUp.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_login);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(intent_signup);
            }
        });
    }
    @Override
    public void onBackPressed() {
        return;
    }
}