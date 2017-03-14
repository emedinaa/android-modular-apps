package com.emedinaa.peruvian_recipes.user.view;

import com.emedinaa.peruvian_recipes.common.presenter.BaseView;
import com.emedinaa.peruvian_recipes.user.presenter.LogOutPresenter;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface LogOutContract {

    interface View extends BaseView<LogOutPresenter> {
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        void gotoLogIn();
    }
}
