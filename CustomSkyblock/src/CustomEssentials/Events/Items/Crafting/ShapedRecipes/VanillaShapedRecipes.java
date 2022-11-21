package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapedRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapedRecipes() {
		addDoubleItemRecipes();
	}
	
	
	public void addAllDoubleInputHorizontalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllDoubleInputVerticalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	private void addDoubleItemRecipes() {
		addAllDoubleInputHorizontalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.BIRCH_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.SPRUCE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.DARK_OAK_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.JUNGLE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.ACACIA_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.CRIMSON_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.WARPED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE), new ItemStack(Material.STONE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT), new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.LIGHT_WEIGHTED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.POLISHED_BLACKSTONE_PRESSURE_PLATE));
		
		addAllDoubleInputVerticalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.STICK,4));
	}

	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
