package com.example.mayadeeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnRegister, btnCancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.editTextTextEmailAddress);
        etPassword = findViewById(R.id.editTextTextPassword);
        btnRegister = findViewById(R.id.button3);
        btnRegister = findViewById(R.id.button4);

        preferences = getSharedPreferences("userinfo", 0);

    }
    public void register(View view) {
        String input_Email = etEmail.getText().toString();
        String input_password = etPassword.getText().toString();
        if(input_Email.length()>0){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", input_Email);
        editor.putString("password", input_password);

        editor.apply();
        Toast.makeText(this, "User registered!", Toast.LENGTH_SHORT).show();
        Intent intent_main = new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }
    else{
        Toast.makeText(this, "Empty values, please insert!", Toast.LENGTH_SHORT).show();
    }

    }
    public void cancel(View view) {
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
       }

    }




