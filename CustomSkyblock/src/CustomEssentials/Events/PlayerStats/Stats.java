package CustomEssentials.Events.PlayerStats;

import java.util.ArrayList;

import CustomEssentials.Utils.Utils;

public class Stats {
	

	private int health;
	private int armor;
	private int magicResist;
	private int physicalDamage;
	private int magicDamage;
	private int mana;
	private int totalMana;
	private double speed;
	private double criticalDamage;
	private double criticalChance;
	private double burstDamage;
	private double burstChance;
	private int cooldownReduction;
	private double lifeSteal;
	private int defaultPhysicalDamage;
	private int defaultMagicDamage;
	private int defaultMana;
	private int defaultHealth;
	private int defaultArmor;
	private int defaultMR;
	private double defaultSpeed;
	private double defaultCritDmg;
	private double defaultCritChance;
	private double defaultBurstDmg;
	private double defaultBurstChance;
	private double defaultCDR;
	private double defaultLifeSteal;
	private int manaRegen;
	private int defaultManaRegen;
	private int luck;
	private int defaultLuck;
	
	private int rangedDamage;
	private double attackSpeed;
	private double omnivamp;	
	
	private double miningFortune;
	private double farmingFortune;
	private double lootingFortune;
	private double fishingFortune;
	
	private int defaultRangedDamage;
	private double defaultAttackSpeed;
	private double defaultOmnivamp;	
	
	private double defaultMiningFortune;
	private double defaultFarmingFortune;
	private double defaultLootingFortune;
	private double defaultFishingFortune;	

	public Stats(int health, int armor, int magicResist, int physicalDamage, int magicDamage, int mana, int totalMana,
			int speed, double criticalDamage, double criticalChance, double burstDamage, double burstChance, 
			int cooldownReduction,int defaultMana, int defaultHealth, int defaultArmor, int defaultMR, int defaultSpeed,
			double defaultCritDmg, double defaultCritChance, double defaultBurstDmg, double defaultBurstChance, 
			double defaultCDR, int defaultPhysicalDamage, double lifeSteal, double defaultLifeSteal,int defaultMagicDamage, 
			int manaRegen, int defaultManaRegen, int luck, int defaultLuck, int rangedDamage, int defaultRangedDamage,
			double attackSpeed, double omnivamp, double miningFortune, double farmingFortune, double lootingFortune, double fishingFortune,
			double defaultAttackSpeed, double defaultOmnivamp, double defaultMiningFortune, double defaultFarmingFortune, double defaultLootingFortune, double defaultFishingFortune) {
		this.health = health;
		this.armor = armor;
		this.magicResist= magicResist;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
		this.mana = mana;
		this.totalMana = totalMana;
		this.speed = speed;
		this.criticalDamage = criticalDamage;
		this.setCriticalChance(criticalChance);
		this.burstDamage = burstDamage;
		this.setBurstChance(burstChance);
		this.cooldownReduction = cooldownReduction;
		this.defaultMana = defaultMana;
		this.defaultHealth = defaultHealth;
		this.defaultArmor = defaultArmor;
		this.defaultMR = defaultMR;
		this.defaultSpeed = defaultSpeed;
		this.defaultCritDmg = defaultCritDmg;
		this.defaultCritChance = defaultCritChance;
		this.defaultBurstDmg = defaultBurstDmg;
		this.defaultBurstChance =  defaultBurstChance;
		this.defaultCDR = defaultCDR;
		this.defaultPhysicalDamage = defaultPhysicalDamage;
		this.lifeSteal = lifeSteal;
		this.defaultLifeSteal = defaultLifeSteal;
		this.defaultMagicDamage = defaultMagicDamage;
		this.manaRegen = manaRegen;
		this.defaultManaRegen = defaultManaRegen;
		this.luck = luck;
		this.defaultLuck = defaultLuck;
		this.rangedDamage = rangedDamage;
		this.attackSpeed = attackSpeed;
		this.omnivamp = omnivamp;
		this.miningFortune = miningFortune;
		this.farmingFortune = farmingFortune;
		this.lootingFortune = lootingFortune;
		this.fishingFortune = fishingFortune;
		this.defaultRangedDamage = defaultRangedDamage;
		this.defaultAttackSpeed = defaultAttackSpeed;
		this.defaultOmnivamp = defaultOmnivamp;
		this.defaultMiningFortune = defaultMiningFortune;
		this.defaultFarmingFortune = defaultFarmingFortune;
		this.defaultLootingFortune = defaultLootingFortune;
		this.defaultFishingFortune = defaultFishingFortune;
	}
	
