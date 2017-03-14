package com.emedinaa.peruvian_recipes.data.rest.entity;

import com.emedinaa.peruvian_recipes.data.entity.MemberEntity;
import com.emedinaa.peruvian_recipes.domain.entity.Recipe;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public class RecipesResponse extends BaseResponse {

    private List<Recipe> data;

    public List<Recipe> getData() {
        return data;
    }

    public void setData(List<Recipe> data) {
        this.data = data;
    }
}
