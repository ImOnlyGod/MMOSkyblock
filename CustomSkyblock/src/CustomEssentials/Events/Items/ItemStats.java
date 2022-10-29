package CustomEssentials.Events.Items;

import java.util.ArrayList;

import org.bukkit.attribute.Attribute;
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
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		stats.setTotalMana(stats.getDefaultMana() + pathStats.getDefaultMana() + pathStats.getMana());
		stats.setPhysicalDamage(stats.getDefaultPhysicalDamage() + pathStats.getDefaultPhysicalDamage());
		stats.setCriticalChance(stats.getDefaultCritChance() + pathStats.getDefaultCritChance() + pathStats.getCriticalChance());
		stats.setCriticalDamage(stats.getDefaultCritDmg() + pathStats.getDefaultCritDmg() + pathStats.getCriticalDamage());
		stats.setArmor(stats.getDefaultArmor() + pathStats.getDefaultArmor());
		stats.setMagicResist(stats.getDefaultMR() + pathStats.getDefaultMR() + pathStats.getMagicResist());
		stats.setHealth(stats.getDefaultHealth() + pathStats.getDefaultHealth());
		stats.setSpeed(stats.getDefaultSpeed() + pathStats.getDefaultSpeed());
		p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(stats.getArmor() + pathStats.getArmor());
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(stats.getHealth() + pathStats.getHealth());
		p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(stats.getPhysicalDamage()  +  pathStats.getPhysicalDamage());	
		p.setWalkSpeed((float) ((stats.getSpeed() + pathStats.getSpeed())/500f));
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
		setItemMRStat();
		
	}

	//FIX ADAPT WITH PATH STATS CURRENTLY ACCUMULATES
	public void setItemManaStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		int totalMana = stats.getDefaultMana() + pathStats.getDefaultMana();
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
	
	public void setItemDamageStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		int totalDmg = stats.getDefaultPhysicalDamage() + pathStats.getDefaultPhysicalDamage() + pathStats.getPhysicalDamage();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int dmg= item.getItemPhysicalDamage();
			totalDmg = totalDmg + dmg;
			
		}
		p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(totalDmg);
		stats.setPhysicalDamage(totalDmg);	
		
	}
	
	public void setItemCritChanceStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		double totalCritChance = stats.getDefaultCritChance() + pathStats.getDefaultCritChance() + pathStats.getCriticalChance();
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
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		double totalCritDmg = stats.getDefaultCritDmg() + pathStats.getDefaultCritDmg() + pathStats.getCriticalDamage();
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
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		int totalHealth = stats.getDefaultHealth() + pathStats.getDefaultHealth() + pathStats.getHealth();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int health= item.getItemHeathStat();
			totalHealth = totalHealth + health;
			
		}
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(totalHealth);
		stats.setHealth(totalHealth);	
		
	}
	
	public void setItemArmorStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		int totalArmor = stats.getDefaultArmor() + pathStats.getDefaultArmor() + pathStats.getArmor();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int armor = item.getItemArmor();
			totalArmor = totalArmor + armor;
			
		}
		p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(totalArmor);
		stats.setArmor(totalArmor);	
	}
	
	public void setItemMRStat() {
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
		int totalMR = stats.getDefaultMR() + pathStats.getDefaultMR() + pathStats.getMagicResist();
		ItemStorageTable itemTable = new ItemStorageTable();
		
		for (int i = 0; i < items.size(); i++) {
			int ID = getItemCustomID(items.get(i));
			ItemsCore item = itemTable.getIDtoItemsCore().get(ID);
			item.createItem(1);
			int mr= item.getItemMagicResist();
			totalMR = totalMR + mr;
			
		}
		stats.setMagicResist(totalMR);	
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
