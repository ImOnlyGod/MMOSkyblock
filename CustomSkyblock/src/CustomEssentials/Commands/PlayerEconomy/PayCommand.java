package CustomEssentials.Commands.PlayerEconomy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Utils.Utils;

public class PayCommand implements CommandExecutor {

	private Main plugin;
		
	public PayCommand(Main plugin) {
			
			this.plugin = plugin;
			plugin.getCommand("pay").setExecutor(this);			
			
		}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length != 2) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.invalid_payment_msg")));
			return false;
		}
					
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
		
		try {
			Double.parseDouble(args[1]);
		} catch(Exception e) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.invalid_payment_msg2")));
			return false;
		}
		
		double amount = Double.parseDouble(args[1]);
		if (!(amount > 0.01)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.invalid_payment_msg3")));
			return false;
		}
		
		execute(sender,Bukkit.getPlayer(args[0]),amount);
			
		return false;
		
	}
	
	private boolean execute(CommandSender sender, Player target, double amount) {
		
		Profile targetProfile = this.plugin.getProfileManager().getPlayerProfile(target);
		
		if (!(sender instanceof Player)) {
			targetProfile.addBalance(amount);
			target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_pay_msg") + Math.floor(amount*100)/100 + " &7from &bConsole"));
			target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + Math.floor(targetProfile.getBalance()*100)/100));
			return false;
		}
		
		Player s = (Player) sender;
		Profile senderProfile = this.plugin.getProfileManager().getPlayerProfile(s);
		
		if ((senderProfile.getBalance()-amount) < 0) {
			s.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.invalid_payment_msg4")));
			return false;
		}
		
		senderProfile.removeBalance(amount);
		targetProfile.addBalance(amount);

		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_pay_msg") + Math.floor(amount*100)/100 + " &7from &b" + s.getDisplayName()));
		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + Math.floor(targetProfile.getBalance()*100)/100));
		s.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.sender_pay_msg") + Math.floor(amount*100)/100 + " &7to &b" + target.getDisplayName()));	
		s.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + Math.floor(targetProfile.getBalance()*100)/100));
		return false;
	}
	
}