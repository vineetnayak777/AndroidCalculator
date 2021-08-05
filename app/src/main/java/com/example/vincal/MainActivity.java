package com.example.vincal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button mul;
    private Button div;
    private Button plus;
    private Button minus;
    private Button cancel;
    private Button dot;
    private Button equal;
    private EditText info;
    private TextView result;
    private final char ADDITION = '+';
    private final char MINUS = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private final char EQU = '=';
    private double val1 = Double.NaN;
    private double val2;
    private char Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+".");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = ADDITION;
                result.setText(String.valueOf(val1)+"+");
                info.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = MINUS;
                result.setText(String.valueOf(val1)+"-");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = DIV;
                result.setText(String.valueOf(val1)+"/");
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = MUL;
                result.setText(String.valueOf(val1)+"*");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = EQU;
                result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
                info.setText(null);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void setupUIViews(){
        one = (Button)findViewById(R.id.but1);
        two = (Button)findViewById(R.id.but2);
        three = (Button)findViewById(R.id.but3);
        four = (Button)findViewById(R.id.but4);
        five = (Button)findViewById(R.id.but5);
        six = (Button)findViewById(R.id.but6);
        seven = (Button)findViewById(R.id.but7);
        eight = (Button)findViewById(R.id.but8);
        nine = (Button)findViewById(R.id.but9);
        zero = (Button)findViewById(R.id.but0);
        cancel = (Button)findViewById(R.id.butc);
        plus = (Button)findViewById(R.id.butp);
        minus = (Button)findViewById(R.id.butmi);
        div = (Button)findViewById(R.id.butd);
        mul = (Button)findViewById(R.id.butm);
        dot = (Button)findViewById(R.id.butdo);
        equal = (Button)findViewById(R.id.buteq);
        info = (EditText)findViewById(R.id.textViewControl);
        result = (TextView)findViewById(R.id.textViewDisplay);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());
            if(Double.isNaN(val2)){
                val2 = Double.parseDouble(info.getText().toString());
            }
            switch (Action){
                case ADDITION:
                    val1 += val2;
                    break;
                case MINUS:
                    val1 -= val2;
                    break;
                case MUL:
                    val1 = val1*val2;
                    break;
                case DIV:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}