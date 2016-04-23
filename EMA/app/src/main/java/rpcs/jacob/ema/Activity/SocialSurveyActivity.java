package rpcs.jacob.ema.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import rpcs.jacob.ema.Entities.MyGlobal;
import rpcs.jacob.ema.Intents.AccountHomeIntent;
import rpcs.jacob.ema.Intents.NutritionSurveyIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.ListViewAdapter;
import rpcs.jacob.ema.Util.Model;

/**
 * Created by jacobnelson on 4/22/16.
 */
public class SocialSurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_survey);


        // go back to account home page
        Button buttonFinish = (Button) findViewById(R.id.buttonFinishSurvey);
        buttonFinish.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //TODO: send vals to database
                        //friends, family, visitors, left_house, unplanned_interactions

                        MyGlobal.surveys = 0;
                        startActivity(new AccountHomeIntent(SocialSurveyActivity.this));

                    }
                }
        );
    }
}
