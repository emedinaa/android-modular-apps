package com.emedinaa.peruvian_recipes.recipe.ui.recycler;

import android.view.View;

/**
 * Created by emedinaa on 14/10/15.
 */
public interface RecyclerClickListener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}