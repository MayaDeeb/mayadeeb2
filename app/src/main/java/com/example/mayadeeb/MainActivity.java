package com.example.mayadeeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    Button buttonPlus, buttonMinus;
    TextView textViewResult;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homemenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.About_menu){
            Intent i = new Intent(this, listActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.sitting_menu) {

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back Button was pressed!");
        dialog.setMessage("Are you sure you want to Exit");
        dialog.setNegativeButton("No", null);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
       dialog.setIcon(R.drawable.ic_android_black_24dp);
       AlertDialog alertDialog = dialog.create();
       alertDialog.show();
    }

    public void minus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

        textViewResult.setText((number1+number2)+"");
    }

    public void plus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

        textViewResult.setText((number1+number2)+"");
    }


    public void signIn(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}