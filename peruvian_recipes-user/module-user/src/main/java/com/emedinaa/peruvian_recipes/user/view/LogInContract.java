package com.emedinaa.peruvian_recipes.user.view;

import com.emedinaa.peruvian_recipes.common.presenter.BaseView;
import com.emedinaa.peruvian_recipes.user.presenter.LogInPresenter;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface LogInContract {

    interface View extends BaseView<LogInPresenter>{
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        boolean validate();
        void gotoMain();
    }
}
