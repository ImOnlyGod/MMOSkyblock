package CustomEssentials.Events.Gui.GeneratorGui;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import CustomEssentials.Main;

public class GeneratorGui {
	
	private int ID;
	private Main plugin;
	private int storageCapacity;
	private int productionRate; //per hour
	private Player owner;
	private ArrayList<Material> accessPlayers = new ArrayList<Material>();
	
	//Store UUID of players allowed to access
	
	public GeneratorGui(int ID, Main plugin, Player p, int storageCapacity, int productionRate) {
		this.ID = ID;
		this.plugin = plugin;
		this.owner = p;
		this.storageCapacity = storageCapacity;
		this.productionRate = productionRate;
		
	}
	
}
