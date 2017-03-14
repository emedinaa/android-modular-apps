package com.emedinaa.peruvian_recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emedinaa.peruvian_recipes.user.ui.LogInActivity;

public class UserMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        app();
    }

    private void app() {
        startActivity(new Intent(this, LogInActivity.class));
    }
}
