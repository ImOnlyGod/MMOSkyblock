package CustomEssentials.Events.Mobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.Items.CustomItems.CompressedItems;

public class MobMappings {
	
	private HashMap<String,Integer> NameToXp = new HashMap<String,Integer>();
	private HashMap<String,Integer> NameToMoney = new HashMap<String,Integer>();
	private HashMap<String,ArrayList<ItemStack>> NameToLuckyDrops = new HashMap<String,ArrayList<ItemStack>>();
	private HashMap<String,ArrayList<Integer>> NameToLuckyDropChance = new HashMap<String,ArrayList<Integer>>();
	
	public MobMappings() {
		this.generateNameToDrops();
		this.generateNameToMoney();
		this.getNameToXp();
	}
	
	public String[] getNameLevel(Entity mob) {
		
		String mobName = mob.getCustomName();
		int leftStringName = mobName.indexOf("]") + 2;
		int rightStringName = mobName.indexOf("(") - 5;		
		int levelLeftString = mobName.indexOf('[') + 5;
		int levelRightString = mobName.indexOf(']') - 4;
		String level = mobName.substring(levelLeftString,levelRightString);
		mobName = mobName.substring(leftStringName, rightStringName);
		
		String[] output = new String[2];
		output[0] = mobName;
		output[1] = level;
		
		return output;
	}
	
	public ArrayList<ItemStack> getLuckyDrops(Entity mob, int luck) {
		String[] mobStats = this.getNameLevel(mob);
		String mobName = mobStats[0];
		int mobLevel = Integer.parseInt(mobStats[1]);
		ArrayList<ItemStack> finalDrops = new ArrayList<ItemStack>();
		
		if (!this.NameToLuckyDropChance.containsKey(mobName)) return finalDrops;

		int i = 0;
		for (int chance: this.NameToLuckyDropChance.get(mobName)) {
			Random rand = new Random();
			if (rand.nextInt((int) (Math.max(1,chance-(mobLevel/10)-(luck*0.1)))) == 0) finalDrops.add(this.NameToLuckyDrops.get(mobName).get(i));
			i++;
		}		
		
		return finalDrops;
	}
	
	public double getXPamount(Entity mob) {
		
		String[] values = getNameLevel(mob);
		String mobName = values[0];
		int level = Integer.valueOf(values[1]);
		
		if (!this.NameToXp.containsKey(mobName)) return 0.0;
		int amount = this.NameToXp.get(mobName) * level;
		
		return amount;
	}
	
	public double getMoneyamount(Entity mob) {
		
		String[] values = getNameLevel(mob);
		String mobName = values[0];
		int level = Integer.valueOf(values[1]);
		
		if (!this.NameToMoney.containsKey(mobName)) return 0.0;
		int amount = this.NameToMoney.get(mobName) * level;
		
		return amount;
	}
	
