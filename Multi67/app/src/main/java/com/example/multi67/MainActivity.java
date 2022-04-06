package com.example.multi67;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static  final String MSG = "hash.screen.key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void performAct(View view){
        Intent intent = new Intent(this, newPage.class);
        String msg = "Its working";
        intent.putExtra(MSG, msg);
        startActivity(intent);

    }
}