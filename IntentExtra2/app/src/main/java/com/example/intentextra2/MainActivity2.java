package com.example.intentextra2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tV1, tV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tV1 = (TextView)findViewById(R.id.textView);
        tV2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name_key");
        String id = intent.getStringExtra("id_key");
        tV1.setText("Usrname:   "+name);
        tV2.setText("Id:    "+id);
    }
}