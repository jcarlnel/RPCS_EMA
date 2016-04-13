package rpcs.jacob.ema.Intents;

/**
 * Created by Jacobs on 4/3/2016.
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.LoginActivity;
import rpcs.jacob.ema.Activity.SignupActivity;

/**
 * A Intent to LoginActivity page.
 * Page flow:
 *   from SignupActivity.
 */
@SuppressLint("ParcelCreator")
public class LoadLoginIntent extends Intent {
    public LoadLoginIntent(SignupActivity context) {
        super(context, LoginActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

}
