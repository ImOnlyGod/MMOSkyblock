package CustomEssentials.Utils;

import org.bukkit.entity.Player;

public class ManaUtils {

	public static String getActionBarManaText(Player p,int currentMana,int TotalMana ) {
		return Utils.chat("  &b" + Math.floor(currentMana) + "/" + Math.rint(TotalMana) + "✶ Mana");
	}
}
