package rpcs.jacob.ema.Intents;

import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.PainSurveyActivity;

/**
 * Created by jacobnelson on 4/22/16.
 */
public class PainSurveyIntent extends Intent {
    public PainSurveyIntent(Context context) {
        super(context, PainSurveyActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
