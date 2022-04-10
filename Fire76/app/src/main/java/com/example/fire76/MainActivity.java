package com.example.fire76;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef1;
    EditText editText;
    TextView textView,tV3,tV4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<Assigning textviews>
        textView =findViewById(R.id.textView2);
        tV3 =findViewById(R.id.tV3);
        tV4 =findViewById(R.id.tV4);
        //<Assigning textviews>

        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);

        //<Getting DB Reference>
        database = FirebaseDatabase.getInstance();
        //<Getting DB Reference>
        
        // Creating Unique User
        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");

        //<Setting the textValue>
        tV3.setText(name);
        tV4.setText(id);
        //<Setting the textValue>

        myRef1 = database.getReference("User")
                .child(filteredId(id)).child("msg");
        // Creating Unique User


        // Input msg from App Setting value on Server
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                myRef1.setValue(s);
            }
        });
        // Input msg from App Setting value on Server

        // Receiving data(msg) from server
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String msg = snapshot.getValue(String.class);
                textView.setText(new StringBuilder().append(name).append(":")
                        .append(msg).toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                                    }});
        // Receiving data(msg) from server
    }

    //<Filtering encoded >
    private String filteredId(String id) {
        String [] str = id.split("=");
        return str[0];
    }
    //<Filtering encoded >

}