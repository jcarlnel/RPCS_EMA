package rpcs.jacob.ema.Intents;

import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.AccountHomeActivity;
import rpcs.jacob.ema.Activity.MoodSurveyActivity;
import rpcs.jacob.ema.Activity.SurveyActivity;

/**
 * Created by jacobnelson on 4/22/16.
 */
public class MoodSurveyIntent extends Intent {
    public MoodSurveyIntent(Context context) {
        super(context, MoodSurveyActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
