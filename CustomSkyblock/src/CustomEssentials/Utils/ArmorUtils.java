package CustomEssentials.Utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import CustomEssentials.Events.Profile;

public class ArmorUtils {
	
	public static String getActionBarArmorText(Profile p) {
		return Utils.chat("  &a" + Math.floor((p.getStats().getArmor())) + "✦ Armor");
	}

}
