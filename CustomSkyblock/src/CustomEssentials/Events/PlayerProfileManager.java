package CustomEssentials.Events;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.PlayerPath.Paths.Default;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.PlayerSkills.CombatSkill;
import CustomEssentials.Events.PlayerSkills.FarmingSkill;
import CustomEssentials.Events.PlayerSkills.FishingSkill;
import CustomEssentials.Events.PlayerSkills.ForagingSkill;
import CustomEssentials.Events.PlayerSkills.MiningSkill;
import CustomEssentials.Events.PlayerStats.Stats;

public class PlayerProfileManager {

	
	@SuppressWarnings("unused")
	private Main plugin;
	private Map<UUID, Profile> profiles = new HashMap<UUID, Profile>();
	
	public PlayerProfileManager(Main plugin) {
		this.plugin = plugin;
	}
	
	public void createPlayerProfile(Player p) {
		
		Profile newProfile = new Profile(new Stats(), new MiningSkill(), new CombatSkill(), new FarmingSkill(), new FishingSkill(), new ForagingSkill(),0, new Default());
		UUID playerID = p.getUniqueId();
		
		
		profiles.put(playerID, newProfile);
		
	}
	
	public Profile getPlayerProfile(Player p) {
		
		Profile profile = profiles.get(p.getUniqueId());
		
		return profile;
	}
	
	public void setPlayerProfile(Profile profile, Player p) {
		
		profiles.remove(p.getUniqueId());
		profiles.put(p.getUniqueId(), profile);
	}
	
	public Boolean hasProfile(Player p) {
		
		UUID playerID = p.getUniqueId();
		
		if (profiles.get(playerID) == null) return false;
		
		
		return true;
	}

}
