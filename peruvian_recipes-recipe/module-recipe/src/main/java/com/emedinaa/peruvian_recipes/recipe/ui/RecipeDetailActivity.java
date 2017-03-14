package com.emedinaa.peruvian_recipes.recipe.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.peruvian_recipes.common.media.ImageLoaderHelper;
import com.emedinaa.peruvian_recipes.common.ui.BaseActivity;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;
import com.emedinaa.peruvian_recipes.recipe.R;

public class RecipeDetailActivity extends BaseActivity {

    private ImageView iviPhoto;
    private TextView tviTitle;
    private TextView tviDesc;
    private TextView tviIngre;
    private TextView tviSteps;

    private Recipe recipe;
    private ImageLoaderHelper imageLoaderHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        extras();
        ui();
        imageLoaderHelper= new ImageLoaderHelper(ImageLoaderHelper.PICASSO);
        populateRecipe();
    }

    private void populateRecipe() {
        String title= recipe.getTitle();
        String desc= recipe.getDescription();
        String ingredients= recipe.getIngredients();
        String steps= recipe.getSteps();
        int servings= recipe.getServings();

        tviTitle.setText(title);
        tviDesc.setText(desc);
        tviIngre.setText(ingredients);
        tviSteps.setText(steps);

        imageLoaderHelper.getLoader().load(recipe.getImage(),iviPhoto);

    }

    private void extras() {
        if(getIntent()!=null){
            Bundle bundle= getIntent().getExtras();
            if(bundle!=null){
                recipe= (Recipe) bundle.getSerializable("RECIPE");
            }
        }
    }

    private void ui() {
        iviPhoto= (ImageView)(findViewById(R.id.iviPhoto));
        tviTitle= (TextView) (findViewById(R.id.tviTitle));
        tviDesc= (TextView)(findViewById(R.id.tviDesc));
        tviIngre= (TextView)(findViewById(R.id.tviIngre));
        tviSteps= (TextView)(findViewById(R.id.tviSteps));
        myToolbar= (Toolbar)(findViewById(R.id.my_toolbar));
        back= findViewById(R.id.iviBack);
        profile= findViewById(R.id.iviProfile);

        buildCustomToolbar();
        enabledBack();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeActivity();
            }
        });
    }

    private void closeActivity() {
        finish();
    }
}
