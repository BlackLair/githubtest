package com.example.githubtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
//코밋만해봐

//믹스트 지우기

//이번엔 하드

//이번엔 다시 진짜 하드
//코밋만해봐
public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=(LinearLayout)findViewById(R.id.myLinear);
        myText=(TextView)findViewById(R.id.locationText);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x, y;
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    myText.setText("터치 위치 : x (" + Float.toString(x) + "), y (" + Float.toString(y) + ")");
                }
                return false;
            }
        });

// 진선우 보여줄 주석이다 이거야~
    }
}