package com.example.fire76;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Base64;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button btn2;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Assigning Ids
        editText = findViewById(R.id.editTextTextPersonName2);
        btn2 = findViewById(R.id.button2);


        final String usrname = editText.getText().toString();
        final String encoded = encodeUsrname(usrname);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent(usrname, encoded);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String encodeUsrname(String usrname) {
        byte[] eBytes =  usrname.getBytes();
        final String encoded = Base64.getEncoder().encodeToString(eBytes);
        return encoded;
    }

    private void callIntent(String usrname, String encoded) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("name", usrname);
        intent.putExtra("id", encoded);
        startActivity(intent);
    }
}