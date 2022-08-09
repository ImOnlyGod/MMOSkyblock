package CustomEssentials.Events;

import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Events.PlayerSkills.CombatSkill;
import CustomEssentials.Events.PlayerSkills.FarmingSkill;
import CustomEssentials.Events.PlayerSkills.FishingSkill;
import CustomEssentials.Events.PlayerSkills.ForagingSkill;
import CustomEssentials.Events.PlayerSkills.MiningSkill;
import CustomEssentials.Events.PlayerStats.Stats;

public class Profile {

	private Stats stats;
	private MiningSkill mining;
	private CombatSkill combat;
	private FarmingSkill farming;
	private FishingSkill fishing;
	private ForagingSkill foraging;
	private int playTime; //Seconds
	private Path path;
	
	public Profile(Stats newStats, MiningSkill mining, CombatSkill combat, FarmingSkill farming, FishingSkill fishing, ForagingSkill foraging, int playTime, Path path) {
		this.stats = newStats;
		this.mining = mining;
		this.combat = combat;
		this.farming = farming;
		this.fishing = fishing;
		this.foraging = foraging;
		this.playTime = playTime;
		this.setPath(path);
		
	}
	
	public CombatSkill getCombat() {
		return combat;
	}

	public FarmingSkill getFarming() {
		return farming;
	}

	public FishingSkill getFishing() {
		return fishing;
	}

	public ForagingSkill getForaging() {
		return foraging;
	}
	
	public MiningSkill getMining() {
		return mining;
	}

	public Stats getStats() {
		
		return this.stats;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	
	public void incrementPlayTime() {
		this.playTime += 1;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	

}
