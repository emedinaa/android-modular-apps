package com.emedinaa.peruvian_recipes.domain.interactors;

import com.emedinaa.peruvian_recipes.domain.callback.StorageCallback;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface RecipesInteractor {

    void getRecipes(final StorageCallback callback);
}
