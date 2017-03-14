package com.emedinaa.peruvian_recipes.recipe.presenter;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.domain.interactors.LogInInteractor;
import com.emedinaa.peruvian_recipes.domain.interactors.RecipesInteractor;
import com.emedinaa.peruvian_recipes.recipe.view.RecipesContract;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public class RecipesPresenter {

    private  final RecipesContract.View recipesView;
    private final RecipesInteractor recipesInteractor;

    public RecipesPresenter(RecipesContract.View recipesView, RecipesInteractor recipesInteractor) {
        this.recipesView = recipesView;
        this.recipesInteractor = recipesInteractor;
    }

    private StorageCallback storageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            recipesView.hideLoading();
            recipesView.renderRecipes((List<Recipe>)(object));
        }

        @Override
        public void onFailure(Exception e) {
            recipesView.hideLoading();
            recipesView.showMessage(e.getMessage());
        }
    };

    public void getRecipes(){
        recipesInteractor.getRecipes(storageCallback);
    }
}
