package CustomEssentials.Events.Items;

import java.util.ArrayList;


import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.PlayerStats.Stats;

public class ItemStats {
	
	private Player p;
	private PlayerProfileManager profileManager;
	private ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	
	public ItemStats(Player p, PlayerProfileManager profileManager) {
		this.p = p;
		this.profileManager = profileManager;
		
	}
	
	public void setDefaultStats() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		stats.setTotalMana(stats.getDefaultMana());
		stats.setPhysicalDamage(stats.getDefaultPhysicalDamage());
		stats.setCriticalChance(stats.getDefaultCritChance());
		stats.setCriticalDamage(stats.getDefaultCritDmg());
		
	}
	
	public void setItemStats() {
		
		isValidWeaponItem();
		isValidArmorItem();
		if (this.items.size() < 1) {
			setDefaultStats();
			return;
		}

		setItemManaStat();
		setItemHealthStat();
		setItemArmorStat();
		setItemCritChanceStat();
		setItemCritDamageStat();
		setItemDamageStat();
		
	}
	
	public void setItemManaStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		int totalMana = stats.getDefaultMana();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int mana= item.getItemManaStat();
			totalMana = totalMana + mana;
			
		}
		
		stats.setTotalMana(totalMana);	
		
	}
	
	//SET DAMAGE FOR DOUBLE WEAPON WEILD
	public void setItemDamageStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		int totalDmg = stats.getDefaultPhysicalDamage();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int dmg= item.getItemPhysicalDamage();
			totalDmg = totalDmg + dmg;
			
		}
		stats.setPhysicalDamage(totalDmg);	
		
	}
	
	public void setItemCritChanceStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		double totalCritChance = stats.getDefaultCritChance();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			double critChance = item.getItemCritChance();
			totalCritChance = totalCritChance + critChance;
			
		}
		
		stats.setCriticalChance(Math.min(100, totalCritChance));
				
	}
	
	public void setItemCritDamageStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		double totalCritDmg = stats.getDefaultCritDmg();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			double critDmg = item.getItemCritDamage();
			totalCritDmg = totalCritDmg + critDmg;
			
		}
		
		stats.setCriticalDamage(totalCritDmg);
				
	}
	
	public void setItemHealthStat() {
		
	}
	
	public void setItemArmorStat() {
		
	}
	
	public Boolean isValidItem(ItemStack item) {
		if (item == null) return false;
		if (!item.hasItemMeta()) return false;
		if (!item.getItemMeta().hasCustomModelData()) return false;
	
		this.items.add(item);
		
		return true;	
		
	}
	
	public Boolean isValidWeaponItem() {
		ItemStack item = p.getInventory().getItemInMainHand();
		return isValidItem(item);
			
	}
	
	public Boolean isValidArmorItem() {
		ItemStack helmet = p.getInventory().getHelmet();
		isValidItem(helmet);
		
		ItemStack chestplate = p.getInventory().getChestplate();
		isValidItem(chestplate);
		
		ItemStack leggings = p.getInventory().getLeggings();
		isValidItem(leggings);
		
		ItemStack boots = p.getInventory().getBoots();
		isValidItem(boots);		
		
		ItemStack offHand = p.getInventory().getItemInOffHand();
		isValidItem(offHand);
		
		return true;
		
			
	}
	
	public int getItemCustomID(ItemStack item) {
		
		return item.getItemMeta().getCustomModelData();
	}
	
	

}
