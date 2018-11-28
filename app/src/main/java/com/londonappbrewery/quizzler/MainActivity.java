package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here

int qq=0;

    // TODO: Declare member variables here:
    Button truebutton,falsebutton;
    TextView questionview;
    int index;
    int question;
    TextView myscore;
    int my_score;
    ProgressBar myprogressbar;

   // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

   final int progress_increment = (int) Math.floor(100.0/(mQuestionBank.length-1));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        truebutton = findViewById(R.id.true_button);
        falsebutton = findViewById(R.id.false_button);
        questionview = findViewById(R.id.question_text_view);
        question = mQuestionBank[index].getQuestionid();
        questionview.setText(question);
        myscore = findViewById(R.id.score);
        myprogressbar = findViewById(R.id.progress_bar);

        truebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d("Quiz App","True Button Pressed!");
                //Toast newtoast = Toast.makeText(getApplicationContext(), "True Pressed", Toast.LENGTH_SHORT);
                //newtoast.show()
                checkanswer(true);
                updateQuestion();

            }
        });
        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Quizz App","False Button Pressed");
                //Toast.makeText(getApplicationContext(), "False Pressed", Toast.LENGTH_SHORT).show();
                checkanswer(false);
                updateQuestion();

            }
        });
    }
        private void updateQuestion(){
            index=(index+1)%mQuestionBank.length;
            qq++;
            question = mQuestionBank[index].getQuestionid();
            questionview.setText(question);
            myprogressbar.incrementProgressBy(progress_increment);
            if(qq==mQuestionBank.length-1)myprogressbar.setProgress(100);
            else if (qq==mQuestionBank.length){
                myprogressbar.setProgress(0);
                qq=0;
                //here
                setContentView(R.layout.done);
            }
            myscore.setText("Score "+my_score+"/"+mQuestionBank.length);
        }

        private void checkanswer(boolean userselection){

        boolean correctanswer = mQuestionBank[index].isAnswer();

        if(userselection == correctanswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            my_score = my_score+1;
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }

        }

}

