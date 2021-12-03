package com.example.project5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        //1.레이아웃의 초기 옵션값을 정한다.
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        //2.레이아웃을 만든다. only java 코드로 => 유의사항은 activity를 지정(=this)
        LinearLayout baseLayout = new LinearLayout(this);
        //3.레이아웃의 또 옵션값을 정한다.
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0,255,0));

        //4.만들어진 레이아웃을 콘텐트뷰에 꽂는다
        //setContentView(레이아웃, 레이아웃 초기옵션);
        setContentView(baseLayout,params);

        //문제: 에디트텍스트 추가
        EditText edt1 = new EditText(this);
        edt1.setHint("입력바람!");
        edt1.setTextSize(30);
        edt1.setBackgroundColor(Color.YELLOW);

        baseLayout.addView(edt1);


        //두번째 view, cf)레이아웃이 아님
        //1.view(예:버튼) 객체를 만든다. only java코드로, 유의사항:액티비티 소속 설정 ->this
        //2.view(예:버튼) 객체의 옵션값을 정한다.
        //3. 중요: view(예:버튼) 객체를 레이아웃에 꽂는다.
        //4. view(예:버튼) 객체의 이벤트 처리를 한다.


        
        //1.view(예:버튼) 객체를 만든다. only java코드로, 유의사항:액티비티 소속 설정 ->this
        Button btn1 = new Button(this);

        //2.view(예:버튼) 객체의 옵션값을 정한다.
        btn1.setText("버튼입니다");
        btn1.setTextSize(30);
        btn1.setBackgroundColor(Color.CYAN);
        //3. 중요: view(예:버튼) 객체를 레이아웃에 꽂는다.
        baseLayout.addView(btn1);

        //문제: 텍스트뷰 추가
        TextView tv1 = new TextView(this);
        tv1. setText("결과값 출력");
        tv1. setTextSize(30);
        tv1. setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(tv1);

        //4.view(예:버튼) 객체의 이벤트 처리를 한다.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                tv1.setText(str1);
            }
        });
    }


}