package com.example.game130;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ImageView img0,img1,img2,img3,img4,img5,img6,img7,img8,img9;
        Boolean gameActive = true;

    int activePlayer = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPositions = {{0,1,2}
                            ,{3,4,5}
                            ,{6,7,8}
                            ,{0,3,6}
                            ,{1,4,7}
                            ,{2,5,8}
                            ,{0,4,8}
                            ,{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // 0 - X
    // 1 - O
    // 2 - null
    public void onTap(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activePlayer;
            if(activePlayer == 0){
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
            }else{
                img.setImageResource(R.drawable.x0);
                activePlayer = 0;
            }
        }
        checkForWinner();
    }

    private void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.img0)).setImageResource(0);
        ((ImageView)findViewById(R.id.img1)).setImageResource(0);
        ((ImageView)findViewById(R.id.img2)).setImageResource(0);
        ((ImageView)findViewById(R.id.img3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img4)).setImageResource(0);
        ((ImageView)findViewById(R.id.img5)).setImageResource(0);
        ((ImageView)findViewById(R.id.img6)).setImageResource(0);
        ((ImageView)findViewById(R.id.img7)).setImageResource(0);
        ((ImageView)findViewById(R.id.img8)).setImageResource(0);

        TextView textView = findViewById(R.id.textView);
        textView.setText(R.string.game_restart_again);

    }

    private void checkForWinner() {
        for(int [] winPosition : winPositions){
            String winnerStr = "";
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2  && gameState[winPosition[1]] !=2 &&
                    gameState[winPosition[2]] != 2){
                final MediaPlayer won = MediaPlayer.create(this, R.raw.won);
                won.start();
                if(gameState[winPosition[0]] == 0){winnerStr = "O won";}
                else{winnerStr = "X Won";}
                gameActive = false;
            }
            TextView textView = findViewById(R.id.textView);
            textView.setText(winnerStr);
        }
    }
}