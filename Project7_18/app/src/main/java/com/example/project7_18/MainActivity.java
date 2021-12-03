package com.example.project7_18;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        boolean[] checkArray = new boolean[] {true, false, false};

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                String versionArray[] = {"롤리팝","마시멜로","누가"};
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]);
//                    }
//                });
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                String str1  = "";
                                int cnt = 0;

                                for(int i=0; i<versionArray.length; ++i)
                                {
                                    if(checkArray[i])
                                    {
                                        if(cnt==0)
                                            str1 = versionArray[i];
                                        else
                                            str1 = str1 + "," + versionArray[i];
                                        cnt++;
                                    }
                                }

                                button1.setText(str1);
                            }
                        });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"확인누름!",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });
    }
}