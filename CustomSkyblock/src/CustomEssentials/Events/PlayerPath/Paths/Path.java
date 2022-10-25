package CustomEssentials.Events.PlayerPath.Paths;

import CustomEssentials.Events.PlayerStats.Stats;

public abstract class Path {
	
	private int level; 
	private Double currentXP;
	private Double maxXP;
	private int prestige;
	private Stats stats;
	
	public Path() {
		
		this.setLevel(0);
		this.setCurrentXP(0.0);
		this.setMaxXP(100.0);
		this.stats = new Stats();
		this.stats.resetStats();
	}
	
	public void levelUp() {
		this.level ++;		
		this.currentXP = this.currentXP - this.maxXP;
		this.maxXP = 2*this.maxXP + (Math.PI * this.maxXP/(Math.E));
		this.levelUpStats();
	}
	
	public void levelUpStats() {
	}
	
	public void prestigeUp() {
		this.setLevel(0);
		this.setCurrentXP(0.0);
		this.setMaxXP(100.0);
		this.prestige++;
		this.stats.resetStats();   
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Double getCurrentXP() {
		return currentXP;
	}

	public void setCurrentXP(Double currentXP) {
		this.currentXP = currentXP;
	}
	
	public void addCurrentXP(Double amount) {
		this.currentXP = this.currentXP + amount;
	}

	public Double getMaxXP() {
		return maxXP;
	}

	public void setMaxXP(Double maxXP) {
		this.maxXP = maxXP;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

}
