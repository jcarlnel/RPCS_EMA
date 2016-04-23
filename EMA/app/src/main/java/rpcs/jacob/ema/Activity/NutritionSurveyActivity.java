package rpcs.jacob.ema.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import rpcs.jacob.ema.Intents.AccountHomeIntent;
import rpcs.jacob.ema.Intents.SocialSurveyIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.ListViewAdapter;
import rpcs.jacob.ema.Util.Model;
import rpcs.jacob.ema.Util.WriteValTask;

/**
 * Created by jacobnelson on 4/22/16.
 */
public class NutritionSurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_survey);


        // go back to account home page
        Button buttonFinish = (Button)findViewById(R.id.buttonFinishSurvey);
        buttonFinish.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Spinner nonwater = (Spinner)findViewById(R.id.nonwater);
                        Spinner water = (Spinner)findViewById(R.id.water);
                        Spinner snacks = (Spinner)findViewById(R.id.snacks);
                        Spinner meals = (Spinner)findViewById(R.id.meals);
                        int liquids = nonwater.getSelectedItemPosition() + water.getSelectedItemPosition();
                        int snack = snacks.getSelectedItemPosition();
                        int meal = meals.getSelectedItemPosition();
                        new WriteValTask(getApplicationContext(), "liquids", liquids).execute();
                        new WriteValTask(getApplicationContext(), "snacks", snack).execute();
                        new WriteValTask(getApplicationContext(), "meals", meal).execute();
                        startActivity(new SocialSurveyIntent(NutritionSurveyActivity.this));
                    }
                }
        );

    }
}
