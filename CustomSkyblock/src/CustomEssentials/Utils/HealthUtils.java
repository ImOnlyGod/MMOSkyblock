package CustomEssentials.Utils;

import org.bukkit.entity.Player;

public class HealthUtils {
	
	public static String getActionBarHealthText(Player p) {
		return Utils.chat("&c" + Math.floor(p.getHealth()) + "/" + Math.rint(p.getMaxHealth()) + "♥");
	}

}
