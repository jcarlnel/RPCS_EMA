package rpcs.jacob.ema.Intents;

import android.content.Context;
import android.content.Intent;

import rpcs.jacob.ema.Activity.NutritionSurveyActivity;

/**
 * Created by jacobnelson on 4/23/16.
 */
public class NutritionSurveyIntent extends  Intent{
    public NutritionSurveyIntent(Context context) {
        super(context, NutritionSurveyActivity.class);
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
