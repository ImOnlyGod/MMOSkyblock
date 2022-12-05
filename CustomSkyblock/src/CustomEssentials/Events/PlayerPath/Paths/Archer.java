package CustomEssentials.Events.PlayerPath.Paths;

import java.util.ArrayList;

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
		super.levelUpStats();
		int level = this.getLevel();

		int healthScalar = this.getHealthValue(level);
		int armorScalar = this.getArmorValue(level);
		int mrScalar = this.getMRValue(level);
		int manaScalar = this.getPDamageValue(level);
		int pDmgScalar = this.getManaValue(level);
		int mDmgScalar = this.getMDamageValue(level);
			
		Stats stats = this.getStats();
		stats.setDefaultHealth(stats.getDefaultHealth() + healthScalar);
		stats.setDefaultArmor(stats.getDefaultArmor() + armorScalar);
		stats.setDefaultMR(stats.getDefaultMR() + mrScalar);
		stats.setDefaultMana(stats.getDefaultMana() + manaScalar);
		stats.setDefaultPhysicalDamage(stats.getDefaultPhysicalDamage() + pDmgScalar);
		stats.setDefaultBurstDmg(stats.getDefaultBurstDmg() + mDmgScalar);
		
	}
	
	public ArrayList<String> calcLevelUpRewards(int level) {
		ArrayList<String> levelRewards = super.calcLevelUpRewards(level);
		
		return levelRewards;
	}
	
	public int getHealthValue(int level) {
		return (int) (10+Math.floor(level/5));
	}
	public int getArmorValue(int level) {
		return  1 + (int) ((level + 2*level)/10);
	}
	public int getMRValue(int level) {
		return 3 + (int) ((level + 2*level)/10);
	}
	public int getPDamageValue(int level) {
		return 3 + (int) ((level + 2*level)/10);
	}
	public int getManaValue(int level) {
		return 30 + level + 2*level;
	}
	public int getMDamageValue(int level) {
		return 3 + (int) ((level + 2*level)/10);
	}
	
	
	
}

