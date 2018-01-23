package com.exam.ravi.broadcast2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tob;
    BroadcastReceiver bcr;
    IntentFilter ift;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tob = (TextView) findViewById(R.id.tv1);
        bcr = new MyRecClass();
        ift = new IntentFilter(Intent.ACTION_TIME_TICK);
    }

    public void sendB(View v) {
        registerReceiver(bcr,ift);
    }

    public void stopB(View v) {
        unregisterReceiver(bcr);
    }

    class MyRecClass extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            int seconds = count*60;
            tob.setText("It's been "+seconds+"  seconds since start");
            count++;

        }
    }
}
