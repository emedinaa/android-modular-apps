package com.emedinaa.peruvian_recipes.user.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emedinaa.peruvian_recipes.user.R;
import com.emedinaa.peruvian_recipes.user.presenter.SigInPresenter;
import com.emedinaa.peruvian_recipes.user.view.SigInContract;

public class SigInActivity extends AppCompatActivity implements SigInContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void gotoLogIn() {

    }

    @Override
    public void setPresenter(SigInPresenter presenter) {

    }
}
