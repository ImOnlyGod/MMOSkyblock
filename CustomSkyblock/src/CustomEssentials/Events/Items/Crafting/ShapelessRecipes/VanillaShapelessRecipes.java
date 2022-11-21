package CustomEssentials.Events.Items.Crafting.ShapelessRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapelessRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapelessRecipes() {
		addSingleItemRecipes();
		addDoubleItemRecipes();		
		addTripleItemRecipes();
		addQuadItemRecipes();
	}
	
	public void addAllSlotInputSingleItem(ItemStack inputItem, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem.getType(),inputItem.getAmount());
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSlotInputDoubleItem(ItemStack inputItem1, ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				for (int k=0;k<4;k++) {
					for (int l=0;l<4;l++) {
						
						if (i==k && j==l) continue;
						
						ItemStack[][] inputItems = new ItemStack[4][4];
						ItemStack[][] resultItems = new ItemStack[2][2];
						inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
						inputItems[k][l] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
						
						resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
						resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
						resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
						resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
						recipeOutput.put(inputItems, resultItems);
						
						
					}					
				}
			}
		}
	}
	
public void addAllSlotInputTripleItem(ItemStack inputItem1, ItemStack inputItem2, ItemStack inputItem3, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				for (int k=0;k<4;k++) {
					for (int l=0;l<4;l++) {
						for (int m=0;m<4;m++) {
							for (int n=0;n<4;n++) {
								
								if ((i==k && j==l) || (i==m && j==n) || (k==m && l==n)) continue;
								
								ItemStack[][] inputItems = new ItemStack[4][4];
								ItemStack[][] resultItems = new ItemStack[2][2];
								inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
								inputItems[k][l] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
								inputItems[m][n] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
								
								resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
								resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
								resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
								resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
								recipeOutput.put(inputItems, resultItems);
								
								
							}					
						}
					}					
				}
			}
		}
	}

