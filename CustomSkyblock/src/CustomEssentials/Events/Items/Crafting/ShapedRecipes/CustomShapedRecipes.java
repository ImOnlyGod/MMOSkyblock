package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.Items.Crafting.CustomItemSets;
import CustomEssentials.Events.Items.CustomItems.CompressedItems;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.DiamondBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.GoldenBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.IronBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.LetherBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.NetheriteBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.DiamondChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.GoldenChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.IronChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.LetherChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.NetheriteChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.DiamondHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.GoldenHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.IronHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.LetherHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.NetheriteHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.TurtleHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.DiamondLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.GoldenLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.IronLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.LetherLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.NetheriteLeggings;
import CustomEssentials.Events.Items.Vanilla.Bows.Bow;
import CustomEssentials.Events.Items.Vanilla.Bows.CrossBow;
import CustomEssentials.Events.Items.Vanilla.Swords.DiamondSword;
import CustomEssentials.Events.Items.Vanilla.Swords.GoldenSword;
import CustomEssentials.Events.Items.Vanilla.Swords.IronSword;
import CustomEssentials.Events.Items.Vanilla.Swords.NetheriteSword;
import CustomEssentials.Events.Items.Vanilla.Swords.StoneSword;
import CustomEssentials.Events.Items.Vanilla.Swords.WoodenSword;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.DiamondAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.GoldenAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.IronAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.NetheriteAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.StoneAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.WoodenAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.DiamondHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.GoldenHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.IronHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.NetheriteHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.StoneHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.WoodenHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.DiamondPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.GoldenPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.IronPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.NetheritePickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.StonePickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.WoodenPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.DiamondShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.GoldenShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.IronShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.NetheriteShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.StoneShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.WoodenShovel;
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
		addBowItemRecipes();
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
	
	public void addAllTInputPickItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTInputShovelItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTInputAxeItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTInputHoeItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
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
	
	public void addAllArmorInputHelmetItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAllArmorInputChestplateItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAllArmorInputLeggingsItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAllArmorInputBootsItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll6InputsBowItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack outputItem) {

		for (int i=1;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i-1][j+2] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=1;i<3;i++) {
			for (int j=2;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j-1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j-1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i-1][j-2] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j-2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+1][j-2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				
				
				
				resultItems[0][0] = outputItem;
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}	
		
	}
	
	public void addAll7InputsItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				
				
				
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
		//Vanilla Swords
		addAllTripleInputVerticalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new WoodenSword().createItem(1));
		
		addAllTripleInputVerticalItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.STICK),new StoneSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.STICK),new StoneSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.BASALT),new ItemStack(Material.STICK),new StoneSword().createItem(1));
		
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new IronSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new GoldenSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.STICK),new DiamondSword().createItem(1));
		addAllTripleInputVerticalItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.STICK),new NetheriteSword().createItem(1));
		
		//Vanilla Tools
		addAllTInputPickItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new WoodenPickaxe().createItem(1));
		
		addAllTInputPickItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.STICK),new StonePickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.STICK),new StonePickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.BASALT),new ItemStack(Material.STICK),new StonePickaxe().createItem(1));
		
		addAllTInputPickItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new IronPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new GoldenPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.STICK),new DiamondPickaxe().createItem(1));
		addAllTInputPickItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.STICK),new NetheritePickaxe().createItem(1));
		
		addAllTInputAxeItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new WoodenAxe().createItem(1));
		
		addAllTInputAxeItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.STICK),new StoneAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.STICK),new StoneAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.BASALT),new ItemStack(Material.STICK),new StoneAxe().createItem(1));
		
		addAllTInputAxeItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new IronAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new GoldenAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.STICK),new DiamondAxe().createItem(1));
		addAllTInputAxeItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.STICK),new NetheriteAxe().createItem(1));
		
		addAllTInputShovelItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new WoodenShovel().createItem(1));
		
		addAllTInputShovelItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.STICK),new StoneShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.STICK),new StoneShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.BASALT),new ItemStack(Material.STICK),new StoneShovel().createItem(1));
		
		addAllTInputShovelItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new IronShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new GoldenShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.STICK),new DiamondShovel().createItem(1));
		addAllTInputShovelItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.STICK),new NetheriteShovel().createItem(1));
		
		addAllTInputHoeItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new WoodenHoe().createItem(1));
		
		addAllTInputHoeItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.STICK),new StoneHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.STICK),new StoneHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.BASALT),new ItemStack(Material.STICK),new StoneHoe().createItem(1));
		
		addAllTInputHoeItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new IronHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new GoldenHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.STICK),new DiamondHoe().createItem(1));
		addAllTInputHoeItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.STICK),new NetheriteHoe().createItem(1));

		//Custom Weapons
		addAllTripleInputVerticalItem(new CompressedItems().createItem(Material.OAK_LOG,1),new ItemStack(Material.STICK),new ThickWoodenSword().createItem(1));
			
		
	}
	
	private void addArmorItemRecipes() {
		
		addAllSingleInputHelmetItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneHelmet().createItem(1));
		addAllSingleInputChestplateItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneChestplate().createItem(1));
		addAllSingleInputLeggingsItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneLeggings().createItem(1));
		addAllSingleInputBootsItem(new CompressedItems().createItem(Material.COBBLESTONE,1),new HardStoneBoots().createItem(1));
		
		//Vanilla Armor
		addAllSingleInputHelmetItem(new ItemStack(Material.LEATHER), new LetherHelmet().createItem(1));
		addAllSingleInputHelmetItem(new ItemStack(Material.IRON_INGOT), new IronHelmet().createItem(1));
		addAllSingleInputHelmetItem(new ItemStack(Material.GOLD_INGOT), new GoldenHelmet().createItem(1));
		addAllSingleInputHelmetItem(new ItemStack(Material.DIAMOND), new DiamondHelmet().createItem(1));
		addAllSingleInputHelmetItem(new ItemStack(Material.NETHERITE_INGOT), new NetheriteHelmet().createItem(1));
		addAllSingleInputHelmetItem(new ItemStack(Material.SCUTE), new TurtleHelmet().createItem(1));
		
		addAllSingleInputChestplateItem(new ItemStack(Material.LEATHER), new LetherChestplate().createItem(1));
		addAllSingleInputChestplateItem(new ItemStack(Material.IRON_INGOT), new IronChestplate().createItem(1));
		addAllSingleInputChestplateItem(new ItemStack(Material.GOLD_INGOT), new GoldenChestplate().createItem(1));
		addAllSingleInputChestplateItem(new ItemStack(Material.DIAMOND), new DiamondChestplate().createItem(1));
		addAllSingleInputChestplateItem(new ItemStack(Material.NETHERITE_INGOT), new NetheriteChestplate().createItem(1));
		
		addAllSingleInputLeggingsItem(new ItemStack(Material.LEATHER), new LetherLeggings().createItem(1));
		addAllSingleInputLeggingsItem(new ItemStack(Material.IRON_INGOT), new IronLeggings().createItem(1));
		addAllSingleInputLeggingsItem(new ItemStack(Material.GOLD_INGOT), new GoldenLeggings().createItem(1));
		addAllSingleInputLeggingsItem(new ItemStack(Material.DIAMOND), new DiamondLeggings().createItem(1));
		addAllSingleInputLeggingsItem(new ItemStack(Material.NETHERITE_INGOT), new NetheriteLeggings().createItem(1));
		
		addAllSingleInputBootsItem(new ItemStack(Material.LEATHER), new LetherBoots().createItem(1));
		addAllSingleInputBootsItem(new ItemStack(Material.IRON_INGOT), new IronBoots().createItem(1));
		addAllSingleInputBootsItem(new ItemStack(Material.GOLD_INGOT), new GoldenBoots().createItem(1));
		addAllSingleInputBootsItem(new ItemStack(Material.DIAMOND), new DiamondBoots().createItem(1));
		addAllSingleInputBootsItem(new ItemStack(Material.NETHERITE_INGOT), new NetheriteBoots().createItem(1));
	}
	
	private void addBowItemRecipes() {
		addAll6InputsBowItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STRING),new ItemStack(Material.STRING),new ItemStack(Material.STRING),new Bow().createItem(1));
		addAll7InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STRING),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.TRIPWIRE_HOOK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STRING),new CrossBow().createItem(1));
		
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
