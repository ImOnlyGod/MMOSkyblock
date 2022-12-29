package CustomEssentials.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.EventTasks.GuiShops;
import CustomEssentials.Utils.Utils;

public class BaseCommands implements TabExecutor{
	
	private Main plugin;
	
	public BaseCommands(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("customessentials").setExecutor(this);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		List<String> commands = new ArrayList<String>();
		commands.add("reload");
		
		return commands;
	}

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (arg3[0].equalsIgnoreCase("reload")) {
			System.out.println("Reloading Plugin...");		
			sender.sendMessage(Utils.chat("&cReloading Plugin..."));
			this.plugin.onDisable();
			this.plugin.generatePlayerFolder();	
			this.plugin.generateShopFile();
			this.plugin.readShopData();
			this.plugin.getServer().getPluginManager().registerEvents(new GuiShops(this.plugin, this.plugin.getShopPrices()), this.plugin);
			this.plugin.generateShopGui();
			for (Player p : Bukkit.getOnlinePlayers()) {
				this.plugin.readPlayerProfile(p);
			}
			this.plugin.reloadConfig();
			
			System.out.println("Reloaded Plugin");
			sender.sendMessage(Utils.chat("&aReloaded Plugin"));
			return true;
		}
		
		
		
		
		return true;
	}



}
