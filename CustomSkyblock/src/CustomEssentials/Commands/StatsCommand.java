package CustomEssentials.Commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class StatsCommand implements TabExecutor{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		return null;
	}

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (!(sender instanceof Player)) {
			
			return true;
		}
		
		
		
		
		return true;
	}



}
