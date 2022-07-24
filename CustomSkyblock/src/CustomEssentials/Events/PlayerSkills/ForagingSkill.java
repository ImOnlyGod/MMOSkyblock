package CustomEssentials.Events.PlayerSkills;

import org.bukkit.Material;

public class ForagingSkill extends Skills{

	public Double getXPamount(Material block) {
		
		if (block == Material.OAK_LOG) {
			return 1.0;
		}
		else if (block == Material.BIRCH_LOG) {
			return 2.0;
		}
		else if (block == Material.SPRUCE_LOG) {
			return 3.0;
		}
		else if (block == Material.ACACIA_LOG) {
			return 4.0;
		}
		else if (block == Material.DARK_OAK_LOG) {
			return 5.0;
		}
		else if (block == Material.JUNGLE_LOG) {
			return 6.0;
		}
		
		return 0.0;
	}

}
