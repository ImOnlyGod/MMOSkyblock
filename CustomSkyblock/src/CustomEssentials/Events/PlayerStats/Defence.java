package CustomEssentials.Events.PlayerStats;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import CustomEssentials.Events.Profile;

public class Defence implements Listener{

public void setInitalArmor(Player player) {
		
		player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);
		
	}

public void setArmor(Player p, int armor, int magicResist) {
	p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(armor);
	
}

}
