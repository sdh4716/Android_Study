package com.example.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        //MainActivity에서 Intent에 실어 보낸것을 ResultActivity에서 받는다
        Intent intent = getIntent();
        int voteResult[] = intent.getIntArrayExtra("VoteCount");
        String imageName[] = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,
                R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,
                R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9,};

        Integer imageFileId[]={
                R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
                R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9
        };
        //voteArr[]안에서 최대 득표수 구하기
        int max = 0;
        int max_index=0;
        for(int i=0; i<voteResult.length; i++){
            if(voteResult[i]>max){
                max = voteResult[i];
                max_index = i;
            }
        }
        TextView tv1 = findViewById(R.id.tvMax);
        ImageView iv1 = findViewById(R.id.ivMax);

        tv1.setText(imageName[max_index]);
        iv1.setImageResource(imageFileId[max_index]);

        for (int i=0; i<voteResult.length; i++){//배열원소 초기화
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for (int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}