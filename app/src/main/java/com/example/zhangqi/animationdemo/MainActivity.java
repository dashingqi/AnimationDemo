package com.example.zhangqi.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startAnim = findViewById(R.id.btn_start_anim);
        final TextView tv = findViewById(R.id.tv);

        //加载动画
        final Animation scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale);
        final Animation alphaAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha);
        final Animation rotateAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
        //加速插值器
        //rotateAnimation.setInterpolator(new AccelerateInterpolator());
        //减速插值器 速度一开始增加到最大值，然后一直处于减速的阶段，直到停止。
        //rotateAnimation.setInterpolator(new DecelerateInterpolator());
        //匀速插值器
//        rotateAnimation.setInterpolator(new LinearInterpolator());
        //弹跳插值器
        //rotateAnimation.setInterpolator(new BounceInterpolator());
        //初始偏移插值器 tension 默认值是2  值越大，初始的偏移量越大，而且速度越大。
        //rotateAnimation.setInterpolator(new AnticipateInterpolator(4));
        //结束偏移插值器 在动画结束的位置，继续运动一段时间，然后恢复到结束位置
        //rotateAnimation.setInterpolator(new OvershootInterpolator());
        //初始偏移和结束偏移插值器
        //rotateAnimation.setInterpolator(new AnticipateOvershootInterpolator());

        //循环插值器   cycle（周期） cycles ：循环次数
        rotateAnimation.setInterpolator(new CycleInterpolator(1));
        final Animation translateAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_tranlate);
        //加速减速插值器
//        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setInterpolator(new AnticipateInterpolator());
        final Animation animationSet = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_set);
        startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.VISIBLE);
                //缩放动画
                //tv.startAnimation(scaleAnimation);
                //透明动画
                //tv.startAnimation(alphaAnimation);
                //旋转动画
                tv.startAnimation(rotateAnimation);
                //平移动画
                //tv.startAnimation(translateAnimation);
                //tv.startAnimation(animationSet);
                //scaleAnimationDemo(tv);
                //alphaAnimationDemo(tv);
                //rotateAnimationDemo(tv);
                //translateAnimationDemo(tv);
                //animationSetDemo(tv);
                //testAnimationListener(tv);
            }
        });
    }


    /**
     * 缩放动画
     * @param view
     */
    private void scaleAnimationDemo(View view){

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);

    }


    /**
     * 透明动画
     * @param view
     */
    private void alphaAnimationDemo(View view){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    /**
     * 旋转动画
     * @param view
     */
    private void rotateAnimationDemo(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(0,720,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    /**
     * 平移动画
     * @param view
     */
    private void translateAnimationDemo(View view){
        TranslateAnimation translateAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0, TranslateAnimation.ABSOLUTE, -80, TranslateAnimation.ABSOLUTE, 0, TranslateAnimation.ABSOLUTE, -80);
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
    }

    private void animationSetDemo(View view){

        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        RotateAnimation rotateAnimation = new RotateAnimation(0,720,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);

        view.startAnimation(animationSet);
    }

    /**
     * 动画的事件
     * @param view
     */
    private void testAnimationListener(final View view){
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 720, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);


        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(rotateAnimation);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(scaleAnimation);
    }
}
