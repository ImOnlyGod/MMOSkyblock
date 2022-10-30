package CustomEssentials.Events;

import java.util.HashMap;

import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Default;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
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
	private HashMap<String,Path> paths = new HashMap<String,Path>();
	
	public Profile(Stats newStats, MiningSkill mining, CombatSkill combat, FarmingSkill farming, FishingSkill fishing, ForagingSkill foraging, int playTime) {
		this.stats = newStats;
		this.mining = mining;
		this.combat = combat;
		this.farming = farming;
		this.fishing = fishing;
		this.foraging = foraging;
		this.playTime = playTime;
		this.initialisePaths();
		this.setPath(this.paths.get("default"));
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

	public HashMap<String,Path> getPaths() {
		return paths;
	}

	public void setPaths(HashMap<String,Path> paths) {
		this.paths = paths;
	}
	
	public void initialisePaths() {
		this.paths.put("default", new Default());
		this.paths.put("tank", new Tank());
		this.paths.put("archer", new Archer());
		this.paths.put("assassin", new Assassin());
	}
	

}
