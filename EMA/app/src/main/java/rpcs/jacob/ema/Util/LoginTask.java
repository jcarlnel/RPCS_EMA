package rpcs.jacob.ema.Util;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.TreeMap;

import rpcs.jacob.ema.Entities.MyGlobal;


/**
 * Created by rueiminl on 2015/11/26.
 * A task to get the response of the request "login". Would be redirected to the AccountHomeActivity.
 */
public class LoginTask extends HttpRequestTask {
    private Context context;
    public LoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected String getUrl() {
        TreeMap<String, String> params = new TreeMap<String, String>();
        //params.put("username", MyGlobal.me.getName());
        //params.put("password", MyGlobal.me.getPassword());
        return getUrl("values", params);
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        new AccountHomeTask(context).execute();
    }
}
