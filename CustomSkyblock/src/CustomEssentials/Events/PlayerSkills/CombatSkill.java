package CustomEssentials.Events.PlayerSkills;

import org.bukkit.entity.EntityType;

public class CombatSkill extends Skills {
	//DO WITH MOB SAME SO NO CONFUSION FOR CUSTOM MOBS
	public Double getXPamount(EntityType mob) {
		
		if (mob.equals(EntityType.CREEPER)) {
			return 10.0;
		}
		else if (mob.equals(EntityType.ZOMBIE)) {
			return 5.0;
		}
		else if (mob.equals(EntityType.SKELETON)) {
			return 5.0;
		}
		
		return 0.0;
	}
}
