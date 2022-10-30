package CustomEssentials.Events.PlayerPath.Paths;

import CustomEssentials.Events.PlayerStats.Stats;

public class Archer extends Path{
	
	//ADD RANGED DMG
	public Archer() {
		super();
		Stats stats = this.getStats();
		stats.setDefaultHealth(100);
		stats.setDefaultArmor(10);
		stats.setDefaultMR(10);
		stats.setDefaultMana(300);
		this.setName("archer");
	}
		
	public void levelUpStats() {
		int level = this.getLevel();
		int prestige = this.getPrestige();
		
		int healthScalar = this.getHealthValue(level, prestige);
		int armorScalar = this.getArmorValue(level, prestige);
		int mrScalar = this.getMRValue(level, prestige);
		int manaScalar = this.getPDamageValue(level, prestige);
		int pDmgScalar = this.getManaValue(level, prestige);
		int mDmgScalar = this.getMDamageValue(level, prestige);
			
		Stats stats = this.getStats();
		stats.setDefaultHealth(stats.getDefaultHealth() + healthScalar);
		stats.setDefaultArmor(stats.getDefaultArmor() + armorScalar);
		stats.setDefaultMR(stats.getDefaultMR() + mrScalar);
		stats.setDefaultMana(stats.getDefaultMana() + manaScalar);
		stats.setDefaultPhysicalDamage(stats.getDefaultPhysicalDamage() + pDmgScalar);
		stats.setDefaultBurstDmg(stats.getBurstDamage() + mDmgScalar);
		
	}
	
	public int getHealthValue(int level, int prestige) {
		return 5 + prestige*level + 2*level;
	}
	public int getArmorValue(int level, int prestige) {
		return  1 + (int) ((prestige*level + 2*level)/10);
	}
	public int getMRValue(int level, int prestige) {
		return 3 + (int) ((prestige*level + 2*level)/10);
	}
	public int getPDamageValue(int level, int prestige) {
		return 20 + (int) ((prestige*level + 2*level)/10);
	}
	public int getManaValue(int level, int prestige) {
		return 30 + prestige*level + 2*level;
	}
	public int getMDamageValue(int level, int prestige) {
		return 0 + (int) ((prestige*level + 2*level)/10);
	}
	
	
	
}

