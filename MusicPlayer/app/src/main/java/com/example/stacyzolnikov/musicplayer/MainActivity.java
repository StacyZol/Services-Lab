package com.example.stacyzolnikov.musicplayer;



import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;

import com.example.stacyzolnikov.musicplayer.Services.MusicService;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Song> songList;
     ListView songView;
    MediaPlayer mMediaPlayer;
    Button mPlay, mPause, mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songView = (ListView) findViewById(R.id.song_list);
        songList = new ArrayList<Song>();
      //  mPause = (Button) findViewById(R.id.)
        mStop = (Button) findViewById(R.id.StopButton);
        mPlay = (Button) findViewById(R.id.StartButton);


        mPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);
            }
        });


        mStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                MusicService.stop();
                stopService(new Intent(MainActivity.this, MusicService.class));
            }
        });

    }


    public void getSongList() {

    }
}
