package CustomEssentials.Events.PlayerStats;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Health implements Listener{

	public void setInitalHealth(Player player) {
		
		player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
		player.setHealthScaled(true);
		player.setHealthScale(20);
		
	}

	public void setPlayerHealth(Player p, int health) {
		
		p.setHealthScaled(true);
		p.setHealthScale(20);
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
		
	}

}
