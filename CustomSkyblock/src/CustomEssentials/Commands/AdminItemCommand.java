package CustomEssentials.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Main;
import CustomEssentials.Events.Items.Crafting.CustomItemSets;
import CustomEssentials.Events.Items.CustomItems.CompressedItems;
import CustomEssentials.Utils.Utils;

public class AdminItemCommand implements TabExecutor{

	private Main plugin; 
	private CustomItemSets compressedItems = new CustomItemSets();
	
	public AdminItemCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("adminitem").setExecutor(this);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {		
		List<String> players = new ArrayList<String>();
		for (Player p:Bukkit.getServer().getOnlinePlayers()) {
			players.add(p.getName());
		}
		
		List<String> items = new ArrayList<String>();
		for (Material item : this.compressedItems.getVanillaToCustomItems()) {
			items.add(item.toString());
		}
		
		if (arg3.length == 1) return players;
		if (arg3.length == 2) return items;
		
		return null;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		CommandSender sender = arg0;
		String[] args = arg3;
		
		if (sender instanceof Player && !sender.hasPermission("adminItem")) return false;
		if (args.length < 3) {
			sender.sendMessage("ADD INVAID COMMAND MSG");
			return false;
		}
		
		boolean valid = false;
		
		for ( Player p: Bukkit.getOnlinePlayers()) {
			if (p == Bukkit.getPlayer(args[0])) {
				valid = true;
				break;
			}
		}
			
		if (!(valid)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.player_not_found_error_msg")));
			return false;
		}
		
		try {
			Integer.parseInt(args[2]);
		} catch(Exception e) {
			sender.sendMessage(Utils.chat("NOT VALID NUMBER"));
			return false;
		}
	
		Player target = Bukkit.getPlayer(args[0]);
		int amount = Integer.parseInt(args[2]);
		
		executeGive(target,amount,args[1]);		
		
		return true;
	}
	
	public void executeGive(Player p, int amount, String item) {
		if (amount < 1) return;
		
		for (Material validItem : this.compressedItems.getVanillaToCustomItems()) {
			if (validItem.toString().equalsIgnoreCase(item)) {
				ItemStack compressedItem = new CompressedItems().createItem(validItem,amount);
				p.getInventory().addItem(compressedItem);
				return;
			}
		}
		
	}
}
