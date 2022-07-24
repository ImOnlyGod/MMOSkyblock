package CustomEssentials.Events.PlayerSkills;

import org.bukkit.Material;

public class MiningSkill extends Skills{
	
	public Double getXPamount(Material block) {
		
		if (block == Material.STONE) {
			return 1.0;
		}
		else if (block == Material.COBBLESTONE) {
			return 1.2;
		}
		else if (block == Material.COAL_ORE)  {
			return 2.0;
		}
		else if (block == Material.IRON_ORE)  {
			return 3.0;
		}
		else if (block == Material.LAPIS_ORE)  {
			return 4.0;
		}
		else if (block == Material.REDSTONE_ORE)  {
			return 5.0;
		}
		else if (block == Material.GOLD_ORE)  {
			return 7.5;
		}
		else if (block == Material.DIAMOND_ORE)  {
			return 10.0;
		}
		else if (block == Material.EMERALD_ORE)  {
			return 15.0;
		}
		
		return 0.0;
		
	}
	
}
