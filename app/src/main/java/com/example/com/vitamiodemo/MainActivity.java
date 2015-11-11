package com.example.com.vitamiodemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;


import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;

public class MainActivity extends ActionBarActivity implements MediaPlayer.OnPreparedListener {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        setContentView(R.layout.activity_main);
        initMediaPlay();
    }

    private void initMediaPlay() {
        mediaPlayer = new MediaPlayer(this);


    }

    public void play(View view) {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/table.mp3";
        try {

            mediaPlayer.setDataSource(path);

            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "开始播放", Toast.LENGTH_LONG).show();
    }

    public void pause(View view) {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    public void stop(View view) {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
