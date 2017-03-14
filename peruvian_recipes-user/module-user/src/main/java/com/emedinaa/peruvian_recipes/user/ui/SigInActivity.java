package com.emedinaa.peruvian_recipes.user.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.emedinaa.peruvian_recipes.common.ui.BaseActivity;
import com.emedinaa.peruvian_recipes.user.R;
import com.emedinaa.peruvian_recipes.user.presenter.SigInPresenter;
import com.emedinaa.peruvian_recipes.user.view.SigInContract;

public class SigInActivity extends BaseActivity implements SigInContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);
        ui();
    }

    private void ui() {
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        buildCustomToolbar();

        //events
    }

    private void closeActivity() {
        finish();
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
