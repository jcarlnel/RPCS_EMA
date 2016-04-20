package rpcs.jacob.ema.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import rpcs.jacob.ema.Intents.AccountHomeIntent;
import rpcs.jacob.ema.Intents.LoadLoginIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.ListViewAdapter;
import rpcs.jacob.ema.Util.Model;
import rpcs.jacob.ema.Util.WriteValTask;

/**
 * Created by Jacobs on 4/4/2016.
 */
public class SurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        ListView lv = (ListView) findViewById(R.id.listView1);
        Model[] modelItems = new Model[5];
        modelItems[0] = new Model("Lonely", 0);
        modelItems[1] = new Model("Energetic", 0);
        modelItems[2] = new Model("Happy", 0);
        modelItems[3] = new Model("Helpless", 0);
        modelItems[4] = new Model("Hopeless", 0);
        ListViewAdapter adapter = new ListViewAdapter(this, modelItems);
        lv.setAdapter(adapter);

        // go back to account home page
        Button buttonFinish = (Button)findViewById(R.id.buttonFinishSurvey);
        buttonFinish.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        SeekBar sb = (SeekBar)findViewById(R.id.seekBarSleep);
                        int val = sb.getProgress();
                        new WriteValTask(getApplicationContext(), val).execute();
                        startActivity(new AccountHomeIntent(SurveyActivity.this));
                    }
                }
        );

        SeekBar seek = (SeekBar)findViewById(R.id.seekBarSleep);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tv = (TextView)findViewById(R.id.seekNum);
                int val = progress + 1;
                tv.setText(String.valueOf(val));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
