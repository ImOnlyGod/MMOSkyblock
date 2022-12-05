package CustomEssentials.Events.PlayerPath.Paths;

import java.util.ArrayList;

import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;

public class Assassin extends Path{
	
	public Assassin() {
		super();
		Stats stats = this.getStats();
		stats.setDefaultPhysicalDamage(300);
		stats.setDefaultMana(300);
		this.setName("assassin");
		
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

