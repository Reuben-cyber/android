package com.example.scrollapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class full extends AppCompatActivity {
FloatingActionButton button;
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        button=(FloatingActionButton) findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), New.class);
                startActivity(i);
            }
        });
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        listener();
    }

    public void listener() {
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction f1 =
                    getSupportFragmentManager().beginTransaction();
            BlankFragment1 ff1=new BlankFragment1();
            f1.replace(R.id.frame,ff1);
            f1.commit();
        }
    });

    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction f2 =
                    getSupportFragmentManager().beginTransaction();
            BlankFragment2 ff2=new BlankFragment2();
            f2.replace(R.id.frame,ff2);
            f2.commit();
        }
    });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction f1 =
                    getSupportFragmentManager().beginTransaction();
            BlankFragment3 ff3=new BlankFragment3();
            f1.replace(R.id.frame,ff3);
            f1.commit();
        }
    });

    b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction f1 =
                    getSupportFragmentManager().beginTransaction();
            BlankFragment4 ff4=new BlankFragment4();
            f1.replace(R.id.frame,ff4);
            f1.commit();
        }
    });

    }

    //Adding menu to the main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.category,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId()))
        {
            case R.id.add:
                Intent i1 = new Intent(getApplicationContext(), add.class);
                startActivity(i1);
                break;

            case R.id.home:
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i2);
                break;

            case R.id.contact:
                Intent i3 = new Intent(getApplicationContext(), contact.class);
                startActivity(i3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
