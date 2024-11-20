package org.LacyCat.catAPI.Manager.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeManager {


    public void ShapedRecipeRegister(
            JavaPlugin plugin,
            String key1, String key2, String key3,
            String key4, String key5, String key6,
            String key7, String key8, String key9,
            Material mat1, Material mat2, Material mat3,
            Material mat4, Material mat5, Material mat6,
            Material mat7, Material mat8, Material mat9,
            ItemStack result, String recipeKey
            ) throws IllegalArgumentException {
        if (plugin == null || result == null || recipeKey == null || recipeKey.isEmpty()) {
            throw new IllegalArgumentException("플러그인, 결과 아이템, 또는 레시피 키 값이 잘못되었습니다.");
        }

        NamespacedKey key = new NamespacedKey(plugin, recipeKey);
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(key1 + key2 + key3, key4 + key5 + key6, key7 + key8 + key9);

        if (key1.charAt(0) != ' ') recipe.setIngredient(key1.charAt(0), mat1);
        if (key2.charAt(0) != ' ') recipe.setIngredient(key2.charAt(0), mat2);
        if (key3.charAt(0) != ' ') recipe.setIngredient(key3.charAt(0), mat3);
        if (key4.charAt(0) != ' ') recipe.setIngredient(key4.charAt(0), mat4);
        if (key5.charAt(0) != ' ') recipe.setIngredient(key5.charAt(0), mat5);
        if (key6.charAt(0) != ' ') recipe.setIngredient(key6.charAt(0), mat6);
        if (key7.charAt(0) != ' ') recipe.setIngredient(key7.charAt(0), mat7);
        if (key8.charAt(0) != ' ') recipe.setIngredient(key8.charAt(0), mat8);
        if (key9.charAt(0) != ' ') recipe.setIngredient(key9.charAt(0), mat9);

        Bukkit.addRecipe(recipe);
    }


    public void FurnaceRecipeRegister(
            JavaPlugin plugin, Material material, ItemStack result,
            float experienceAmount, int cookingTime, String recipeKey
            ) throws IllegalArgumentException {
        if (plugin == null || result == null || recipeKey == null || recipeKey.isEmpty()) {
            throw new IllegalArgumentException("플러그인 또는 레시피 키 값이 잘못되었습니다.");
        }
        NamespacedKey key = new NamespacedKey(plugin, recipeKey);
        FurnaceRecipe recipe = new FurnaceRecipe(key, result, material, experienceAmount, cookingTime);
        Bukkit.addRecipe(recipe);
    }
}
