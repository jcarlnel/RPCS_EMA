package rpcs.jacob.ema.Activity;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rpcs.jacob.ema.Entities.MyGlobal;
import rpcs.jacob.ema.Intents.LoadLoginIntent;
import rpcs.jacob.ema.R;
import rpcs.jacob.ema.Util.SignupTask;

/**
 * A page for user to signup a new account.
 * Views:
 *   Edit: username, password, cash
 *   Button: Signup, Login
 * xml: activity_signup.xml with R.id = typeSignupWidgetName
 * Page flow:
 *   click Signup: send a "signup" request to the backend (SignupTask), and would be redirected to the AccountHomeActivity
 *   click Login: goto the LoginActivity (LoadLoginIntent)
 */
public class SignupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // send a signup request for a new account, if success, goto home account page
        Button buttonSignup = (Button)findViewById(R.id.buttonSignupSubmit);
        buttonSignup.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            EditText editUsername = (EditText) findViewById(R.id.editSignupUsername);
                            MyGlobal.me.setName(editUsername.getText().toString());
                            EditText editPassword = (EditText) findViewById(R.id.editSignupPassword);
                            MyGlobal.me.setPassword(editPassword.getText().toString());
                            // TODO check email, confirm password, ...etc


                            new SignupTask(getApplicationContext()).execute();
                        } catch (Exception e) {
                            // TODO customized exception here
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        // go back to login page
        Button buttonLogin = (Button)findViewById(R.id.buttonSignupLogin);
        buttonLogin.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new LoadLoginIntent(SignupActivity.this));
                    }
                }
        );
    }
}

