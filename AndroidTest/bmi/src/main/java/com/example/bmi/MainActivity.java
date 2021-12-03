package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String Gender = "";
    String bType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] items = {"A", "B", "O", "AB"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(arrayAdapter);


        EditText edtHeight = (EditText) findViewById(R.id.edtHegiht);
        EditText edtWeight = (EditText) findViewById(R.id.edtWegiht);

        RadioButton rd1 = (RadioButton) findViewById(R.id.rd1);
        RadioButton rd2 = (RadioButton) findViewById(R.id.rd2);

        CheckBox chk1 = (CheckBox) findViewById(R.id.chk1);
        CheckBox chk2 = (CheckBox) findViewById(R.id.chk2);
        CheckBox chk3 = (CheckBox) findViewById(R.id.chk3);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);

        Button btnCal = (Button) findViewById(R.id.btnCal);

        Gallery ga1 = (Gallery) findViewById(R.id.ga1);


        rd1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Gender ="여자";

            }
        });

        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender ="남자";

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bType = items[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bType = "A";
            }
        });

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> mThumbIds = new ArrayList<Integer>();

                if (rd1.isChecked()){
                    Gender ="여자";
                }

                if (edtHeight.getText().toString().equals("") || edtWeight.getText().toString().equals("")){

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("키와 체중")
                            .setView(getLayoutInflater().inflate(R.layout.custom_dialog,null))
                            .show();

                    return;
                }

                
                tv1.setText("1." + bType + "형 " + Gender + " 입니다!");

                String str1= edtHeight.getText().toString();
                String str2= edtWeight.getText().toString();
                int intH = Integer.parseInt(str1);
                int intW = Integer.parseInt(str2);
                
                tv2.setText("2.신체질량지수는 " +intW/((intH/100)^2)+" 입니다!");

                if (chk1.isChecked()){
                    mThumbIds.add(R.drawable.drinking);

                }

                if (chk2.isChecked()){
                    mThumbIds.add(R.drawable.ciga);

                }

                if (chk3.isChecked()){
                    mThumbIds.add(R.drawable.running);
                }

                if(chk1.isChecked() || chk2.isChecked() || chk3.isChecked()){
                    ga1.setAdapter(new ImageAdapter(MainActivity.this,mThumbIds));

                }
                else{
                    ga1.removeAllViewsInLayout();
                }
            }
        });
    }
}