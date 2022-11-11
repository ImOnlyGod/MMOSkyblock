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
import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Utils.Utils;

public class CraftGui implements TabExecutor{

	private Main plugin;
	
	public CraftGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("craft").setExecutor(this);
	}
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory bench = Bukkit.createInventory(null, 54,Utils.chat("&2&lCraft"));
		
		//Glass Slots
		for (int i = 0; i < bench.getSize(); i++) {
			if ((i < 10) || (i > 13 && i < 19) || (i > 40) || (i == 23) || (i == 26) || (i == 27) || (i == 32) || (i == 35) || (i == 36)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				bench.setItem(i, glassSlot);
			}
						
		}
		
		
		return bench;
				
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
		Profile playerProfile = this.plugin.getProfileManager().getPlayerProfile(p);
		
		
		Inventory menu = createGui(p, playerProfile);
		
		p.openInventory(menu);
		
		return true;
	}
	
}
