package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1. java 객체를 만든다
    EditText edit1, edit2; //멤버변수
    Button btnAdd, btnSub, btnMul, btnDiv, btn5;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //setContentView를 자기가 출력하고 싶은 layout으로 설정


        //4-2. 리스너를 자바 객체에 등록한다.(리스너 객체 사용)

        setTitle("초간단 계산기");
        //2. xml객체를 java객체에 연결한다(바인딩)
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btn5 = (Button) findViewById(R.id.Btn5);

        textResult = (TextView) findViewById(R.id.TextResult);

        //3. java 객체에 효과(메소드나 멤버변수 사용)를 준다
        //4. java 객체에 이벤트 처리를 한다.
        //4-1. 이벤트 리스너 객체를 만든다.

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= edit1.getText().toString();
                String str2= edit2.getText().toString();
                if(str1.equals("")||str2.equals("")){
                    Toast.makeText(MainActivity.this,
                            "값을 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }else{
                    int n1 = Integer.parseInt(str1);
                    int n2 = Integer.parseInt(str2);

                    int result = n1+n2;
                    textResult.setText("계산결과:"+result);
                }

            }


        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= edit1.getText().toString();
                String str2= edit2.getText().toString();

                if(str1.equals("")||str2.equals("")){
                    Toast.makeText(MainActivity.this,
                            "값을 입력하세요",
                    Toast.LENGTH_LONG).show();
                }else{
                    int n1 = Integer.parseInt(str1);
                    int n2 = Integer.parseInt(str2);
                    int result = n1-n2;
                    textResult.setText("계산결과:"+result);
                }

            }


        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= edit1.getText().toString();
                String str2= edit2.getText().toString();

                if (str1.equals("") || str2.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "값을 입력하이소",
                            Toast.LENGTH_SHORT).show();
                }else{
                    int n1 = Integer.parseInt(str1);
                    int n2 = Integer.parseInt(str2);

                    int result = n1*n2;
                    textResult.setText("계산결과:"+result);
                }


            }


        });

        //return은 OnTouch에 필요
        //OnClick은 return이 필요하지 않음 * 차이점 *

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= edit1.getText().toString();
                String str2= edit2.getText().toString();

                if(str1.equals("")|| str2.equals("")){
                    Toast.makeText(MainActivity.this,
                            "값을 입력하이소,",
                                    Toast.LENGTH_SHORT).show();
                }else{
                    if(str2.equals("0")){
                        Toast.makeText(MainActivity.this,
                                "0으로 나눌수 없소",
                                Toast.LENGTH_SHORT).show();
                    }
                else {
                        double n1 = Double.parseDouble(str1);
                        double n2 = Double.parseDouble(str2);
                        double result = n1 / n2;
                        result = (int) (result * 100) / 100.0;

                        textResult.setText("계산결과:" + result);
                    }
                }

            }


        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= edit1.getText().toString();
                String str2= edit2.getText().toString();

                //editText에 값이 없을때, 토스트
                if(str1.equals("")||str2.equals("")){
                    Toast.makeText(MainActivity.this,
                            "값을 입력해주세요",
                            Toast.LENGTH_SHORT).show();
                }
                else{ //정상일때
                    double n1 = Double.parseDouble(str1);
                    double n2 = Double.parseDouble(str2);
                    double result = n1%n2;
//                tv1.setText(String.valueOf(result));
                    textResult.setText("계산결과:"+result);
                }


            }


        });
    }
}