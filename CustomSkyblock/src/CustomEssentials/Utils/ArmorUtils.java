package CustomEssentials.Utils;

import CustomEssentials.Events.Profile;

public class ArmorUtils {
	
	public static String getActionBarArmorText(Profile p) {
		return Utils.chat("  &a" + Math.floor((p.getStats().getArmor())) + "✦ Armor");
	}

}
