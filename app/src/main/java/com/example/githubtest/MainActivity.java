package com.example.githubtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.media.audiofx.EnvironmentalReverb;
import android.media.audiofx.PresetReverb;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
//코밋만해봐

//믹스트 지우기

//이번엔 하드

//이번엔 다시 진짜 하드
//코밋만해봐
public class MainActivity extends AppCompatActivity {
    Button myButton, btn_1, btn_2;
    SoundPool spool;
    ValueAnimator colorAnimation;
    int colorfrom, colorto, count=0;
    int soundID=0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=findViewById(R.id.myButton);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        colorfrom=((ColorDrawable)myButton.getBackground()).getColor();
        colorto=Color.parseColor("#0000ff");
        colorAnimation=ValueAnimator.ofObject(new ArgbEvaluator(), colorfrom, colorto);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                myButton.setBackgroundColor((int)valueAnimator.getAnimatedValue());
            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myTransition.reverseTransition(1000);
                if(count==0) {
                    colorAnimation.setObjectValues(((ColorDrawable) view.getBackground()).getColor(), Color.parseColor("#ff0000"));
                    count = 1;
                }else{
                    colorAnimation.setObjectValues(((ColorDrawable) view.getBackground()).getColor(), Color.parseColor("#0000ff"));
                    count=0;
                }
                colorAnimation.setDuration(200);
                colorAnimation.start();
            }
        });

        PresetReverb mReverb=new PresetReverb(0,0);
        mReverb.setPreset(PresetReverb.PRESET_LARGEHALL);


        AudioAttributes audioAttributes=new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        spool=new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(5).build();
        int key=spool.load(this, R.raw.p46, 1);
        btn_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    mReverb.setEnabled(true);
                    soundID=spool.play(key,1,1,0,0,1);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    spool.stop(soundID);
                }
                return false;
            }
        });
        btn_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    mReverb.setEnabled(false);
                    soundID=spool.play(key,1,1,0,0,1);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    spool.stop(soundID);
                }
                return false;
            }
        });



// 진선우 보여줄 주석이다 이거야~
    }
}