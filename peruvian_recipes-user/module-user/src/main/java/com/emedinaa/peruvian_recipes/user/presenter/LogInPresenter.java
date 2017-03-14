package com.emedinaa.peruvian_recipes.user.presenter;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.interactors.LogInInteractor;
import com.emedinaa.peruvian_recipes.user.view.LogInContract;

/**
 * Created by emedinaa on 13/03/17.
 */

public class LogInPresenter {
    private  final LogInContract.View logInView;
    private final LogInInteractor logInInteractor;

    public LogInPresenter(LogInContract.View logInView, LogInInteractor logInInteractor) {
        this.logInView = logInView;
        this.logInInteractor = logInInteractor;
    }

    private StorageCallback storageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            logInView.hideLoading();
            logInView.gotoMain();
        }

        @Override
        public void onFailure(Exception e) {
            logInView.hideLoading();
        }
    };
    public void logIn(String email, String password){
        logInView.showLoading();
        logInInteractor.logIn(email,password,storageCallback);
    }
}
