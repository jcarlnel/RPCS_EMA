package rpcs.jacob.ema.Util;

/**
 * Created by jacobnelson on 4/13/16.
 */

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.TreeMap;

import rpcs.jacob.ema.Entities.MyGlobal;

public class WriteValTask extends HttpRequestTask {

    private Context context;
    private int val;

    public WriteValTask(Context context, int val) {
        this.context = context;
        this.val = val;
    }

    protected String getWebPage() {
        return "values";
    }

    @Override
    protected String getUrl() {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("sensor_id", "question");
        params.put("value", String.valueOf(val));
        return getUrl(getWebPage(), params);
    }

    @Override
    protected void onPostExecute(JSONObject json) {
       /* try {
            if (json.getString("result").equals("fail")) {
                Toast.makeText(context, json.get("reason").toString(), Toast.LENGTH_LONG).show();
                return;
            }
            new AccountHomeTask(context).execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        new AccountHomeTask(context).execute();
    }

}

