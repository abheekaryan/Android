package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button0,button1,button2;
    TextView tV1,tV2,tV3;
    //private static  int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);

        String[] arr = {"Rock","Paper","Scissor"};
        final String[] comp = {""};
        // Rock button

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Rock", Toast.LENGTH_SHORT).show();
                String input = "Rock";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                        tV3.setText(R.string.matchDraw);
                }else if(finalComp.equals("Paper")){
                    tV3.setText(R.string.youLose);
                }else{
                    tV3.setText(R.string.youWon);
                }
            }
        });

        // Paper Button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Paper", Toast.LENGTH_SHORT).show();
                String input = "Paper";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV3.setText(R.string.matchDraw);
                }else if(finalComp.equals("Scissor")){
                    tV3.setText(R.string.youLose);
                }else{
                    tV3.setText(R.string.youWon);
                }
            }
        });

        // Scissors Button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Scissor", Toast.LENGTH_SHORT).show();
                String input = "Scissor";
                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV1.setText(input);
                tV2.setText(finalComp);
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV3.setText(R.string.matchDraw);
                }else if(finalComp.equals("Rock")){
                    tV3.setText(R.string.youLose);
                }else{
                    tV3.setText(R.string.youWon);
                }
            }
        });
    }

    private String getRandom(String[] arr) {
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }
}