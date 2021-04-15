package com.example.githubtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
//코밋만해봐

//믹스트 지우기

//이번엔 하드

//이번엔 다시 진짜 하드
//코밋만해봐
public class MainActivity extends AppCompatActivity {
    Button myButton;

    ValueAnimator colorAnimation;
    int colorfrom, colorto, count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=findViewById(R.id.myButton);
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




// 진선우 보여줄 주석이다 이거야~
    }
}