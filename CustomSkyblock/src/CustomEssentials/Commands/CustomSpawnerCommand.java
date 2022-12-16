package CustomEssentials.Commands;

import java.util.ArrayList;
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
import CustomEssentials.Events.Mobs.CustomMobs.AgressiveGolem;
import CustomEssentials.Events.Mobs.CustomMobs.Basic_Zombie;
import CustomEssentials.Events.Mobs.CustomMobs.WildPig;
import CustomEssentials.Utils.Utils;
import net.minecraft.world.level.MobSpawner;

public class CustomSpawnerCommand implements TabExecutor{
	
	private ArrayList<String> MobsCommandList = new ArrayList<String>();
	
	@SuppressWarnings("unused")
	private Main plugin; 
	
	public CustomSpawnerCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawner").setExecutor(this);		
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
	
	public void performMobSpawn(String arg, Player p) {
		ItemStack spawner = new ItemStack(Material.SPAWNER);
		ItemMeta spawnerMeta = spawner.getItemMeta();
		spawnerMeta.setDisplayName(arg + " Spawner");
		spawner.setItemMeta(spawnerMeta);
		p.getInventory().addItem(spawner);
		
	}
	


	
}
