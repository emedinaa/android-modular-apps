package com.emedinaa.peruvian_recipes.recipe.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.recipe.R;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Recipe> recipes;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tviTitle;

        public ViewHolder(View view) {
            super(view);
            tviTitle=(TextView)view.findViewById(R.id.tviTitle);
        }
    }


    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipes = recipeList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recipe, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Recipe recipe= recipes.get(position);
        holder.tviTitle.setText(recipe.getTitle());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.recipes.size();
    }
}
