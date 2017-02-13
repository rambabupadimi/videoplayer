package com.videoplayer;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    // Declare variables
    ProgressDialog pDialog;
   android.widget.VideoView videoview;

    // Insert your Video URL
    String VideoURL = "http://uds.ak.o.brightcove.com/1684477580001/1684477580001_4770363630001_2502984811001.mp4";

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoview = (VideoView)findViewById(R.id.VideoView);
        try {
              Uri vidUri = Uri.parse(VideoURL);
            videoview.setVideoURI(vidUri);

            MediaController vidControl = new MediaController(this);
            vidControl.setAnchorView(videoview);
            videoview.setMediaController(vidControl);
            videoview.start();


        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }


    }
}
