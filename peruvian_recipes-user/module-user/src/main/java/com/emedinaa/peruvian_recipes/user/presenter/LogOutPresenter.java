package com.emedinaa.peruvian_recipes.user.presenter;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.interactors.UserSessionInteractor;
import com.emedinaa.peruvian_recipes.user.view.LogOutContract;

/**
 * Created by emedinaa on 14/03/17.
 */

public class LogOutPresenter {

    private final LogOutContract.View logOutView;
    private final UserSessionInteractor userSessionInteractor;

    public LogOutPresenter(LogOutContract.View logOutView, UserSessionInteractor userSessionInteractor) {
        this.logOutView = logOutView;
        this.userSessionInteractor = userSessionInteractor;
    }

    private StorageCallback sessionStorageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            logOutView.hideLoading();
            logOutView.gotoLogIn();
        }

        @Override
        public void onFailure(Exception e) {
            logOutView.hideLoading();
        }
    };

    public void closeSession(){
        userSessionInteractor.closeSession(sessionStorageCallback);
    }

}
