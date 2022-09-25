package com.example.scrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class New extends AppCompatActivity {
Button submit;
ToggleButton tbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        tbutton=(ToggleButton)findViewById(R.id.toggleButton);
        tbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(New.this,"Okay",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(New.this,"Change information if needed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        submit=(Button) findViewById(R.id.submitbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Button was clicked/tapped
                View view = findViewById(R.id.submitbutton);
                String message = "Category added successfully!!";
                int duration = Snackbar.LENGTH_SHORT;
                showSnackbar(view, message, duration);
            }
        });
    }
    public void showSnackbar(View view, String message, int duration)
    {
        Snackbar.make(view, message, duration).show();
    }
}