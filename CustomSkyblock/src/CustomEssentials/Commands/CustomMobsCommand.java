package CustomEssentials.Commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import CustomEssentials.Main;
import CustomEssentials.Events.Mobs.Basic_Zombie;
import net.minecraft.world.entity.Entity;

public class CustomMobsCommand implements CommandExecutor{
	
	private HashMap<String, Entity> MobsList = new HashMap<String,Entity>();
	
	@SuppressWarnings("unused")
	private Main plugin; 
	
	public CustomMobsCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("espawn").setExecutor(this);
		
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			return false;
		}
	
		Player p = (Player) sender;
		generateMobsList(p.getLocation());
		
		if (args.length == 0) {
			
			this.MobsList.get("basiczombie");
			
		}
		else if (args.length == 1) {
			String key = args[0].toLowerCase();
			if (this.MobsList.containsKey(key)) {
				//REPETATION OF CODE NEED TO REWORK
				this.MobsList.get(key);
							
				
			}
			
		}
		
		
	
		return true;
	}
	
	public void generateMobsList(Location loc) {
		MobsList.put("basiczombie", new Basic_Zombie(loc));
	}


	
}
