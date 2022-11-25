package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.Items.Crafting.CustomItemSets;
import CustomEssentials.Events.Items.CustomItems.CompressedItems;
import CustomEssentials.Events.Items.Weapons.ThickWoodenSword;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneBoots;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneChestplate;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneHelmet;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneLeggings;

public class CustomShapedRecipes {

	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	private CustomItemSets vanillaItems = new CustomItemSets();
	
	
	public CustomShapedRecipes() {
		addSingleItemRecipes();
		addTripleItemRecipes();
		addArmorItemRecipes();
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
	
	public void addAllTripleInputVerticalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = inputItem1;
				inputItems[i+1][j] = inputItem1;
				inputItems[i+2][j] = inputItem2;
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSingleInputHelmetItem(ItemStack inputItem1, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = inputItem1;
				inputItems[i+1][j] = inputItem1;
				inputItems[i][j+1] = inputItem1;
				inputItems[i][j+2] = inputItem1;
				inputItems[i+1][j+2] = inputItem1;
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSingleInputChestplateItem(ItemStack inputItem1, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = inputItem1;
				inputItems[i+1][j] = inputItem1;
				inputItems[i+2][j] = inputItem1;
				inputItems[i+1][j+1] = inputItem1;
				inputItems[i+2][j+1] = inputItem1;
				inputItems[i][j+2] = inputItem1;
				inputItems[i+1][j+2] = inputItem1;
				inputItems[i+2][j+2] = inputItem1;
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSingleInputLeggingsItem(ItemStack inputItem1, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = inputItem1;
				inputItems[i+1][j] = inputItem1;
				inputItems[i][j+1] = inputItem1;
				inputItems[i][j+2] = inputItem1;
				inputItems[i+1][j+2] = inputItem1;
				inputItems[i+2][j] = inputItem1;
				inputItems[i+2][j+2] = inputItem1;
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSingleInputBootsItem(ItemStack inputItem1, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = inputItem1;
				inputItems[i+1][j] = inputItem1;
				inputItems[i][j+2] = inputItem1;
				inputItems[i+1][j+2] = inputItem1;
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	private void addSingleItemRecipes() {
		
		for (Material material: this.getVanillaItems().getVanillaToCustomItems()) {
			addAllSlotInputSingleItem(new ItemStack(material,material.getMaxStackSize()),new CompressedItems().createItem(material,1));
		}		
		
	}
	
	private void addTripleItemRecipes() {
		addAllTripleInputVerticalItem(new CompressedItems().createItem(Material.OAK_LOG,1),new ItemStack(Material.STICK),new ThickWoodenSword().createItem(1));
			
		
	}
	
	private void addArmorItemRecipes() {
		addAllSingleInputHelmetItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneHelmet().createItem(1));
		addAllSingleInputChestplateItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneChestplate().createItem(1));
		addAllSingleInputLeggingsItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneLeggings().createItem(1));
		addAllSingleInputBootsItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneBoots().createItem(1));
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
