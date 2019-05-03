package com.ufc.trabalho.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText login;
    EditText senha;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.button_signin);
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        signup = findViewById(R.id.signup);
        login();
        criarConta();
    }

    public void login() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login.getText().toString().equals("") && senha.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    proximaTela(v);
                } else {
                    Toast.makeText(getApplicationContext(), "WrongCredentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void criarConta() {
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    public void proximaTela(View view) {
        Intent intent = new Intent(this, HomeActiviry.class);
        startActivity(intent);
    }
}
