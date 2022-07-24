package CustomEssentials.Commands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import CustomEssentials.Utils.Utils;
import CustomEssentials.Main;

public class EatCommand implements CommandExecutor {

	private Main plugin;
		
	public EatCommand(Main plugin) {
			
			this.plugin = plugin;
			plugin.getCommand("feed").setExecutor(this);
			plugin.getCommand("eat").setExecutor(this);
			
			
		}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length >= 1) {
			
			boolean valid = false;
			
			for ( Player p: Bukkit.getOnlinePlayers()) {
				if (p == Bukkit.getPlayer(args[0])) {
					valid = true;
				
				}
			}
			
			if (!(valid)) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.player_not_found_error_msg")));
				return false;
			}
			
			
		}
		
		if (!(sender instanceof Player) && (args.length >= 1)) {
			
			return execute(null, Bukkit.getPlayer(args[0]));
		}
		
		else if ((sender instanceof Player) && (args.length == 0) && (sender.hasPermission("e.feed"))) {
			return execute(sender, (Player) sender);
		}
		
		else if ((sender instanceof Player) && (args.length >= 1) && (sender.hasPermission("e.feed.others"))) {
			
			return execute(sender, Bukkit.getPlayer(args[0]));
		}
		
		else if (!(sender instanceof Player) && (args.length != 1)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.console_error_msg")));
			return false;
		}
		
		
		sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.no_permission_msg")));
		return false;
		
	}
	
	private boolean execute(CommandSender sender, Player target) {
		
		Player p = target;
		
		if ((sender == target) && (target instanceof Player)) {
			
			p.sendMessage(Utils.chat(plugin.getConfig().getString("EatCommand.reciever_eat_msg")));
			
		}
		
		else if ((sender != target) && (target instanceof Player)) {
			
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("EatCommand.sender_eat_msg") + " " +target.getDisplayName()));
			p.sendMessage(Utils.chat(plugin.getConfig().getString("EatCommand.reciever_eat_msg")));
		
		}
		
		fillHunger(p);
		
		return true;

	}
	
	private void fillHunger(Player target) {
		target.setFoodLevel(20);
		target.setSaturation(20);
	}

}