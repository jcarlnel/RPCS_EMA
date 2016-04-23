package rpcs.jacob.ema.Activity;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;


import android.preference.PreferenceManager;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import rpcs.jacob.ema.Entities.*;
//import rpcs.jacob.ema.Fragment.*;
import rpcs.jacob.ema.Intents.LoadSurveyIntent;
import rpcs.jacob.ema.Intents.MoodSurveyIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.NotificationReceiver;
import rpcs.jacob.ema.Util.NotifyService;


public class AccountHomeActivity extends Activity {
    private int numMessagesOne = 0;
    private int notificationId = 111;
    private NotificationManager myNotificationManager;
    private AlarmManager alarmManager;
    private Intent alarmIntent;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
            // Code to run once
            setAlarm();
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }

        if(MyGlobal.surveys == 0){
            setContentView(R.layout.account_home_none_pending);
            TextView welcome = (TextView)findViewById(R.id.welcomeText);
            welcome.setText("Welcome " + MyGlobal.me.getName());
        }

        else if(MyGlobal.surveys == 1 || MyGlobal.surveys == 2){
            setContentView(R.layout.activity_account_home);
            TextView welcome = (TextView)findViewById(R.id.welcomeText);
            welcome.setText("Welcome " + MyGlobal.me.getName());
            //Open up a survey to take
            Button buttonLogin = (Button)findViewById(R.id.surveyButton);
            buttonLogin.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            startActivity(new MoodSurveyIntent(AccountHomeActivity.this));
                        }
                    }
            );
        }



    }

    public void setAlarm(){
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmIntent = new Intent();
        alarmIntent.setAction("NotificationReceiverActivity");
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.setTimeInMillis(System.currentTimeMillis());
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 12);
        alarmStartTime.set(Calendar.MINUTE, 0);
        alarmStartTime.set(Calendar.SECOND, 0);
        System.out.println("Set:" + alarmStartTime.getTimeInMillis());
        System.out.println("Cur:" + System.currentTimeMillis());
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_LONG).show();
    }
    private int getInterval(){
        int days = 1;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;
        int milliseconds = 1000;
        int repeatMS = days * hours * minutes * seconds * milliseconds;
        return repeatMS;
    }


}
