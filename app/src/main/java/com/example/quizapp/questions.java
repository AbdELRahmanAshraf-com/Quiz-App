package com.example.quizapp;

import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

class questions {
    //submit function
    int submit(ArrayList<String> answers) {
        int score = 0;
        for (String i : answers) {
            score += Integer.valueOf(i);
        }
        return score;
    }

    String q1(String ans, String uAnswer) {
        if (ans.equals(uAnswer)) {
            return "1";
        } else {
            return "0";
        }
    }

    String q2(String ans, String uAnswer) {
        if (ans.equals(uAnswer)) {
            return "1";
        } else {
            return "0";
        }
    }

    String q3(RadioButton ans, RadioGroup rdg) {
        int selectedId = rdg.getCheckedRadioButtonId();
        if (selectedId == ans.getId()) {
            return "1";
        } else {
            return "0";
        }

    }

    String q4(CheckBox ch1, CheckBox ch3, CheckBox ch2, CheckBox ch4) {
        if (ch1.isChecked() && ch3.isChecked() && !ch2.isChecked() && !ch4.isChecked()) {
            return "1";
        } else {
            return "0";
        }
    }


}
