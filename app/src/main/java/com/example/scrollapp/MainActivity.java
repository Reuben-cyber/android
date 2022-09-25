package com.example.scrollapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    private Button x, y, z, a,b,notify,request;
    TextView name;
    LinearLayout l1;
    ImageView i,i2;
NotificationManagerCompat notificationManagerCompat;
Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//notification from application to the system
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel= new NotificationChannel("myCh","Mychannel",NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager=getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"myCh")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_baseline_account_circle_24))
                    .setSmallIcon(R.drawable.ic_baseline_message2_24)
                    .setContentTitle("Availability Alert!!")
                    .setContentText("Click here to check the availability");

        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "The Space you wanted is currently available.");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        notification=builder.build();
            notificationManagerCompat=NotificationManagerCompat.from(this);
//notification part ends

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        l1=(LinearLayout)findViewById(R.id.l1);
        name = (TextView) findViewById(R.id.name);
        x = (Button) findViewById(R.id.news);
        y = (Button) findViewById(R.id.contact);
        z = (Button) findViewById(R.id.login);
        a = (Button) findViewById(R.id.rate);
        b=(Button)findViewById(R.id.music);
        notify=(Button)findViewById(R.id.notify);
        request=(Button)findViewById(R.id.request);
        i=(ImageView)findViewById(R.id.i1);
        registerForContextMenu(i);
        i2=(ImageView)findViewById(R.id.i2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, i2);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        name.setText(str);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), full.class);
                startActivity(i);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), contact.class);
                startActivity(i);
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), rate.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), music.class);
                startActivity(i);
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             notificationManagerCompat.notify(1,notification);
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), requests.class);
                startActivity(i);
            }
        });
        WebView web = (WebView) findViewById(R.id.web);
        web.loadUrl("https://www.google.co.in/");
    }
    //Adding menu to the main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
                Intent i = new Intent(getApplicationContext(), about.class);
                startActivity(i);
                break;
            case R.id.privacy:
                Intent i1 = new Intent(getApplicationContext(), privacy.class);
                startActivity(i1);
                break;
            case R.id.color:
                l1.setBackgroundResource(R.color.Black);
                break;

            case R.id.nav_account:
                Intent i3 = new Intent(getApplicationContext(), person.class);
                startActivity(i3);
                break;
            case R.id.home:
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // add menu items
        menu.add(0, v.getId(), 0, "Open");
        menu.add(0, v.getId(), 0, "Save");
        super.onCreateContextMenu(menu, v, menuInfo);
    }


}

