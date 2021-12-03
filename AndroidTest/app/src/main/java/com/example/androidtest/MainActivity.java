package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구구단 맞추기");

        EditText Nansu1 = (EditText) findViewById(R.id.Nansu1);
        EditText Nansu2 = (EditText) findViewById(R.id.Nansu2);
        EditText MyAnswer = (EditText) findViewById(R.id.MyAnswer);
        EditText AnswerEditText1 = (EditText) findViewById(R.id.AnswerEditText1);
        EditText AnswerEditText2 = (EditText) findViewById(R.id.AnswerEditText2);
        EditText AnswerEditText3 = (EditText) findViewById(R.id.AnswerEditText3);
        EditText AnswerEditText4 = (EditText) findViewById(R.id.AnswerEditText4);
        EditText AnswerEditText5 = (EditText) findViewById(R.id.AnswerEditText5);
        EditText AnswerEditText6 = (EditText) findViewById(R.id.AnswerEditText6);
        EditText AnswerEditText7 = (EditText) findViewById(R.id.AnswerEditText7);
        EditText AnswerEditText8 = (EditText) findViewById(R.id.AnswerEditText8);
        EditText AnswerEditText9 = (EditText) findViewById(R.id.AnswerEditText9);

        Button NansuGen = (Button) findViewById(R.id.NansuGen);
        Button AnswerChk = (Button) findViewById(R.id.AnswerChk);

        int rand1 = new Random().nextInt(8)+2;
        int rand2 = new Random().nextInt(8)+2;

        Toast CorrectToast = Toast.makeText(MainActivity.this,"정답입니다!",Toast.LENGTH_SHORT);
        Toast WrongToast = Toast.makeText(MainActivity.this,"오답입니다!",Toast.LENGTH_SHORT);



        NansuGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nansu1.getText().toString().equals("")){
                    Nansu1.setText(String.valueOf(rand1));
                    Nansu2.setText(String.valueOf(rand2));
                }
                else {
                    Nansu1.setText(null);
                    Nansu1.setText(String.valueOf(rand1));
                    Nansu2.setText(String.valueOf(rand2));

                }
            }
        });

        AnswerChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);

                if (Nansu1.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"난수를 먼저 생성하십시오!",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (MyAnswer.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"정답을 입력하십시오!",Toast.LENGTH_SHORT).show();
                    return;

                }
                String str0= MyAnswer.getText().toString();
                String str1= Nansu1.getText().toString();
                String str2= Nansu2.getText().toString();
                int n0 = Integer.parseInt(str0);
                int n1 = Integer.parseInt(str1);
                int n2 = Integer.parseInt(str2);



                if (n0 == n1*n2){
                    CorrectToast.show();
                    AnswerEditText1.setText(Nansu1.getText() + " x "  + "1 = " + n1*1 );
                    AnswerEditText2.setText(Nansu1.getText() + " x "  + "2 = " + n1*2 );
                    AnswerEditText3.setText(Nansu1.getText() + " x "  + "3 = " + n1*3 );
                    AnswerEditText4.setText(Nansu1.getText() + " x "  + "4 = " + n1*4 );
                    AnswerEditText5.setText(Nansu1.getText() + " x "  + "5 = " + n1*5 );
                    AnswerEditText6.setText(Nansu1.getText() + " x "  + "6 = " + n1*6 );
                    AnswerEditText7.setText(Nansu1.getText() + " x "  + "7 = " + n1*7 );
                    AnswerEditText8.setText(Nansu1.getText() + " x "  + "8 = " + n1*8 );
                    AnswerEditText9.setText(Nansu1.getText() + " x "  + "9 = " + n1*9 );
                }
                else{
                    WrongToast.show();
                    CorrectToast.show();
                    AnswerEditText1.setText(Nansu1.getText() + " x "  + "1 = " + n1*1 );
                    AnswerEditText2.setText(Nansu1.getText() + " x "  + "2 = " + n1*2 );
                    AnswerEditText3.setText(Nansu1.getText() + " x "  + "3 = " + n1*3 );
                    AnswerEditText4.setText(Nansu1.getText() + " x "  + "4 = " + n1*4 );
                    AnswerEditText5.setText(Nansu1.getText() + " x "  + "5 = " + n1*5 );
                    AnswerEditText6.setText(Nansu1.getText() + " x "  + "6 = " + n1*6 );
                    AnswerEditText7.setText(Nansu1.getText() + " x "  + "7 = " + n1*7 );
                    AnswerEditText8.setText(Nansu1.getText() + " x "  + "8 = " + n1*8 );
                    AnswerEditText9.setText(Nansu1.getText() + " x "  + "9 = " + n1*9 );
                }
            }
        });

    }
}