package rpcs.jacob.ema.Activity;

/**
 * Created by Jacobs on 4/3/2016.
 */

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rpcs.jacob.ema.Entities.*;
//import rpcs.jacob.ema.Fragment.*;
import rpcs.jacob.ema.Intents.LoadSurveyIntent;
import rpcs.jacob.ema.R;

/**
 * The main home page to summary the user's portfolio.
 * Views:
 *   Fragments: SearchFriendFragment, SummaryFragment, StockListFragment, SearchStockFragment
 * xml: activity_account_home.xml
 * Page flow:
 *   from LoginActivity (click Signin => LoginTask => AccountHomeTask => AccountHomeIntent => this)
 *   from SignupActivity (click Signup => SignupTask => AccountHomeTask => AccountHomeIntent => this)
 *   from SellCoverActivity/BuyShortActivity (click Cancel => AccountHomeTask => AccountHomeIntent => this)
 *   from SellCoverActivity (click Sell/Cover => Sell/CoverStockTask => AccountHomeIntent => this)
 *   from BuyShortActivity (click Buy/Short => Buy/ShortStockTask => AccountHomeIntent => this)
 *   click Search in SearchFriendFragment => send a "getotheruser" request (VisitFriendTask), and would be redirected to FriendHomeActivity.
 *   click an item in StockListFragment => send a "loadsell/cover" request (LoadSell/CoverTask), and would be redirected to SellCoverActivity.
 *   click Buy in SearchStockFragment => send a "loadbuy" request (LoadBuyTask), and would be redirected to BuyShortActivity.
 *   click Short in SearchStockFragment => send a "loadshort" request (LoadShortTask), and would be redirected to BuyShortActivity.
 */
public class AccountHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_home);
        TextView welcome = (TextView)findViewById(R.id.welcomeText);
        welcome.setText("Welcome " + MyGlobal.me.getName());


        //Open up a survey to take
        Button buttonLogin = (Button)findViewById(R.id.surveyButton);
        buttonLogin.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new LoadSurveyIntent(AccountHomeActivity.this));
                    }
                }
        );
       //FragmentManager manager = getSupportFragmentManager();
        //Fragment searchFriendFragment = SearchFriendFragment.newInstance();
        //Fragment summaryFragment = SummaryFragment.newInstance(MyGlobal.me.getName(), MyGlobal.me.getCash());
        //Fragment searchStockFragment = SearchStockFragment.newInstance();
        boolean readOnly = false;
        //Fragment stockListFragment = StockListFragment.getNewInstance(MyGlobal.me.getPortfolio().getAllStocks(), readOnly);
        /*manager.beginTransaction()
                .add(R.id.fragmentSearchFriend, searchFriendFragment)
                .add(R.id.fragmentSummary, summaryFragment)
                .add(R.id.fragmentStockList, stockListFragment)
                .add(R.id.fragmentSearchStock, searchStockFragment)
                .commit();*/
    }
}
