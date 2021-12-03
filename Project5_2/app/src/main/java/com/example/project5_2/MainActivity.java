package com.example.project5_2;

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
        setContentView(R.layout.activity_main_table); //setContentView를 자기가 출력하고 싶은 layout으로 설정


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

        //숫자버튼 추가
//        Button btn0 = findViewById(R.id.BtnNum0);
//        Button btn1 = findViewById(R.id.BtnNum1);
//        Button btn2 = findViewById(R.id.BtnNum2);
//        Button btn3 = findViewById(R.id.BtnNum3);
//        Button btn4 = findViewById(R.id.BtnNum4);
//        Button btn5 = findViewById(R.id.BtnNum5);
//        Button btn6 = findViewById(R.id.BtnNum6);
//        Button btn7 = findViewById(R.id.BtnNum7);
//        Button btn8 = findViewById(R.id.BtnNum8);
//        Button btn9 = findViewById(R.id.BtnNum9);

        int btnIdArr[] = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                          R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                          R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8,
                          R.id.BtnNum9};

        Button btnArr[] = new Button[btnIdArr.length];//객체배열
        for(int i=0; i<btnIdArr.length; ++i)
        {
//            btnArr[i] = findViewById(R.id.BtnNum0);
//            btnArr[i] = findViewById(R.id.BtnNum+i)
            btnArr[i] = findViewById(btnIdArr[i]);
        }


        for(int i=0; i<btnArr.length; ++i)
        {
            int final_I = i;
//            btn1.setOnClickListener(new View.OnClickListener() {
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                        edit1.setText(edit1.getText().toString() + final_I);
                    } else if (edit2.isFocused())//포커스가 edt2에 있을때
                    {
                        edit2.setText(edit2.getText().toString() + final_I);
                    }
                }
            });
        }

//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"0");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"0");
//                }
//            }
//        });


//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"1");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"1");
//                }
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"2");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"2");
//                }
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"3");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"3");
//                }
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"4");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"4");
//                }
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"5");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"5");
//                }
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"6");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"6");
//                }
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"7");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"7");
//                }
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"8");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"8");
//                }
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())
//                {
//                    edt1.setText(edt1.getText().toString()+"9");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"9");
//                }
//            }
//        });
    }
}