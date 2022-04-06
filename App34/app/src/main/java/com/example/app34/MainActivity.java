package com.example.app34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextNumber);

        button.setOnClickListener(view -> {

            String s = editText.getText().toString();
            if (s.equals("")) {
                Toast.makeText(MainActivity.this, "Please Enter some value", Toast.LENGTH_SHORT).show();
            }
            else { int kg = Integer.parseInt(s);
                double res = Math.round(kg * 2.205 * 100.0) / 100.0;
                textView.setText("Pound value is :" + res );}
        });
    }
}