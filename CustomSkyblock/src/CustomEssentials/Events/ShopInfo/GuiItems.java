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
		this.blocks.add(Material.DIRT);
		this.blocks.add(Material.GRASS_BLOCK);
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
