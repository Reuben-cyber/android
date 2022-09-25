package com.example.scrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class music extends AppCompatActivity {
TextView t1;
FloatingActionButton rew,fwd;
ToggleButton play;
ImageView music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        t1=(TextView) findViewById(R.id.textView1);
        rew=(FloatingActionButton) findViewById(R.id.rew);
        play=(ToggleButton) findViewById(R.id.play);
        fwd=(FloatingActionButton) findViewById(R.id.fwd);
        music=(ImageView)findViewById(R.id.music);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.vathil);
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.rm);

        play.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mediaPlayer.start();
                    Toast toast = Toast.makeText(getApplicationContext(), "Playing Music", Toast.LENGTH_SHORT);
                    toast.show();
                    music.setImageDrawable(getDrawable(R.drawable.neram));
                    play.setBackground(getDrawable(R.drawable.ic_media_pause));
                    t1.setText(R.string.neram);
                } else {
                    mediaPlayer.pause();
                    Toast toast = Toast.makeText(getApplicationContext(), "Music Stopped", Toast.LENGTH_SHORT);
                    toast.show();
                    music.setImageDrawable(getDrawable(R.drawable.neram));
                    play.setBackground(getDrawable(R.drawable.ic_media_play));
                    t1.setText(R.string.neram);
                }
            }
        });
        fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer1.start();
                Toast toast = Toast.makeText(getApplicationContext(), "Playing next song", Toast.LENGTH_SHORT);
                toast.show();
                music.setImageDrawable(getDrawable(R.drawable.rescue));
                t1.setText(R.string.one);
            }
        });

    }
}