	public Stats() {
		this.health = 100;
		this.armor = 10;
		this.magicResist = 0;
		this.physicalDamage = 10;
		this.magicDamage = 0;
		this.mana = 100;
		this.totalMana = 100;
		this.speed = 100;
		this.criticalDamage = 1.25;
		this.setCriticalChance(0);
		this.burstDamage = 1.25;
		this.setBurstChance(0);
		this.cooldownReduction = 0;
		this.defaultMana = 100;
		this.defaultHealth = 100;
		this.defaultArmor = 10;
		this.defaultMR = 0;
		this.defaultSpeed = 100;
		this.defaultCritDmg = 1.25;
		this.defaultCritChance = 0;
		this.defaultBurstDmg = 0;
		this.defaultBurstChance =  0;
		this.defaultCDR = 0;
		this.defaultPhysicalDamage = 10;
		this.lifeSteal = 0;
		this.defaultLifeSteal = 0;
		this.defaultMagicDamage = 0;
		this.manaRegen = 1;
		this.defaultManaRegen = 1;
		this.luck = 0;
		this.defaultLuck = 0;	
		this.rangedDamage = 0;
		this.attackSpeed = 1;
		this.omnivamp = 0;
		this.miningFortune = 0;
		this.farmingFortune = 0;
		this.lootingFortune = 0;
		this.fishingFortune = 0;
		this.defaultRangedDamage = 0;
		this.defaultAttackSpeed = 1;
		this.defaultOmnivamp = 0;
		this.defaultMiningFortune = 0;
		this.defaultFarmingFortune = 0;
		this.defaultLootingFortune = 0;
		this.defaultFishingFortune = 0;
	}
	
	public void resetStats() {
		this.health = 0;
		this.armor = 0;
		this.magicResist = 0;
		this.physicalDamage = 0;
		this.magicDamage = 0;
		this.mana = 0;
		this.totalMana = 0;
		this.speed = 0;
		this.criticalDamage = 0;
		this.setCriticalChance(0);
		this.burstDamage = 0;
		this.setBurstChance(0);
		this.cooldownReduction = 0;
		this.defaultMana = 0;
		this.defaultHealth = 0;
		this.defaultArmor = 0;
		this.defaultMR = 0;
		this.defaultSpeed = 0;
		this.defaultCritDmg = 0;
		this.defaultCritChance = 0;
		this.defaultBurstDmg = 0;
		this.defaultBurstChance =  0;
		this.defaultCDR = 0;
		this.defaultPhysicalDamage = 0;
		this.lifeSteal = 0;
		this.defaultLifeSteal = 0;
		this.defaultMagicDamage = 0;
		this.manaRegen = 0;
		this.defaultManaRegen = 0;
		this.luck = 0;
		this.defaultLuck = 0;
		
	}

	public int getDefaultPhysicalDamage() {
		return defaultPhysicalDamage;
	}

	public void setDefaultPhysicalDamage(int defaultPhysicalDamage) {
		this.defaultPhysicalDamage = defaultPhysicalDamage;
	}

	public int getDefaultMana() {
		return defaultMana;
	}

	public int getDefaultHealth() {
		return defaultHealth;
	}

	public int getDefaultArmor() {
		return defaultArmor;
	}

	public int getDefaultMR() {
		return defaultMR;
	}

	public double getDefaultSpeed() {
		return defaultSpeed;
	}

	public double getDefaultCritDmg() {
		return defaultCritDmg;
	}

	public double getDefaultCritChance() {
		return defaultCritChance;
	}

	public double getDefaultBurstDmg() {
		return defaultBurstDmg;
	}

	public double getDefaultBurstChance() {
		return defaultBurstChance;
	}

