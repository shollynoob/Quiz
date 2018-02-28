package exabyte.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Quiz quiz = new Quiz();
    private TextView questionTextView;
    private  RadioGroup optionsRadioGroup;
    private int queNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question);
        optionsRadioGroup = findViewById(R.id.options);
    }

    int numberQuestion = quiz.numberOfQuestion();
    String [] answer = new String[numberQuestion];

    public void start(View v){
        LinearLayout layout = findViewById(R.id.buttonContainer);
        TextView instruction = findViewById(R.id.instruction);
        Button start =  findViewById(R.id.start);
        Button next =  findViewById(R.id.next);
        Button end =  findViewById(R.id.end);

        instruction.setVisibility(View.GONE);
        start.setVisibility(View.GONE);
        questionTextView.setVisibility(View.VISIBLE);
        optionsRadioGroup.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        end.setVisibility(View.VISIBLE);
        display();
        layout.setVisibility(View.VISIBLE);
    }

    private void display(){
        String question = quiz.getQuestion(queNumber);
        questionTextView.setText(question);

        String [] options = quiz.getOption(queNumber);
        optionsRadioGroup.removeAllViews();
        for(int i = 0; i<options.length; i++){
            RadioButton optionRadio = new RadioButton(this);
            optionRadio.setText(options[i]);
            optionRadio.setId(i);
            optionsRadioGroup.addView(optionRadio);
        }
    }

    public void end(View v){
        trackAnswer();
        quiz.checkScore(answer);
        int score = quiz.getCorrect();
        int missed = quiz.getMissed();
        Toast.makeText(this, "You Scored "+score+" and missed "+missed, Toast.LENGTH_LONG).show();
        Intent resultActivityIntent = new Intent(this, Result.class);
        resultActivityIntent.putExtra("score",score);
        resultActivityIntent.putExtra("missed", missed);
        startActivity(resultActivityIntent);
    }

    public void next(View v){
        trackAnswer();
        queNumber++;
        if(queNumber < numberQuestion){
            display();
        }
        else {
            end(v);
        }
    }

    private void trackAnswer(){
        if(queNumber < numberQuestion) {
            int answerSelectedId = optionsRadioGroup.getCheckedRadioButtonId();
            if(answerSelectedId!= -1) {
            RadioButton answerSelected = findViewById(answerSelectedId);
                answer[queNumber] = answerSelected.getText().toString();
            }
        }
    }

}
