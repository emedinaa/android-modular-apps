package com.emedinaa.meetup.user.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emedinaa.meetup.user.R;

public class LogInActivity extends AppCompatActivity {

    //https://secure.meetup.com/oauth2/authorize
    //https://secure.meetup.com/oauth2/access

    // Meetup OAuth Endpoints
    // Meetup OAuth Endpoints
    public static final String AUTH_URL = "https://secure.meetup.com/oauth2/authorize";
    public static final String TOKEN_URL = "https://secure.meetup.com/oauth2/access";

    private final String clientId = "n791vkuvd4b3dmso05uf4k6odp";
    private final String clientSecret = "hu2daokd9883fd1vpnn1ocvbgv";
    private final String redirectUri = "your://redirecturi";

    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAuthentication();
            }
        });
    }

    private void gotoAuthentication() {

        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(AUTH_URL  + "?client_id=" + clientId + "&redirect_uri=" + redirectUri));
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(redirectUri)) {

        }
    }
}
