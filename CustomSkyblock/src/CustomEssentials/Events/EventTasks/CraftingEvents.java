package CustomEssentials.Events.EventTasks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

import CustomEssentials.Main;


public class CraftingEvents implements Listener{
	
	private Main plugin;
		
	public CraftingEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {
		if (e.getInventory().getType() == InventoryType.WORKBENCH) {
			e.setCancelled(true);
			Player p = (Player) e.getPlayer();
			p.performCommand("craft");
		}		
	}
	
	
	
	@EventHandler
	public void PlayerDragEvent(InventoryDragEvent e) {
		
		if (e.getInventory() == e.getView().getTopInventory()) {
			e.setCancelled(true);
		}

	}
			
	
}
	

