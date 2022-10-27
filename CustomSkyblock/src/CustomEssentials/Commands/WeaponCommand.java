package CustomEssentials.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Items.Weapons.BasicSword;
import CustomEssentials.Utils.Utils;

public class WeaponCommand implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin; 
	
	//MAKE NEW CLASS FOR OTHER CLASSES TO USE
	private HashMap<String, ItemsCore> NametoItemCore;
	
	public WeaponCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("weapon").setExecutor(this);
		this.NametoItemCore = new ItemStorageTable().getCmdtoItemsCore();
		
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			return false;
		}
		
		if (args.length == 0) {
			
			Player p = (Player) sender;
			BasicSword s = new BasicSword();
			s.giveItems(p,1);
			return true;
		}
		
		String key = args[0].toLowerCase();
		
		if (args.length == 1) {
			
			if (this.NametoItemCore.containsKey(key)) {
				Player p = (Player) sender;
				ItemsCore weapon = this.NametoItemCore.get(key);
				weapon.giveItems(p,1);
			}				
		}
		
		else if (args.length >= 2) {
			if (this.NametoItemCore.containsKey(key)) {
				Player p = (Player) sender;
				ItemsCore weapon = this.NametoItemCore.get(key);
				
				
				if (args[1].toLowerCase().matches("\\d+")) {
					if (args.length == 2) {		
						weapon.giveItems(p,Integer.valueOf(args[1].toLowerCase()));
						return true;
					}
				}
				else {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("WeaponCommand.invalid_amount_msg")));
					return true;
				}
				
				if (args.length >= 3) {
					boolean valid = false;
					for (Player target: Bukkit.getOnlinePlayers()) {
						if (target == Bukkit.getPlayer(args[2])) {
							valid = true;
						
						}
					}
					
					if (valid) {
						weapon.giveItems(Bukkit.getPlayer(args[2]),Integer.valueOf(args[1].toLowerCase()));
					}
					else {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("WeaponCommand.invalid_player_msg")));
					}
				
			}	
			
	}
		}
		
		
		
		return true;
	}

	
	
	


	
}
