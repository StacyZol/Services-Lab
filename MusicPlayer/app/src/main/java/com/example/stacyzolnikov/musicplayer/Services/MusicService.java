package com.example.stacyzolnikov.musicplayer.Services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;



/**
 * Created by stacyzolnikov on 8/8/16.
 */
public class MusicService extends Service {
    private static final String TAG = "MusicService";
    public static MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player == null) {
            String url = "https://soundcloud.com/aviciiofficial/taste-the-feeling-avicii-vs";
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            try {
                player.setDataSource(url);
                player.prepare();
            } catch (IOException ignore) {
                //e.printStackTrace();
            }
            player.start();

        }
        else {
            play();
        }
        return START_NOT_STICKY;
    }

    public void play(){
        if (player !=null && player.isPlaying()){
            player.start();
        }
    }

    public static void pause() {
        if (player != null && player.isPlaying()){
            player.pause();
        }
    }

    public static void stop() {
        player.stop();
        player.release();
    }

}
