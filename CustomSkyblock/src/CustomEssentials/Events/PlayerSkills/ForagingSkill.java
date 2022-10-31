package CustomEssentials.Events.PlayerSkills;

import java.util.HashMap;

import org.bukkit.Material;

public class ForagingSkill extends Skills{
	
	private HashMap<Material, Float> woodXp= new HashMap<Material, Float>();
	private HashMap<Material, Integer> levelRequirements= new HashMap<Material, Integer>();
	
	public double getXPamount(Material block) {
		
		if (this.woodXp.size() < 1) generateWoodXp();
		if (this.levelRequirements.size() < 1) generateLevelRequirements();
		
		
		if (!(this.woodXp.containsKey(block))) return 0.0;
		if (this.getLevel() < this.levelRequirements.get(block)) return 0.0;
		
		return this.woodXp.get(block);
	}
	
	public void generateWoodXp() {
		this.woodXp.put(Material.OAK_PLANKS, (float) 1.0);
		this.woodXp.put(Material.BIRCH_PLANKS, (float) 2.0);
		this.woodXp.put(Material.SPRUCE_PLANKS, (float) 3.0);
		this.woodXp.put(Material.DARK_OAK_PLANKS, (float) 4.0);
		this.woodXp.put(Material.JUNGLE_PLANKS, (float) 4.5);
		this.woodXp.put(Material.ACACIA_PLANKS, (float) 5.0);
		
		this.woodXp.put(Material.OAK_LOG, (float) 7.5);
		this.woodXp.put(Material.BIRCH_LOG, (float) 10.0);
		this.woodXp.put(Material.SPRUCE_LOG, (float) 12.5);
		this.woodXp.put(Material.DARK_OAK_LOG, (float) 15.0);
		this.woodXp.put(Material.JUNGLE_LOG, (float) 17.5);
		this.woodXp.put(Material.ACACIA_LOG, (float) 25.0);

		this.woodXp.put(Material.STRIPPED_OAK_LOG, (float) 50.0);
		this.woodXp.put(Material.STRIPPED_BIRCH_LOG, (float) 55.0);
		this.woodXp.put(Material.STRIPPED_SPRUCE_LOG, (float) 60.0);
		this.woodXp.put(Material.STRIPPED_DARK_OAK_LOG, (float) 65.0);
		this.woodXp.put(Material.STRIPPED_JUNGLE_LOG, (float) 70.0);
		this.woodXp.put(Material.STRIPPED_ACACIA_LOG, (float) 75.0);
		
		
		this.woodXp.put(Material.CRIMSON_PLANKS, (float) 100.0);
		this.woodXp.put(Material.WARPED_PLANKS, (float) 150.0);
		this.woodXp.put(Material.CRIMSON_HYPHAE, (float) 250.0);
		this.woodXp.put(Material.WARPED_HYPHAE, (float) 3505.0);	
		this.woodXp.put(Material.STRIPPED_CRIMSON_HYPHAE, (float) 500.0);
		this.woodXp.put(Material.STRIPPED_WARPED_HYPHAE, (float) 1000.0);
		
	}
	
	public void generateLevelRequirements() {
		this.levelRequirements.put(Material.OAK_PLANKS,  0);
		this.levelRequirements.put(Material.BIRCH_PLANKS,  1);
		this.levelRequirements.put(Material.SPRUCE_PLANKS,  3);
		this.levelRequirements.put(Material.DARK_OAK_PLANKS,  5);
		this.levelRequirements.put(Material.JUNGLE_PLANKS,  10);
		this.levelRequirements.put(Material.ACACIA_PLANKS,  12);
		
		this.levelRequirements.put(Material.OAK_LOG,  15);
		this.levelRequirements.put(Material.BIRCH_LOG,  20);
		this.levelRequirements.put(Material.SPRUCE_LOG,  25);
		this.levelRequirements.put(Material.DARK_OAK_LOG,  30);
		this.levelRequirements.put(Material.JUNGLE_LOG,  35);
		this.levelRequirements.put(Material.ACACIA_LOG,  40);

		this.levelRequirements.put(Material.STRIPPED_OAK_LOG,  50);
		this.levelRequirements.put(Material.STRIPPED_BIRCH_LOG,  55);
		this.levelRequirements.put(Material.STRIPPED_SPRUCE_LOG,  60);
		this.levelRequirements.put(Material.STRIPPED_DARK_OAK_LOG,  65);
		this.levelRequirements.put(Material.STRIPPED_JUNGLE_LOG,  70);
		this.levelRequirements.put(Material.STRIPPED_ACACIA_LOG,  75);
		
		
		this.levelRequirements.put(Material.CRIMSON_PLANKS,  100);
		this.levelRequirements.put(Material.WARPED_PLANKS,  125);
		this.levelRequirements.put(Material.CRIMSON_HYPHAE,  150);
		this.levelRequirements.put(Material.WARPED_HYPHAE,  175);	
		this.levelRequirements.put(Material.STRIPPED_CRIMSON_HYPHAE,  200);
		this.levelRequirements.put(Material.STRIPPED_WARPED_HYPHAE,  250);
		
	}
	
	

	public HashMap<Material, Float> getWoodXp() {
		return woodXp;
	}

	public void setWoodXp(HashMap<Material, Float> woodXp) {
		this.woodXp = woodXp;
	}

	public HashMap<Material, Integer> getLevelRequirements() {
		return levelRequirements;
	}

	public void setLevelRequirements(HashMap<Material, Integer> levelRequirements) {
		this.levelRequirements = levelRequirements;
	}

}
