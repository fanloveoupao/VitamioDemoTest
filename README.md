# VitamioDemoTest
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
