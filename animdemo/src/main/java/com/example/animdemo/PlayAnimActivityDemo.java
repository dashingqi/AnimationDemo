package com.example.animdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayAnimActivityDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paly_anim_demo);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        final ImageView iv = findViewById(R.id.iv);

        final AnimationDrawable drawable = (AnimationDrawable) iv.getDrawable();

        for (int i = 1; i <= 14; i++) {

            int id = getResources().getIdentifier("list_icon_gif_playing" + i, "drawable", getPackageName());
            Drawable drawable1 = getResources().getDrawable(id);

            //增加一帧 持续时间60秒
            drawable.addFrame(drawable1,60);

        }

//        drawable.setOneShot(false);
        drawable.start();


//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawable.start();
//
//            }
//        });
//
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawable.stop();
//
//            }
//        });

    }
}
