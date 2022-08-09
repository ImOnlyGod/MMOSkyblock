package CustomEssentials.Events.PlayerPath.Paths;

public abstract class Path {
	
	private int level; 
	private Double currentXP;
	private Double maxXP;
	private int prestige;
	
	public Path() {
		
		this.setLevel(0);
		this.setCurrentXP(0.0);
		this.setMaxXP(100.0);
	}
	
	public void levelUp() {
		this.level ++;		
		this.currentXP = this.currentXP - this.maxXP;
		this.maxXP = 2*this.maxXP + (Math.PI * this.maxXP/(Math.E));
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