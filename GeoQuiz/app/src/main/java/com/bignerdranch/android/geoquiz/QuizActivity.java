package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;

    private TextView mQuestionTextView;

    private Question [] mQuestionBank = new Question[] {
        new Question(R.string.question_oceans,true),
        new Question(R.string.question_mideast,false),
        new Question(R.string.question_africa,false),
        new Question(R.string.question_americas,true),
        new Question(R.string.question_asia,true),
    };

    private int mCurrentIndex = 0;

    private void updateQuestion () {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue)
        {
            messageResId = R.string.correct_toast;
        }
        else
        {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId,Toast.LENGTH_SHORT).show();
    }

    //toast check
    private void printTrue (){
        Toast.makeText(this, R.string.true_button,Toast.LENGTH_SHORT).show();
    }
    private void printFalse () {
        Toast.makeText(this, R.string.false_button,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //true button
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick (View v) {

              checkAnswer(true);
            //  printTrue();
          }
        });

        //false button
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                checkAnswer(false);
             //   printFalse();
            }
        });

        //prev button
    /*    mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {

                if (mCurrentIndex==0)
                {
                    mCurrentIndex = mQuestionBank.length-1;
                }
                else
                {
                    mCurrentIndex = (mCurrentIndex-1)% mQuestionBank.length;
                }
                updateQuestion();
            }
        }); */

        //next button
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {

                if (mCurrentIndex==mQuestionBank.length-1)
                {
                    mCurrentIndex = 0;
                }

                else
                {
                    mCurrentIndex = (mCurrentIndex+1)% mQuestionBank.length;
                }
                updateQuestion();
            }
        });

        updateQuestion();
    }

    //Overriding more lifecycle methods
    private static final String TAG = "QuizActivity";

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
