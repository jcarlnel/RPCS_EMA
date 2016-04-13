package rpcs.jacob.ema.Intents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.AccountHomeActivity;

/**
 * Created by Jacobs on 4/3/2016.
 */
@SuppressLint("ParcelCreator")
public class AccountHomeIntent extends Intent {
    public AccountHomeIntent(Context context) {
        super(context, AccountHomeActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
