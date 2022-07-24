package CustomEssentials.Utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class ArmorUtils {
	
	public static String getActionBarArmorText(Player p) {
		return Utils.chat("  &a" + Math.floor((p.getAttribute(Attribute.GENERIC_ARMOR).getValue())) + "✦ Armor");
	}

}
