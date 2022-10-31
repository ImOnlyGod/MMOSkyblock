package CustomEssentials.Events.PlayerSkills;

import java.util.HashMap;

import org.bukkit.Material;

public class MiningSkill extends Skills{
	
	private HashMap<Material, Float> blockXp = new HashMap<Material, Float>();
	private HashMap<Material, Integer> levelRequirements=  new HashMap<Material, Integer>();
	
	public double getXPamount(Material block) {
				
		if (this.blockXp.size() < 1) generateBlockXp();
		if (this.levelRequirements.size() < 1) generateLevelRequirements();
		
		
		if (!(this.blockXp.containsKey(block))) return 0.0;
		if (this.getLevel() < this.levelRequirements.get(block)) return 0.0;
		
		return this.blockXp.get(block);
	}
	
	public void generateBlockXp() {
		this.blockXp.put(Material.STONE, (float) 0.1);
		this.blockXp.put(Material.COBBLESTONE, (float) 0.25);
		this.blockXp.put(Material.COAL_ORE, (float) 1);
		this.blockXp.put(Material.DEEPSLATE_COAL_ORE, (float) 1.5);
		this.blockXp.put(Material.IRON_ORE, (float) 2);
		this.blockXp.put(Material.DEEPSLATE_IRON_ORE, (float) 2.5);
		this.blockXp.put(Material.COPPER_ORE, (float) 3.5);
		this.blockXp.put(Material.DEEPSLATE_COPPER_ORE, (float) 4.0);
		this.blockXp.put(Material.LAPIS_ORE, (float) 4.5);
		this.blockXp.put(Material.DEEPSLATE_LAPIS_ORE, (float) 5.0);
		this.blockXp.put(Material.REDSTONE_ORE, (float) 6.0);
		this.blockXp.put(Material.DEEPSLATE_REDSTONE_ORE, (float) 7.0);
		this.blockXp.put(Material.GOLD_ORE, (float) 10);
		this.blockXp.put(Material.DEEPSLATE_GOLD_ORE, (float) 15);
		this.blockXp.put(Material.DIAMOND_ORE, (float) 20);
		this.blockXp.put(Material.DEEPSLATE_DIAMOND_ORE, (float) 25);
		this.blockXp.put(Material.EMERALD_ORE, (float) 35);
		this.blockXp.put(Material.DEEPSLATE_EMERALD_ORE, (float) 50);	
		//ADD MORE LATER :)
	}
	
	public void generateLevelRequirements() {
		this.levelRequirements.put(Material.STONE,  0);
		this.levelRequirements.put(Material.COBBLESTONE,  1);
		this.levelRequirements.put(Material.COAL_ORE,  3);
		this.levelRequirements.put(Material.DEEPSLATE_COAL_ORE,  5);
		this.levelRequirements.put(Material.IRON_ORE,  7);
		this.levelRequirements.put(Material.DEEPSLATE_IRON_ORE,  9);
		this.levelRequirements.put(Material.COPPER_ORE,  10);
		this.levelRequirements.put(Material.DEEPSLATE_COPPER_ORE,  15);
		this.levelRequirements.put(Material.LAPIS_ORE,  20);
		this.levelRequirements.put(Material.DEEPSLATE_LAPIS_ORE,  25);
		this.levelRequirements.put(Material.REDSTONE_ORE,  30);
		this.levelRequirements.put(Material.DEEPSLATE_REDSTONE_ORE,  35);
		this.levelRequirements.put(Material.GOLD_ORE,  40);
		this.levelRequirements.put(Material.DEEPSLATE_GOLD_ORE,  45);
		this.levelRequirements.put(Material.DIAMOND_ORE,  50);
		this.levelRequirements.put(Material.DEEPSLATE_DIAMOND_ORE,  55);
		this.levelRequirements.put(Material.EMERALD_ORE,  60);
		this.levelRequirements.put(Material.DEEPSLATE_EMERALD_ORE,  65);	
	}
	
	

	public HashMap<Material, Float> getBlockXp() {
		return blockXp;
	}

	public void setBlockXp(HashMap<Material, Float> blockXp) {
		this.blockXp = blockXp;
	}

	public HashMap<Material, Integer> getLevelRequirements() {
		return levelRequirements;
	}

	public void setLevelRequirements(HashMap<Material, Integer> levelRequirements) {
		this.levelRequirements = levelRequirements;
	}
	
}
