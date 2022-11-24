package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.Items.Crafting.CustomItemSets;
import CustomEssentials.Events.Items.CustomItems.CompressedItems;

public class CustomShapedRecipes {

	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	private CustomItemSets vanillaItems = new CustomItemSets();
	
	
	public CustomShapedRecipes() {
		addSingleItemRecipes();
	}
	
	public void addAllSlotInputSingleItem(ItemStack inputItem, ItemStack outputItem) {
		

		ItemStack[][] inputItems = new ItemStack[4][4];
		ItemStack[][] resultItems = new ItemStack[2][2];
		inputItems[0][0] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[0][1] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[0][2] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[0][3] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[1][0] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[1][1] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[1][2] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[1][3] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[2][0] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[2][1] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[2][2] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[2][3] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[3][0] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[3][1] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[3][2] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		inputItems[3][3] = new ItemStack(inputItem.getType(),inputItem.getAmount());
		
		resultItems[0][0] = outputItem;
		resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		recipeOutput.put(inputItems, resultItems);
		
	}
	
	private void addSingleItemRecipes() {
		
		for (Material material: this.getVanillaItems().getVanillaToCustomItems()) {
			addAllSlotInputSingleItem(new ItemStack(material,material.getMaxStackSize()),new CompressedItems().createItem(material,1));
		}
		
		
	}

	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}

	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}

	public CustomItemSets getVanillaItems() {
		return vanillaItems;
	}

	public void setVanillaItems(CustomItemSets vanillaItems) {
		this.vanillaItems = vanillaItems;
	}

}
