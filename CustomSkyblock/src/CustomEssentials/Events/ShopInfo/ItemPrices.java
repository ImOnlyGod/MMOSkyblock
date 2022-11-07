package CustomEssentials.Events.ShopInfo;

import java.util.HashMap;

import org.bukkit.Material;

public class ItemPrices {
	
	HashMap<Material,Float> itemBuyPrice = new HashMap<Material, Float>();
	HashMap<Material,Float> itemSellPrice = new HashMap<Material, Float>();
	HashMap<Integer,Integer> itemSlotPriceMultiplier = new HashMap<Integer, Integer>();

	public ItemPrices() {
		setItemBuyPrices();
		setItemSellPrices();
		setItemSlotPrice();
		
	}
	
	public void setItemBuyPrices() {
		
		this.itemBuyPrice.put(Material.STONE, (float) 25.0);
		this.itemBuyPrice.put(Material.COBBLESTONE, (float) 10.0);
		this.itemBuyPrice.put(Material.MOSSY_COBBLESTONE, (float) 50.0);
		this.itemBuyPrice.put(Material.GRANITE, (float) 30.0);
		this.itemBuyPrice.put(Material.DIORITE, (float) 30.0);
		this.itemBuyPrice.put(Material.ANDESITE, (float) 30.0);
		this.itemBuyPrice.put(Material.STONE_BRICKS, (float) 26.0);
		this.itemBuyPrice.put(Material.MOSSY_STONE_BRICKS, (float) 76.0);
		this.itemBuyPrice.put(Material.CRACKED_STONE_BRICKS, (float) 30.0);
		this.itemBuyPrice.put(Material.CHISELED_STONE_BRICKS, (float) 27.0);
		this.itemBuyPrice.put(Material.POLISHED_GRANITE, (float) 31.0);
		this.itemBuyPrice.put(Material.POLISHED_DIORITE, (float) 31.0);
		this.itemBuyPrice.put(Material.POLISHED_ANDESITE, (float) 31.0);
		this.itemBuyPrice.put(Material.DIRT, (float) 55.0);
		this.itemBuyPrice.put(Material.ROOTED_DIRT, (float) 75.0);
		this.itemBuyPrice.put(Material.GRASS_BLOCK, (float) 100.0);
		this.itemBuyPrice.put(Material.PODZOL, (float) 135.0);
		this.itemBuyPrice.put(Material.MYCELIUM, (float) 500.0);
		this.itemBuyPrice.put(Material.SAND, (float) 40.0);
		this.itemBuyPrice.put(Material.RED_SAND, (float) 65.0);
		this.itemBuyPrice.put(Material.SANDSTONE, (float) 160.0);
		this.itemBuyPrice.put(Material.RED_SANDSTONE, (float) 260.0);
		this.itemBuyPrice.put(Material.SMOOTH_SANDSTONE, (float) 161.0);
		this.itemBuyPrice.put(Material.SMOOTH_RED_SANDSTONE, (float) 261.0);
		this.itemBuyPrice.put(Material.CHISELED_SANDSTONE, (float) 161.0);
		this.itemBuyPrice.put(Material.CHISELED_RED_SANDSTONE, (float) 261.0);
		this.itemBuyPrice.put(Material.OAK_PLANKS, (float) 10.0);
		this.itemBuyPrice.put(Material.BIRCH_PLANKS, (float) 12.5);
		this.itemBuyPrice.put(Material.SPRUCE_PLANKS, (float) 15.0);
		this.itemBuyPrice.put(Material.DARK_OAK_PLANKS, (float) 20.0);
		this.itemBuyPrice.put(Material.JUNGLE_PLANKS, (float) 25.0);
		this.itemBuyPrice.put(Material.ACACIA_PLANKS, (float) 30.0);
		this.itemBuyPrice.put(Material.OAK_LOG, (float) 40.0);
		this.itemBuyPrice.put(Material.BIRCH_LOG, (float) 48.0);
		this.itemBuyPrice.put(Material.SPRUCE_LOG, (float) 60.0);
		this.itemBuyPrice.put(Material.DARK_OAK_LOG, (float) 80.0);
		this.itemBuyPrice.put(Material.JUNGLE_LOG, (float) 100.0);
		this.itemBuyPrice.put(Material.ACACIA_LOG, (float) 120.0);
		this.itemBuyPrice.put(Material.GRAVEL, (float) 20.0);
		this.itemBuyPrice.put(Material.CLAY, (float) 40.0);
		this.itemBuyPrice.put(Material.BRICKS, (float) 100.0);
		this.itemBuyPrice.put(Material.SNOW_BLOCK, (float) 15.0);
		this.itemBuyPrice.put(Material.ICE, (float) 35.0);
		this.itemBuyPrice.put(Material.PACKED_ICE, (float) 320.0);
		this.itemBuyPrice.put(Material.BLUE_ICE, (float) 2900.0);
		this.itemBuyPrice.put(Material.OBSIDIAN, (float) 1000.0);
		this.itemBuyPrice.put(Material.PRISMARINE, (float) 250.0);
		this.itemBuyPrice.put(Material.PRISMARINE_BRICKS, (float) 350.0);
		this.itemBuyPrice.put(Material.DARK_PRISMARINE, (float) 500.0);
		this.itemBuyPrice.put(Material.SEA_LANTERN, (float) 500.0);
		this.itemBuyPrice.put(Material.DEAD_TUBE_CORAL_BLOCK, (float) 10.0);
		this.itemBuyPrice.put(Material.DEAD_BRAIN_CORAL_BLOCK, (float) 10.0);
		this.itemBuyPrice.put(Material.DEAD_BUBBLE_CORAL_BLOCK, (float) 10.0);
		this.itemBuyPrice.put(Material.DEAD_FIRE_CORAL_BLOCK, (float) 10.0);
		this.itemBuyPrice.put(Material.DEAD_HORN_CORAL_BLOCK, (float) 10.0);
		this.itemBuyPrice.put(Material.TUBE_CORAL_BLOCK, (float) 200.0);
		this.itemBuyPrice.put(Material.BRAIN_CORAL_BLOCK, (float) 200.0);
		this.itemBuyPrice.put(Material.BUBBLE_CORAL_BLOCK, (float) 200.0);
		this.itemBuyPrice.put(Material.FIRE_CORAL_BLOCK, (float) 200.0);
		this.itemBuyPrice.put(Material.HORN_CORAL_BLOCK, (float) 200.0);
		this.itemBuyPrice.put(Material.NETHERRACK, (float) 5.0);
		this.itemBuyPrice.put(Material.CRIMSON_NYLIUM, (float) 100.0);
		this.itemBuyPrice.put(Material.WARPED_NYLIUM, (float) 100.0);
		this.itemBuyPrice.put(Material.NETHER_BRICKS, (float) 21.0);
		this.itemBuyPrice.put(Material.RED_NETHER_BRICKS, (float) 35.0);
		this.itemBuyPrice.put(Material.CRACKED_NETHER_BRICKS, (float) 36.0);
		this.itemBuyPrice.put(Material.CHISELED_NETHER_BRICKS, (float) 37.0);
		this.itemBuyPrice.put(Material.CRIMSON_PLANKS, (float) 45.0);
		this.itemBuyPrice.put(Material.WARPED_PLANKS, (float) 50.0);
		this.itemBuyPrice.put(Material.CRIMSON_STEM, (float) 150.0);
		this.itemBuyPrice.put(Material.WARPED_STEM, (float) 175.0);
		this.itemBuyPrice.put(Material.WARPED_HYPHAE, (float) 200.0);
		this.itemBuyPrice.put(Material.NETHER_WART_BLOCK, (float) 90.0);
		this.itemBuyPrice.put(Material.WARPED_WART_BLOCK, (float) 90.0);
		this.itemBuyPrice.put(Material.SOUL_SAND, (float) 300.0);
		this.itemBuyPrice.put(Material.MAGMA_BLOCK, (float) 500.0);
		this.itemBuyPrice.put(Material.GLOWSTONE, (float) 80.0);
		this.itemBuyPrice.put(Material.BONE_BLOCK, (float) 100.0);
		this.itemBuyPrice.put(Material.BLACKSTONE, (float) 80.0);
		this.itemBuyPrice.put(Material.POLISHED_BLACKSTONE, (float) 81.0);
		this.itemBuyPrice.put(Material.POLISHED_BLACKSTONE_BRICKS, (float) 160.0);
		this.itemBuyPrice.put(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, (float) 161.0);
		this.itemBuyPrice.put(Material.CRYING_OBSIDIAN, (float) 1300.0);
		this.itemBuyPrice.put(Material.QUARTZ_BLOCK, (float) 250.0);
		this.itemBuyPrice.put(Material.CHISELED_QUARTZ_BLOCK, (float) 251.0);
		this.itemBuyPrice.put(Material.QUARTZ_PILLAR, (float) 300.0);
		this.itemBuyPrice.put(Material.END_STONE, (float) 100.0);
		this.itemBuyPrice.put(Material.PURPUR_BLOCK, (float) 500.0);
		this.itemBuyPrice.put(Material.PURPUR_PILLAR, (float) 700.0);
		
		this.itemBuyPrice.put(Material.GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_BLUE_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_GRAY_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_STAINED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.TINTED_GLASS, (float) 0.0);
		this.itemBuyPrice.put(Material.TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_BLUE_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_GRAY_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_WOOL, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_BLUE_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_GRAY_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_GLAZED_TERRACOTTA, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_BLUE_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_GRAY_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_CONCRETE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGENTA_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_BLUE_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.YELLOW_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.LIME_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.GRAY_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHT_GRAY_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.CYAN_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.PURPLE_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.GREEN_CONCRETE, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_CONCRETE, (float) 0.0);
		
		this.itemBuyPrice.put(Material.TORCH, (float) 0.0);
		this.itemBuyPrice.put(Material.SOUL_TORCH, (float) 0.0);
		this.itemBuyPrice.put(Material.IRON_BARS, (float) 0.0);
		this.itemBuyPrice.put(Material.CHAIN, (float) 0.0);
		this.itemBuyPrice.put(Material.LILY_PAD, (float) 0.0);
		this.itemBuyPrice.put(Material.OAK_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.BIRCH_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.SPRUCE_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.DARK_OAK_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.JUNGLE_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.ACACIA_SAPLING, (float) 0.0);
		this.itemBuyPrice.put(Material.OAK_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.BIRCH_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.SPRUCE_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.DARK_OAK_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.JUNGLE_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.ACACIA_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.AZALEA_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.FLOWERING_AZALEA_LEAVES, (float) 0.0);
		this.itemBuyPrice.put(Material.GRASS, (float) 0.0);
		this.itemBuyPrice.put(Material.FERN, (float) 0.0);
		this.itemBuyPrice.put(Material.AZALEA, (float) 0.0);
		this.itemBuyPrice.put(Material.FLOWERING_AZALEA, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_BUSH, (float) 0.0);
		this.itemBuyPrice.put(Material.SEAGRASS, (float) 0.0);
		this.itemBuyPrice.put(Material.SEA_PICKLE, (float) 0.0);
		this.itemBuyPrice.put(Material.DANDELION, (float) 0.0);
		this.itemBuyPrice.put(Material.POPPY, (float) 0.0);
		this.itemBuyPrice.put(Material.BLUE_ORCHID, (float) 0.0);
		this.itemBuyPrice.put(Material.ALLIUM, (float) 0.0);
		this.itemBuyPrice.put(Material.AZURE_BLUET, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.PINK_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.OXEYE_DAISY, (float) 0.0);
		this.itemBuyPrice.put(Material.CORNFLOWER, (float) 0.0);
		this.itemBuyPrice.put(Material.LILY_OF_THE_VALLEY, (float) 0.0);
		this.itemBuyPrice.put(Material.WITHER_ROSE, (float) 0.0);
		this.itemBuyPrice.put(Material.SPORE_BLOSSOM, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.SUNFLOWER, (float) 0.0);
		this.itemBuyPrice.put(Material.LILAC, (float) 0.0);
		this.itemBuyPrice.put(Material.ROSE_BUSH, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.PEONY, (float) 0.0);
		this.itemBuyPrice.put(Material.TALL_GRASS, (float) 0.0);
		this.itemBuyPrice.put(Material.LARGE_FERN, (float) 0.0);		
		this.itemBuyPrice.put(Material.CRIMSON_ROOTS, (float) 0.0);
		this.itemBuyPrice.put(Material.WARPED_ROOTS, (float) 0.0);
		this.itemBuyPrice.put(Material.NETHER_SPROUTS, (float) 0.0);
		this.itemBuyPrice.put(Material.ORANGE_TULIP, (float) 0.0);
		this.itemBuyPrice.put(Material.MOSS_BLOCK, (float) 0.0);
		this.itemBuyPrice.put(Material.HANGING_ROOTS, (float) 0.0);
		this.itemBuyPrice.put(Material.BIG_DRIPLEAF, (float) 0.0);
		this.itemBuyPrice.put(Material.SMALL_DRIPLEAF, (float) 0.0);
		this.itemBuyPrice.put(Material.TUBE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.BUBBLE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.BRAIN_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.FIRE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.HORN_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_TUBE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_BUBBLE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_BRAIN_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_FIRE_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_HORN_CORAL, (float) 0.0);
		this.itemBuyPrice.put(Material.TUBE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.BUBBLE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.BRAIN_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.FIRE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.HORN_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_TUBE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_BUBBLE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_BRAIN_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_FIRE_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.DEAD_HORN_CORAL_FAN, (float) 0.0);
		this.itemBuyPrice.put(Material.SHROOMLIGHT, (float) 0.0);
		
		this.itemBuyPrice.put(Material.WHEAT_SEEDS, (float) 0.0);
		this.itemBuyPrice.put(Material.WHEAT, (float) 0.0);
		this.itemBuyPrice.put(Material.BEETROOT_SEEDS, (float) 0.0);
		this.itemBuyPrice.put(Material.BEETROOT, (float) 0.0);
		this.itemBuyPrice.put(Material.CARROT, (float) 0.0);
		this.itemBuyPrice.put(Material.POTATO, (float) 0.0);
		this.itemBuyPrice.put(Material.MELON_SEEDS, (float) 0.0);
		this.itemBuyPrice.put(Material.MELON_SLICE, (float) 0.0);
		this.itemBuyPrice.put(Material.PUMPKIN, (float) 0.0);
		this.itemBuyPrice.put(Material.NETHER_WART, (float) 0.0);
		this.itemBuyPrice.put(Material.SUGAR_CANE, (float) 0.0);
		this.itemBuyPrice.put(Material.CACTUS, (float) 0.0);
		this.itemBuyPrice.put(Material.BAMBOO, (float) 0.0);
		this.itemBuyPrice.put(Material.COCOA_BEANS, (float) 0.0);
		this.itemBuyPrice.put(Material.KELP, (float) 0.0);
		this.itemBuyPrice.put(Material.VINE, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOW_LICHEN, (float) 0.0);
		this.itemBuyPrice.put(Material.RED_MUSHROOM, (float) 0.0);
		this.itemBuyPrice.put(Material.BROWN_MUSHROOM, (float) 0.0);
		this.itemBuyPrice.put(Material.TWISTING_VINES, (float) 0.0);
		this.itemBuyPrice.put(Material.WEEPING_VINES, (float) 0.0);
		this.itemBuyPrice.put(Material.CRIMSON_FUNGUS, (float) 0.0);
		this.itemBuyPrice.put(Material.WARPED_FUNGUS, (float) 0.0);
		
		this.itemBuyPrice.put(Material.ROTTEN_FLESH, (float) 0.0);
		this.itemBuyPrice.put(Material.SPIDER_EYE, (float) 0.0);
		this.itemBuyPrice.put(Material.APPLE, (float) 0.0);
		this.itemBuyPrice.put(Material.GOLDEN_APPLE, (float) 0.0);
		this.itemBuyPrice.put(Material.ENCHANTED_GOLDEN_APPLE, (float) 0.0);
		this.itemBuyPrice.put(Material.MELON_SLICE, (float) 0.0);
		this.itemBuyPrice.put(Material.DRIED_KELP, (float) 0.0);
		this.itemBuyPrice.put(Material.SWEET_BERRIES, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOW_BERRIES, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKIE, (float) 0.0);
		this.itemBuyPrice.put(Material.BREAD, (float) 0.0);
		this.itemBuyPrice.put(Material.BEETROOT, (float) 0.0);
		this.itemBuyPrice.put(Material.POTATO, (float) 0.0);
		this.itemBuyPrice.put(Material.POISONOUS_POTATO, (float) 0.0);
		this.itemBuyPrice.put(Material.BAKED_POTATO, (float) 0.0);
		this.itemBuyPrice.put(Material.CARROT, (float) 0.0);
		this.itemBuyPrice.put(Material.GOLDEN_CARROT, (float) 0.0);
		this.itemBuyPrice.put(Material.CHICKEN, (float) 0.0);
		this.itemBuyPrice.put(Material.RABBIT, (float) 0.0);
		this.itemBuyPrice.put(Material.PORKCHOP, (float) 0.0);
		this.itemBuyPrice.put(Material.BEEF, (float) 0.0);
		this.itemBuyPrice.put(Material.MUTTON, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_CHICKEN, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_RABBIT, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_PORKCHOP, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_BEEF, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_MUTTON, (float) 0.0);
		this.itemBuyPrice.put(Material.SALMON, (float) 0.0);
		this.itemBuyPrice.put(Material.COD, (float) 0.0);
		this.itemBuyPrice.put(Material.TROPICAL_FISH, (float) 0.0);
		this.itemBuyPrice.put(Material.PUFFERFISH, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_SALMON, (float) 0.0);
		this.itemBuyPrice.put(Material.COOKED_COD, (float) 0.0);
		this.itemBuyPrice.put(Material.PUMPKIN_PIE, (float) 0.0);
		this.itemBuyPrice.put(Material.MUSHROOM_STEW, (float) 0.0);
		this.itemBuyPrice.put(Material.BEETROOT_SOUP, (float) 0.0);
		this.itemBuyPrice.put(Material.RABBIT_STEW, (float) 0.0);
		this.itemBuyPrice.put(Material.CAKE, (float) 0.0);
		this.itemBuyPrice.put(Material.HONEY_BOTTLE, (float) 0.0);
		this.itemBuyPrice.put(Material.CHORUS_FRUIT, (float) 0.0);
		
		this.itemBuyPrice.put(Material.ARROW, (float) 0.0);
		this.itemBuyPrice.put(Material.BONE, (float) 0.0);
		this.itemBuyPrice.put(Material.STRING, (float) 0.0);
		this.itemBuyPrice.put(Material.GUNPOWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOWSTONE_DUST, (float) 0.0);
		this.itemBuyPrice.put(Material.LEATHER, (float) 0.0);
		this.itemBuyPrice.put(Material.RABBIT_HIDE, (float) 0.0);
		this.itemBuyPrice.put(Material.FEATHER, (float) 0.0);
		this.itemBuyPrice.put(Material.SLIME_BALL, (float) 0.0);
		this.itemBuyPrice.put(Material.MAGMA_CREAM, (float) 0.0);
		this.itemBuyPrice.put(Material.INK_SAC, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOW_INK_SAC, (float) 0.0);
		this.itemBuyPrice.put(Material.ENDER_PEARL, (float) 0.0);
		this.itemBuyPrice.put(Material.BLAZE_ROD, (float) 0.0);
		this.itemBuyPrice.put(Material.GHAST_TEAR, (float) 0.0);
		this.itemBuyPrice.put(Material.POPPY, (float) 0.0);
		this.itemBuyPrice.put(Material.WITHER_ROSE, (float) 0.0);
		this.itemBuyPrice.put(Material.IRON_INGOT, (float) 0.0);
		this.itemBuyPrice.put(Material.GOLD_NUGGET, (float) 0.0);
		this.itemBuyPrice.put(Material.GOLD_INGOT, (float) 0.0);
		this.itemBuyPrice.put(Material.EMERALD, (float) 0.0);
		this.itemBuyPrice.put(Material.PRISMARINE_CRYSTALS, (float) 0.0);
		this.itemBuyPrice.put(Material.PRISMARINE_SHARD, (float) 0.0);
		this.itemBuyPrice.put(Material.PHANTOM_MEMBRANE, (float) 0.0);
		this.itemBuyPrice.put(Material.WITHER_SKELETON_SKULL, (float) 0.0);	
		
		this.itemBuyPrice.put(Material.COAL, (float) 0.0);
		this.itemBuyPrice.put(Material.RAW_IRON, (float) 0.0);
		this.itemBuyPrice.put(Material.RAW_COPPER, (float) 0.0);
		this.itemBuyPrice.put(Material.COPPER_INGOT, (float) 0.0);
		this.itemBuyPrice.put(Material.LAPIS_LAZULI, (float) 0.0);
		this.itemBuyPrice.put(Material.REDSTONE, (float) 0.0);
		this.itemBuyPrice.put(Material.RAW_GOLD, (float) 0.0);
		this.itemBuyPrice.put(Material.DIAMOND, (float) 0.0);
		this.itemBuyPrice.put(Material.NETHERITE_SCRAP, (float) 0.0);
		this.itemBuyPrice.put(Material.NETHERITE_INGOT, (float) 0.0);
		
		this.itemBuyPrice.put(Material.REDSTONE_TORCH, (float) 0.0);
		this.itemBuyPrice.put(Material.REDSTONE_BLOCK, (float) 0.0);
		this.itemBuyPrice.put(Material.REPEATER, (float) 0.0);
		this.itemBuyPrice.put(Material.COMPARATOR, (float) 0.0);
		this.itemBuyPrice.put(Material.PISTON, (float) 0.0);
		this.itemBuyPrice.put(Material.STICKY_PISTON, (float) 0.0);
		this.itemBuyPrice.put(Material.SLIME_BLOCK, (float) 0.0);
		this.itemBuyPrice.put(Material.HONEY_BLOCK, (float) 0.0);
		this.itemBuyPrice.put(Material.OBSERVER, (float) 0.0);
		this.itemBuyPrice.put(Material.HOPPER, (float) 0.0);
		this.itemBuyPrice.put(Material.MINECART, (float) 0.0);
		this.itemBuyPrice.put(Material.RAIL, (float) 0.0);
		this.itemBuyPrice.put(Material.POWERED_RAIL, (float) 0.0);
		this.itemBuyPrice.put(Material.DETECTOR_RAIL, (float) 0.0);
		this.itemBuyPrice.put(Material.ACTIVATOR_RAIL, (float) 0.0);
		this.itemBuyPrice.put(Material.DISPENSER, (float) 0.0);
		this.itemBuyPrice.put(Material.DROPPER, (float) 0.0);
		this.itemBuyPrice.put(Material.LEVER, (float) 0.0);
		this.itemBuyPrice.put(Material.STONE_BUTTON, (float) 0.0);
		this.itemBuyPrice.put(Material.STONE_PRESSURE_PLATE, (float) 0.0);
		this.itemBuyPrice.put(Material.LECTERN, (float) 0.0);
		this.itemBuyPrice.put(Material.TARGET, (float) 0.0);
		this.itemBuyPrice.put(Material.LIGHTNING_ROD, (float) 0.0);
		this.itemBuyPrice.put(Material.DAYLIGHT_DETECTOR, (float) 0.0);
		this.itemBuyPrice.put(Material.TRIPWIRE_HOOK, (float) 0.0);
		this.itemBuyPrice.put(Material.CHEST, (float) 0.0);
		this.itemBuyPrice.put(Material.TRAPPED_CHEST, (float) 0.0);
		this.itemBuyPrice.put(Material.TNT, (float) 0.0);
		this.itemBuyPrice.put(Material.REDSTONE_LAMP, (float) 0.0);
		this.itemBuyPrice.put(Material.NOTE_BLOCK, (float) 0.0);
		this.itemBuyPrice.put(Material.IRON_TRAPDOOR, (float) 0.0);
		
		this.itemBuyPrice.put(Material.ENCHANTING_TABLE, (float) 0.0);
		this.itemBuyPrice.put(Material.ENDER_CHEST, (float) 0.0);
		this.itemBuyPrice.put(Material.JUKEBOX, (float) 0.0);
		this.itemBuyPrice.put(Material.ANVIL, (float) 0.0);
		this.itemBuyPrice.put(Material.PAINTING, (float) 0.0);
		this.itemBuyPrice.put(Material.ITEM_FRAME, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOW_ITEM_FRAME, (float) 0.0);
		this.itemBuyPrice.put(Material.FLOWER_POT, (float) 0.0);
		this.itemBuyPrice.put(Material.ARMOR_STAND, (float) 0.0);
		this.itemBuyPrice.put(Material.WHITE_BANNER, (float) 0.0);
		this.itemBuyPrice.put(Material.LOOM, (float) 0.0);
		this.itemBuyPrice.put(Material.COMPOSTER, (float) 0.0);
		this.itemBuyPrice.put(Material.BARREL, (float) 0.0);
		this.itemBuyPrice.put(Material.FURNACE, (float) 0.0);
		this.itemBuyPrice.put(Material.SMOKER, (float) 0.0);
		this.itemBuyPrice.put(Material.BLAST_FURNACE, (float) 0.0);
		this.itemBuyPrice.put(Material.CARTOGRAPHY_TABLE, (float) 0.0);
		this.itemBuyPrice.put(Material.FLETCHING_TABLE, (float) 0.0);
		this.itemBuyPrice.put(Material.GRINDSTONE, (float) 0.0);
		this.itemBuyPrice.put(Material.SMITHING_TABLE, (float) 0.0);
		this.itemBuyPrice.put(Material.STONECUTTER, (float) 0.0);
		this.itemBuyPrice.put(Material.BELL, (float) 0.0);
		this.itemBuyPrice.put(Material.BEE_NEST, (float) 0.0);
		this.itemBuyPrice.put(Material.BEEHIVE, (float) 0.0);
		this.itemBuyPrice.put(Material.LODESTONE, (float) 0.0);
		this.itemBuyPrice.put(Material.RESPAWN_ANCHOR, (float) 0.0);
		this.itemBuyPrice.put(Material.CANDLE, (float) 0.0);
		this.itemBuyPrice.put(Material.POINTED_DRIPSTONE, (float) 0.0);
		this.itemBuyPrice.put(Material.SCAFFOLDING, (float) 0.0);
		this.itemBuyPrice.put(Material.BUCKET, (float) 0.0);
		this.itemBuyPrice.put(Material.WATER_BUCKET, (float) 0.0);
		this.itemBuyPrice.put(Material.LAVA_BUCKET, (float) 0.0);
		this.itemBuyPrice.put(Material.POWDER_SNOW_BUCKET, (float) 0.0);
		this.itemBuyPrice.put(Material.NAME_TAG, (float) 0.0);
		this.itemBuyPrice.put(Material.BOOK, (float) 0.0);
		
		this.itemBuyPrice.put(Material.BREWING_STAND, (float) 0.0);
		this.itemBuyPrice.put(Material.CAULDRON, (float) 0.0);
		this.itemBuyPrice.put(Material.POTION, (float) 0.0);
		this.itemBuyPrice.put(Material.BLAZE_POWDER, (float) 0.0);
		this.itemBuyPrice.put(Material.GLOWSTONE_DUST, (float) 0.0);
		this.itemBuyPrice.put(Material.SUGAR, (float) 0.0);
		this.itemBuyPrice.put(Material.FERMENTED_SPIDER_EYE, (float) 0.0);
		this.itemBuyPrice.put(Material.GLISTERING_MELON_SLICE, (float) 0.0);
	}
	
