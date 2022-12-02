package CustomEssentials.Events.Gui.Path;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Utils.Utils;

public class PathStatsGui {
	
	private Player p;
	private Path playerPath;
	private HashMap<Integer,Integer> oddlevelToSlot = new HashMap<Integer,Integer>();
	private HashMap<Integer,Integer> evenlevelToSlot = new HashMap<Integer,Integer>();
	
	public PathStatsGui(Player p, Profile playerProfile) {
		
		this.playerPath = playerProfile.getPath();
		this.p = p;	
		generateOddLevelToSlot();
		generateEvenLevelToSlot();
		this.openPage1();	
		
	}
	
	public String progressionBarGenerator(float progressionPercent) {
		String progressionBarGreen = "";
		String progressionBarRed = "";
				
		
		//Move to separate function
		String progressionBar = "▊";
		for (int i=0; i < 10; i++) {
			if (((int) progressionPercent/10) > i) {
				progressionBarGreen += progressionBar;
				}
			else progressionBarRed += progressionBar;
			
		}
		
		String skillProgressionBar = Utils.chat("&a" + progressionBarGreen + "&c" + progressionBarRed);
		return skillProgressionBar;
	}
	
	public void openPage1() {
		String pathName = this.playerPath.getName().replace(this.playerPath.getName().charAt(0), this.playerPath.getName().toUpperCase().charAt(0));
		Inventory gui = Bukkit.createInventory(null, 54,Utils.chat("&b&l"+pathName+" &7&lProgress &7(Page 1)"));
		
		int currentPathLevel = this.playerPath.getLevel();
		double currentPathXp = this.playerPath.getCurrentXP();
		double currentPathMaxXp = this.playerPath.getMaxXP();
		
		//next page
		ItemStack nextPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta nextPageMeta = (SkullMeta) nextPage.getItemMeta();
		nextPageMeta.setDisplayName(Utils.chat("&a&lNext"));
		GameProfile nextPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String nextPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1Y2U4NDQ4YWNiZDhlNjBjOWI2ZTkzZjQwNjJhMjAzYzQzNGFlYzUwNjgwZDlmMGQwMjhiN2MwOTEyNTczOCJ9fX0=";
		nextPageGameProfile.getProperties().put("textures", new Property("texture",nextPageValue));		
		
		try {
			Field profileField = nextPageMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(nextPageMeta, nextPageGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		nextPage.setItemMeta(nextPageMeta);
		gui.setItem(50, nextPage);
		
		//Generate level slots
		for (int level:this.oddlevelToSlot.keySet()) {
			int slot = this.oddlevelToSlot.get(level);
			if (currentPathLevel > level) {
				ItemStack levelSlot = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				levelSlot.setItemMeta(levelSlotMeta);
				gui.setItem(slot, levelSlot);
			}
			else if (currentPathLevel==level) {
				ItemStack levelSlot = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&b&lLevel Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}				
				
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&lXp: &7"+ Math.round(currentPathXp)/10 + "&f/&7" + Math.round(currentPathMaxXp)/10));
				levelSlotLore.add(Utils.chat(progressionBarGenerator((float) ((currentPathXp/currentPathMaxXp)*100)) + " &6" + Math.round((currentPathXp/currentPathMaxXp)*100*100)/100 + "%"));
				
				levelSlotMeta.setLore(levelSlotLore);
				levelSlot.setItemMeta(levelSlotMeta);
				gui.setItem(slot, levelSlot);
			}
			else {
				ItemStack levelSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				levelSlot.setItemMeta(levelSlotMeta);
				gui.setItem(slot, levelSlot);
			}
		}
		
		//generate remaining glass
		for (int i=0;i<54;i++) {
			ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
			if (gui.getItem(i) == null) {
				gui.setItem(i, glassSlot);
			}
		}	
		
		p.openInventory(gui);
	}
	
	public void generateOddLevelToSlot() {
		for (int i=0;i<9;i++) {
			this.oddlevelToSlot.put(i, i);
		}
		this.oddlevelToSlot.put(9, 17);
		for (int i=26;i>17;i--) {
			this.oddlevelToSlot.put(36-i, i);
		}
		this.oddlevelToSlot.put(19, 27);
		for (int i=36;i<45;i++) {
			this.oddlevelToSlot.put(20+i-36, i);
		}
		this.oddlevelToSlot.put(29, 53);
	}
	
	public void generateEvenLevelToSlot() {
		this.evenlevelToSlot.put(0, 45);
		for (int i=36;i<45;i++) {
			this.evenlevelToSlot.put(i-35, i);
		}
		this.evenlevelToSlot.put(10, 35);
		for (int i=26;i>17;i--) {
			this.evenlevelToSlot.put(37-i, i);
		}
		this.evenlevelToSlot.put(20, 9);
		for (int i=0;i<9;i++) {
			this.evenlevelToSlot.put(i+21, i);
		}
	}	
	
	public void nextPage(int page) {
		if (Math.floorMod(page, 2) == 0) this.evenPage(page);
		else this.oddPage(page);
	}

	public void oddPage(int page) {
		
	}
	
	public void evenPage(int page) {
		
	}
	
	
	public Path getPlayerProfile() {
		return playerPath;
	}

	public void setPlayerProfile(Path playerProfile) {
		this.playerPath = playerProfile;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public HashMap<Integer,Integer> getLevelToSlot() {
		return oddlevelToSlot;
	}

	public void setLevelToSlot(HashMap<Integer,Integer> levelToSlot) {
		this.oddlevelToSlot = levelToSlot;
	}

	public HashMap<Integer,Integer> getEvenlevelToSlot() {
		return evenlevelToSlot;
	}

	public void setEvenlevelToSlot(HashMap<Integer,Integer> evenlevelToSlot) {
		this.evenlevelToSlot = evenlevelToSlot;
	}
	
	
}
