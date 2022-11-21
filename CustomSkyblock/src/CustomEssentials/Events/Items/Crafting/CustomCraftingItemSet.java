package CustomEssentials.Events.Items.Crafting;

import CustomEssentials.Events.Items.Crafting.ShapedRecipes.VanillaShapedRecipes;
import CustomEssentials.Events.Items.Crafting.ShapelessRecipes.VanillaShapelessRecipes;

public class CustomCraftingItemSet {
	
	private VanillaShapelessRecipes vanillaShapelessRecipe = new VanillaShapelessRecipes();
	private VanillaShapedRecipes vanillaShapedRecipe = new VanillaShapedRecipes();

	public VanillaShapelessRecipes getVanillaShapelessRecipe() {
		return vanillaShapelessRecipe;
	}

	public void setVanillaShapelessRecipe(VanillaShapelessRecipes vanillaShapelessRecipe) {
		this.vanillaShapelessRecipe = vanillaShapelessRecipe;
	}

	public VanillaShapedRecipes getVanillaShapedRecipe() {
		return vanillaShapedRecipe;
	}

	public void setVanillaShapedRecipe(VanillaShapedRecipes vanillaShapedRecipe) {
		this.vanillaShapedRecipe = vanillaShapedRecipe;
	}
	
	
}
	
	
