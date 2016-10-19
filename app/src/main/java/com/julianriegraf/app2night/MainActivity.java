package com.julianriegraf.app2night;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mBottomBar = BottomBar.attach(this,savedInstanceState);
            mBottomBar.setItems(R.menu.menu_main);
            mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener()
            {
                @Override
                public void onMenuTabSelected(@IdRes int menuItemId)
                {
                    if(menuItemId == R.id.Bottombaritemone)
                    {
                        PartysFragment f = new PartysFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                    }
                    else if(menuItemId == R.id.Bottombaritemtwo)
                    {
                        LocationFragment f = new LocationFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                    }
                    else if(menuItemId == R.id.Bottombaritemthree)
                    {
                        AccountFragment f = new AccountFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                    }
                    else if(menuItemId == R.id.Bottombaritemfour)
                    {
                        SettingsFragment f = new SettingsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                    }
                    else if(menuItemId == R.id.Bottombaritemfive)
                    {
                        ContactFragment f = new ContactFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                    }
                }

                @Override
                public void onMenuTabReSelected(@IdRes int menuItemId) {

                }
            });

            mBottomBar.mapColorForTab(0, "#81d4fa");
            mBottomBar.mapColorForTab(1, "#ce93d8");
            mBottomBar.mapColorForTab(2, "#90caf9");
            mBottomBar.mapColorForTab(3, "#a5d6a7");
            mBottomBar.mapColorForTab(4, "#b0bec5");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}


