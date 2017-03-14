package com.emedinaa.peruvian_recipes.common.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.emedinaa.peruvian_recipes.common.R;

/**
 * Created by eduardomedina on 14/03/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected Toolbar myToolbar;
    protected View profile;
    protected View back;

    protected void buildCustomToolbar(){
        setSupportActionBar(myToolbar);
    }

    protected void enabledBack(){
        if(back!=null)back.setVisibility(View.VISIBLE);
    }

    protected void enabledProfile(){
        if(profile!=null)profile.setVisibility(View.VISIBLE);
    }
}
