package com.example.project14_2_broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project14_2.R;

public class MainActivity extends AppCompatActivity {

    ImageView ivBattery;
    EditText edtBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Battery Status");

        ivBattery = (ImageView) findViewById(R.id.ivBattery);
        edtBattery = (EditText) findViewById(R.id.edtBattery);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        //객체를 만들면서 사용한다.
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
//            Toast tmsg = Toast.makeText(MainActivity.this, "전원 연결 : None",Toast.LENGTH_SHORT);

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                edtBattery.setText("Battery Status :" + remain + " %\n");

                if (remain >=90) ivBattery.setImageResource(R.drawable.battery_100);
                else if (remain >= 70) ivBattery.setImageResource(R.drawable.battery_80);
                else if (remain >= 50) ivBattery.setImageResource(R.drawable.battery_60);
                else if (remain >= 10) ivBattery.setImageResource(R.drawable.battery_20);
                else ivBattery.setImageResource(R.drawable.battery_0);
            }
            int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
            switch (plug){
                case 0:
                    edtBattery.append("전원 연결 : None");
                    Toast.makeText(MainActivity.this, "전원 연결 : None",Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_PLUGGED_AC:
                    edtBattery.append("전원 연결 : Adaptor Connected");
                    Toast.makeText(MainActivity.this, "전원 연결 : Adaptor Connected",Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_PLUGGED_USB:
                    edtBattery.append("전원 연결 : USB Connected");
                    break;

            }
        }
    };

    // 다른 어플을 실행하는 등 작업이 중단되면 BroadcastReceiver를 unregister.
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }


    // br과 iFilter을 재등록
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter);
    }
}