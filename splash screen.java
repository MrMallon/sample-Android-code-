package com.theTeaCakeProject.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class splash extends Activity {

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        video = (VideoView)findViewById(R.id.videoView);
        String urlPath = "android.resource://" + getPackageName() + "/" + R.raw.ttcp;
        video.setVideoURI(Uri.parse(urlPath));
        video.start();
        Thread logoTimer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4500);
                    Intent i = new Intent("com.TeaCake.app.MAIN");
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        logoTimer.start();
    }
}
