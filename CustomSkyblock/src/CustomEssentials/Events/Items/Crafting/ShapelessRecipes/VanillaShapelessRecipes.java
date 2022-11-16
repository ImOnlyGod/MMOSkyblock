package CustomEssentials.Events.Items.Crafting.ShapelessRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapelessRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapelessRecipes() {
		addSingleItemRecipes();
		
		
	}
	

	private void addSingleItemRecipes() {
		ItemStack[][] OAK_LOG = new ItemStack[4][4];
		ItemStack[][] OAK_PLANKS = new ItemStack[2][2];
		OAK_LOG[0][0] = new ItemStack(Material.OAK_LOG);				
		OAK_PLANKS[0][0] = new ItemStack(Material.OAK_PLANKS,4);
		recipeOutput.put(OAK_LOG, OAK_PLANKS);
		
	}


	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
