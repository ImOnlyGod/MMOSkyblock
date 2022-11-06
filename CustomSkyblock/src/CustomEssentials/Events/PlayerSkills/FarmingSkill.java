package CustomEssentials.Events.PlayerSkills;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Material;

public class FarmingSkill extends Skills{
	
	private HashMap<Material, Float> cropXp= new HashMap<Material, Float>();
	private HashMap<Material, Integer> levelRequirements= new HashMap<Material, Integer>();
	private ArrayList<Material> nonPlantingCrops = new ArrayList<Material>();

	public double getXPamount(Material block) {
		
		
		if (this.cropXp.size() < 1) generateCropXp();
		if (this.levelRequirements.size() < 1) generateLevelRequirements();
		
		
		if (!(this.cropXp.containsKey(block))) return 0.0;
		if (this.getLevel() < this.levelRequirements.get(block)) return 0.0;
		
		return this.cropXp.get(block);
		
	}

	public HashMap<Material, Float> getCropXp() {
		return cropXp;
	}

	public void setCropXp(HashMap<Material, Float> cropXp) {
		this.cropXp = cropXp;
	}
	
	public void generateCropXp() {
		this.cropXp.put(Material.WHEAT, (float) 1.0);
		this.cropXp.put(Material.BEETROOTS, (float) 1.5);
		this.cropXp.put(Material.CARROTS, (float) 2.0);
		this.cropXp.put(Material.POTATOES, (float) 2.5);
		this.cropXp.put(Material.MELON, (float) 3.0);
		this.cropXp.put(Material.PUMPKIN, (float) 3.5);
		this.cropXp.put(Material.NETHER_WART, (float) 5.0);
		this.cropXp.put(Material.SUGAR_CANE, (float) 5.0);
		this.cropXp.put(Material.CACTUS, (float) 7.5);
		this.cropXp.put(Material.BAMBOO, (float) 5.0);
		this.cropXp.put(Material.BAMBOO_SAPLING, (float) 5.0);
		this.cropXp.put(Material.COCOA_BEANS, (float) 25.0);
		this.cropXp.put(Material.KELP_PLANT, (float) 5.5);
		this.cropXp.put(Material.KELP, (float) 5.5);
		this.cropXp.put(Material.VINE, (float) 30.0);
		this.cropXp.put(Material.GLOW_LICHEN, (float) 35.0);
		this.cropXp.put(Material.RED_MUSHROOM, (float) 40.0);
		this.cropXp.put(Material.BROWN_MUSHROOM, (float) 40.0);
		this.cropXp.put(Material.RED_MUSHROOM_BLOCK, (float) 10.0);
		this.cropXp.put(Material.BROWN_MUSHROOM_BLOCK, (float) 10.0);
		this.cropXp.put(Material.MUSHROOM_STEM, (float) 10.0);
		this.cropXp.put(Material.TWISTING_VINES, (float) 8.0);
		this.cropXp.put(Material.WEEPING_VINES, (float) 8.0);
		this.cropXp.put(Material.CRIMSON_FUNGUS, (float) 50.0);
		this.cropXp.put(Material.WARPED_FUNGUS, (float) 50.0);		
		
		this.nonPlantingCrops.add(Material.SUGAR_CANE);
		this.nonPlantingCrops.add(Material.CACTUS);
		this.nonPlantingCrops.add(Material.KELP_PLANT);
		this.nonPlantingCrops.add(Material.TWISTING_VINES_PLANT);
		this.nonPlantingCrops.add(Material.WEEPING_VINES_PLANT);
		this.nonPlantingCrops.add(Material.BAMBOO);
		
	}
	
	public void generateLevelRequirements() {
		this.levelRequirements.put(Material.WHEAT,  0);
		this.levelRequirements.put(Material.BEETROOTS,  1);
		this.levelRequirements.put(Material.CARROTS,  5);
		this.levelRequirements.put(Material.POTATOES,  10);
		this.levelRequirements.put(Material.MELON,  12);
		this.levelRequirements.put(Material.PUMPKIN,  15);
		this.levelRequirements.put(Material.NETHER_WART,  20);
		this.levelRequirements.put(Material.SUGAR_CANE,  25);
		this.levelRequirements.put(Material.CACTUS,  30);
		this.levelRequirements.put(Material.BAMBOO,  30);
		this.levelRequirements.put(Material.BAMBOO_SAPLING,  30);
		this.levelRequirements.put(Material.COCOA_BEANS,  35);
		this.levelRequirements.put(Material.KELP_PLANT,  35);
		this.levelRequirements.put(Material.KELP,  35);
		this.levelRequirements.put(Material.VINE,  40);
		this.levelRequirements.put(Material.GLOW_LICHEN,  45);
		this.levelRequirements.put(Material.RED_MUSHROOM,  50);
		this.levelRequirements.put(Material.BROWN_MUSHROOM,  50);
		this.levelRequirements.put(Material.RED_MUSHROOM_BLOCK,  50);
		this.levelRequirements.put(Material.BROWN_MUSHROOM_BLOCK,  50);
		this.levelRequirements.put(Material.MUSHROOM_STEM,  50);
		this.levelRequirements.put(Material.TWISTING_VINES_PLANT,  55);
		this.levelRequirements.put(Material.WEEPING_VINES_PLANT,  55);
		this.levelRequirements.put(Material.CRIMSON_FUNGUS,  55);
		this.levelRequirements.put(Material.WARPED_FUNGUS,  55);	
	
	}

	public HashMap<Material, Integer> getLevelRequirements() {
		return levelRequirements;
	}

	public void setLevelRequirements(HashMap<Material, Integer> levelRequirements) {
		this.levelRequirements = levelRequirements;
	}

	public ArrayList<Material> getNonPlantingCrops() {
		return nonPlantingCrops;
	}

	public void setNonPlantingCrops(ArrayList<Material> nonPlantingCrops) {
		this.nonPlantingCrops = nonPlantingCrops;
	}

}
