package com.example.intentextra2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Base64;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editTextTextPersonName);
        button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String encoded = callEncoder(name);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name_key", name);
                intent.putExtra("id_key", encoded);
                startActivity(intent);
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            private String callEncoder(String name) {
                byte[] bytes = name.getBytes();
                return Base64.getEncoder().encodeToString(bytes);
            }


        });
    }
}