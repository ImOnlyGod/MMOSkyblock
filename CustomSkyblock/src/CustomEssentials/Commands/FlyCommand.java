package CustomEssentials.Commands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import CustomEssentials.Utils.Utils;
import CustomEssentials.Main;

public class FlyCommand implements CommandExecutor {

	private Main plugin;
	
	public FlyCommand(Main plugin) {
		
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
		
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
		
		else if ((sender instanceof Player) && (args.length == 0) && (sender.hasPermission("e.fly"))) {
			return execute(sender, (Player) sender);
		}
		
		else if ((sender instanceof Player) && (args.length >= 1) && (sender.hasPermission("e.fly.others"))) {
			return execute(sender, Bukkit.getPlayer(args[0]));
		}
		
		else if (!(sender instanceof Player) && (args.length != 1)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.console_argument_error_msg")));
			return false;
		}
		
		sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.no_permission_msg")));
		return false;	
	
	}

	private boolean execute(CommandSender sender, Player target) {
		
		Player p = target;
		
		if (p.isFlying() || p.getAllowFlight()) {
			
			p.setAllowFlight(false);
			p.setFlying(false);
			p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_disabled_msg")));
			
			if ((sender instanceof Player) && (sender != target)) sender.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.sender_fly_disabled_msg") + " " + p.getDisplayName()));
			
		} else {
			
			p.setAllowFlight(true);
			p.setFlying(true);
			p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_enabled_msg")));
			
			if ((sender instanceof Player) && (sender != target)) sender.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.sender_fly_enabled_msg")  + " " + p.getDisplayName()));
		}		
		
		return true;
		
	}
	

}
