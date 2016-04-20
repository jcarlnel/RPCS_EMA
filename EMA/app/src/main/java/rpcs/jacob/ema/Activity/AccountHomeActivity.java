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
import android.os.Build;
import android.os.Bundle;


import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import rpcs.jacob.ema.Entities.*;
//import rpcs.jacob.ema.Fragment.*;
import rpcs.jacob.ema.Intents.LoadSurveyIntent;
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
        setContentView(R.layout.activity_account_home);
        TextView welcome = (TextView)findViewById(R.id.welcomeText);
        welcome.setText("Welcome " + MyGlobal.me.getName());
        NotificationReceiver.setupAlarm(getApplicationContext());

        //Open up a survey to take
        Button buttonLogin = (Button)findViewById(R.id.surveyButton);
        buttonLogin.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new LoadSurveyIntent(AccountHomeActivity.this));
                    }
                }
        );

    }

    public void setAlarm(){
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmIntent = new Intent(AccountHomeActivity.this, NotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AccountHomeActivity.this, 0, alarmIntent, 0);

        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 15);
        alarmStartTime.set(Calendar.MINUTE, 19);
        alarmStartTime.set(Calendar.SECOND, 0);
        alarmManager.setRepeating(AlarmManager.RTC, alarmStartTime.getTimeInMillis(), getInterval(), pendingIntent);
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
