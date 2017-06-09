package singlepageapp.mohanty.dinesh.com.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_5);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.answer_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    public void submitAnswer(View view) {
         score = 0;
        questionOneCheck();
        questionTwoCheck();
        questionThreeCheck();
        questionFourCheck();
        questionFiveCheck();
        String AnswerPhrase = getString(R.string.answer_phrase);
        TextView textView = (TextView) findViewById(R.id.score_board);

        String score = forHindiApp();
        textView.setText("" + AnswerPhrase + " " + score);
    }


    private void questionOneCheck() {
        TextView textView = (TextView) findViewById(R.id.q1_edit);
        String Answer = textView.getText().toString();
        if (Answer.equals("DELHI") || Answer.equals("Delhi") || Answer.equals("delhi") || Answer.equals("दिल्ली")) {
            score++;
        }
    }

    private void questionTwoCheck() {
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.id_q2o1);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.id_q2o2);
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.id_q2o3);
        CheckBox checkbox4 = (CheckBox) findViewById(R.id.id_q2o4);

        if (checkbox1.isChecked() && !checkbox2.isChecked() && checkbox3.isChecked() && !checkbox4.isChecked()) {
            score++;
        }


    }

    private void questionThreeCheck() {
        RadioButton radio =(RadioButton)findViewById(R.id.id_q3o2);
        if(radio.isChecked())
        {
            score++;
        }

    }
    private void questionFourCheck()
    {
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        if(toggle.isChecked())
        {
            score++;
        }
    }

    private  void questionFiveCheck(){

        Spinner spinner = (Spinner)findViewById(R.id.spinner_5);
        if(spinner.getSelectedItem().equals("11") || spinner.getSelectedItem().equals("११"))
        {
            score++;
        }

    }
    private String forHindiApp()
    {
        String scoreString = "";
        if(score == 1)
        {
            scoreString = getString(R.string.a1);
        }else if(score == 2)
        {
            scoreString = getString(R.string.a2);
        }else if(score == 3)
        {
            scoreString = getString(R.string.a3);
        }else if(score == 4)
        {
            scoreString = getString(R.string.a4);
        }else if(score == 5)
        {
            scoreString = getString(R.string.a5);
        }else if(score == 0)
        {
            scoreString = getString(R.string.a0);
        }
        return scoreString;
    }
    }

