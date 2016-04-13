package rpcs.jacob.ema.Intents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.AccountHomeActivity;
import rpcs.jacob.ema.Activity.SurveyActivity;

/**
 * Created by Jacobs on 4/4/2016.
 */
@SuppressLint("ParcelCreator")
public class LoadSurveyIntent extends Intent{
    public LoadSurveyIntent(AccountHomeActivity context) {
        super(context, SurveyActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
