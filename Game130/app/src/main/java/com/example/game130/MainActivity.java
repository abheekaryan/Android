package com.example.game130;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Boolean gameActive = true;
    TextView textView;
    int activePlayer = 0;
    private int counter = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPositions = {{0,1,2},{3,4,5},{6,7,8}
                            ,{0,3,6},{1,4,7},{2,5,8}
                            ,{0,4,8},{2,4,6}};
    // 0 - X
    // 1 - O
    // 2 - null
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Getting Tap
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
                img.setImageResource(R.drawable.x_transparent);
                activePlayer = 1;
            }else{
                img.setImageResource(R.drawable.o_transparent_dash);
                activePlayer = 0;
            }
        }
        checkForWinner();
        counter++;
        checkForMatchDraw(counter);
    }

    // Checking for draw
    private void checkForMatchDraw(int counter) {
        if(counter==9){
            textView.setText(R.string.match_draw);
            gameActive = false;
        }
    }

    private void gameReset(View view) {
        gameActive = true;
        Random ran = new Random();
        activePlayer = ran.nextInt(2);
        counter = 0;
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
        textView = findViewById(R.id.textView);
            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]] != 2) {
                    String winnerStr;
                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = "X won";
                    } else {
                        winnerStr = "O Won";
                    }
                    textView.setText(winnerStr);
                    gameActive = false;
                    final MediaPlayer won = MediaPlayer.create(this, R.raw.won);
                    won.start();
                }

            }
     }
}