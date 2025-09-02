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

    String[] questions = {"First Question.",
            "Second Question.",
            "Third Question.",
            "Fourth Question.",
            "Quinta Qergunta."};

    String[] optionA_answers = {"Response A - First Question.",
            "Response A - Second Question.",
            "Response A - Third Question.",
            "Response A - Fourth Question.",
            "Response A - Quinta Qergunta."};
    String[] optionB_answers = {"Response B - First Question.",
            "Response B - Second Question.",
            "Response B - Third Question.",
            "Response B - Fourth Question.",
            "Response B - Quinta Qergunta."};
    String[] optionC_answers = {"Response C - First Question.",
            "Response C - Second Question.",
            "Response C - Third Question.",
            "Response C - Fourth Question.",
            "Response C - Quinta Qergunta."};

    int[] listAnswers = new int[questions.length];
    int[] correctAnswers = {1,2,3,4,5};
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
            optionA.setText(optionA_answers[questionNumber]);
            optionB.setText(optionB_answers[questionNumber]);
            optionC.setText(optionC_answers[questionNumber]);
            question.setText(questions[questionNumber]);
            questionNumber++;
            okButton.setEnabled(false);
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
                if(number==listAnswers[listCounter]){
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
        Toast.makeText(this,"Você acertou: " + answeredCorrectly, Toast.LENGTH_SHORT).show();
    }
}