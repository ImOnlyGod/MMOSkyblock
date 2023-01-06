package CustomEssentials.Events.PlayerStats;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AttackDamage implements Listener{

public void setInitalDamage(Player player) {
		
		//player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10);
		//player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(999999999);
		
			
	}

public void setDamage(Player p, int physicalDamage, int magicDamage) {
	
	p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(physicalDamage);
	
}

}
