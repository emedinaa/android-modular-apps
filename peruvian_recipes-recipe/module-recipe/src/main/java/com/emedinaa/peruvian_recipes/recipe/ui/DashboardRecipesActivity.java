package com.emedinaa.peruvian_recipes.recipe.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.emedinaa.peruvian_recipes.data.rest.RecipesRestInteractor;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.recipe.R;
import com.emedinaa.peruvian_recipes.recipe.adapter.RecipeAdapter;
import com.emedinaa.peruvian_recipes.recipe.presenter.RecipesPresenter;
import com.emedinaa.peruvian_recipes.recipe.view.RecipesContract;

import java.util.List;

public class DashboardRecipesActivity extends AppCompatActivity implements RecipesContract.View {

    private static final String TAG = "DashboardRecipesA";
    private RecyclerView rviRecipes;
    private View pBar;

    private List<Recipe> recipes;
    private RecyclerView.LayoutManager layoutManager;
    private RecipesPresenter recipesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_recipes);
        setPresenter(new RecipesPresenter(this,new RecipesRestInteractor()));
        ui();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recipesPresenter.getRecipes();
    }

    private void ui() {
        rviRecipes= (RecyclerView)findViewById(R.id.rviRecipes);
        pBar= findViewById(R.id.pBar);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rviRecipes.setHasFixedSize(false);

        // use a linear layout manager
        layoutManager= new LinearLayoutManager(this);
        rviRecipes.setLayoutManager(layoutManager);
    }

    @Override
    public void showLoading() {
        pBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void renderRecipes(List<Recipe> recipeList) {
        this.recipes= recipeList;
        Log.v(TAG, "recipes "+recipes);
        RecipeAdapter recipeAdapter= new RecipeAdapter(this.recipes);
        rviRecipes.setAdapter(recipeAdapter);

    }

    @Override
    public void gotoRecipe(Recipe recipe) {

    }

    @Override
    public void setPresenter(RecipesPresenter presenter) {
        this.recipesPresenter= presenter;
    }
}
