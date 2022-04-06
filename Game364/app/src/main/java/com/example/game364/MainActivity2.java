package com.example.game364;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button button0,button1,button2;
    TextView tV1,tV2,tV6,tV7,tV8;
    public int scoreComp = 0;
    public int scoreUser = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV6 = findViewById(R.id.tV6);
        tV7 = findViewById(R.id.tV7);
        tV8 = findViewById(R.id.tV8);

        String[] arr = {"Rock","Paper","Scissor"};
        final String[] comp = {""};
        // Rock button

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = "Rock";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV6.setText(R.string.matchDraw);
                }else if(finalComp.equals("Paper")){
                    scoreComp += 100;
                    tV6.setText(R.string.youLose);
                    tV8.setText(String.valueOf(scoreComp));
                }else{
                    scoreUser += 100;
                    tV6.setText(R.string.youWon);
                    tV7.setText(String.valueOf(scoreUser));
                }
            }
        });

        // Paper Button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = "Paper";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV6.setText(R.string.matchDraw);
                }else if(finalComp.equals("Scissor")){
                    scoreComp += 100;
                    tV6.setText(R.string.youLose);
                    tV8.setText(String.valueOf(scoreComp));
                }else{
                    scoreUser += 100;
                    tV6.setText(R.string.youWon);
                    tV7.setText(String.valueOf(scoreUser));
                }
            }
        });

        // Scissors Button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = "Scissor";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV6.setText(R.string.matchDraw);
                }else if(finalComp.equals("Rock")){
                    scoreComp += 100;
                    tV6.setText(R.string.youLose);
                    tV8.setText(String.valueOf(scoreComp));
                }else{
                    scoreUser += 100;
                    tV6.setText(R.string.youWon);
                    tV7.setText(String.valueOf(scoreUser));
                }
            }
        });
    }

    private String getRandom(String[] arr) {
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }
}