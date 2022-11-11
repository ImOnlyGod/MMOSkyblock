package CustomEssentials.Commands.PlayerEconomy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Utils.CurrencyUtils;
import CustomEssentials.Utils.Utils;

public class BalanceCommand implements CommandExecutor {

	private Main plugin;
		
	public BalanceCommand(Main plugin) {
			
			this.plugin = plugin;
			plugin.getCommand("balance").setExecutor(this);
			plugin.getCommand("bal").setExecutor(this);
			plugin.getCommand("money").setExecutor(this);
			
			
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
		
		else if ((sender instanceof Player) && (args.length == 0) && (sender.hasPermission("e.balance"))) {
			return execute(sender, (Player) sender);
		}
		
		else if ((sender instanceof Player) && (args.length >= 1) && (sender.hasPermission("e.balance.others"))) {
			
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
		double bal = checkBalance(p);
		
		if (sender == target) {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_bal_msg") + CurrencyUtils.currencyFormat(bal)));
			return true;
		}
		
		if (!(sender instanceof Player)) {
			System.out.println("The balance of " + target.getDisplayName() + "is $" + CurrencyUtils.currencyFormat(bal));
			return true;
		}
					
		sender.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.sender_bal_msg") + target.getDisplayName() + " &7is &a$" + CurrencyUtils.currencyFormat(bal)));		
		
		return true;

	}
	
	private double checkBalance(Player target) {
		Profile profile = this.plugin.getProfileManager().getPlayerProfile(target);
		return profile.getBalance();
		
	}

}