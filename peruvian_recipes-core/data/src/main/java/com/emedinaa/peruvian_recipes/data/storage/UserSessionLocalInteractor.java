package com.emedinaa.peruvian_recipes.data.storage;

import com.emedinaa.peruvian_recipes.data.entity.UserEntity;
import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.entity.User;
import com.emedinaa.peruvian_recipes.domain.interactors.UserSessionInteractor;

/**
 * Created by eduardomedina on 14/03/17.
 */

public class UserSessionLocalInteractor implements UserSessionInteractor {

    private final SharedPreferencesHelper sharedPreferencesHelper;

    public UserSessionLocalInteractor(SharedPreferencesHelper sharedPreferencesHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    @Override
    public void validateCurrentSession(final StorageCallback storageCallback) {
        UserEntity userEntity= sharedPreferencesHelper.user();

        if(userEntity==null){
            storageCallback.onFailure(new Exception(""));
        }else{
            User user= new User();
            userEntity.setName(userEntity.getName());
            userEntity.setId(userEntity.getId());
            userEntity.setEmail(userEntity.getEmail());

            storageCallback.onSuccess(user);
        }
    }

    @Override
    public void saveSession(User user, final StorageCallback storageCallback) {

        if(user==null){
            storageCallback.onFailure(new Exception(""));
        }else{
            UserEntity userEntity= new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setName(user.getName());
            userEntity.setEmail(user.getEmail());

            sharedPreferencesHelper.saveUser(userEntity);

            storageCallback.onSuccess(null);
        }
    }
}
