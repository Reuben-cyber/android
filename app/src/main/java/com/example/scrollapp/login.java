package com.example.scrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email, pass;
    Button login;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        i1 = (ImageView) findViewById(R.id.imageView2);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("Reuben") &&
                        pass.getText().toString().equals("pass")) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    String str = email.getText().toString();
                    i.putExtra("message_key", "Hello, " + str);
                    startActivity(i);
                    Toast toast = Toast.makeText(getApplicationContext(), "Welcome " + str, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wrong Credentials. Try again!!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}