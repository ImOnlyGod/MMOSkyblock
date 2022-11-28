package CustomEssentials.Commands;

import java.util.ArrayList;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Mobs.AgressiveGolem;
import CustomEssentials.Events.Mobs.Basic_Zombie;
import CustomEssentials.Events.Mobs.WildPig;

public class CustomMobsCommand implements TabExecutor{
	
	private ArrayList<String> MobsCommandList = new ArrayList<String>();
	
	@SuppressWarnings("unused")
	private Main plugin; 
	
	public CustomMobsCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("espawn").setExecutor(this);		
	}
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		List<String> commands = new ArrayList<String>();
		
		for (String name: this.MobsCommandList) {
			commands.add(name);
		}
		
		return commands;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		CommandSender sender = arg0;
		String[] args = arg3;
		if (!(sender instanceof Player)) {
			return false;
		}
		generateMobCommandList();
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		if (args.length == 1) {
			String key = args[0].toLowerCase();
			if (this.MobsCommandList.contains(key)) {
				performMobSpawn(key,loc,1);								
			}
		}
		else if (args.length > 1) {
			String key = args[0].toLowerCase();
			if (this.MobsCommandList.contains(key)) {
				try {
					int level = Integer.parseInt(args[1]);
					performMobSpawn(key,loc,level);
				}
				catch (Exception e) {
					p.sendMessage("Please add valid level number");									
			}
		}
		}
		else {
			performMobSpawn("basiczombie", loc,1);
		}
		
		return true;
	}
	
	public void generateMobCommandList() {
		this.MobsCommandList.add("basiczombie");
		this.MobsCommandList.add("agressivegolem");
		this.MobsCommandList.add("wildpig");
		
	}
	
	public void performMobSpawn(String arg, Location loc, int level) {
		if (arg.equals("basiczombie")) new Basic_Zombie(loc,level);
		else if (arg.equals("agressivegolem")) new AgressiveGolem(loc,level);
		else if (arg.equals("wildpig")) new WildPig(loc,level);
		
	}
	


	
}