	public void setItemSellPrices() {
		this.itemSellPrice.put(Material.STONE, (float) 0.0);
		this.itemSellPrice.put(Material.COBBLESTONE, (float) 0.0);
		this.itemSellPrice.put(Material.DIRT, (float) 0.0);
		this.itemSellPrice.put(Material.GRASS_BLOCK, (float) 0.0);
	}
	
	public void setItemSlotPrice() {
		this.itemSlotPriceMultiplier.put(10, 1);
		this.itemSlotPriceMultiplier.put(11, 8);
		this.itemSlotPriceMultiplier.put(12, 16);
		this.itemSlotPriceMultiplier.put(13, 32);
		this.itemSlotPriceMultiplier.put(14, 64);
		this.itemSlotPriceMultiplier.put(15, 128);
		this.itemSlotPriceMultiplier.put(16, 256);
		this.itemSlotPriceMultiplier.put(20, 512);
		this.itemSlotPriceMultiplier.put(21, 1024);
		this.itemSlotPriceMultiplier.put(22, 1536);
		this.itemSlotPriceMultiplier.put(23, 2048);
		this.itemSlotPriceMultiplier.put(24, 2304);
	}
	
	public HashMap<Integer, Integer> getItemSlotPriceMultiplier() {
		return itemSlotPriceMultiplier;
	}

	public void setItemSlotPriceMultiplier(HashMap<Integer, Integer> itemSlotPriceMultiplier) {
		this.itemSlotPriceMultiplier = itemSlotPriceMultiplier;
	}

	public HashMap<Material, Float> getItemBuyPrice() {
		return itemBuyPrice;
	}

	public void setItemBuyPrice(HashMap<Material, Float> itemBuyPrice) {
		this.itemBuyPrice = itemBuyPrice;
	}

	public HashMap<Material, Float> getItemSellPrice() {
		return itemSellPrice;
	}

	public void setItemSellPrice(HashMap<Material, Float> itemSellPrice) {
		this.itemSellPrice = itemSellPrice;
	}
	
	
	
	
}
