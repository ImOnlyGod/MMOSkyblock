package CustomEssentials.Events.PlayerSkills;

import org.bukkit.Material;

public class FarmingSkill extends Skills{

	public double getXPamount(Material block) {
		
		//ADD LEVEL REQUIREMENT PUT IN HASHMAP FOR ALL CROPS WHEAT LV 1-10 EXAMPLE
		if (block == Material.WHEAT) {
			return 1.0;
		}
		else if (block == Material.CARROTS) {
			return 2.0;
		}
		else if (block == Material.POTATOES) {
			return 2.5;
		}
		else if (block == Material.PUMPKIN) {
			return 3.0;
		}
		else if (block == Material.MELON) {
			return 3.25;
		}
		else if (block == Material.SUGAR_CANE) {
			return 2.5;
		}
		else if (block == Material.CACTUS) {
			return 10.0;
		}
		else if (block == Material.BEETROOTS) {
			return 3.0;
		}
		else if (block == Material.COCOA_BEANS) {
			return 5.0;
		}
		return 0.0;
	}

}
