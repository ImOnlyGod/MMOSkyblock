package CustomEssentials.Events.EventTasks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Main;
import CustomEssentials.Events.Items.Crafting.CustomCraft;
import CustomEssentials.Utils.Utils;


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
		
		if ((e.getView().getTitle().equals("Crafting") || 
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
			return;
		}			
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lCraft"))) {
			for (int i: e.getRawSlots()) {	
				if (i == 24) {
					e.setCancelled(true);
					return;
				}
				if (i > e.getView().getTopInventory().getSize()) continue;
				if (e.getView().getTopInventory().getItem(i) == null) continue;
				if (e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)) || e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.RED_STAINED_GLASS_PANE)) ||
						e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE))) {
					e.setCancelled(true);
					return;
				}
			}
			return;
		}
		for (int i: e.getRawSlots()) {	
			if (i < (e.getInventory().getSize())) {
				e.setCancelled(true);
				return;
			}
		}
	
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
			
	
}
	

