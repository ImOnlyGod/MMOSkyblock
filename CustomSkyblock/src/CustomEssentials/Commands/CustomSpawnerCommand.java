package CustomEssentials.Commands;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Main;
import CustomEssentials.Utils.Utils;

public class CustomSpawnerCommand implements TabExecutor{
	
	private ArrayList<String> MobsCommandList = new ArrayList<String>();
	private HashMap<String,String> commandToName = new HashMap<String,String>();
	
	@SuppressWarnings("unused")
	private Main plugin; 
	
	public CustomSpawnerCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawner").setExecutor(this);		
		generateMobCommandList();
		generateMobNames();
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
		
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		if (args.length == 1) {
			String key = args[0].toLowerCase();
			if (this.MobsCommandList.contains(key)) {
				performMobSpawn(key,p);								
			}
		}
		else if (args.length > 1) {
			String key = args[0].toLowerCase();
			if (this.MobsCommandList.contains(key)) {
				try {
					int level = Integer.parseInt(args[1]);
					performMobSpawn(key,p);	
				}
				catch (Exception e) {
					p.sendMessage("Please add valid level number");									
				}
			}
		}
		else {
			performMobSpawn("basiczombie", p);
		}
		
		return true;
	}
	
	public void generateMobCommandList() {
		this.MobsCommandList.add("basiczombie");
		this.MobsCommandList.add("agressivegolem");
		this.MobsCommandList.add("wildpig");
		
	}
	
	public void generateMobNames() {
		this.commandToName.put("basiczombie", Utils.chat("&6Basic Zombie &7Spawner"));
		this.commandToName.put("agressivegolem", Utils.chat("&6Agressive Golem &7Spawner"));
		this.commandToName.put("wildpig", Utils.chat("&6Wild Pig &7Spawner"));
		
	}
	
	public void performMobSpawn(String arg, Player p) {
		ItemStack spawner = new ItemStack(Material.SPAWNER);
		ItemMeta spawnerMeta = spawner.getItemMeta();
		spawnerMeta.setDisplayName(this.commandToName.get(arg));
		spawner.setItemMeta(spawnerMeta);
		p.getInventory().addItem(spawner);
		
	}

	public HashMap<String,String> getCommandToName() {
		return commandToName;
	}

	public void setCommandToName(HashMap<String,String> commandToName) {
		this.commandToName = commandToName;
	}
	


	
}
