package com.emedinaa.peruvian_recipes.data.rest;

import android.util.Log;

import com.emedinaa.peruvian_recipes.data.rest.entity.LogInRaw;
import com.emedinaa.peruvian_recipes.data.rest.entity.LogInResponse;
import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.interactors.LogInInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 13/03/17.
 */

public class LogInRestInteractor implements LogInInteractor {

    private static final String TAG = "LogInRestInteractor";
    private final String ERROR_MESSAGE= "Ocurrió un error";

    @Override
    public void logIn(String email, String password, final StorageCallback storageCallback) {
        LogInRaw logInRaw= new LogInRaw();
        logInRaw.setLogin(email);
        logInRaw.setPassword(password);
        Call<LogInResponse> call = ApiClient.getMyApiClient().login(logInRaw);
        call.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                if(response.isSuccessful()){
                    storageCallback.onSuccess(response.body());
                }else {
                    storageCallback.onFailure(new Exception(ERROR_MESSAGE));
                }
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                String json="Error ";
                try {
                    json= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {}
                Log.v(TAG, "json >>>> " + json);

                storageCallback.onFailure(new Exception(json));
            }
        });
    }
}
