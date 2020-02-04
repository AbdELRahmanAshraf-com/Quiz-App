package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int next = 0;
    ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // question array
        final Integer[] q = {R.id.q1, R.id.q2, R.id.q3, R.id.q4};
        String[] s = {"0", "0", "0", "0"};
        answers.addAll(Arrays.asList(s));


        //Variables
        final questions qus = new questions();
        final EditText etQ1 = findViewById(R.id.etq1);
        final EditText etQ2 = findViewById(R.id.etq2);
        final RadioButton ans = findViewById(R.id.ans);
        final RadioGroup rdg = findViewById(R.id.rdg);
        final CheckBox ch1 = findViewById(R.id.chk1);
        final CheckBox ch3 = findViewById(R.id.chk3);
        final CheckBox ch2 = findViewById(R.id.chk2);
        final CheckBox ch4 = findViewById(R.id.chk4);

        // next button function
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                // Take answers from user
                switch (next - 1) {
                    case 0:
                        answers.set(next - 1, qus.q1(getResources().getString(R.string.question_one_ans), etQ1.getText().toString()));
                        break;
                    case 1:
                        answers.set(next - 1, qus.q2(getResources().getString(R.string.question_two_ans), etQ2.getText().toString()));
                        break;
                    case 2:
                        answers.set(next - 1, qus.q3(ans, rdg));
                        break;
                    case 3:
                        answers.set(next - 1, qus.q4(ch1, ch3, ch2, ch4));
                        break;
                }

                if (next >= q.length) {
                    Toast.makeText(getApplicationContext(), String.valueOf(qus.submit(answers)), Toast.LENGTH_LONG).show();
                    next = q.length - 1;
                }

                //change the shown question
                findViewById(q[next]).setVisibility(View.VISIBLE);
                findViewById(q[next - 1]).setVisibility(View.GONE);
                findViewById(R.id.btn_back).setVisibility(View.VISIBLE);

                //change next button to submit
                if (next == q.length - 1) {
                    Button btn_next = findViewById(R.id.btn_next);
                    btn_next.setText(R.string.submit);
                }
            }
        });


        // back button function
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (next >= q.length) {
                    next = q.length - 1;
                }
                next--;
                //change the shown question
                findViewById(q[next]).setVisibility(View.VISIBLE);
                findViewById(q[next + 1]).setVisibility(View.GONE);
                if (next == 0) {
                    findViewById(R.id.btn_back).setVisibility(View.INVISIBLE);
                }
                //findViewById(R.id.btn_next).setVisibility(View.VISIBLE);
                Button btn_next = findViewById(R.id.btn_next);
                btn_next.setText(R.string.submit);
            }
        });
    }
}
