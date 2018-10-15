package com.example.animdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private ImageView circle4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // scaleAnimDemo(imageView);
      //  rotateAnimDemo(imageView);
        initView();
        scaleAndAlphaAnimDemo();




    }

    private void initView() {
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle1);
        circle3 = findViewById(R.id.circle1);
        circle4 = findViewById(R.id.circle1);
    }


    /**
     * 旋转框
     * @param view
     */
    private void scaleAnimDemo(View view){

        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(4000);

        view.startAnimation(scaleAnimation);

    }

    /**
     * 加载框
     * @param view
     */
    private void rotateAnimDemo(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(2000);
        //无限循环
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    private void scaleAndAlphaAnimDemo(){

        Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scal_alpha_anim);
        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scal_alpha_anim);
        Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scal_alpha_anim);
        Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scal_alpha_anim);

        circle1.startAnimation(animation1);
        //动画持续的时间
        animation2.setStartOffset(600);
        circle2.startAnimation(animation2);
        animation3.setStartOffset(1200);
        circle3.startAnimation(animation3);
        animation4.setStartOffset(1800);
        circle4.startAnimation(animation4);

    }
}
