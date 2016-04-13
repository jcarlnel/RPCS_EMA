package rpcs.jacob.ema.Util;

import android.content.Context;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.TreeMap;

import rpcs.jacob.ema.Entities.MyGlobal;
import rpcs.jacob.ema.Intents.AccountHomeIntent;

public class AccountHomeTask extends HttpRequestTask {
    private Context context;
    public AccountHomeTask(Context context) {
        this.context = context;
    }

    @Override
    protected String getUrl() {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("username", MyGlobal.me.getName());
        return getUrl("getuser", params);
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        try {
            if (json.get("result").equals("fail")) {
                Toast.makeText(context, json.get("reason").toString(), Toast.LENGTH_LONG).show();
                return;
            }
            // backup username
            String username = MyGlobal.me.getName();

            //MyGlobal.me = JsonToUser.transfer(json);
            MyGlobal.me.setName(username);

            // goto home account page
            context.startActivity(new AccountHomeIntent(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

