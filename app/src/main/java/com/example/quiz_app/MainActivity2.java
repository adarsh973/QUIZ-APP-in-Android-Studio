package com.example.quiz_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

//    Button btn_next;

    TextView recieveintentmsg;
    RadioGroup rdg;

//    variables:
    TextView totalQuestionsTextView;
    TextView questionTextView;
    RadioButton ansA,ansB,ansC,ansD;
    Button SubmitBtn;

    Button quity;

    int score =0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @SuppressLint("MissingInflatedId")
    @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        //fetching name
        recieveintentmsg = findViewById(R.id.head2);

        rdg = (RadioGroup)findViewById(R.id.rd_grp);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message key");
        recieveintentmsg.setText(str);


        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        SubmitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        SubmitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions: " + totalQuestion);
        loadNewQuestion();

        //BACK BUTTON SWITCHING

        quity = (Button) findViewById(R.id.quit);

        quity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent3);
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        Button clickedButton = (Button) v;

        if( clickedButton.getId() == R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
                Toast.makeText(getApplicationContext(),"CORRECT",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_LONG).show();
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else{
            //choices clicked
            selectedAnswer = clickedButton.getText().toString();

        }
    }

    void loadNewQuestion()
    {
        if(currentQuestionIndex == totalQuestion)
        {
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);

        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
        rdg.clearCheck();

    }

    void finishQuiz()
    {

        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("MY_KEY" , score);
                startActivity(intent);
    }
}