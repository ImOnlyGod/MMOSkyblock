package CustomEssentials.Events.EventTasks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import CustomEssentials.Main;


public class FoodSaturation implements Listener{
	
	private Main plugin;
		
	public FoodSaturation(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void HungerEvent(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		
	}
		
}
	

