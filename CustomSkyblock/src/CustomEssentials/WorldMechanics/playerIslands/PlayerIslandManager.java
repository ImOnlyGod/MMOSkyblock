package CustomEssentials.WorldMechanics.playerIslands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import CustomEssentials.Main;

public class PlayerIslandManager {
	
	private Main plugin;
	private ArrayList<islandStats> playerIslands = new ArrayList<islandStats>();
	
	public PlayerIslandManager(Main plugin) {
		this.plugin = plugin;
	}
	
	public void createPlayerIsland(Player owner) {
		
	}
	
	public islandStats getplayerIsland(Player p) {
		return null;		
	}
	
	public void setPlayerIsland(Player owner, Player member) {
		
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	public ArrayList<islandStats> getPlayerIslands() {
		return playerIslands;
	}

	public void setPlayerIslands(ArrayList<islandStats> playerIslands) {
		this.playerIslands = playerIslands;
	}
	
	
	

}
