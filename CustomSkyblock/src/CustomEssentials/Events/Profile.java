package CustomEssentials.Events;

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
	
	public Profile(Stats newStats, MiningSkill mining, CombatSkill combat, FarmingSkill farming, FishingSkill fishing, ForagingSkill foraging) {
		this.stats = newStats;
		this.mining = mining;
		this.combat = combat;
		this.farming = farming;
		this.fishing = fishing;
		this.foraging = foraging;
		
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
	

}
