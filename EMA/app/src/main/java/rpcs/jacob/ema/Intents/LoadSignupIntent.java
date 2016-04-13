package rpcs.jacob.ema.Intents;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.SignupActivity;

public class LoadSignupIntent extends Intent {
    public LoadSignupIntent(Context context) {
        super(context, SignupActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

}