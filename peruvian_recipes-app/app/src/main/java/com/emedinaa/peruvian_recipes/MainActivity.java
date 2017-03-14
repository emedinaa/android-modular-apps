package com.emedinaa.peruvian_recipes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emedinaa.peruvian_recipes.common.Navigation;
import com.emedinaa.peruvian_recipes.data.helpers.GsonHelper;
import com.emedinaa.peruvian_recipes.data.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.peruvian_recipes.data.storage.SharedPreferencesHelper;
import com.emedinaa.peruvian_recipes.data.storage.UserSessionLocalInteractor;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements UserSessionContract.View {

    private static final String SPREFERENCES = "com.emedinaa.peruvian_recipes.session";
    private final int SPLASH_TIME=1500;
    private Timer timer;
    private UserSessionPresenter userSessionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences= getSharedPreferences(SPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferencesHelper preferencesHelper= new DefaultSharedPreferencesHelper(
                new GsonHelper(),sharedPreferences );
        setPresenter(new UserSessionPresenter(this, new UserSessionLocalInteractor(preferencesHelper)));

        app();
    }

    private void app() {
        timer= new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                validateSession();
            }
        };

        timer.schedule(task, SPLASH_TIME);
    }

    private void validateSession() {
        userSessionPresenter.validateSession();
    }


    @Override
    public void gotoLogIn() {
        Navigation.getInstance().startActivity(this,
                new Bundle(), getString(R.string.ui_module_user_login),true);
    }

    @Override
    public void gotoMain() {
        Navigation.getInstance().startActivity(this,
                new Bundle(), getString(R.string.ui_module_recipes_main),true);
    }


    @Override
    public void setPresenter(UserSessionPresenter presenter) {
        this.userSessionPresenter= presenter;
    }
}
