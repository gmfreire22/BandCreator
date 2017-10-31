package com.example.guilh.bandcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Button fazer_login_button;
    Button go_back_button;
    Intent fazer_login;
    Intent go_back;
    EditText usuario_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario_editText = (EditText) findViewById(R.id.usuario_input);
        fazer_login_button = (Button) findViewById(R.id.fazer_login);
        go_back_button = (Button) findViewById(R.id.voltar_cadastro);
        go_back = new Intent(this, SignUp.class);
        fazer_login = new Intent(this, search.class);

        fazer_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fazer_login);
            }
        });
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(go_back);
            }
        });
    }
}
