package rpcs.jacob.ema.Intents;

import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.SocialSurveyActivity;


/**
 * Created by jacobnelson on 4/23/16.
 */
public class SocialSurveyIntent extends Intent{
    public SocialSurveyIntent(Context context) {
        super(context, SocialSurveyActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
