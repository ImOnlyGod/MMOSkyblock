package CustomEssentials.Events.Gui.Path;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
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
import CustomEssentials.Utils.Utils;

public class PathSelectionGui implements TabExecutor{

	private Main plugin;
	
	public PathSelectionGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("pathSelector").setExecutor(this);
		
	}
	

	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&5&lChoose a Path"));
		
		//Glass Slots
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i < 19) || (i > 34) || (i == 26) || (i == 27)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				menu.setItem(i, glassSlot);
			}
						
		}
			
		ItemStack tank = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta tankMeta = tank.getItemMeta();
		tankMeta.setDisplayName(Utils.chat("&a&l        Tank &7Path"));
		tankMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		tankMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		ArrayList<String> tankLore = new ArrayList<String>();
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7This path provides high"));
		tankLore.add(Utils.chat("&7defensive stats and abilities."));
		tankLore.add(Utils.chat("&7This comes at a cost of giving"));
		tankLore.add(Utils.chat("&7up all forms of damage."));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7Base Health: +500"));
		tankLore.add(Utils.chat("&7Base Armor: +50"));
		tankLore.add(Utils.chat("&7Base MR: +35"));
		tankLore.add(Utils.chat("&7Base Mana: +300"));
		
		
		tankMeta.setLore(tankLore);
		tank.setItemMeta(tankMeta);
		menu.setItem(20, tank);
		
		
		//CHANGE TO ONLY BOW DMG -> ADD BOW DMG
		ItemStack archer = new ItemStack(Material.BOW);
		ItemMeta archerMeta = archer.getItemMeta();
		archerMeta.setDisplayName(Utils.chat("&6&l         Archer &7Path"));
		archerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		archerMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		ArrayList<String> archerLore = new ArrayList<String>();
		archerLore.add(Utils.chat(""));
		archerLore.add(Utils.chat("&7This path provides high"));
		archerLore.add(Utils.chat("&7offensive ranged stats and abilities."));
		archerLore.add(Utils.chat("&7This comes at a cost of giving"));
		archerLore.add(Utils.chat("&7up all forms of defences."));
		archerLore.add(Utils.chat(""));
		archerLore.add(Utils.chat(""));
		archerLore.add(Utils.chat("&7Base Health: +100"));
		archerLore.add(Utils.chat("&7Base Armor: +10"));
		archerLore.add(Utils.chat("&7Base MR: +10"));
		archerLore.add(Utils.chat("&7Base Mana: +300"));
		
		
		archerMeta.setLore(archerLore);
		archer.setItemMeta(archerMeta);
		menu.setItem(21, archer);
		
		
		ItemStack assassin = new ItemStack(Material.REDSTONE);
		ItemMeta assassinMeta = assassin.getItemMeta();
		assassinMeta.setDisplayName(Utils.chat("&4&l         Assassin &7Path"));
		assassinMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		assassinMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		ArrayList<String> assassinLore = new ArrayList<String>();
		assassinLore.add(Utils.chat(""));
		assassinLore.add(Utils.chat("&7This path provides high"));
		assassinLore.add(Utils.chat("&7offensive mele stats and abilities."));
		assassinLore.add(Utils.chat("&7This comes at a cost of giving"));
		assassinLore.add(Utils.chat("&7up all forms of defences."));
		assassinLore.add(Utils.chat(""));
		assassinLore.add(Utils.chat(""));
		assassinLore.add(Utils.chat("&7Base Mele Damage: +300"));
		assassinLore.add(Utils.chat("&7Base Mana: +300"));
		
		
		assassinMeta.setLore(assassinLore);
		assassin.setItemMeta(assassinMeta);
		menu.setItem(22, assassin);
		
		//back item
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
		menu.setItem(0, mainMenu);
		
		
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
	
}
