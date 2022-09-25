package com.example.scrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class requests extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String City = "cityKey";
    public static final String Contact = "contactKey";
    public static final String Type = "typeKey";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.city);
        ed3=(EditText)findViewById(R.id.contact);
        ed4=(EditText)findViewById(R.id.type);
        b1=(Button)findViewById(R.id.save);
//        b2=(Button)findViewById(R.id.retrieve);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            ed1.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(City)) {
            ed2.setText(sharedpreferences.getString(City, ""));
        }
        if (sharedpreferences.contains(Contact)) {
            ed3.setText(sharedpreferences.getString(Contact, ""));
        }
        if (sharedpreferences.contains(Type)) {
            ed4.setText(sharedpreferences.getString(Type, ""));
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n  = ed1.getText().toString();
                String cit  = ed2.getText().toString();
                String con  = ed3.getText().toString();
                String ty   = ed4.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(City, cit);
                editor.putString(Contact, con);
                editor.putString(Type, ty);
                editor.commit();
                Toast.makeText(requests.this,"Thanks",Toast.LENGTH_LONG).show();

            }
        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//    retrieve();
//            }
//        });
//    }
//    public void retrieve()
//    {
//        ed1 = (EditText) findViewById(R.id.name);
//        ed2 = (EditText) findViewById(R.id.city);
//        ed3 = (EditText) findViewById(R.id.contact);
//        ed4 = (EditText) findViewById(R.id.type);
//        sharedpreferences = getSharedPreferences(MyPREFERENCES,
//                Context.MODE_PRIVATE);
//
//        if (sharedpreferences.contains(Name)) {
//            ed1.setText(sharedpreferences.getString(Name, ""));
//        }
//        if (sharedpreferences.contains(City)) {
//            ed2.setText(sharedpreferences.getString(City, ""));
//        }
//        if (sharedpreferences.contains(Contact)) {
//            ed3.setText(sharedpreferences.getString(Contact, ""));
//        }
//        if (sharedpreferences.contains(Type)) {
//            ed4.setText(sharedpreferences.getString(Type, ""));
//        }
  }
}