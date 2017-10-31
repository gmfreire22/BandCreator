package com.example.guilh.bandcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    Button fazer_cadastro_button;
    Button go_back_to_login_button;
    Intent fazer_cadastro;
    Intent go_back_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        fazer_cadastro_button = (Button) findViewById(R.id.Fazer_cadastro);
        go_back_to_login_button = (Button) findViewById(R.id.voltar_para_login);
        go_back_to_login = new Intent(this, Login.class);
        fazer_cadastro = new Intent(this, search.class);

        fazer_cadastro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fazer_cadastro);
            }
        });
        go_back_to_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(go_back_to_login);
            }
        });
    }
}
