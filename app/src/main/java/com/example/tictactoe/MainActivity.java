package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, Restart;
    TextView Result, score;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag=0;
    int count= 0;
    int winO = 0;
    int winX = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        Result = findViewById(R.id.Result);
        score = findViewById(R.id.score);

    }

    @SuppressLint("SetTextI18n")
    public void Check(View view) {
        AppCompatButton CurrentBtn = (AppCompatButton) view;
        Restart = findViewById(R.id.Restart);

        Animation fade = AnimationUtils.loadAnimation(this, R.anim.anim_tictactoe);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        if (CurrentBtn.getText().toString().equals("")) {
            count++;

            if (flag == 0) {
                CurrentBtn.setText("x");
                flag = 1;
            } else {
                CurrentBtn.setText("O");
                flag = 0;
            }

            if(count>0){

                CurrentBtn.startAnimation(fade);
                Restart.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                Restart.setText("RESTART");
            }

            Restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    restart();
                }
            });
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    btn1.startAnimation(scale);
                    btn2.startAnimation(scale);
                    btn3.startAnimation(scale);
                    winner(b1);
                    Result.setText("Winner: "+b1);
                    result();
                    restart();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    btn4.startAnimation(scale);
                    btn5.startAnimation(scale);
                    btn6.startAnimation(scale);
                    winner(b4);
                    Result.setText("Winner: "+b4);
                    result();
                    restart();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    btn7.startAnimation(scale);
                    btn8.startAnimation(scale);
                    btn9.startAnimation(scale);
                    winner(b7);
                    Result.setText("Winner: "+b7);
                    result();
                    restart();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    btn1.startAnimation(scale);
                    btn5.startAnimation(scale);
                    btn9.startAnimation(scale);
                    winner(b1);
                    Result.setText("Winner: "+b1);
                    result();
                    restart();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    btn3.startAnimation(scale);
                    btn5.startAnimation(scale);
                    btn7.startAnimation(scale);
                    winner(b3);
                    Result.setText("Winner: "+b3);
                    result();
                    restart();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    btn1.startAnimation(scale);
                    btn4.startAnimation(scale);
                    btn7.startAnimation(scale);
                    winner(b1);
                    Result.setText("Winner: "+b1);
                    result();
                    restart();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    btn2.startAnimation(scale);
                    btn5.startAnimation(scale);
                    btn8.startAnimation(scale);
                    winner(b2);
                    Result.setText("Winner: "+b2);
                    result();
                    restart();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    btn3.startAnimation(scale);
                    btn6.startAnimation(scale);
                    btn9.startAnimation(scale);
                    winner(b3);
                    Result.setText("Winner: "+b3);
                    result();
                    restart();
                } else if(count==9){
                    btn1.startAnimation(scale);
                    btn1.startAnimation(scale);
                    btn1.startAnimation(scale);
                    Result.setText("Match Draw!!!");
                    result();
                    restart();
                }

            }

        }
    }

    @SuppressLint("SetTextI18n")
    public void winner(String s){
        if(Objects.equals(s, "x")){
            winX ++;
            score.setText("Score: O ="+winO +" / X = "+winX);
        }else{
            winO ++;
            score.setText("Score: O ="+winO +" / X = "+winX);
        }
    }
    public void restart(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        ;}
        }, 750);
        flag=0;
        count=0;
        Restart.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.transparent));
        Restart.setText("");
    }

    public  void  result(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Result.setText("");
            }
        }, 1000);
    }

}