package rpcs.jacob.ema.Activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import rpcs.jacob.ema.Intents.AccountHomeIntent;
import rpcs.jacob.ema.Intents.PainSurveyIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.ListViewAdapter;
import rpcs.jacob.ema.Util.Model;
import rpcs.jacob.ema.Util.WriteValTask;

/**
 * Created by Philip on 4/20/16.
 */
public class MoodSurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_survey);
        ListView lv = (ListView) findViewById(R.id.moodListView);
        Model[] modelItems = new Model[16];
        modelItems[0] = new Model("Tired", 0);
        modelItems[1] = new Model("Energetic", 0);
        modelItems[2] = new Model("Happy", 0);
        modelItems[3] = new Model("Miserable", 0);
        modelItems[4] = new Model("Sad", 0);
        modelItems[5] = new Model("Content", 0);
        modelItems[6] = new Model("Tense", 0);
        modelItems[7] = new Model("Frustrated", 0);
        modelItems[8] = new Model("Angry", 0);
        modelItems[9] = new Model("Annoyed", 0);
        modelItems[10] = new Model("Bored", 0);
        modelItems[11] = new Model("Lonely", 0);
        modelItems[12] = new Model("Confused", 0);
        modelItems[13] = new Model("Hopeless", 0);
        modelItems[14] = new Model("Anxious", 0);
        modelItems[15] = new Model("Helpless", 0);
        ListViewAdapter adapter = new ListViewAdapter(this, modelItems);
        lv.setAdapter(adapter);

        // go back to account home page
        Button buttonFinish = (Button) findViewById(R.id.buttonFinishSurvey);
        buttonFinish.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int val = 0;
                        ListView lv = (ListView) findViewById(R.id.moodListView);
                        CheckBox cb;
                        for (int x = 0; x < lv.getChildCount();x++){
                            cb = (CheckBox)lv.getChildAt(x).findViewById(R.id.checkBox1);
                            if(cb.isChecked()){
                                val = val | 1;
                            }
                            val = val << 1;
                        }
                        new WriteValTask(getApplicationContext(), "moods", val).execute();
                        startActivity(new PainSurveyIntent(MoodSurveyActivity.this));
                    }
                }
        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
