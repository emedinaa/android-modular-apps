package com.emedinaa.peruvian_recipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emedinaa.peruvian_recipes.common.Navigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app();
    }

    private void app() {
        Navigation.getInstance().startActivity(this,
                new Bundle(), getString(R.string.ui_module_user_login),false);
    }
}
