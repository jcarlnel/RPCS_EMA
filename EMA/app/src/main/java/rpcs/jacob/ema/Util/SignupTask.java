package rpcs.jacob.ema.Util;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.TreeMap;

import rpcs.jacob.ema.Entities.MyGlobal;

/**
 * Created by Jacobs on 4/3/2016.
 */
public class SignupTask extends HttpRequestTask {
    private Context context;
    public SignupTask(Context context) {
        this.context = context;
    }

    @Override
    protected String getUrl() {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("username", MyGlobal.me.getName());
        params.put("password", MyGlobal.me.getPassword());
        return getUrl("signup", params);
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        try {
            if (json.getString("result").equals("fail")) {
                Toast.makeText(context, json.get("reason").toString(), Toast.LENGTH_LONG).show();
                return;
            }
            new AccountHomeTask(context).execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

