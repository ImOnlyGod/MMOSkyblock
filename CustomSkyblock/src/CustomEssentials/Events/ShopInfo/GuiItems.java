package CustomEssentials.Events.ShopInfo;

import java.util.ArrayList;

import org.bukkit.Material;

public class GuiItems {
	
	ArrayList<Material> blocks = new ArrayList<Material>();
	ArrayList<Material> colorBlocks = new ArrayList<Material>();
	ArrayList<Material> decorativeBlocks = new ArrayList<Material>();
	ArrayList<Material> farming = new ArrayList<Material>();
	ArrayList<Material> foods = new ArrayList<Material>();
	ArrayList<Material> misc = new ArrayList<Material>();
	ArrayList<Material> gems = new ArrayList<Material>();
	ArrayList<Material> mobDrops = new ArrayList<Material>();
	ArrayList<Material> redstone = new ArrayList<Material>();
	ArrayList<Material> brewing = new ArrayList<Material>();
	
	public GuiItems() {
		setBlocksItems();
		setColorBlocksItems();
		setFarmingItems();
		setGemsItems();
	}
	
	public void setBlocksItems() {
		this.blocks.add(Material.STONE);
		this.blocks.add(Material.COBBLESTONE);
		this.blocks.add(Material.MOSSY_COBBLESTONE);
		this.blocks.add(Material.GRANITE);
		this.blocks.add(Material.DIORITE);
		this.blocks.add(Material.ANDESITE);
		this.blocks.add(Material.STONE_BRICKS);
		this.blocks.add(Material.MOSSY_STONE_BRICKS);
		this.blocks.add(Material.CRACKED_STONE_BRICKS);
		this.blocks.add(Material.CHISELED_STONE_BRICKS);
		this.blocks.add(Material.POLISHED_GRANITE);
		this.blocks.add(Material.POLISHED_DIORITE);
		this.blocks.add(Material.POLISHED_ANDESITE);
		this.blocks.add(Material.DIRT);
		this.blocks.add(Material.ROOTED_DIRT);
		this.blocks.add(Material.GRASS_BLOCK);
		this.blocks.add(Material.PODZOL);
		this.blocks.add(Material.MYCELIUM);
		this.blocks.add(Material.SAND);
		this.blocks.add(Material.RED_SAND);
		this.blocks.add(Material.SANDSTONE);
		this.blocks.add(Material.RED_SANDSTONE);
		this.blocks.add(Material.SMOOTH_SANDSTONE);
		this.blocks.add(Material.SMOOTH_RED_SANDSTONE);
		this.blocks.add(Material.CHISELED_SANDSTONE);
		this.blocks.add(Material.CHISELED_RED_SANDSTONE);
		this.blocks.add(Material.OAK_PLANKS);
		this.blocks.add(Material.BIRCH_PLANKS);
		this.blocks.add(Material.SPRUCE_PLANKS);
		this.blocks.add(Material.DARK_OAK_PLANKS);
		this.blocks.add(Material.JUNGLE_PLANKS);
		this.blocks.add(Material.ACACIA_PLANKS);
		this.blocks.add(Material.OAK_LOG);
		this.blocks.add(Material.BIRCH_LOG);
		this.blocks.add(Material.SPRUCE_LOG);
		this.blocks.add(Material.DARK_OAK_LOG);
		this.blocks.add(Material.JUNGLE_LOG);
		this.blocks.add(Material.ACACIA_LOG);
		this.blocks.add(Material.GRAVEL);
		this.blocks.add(Material.CLAY);
		this.blocks.add(Material.BRICKS);
		this.blocks.add(Material.SNOW_BLOCK);
		this.blocks.add(Material.ICE);
		this.blocks.add(Material.PACKED_ICE);
		this.blocks.add(Material.BLUE_ICE);
		this.blocks.add(Material.OBSIDIAN);
		this.blocks.add(Material.PRISMARINE);
		this.blocks.add(Material.PRISMARINE_BRICKS);
		this.blocks.add(Material.DARK_PRISMARINE);
		this.blocks.add(Material.SEA_LANTERN);
		this.blocks.add(Material.DEAD_TUBE_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_BRAIN_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_BUBBLE_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_FIRE_CORAL_BLOCK);
		this.blocks.add(Material.TUBE_CORAL_BLOCK);
		this.blocks.add(Material.BRAIN_CORAL_BLOCK);
		this.blocks.add(Material.BUBBLE_CORAL_BLOCK);
		this.blocks.add(Material.FIRE_CORAL_BLOCK);
		this.blocks.add(Material.NETHERRACK);
		this.blocks.add(Material.CRIMSON_NYLIUM);
		this.blocks.add(Material.WARPED_NYLIUM);
		this.blocks.add(Material.NETHER_BRICKS);
		this.blocks.add(Material.RED_NETHER_BRICKS);
		this.blocks.add(Material.CRACKED_NETHER_BRICKS);
		this.blocks.add(Material.CHISELED_NETHER_BRICKS);
		this.blocks.add(Material.CRIMSON_PLANKS);
		this.blocks.add(Material.WARPED_PLANKS);
		this.blocks.add(Material.CRIMSON_STEM);
		this.blocks.add(Material.WARPED_STEM);
		this.blocks.add(Material.WARPED_HYPHAE);
		this.blocks.add(Material.NETHER_WART_BLOCK);
		this.blocks.add(Material.WARPED_WART_BLOCK);
		this.blocks.add(Material.SOUL_SAND);
		this.blocks.add(Material.MAGMA_BLOCK);
		this.blocks.add(Material.GLOWSTONE);
		this.blocks.add(Material.BONE_BLOCK);
		this.blocks.add(Material.BLACKSTONE);
		this.blocks.add(Material.POLISHED_BLACKSTONE);
		this.blocks.add(Material.POLISHED_BLACKSTONE_BRICKS);
		this.blocks.add(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
		this.blocks.add(Material.CRYING_OBSIDIAN);
		this.blocks.add(Material.QUARTZ_BLOCK);
		this.blocks.add(Material.CHISELED_QUARTZ_BLOCK);
		this.blocks.add(Material.QUARTZ_PILLAR);
		this.blocks.add(Material.DEAD_TUBE_CORAL_BLOCK);
		this.blocks.add(Material.END_STONE);
		this.blocks.add(Material.PURPUR_BLOCK);
		this.blocks.add(Material.PURPUR_PILLAR);
	}
	
	public void setColorBlocksItems() {
		this.colorBlocks.add(Material.GLASS);
		this.colorBlocks.add(Material.WHITE_STAINED_GLASS);
		this.colorBlocks.add(Material.ORANGE_STAINED_GLASS);
		this.colorBlocks.add(Material.MAGENTA_STAINED_GLASS);
		this.colorBlocks.add(Material.LIGHT_BLUE_STAINED_GLASS);
		this.colorBlocks.add(Material.YELLOW_STAINED_GLASS);
		this.colorBlocks.add(Material.LIME_STAINED_GLASS);
		this.colorBlocks.add(Material.PINK_STAINED_GLASS);
		this.colorBlocks.add(Material.GRAY_STAINED_GLASS);
		this.colorBlocks.add(Material.LIGHT_GRAY_STAINED_GLASS);
		this.colorBlocks.add(Material.CYAN_STAINED_GLASS);
		this.colorBlocks.add(Material.PURPLE_STAINED_GLASS);
		this.colorBlocks.add(Material.BLUE_STAINED_GLASS);
		this.colorBlocks.add(Material.BROWN_STAINED_GLASS);
		this.colorBlocks.add(Material.GREEN_STAINED_GLASS);
		this.colorBlocks.add(Material.RED_STAINED_GLASS);
		this.colorBlocks.add(Material.TINTED_GLASS);
		this.colorBlocks.add(Material.TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_WOOL);
		this.colorBlocks.add(Material.ORANGE_WOOL);
		this.colorBlocks.add(Material.MAGENTA_WOOL);
		this.colorBlocks.add(Material.LIGHT_BLUE_WOOL);
		this.colorBlocks.add(Material.YELLOW_WOOL);
		this.colorBlocks.add(Material.LIME_WOOL);
		this.colorBlocks.add(Material.PINK_WOOL);
		this.colorBlocks.add(Material.GRAY_WOOL);
		this.colorBlocks.add(Material.LIGHT_GRAY_WOOL);
		this.colorBlocks.add(Material.CYAN_WOOL);
		this.colorBlocks.add(Material.PURPLE_WOOL);
		this.colorBlocks.add(Material.BLUE_WOOL);
		this.colorBlocks.add(Material.BROWN_WOOL);
		this.colorBlocks.add(Material.GREEN_WOOL);
		this.colorBlocks.add(Material.RED_WOOL);
		this.colorBlocks.add(Material.WHITE_TERRACOTTA);
		this.colorBlocks.add(Material.ORANGE_TERRACOTTA);
		this.colorBlocks.add(Material.MAGENTA_TERRACOTTA);
		this.colorBlocks.add(Material.LIGHT_BLUE_TERRACOTTA);
		this.colorBlocks.add(Material.YELLOW_TERRACOTTA);
		this.colorBlocks.add(Material.LIME_TERRACOTTA);
		this.colorBlocks.add(Material.PINK_TERRACOTTA);
		this.colorBlocks.add(Material.GRAY_TERRACOTTA);
		this.colorBlocks.add(Material.LIGHT_GRAY_TERRACOTTA);
		this.colorBlocks.add(Material.CYAN_TERRACOTTA);
		this.colorBlocks.add(Material.PURPLE_TERRACOTTA);
		this.colorBlocks.add(Material.BLUE_TERRACOTTA);
		this.colorBlocks.add(Material.BROWN_TERRACOTTA);
		this.colorBlocks.add(Material.GREEN_TERRACOTTA);
		this.colorBlocks.add(Material.RED_TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.ORANGE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.MAGENTA_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.YELLOW_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.LIME_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.PINK_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.GRAY_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.CYAN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.PURPLE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.BLUE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.BROWN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.GREEN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.RED_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.ORANGE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.MAGENTA_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIGHT_BLUE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.YELLOW_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIME_CONCRETE_POWDER);
		this.colorBlocks.add(Material.PINK_CONCRETE_POWDER);
		this.colorBlocks.add(Material.GRAY_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIGHT_GRAY_CONCRETE_POWDER);
		this.colorBlocks.add(Material.CYAN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.PURPLE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.BLUE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.BROWN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.GREEN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.RED_CONCRETE_POWDER);
		this.colorBlocks.add(Material.WHITE_CONCRETE);
		this.colorBlocks.add(Material.ORANGE_CONCRETE);
		this.colorBlocks.add(Material.MAGENTA_CONCRETE);
		this.colorBlocks.add(Material.LIGHT_BLUE_CONCRETE);
		this.colorBlocks.add(Material.YELLOW_CONCRETE);
		this.colorBlocks.add(Material.LIME_CONCRETE);
		this.colorBlocks.add(Material.PINK_CONCRETE);
		this.colorBlocks.add(Material.GRAY_CONCRETE);
		this.colorBlocks.add(Material.LIGHT_GRAY_CONCRETE);
		this.colorBlocks.add(Material.CYAN_CONCRETE);
		this.colorBlocks.add(Material.PURPLE_CONCRETE);
		this.colorBlocks.add(Material.BLUE_CONCRETE);
		this.colorBlocks.add(Material.BROWN_CONCRETE);
		this.colorBlocks.add(Material.GREEN_CONCRETE);
		this.colorBlocks.add(Material.RED_CONCRETE);
	}
	
	public void setDecorationItems() {
		
	}
	
	public void setFarmingItems() {
		this.farming.add(Material.WHEAT_SEEDS);
		this.farming.add(Material.WHEAT);
		this.farming.add(Material.BEETROOT_SEEDS);
		this.farming.add(Material.BEETROOT);
		this.farming.add(Material.CARROT);
		this.farming.add(Material.POTATO);
		this.farming.add(Material.MELON_SEEDS);
		this.farming.add(Material.MELON_SLICE);
		this.farming.add(Material.PUMPKIN);
		this.farming.add(Material.NETHER_WART);
		this.farming.add(Material.SUGAR_CANE);
		this.farming.add(Material.CACTUS);
		this.farming.add(Material.BAMBOO);
		this.farming.add(Material.COCOA_BEANS);
		this.farming.add(Material.KELP);
		this.farming.add(Material.VINE);
		this.farming.add(Material.GLOW_LICHEN);
		this.farming.add(Material.RED_MUSHROOM);
		this.farming.add(Material.BROWN_MUSHROOM);
		this.farming.add(Material.TWISTING_VINES);
		this.farming.add(Material.WEEPING_VINES);
		this.farming.add(Material.CRIMSON_FUNGUS);
		this.farming.add(Material.WARPED_FUNGUS);
		
	}
	
	public void setFoodItems() {
		
	}
	
	public void setMobItems() {
		
	}
	
	public void setGemsItems() {
		this.gems.add(Material.COAL);
		this.gems.add(Material.RAW_IRON);
		this.gems.add(Material.IRON_INGOT);
		this.gems.add(Material.RAW_COPPER);
		this.gems.add(Material.COPPER_INGOT);
		this.gems.add(Material.LAPIS_LAZULI);
		this.gems.add(Material.REDSTONE);
		this.gems.add(Material.RAW_GOLD);
		this.gems.add(Material.GOLD_INGOT);
		this.gems.add(Material.DIAMOND);
		this.gems.add(Material.EMERALD);
		this.gems.add(Material.NETHERITE_SCRAP);
		this.gems.add(Material.NETHERITE_INGOT);
	}
	
	public void setRedstoneItems() {
		
	}
	
	public void setMiscItems() {
		
	}
	
	public void setBrewingItems() {
		
	}
	
	public ArrayList<Material> getBlocks() {
		return blocks;
	}
	public void setBlocks(ArrayList<Material> blocks) {
		this.blocks = blocks;
	}
	public ArrayList<Material> getColorBlocks() {
		return colorBlocks;
	}
	public void setColorBlocks(ArrayList<Material> colorBlocks) {
		this.colorBlocks = colorBlocks;
	}
	public ArrayList<Material> getDecorativeBlocks() {
		return decorativeBlocks;
	}
	public void setDecorativeBlocks(ArrayList<Material> decorativeBlocks) {
		this.decorativeBlocks = decorativeBlocks;
	}
	public ArrayList<Material> getFarming() {
		return farming;
	}
	public void setFarming(ArrayList<Material> farming) {
		this.farming = farming;
	}
	public ArrayList<Material> getFoods() {
		return foods;
	}
	public void setFoods(ArrayList<Material> foods) {
		this.foods = foods;
	}
	public ArrayList<Material> getMisc() {
		return misc;
	}
	public void setMisc(ArrayList<Material> misc) {
		this.misc = misc;
	}
	public ArrayList<Material> getGems() {
		return gems;
	}
	public void setGems(ArrayList<Material> gems) {
		this.gems = gems;
	}
	public ArrayList<Material> getMobDrops() {
		return mobDrops;
	}
	public void setMobDrops(ArrayList<Material> mobDrops) {
		this.mobDrops = mobDrops;
	}
	public ArrayList<Material> getRedstone() {
		return redstone;
	}
	public void setRedstone(ArrayList<Material> redstone) {
		this.redstone = redstone;
	}
	public ArrayList<Material> getBrewing() {
		return brewing;
	}
	public void setBrewing(ArrayList<Material> brewing) {
		this.brewing = brewing;
	}
	

}
