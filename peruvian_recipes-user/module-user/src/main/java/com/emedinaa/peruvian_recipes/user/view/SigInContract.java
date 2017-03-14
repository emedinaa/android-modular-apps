package com.emedinaa.peruvian_recipes.user.view;

import com.emedinaa.peruvian_recipes.common.presenter.BaseView;
import com.emedinaa.peruvian_recipes.user.presenter.SigInPresenter;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface SigInContract {

    interface View extends BaseView<SigInPresenter> {
        void showLoading();
        void hideLoading();
        boolean validate();
        void gotoLogIn();
    }
}