public void addAllSlotInputQuadItem(ItemStack inputItem1, ItemStack inputItem2, ItemStack inputItem3, ItemStack inputItem4, ItemStack outputItem) {
	
	for (int i=0;i<4;i++) {
		for (int j=0;j<4;j++) {
			for (int k=0;k<4;k++) {
				for (int l=0;l<4;l++) {
					for (int m=0;m<4;m++) {
						for (int n=0;n<4;n++) {
							for (int o=0;o<4;o++) {
								for (int p=0;p<4;p++) {
									
									if ((i==k && j==l) || (i==m && j==n) || (i==o && j==p) || (k==m && l==n)
											|| (k==o && l==p) || (m==o && n==p)) continue;
									
									ItemStack[][] inputItems = new ItemStack[4][4];
									ItemStack[][] resultItems = new ItemStack[2][2];
									inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
									inputItems[k][l] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
									inputItems[m][n] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
									inputItems[o][p] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
									
									resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
									resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
									resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
									resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
									recipeOutput.put(inputItems, resultItems);
									
									
								}					
							}
						}					
					}
				}					
			}
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
		addAllSlotInputSingleItem(new ItemStack(Material.CRIMSON_STEM), new ItemStack(Material.CRIMSON_PLANKS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.WARPED_STEM), new ItemStack(Material.WARPED_PLANKS,4));
		
		addAllSlotInputSingleItem(new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.BIRCH_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.SPRUCE_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.DARK_OAK_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.ACACIA_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.JUNGLE_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.CRIMSON_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.WARPED_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.STONE), new ItemStack(Material.STONE_BUTTON,1));
		addAllSlotInputSingleItem(new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.POLISHED_BLACKSTONE_BUTTON,1));
		
		addAllSlotInputSingleItem(new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL,9));
		addAllSlotInputSingleItem(new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_INGOT,9));
		addAllSlotInputSingleItem(new ItemStack(Material.COPPER_BLOCK), new ItemStack(Material.COPPER_INGOT,9));
		addAllSlotInputSingleItem(new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_LAZULI,9));
		addAllSlotInputSingleItem(new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.REDSTONE,9));
		addAllSlotInputSingleItem(new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.GOLD_INGOT,9));
		addAllSlotInputSingleItem(new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(Material.DIAMOND,9));
		addAllSlotInputSingleItem(new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD,9));
		addAllSlotInputSingleItem(new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_INGOT,9));
		addAllSlotInputSingleItem(new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_NUGGET,9));
		
		addAllSlotInputSingleItem(new ItemStack(Material.PUMPKIN), new ItemStack(Material.PUMPKIN_SEEDS,4));
		addAllSlotInputSingleItem(new ItemStack(Material.SUGAR_CANE), new ItemStack(Material.SUGAR,1));
		addAllSlotInputSingleItem(new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.BLAZE_POWDER,2));
		addAllSlotInputSingleItem(new ItemStack(Material.BONE), new ItemStack(Material.BONE_MEAL,3));
		
		addAllSlotInputSingleItem(new ItemStack(Material.POPPY), new ItemStack(Material.RED_DYE,2));
		addAllSlotInputSingleItem(new ItemStack(Material.RED_TULIP), new ItemStack(Material.RED_DYE,2));
		addAllSlotInputSingleItem(new ItemStack(Material.ROSE_BUSH), new ItemStack(Material.RED_DYE,2));
		addAllSlotInputSingleItem(new ItemStack(Material.BEETROOT), new ItemStack(Material.RED_DYE,1));
		addAllSlotInputSingleItem(new ItemStack(Material.DANDELION), new ItemStack(Material.YELLOW_DYE,2));
		
		
	}
	
	private void addDoubleItemRecipes() {
		addAllSlotInputDoubleItem(new ItemStack(Material.IRON_INGOT), new ItemStack(Material.FLINT),new ItemStack(Material.FLINT_AND_STEEL));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_DYE),new ItemStack(Material.WHITE_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.LIGHT_GRAY_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAY_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.BLACK_DYE),new ItemStack(Material.BLACK_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.BROWN_DYE),new ItemStack(Material.BROWN_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.RED_DYE),new ItemStack(Material.RED_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.ORANGE_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.YELLOW_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.LIME_DYE),new ItemStack(Material.LIME_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GREEN_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.CYAN_DYE),new ItemStack(Material.CYAN_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.LIGHT_BLUE_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.BLUE_DYE),new ItemStack(Material.BLUE_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.PURPLE_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.MAGENTA_WOOL));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.PINK_DYE),new ItemStack(Material.PINK_WOOL));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.WHITE_DYE),new ItemStack(Material.WHITE_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.LIGHT_GRAY_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAY_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.BLACK_DYE),new ItemStack(Material.BLACK_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.BROWN_DYE),new ItemStack(Material.BROWN_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.RED_DYE),new ItemStack(Material.RED_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.ORANGE_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.YELLOW_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.LIME_DYE),new ItemStack(Material.LIME_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GREEN_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.CYAN_DYE),new ItemStack(Material.CYAN_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.LIGHT_BLUE_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.BLUE_DYE),new ItemStack(Material.BLUE_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.PURPLE_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.MAGENTA_CONCRETE));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.PINK_DYE),new ItemStack(Material.PINK_CONCRETE));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.WHITE_DYE),new ItemStack(Material.WHITE_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAY_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.BLACK_DYE),new ItemStack(Material.BLACK_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.BROWN_DYE),new ItemStack(Material.BROWN_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.RED_DYE),new ItemStack(Material.RED_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.ORANGE_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.YELLOW_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.LIME_DYE),new ItemStack(Material.LIME_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GREEN_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.CYAN_DYE),new ItemStack(Material.CYAN_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.BLUE_DYE),new ItemStack(Material.BLUE_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.PURPLE_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.MAGENTA_CONCRETE_POWDER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.PINK_DYE),new ItemStack(Material.PINK_CONCRETE_POWDER));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.WHITE_DYE),new ItemStack(Material.WHITE_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.LIGHT_GRAY_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAY_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.BLACK_DYE),new ItemStack(Material.BLACK_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.BROWN_DYE),new ItemStack(Material.BROWN_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.RED_DYE),new ItemStack(Material.RED_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.ORANGE_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.YELLOW_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.LIME_DYE),new ItemStack(Material.LIME_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GREEN_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.CYAN_DYE),new ItemStack(Material.CYAN_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.LIGHT_BLUE_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.BLUE_DYE),new ItemStack(Material.BLUE_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.PURPLE_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.MAGENTA_TERRACOTTA));
		addAllSlotInputDoubleItem(new ItemStack(Material.TERRACOTTA), new ItemStack(Material.PINK_DYE),new ItemStack(Material.PINK_TERRACOTTA));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.WHITE_DYE),new ItemStack(Material.WHITE_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAY_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.BLACK_DYE),new ItemStack(Material.BLACK_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.BROWN_DYE),new ItemStack(Material.BROWN_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.RED_DYE),new ItemStack(Material.RED_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.ORANGE_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.YELLOW_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.LIME_DYE),new ItemStack(Material.LIME_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GREEN_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.CYAN_DYE),new ItemStack(Material.CYAN_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.BLUE_DYE),new ItemStack(Material.BLUE_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.PURPLE_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.MAGENTA_STAINED_GLASS));
		addAllSlotInputDoubleItem(new ItemStack(Material.GLASS), new ItemStack(Material.PINK_DYE),new ItemStack(Material.PINK_STAINED_GLASS));
		
		
		addAllSlotInputDoubleItem(new ItemStack(Material.COPPER_BLOCK), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_COPPER_BLOCK));
		addAllSlotInputDoubleItem(new ItemStack(Material.EXPOSED_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_EXPOSED_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WEATHERED_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_WEATHERED_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.OXIDIZED_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_OXIDIZED_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.CUT_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_CUT_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.EXPOSED_CUT_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.WEATHERED_CUT_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.OXIDIZED_CUT_COPPER), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER));
		addAllSlotInputDoubleItem(new ItemStack(Material.CUT_COPPER_SLAB), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_CUT_COPPER_SLAB));
		addAllSlotInputDoubleItem(new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_SLAB));
		addAllSlotInputDoubleItem(new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_SLAB));
		addAllSlotInputDoubleItem(new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB));
		addAllSlotInputDoubleItem(new ItemStack(Material.CUT_COPPER_STAIRS), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_CUT_COPPER_STAIRS));
		addAllSlotInputDoubleItem(new ItemStack(Material.EXPOSED_CUT_COPPER_STAIRS), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_STAIRS));
		addAllSlotInputDoubleItem(new ItemStack(Material.WEATHERED_CUT_COPPER_STAIRS), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_STAIRS));
		addAllSlotInputDoubleItem(new ItemStack(Material.OXIDIZED_CUT_COPPER_STAIRS), new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS));
		
		addAllSlotInputDoubleItem(new ItemStack(Material.COBBLESTONE), new ItemStack(Material.VINE),new ItemStack(Material.MOSSY_COBBLESTONE));
		addAllSlotInputDoubleItem(new ItemStack(Material.COBBLESTONE), new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.MOSSY_COBBLESTONE));
		addAllSlotInputDoubleItem(new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.VINE),new ItemStack(Material.MOSSY_STONE_BRICKS));
		addAllSlotInputDoubleItem(new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.MOSSY_STONE_BRICKS));
		addAllSlotInputDoubleItem(new ItemStack(Material.STONE_BRICK_SLAB), new ItemStack(Material.STONE_BRICK_SLAB),new ItemStack(Material.CHISELED_STONE_BRICKS));
		addAllSlotInputDoubleItem(new ItemStack(Material.COBBLED_DEEPSLATE_SLAB), new ItemStack(Material.COBBLED_DEEPSLATE_SLAB),new ItemStack(Material.CHISELED_DEEPSLATE));
		
		
	}

	private void addTripleItemRecipes() {
		addAllSlotInputTripleItem(new ItemStack(Material.BOOK), new ItemStack(Material.FEATHER),new ItemStack(Material.INK_SAC),new ItemStack(Material.WRITABLE_BOOK));
	}
	
	private void addQuadItemRecipes() {
		addAllSlotInputQuadItem(new ItemStack(Material.PAPER), new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.LEATHER),new ItemStack(Material.BOOK));
	}

	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
