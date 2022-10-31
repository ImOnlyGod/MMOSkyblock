package CustomEssentials.Events.PlayerSkills;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Entity;


//CUSTOMISE MORE WITH BETTER LEVEL INTEGRATION AND PROGRESSION
public class CombatSkill extends Skills {
	
	private ArrayList<String> mobNames = new ArrayList<String>();
	private HashMap<String, Float> mobXp = new HashMap<String, Float>();
	private HashMap<String, Integer> levelRequirements =  new HashMap<String, Integer>();
	
	public double getXPamount(Entity mob) {
		
		if (this.mobXp.size() < 1) generateMobXp();
		if (this.levelRequirements.size() < 1) generateLevelRequirements();
		
		String mobName = mob.getCustomName();
		int levelLeftString = mobName.indexOf('[') + 5;
		int levelRightString = mobName.indexOf(']') - 4;
		int level = Integer.valueOf(mobName.substring(levelLeftString,levelRightString));
		
		for (int i=0; i<this.mobNames.size(); i++) {
			if (mobName.contains(this.mobNames.get(i))) {
				if (this.getLevel() < this.levelRequirements.get(this.mobNames.get(i))) break;
				
				return level*this.mobXp.get(this.mobNames.get(i));
			}
		}
		return 0.0;
	}
	
	public void generateMobXp() {
		this.mobXp.put("§6§lZombie", (float) 1.0);
		this.mobXp.put("§6§lSkeleton", (float) 1.0);
		this.mobXp.put("§6§lCreeper", (float) 2.0);
		this.mobXp.put("§6§lEnderman", (float) 5.0);
		this.mobXp.put("§6§lSpider", (float) 2.0);
		this.mobXp.put("§6§lBlaze", (float) 10.0);		
		
		this.mobNames.add("§6§lZombie");
		this.mobNames.add("§6§lSkeleton");
		this.mobNames.add("§6§lCreeper");
		this.mobNames.add("§6§lEnderman");
		this.mobNames.add("§6§lSpider");
		this.mobNames.add("§6§lBlaze");
		
	}
	
	public void generateLevelRequirements() {
		this.levelRequirements.put("§6§lZombie",  0);
		this.levelRequirements.put("§6§lSkeleton",  0);
		this.levelRequirements.put("§6§lCreeper",  0);
		this.levelRequirements.put("§6§lEnderman",  0);
		this.levelRequirements.put("§6§lSpider",  0);
		this.levelRequirements.put("§6§lBlaze",  1);	
	}
	
	public HashMap<String, Float> getMobXp() {
		return mobXp;
	}

	public void setMobXp(HashMap<String, Float> mobXp) {
		this.mobXp = mobXp;
	}

	public HashMap<String, Integer> getLevelRequirements() {
		return levelRequirements;
	}

	public void setLevelRequirements(HashMap<String, Integer> levelRequirements) {
		this.levelRequirements = levelRequirements;
	}

	public ArrayList<String> getMobNames() {
		return mobNames;
	}

	public void setMobNames(ArrayList<String> mobNames) {
		this.mobNames = mobNames;
	}
}
