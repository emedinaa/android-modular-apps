package com.emedinaa.peruvian_recipes;

import com.emedinaa.peruvian_recipes.common.presenter.BaseView;

/**
 * Created by eduardomedina on 14/03/17.
 */

public interface UserSessionContract {

    interface View extends BaseView<UserSessionPresenter>{
        void gotoLogIn();
        void gotoMain();
    }
}
