package com.emedinaa.peruvian_recipes.user.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.emedinaa.peruvian_recipes.common.Navigation;
import com.emedinaa.peruvian_recipes.data.helpers.GsonHelper;
import com.emedinaa.peruvian_recipes.data.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.peruvian_recipes.data.storage.SharedPreferencesHelper;
import com.emedinaa.peruvian_recipes.data.storage.UserSessionLocalInteractor;
import com.emedinaa.peruvian_recipes.user.R;
import com.emedinaa.peruvian_recipes.user.presenter.LogOutPresenter;
import com.emedinaa.peruvian_recipes.user.view.LogOutContract;

public class ProfileActivity extends AppCompatActivity implements
        LogOutContract.View{

    private static final String SPREFERENCES = "com.emedinaa.peruvian_recipes.session";

    private View btnLogOut;
    private LogOutPresenter logOutPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences sharedPreferences= getSharedPreferences(SPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferencesHelper preferencesHelper= new DefaultSharedPreferencesHelper(
                new GsonHelper(),sharedPreferences );
        setPresenter(new LogOutPresenter(this, new UserSessionLocalInteractor(preferencesHelper)));
        ui();
    }

    private void ui() {
        btnLogOut= findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSession();
            }
        });
    }

    private void closeSession() {
        logOutPresenter.closeSession();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void gotoLogIn() {
        Navigation.getInstance().startActivityAndReset(this,new Bundle(),
                getString(R.string.ui_module_user_login),true);
    }

    @Override
    public void setPresenter(LogOutPresenter presenter) {
        logOutPresenter= presenter;
    }
}
