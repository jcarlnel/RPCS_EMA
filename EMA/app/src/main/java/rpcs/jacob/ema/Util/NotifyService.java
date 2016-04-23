package rpcs.jacob.ema.Util;

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
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;

import rpcs.jacob.ema.Activity.AccountHomeActivity;
import rpcs.jacob.ema.Activity.SurveyActivity;
import rpcs.jacob.ema.R;


/**
 * Created by jacobnelson on 4/20/16.
 */
public class NotifyService extends Service{

    private NotificationManager myNotificationManager;
    private int numMessagesOne = 0;
    private int notificationId = 111;

    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override
    public void onCreate(){
        System.out.println("NotifyService onCreate");
        Toast.makeText(this, "NotifyService onCreate",Toast.LENGTH_LONG).show();


        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        displayNotification();
        /*
        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(), SurveyActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification mNotify = new Notification.Builder(this)
                .setContentTitle("Log Steps!")
                .setContentText("Log your steps for today")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .setSound(sound)
                .addAction(0, "Load Website", pIntent)
                .build();

        mNM.notify(1, mNotify);*/
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    protected void displayNotification() {

        // Invoking the default notification service
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("New Survey to Take");
        mBuilder.setContentText("Please go take your Mood and Pain survey");
        mBuilder.setTicker("Explicit: New Message Received!");
        mBuilder.setSmallIcon(R.drawable.ic_launcher);

        // Increase notification number every time a new notification arrives
        mBuilder.setNumber(++numMessagesOne);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, SurveyActivity.class);
        resultIntent.putExtra("notificationId", notificationId);

        //This ensures that navigating backward from the Activity leads out of the app to Home page
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent
        stackBuilder.addParentStack(SurveyActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_ONE_SHOT //can only be used once
                );
        // start the activity when the user clicks the notification text
        mBuilder.setContentIntent(resultPendingIntent);

        myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // pass the Notification object to the system
        myNotificationManager.notify(notificationId, mBuilder.build());
    }
}
