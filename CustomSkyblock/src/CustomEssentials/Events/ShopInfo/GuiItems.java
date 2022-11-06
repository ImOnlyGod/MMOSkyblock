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
