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

import rpcs.jacob.ema.Entities.MyGlobal;
import rpcs.jacob.ema.Intents.AccountHomeIntent;
import rpcs.jacob.ema.Intents.NutritionSurveyIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.ListViewAdapter;
import rpcs.jacob.ema.Util.Model;
import rpcs.jacob.ema.Util.WriteValTask;

/**
 * Created by Philip on 4/20/16.
 */
public class PainSurveyActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_survey);
        ListView lv = (ListView) findViewById(R.id.painListView);
        Model[] modelItems = new Model[17];
        modelItems[0] = new Model("Head", 0);
        modelItems[1] = new Model("Neck & Shoulders", 0);
        modelItems[2] = new Model("Arms", 0);
        modelItems[3] = new Model("Hands", 0);
        modelItems[4] = new Model("Chest", 0);
        modelItems[5] = new Model("Upper Abdomen", 0);
        modelItems[6] = new Model("Lower Abdomen", 0);
        modelItems[7] = new Model("Upper Back", 0);
        modelItems[8] = new Model("Lower Back", 0);
        modelItems[9] = new Model("Buttocks", 0);
        modelItems[10] = new Model("Hip", 0);
        modelItems[11] = new Model("Knee", 0);
        modelItems[12] = new Model("Groin", 0);
        modelItems[13] = new Model("Front Thigh", 0);
        modelItems[14] = new Model("Back Thigh", 0);
        modelItems[15] = new Model("Lower Leg", 0);
        modelItems[16] = new Model("Feet", 0);
        ListViewAdapter adapter = new ListViewAdapter(this, modelItems);
        lv.setAdapter(adapter);

        // go back to account home page
        Button buttonFinish = (Button) findViewById(R.id.buttonFinishSurvey);
        if(MyGlobal.surveys == 2){
                buttonFinish.setText("Continue");
        }
        buttonFinish.setOnClickListener(
        new Button.OnClickListener() {
public void onClick(View v) {
                int val = 0;
                ListView lv = (ListView) findViewById(R.id.painListView);
                CheckBox cb;
                for (int x = 0; x < lv.getChildCount();x++){
                        cb = (CheckBox)lv.getChildAt(x).findViewById(R.id.checkBox1);
                        if(cb.isChecked()){
                                val = val | 1;
                        }
                        val = val << 1;
                }
                new WriteValTask(getApplicationContext(), "pains", val).execute();
                if(MyGlobal.surveys == 1){
                        MyGlobal.surveys = 0;
                        startActivity(new AccountHomeIntent(PainSurveyActivity.this));
                }
                else{
                        startActivity(new NutritionSurveyIntent(PainSurveyActivity.this));
                }
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