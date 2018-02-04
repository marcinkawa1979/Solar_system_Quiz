package com.example.android.solar_system_quiz;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static int points;
    static final int MAX_POINTS = 9;

    static String answerSummary = "";

    String planetName;

    Button resumeButton;
    EditText nameOfPlanet;
    TextView resumeTextView;

    static RadioGroup[] questionsGroup = new RadioGroup[6];
    static CheckBox[] answerCheckBox = new CheckBox[5];

    RadioButton answer_1;
    RadioButton answer_2;
    RadioButton answer_3;
    RadioButton answer_4;
    RadioButton answer_5;
    RadioButton answer_6;
    CheckBox answer_7_b;
    CheckBox answer_7_d;
    CheckBox answer_7_e;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        resumeButton = findViewById(R.id.resume_button);
        resumeTextView = findViewById(R.id.resumeQuiz);


        //The list the correct answers.
        answer_1 = findViewById(R.id.answer_1_b);
        answer_2 = findViewById(R.id.answer_2_c);
        answer_3 = findViewById(R.id.answer_3_a);
        answer_4 = findViewById(R.id.answer_4_c);
        answer_5 = findViewById(R.id.answer_5_b);
        answer_6 = findViewById(R.id.answer_6_c);
        answer_7_b = findViewById(R.id.answer_7_b);
        answer_7_d = findViewById(R.id.answer_7_d);
        answer_7_e = findViewById(R.id.answer_7_e);


        questionsGroup[0] = findViewById(R.id.question_1_answers);
        questionsGroup[1] = findViewById(R.id.question_2_answers);
        questionsGroup[2] = findViewById(R.id.question_3_answers);
        questionsGroup[3] = findViewById(R.id.question_4_answers);
        questionsGroup[4] = findViewById(R.id.question_5_answers);
        questionsGroup[5] = findViewById(R.id.question_6_answers);
        answerCheckBox[0] =  findViewById(R.id.answer_7_a);
        answerCheckBox[1] =  findViewById(R.id.answer_7_b);
        answerCheckBox[2] =  findViewById(R.id.answer_7_c);
        answerCheckBox[3] =  findViewById(R.id.answer_7_d);
        answerCheckBox[4] =  findViewById(R.id.answer_7_e);


    }

    public void answerSummaryCorrect(int noOfQuestion){
        answerSummary += "\n Question " + noOfQuestion + " correct answer.";
    }

    public void answerSummaryIncorrect(int noOfQuestion){
        answerSummary += "\n Question " + noOfQuestion + " wrong answer.";
    }

    public void setAnswerSummaryCheckBox(int noOfQuestion, int positive){
        answerSummary += "\nQuestion " + noOfQuestion + ": " + positive + " of 3 correct answers";
    }

    public void setAnswerSummaryFinal(){
        nameOfPlanet = findViewById(R.id.edit_text);
        planetName = nameOfPlanet.getText().toString();
        String hello = "Welcome citizen of " + planetName;
        answerSummary = hello + "\nYour score " + points + "/" + MAX_POINTS + "\n" + answerSummary;
    }

    public void quizResume(View view){
        answerSummary = "";
        points = 0;
        quizCheck();
        resumeTextView.setText(answerSummary);
    }

    public void quizCheck(){
        int noOfQuestion = 1;

        //Question 1 check.
        boolean hasSelection = answer_1.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        // Question 2  check
        noOfQuestion = 2;
        hasSelection = answer_2.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        // Question 3  check
        noOfQuestion = 3;
        hasSelection = answer_3.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        // Question 4  check
        noOfQuestion = 4;
        hasSelection = answer_4.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        // Question 5  check
        noOfQuestion = 5;
        hasSelection = answer_5.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        // Question 6  check
        noOfQuestion = 6;
        hasSelection = answer_6.isChecked();
        if(hasSelection){
            addPointCorrect();
            answerSummaryCorrect(noOfQuestion);
        }else {
            answerSummaryIncorrect(noOfQuestion);
        }

        //Question 7 CheckBox check. one point for every correct check.
        noOfQuestion = 7;
        int positive_7 = 0;

        hasSelection = answer_7_b.isChecked();
        if(hasSelection){
            addPointCorrect();
            positive_7 += 1;
        }

        hasSelection = answer_7_d.isChecked();
        if(hasSelection) {
            addPointCorrect();
            positive_7 += 1;
        }

        hasSelection = answer_7_e.isChecked();
        if(hasSelection) {
            addPointCorrect();
            positive_7 += 1;
        }

        setAnswerSummaryCheckBox(noOfQuestion, positive_7);

        setAnswerSummaryFinal();
    }

    /**
     * This method increase number of points.
     *
     */
    public static void addPointCorrect(){
        points += 1;
    }

    /**
     * This method removes all answers.
     *
     */
    public void quizRestart(View view){

        for(int i =0; i<=5; i++){
            questionsGroup[i].clearCheck();
        }

        for(int j=0; j<=4; j++){
            if (answerCheckBox[j].isChecked()) {
                answerCheckBox[j].setChecked(false);
            }
        }
        points = 0;
        nameOfPlanet.setText(" ");
        answerSummary = "";
        resumeTextView.setText(answerSummary);

    }
}