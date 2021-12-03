package com.example.project11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Gallery Movie Poster");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);

    }
    public class MyGalleryAdapter extends BaseAdapter {
        Context context;

        Integer[] posterID = {
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov44, R.drawable.mov48, R.drawable.mov51, R.drawable.mov58, R.drawable.mov59,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov44, R.drawable.mov48, R.drawable.mov51, R.drawable.mov58, R.drawable.mov59,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov44, R.drawable.mov48, R.drawable.mov51, R.drawable.mov58, R.drawable.mov59
        };

        String[] posterName = {
                "Island", "Welcome to Dongmakgol", "Ajussi", "Avatar",
                "The Godfather", "Gladiator", "Sound of Music", "Leon", "Taken", "Brave Heart",
                "Island", "Welcome to Dongmakgol", "Ajussi", "Avatar",
                "The Godfather", "Gladiator", "Sound of Music", "Leon", "Taken", "Brave Heart",
                "Island", "Welcome to Dongmakgol", "Ajussi", "Avatar",
                "The Godfather", "Gladiator", "Sound of Music", "Leon", "Taken", "Brave Heart"
        };

        public MyGalleryAdapter(Context c){
            context=c;
        }


        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200,300));

            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
//                   setTitle(posterName[pos]);
//                   토스트 띄우기 , 비슷한게 2번 그리드에서 다이얼로그 띄우기
                    View view1 = View.inflate(context,R.layout.toast1,null);

                    Toast toast1 = new Toast(context);
//                    toast1.setText(posterName[pos]); 이렇게 하면 안됨!!

                    TextView tv1 = view1.findViewById(R.id.tv1);
                    tv1.setTextColor(Color.RED);
                    tv1.setTextSize(25);
                    tv1.setText(posterName[pos]);

                    toast1.setView(view1);
                    toast1.show();
                    return false;
                }
            });
            return imageview;
        }
    }

}