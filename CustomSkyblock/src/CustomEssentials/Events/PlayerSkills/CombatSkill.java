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
		int leftStringName = mobName.indexOf("]") + 2;
		int rightStringName = mobName.indexOf("(") - 5;		
		int levelLeftString = mobName.indexOf('[') + 5;
		int levelRightString = mobName.indexOf(']') - 4;
		int level = Integer.valueOf(mobName.substring(levelLeftString,levelRightString));
		mobName = mobName.substring(leftStringName, rightStringName);
		
		for (int i=0; i<this.mobNames.size(); i++) {
			if (mobName.equalsIgnoreCase(this.mobNames.get(i))) {
				if (this.getLevel() < this.levelRequirements.get(this.mobNames.get(i))) break;
				
				return level*this.mobXp.get(this.mobNames.get(i));
			}
		}
		return 0.0;
	}
	
	public void generateMobXp() {
		this.mobXp.put("§6§lAxolotl", (float) 1);
		this.mobXp.put("§6§lBat", (float) 1);
		this.mobXp.put("§6§lCat", (float) 1);
		this.mobXp.put("§6§lChicken", (float) 1);
		this.mobXp.put("§6§lCod", (float) 1);
		this.mobXp.put("§6§lCow", (float) 1);
		this.mobXp.put("§6§lDonkey", (float) 1);
		this.mobXp.put("§6§lFox", (float) 1);
		this.mobXp.put("§6§lGlow Squid", (float) 1);
		this.mobXp.put("§6§lHorse", (float) 1);
		this.mobXp.put("§6§lMooshroom", (float) 1);
		this.mobXp.put("§6§lMule", (float) 1);
		this.mobXp.put("§6§lOcelot", (float) 1);
		this.mobXp.put("§6§lParrot", (float) 1);
		this.mobXp.put("§6§lPig", (float) 1);
		this.mobXp.put("§6§lPufferfish", (float) 1);
		this.mobXp.put("§6§lRabbit", (float) 1);
		this.mobXp.put("§6§lSalmon", (float) 1);
		this.mobXp.put("§6§lSheep", (float) 1);
		this.mobXp.put("§6§lSkeleton Horse", (float) 1);
		this.mobXp.put("§6§lSnow Golem", (float) 2);
		this.mobXp.put("§6§lSquid", (float) 1);
		this.mobXp.put("§6§lStrider", (float) 1);
		this.mobXp.put("§6§lTropical Fish", (float) 1);
		this.mobXp.put("§6§lTurtle", (float) 1);
		this.mobXp.put("§6§lVillager", (float) 1);
		this.mobXp.put("§6§lWandering Trader", (float) 1);
		
		this.mobXp.put("§6§lBee", (float) 1);
		this.mobXp.put("§6§lCave Spider", (float) 1);
		this.mobXp.put("§6§lDolphin", (float) 1);
		this.mobXp.put("§6§lEnderman", (float) 1);
		this.mobXp.put("§6§lGoat", (float) 1);
		this.mobXp.put("§6§lIron Golem", (float) 1);
		this.mobXp.put("§6§lLlama", (float) 1);
		this.mobXp.put("§6§lPanda", (float) 1);
		this.mobXp.put("§6§lPolar Bear", (float) 1);
		this.mobXp.put("§6§lSpider", (float) 1);
		this.mobXp.put("§6§lWolf", (float) 1);
		this.mobXp.put("§6§lZombified Piglin", (float) 1.0);
		this.mobXp.put("§6§lTrader Llama", (float) 1);
		
		this.mobXp.put("§6§lBlaze", (float) 1);
		this.mobXp.put("§6§lCreeper", (float) 1);
		this.mobXp.put("§6§lDrowned", (float) 1);
		this.mobXp.put("§6§lElder Guardian", (float) 1);
		this.mobXp.put("§6§lEndermite", (float) 1);
		this.mobXp.put("§6§lEvoker", (float) 1);
		this.mobXp.put("§6§lGhast", (float) 1);
		this.mobXp.put("§6§lGuardian", (float) 1);
		this.mobXp.put("§6§lHoglin", (float) 1);
		this.mobXp.put("§6§lHusk", (float) 1);
		this.mobXp.put("§6§lMagma Cube", (float) 1);
		this.mobXp.put("§6§lPhantom", (float) 1);
		this.mobXp.put("§6§lPiglin Brute", (float) 1.0);
		this.mobXp.put("§6§lPiglin", (float) 1.0);
		this.mobXp.put("§6§lPillager", (float) 1);
		this.mobXp.put("§6§lRavager", (float) 1);
		this.mobXp.put("§6§lShulker", (float) 1);
		this.mobXp.put("§6§lSilverfish", (float) 1);
		this.mobXp.put("§6§lSkeleton", (float) 1);
		this.mobXp.put("§6§lSlime", (float) 1);
		this.mobXp.put("§6§lStray", (float) 1);
		this.mobXp.put("§6§lVex", (float) 1);
		this.mobXp.put("§6§lVindicator", (float) 1);
		this.mobXp.put("§6§lWitch", (float) 1);
		this.mobXp.put("§6§lWither Skeleton", (float) 1);
		this.mobXp.put("§6§lZoglin", (float) 1);
		this.mobXp.put("§6§lZombie Villager", (float) 1);
		this.mobXp.put("§6§lZombie", (float) 1);
		
		this.mobXp.put("§7§lBasic Zombie", (float) 5);
		this.mobXp.put("§5§lWild Pig", (float) 3);
		this.mobXp.put("§c§lAgressive Golem", (float) 25);	
		
		this.mobNames.add("§6§lAxolotl");
		this.mobNames.add("§6§lBat");
		this.mobNames.add("§6§lCat");
		this.mobNames.add("§6§lChicken");
		this.mobNames.add("§6§lCod");
		this.mobNames.add("§6§lCow");
		this.mobNames.add("§6§lDonkey");
		this.mobNames.add("§6§lFox");
		this.mobNames.add("§6§lGlow Squid");
		this.mobNames.add("§6§lHorse");
		this.mobNames.add("§6§lMooshroom");
		this.mobNames.add("§6§lMule");
		this.mobNames.add("§6§lOcelot");
		this.mobNames.add("§6§lParrot");
		this.mobNames.add("§6§lPig");
		this.mobNames.add("§6§lPufferfish");
		this.mobNames.add("§6§lRabbit");
		this.mobNames.add("§6§lSalmon");
		this.mobNames.add("§6§lSheep");
		this.mobNames.add("§6§lSkeleton Horse");
		this.mobNames.add("§6§lSnow Golem");
		this.mobNames.add("§6§lSquid");
		this.mobNames.add("§6§lStrider");
		this.mobNames.add("§6§lTropical Fish");
		this.mobNames.add("§6§lTurtle");
		this.mobNames.add("§6§lVillager");
		this.mobNames.add("§6§lWandering Trader");
		
		this.mobNames.add("§6§lBee");
		this.mobNames.add("§6§lCave Spider");
		this.mobNames.add("§6§lDolphin");
		this.mobNames.add("§6§lEnderman");
		this.mobNames.add("§6§lGoat");
		this.mobNames.add("§6§lIron Golem");
		this.mobNames.add("§6§lLlama");
		this.mobNames.add("§6§lPanda");
		this.mobNames.add("§6§lPolar Bear");
		this.mobNames.add("§6§lSpider");
		this.mobNames.add("§6§lWolf");
		this.mobNames.add("§6§lZombified Piglin");
		
		this.mobNames.add("§6§lBlaze");
		this.mobNames.add("§6§lCreeper");
		this.mobNames.add("§6§lDrowned");
		this.mobNames.add("§6§lElder Guardian");
		this.mobNames.add("§6§lEndermite");
		this.mobNames.add("§6§lEvoker");
		this.mobNames.add("§6§lGhast");
		this.mobNames.add("§6§lGuardian");
		this.mobNames.add("§6§lHoglin");
		this.mobNames.add("§6§lHusk");
		this.mobNames.add("§6§lMagma Cube");
		this.mobNames.add("§6§lPhantom");
		this.mobNames.add("§6§lPiglin Brute");
		this.mobNames.add("§6§lPiglin");
		this.mobNames.add("§6§lPillager");
		this.mobNames.add("§6§lRavager");
		this.mobNames.add("§6§lShulker");
		this.mobNames.add("§6§lSilverfish");
		this.mobNames.add("§6§lSkeleton");
		this.mobNames.add("§6§lSlime");
		this.mobNames.add("§6§lStray");
		this.mobNames.add("§6§lVex");
		this.mobNames.add("§6§lVindicator");
		this.mobNames.add("§6§lWitch");
		this.mobNames.add("§6§lWither Skeleton");
		this.mobNames.add("§6§lZoglin");
		this.mobNames.add("§6§lZombie Villager");
		this.mobNames.add("§6§lZombie");
		
		this.mobNames.add("§7§lBasic Zombie");
		this.mobNames.add("§5§lWild Pig");
		this.mobNames.add("§c§lAgressive Golem");

		
	}
	
	public void generateLevelRequirements() {
		this.levelRequirements.put("§6§lAxolotl", 0);
		this.levelRequirements.put("§6§lBat", 0);
		this.levelRequirements.put("§6§lCat", 0);
		this.levelRequirements.put("§6§lChicken", 0);
		this.levelRequirements.put("§6§lCod", 0);
		this.levelRequirements.put("§6§lCow", 0);
		this.levelRequirements.put("§6§lDonkey", 0);
		this.levelRequirements.put("§6§lFox", 0);
		this.levelRequirements.put("§6§lGlow Squid", 0);
		this.levelRequirements.put("§6§lHorse", 0);
		this.levelRequirements.put("§6§lMooshroom", 0);
		this.levelRequirements.put("§6§lMule", 0);
		this.levelRequirements.put("§6§lOcelot", 0);
		this.levelRequirements.put("§6§lParrot", 0);
		this.levelRequirements.put("§6§lPig", 0);
		this.levelRequirements.put("§6§lPufferfish", 0);
		this.levelRequirements.put("§6§lRabbit", 0);
		this.levelRequirements.put("§6§lSalmon", 0);
		this.levelRequirements.put("§6§lSheep", 0);
		this.levelRequirements.put("§6§lSkeleton Horse", 0);
		this.levelRequirements.put("§6§lSnow Golem", 0);
		this.levelRequirements.put("§6§lSquid", 0);
		this.levelRequirements.put("§6§lStrider", 0);
		this.levelRequirements.put("§6§lTropical Fish", 0);
		this.levelRequirements.put("§6§lTurtle", 0);
		this.levelRequirements.put("§6§lVillager", 0);
		this.levelRequirements.put("§6§lWandering Trader", 0);
		
		this.levelRequirements.put("§6§lBee", 0);
		this.levelRequirements.put("§6§lCave Spider", 0);
		this.levelRequirements.put("§6§lDolphin", 0);
		this.levelRequirements.put("§6§lEnderman", 0);
		this.levelRequirements.put("§6§lGoat", 0);
		this.levelRequirements.put("§6§lIron Golem", 0);
		this.levelRequirements.put("§6§lLlama", 0);
		this.levelRequirements.put("§6§lPanda", 0);
		this.levelRequirements.put("§6§lPolar Bear", 0);
		this.levelRequirements.put("§6§lSpider", 0);
		this.levelRequirements.put("§6§lWolf", 0);
		this.levelRequirements.put("§6§lZombified Piglin", 0);
		
		this.levelRequirements.put("§6§lBlaze", 0);
		this.levelRequirements.put("§6§lCreeper", 0);
		this.levelRequirements.put("§6§lDrowned", 0);
		this.levelRequirements.put("§6§lElder Guardian", 0);
		this.levelRequirements.put("§6§lEndermite", 0);
		this.levelRequirements.put("§6§lEvoker", 0);
		this.levelRequirements.put("§6§lGhast", 0);
		this.levelRequirements.put("§6§lGuardian", 0);
		this.levelRequirements.put("§6§lHoglin", 0);
		this.levelRequirements.put("§6§lHusk", 0);
		this.levelRequirements.put("§6§lMagma Cube", 0);
		this.levelRequirements.put("§6§lPhantom", 0);
		this.levelRequirements.put("§6§lPiglin Brute", 0);
		this.levelRequirements.put("§6§lPiglin", 0);
		this.levelRequirements.put("§6§lPillager", 0);
		this.levelRequirements.put("§6§lRavager", 0);
		this.levelRequirements.put("§6§lShulker", 0);
		this.levelRequirements.put("§6§lSilverfish", 0);
		this.levelRequirements.put("§6§lSkeleton", 0);
		this.levelRequirements.put("§6§lSlime", 0);
		this.levelRequirements.put("§6§lStray", 0);
		this.levelRequirements.put("§6§lVex", 0);
		this.levelRequirements.put("§6§lVindicator", 0);
		this.levelRequirements.put("§6§lWitch", 0);
		this.levelRequirements.put("§6§lWither Skeleton", 0);
		this.levelRequirements.put("§6§lZoglin", 0);
		this.levelRequirements.put("§6§lZombie Villager", 0);
		this.levelRequirements.put("§6§lZombie", 0);
		
		this.levelRequirements.put("§7§lBasic Zombie", 0);
		this.levelRequirements.put("§5§lWild Pig", 0);
		this.levelRequirements.put("§c§lAgressive Golem", 0);	
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