	public void generateNameToXp() {
		this.NameToXp.put("§6§lAxolotl", 1);
		this.NameToXp.put("§6§lBat", 10);
		this.NameToXp.put("§6§lCat", 3);
		this.NameToXp.put("§6§lChicken", 1);
		this.NameToXp.put("§6§lCod", 1);
		this.NameToXp.put("§6§lCow", 4);
		this.NameToXp.put("§6§lDonkey", 4);
		this.NameToXp.put("§6§lFox", 1);
		this.NameToXp.put("§6§lGlow Squid", 5);
		this.NameToXp.put("§6§lHorse", 4);
		this.NameToXp.put("§6§lMooshroom", 5);
		this.NameToXp.put("§6§lMule", 4);
		this.NameToXp.put("§6§lOcelot", 1);
		this.NameToXp.put("§6§lParrot", 10);
		this.NameToXp.put("§6§lPig", 2);
		this.NameToXp.put("§6§lPufferfish", 4);
		this.NameToXp.put("§6§lRabbit", 3);
		this.NameToXp.put("§6§lSalmon", 1);
		this.NameToXp.put("§6§lSheep", 3);
		this.NameToXp.put("§6§lSkeleton Horse", 4);
		this.NameToXp.put("§6§lSnow Golem", 1);
		this.NameToXp.put("§6§lSquid", 2);
		this.NameToXp.put("§6§lStrider", 6);
		this.NameToXp.put("§6§lTropical Fish", 1);
		this.NameToXp.put("§6§lTurtle", 7);
		this.NameToXp.put("§6§lVillager", 10);
		this.NameToXp.put("§6§lWandering Trader", 10);
		
		this.NameToXp.put("§6§lBee", 2);
		this.NameToXp.put("§6§lCave Spider", 7);
		this.NameToXp.put("§6§lDolphin", 1);
		this.NameToXp.put("§6§lEnderman", 10);
		this.NameToXp.put("§6§lGoat", 3);
		this.NameToXp.put("§6§lIron Golem", 25);
		this.NameToXp.put("§6§lLlama", 4);
		this.NameToXp.put("§6§lPanda", 5);
		this.NameToXp.put("§6§lPolar Bear", 5);
		this.NameToXp.put("§6§lSpider", 6);
		this.NameToXp.put("§6§lWolf", 2);
		this.NameToXp.put("§6§lZombified Piglin", 9);
		
		this.NameToXp.put("§6§lBlaze", 15);
		this.NameToXp.put("§6§lCreeper", 12);
		this.NameToXp.put("§6§lDrowned", 8);
		this.NameToXp.put("§6§lElder Guardian", 50);
		this.NameToXp.put("§6§lEndermite", 6);
		this.NameToXp.put("§6§lEvoker", 20);
		this.NameToXp.put("§6§lGhast", 15);
		this.NameToXp.put("§6§lGuardian", 10);
		this.NameToXp.put("§6§lHoglin", 8);
		this.NameToXp.put("§6§lHusk", 9);
		this.NameToXp.put("§6§lMagma Cube", 5);
		this.NameToXp.put("§6§lPhantom", 20);
		this.NameToXp.put("§6§lPiglin Brute", 20);
		this.NameToXp.put("§6§lPiglin", 10);
		this.NameToXp.put("§6§lPillager", 7);
		this.NameToXp.put("§6§lRavager", 20);
		this.NameToXp.put("§6§lShulker", 5);
		this.NameToXp.put("§6§lSilverfish", 3);
		this.NameToXp.put("§6§lSkeleton", 7);
		this.NameToXp.put("§6§lSlime", 4);
		this.NameToXp.put("§6§lStray", 8);
		this.NameToXp.put("§6§lVex", 20);
		this.NameToXp.put("§6§lVindicator", 15);
		this.NameToXp.put("§6§lWitch", 10);
		this.NameToXp.put("§6§lWither Skeleton", 12);
		this.NameToXp.put("§6§lZoglin", 8);
		this.NameToXp.put("§6§lZombie Villager", 6);
		this.NameToXp.put("§6§lZombie", 6);
		
		this.NameToXp.put("§7§lBasic Zombie", 10);
		this.NameToXp.put("§5§lWild Pig", 2);
		this.NameToXp.put("§c§lAgressive Golem", 25);
		
	}
	
