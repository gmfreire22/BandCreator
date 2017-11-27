package com.example.guilh.bandcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button fazer_login_button;
    Button go_back_button;
    Intent fazer_login;
    Intent go_back;
    EditText usuario_editText;
    EditText password_editText;
    FirebaseAuth auth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario_editText = (EditText) findViewById(R.id.usuario_input);
        password_editText = (EditText) findViewById(R.id.senha_input);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
           startActivity(new Intent(Login.this, MainActivity.class));
           finish();
        }
        fazer_login_button = (Button) findViewById(R.id.fazer_login);
        go_back_button = (Button) findViewById(R.id.voltar_cadastro);
        go_back = new Intent(this, SignUp.class);
        fazer_login = new Intent(this, search.class);
        fazer_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = usuario_editText.getText().toString();
                final String password = password_editText.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            if (password.length() < 6) {
                                                Toast.makeText(getApplicationContext(), "A senha tem que ter pelo menos 6 caracteres", Toast.LENGTH_LONG).show();
                                            } else {
                                                Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();

                                            }
                                        } else {
                                            String para_fazer_login = MyPreferences.isLogged(Login.this, email, password);
                                            startActivity(fazer_login);
                                            finish();
                                        }
                                    }
                                });
            }
        });
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(go_back);
            }
        });
    }
    @Override
    public void onBackPressed() {
        return;
    }
}
