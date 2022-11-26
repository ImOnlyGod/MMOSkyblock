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
		this.setPlugin(plugin);
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
		
		if (!(e.getView().getTitle().equals("Crafting") || 
				e.getView().getTitle().equals("Chest") || 
				e.getView().getTitle().equals("Large Chest") || 
				e.getView().getTitle().equals("Inventory") ||
				e.getView().getTitle().equals("Furnace") || 
				e.getView().getTitle().equals("Trapped Chest") || 
				e.getView().getTitle().equals("Large Trapped Chest") || 
				e.getView().getTitle().equals("Repair & Name") || 
				e.getView().getTitle().equals("Enchant") || 
				e.getView().getTitle().equals("Loom") || 
				e.getView().getTitle().equals("Barrel") || 
				e.getView().getTitle().equals("Smoker") || 
				e.getView().getTitle().equals("Blast Furnace") || 
				e.getView().getTitle().equals("Cartography Table") || 
				e.getView().getTitle().equals("Repair & Disenchant") || 
				e.getView().getTitle().equals("Upgrade Gear") || 
				e.getView().getTitle().equals("Stonecutter") || 
				e.getView().getTitle().equals("Item Hopper") || 
				e.getView().getTitle().equals("Dropper") || 
				e.getView().getTitle().equals("Dispenser") ||
				e.getView().getTitle().equals("Ender Chest") ||
				e.getView().getTitle().equals("Shulker Box") ||
				e.getView().getTitle().equals("Minecart with Chest"))) {
			e.setCancelled(true);
		}

	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
			
	
}
	

