package com.example.quizgame_android;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView question;

    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;

    private Button okButton;

    String questions[] = {"First Question.",
            "Second Question.",
            "Third Question.",
            "Fourth Question.",
            "Quinta Qergunta."};

    String optionA_answers[] = {"Response A - First Question.",
            "Response A - Second Question.",
            "Response A - Third Question.",
            "Response A - Fourth Question.",
            "Response A - Quinta Qergunta."};
    String optionB_answers[] = {"Response B - First Question.",
            "Response B - Second Question.",
            "Response B - Third Question.",
            "Response B - Fourth Question.",
            "Response B - Quinta Qergunta."};
    String optionC_answers[] = {"Response C - First Question.",
            "Response C - Second Question.",
            "Response C - Third Question.",
            "Response C - Fourth Question.",
            "Response C - Quinta Qergunta."};

    int[] listAnswers = new int[questions.length];
    int correctAnswers[] = {1,2,3,4,5};
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


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1){
                    Log.d("s", "Option #1");
                }
                else if (checkedId == R.id.radioButton2){
                    Log.d("s", "Option #2");
                }
                else if (checkedId == R.id.radioButton3){
                    Log.d("s", "Option #3");
                }
                okButton.setEnabled(true);
            }
        });


    }
}