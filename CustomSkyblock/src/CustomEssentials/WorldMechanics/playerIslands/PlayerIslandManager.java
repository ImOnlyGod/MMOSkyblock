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
		
		String playerUUID = p.getUniqueId().toString();
		
		for (int i=0; i < this.getPlayerIslands().size();i++) {
			islandStats island = this.playerIslands.get(i);
			
			if (island.getIslandOwner().equals(playerUUID)) return island;
			if (island.getIslandCoOwners().contains(playerUUID)) return island;
			if (island.getIslandAdmins().contains(playerUUID)) return island;
			if (island.getIslandMods().contains(playerUUID)) return island;
			if (island.getIslandMembers().contains(playerUUID)) return island;			
		}
		
		return null;		
	}
	
	public void setPlayerIsland(Player owner, Player member) {
		
		if (owner.equals(member)) {
			this.createPlayerIsland(owner);
			return;
		}
		
		islandStats ownerIsland = this.getplayerIsland(owner);
		islandStats newPlayerIsland = this.getplayerIsland(member);
		
		if (ownerIsland.equals(newPlayerIsland)) return; 
		
		//find role for player
		//set to member in new island
		
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
