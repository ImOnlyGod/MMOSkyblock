package CustomEssentials.Commands.PlayerEconomy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Items.Weapons.ThickWoodenSword;
import CustomEssentials.Utils.CurrencyUtils;
import CustomEssentials.Utils.Utils;

public class AdminEcoCommand implements TabExecutor{

	@SuppressWarnings("unused")
	private Main plugin; 
	
	public AdminEcoCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("adminpay").setExecutor(this);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		List<String> commands = new ArrayList<String>();
		commands.add("give");
		commands.add("take");
		commands.add("set");
		
		List<String> players = new ArrayList<String>();
		for (Player p:Bukkit.getServer().getOnlinePlayers()) {
			players.add(p.getName());
		}
		
		if (arg3[0].equalsIgnoreCase("give") || arg3[0].equalsIgnoreCase("take") || arg3[0].equalsIgnoreCase("set")) return players;
		
		return commands;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		CommandSender sender = arg0;
		String[] args = arg3;
		
		if (sender instanceof Player && !sender.hasPermission("adminpay")) return false;
		if (args.length < 3) {
			sender.sendMessage("ADD INVAID COMMAND MSG");
			return false;
		}
		
		boolean valid = false;
		
		for ( Player p: Bukkit.getOnlinePlayers()) {
			if (p == Bukkit.getPlayer(args[1])) {
				valid = true;
				break;
			}
		}
			
		if (!(valid)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.player_not_found_error_msg")));
			return false;
		}
		
		try {
			Double.parseDouble(args[2]);
		} catch(Exception e) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.invalid_payment_msg2")));
			return false;
		}
		
		Player reciever = Bukkit.getPlayer(args[1]);
		double amount = Double.parseDouble(args[2]);
		
		if (args[0].equalsIgnoreCase("give")) {
			executeGive(reciever,amount);
		}
		else if (args[0].equalsIgnoreCase("take")) {
			executeTake(reciever,amount);
		}
		else if (args[0].equalsIgnoreCase("set")) {
			executeSet(reciever,amount);
		}
		
		return true;
	}
	
	public void executeGive(Player target, double amount) {
		Profile targetProfile = this.plugin.getProfileManager().getPlayerProfile(target);
		
		targetProfile.addBalance(amount);

		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_pay_msg") + CurrencyUtils.currencyFormat(amount)));
		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + CurrencyUtils.currencyFormat(targetProfile.getBalance())));
	}
	
	public void executeTake(Player target, double amount) {
		Profile targetProfile = this.plugin.getProfileManager().getPlayerProfile(target);
		
		targetProfile.removeBalance(amount);
		if (targetProfile.getBalance() < 0) targetProfile.setBalance(0);

		//TAKE BALANCE MESSAGE
		
		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + CurrencyUtils.currencyFormat(targetProfile.getBalance())));
	}

	public void executeSet(Player target, double amount) {
		Profile targetProfile = this.plugin.getProfileManager().getPlayerProfile(target);
		
		targetProfile.setBalance(Math.max(amount, 0));

		//SET BALANCE MESSAGES
		target.sendMessage(Utils.chat(plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + CurrencyUtils.currencyFormat(targetProfile.getBalance())));
	}
	
}
