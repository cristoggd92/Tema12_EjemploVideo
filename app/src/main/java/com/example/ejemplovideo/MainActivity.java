package com.example.ejemplovideo;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaController mediaController = new MediaController(this);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("https://file-examples.com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Log.i("VIDEO_VIEW_TAG", "Video is ready to play");
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.i("VIDEO_VIEW_TAG", "Video is completed");
            }
        });

    }
}
