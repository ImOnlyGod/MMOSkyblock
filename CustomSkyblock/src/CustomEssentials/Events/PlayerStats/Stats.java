package CustomEssentials.Events.PlayerStats;

public class Stats {
	

	private int health;
	private int armor;
	private int magicResist;
	private int physicalDamage;
	private int magicDamage;
	private int mana;
	private int totalMana;
	private int speed;
	private double criticalDamage;
	private double criticalChance;
	private double burstDamage;
	private double burstChance;
	private int cooldownReduction;
	private int defaultPhysicalDamage;
	private int defaultMana;
	private int defaultHealth;
	private int defaultArmor;
	private int defaultMR;
	private int defaultSpeed;
	private double defaultCritDmg;
	private double defaultCritChance;
	private double defaultBurstDmg;
	private double defaultBurstChance;
	private double defaultCDR;
	

	public Stats(int health, int armor, int magicResist, int physicalDamage, int magicDamage, int mana, int totalMana,
			int speed, double criticalDamage, double criticalChance, double burstDamage, double burstChance, 
			int cooldownReduction,int defaultMana, int defaultHealth, int defaultArmor, int defaultMR, int defaultSpeed,
			double defaultCritDmg, double defaultCritChance, double defaultBurstDmg, double defaultBurstChance, 
			double defaultCDR, int defaultPhysicalDamage) {
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

	public int getDefaultSpeed() {
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

	public void setDefaultSpeed(int defaultSpeed) {
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
	

}
