package com.emedinaa.peruvian_recipes;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.interactors.UserSessionInteractor;

/**
 * Created by eduardomedina on 14/03/17.
 */

public class UserSessionPresenter {

    private  final UserSessionContract.View sessionView;
    private final UserSessionInteractor userSessionInteractor;


    public UserSessionPresenter(UserSessionContract.View sessionView, UserSessionInteractor userSessionInteractor) {
        this.sessionView = sessionView;
        this.userSessionInteractor = userSessionInteractor;
    }

    private StorageCallback storageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            sessionView.gotoMain();
        }

        @Override
        public void onFailure(Exception e) {
            sessionView.gotoLogIn();
        }
    };

    public void validateSession(){
        userSessionInteractor.validateCurrentSession(storageCallback);
    }
}
