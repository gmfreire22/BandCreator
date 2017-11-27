package com.example.guilh.bandcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button fazer_cadastro_button;
    Button go_back_to_login_button;
    Intent edit_profile;
    boolean pode_fazer_login;
    FirebaseAuth auth;
    Intent go_back_to_login;
    EditText inputEmail, inputPassword, inputConfirmarPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        pode_fazer_login = false;
        auth = FirebaseAuth.getInstance();
        inputEmail = (EditText) findViewById(R.id.novo_usuario_input);
        inputPassword = (EditText) findViewById(R.id.nova_senha_input);
        inputConfirmarPassword = (EditText) findViewById(R.id.confirmar_a_senha_input);
        fazer_cadastro_button = (Button) findViewById(R.id.Fazer_cadastro);
        go_back_to_login_button = (Button) findViewById(R.id.voltar_para_login);
        go_back_to_login = new Intent(this, Login.class);
        edit_profile = new Intent(this, edit_profile.class);

        fazer_cadastro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Foi!", Toast.LENGTH_SHORT).show();
                final String email = inputEmail.getText().toString().trim();
                final String password = inputPassword.getText().toString().trim();
                String confirmarpassword = inputConfirmarPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Ponha um email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Ponha uma senha!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Senha tem que ter pelo menos 6 caracteres!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(confirmarpassword.equals(password))){
                    Toast.makeText(getApplicationContext(), "Senhas não combinam", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUp.this, "Funcionou", Toast.LENGTH_SHORT).show();
                                Toast.makeText(SignUp.this, "Funcionou: " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                if (!task.isSuccessful()) {
                                    if (password.length() < 6) {
                                        Toast.makeText(getApplicationContext(), "A senha tem que ter pelo menos 6 caracteres", Toast.LENGTH_LONG).show();
                                    }
                                    Toast.makeText(SignUp.this, "Não Funcionou: " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignUp.this, "Funcionou: " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                    pode_fazer_login = true;

                                }
                                if(pode_fazer_login){
                                auth.signInWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (!task.isSuccessful()) {
                                                        Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Fez login in", Toast.LENGTH_LONG).show();
                                                    startActivity(new Intent(SignUp.this, edit_profile.class));
                                                    finish();
                                                }
                                            }
                                        });
                            }}
                        });
            }
        });
        go_back_to_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(go_back_to_login);
            }
        });
    }
    @Override
    protected void onResume() {
       super.onResume();
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
