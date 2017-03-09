package com.emedinaa.meetup.data.storage;

import android.content.SharedPreferences;

import com.emedinaa.meetup.data.entity.UserEntity;
import com.emedinaa.meetup.data.helpers.GsonHelper;


/**
 * Created by eduardomedina on 15/11/16.
 */
public class DefaultSharedPreferencesHelper implements SharedPreferencesHelper {

    private  final String MY_SHARED_PREFERENCES = "com.emedinaa.sharedpreferences";
    private  final String KEY_EMAIL = MY_SHARED_PREFERENCES+".session.email";
    private  final String KEY_USER = MY_SHARED_PREFERENCES+".session.user";

    private final SharedPreferences sharedPreferences;
    private final GsonHelper gsonHelper;

    public DefaultSharedPreferencesHelper(GsonHelper gsonHelper,SharedPreferences sharedPreferences) {
        this.gsonHelper= gsonHelper;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void saveEmail(String email) {
        SharedPreferences.Editor editor = editor();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    @Override
    public String email() {
        String  email= sharedPreferences.getString(KEY_EMAIL,"");
        return email;
    }

    @Override
    public void saveUser(UserEntity user) {
        SharedPreferences.Editor editor = editor();
        editor.putString(KEY_USER, gsonHelper.objectToJSON(user).toString());
        editor.apply();
    }

    @Override
    public UserEntity user() {
        String  userStr= sharedPreferences.getString(KEY_USER,"");
        UserEntity user= gsonHelper.jsonToObject(userStr,UserEntity.class);
        System.out.println("sp user "+user);
        return user;
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = editor();
        editor.clear();
        editor.apply();
    }

    private  SharedPreferences.Editor editor() {
        return sharedPreferences.edit();
    }

}