	public void generateNameToMoney() {
		
		this.NameToMoney.put("§6§lAxolotl", 1);
		this.NameToMoney.put("§6§lBat", 10);
		this.NameToMoney.put("§6§lCat", 3);
		this.NameToMoney.put("§6§lChicken", 1);
		this.NameToMoney.put("§6§lCod", 1);
		this.NameToMoney.put("§6§lCow", 4);
		this.NameToMoney.put("§6§lDonkey", 4);
		this.NameToMoney.put("§6§lFox", 1);
		this.NameToMoney.put("§6§lGlow Squid", 5);
		this.NameToMoney.put("§6§lHorse", 4);
		this.NameToMoney.put("§6§lMooshroom", 5);
		this.NameToMoney.put("§6§lMule", 4);
		this.NameToMoney.put("§6§lOcelot", 1);
		this.NameToMoney.put("§6§lParrot", 10);
		this.NameToMoney.put("§6§lPig", 2);
		this.NameToMoney.put("§6§lPufferfish", 4);
		this.NameToMoney.put("§6§lRabbit", 3);
		this.NameToMoney.put("§6§lSalmon", 1);
		this.NameToMoney.put("§6§lSheep", 3);
		this.NameToMoney.put("§6§lSkeleton Horse", 4);
		this.NameToMoney.put("§6§lSnow Golem", 1);
		this.NameToMoney.put("§6§lSquid", 2);
		this.NameToMoney.put("§6§lStrider", 6);
		this.NameToMoney.put("§6§lTropical Fish", 1);
		this.NameToMoney.put("§6§lTurtle", 7);
		this.NameToMoney.put("§6§lVillager", 10);
		this.NameToMoney.put("§6§lWandering Trader", 10);
		
		this.NameToMoney.put("§6§lBee", 2);
		this.NameToMoney.put("§6§lCave Spider", 7);
		this.NameToMoney.put("§6§lDolphin", 1);
		this.NameToMoney.put("§6§lEnderman", 10);
		this.NameToMoney.put("§6§lGoat", 3);
		this.NameToMoney.put("§6§lIron Golem", 25);
		this.NameToMoney.put("§6§lLlama", 4);
		this.NameToMoney.put("§6§lPanda", 5);
		this.NameToMoney.put("§6§lPolar Bear", 5);
		this.NameToMoney.put("§6§lSpider", 6);
		this.NameToMoney.put("§6§lWolf", 2);
		this.NameToMoney.put("§6§lZombified Piglin", 9);
		
		this.NameToMoney.put("§6§lBlaze", 15);
		this.NameToMoney.put("§6§lCreeper", 12);
		this.NameToMoney.put("§6§lDrowned", 8);
		this.NameToMoney.put("§6§lElder Guardian", 50);
		this.NameToMoney.put("§6§lEndermite", 6);
		this.NameToMoney.put("§6§lEvoker", 20);
		this.NameToMoney.put("§6§lGhast", 15);
		this.NameToMoney.put("§6§lGuardian", 10);
		this.NameToMoney.put("§6§lHoglin", 8);
		this.NameToMoney.put("§6§lHusk", 9);
		this.NameToMoney.put("§6§lMagma Cube", 5);
		this.NameToMoney.put("§6§lPhantom", 20);
		this.NameToMoney.put("§6§lPiglin Brute", 20);
		this.NameToMoney.put("§6§lPiglin", 10);
		this.NameToMoney.put("§6§lPillager", 7);
		this.NameToMoney.put("§6§lRavager", 20);
		this.NameToMoney.put("§6§lShulker", 5);
		this.NameToMoney.put("§6§lSilverfish", 3);
		this.NameToMoney.put("§6§lSkeleton", 7);
		this.NameToMoney.put("§6§lSlime", 4);
		this.NameToMoney.put("§6§lStray", 8);
		this.NameToMoney.put("§6§lVex", 20);
		this.NameToMoney.put("§6§lVindicator", 15);
		this.NameToMoney.put("§6§lWitch", 10);
		this.NameToMoney.put("§6§lWither Skeleton", 12);
		this.NameToMoney.put("§6§lZoglin", 8);
		this.NameToMoney.put("§6§lZombie Villager", 6);
		this.NameToMoney.put("§6§lZombie", 6);
		
		this.NameToMoney.put("§7§lBasic Zombie", 10);
		this.NameToMoney.put("§5§lWild Pig", 2);
		this.NameToMoney.put("§c§lAgressive Golem", 25);
		
	}

	public void generateNameToDrops() {
		ArrayList<ItemStack> wildPigDrops = new ArrayList<ItemStack>();
		wildPigDrops.add(new CompressedItems().createItem(Material.PORKCHOP,1));
		ArrayList<Integer> wildPigDropChance = new ArrayList<Integer>();
		wildPigDropChance.add(30);
		this.NameToLuckyDrops.put("§5§lWild Pig", wildPigDrops);
		this.NameToLuckyDropChance.put("§5§lWild Pig", wildPigDropChance);
		
		ArrayList<ItemStack> agressiveGolemDrops = new ArrayList<ItemStack>();
		agressiveGolemDrops.add(new CompressedItems().createItem(Material.IRON_INGOT,1));
		ArrayList<Integer> gressiveGolemDropChance = new ArrayList<Integer>();
		gressiveGolemDropChance.add(25);
		this.NameToLuckyDrops.put("§c§lAgressive Golem", agressiveGolemDrops);
		this.NameToLuckyDropChance.put("§c§lAgressive Golem", gressiveGolemDropChance);
	}

	public HashMap<String, Integer> getNameToXp() {
		return NameToXp;
	}

	public void setNameToXp(HashMap<String, Integer> nameToXp) {
		NameToXp = nameToXp;
	}

	public HashMap<String, Integer> getNameToMoney() {
		return NameToMoney;
	}

	public void setNameToMoney(HashMap<String, Integer> nameToMoney) {
		NameToMoney = nameToMoney;
	}

	public HashMap<String,ArrayList<ItemStack>> getNameToLuckyDrops() {
		return NameToLuckyDrops;
	}

	public void setNameToLuckyDrops(HashMap<String,ArrayList<ItemStack>> nameToLuckyDrops) {
		NameToLuckyDrops = nameToLuckyDrops;
	}

	public HashMap<String,ArrayList<Integer>> getNameToLuckyDropChance() {
		return NameToLuckyDropChance;
	}

	public void setNameToLuckyDropChance(HashMap<String,ArrayList<Integer>> nameToLuckyDropChance) {
		NameToLuckyDropChance = nameToLuckyDropChance;
	}




	
	
}	
