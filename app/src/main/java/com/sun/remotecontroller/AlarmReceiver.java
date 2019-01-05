package com.sun.remotecontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "hahahahahahahahahahahah");

        Toast.makeText(context, "hahahaa", Toast.LENGTH_SHORT).show();

        AlarmUtils.setAlarm(context);

        ControllerUtils.openWarm30(context);
    }
}
