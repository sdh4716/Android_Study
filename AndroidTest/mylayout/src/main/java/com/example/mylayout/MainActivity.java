package com.example.mylayout;

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
        setTitle("포토 일기장");

        GridView gv = (GridView) findViewById(R.id.grid1);
        MyGridAdapter gAdapter = new MyGridAdapter(MainActivity.this);
        gv.setAdapter(gAdapter);

    }
    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return photoID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        Integer[] photoID = {
                R.drawable.jeju7, R.drawable.jeju5, R.drawable.jeju6, R.drawable.jeju8, R.drawable.jeju9,
                R.drawable.jeju10, R.drawable.jeju11, R.drawable.jeju12, R.drawable.jeju13, R.drawable.jeju14,
                R.drawable.jeju7, R.drawable.jeju5, R.drawable.jeju6, R.drawable.jeju8, R.drawable.jeju9,
                R.drawable.jeju10, R.drawable.jeju11, R.drawable.jeju12, R.drawable.jeju13, R.drawable.jeju14,
                R.drawable.jeju7, R.drawable.jeju5, R.drawable.jeju6, R.drawable.jeju8, R.drawable.jeju9,
                R.drawable.jeju10, R.drawable.jeju11, R.drawable.jeju12, R.drawable.jeju13, R.drawable.jeju14
        };

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(300,300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(photoID[position]);

            return imageview;
        }
    }



}