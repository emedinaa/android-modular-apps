package com.emedinaa.peruvian_recipes.data.rest;

import android.util.Log;

import com.emedinaa.peruvian_recipes.data.rest.entity.RecipesResponse;
import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.domain.interactors.RecipesInteractor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 14/03/17.
 */

public class RecipesRestInteractor implements RecipesInteractor {
    private final String ERROR_MESSAGE= "Ocurrió un error";

    @Override
    public void getRecipes(final StorageCallback storageCallback) {
        Call<RecipesResponse> call = ApiClient.getMyApiClient().recipes();
        call.enqueue(new Callback<RecipesResponse>() {
            @Override
            public void onResponse(Call<RecipesResponse> call, Response<RecipesResponse> response) {
                if (response.isSuccessful()) {
                    RecipesResponse recipesResponse= response.body();
                    if(recipesResponse!=null){
                        List<Recipe> recipes= recipesResponse.getData();
                        storageCallback.onSuccess(recipes);
                    }else{
                        storageCallback.onFailure(new Exception(ERROR_MESSAGE));
                    }

                } else {
                    storageCallback.onFailure(new Exception(ERROR_MESSAGE));
                }
            }

            @Override
            public void onFailure(Call<RecipesResponse> call, Throwable t) {
                String json = "Error ";
                try {
                    json = new StringBuffer().append(t.getMessage()).toString();
                } catch (NullPointerException e) {
                }

                storageCallback.onFailure(new Exception(json));
            }
        });
    }
}
