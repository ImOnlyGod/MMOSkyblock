package CustomEssentials.Events.Gui;

import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Utils.Utils;
import CustomEssentials.Main;

public class MenuGui implements TabExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public MenuGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("menu").setExecutor(this);
		
	}
	
	public Inventory createGui() {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&a&lMenu"));
		
		//Glass Slots
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i != 13) && ((i < 18) || (i > 35))) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				menu.setItem(i, glassSlot);
			}
						
		}
		
		
		
		
		return menu;
				
	}
	

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;
		
		Inventory menu = createGui();
		
		p.openInventory(menu);
		
		return true;
	}
	
}
