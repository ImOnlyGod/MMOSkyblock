package CustomEssentials.Events.Items.Crafting;

import CustomEssentials.Events.Items.Crafting.ShapedRecipes.CustomShapedRecipes;
import CustomEssentials.Events.Items.Crafting.ShapedRecipes.VanillaShapedRecipes;
import CustomEssentials.Events.Items.Crafting.ShapelessRecipes.CustomShapelessRecipes;
import CustomEssentials.Events.Items.Crafting.ShapelessRecipes.VanillaShapelessRecipes;

public class CustomCraftingItemSet {
	
	private VanillaShapelessRecipes vanillaShapelessRecipe = new VanillaShapelessRecipes();
	private VanillaShapedRecipes vanillaShapedRecipe = new VanillaShapedRecipes();
	public CustomShapelessRecipes customShapelessRecipes = new CustomShapelessRecipes();
	public CustomShapedRecipes customShapedRecipes = new CustomShapedRecipes();
	


	public CustomShapedRecipes getCustomShapedRecipes() {
		return customShapedRecipes;
	}


	public void setCustomShapedRecipes(CustomShapedRecipes customShapedRecipes) {
		this.customShapedRecipes = customShapedRecipes;
	}


	public CustomCraftingItemSet() {
	}
	
	
	public CustomShapelessRecipes getCustomShapelessRecipes() {
		return customShapelessRecipes;
	}

	public void setCustomShapelessRecipes(CustomShapelessRecipes customShapelessRecipes) {
		this.customShapelessRecipes = customShapelessRecipes;
	}

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
	
	
