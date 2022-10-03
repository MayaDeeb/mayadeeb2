package com.example.mayadeeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etMail, etPassword;
    private Button btnLogIn, btnSignUp;
    private TextView tvSignUp;

    private final String valid_mail = "admin";
    private final String valid_password = "1";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etMail = findViewById(R.id.editTextTextEmailAddress);
        etPassword = findViewById(R.id.editTextTextPassword);
        btnLogIn = findViewById(R.id.button);
        btnSignUp = findViewById(R.id.button2);

        preferences = getSharedPreferences("userinfo", 0);


    }

    public void register(View view) {
        Intent i_register = new Intent(this, RegisterActivity.class);
        startActivity(i_register);

    }

    public void login(View view) {
        String input_mail = etMail.getText().toString();
        String input_password = etPassword.getText().toString();

        String registeredMail = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");

        if (input_mail.equals(registeredMail) && input_password.equals(registeredPassword)) {
            Intent i_mail = new Intent(this, Mail.class);
            startActivity(i_mail);
        } else {
            Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
        }
    }


    }






