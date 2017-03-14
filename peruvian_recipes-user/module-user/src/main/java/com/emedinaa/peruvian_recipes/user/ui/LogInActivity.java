package com.emedinaa.peruvian_recipes.user.ui;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emedinaa.peruvian_recipes.common.Navigation;
import com.emedinaa.peruvian_recipes.data.rest.LogInRestInteractor;
import com.emedinaa.peruvian_recipes.user.R;
import com.emedinaa.peruvian_recipes.user.presenter.LogInPresenter;
import com.emedinaa.peruvian_recipes.user.view.LogInContract;

public class LogInActivity extends AppCompatActivity implements LogInContract.View {

    private View pBar;
    private LogInPresenter logInPresenter;
    private String email , password;
    private TextInputLayout txtInputEteEmail, txtInputEtePassword;
    private EditText eteEmail, etePassword;
    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logInPresenter= new LogInPresenter(this, new LogInRestInteractor());
        setPresenter(logInPresenter);
        ui();
    }

    private void logIn(){
        logInPresenter.logIn(email, password);
    }

    private void ui() {
        pBar= findViewById(R.id.pBar);
        txtInputEteEmail= (TextInputLayout) findViewById(R.id.txtInputEteEmail);
        txtInputEtePassword= (TextInputLayout) findViewById(R.id.txtInputEtePassword);
        eteEmail= (EditText) findViewById(R.id.eteEmail);
        etePassword= (EditText) findViewById(R.id.etePassword);
        btnLogIn= (Button) findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    logIn();
                }
            }
        });
    }

    @Override
    public void showLoading() {
        pBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean validate() {
        email= eteEmail.getText().toString();
        password= etePassword.getText().toString();
        if(email.isEmpty() )return  false;
        if(password.isEmpty())return  false;

        return true;
    }

    @Override
    public void gotoMain() {
        Navigation.getInstance().startActivity(this,new Bundle(),
                getString(R.string.ui_module_recipes_main),true);
    }

    @Override
    public void setPresenter(LogInPresenter presenter) {

    }
}
