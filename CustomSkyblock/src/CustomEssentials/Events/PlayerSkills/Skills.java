package CustomEssentials.Events.PlayerSkills;

public abstract class Skills {

	private int level; 
	private Double currentXP;
	private Double maxXP;
	private double previousXpAmountGained;
	private double xpMultiplier;
	private double globalXpMultiplier;
	
	public Skills() {
		
		this.setLevel(0);
		this.setCurrentXP(0.0);
		this.setMaxXP(10.0);
		this.setXpMultiplier(1);
		this.setGlobalXpMultiplier(1);
	}
	
	public void levelUp() {
		this.level ++;		
		this.currentXP = Math.max(0,this.currentXP - this.maxXP);
		if (level < 11) this.maxXP = 2*this.maxXP;
		else if (level > 10 && level < 20)  this.maxXP = 1.5*this.maxXP;
		else if (level > 20 && level < 30) this.maxXP = 1.2*this.maxXP;
		else if (level > 30 && level < 40) this.maxXP = 1.01*this.maxXP;
		else  this.maxXP = 1.001*this.maxXP;
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
		this.currentXP = this.getGlobalXpMultiplier() * this.xpMultiplier * (this.currentXP + amount);
		this.setPreviousXpAmountGained(amount);
	}

	public Double getMaxXP() {
		return maxXP;
	}

	public void setMaxXP(Double maxXP) {
		this.maxXP = maxXP;
	}

	public double getPreviousXpAmountGained() {
		return previousXpAmountGained;
	}

	public void setPreviousXpAmountGained(double previousXpAmountGained) {
		this.previousXpAmountGained = previousXpAmountGained;
	}

	public double getXpMultiplier() {
		return xpMultiplier;
	}

	public void setXpMultiplier(double xpMultiplier) {
		this.xpMultiplier = xpMultiplier;
	}

	public double getGlobalXpMultiplier() {
		return globalXpMultiplier;
	}

	public void setGlobalXpMultiplier(double globalXpMultiplier) {
		this.globalXpMultiplier = globalXpMultiplier;
	}
	
}
