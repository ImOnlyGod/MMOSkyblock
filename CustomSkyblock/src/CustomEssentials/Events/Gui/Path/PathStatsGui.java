package CustomEssentials.Events.Gui.Path;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Utils.Utils;

public class PathStatsGui {
	
	public PathStatsGui(Player p, Profile playerProfile) {
		
		Path playerPath = playerProfile.getPath();
		String pathName = playerPath.getName().replace(playerPath.getName().charAt(0), playerPath.getName().toUpperCase().charAt(0));
		Inventory gui = Bukkit.createInventory(null, 54,Utils.chat("&b&l"+pathName+" &7&lPath Progression"));
		
		
	
		
		p.openInventory(gui);
	}
}
