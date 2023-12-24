package com.example.quiz_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button send,Developer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        editText = (EditText) findViewById(R.id.username);
        send = (Button) findViewById(R.id.start);
        Developer = (Button) findViewById(R.id.about);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_text = editText.getText().toString().trim();

                if(ed_text.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent2 = new Intent(getApplicationContext(),MainActivity2.class);
                    intent2.putExtra("message key",ed_text);
                    startActivity(intent2);
                }
            }
        });

        Developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
            }
        });
    }
}