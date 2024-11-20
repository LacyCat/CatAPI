package org.LacyCat.catAPI;

import org.LacyCat.catAPI.Manager.Inventory.InventoryManager;
import org.LacyCat.catAPI.Manager.Recipe.RecipeManager;
import org.LacyCat.catAPI.Manager.Utils.UtilsMain;
import org.bukkit.plugin.java.JavaPlugin;

public class MainAPI {
    private static InventoryManager inventoryManager;
    private static RecipeManager recipeManager;
    private static UtilsMain utils;

    public static void initialize(JavaPlugin plugin) {
        inventoryManager = new InventoryManager();
        recipeManager = new RecipeManager();
        utils = new UtilsMain();
    }

    public static InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public static RecipeManager getRecipeManager() {
        return recipeManager;
    }

    public static UtilsMain getUtils() {
        return utils;
    }
}
