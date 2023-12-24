package com.example.quiz_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    TextView forWrong;
    TextView forFinal;
    Button restarting;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.right);
        forWrong = (TextView) findViewById(R.id.wrong);
        forFinal = (TextView) findViewById(R.id.last);
        Intent i = getIntent();
        int sure = i.getIntExtra("MY_KEY",0);
        textView.setText("Correct Answer:" +"" +sure);
        forWrong.setText("Wrong Answers:"+""+(5-sure));
        forFinal.setText("Final Score:"+""+sure);

        restarting = (Button) findViewById(R.id.restart);

        restarting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}