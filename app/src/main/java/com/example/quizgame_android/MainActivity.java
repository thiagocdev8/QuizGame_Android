package com.example.quizgame_android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public TextView question;

    public RadioButton optionA;
    public RadioButton optionB;
    public RadioButton optionC;

    public Button okButton;

    String[] questions = {"Q1: Who is known as the father of Java programming language?",
            "Q2: In which year was the first version of Java officially released?",
            "Q3: Before being called \"Java\", what was the original name of the language?",
            "Q4: Which company originally developed Java?",
            "Q5: What was one of Java’s main mottos during its early years?"};

    String[] optionA_answers = {"a) James Gosling",
            "a) 1991",
            "a) CoffeeCode",
            "a) Sun Microsystems",
            "a) \"Fast and Flexible\""};
    String[] optionB_answers = {"b) Dennis Ritchie",
            "b) 1995 ",
            "b) Oak",
            "b) Oracle",
            "b) \"Write Once, Run Anywhere\""};
    String[] optionC_answers = {"b) Dennis Ritchie",
            "c) 2000",
            "c) Green",
            "c) Microsoft",
            "c) \"Secure and Simple\""};

    int[] listAnswers = new int[questions.length];
    int[] correctAnswers = {1,2,2,1,2};
    int answeredCorrectly = 0;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        okButton = findViewById(R.id.buttonOk);
        okButton.setEnabled(false);

        question = findViewById(R.id.questionText);

        optionA = findViewById(R.id.radioButton1);
        optionB = findViewById(R.id.radioButton2);
        optionC = findViewById(R.id.radioButton3);


        radioGroup = findViewById(R.id.radioGroup);

        updateQuestions(okButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1){
                    Log.d("s", "Option #1");
                    listAnswers[questionNumber-1] = 1;
                }
                else if (checkedId == R.id.radioButton2){
                    Log.d("s", "Option #2");
                    listAnswers[questionNumber-1]= 2;
                }
                else if (checkedId == R.id.radioButton3){
                    Log.d("s", "Option #3");
                    listAnswers[questionNumber-1]= 3;
                }
                okButton.setEnabled(true);
            }
        });


    }

    public void updateQuestions(View view){
        if(questionNumber == questions.length){
            resultCheck();
        }
        else {
            resultCheck();
            optionA.setText(optionA_answers[questionNumber]);
            optionB.setText(optionB_answers[questionNumber]);
            optionC.setText(optionC_answers[questionNumber]);
            question.setText(questions[questionNumber]);
            questionNumber++;
            okButton.setEnabled(false);
            radioGroup.clearCheck();
        }

    }

    public void resultCheck(){
        if(questionNumber == questions.length){
            showResults();
        }
        else{
            int listCounter = 0;
            for(int number : listAnswers){

                System.out.println(number);
                if(number==correctAnswers[listCounter]){

                    answeredCorrectly++;
                    System.out.println("Correct Answer!");
                }
                else {

                    System.out.println("Wrong Answer!");
                }
                listCounter++;
            }
        }

    }

    public void showResults(){
        AlertDialog alertResult = new AlertDialog.Builder(this).create();
        int score = answeredCorrectly / 2;
        String stars = new String(new char[score]).replace("\0", "⭐");

        if(answeredCorrectly >= 4){
            alertResult.setTitle("\uD83C\uDF89 Quiz Over! \uD83C\uDF89");
            alertResult.setMessage("Your Score: " + stars + " (" + score + ")");
        }
        else if ( answeredCorrectly < 3){
            alertResult.setTitle("\uD83D\uDE22 Quiz Over \uD83D\uDE22");
            alertResult.setMessage("Your Score: " + stars + " (" + score + ")");
        }else if ( answeredCorrectly == 3){
            alertResult.setTitle("\uD83D\uDE10 Quiz Over \uD83D\uDE10");
            alertResult.setMessage("Your Score: " + stars + " (" + score + ")");
        }

        alertResult.show();

    }
}