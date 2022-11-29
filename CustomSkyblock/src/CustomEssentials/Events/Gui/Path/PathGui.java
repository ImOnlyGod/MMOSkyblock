package CustomEssentials.Events.Gui.Path;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Utils.Utils;

public class PathGui implements TabExecutor{

	private Main plugin;
	private HashMap<String,Material> stringToPathMaterial = new HashMap<String,Material>();
	
	public PathGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("path").setExecutor(this);
		this.generateStringToPathMaterial();
	}
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 45,Utils.chat("&5&lPath Info"));
		
		//Glass Slots
		for (int i = 1; i < menu.getSize(); i++) {
			if ((i < 10) || (i > 34) || (i == 17) || (i == 27)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				menu.setItem(i, glassSlot);
			}						
			else if (!(i>19 && i<25)) {
				ItemStack glassSlot = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
				menu.setItem(i, glassSlot);
			}
		}
		
		Path currentPathStats = playerProfile.getPath();
		String currentPathName = currentPathStats.getClass().getSimpleName();
		Material currentPathMat = this.getStringToPathMaterial().get(currentPathName.toLowerCase());
		ItemStack currentPath = new ItemStack(currentPathMat);
		ItemMeta currentPathMeta = currentPath.getItemMeta();
		currentPathMeta.setDisplayName(Utils.chat("&f&lCurrent Path: &6&l"+currentPathName));
		currentPathMeta.addEnchant(Enchantment.DURABILITY, 1, false);
		currentPathMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		currentPathMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		ArrayList<String> currentPathLore = new ArrayList<String>();
		currentPathLore.add(Utils.chat("&7&oClick to see Path Progression!"));
		currentPathLore.add("");
		//ADD LEVEL AND PROGRESSION
		
		currentPathMeta.setLore(currentPathLore);
		currentPath.setItemMeta(currentPathMeta);
		menu.setItem(22, currentPath);
		
		//Skill points item
		ItemStack points = new ItemStack(Material.FEATHER);
		ItemMeta pointsMeta = points.getItemMeta();
		pointsMeta.setDisplayName(Utils.chat("&b&lAttributes"));
		
		ArrayList<String> pointsLore = new ArrayList<String>();
		pointsLore.add("");
		pointsLore.add(Utils.chat("&fAvailable Attribute Points:"));
		pointsLore.add(Utils.chat("&fTotal Attribute Points:"));
		
		pointsMeta.setLore(pointsLore);
		points.setItemMeta(pointsMeta);
		menu.setItem(21, points);
		
		//Path Evolution
		ItemStack evolution = new ItemStack(Material.TURTLE_EGG);
		ItemMeta evolutionMeta = evolution.getItemMeta();
		evolutionMeta.setDisplayName(Utils.chat("&e&lEvolution"));
		
		ArrayList<String> evolutionLore = new ArrayList<String>();
		evolutionLore.add("");
		evolutionLore.add(Utils.chat("&fStage: " + currentPathName));
		evolutionLore.add(Utils.chat("&f"));
		
		evolutionMeta.setLore(evolutionLore);
		evolution.setItemMeta(evolutionMeta);
		menu.setItem(24, evolution);		
				
		//Quests item
		ItemStack quests = new ItemStack(Material.WRITABLE_BOOK);
		ItemMeta questsMeta = quests.getItemMeta();
		questsMeta.setDisplayName(Utils.chat("&4&lQuests"));
		
		ArrayList<String> questsLore = new ArrayList<String>();
		questsLore.add("");
		questsLore.add(Utils.chat("&fCurrent: "));
		questsLore.add(Utils.chat("&f"));
		
		questsMeta.setLore(questsLore);
		quests.setItemMeta(questsMeta);
		menu.setItem(20, quests);	
		
		//Perks/Abilities Item
		ItemStack abilities = new ItemStack(Material.CONDUIT);
		ItemMeta abilitiesMeta = abilities.getItemMeta();
		abilitiesMeta.setDisplayName(Utils.chat("&5&lAbilities"));
		
		ArrayList<String> abilitiesLore = new ArrayList<String>();
		abilitiesLore.add(Utils.chat("&7&oClick to view abilities!"));
		
		abilitiesMeta.setLore(abilitiesLore);
		abilities.setItemMeta(abilitiesMeta);
		menu.setItem(23, abilities);
		
		//Change Path item
		ItemStack changePath = new ItemStack(Material.BARRIER);
		ItemMeta changePathMeta = changePath.getItemMeta();
		changePathMeta.setDisplayName(Utils.chat("&c&lChange Paths"));
		
		ArrayList<String> changePathLore = new ArrayList<String>();
		changePathLore.add("");
		
		changePathMeta.setLore(changePathLore);
		changePath.setItemMeta(changePathMeta);
		menu.setItem(40, changePath);
		
		
		
		
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lBack to Main Menu"));
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
		menu.setItem(0, mainMenu);
		
		//ADD INFORMATION 
		ItemStack info = new ItemStack(Material.BOOK);
		ItemMeta infoMeta = info.getItemMeta();
		infoMeta.setDisplayName(Utils.chat("&a&lPath Information"));
		
		//NEED TO ADD LORE
		
		info.setItemMeta(infoMeta);
		menu.setItem(4, info);
		
		
		
		return menu;
				
	}
	

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;
		Profile playerProfile = this.plugin.getProfileManager().getPlayerProfile(p);		
		
		Inventory menu = createGui(p, playerProfile);
		
		p.openInventory(menu);
		
		return true;
	}
	
	public void generateStringToPathMaterial() {
		this.stringToPathMaterial.put("tank", Material.DIAMOND_CHESTPLATE);
		this.stringToPathMaterial.put("archer", Material.BOW);
		this.stringToPathMaterial.put("assassin", Material.REDSTONE);
		this.stringToPathMaterial.put("default", Material.BARRIER);
	}

	public HashMap<String,Material> getStringToPathMaterial() {
		return stringToPathMaterial;
	}

	public void setStringToPathMaterial(HashMap<String,Material> stringToPathMaterial) {
		this.stringToPathMaterial = stringToPathMaterial;
	}
	
}
