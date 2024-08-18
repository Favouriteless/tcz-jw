package com.tacz.guns.resource.pojo.data.recipe;

import com.google.gson.annotations.SerializedName;
import com.tacz.guns.crafting.GunSmithTableIngredient;
import com.tacz.guns.crafting.GunSmithTableResult;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TableRecipe {
    @SerializedName("materials")
    private List<GunSmithTableIngredient> materials;

    @SerializedName("result")
    private GunSmithTableResult result;

    @SerializedName("required_advancement")
    private String requiredAdvancement;

    public List<GunSmithTableIngredient> getMaterials() {
        return materials;
    }

    public GunSmithTableResult getResult() {
        return result;
    }

    public String getRequiredAdvancement() {
        return requiredAdvancement;
    }
}
