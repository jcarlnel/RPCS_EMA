package rpcs.jacob.ema.Util;


import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import rpcs.jacob.ema.Activity.MoodSurveyActivity;
import rpcs.jacob.ema.Activity.NutritionSurveyActivity;
import rpcs.jacob.ema.Entities.MyGlobal;
import rpcs.jacob.ema.R;

/**
 * Created by jacobnelson on 4/20/16.
 */
public class NotificationReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if(System.currentTimeMillis() > 19 * 60 * 60 * 1000){
            if(MyGlobal.surveys == 1){
                MyGlobal.surveys = 2;
            }
            else{
                MyGlobal.surveys = 1;
            }
        }
        else{
            MyGlobal.surveys = 1;
        }



        showNotification(context);

    }

    private void showNotification(Context context) {

        PendingIntent contentIntent = null;
        if(MyGlobal.surveys == 1 && System.currentTimeMillis() > 19 * 60 * 60 * 1000) {
            contentIntent = PendingIntent.getActivity(context, 0,
                    new Intent(context, NutritionSurveyActivity.class), 0);
        }
        else{
          contentIntent = PendingIntent.getActivity(context, 0,
                    new Intent(context, MoodSurveyActivity.class), 0);
        }


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("It is time for a survey!")
                        .setContentText("Please tap this notification to complete your survey");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

        setAlarm(context);

    }

    private void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent();
        alarmIntent.setAction("NotificationReceiverActivity");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.setTimeInMillis(System.currentTimeMillis());

        if(System.currentTimeMillis() > 19 * 60 * 60 * 1000){
            alarmStartTime.add(Calendar.HOUR, 12);
        }
        else{
            alarmStartTime.add(Calendar.HOUR, 4);
        }

        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), pendingIntent);
        Toast.makeText(context, "Alarm Set", Toast.LENGTH_LONG).show();
    }
}
