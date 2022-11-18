package CustomEssentials.Events.Items.Crafting.ShapelessRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapelessRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapelessRecipes() {
		addSingleItemRecipes();
		
		
	}
	
	public void addAllSlotInputSingleItem(ItemStack inputItem, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem.getType(),inputItem.getAmount());
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	

	private void addSingleItemRecipes() {
		addAllSlotInputSingleItem(new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.BIRCH_LOG), new ItemStack(Material.BIRCH_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.SPRUCE_LOG), new ItemStack(Material.SPRUCE_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.ACACIA_LOG), new ItemStack(Material.ACACIA_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.JUNGLE_LOG), new ItemStack(Material.JUNGLE_PLANKS,4));
		
	}


	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
