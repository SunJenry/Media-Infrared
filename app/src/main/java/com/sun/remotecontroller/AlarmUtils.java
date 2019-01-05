package com.sun.remotecontroller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

import java.util.Calendar;
import java.util.TimeZone;

import static android.content.Context.ALARM_SERVICE;

/**
 * @author sun on 2018/11/24.
 */
public class AlarmUtils {

    public static void setAlarm(Context context) {
        Intent intentAlarm = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(
                context, 0, intentAlarm, 0);

        long firstTime = SystemClock.elapsedRealtime();    //获取系统当前时间
        long systemTime = System.currentTimeMillis();//java.lang.System.currentTimeMillis()，它返回从 UTC 1970 年 1 月 1 日午夜开始经过的毫秒数。

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8")); //  这里时区需要设置一下，不然会有8个小时的时间差
        calendar.set(Calendar.HOUR_OF_DAY, 5);//设置为4：00点提醒
        calendar.set(Calendar.MINUTE, 35);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        //选择的定时时间
        long selectTime = calendar.getTimeInMillis();    //计算出设定的时间

        //  如果当前时间大于设置的时间，那么就从第二天的设定时间开始
        if (systemTime > selectTime) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            selectTime = calendar.getTimeInMillis();
        }

        long time = selectTime - systemTime;// 计算现在时间到设定时间的时间差
        long myTime = firstTime + time;//系统 当前的时间+时间差

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        // pendingIntent 为发送广播
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            assert alarmManager != null;
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    myTime, sender);
        } else {
            assert alarmManager != null;
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    myTime, sender);
        }

    }
}
