package com.ufc.trabalho.trabalhofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText login;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.button_signin);
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        login();
    }

    public void login() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(login.getText().toString().equals("admin") && senha.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "WrongCredentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
