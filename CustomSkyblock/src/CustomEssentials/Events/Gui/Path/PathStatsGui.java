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
		char firstCharName = this.playerPath.getName().toUpperCase().charAt(0);
		String pathName = firstCharName + this.playerPath.getName().substring(1);
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
		
		//Path menu
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lGo Back"));
		GameProfile mainMenuGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mainMenuValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJlNTI5YWI2YjJlYTdjNTBkOTE5MmQ4OWY4OThmZDdkYThhOWU3NTBkMzc4Mjk1ZGY3MzIwNWU3YTdlZWFlMCJ9fX0=";
		mainMenuGameProfile.getProperties().put("textures", new Property("texture",mainMenuValue));	
		
		try {
			Field profileField = mainMenuMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(mainMenuMeta, mainMenuGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainMenu.setItemMeta(mainMenuMeta);
		gui.setItem(49, mainMenu);
		
		//Generate level slots
		for (int level:this.oddlevelToSlot.keySet()) {
			int slot = this.oddlevelToSlot.get(level);
			if (currentPathLevel > level) {
				ItemStack levelSlot = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&a&lClaimed Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
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
				levelSlotLore.add(Utils.chat("&6&lLevel Rewards:"));
				
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
				
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&c&lLevel Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
				
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
	
	public void previousPage(int page) {
		if (page == 1) this.openPage1();
		else if (Math.floorMod(page, 2) == 0) this.evenPage(page);
		else this.oddPage(page);
	}

	public void oddPage(int page) {
		char firstCharName = this.playerPath.getName().toUpperCase().charAt(0);
		String pathName = firstCharName + this.playerPath.getName().substring(1);
		Inventory gui = Bukkit.createInventory(null, 54,Utils.chat("&b&l"+pathName+" &7&lProgress &7(Page "+page+")"));
		
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
		//previous page
		
		ItemStack previousPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta previousPageMeta = (SkullMeta) previousPage.getItemMeta();
		previousPageMeta.setDisplayName(Utils.chat("&a&lBack"));
		GameProfile previousPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String previousPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk2MTcwMjJjZjlhMWQ1YTg2MDZjMDZlMzg5NGMzMTA4NzRkZmFkMjc2OTA3OTNkNjc1NjkwMTY1OGM2ZTA2NCJ9fX0=";
		previousPageGameProfile.getProperties().put("textures", new Property("texture",previousPageValue));	
		
		try {
			Field profileField = previousPageMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(previousPageMeta, previousPageGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		previousPage.setItemMeta(previousPageMeta);
		gui.setItem(48, previousPage);
		
		//path menu
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lGo Back"));
		GameProfile mainMenuGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mainMenuValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJlNTI5YWI2YjJlYTdjNTBkOTE5MmQ4OWY4OThmZDdkYThhOWU3NTBkMzc4Mjk1ZGY3MzIwNWU3YTdlZWFlMCJ9fX0=";
		mainMenuGameProfile.getProperties().put("textures", new Property("texture",mainMenuValue));	
		
		try {
			Field profileField = mainMenuMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(mainMenuMeta, mainMenuGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainMenu.setItemMeta(mainMenuMeta);
		gui.setItem(49, mainMenu);
		
		//LEVEL slots
		for (int level:this.oddlevelToSlot.keySet()) {
			level = level+(29*(page-1));
			int slot = this.oddlevelToSlot.get(level-(29*(page-1)));
			if (currentPathLevel > level) {
				ItemStack levelSlot = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&a&lClaimed Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
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
				levelSlotLore.add(Utils.chat("&6&lLevel Rewards:"));
				
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
				
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&c&lLevel Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
				
				levelSlot.setItemMeta(levelSlotMeta);
				gui.setItem(slot, levelSlot);
			}
		}
		//Black glass
		for (int i=0;i<54;i++) {
			ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
			if (gui.getItem(i) == null) {
				gui.setItem(i, glassSlot);
			}
		}	
		
		p.openInventory(gui);
	}
	
	public void evenPage(int page) {
		char firstCharName = this.playerPath.getName().toUpperCase().charAt(0);
		String pathName = firstCharName + this.playerPath.getName().substring(1);
		Inventory gui = Bukkit.createInventory(null, 54,Utils.chat("&b&l"+pathName+" &7&lProgress &7(Page "+page+")"));
		
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
		
		//previous page
		ItemStack previousPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta previousPageMeta = (SkullMeta) previousPage.getItemMeta();
		previousPageMeta.setDisplayName(Utils.chat("&a&lBack"));
		GameProfile previousPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String previousPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk2MTcwMjJjZjlhMWQ1YTg2MDZjMDZlMzg5NGMzMTA4NzRkZmFkMjc2OTA3OTNkNjc1NjkwMTY1OGM2ZTA2NCJ9fX0=";
		previousPageGameProfile.getProperties().put("textures", new Property("texture",previousPageValue));	
		
		try {
			Field profileField = previousPageMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(previousPageMeta, previousPageGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		previousPage.setItemMeta(previousPageMeta);
		gui.setItem(48, previousPage);
		
		//path menu
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lGo Back"));
		GameProfile mainMenuGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mainMenuValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJlNTI5YWI2YjJlYTdjNTBkOTE5MmQ4OWY4OThmZDdkYThhOWU3NTBkMzc4Mjk1ZGY3MzIwNWU3YTdlZWFlMCJ9fX0=";
		mainMenuGameProfile.getProperties().put("textures", new Property("texture",mainMenuValue));	
		
		try {
			Field profileField = mainMenuMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(mainMenuMeta, mainMenuGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainMenu.setItemMeta(mainMenuMeta);
		gui.setItem(49, mainMenu);
		
		//LEVEL Slots
		for (int level:this.evenlevelToSlot.keySet()) {
			level = level+(29*(page-1));
			int slot = this.evenlevelToSlot.get(level-(29*(page-1)));
			if (currentPathLevel > level) {
				ItemStack levelSlot = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
				ItemMeta levelSlotMeta = levelSlot.getItemMeta();	
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&a&lClaimed Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
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
				levelSlotLore.add(Utils.chat("&6&lLevel Rewards:"));
				
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
				
				levelSlotMeta.setDisplayName(Utils.chat("&f&lLevel: "+level));
				
				List<String> levelSlotLore = new ArrayList<String>();
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&7&oComplete more path quests to"));
				levelSlotLore.add(Utils.chat("&7&oprogress in levels and gain"));
				levelSlotLore.add(Utils.chat("&7&omore perks!"));
				levelSlotLore.add("");
				levelSlotLore.add(Utils.chat("&c&lLevel Rewards:"));
				
				ArrayList<String> rewards = this.playerPath.calcLevelUpRewards(level);
				for (String reward: rewards) {
					levelSlotLore.add(reward);
				}
				
				levelSlotMeta.setLore(levelSlotLore);
				
				levelSlot.setItemMeta(levelSlotMeta);
				gui.setItem(slot, levelSlot);
			}
		}
		//Black Glass
		for (int i=0;i<54;i++) {
			ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
			if (gui.getItem(i) == null) {
				gui.setItem(i, glassSlot);
			}
		}	
		
		p.openInventory(gui);
		
	}
	
	public int getCurrentPage(String invenTitle) {
		String pageString = "";
		for (int i=0;i<invenTitle.length();i++) {
			if (invenTitle.charAt(i) == '(') {
				for (int j=i+6;j<invenTitle.length()-1;j++) {
					pageString += invenTitle.charAt(j);
				}
				break;
			}
		}
		
		return Integer.parseInt(pageString);		
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
