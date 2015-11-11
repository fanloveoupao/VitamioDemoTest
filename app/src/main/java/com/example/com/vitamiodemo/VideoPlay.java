package com.example.com.vitamiodemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoPlay extends ActionBarActivity implements MediaPlayer.OnPreparedListener {
    VideoView videoView;
    String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES) + "/Moon.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        setContentView(R.layout.activity_video_play);
        videoView = (VideoView) findViewById(R.id.surface_view);
        initVideoView();
    }

    private void initVideoView() {
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath(path);

        videoView.requestFocus();
//        videoView.setOnPreparedListener(this);
        videoView.start();
    }

    public void playVideo(View view) {
        videoView.setVideoPath(path);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.setPlaybackSpeed(1.0f);
    }
}
