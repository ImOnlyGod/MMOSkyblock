package CustomEssentials.Events.PlayerStats;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Speed implements Listener{

	public void setInitalSpeed(Player player) {
		
		player.setWalkSpeed(1);
		
	}

	public void setPlayerSpeed(Player p, int speed) {
		
		p.setWalkSpeed(1);
		
	}

}
