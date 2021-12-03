package com.example.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Grid View Movie Poster");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(MainActivity.this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
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

        Context context;

        // AppCompatActivity act1;

        // public MyGridAdapter(AppCompatActivity act1) {
        // this.
        //}

        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            // 데이터 갯수
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

        @Override //3번, 1칸의 디자인 만들기(커스텀 디자인)
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);
            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 여기서의 this는 MyGridAdapter, 그래서 activity를 불러오려면 MainActivity.this 사용
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.movie);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("Close",null);
                    dlg.show();
                }
            });

            return imageview;
        }

    }







}