package CustomEssentials.Events.Gui;

import java.util.ArrayList;
import java.util.List;

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
		tankMeta.setDisplayName(Utils.chat("&6&l        Archer &7Path"));
		tankMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		tankMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		ArrayList<String> archerLore = new ArrayList<String>();
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7This path provides high"));
		tankLore.add(Utils.chat("&7offensive ranged stats and abilities."));
		tankLore.add(Utils.chat("&7This comes at a cost of giving"));
		tankLore.add(Utils.chat("&7up all forms of defences."));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7Base Health: +100"));
		tankLore.add(Utils.chat("&7Base Armor: +10"));
		tankLore.add(Utils.chat("&7Base MR: +10"));
		tankLore.add(Utils.chat("&7Base Mana: +300"));
		
		
		archerMeta.setLore(archerLore);
		archer.setItemMeta(archerMeta);
		menu.setItem(21, archer);
		
		
		ItemStack assassin = new ItemStack(Material.REDSTONE);
		ItemMeta assassinMeta = assassin.getItemMeta();
		tankMeta.setDisplayName(Utils.chat("&4&l        Assassin &7Path"));
		tankMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		tankMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		ArrayList<String> assassinLore = new ArrayList<String>();
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7This path provides high"));
		tankLore.add(Utils.chat("&7offensive mele stats and abilities."));
		tankLore.add(Utils.chat("&7This comes at a cost of giving"));
		tankLore.add(Utils.chat("&7up all forms of defences."));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat(""));
		tankLore.add(Utils.chat("&7Base Mele Damage: +300"));
		tankLore.add(Utils.chat("&7Base Mana: +300"));
		
		
		assassinMeta.setLore(assassinLore);
		assassin.setItemMeta(assassinMeta);
		menu.setItem(19, assassin);
		
		
		
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
