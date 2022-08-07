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
		stats.setTotalMana(stats.getDefaultMana());
		stats.setPhysicalDamage(stats.getDefaultPhysicalDamage());
		stats.setCriticalChance(stats.getDefaultCritChance());
		stats.setCriticalDamage(stats.getDefaultCritDmg());
		stats.setArmor(stats.getDefaultArmor());
		stats.setMagicResist(stats.getDefaultMR());
		stats.setHealth(stats.getDefaultHealth());
		p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(stats.getArmor());
		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(stats.getDefaultHealth());
		p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(stats.getDefaultPhysicalDamage());
		
		
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
		p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(totalDmg);
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
		Stats stats = profileManager.getPlayerProfile(p).getStats();
		int totalHealth = stats.getDefaultHealth();
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
		int totalArmor = stats.getDefaultArmor();
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
		int totalMR = stats.getDefaultMR();
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
