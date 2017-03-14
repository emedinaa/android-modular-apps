package com.emedinaa.peruvian_recipes.recipe.view;

import com.emedinaa.peruvian_recipes.common.presenter.BaseView;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.recipe.presenter.RecipesPresenter;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface RecipesContract {

    interface View extends BaseView<RecipesPresenter>{
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        void renderRecipes(List<Recipe> recipeList);
        void gotoRecipe(Recipe recipe);
    }
}
