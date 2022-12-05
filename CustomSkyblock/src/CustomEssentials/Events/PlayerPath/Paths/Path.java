package CustomEssentials.Events.PlayerPath.Paths;

import java.util.ArrayList;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;

public abstract class Path {
	
	private int level; 
	private Double currentXP;
	private Double maxXP;
	private int skillPoints;
	private int skillPointsMax;
	private Stats stats;
	private String name = "path";
	
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
		this.maxXP = 1.3*this.maxXP + (Math.PI * this.maxXP/(Math.E));
		this.levelUpStats();
	}
	
	public void levelUpStats() {
		if (Math.floorMod(this.level, 2) == 1) {
			this.setSkillPoints(this.getSkillPoints() + 1);
			this.setSkillPointsMax(this.getSkillPointsMax() + 1);
		}
	}
	
	public ArrayList<String> calcLevelUpRewards(int level) {
		ArrayList<String> levelRewards = new ArrayList<String>();
		if (Math.floorMod(level, 2) == 1) {
			levelRewards.add(Utils.chat("&b+ &7Skill Point (x1)"));
		}
		
		return levelRewards;
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
		if (this.currentXP >= this.maxXP) this.levelUp();
	}

	public Double getMaxXP() {
		return maxXP;
	}

	public void setMaxXP(Double maxXP) {
		this.maxXP = maxXP;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	public int getSkillPointsMax() {
		return skillPointsMax;
	}

	public void setSkillPointsMax(int skillPointsMax) {
		this.skillPointsMax = skillPointsMax;
	}

}