	public double getDefaultCDR() {
		return defaultCDR;
	}

	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}

	public void setDefaultMana(int defaultMana) {
		this.defaultMana = defaultMana;
	}

	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}

	public void setDefaultArmor(int defaultArmor) {
		this.defaultArmor = defaultArmor;
	}

	public void setDefaultMR(int defaultMR) {
		this.defaultMR = defaultMR;
	}

	public void setDefaultSpeed(double defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}

	public void setDefaultCritDmg(double defaultCritDmg) {
		this.defaultCritDmg = defaultCritDmg;
	}

	public void setDefaultCritChance(double defaultCritChance) {
		this.defaultCritChance = defaultCritChance;
	}

	public void setDefaultBurstDmg(double defaultBurstDmg) {
		this.defaultBurstDmg = defaultBurstDmg;
	}

	public void setDefaultBurstChance(double defaultBurstChance) {
		this.defaultBurstChance = defaultBurstChance;
	}

	public void setDefaultCDR(double defaultCDR) {
		this.defaultCDR = defaultCDR;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getTotalMana() {
		return this.totalMana;
	}

	public void setTotalMana(int totalMana) {
		this.totalMana = totalMana;
	}

	public int getMagicResist() {
		return magicResist;
	}

	public void setMagicResist(int magicResist) {
		this.magicResist = magicResist;
	}

	public int getMagicDamage() {
		return magicDamage;
	}

	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double d) {
		this.speed = d;
	}

	public int getPhysicalDamage() {
		return physicalDamage;
	}

	public void setPhysicalDamage(int physicalDamage) {
		this.physicalDamage = physicalDamage;
	}

	public double getCriticalDamage() {
		return criticalDamage;
	}

	public void setCriticalChance(int criticalChance) {
		this.criticalChance = criticalChance;
	}

	public double getBurstDamage() {
		return burstDamage;
	}

	public void setBurstDamage(double burstDamage) {
		this.burstDamage = burstDamage;
	}

	public int getCooldownReduction() {
		return cooldownReduction;
	}

	public void setCooldownReduction(int cooldownReduction) {
		this.cooldownReduction = cooldownReduction;
	}

	public double getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}

	public double getBurstChance() {
		return burstChance;
	}

	public void setBurstChance(double burstChance) {
		this.burstChance = burstChance;
	}

	public double getLifeSteal() {
		return lifeSteal;
	}

	public void setLifeSteal(double lifeSteal) {
		this.lifeSteal = lifeSteal;
	}

	public double getDefaultLifeSteal() {
		return defaultLifeSteal;
	}

	public void setDefaultLifeSteal(double defaultLifeSteal) {
		this.defaultLifeSteal = defaultLifeSteal;
	}
	
	public double getLifeStealHealAmount(double damage) {
		return (this.getLifeSteal()*damage)/100;

	}
	
	//String of stats with amount
	public ArrayList<String> calclevelUpMining(int level) {
		int scalar = (level+"").length();
		ArrayList<String> result = new ArrayList<String>();
		result.add(Utils.chat("&7" + scalar + " &aArmor"));
		if (((int) scalar/2) <1) result.add(Utils.chat("&7" + scalar + " &5Magic Resist"));
		return result;
		
	}
	
	public ArrayList<String> calclevelUpFarming(int level) {
		int scalar = (level+"").length();
		ArrayList<String> result = new ArrayList<String>();
		result.add(Utils.chat("&7" + ((int) 1.2*(scalar+1)) + " &cHealth"));
		return result;
		
	}
	
	public ArrayList<String> calclevelUpCombat(int level) {
		int scalar = (level+"").length();
		ArrayList<String> result = new ArrayList<String>();
		result.add(Utils.chat("&7" + 0.25 + "x &bCrit Chance"));
		result.add(Utils.chat("&7" + (0.1*scalar) + "x &bCrit Damage"));
		return result;
		
	}
	
	public ArrayList<String> calclevelUpForaging(int level) {
		int scalar = (level+"").length();
		ArrayList<String> result = new ArrayList<String>();
		result.add(Utils.chat("&7" + (2*scalar) + " &4Damage"));
		return result;
		
	}
		
	public ArrayList<String> calclevelUpFishing(int level) {
		int scalar = (level+"").length();
		ArrayList<String> result = new ArrayList<String>();
		return result;
		
	}
	
	public void levelUpMining(int level) {
		int scalar = (level+"").length();
		this.defaultArmor += scalar;
		this.defaultMR += (int)scalar/2;
		
	}

	public void levelUpFarming(int level) {
		int scalar = (level+"").length();
		this.defaultHealth += (int) 1.2*(scalar+1);
		
	}
	
	public void levelUpCombat(int level) {
		int scalar = (level+"").length();
		this.defaultCritChance += 0.25;
		this.defaultCritDmg += (scalar * 0.1);
		
	}
	
	public void levelUpForaging(int level) {
		int scalar = (level+"").length();
		this.defaultPhysicalDamage += 2*(scalar);
		this.defaultSpeed += 1;
		
	}
	
	public void levelUpFishing(int level) {
		int scalar = (level+"").length();
		
	}
	
	public void levelDownMining(int level) {
		int scalar = (level+"").length();
		this.defaultArmor -= scalar;
		this.defaultMR -= (int)scalar/2;
		
	}

	public void levelDownFarming(int level) {
		int scalar = (level+"").length();
		this.defaultHealth -= (int) 1.2*(scalar+1);
		
	}
	
	public void levelDownCombat(int level) {
		int scalar = (level+"").length();
		this.defaultCritChance -= 0.25;
		this.defaultCritDmg -= (scalar * 0.1);
		
	}
	
	public void levelDownForaging(int level) {
		int scalar = (level+"").length();
		this.defaultPhysicalDamage -= 2*(scalar);
		this.defaultSpeed -= 1;
		
	}
	
	public void levelDownFishing(int level) {
		int scalar = (level+"").length();
		
	}

	public int getDefaultMagicDamage() {
		return defaultMagicDamage;
	}

	public void setDefaultMagicDamage(int defaultMagicDamage) {
		this.defaultMagicDamage = defaultMagicDamage;
	}

	public int getManaRegen() {
		return manaRegen;
	}

	public void setManaRegen(int manaRegen) {
		this.manaRegen = manaRegen;
	}

	public int getDefaultManaRegen() {
		return defaultManaRegen;
	}

	public void setDefaultManaRegen(int defaultManaRegen) {
		this.defaultManaRegen = defaultManaRegen;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getDefaultLuck() {
		return defaultLuck;
	}

	public void setDefaultLuck(int defaultLuck) {
		this.defaultLuck = defaultLuck;
	}

	public int getRangedDamage() {
		return rangedDamage;
	}

	public void setRangedDamage(int rangedDamage) {
		this.rangedDamage = rangedDamage;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public double getOmnivamp() {
		return omnivamp;
	}

	public void setOmnivamp(double omnivamp) {
		this.omnivamp = omnivamp;
	}

	public double getMiningFortune() {
		return miningFortune;
	}

	public void setMiningFortune(double miningFortune) {
		this.miningFortune = miningFortune;
	}

	public double getFarmingFortune() {
		return farmingFortune;
	}

	public void setFarmingFortune(double farmingFortune) {
		this.farmingFortune = farmingFortune;
	}

	public double getLootingFortune() {
		return lootingFortune;
	}

	public void setLootingFortune(double lootingFortune) {
		this.lootingFortune = lootingFortune;
	}

	public double getFishingFortune() {
		return fishingFortune;
	}

	public void setFishingFortune(double fishingFortune) {
		this.fishingFortune = fishingFortune;
	}

	public int getDefaultRangedDamage() {
		return defaultRangedDamage;
	}

	public void setDefaultRangedDamage(int defaultRangedDamage) {
		this.defaultRangedDamage = defaultRangedDamage;
	}

	public double getDefaultAttackSpeed() {
		return defaultAttackSpeed;
	}

	public void setDefaultAttackSpeed(double defaultAttackSpeed) {
		this.defaultAttackSpeed = defaultAttackSpeed;
	}

	public double getDefaultOmnivamp() {
		return defaultOmnivamp;
	}

	public void setDefaultOmnivamp(double defaultOmnivamp) {
		this.defaultOmnivamp = defaultOmnivamp;
	}

	public double getDefaultMiningFortune() {
		return defaultMiningFortune;
	}

	public void setDefaultMiningFortune(double defaultMiningFortune) {
		this.defaultMiningFortune = defaultMiningFortune;
	}

	public double getDefaultFarmingFortune() {
		return defaultFarmingFortune;
	}

	public void setDefaultFarmingFortune(double defaultFarmingFortune) {
		this.defaultFarmingFortune = defaultFarmingFortune;
	}

	public double getDefaultLootingFortune() {
		return defaultLootingFortune;
	}

	public void setDefaultLootingFortune(double defaultLootingFortune) {
		this.defaultLootingFortune = defaultLootingFortune;
	}

	public double getDefaultFishingFortune() {
		return defaultFishingFortune;
	}

	public void setDefaultFishingFortune(double defaultFishingFortune) {
		this.defaultFishingFortune = defaultFishingFortune;
	}

}
