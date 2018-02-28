package exabyte.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private TextView tscore, tmissed;
    private Quiz quiz = new Quiz();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

         tscore = findViewById(R.id.score);
         tmissed = findViewById(R.id.missed);

        Intent receiver = getIntent();
        int mscore = receiver.getIntExtra("score", 0);
        int mmissed = receiver.getIntExtra("missed", 0);

        if(mscore == quiz.numberOfQuestion()){
            tscore.setText("You Scored " + mscore);
            tscore.append("\n\n Excellent Perfomance Keep it up!");
        }else if(mscore < quiz.numberOfQuestion()) {
            tscore.setText("You Scored " + mscore);
            tscore.append("\n\n Try Harder on you next Attempt");
            tmissed.setText("You Missed " + mmissed);
        }
    }
}
