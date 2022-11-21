package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapedRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapedRecipes() {
		addDoubleItemRecipes();
		addTripleItemRecipes();
		addQuadItemRecipes();
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
	
	public void addAllTripleInputSlabItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllQuadInputCubeItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
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
		
		addAllDoubleInputHorizontalItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIGHT_GRAY_WOOL), new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GRAY_WOOL), new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BROWN_WOOL), new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.RED_WOOL), new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIME_WOOL), new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.CYAN_WOOL), new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIGHT_BLUE_WOOL), new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BLUE_WOOL), new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.PURPLE_WOOL), new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.MAGENTA_WOOL), new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.PINK_WOOL), new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_CARPET,3));
		
		addAllDoubleInputVerticalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.STICK,4));
		
		addAllDoubleInputVerticalItem(new ItemStack(Material.COAL),new ItemStack(Material.STICK), new ItemStack(Material.TORCH,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.REDSTONE),new ItemStack(Material.STICK), new ItemStack(Material.REDSTONE_TORCH,1));
		addAllDoubleInputVerticalItem(new ItemStack(Material.BLAZE_ROD),new ItemStack(Material.POPPED_CHORUS_FRUIT), new ItemStack(Material.END_ROD,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.STICK),new ItemStack(Material.COBBLESTONE), new ItemStack(Material.LEVER));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SANDSTONE_SLAB),new ItemStack(Material.SANDSTONE_SLAB), new ItemStack(Material.CHISELED_SANDSTONE));
		addAllDoubleInputVerticalItem(new ItemStack(Material.RED_SANDSTONE_SLAB),new ItemStack(Material.RED_SANDSTONE_SLAB), new ItemStack(Material.CHISELED_RED_SANDSTONE));
		addAllDoubleInputVerticalItem(new ItemStack(Material.PURPUR_SLAB),new ItemStack(Material.PURPUR_SLAB), new ItemStack(Material.PURPUR_PILLAR));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CARVED_PUMPKIN),new ItemStack(Material.TORCH), new ItemStack(Material.JACK_O_LANTERN));
		addAllDoubleInputVerticalItem(new ItemStack(Material.QUARTZ_SLAB),new ItemStack(Material.QUARTZ_SLAB), new ItemStack(Material.CHISELED_QUARTZ_BLOCK));
		addAllDoubleInputVerticalItem(new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_PILLAR,2));
		addAllDoubleInputVerticalItem(new ItemStack(Material.NETHER_BRICK_SLAB),new ItemStack(Material.NETHER_BRICK_SLAB), new ItemStack(Material.CHISELED_NETHER_BRICKS));
		
	}
	
	private void addTripleItemRecipes() {
		
		addAllTripleInputSlabItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILE_SLAB,6));
		
	}
	
	private void addQuadItemRecipes() {
		addAllQuadInputCubeItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		
		addAllQuadInputCubeItem(new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.BIRCH_LOG), new ItemStack(Material.BIRCH_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SPRUCE_LOG), new ItemStack(Material.SPRUCE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.JUNGLE_LOG), new ItemStack(Material.JUNGLE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.ACACIA_LOG), new ItemStack(Material.ACACIA_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.CRIMSON_STEM), new ItemStack(Material.CRIMSON_HYPHAE,3));
		addAllQuadInputCubeItem(new ItemStack(Material.WARPED_STEM),new ItemStack(Material.WARPED_STEM), new ItemStack(Material.WARPED_HYPHAE,3));
		
		addAllQuadInputCubeItem(new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.SNOWBALL),new ItemStack(Material.SNOWBALL),new ItemStack(Material.SNOW_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.CLAY_BALL),new ItemStack(Material.CLAY_BALL),new ItemStack(Material.CLAY));
		addAllQuadInputCubeItem(new ItemStack(Material.BRICK),new ItemStack(Material.BRICK),new ItemStack(Material.BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SANDSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE,4));	
		addAllQuadInputCubeItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE_BRICKS,4));
		addAllQuadInputCubeItem(new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BRICKS,4));
		addAllQuadInputCubeItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.POLISHED_GRANITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.POLISHED_ANDESITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.POLISHED_DIORITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE));
		addAllQuadInputCubeItem(new ItemStack(Material.DIRT),new ItemStack(Material.GRAVEL),new ItemStack(Material.COARSE_DIRT,4));
		addAllQuadInputCubeItem(new ItemStack(Material.RED_SAND),new ItemStack(Material.RED_SAND),new ItemStack(Material.RED_SANDSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.POPPED_CHORUS_FRUIT),new ItemStack(Material.POPPED_CHORUS_FRUIT),new ItemStack(Material.PURPUR_PILLAR,4));
		addAllQuadInputCubeItem(new ItemStack(Material.MAGMA_CREAM),new ItemStack(Material.MAGMA_CREAM),new ItemStack(Material.MAGMA_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.NETHER_WART),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.RED_NETHER_BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.HONEY_BOTTLE),new ItemStack(Material.HONEY_BOTTLE),new ItemStack(Material.HONEY_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.HONEYCOMB),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.HONEYCOMB_BLOCK));
		
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_OAK_LOG),new ItemStack(Material.STRIPPED_OAK_LOG),new ItemStack(Material.STRIPPED_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_BIRCH_LOG),new ItemStack(Material.STRIPPED_BIRCH_LOG), new ItemStack(Material.STRIPPED_BIRCH_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_SPRUCE_LOG),new ItemStack(Material.STRIPPED_SPRUCE_LOG), new ItemStack(Material.STRIPPED_SPRUCE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_DARK_OAK_LOG),new ItemStack(Material.STRIPPED_DARK_OAK_LOG), new ItemStack(Material.STRIPPED_DARK_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_JUNGLE_LOG),new ItemStack(Material.STRIPPED_JUNGLE_LOG), new ItemStack(Material.STRIPPED_JUNGLE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_ACACIA_LOG),new ItemStack(Material.STRIPPED_ACACIA_LOG), new ItemStack(Material.STRIPPED_ACACIA_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_CRIMSON_STEM),new ItemStack(Material.STRIPPED_CRIMSON_STEM), new ItemStack(Material.STRIPPED_CRIMSON_HYPHAE,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_WARPED_STEM),new ItemStack(Material.STRIPPED_WARPED_STEM), new ItemStack(Material.STRIPPED_WARPED_HYPHAE,3));
		
		
		
	}
	
	

	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
