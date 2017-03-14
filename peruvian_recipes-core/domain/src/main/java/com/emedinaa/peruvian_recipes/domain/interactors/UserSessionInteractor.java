package com.emedinaa.peruvian_recipes.domain.interactors;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.entity.User;

/**
 * Created by eduardomedina on 14/03/17.
 */

public interface UserSessionInteractor {

    void validateCurrentSession(final StorageCallback storageCallback);
    void saveSession(User user, final StorageCallback storageCallback);
    void closeSession(final StorageCallback storageCallback);
}
