package com.emedinaa.peruvian_recipes.domain.interactors;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface LogInInteractor {

    void logIn(String email, String password, final StorageCallback storageCallback);
}
