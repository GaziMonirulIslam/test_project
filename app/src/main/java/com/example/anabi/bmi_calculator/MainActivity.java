package com.example.anabi.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View view) {

        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {

            float heightValue = (float) (Float.parseFloat(heightStr)/3.28084);
            float weightValue = Float.parseFloat(weightStr);

            float bmi =  weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }


    }

    public void displayBMI(float bmi) {

        String bmiLabel = "";

        if (bmi < 18.5) {

            Toast.makeText(getApplicationContext(), bmi+" You are under weight", Toast.LENGTH_LONG).show();


        } else if ((bmi>=18.5)&&(bmi<=25)){

            Toast.makeText(getApplicationContext(), bmi+" You Have Optimal weight!", Toast.LENGTH_LONG).show();

        }

        else {

            Toast.makeText(getApplicationContext(), bmi+" You are over weight", Toast.LENGTH_LONG).show();
        }

        bmiLabel = bmi +"\n\n"+bmiLabel;
        result.setText("BMI: "+bmiLabel);
    }
}
