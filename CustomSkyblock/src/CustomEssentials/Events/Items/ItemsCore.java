package CustomEssentials.Events.Items;

import org.bukkit.entity.Player;



import org.bukkit.inventory.ItemStack;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Profile;

public class ItemsCore {
	
	private int itemHeathStat = 0;
	private int itemManaStat = 0;
	private int itemArmor = 0;
	private int itemmagicResist = 0;
	private int itemPhysicalDamage = 0;
	private int itemMagicDamage = 0;
	private double itemCritChance = 0;
	private double itemCritDamage = 0;
	private double itemBurstChance = 0;
	private double itemBurstDamage = 0;
	private int itemSpeed = 0;
	private int itemCDR = 0;
	private double itemLifeSteal = 0;
	
	private String itemName;
	
	public void itemAbility(Player p, Profile profile) {
		
	}
	
	public int getItemHeathStat() {
		return itemHeathStat;
	}

	public void setItemHeathStat(int itemHeathStat) {
		this.itemHeathStat = itemHeathStat;
	}

	public int getItemArmor() {
		return itemArmor;
	}

	public void setItemArmor(int itemArmor) {
		this.itemArmor = itemArmor;
	}

	public int getItemMagicResist() {
		return itemmagicResist;
	}

	public void setItemMagicResist(int itemmagicResist) {
		this.itemmagicResist = itemmagicResist;
	}

	public int getItemPhysicalDamage() {
		return itemPhysicalDamage;
	}

	public void setItemPhysicalDamage(int itemPhysicalDamage) {
		this.itemPhysicalDamage = itemPhysicalDamage;
	}

	public int getItemMagicDamage() {
		return itemMagicDamage;
	}

	public void setItemMagicDamage(int itemMagicDamage) {
		this.itemMagicDamage = itemMagicDamage;
	}

	public int getItemSpeed() {
		return itemSpeed;
	}

	public void setItemSpeed(int itemSpeed) {
		this.itemSpeed = itemSpeed;
	}

	public int getItemCDR() {
		return itemCDR;
	}

	public void setItemCDR(int itemCDR) {
		this.itemCDR = itemCDR;
	}

	public double getItemCritDamage() {
		return itemCritDamage;
	}

	public void setItemCritDamage(double itemCritDamage) {
		this.itemCritDamage = itemCritDamage;
	}

	public double getItemBurstChance() {
		return itemBurstChance;
	}

	public void setItemBurstChance(double itemBurstChance) {
		this.itemBurstChance = itemBurstChance;
	}

	public double getItemBurstDamage() {
		return itemBurstDamage;
	}

	public void setItemBurstDamage(double itemBurstDamage) {
		this.itemBurstDamage = itemBurstDamage;
	}
	
	public int getItemManaStat() {
		return itemManaStat;
	}

	public void setItemManaStat(int itemManaStat) {
		this.itemManaStat = itemManaStat;
	}

	public double getItemCritChance() {
		return itemCritChance;
	}

	public void setItemCritChance(double itemCritChance) {
		this.itemCritChance = itemCritChance;
	}
	
	public ItemStack createItem(int amount) {
		return null;
	}
	
	public void giveItems(Player player, int amount) {
		
		ItemStack item = createItem(amount);		
		player.getInventory().addItem(item);

	}
	
	public void setItemFlags(ItemMeta meta) {
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 999, Operation.ADD_NUMBER));
		
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemLifeSteal() {
		return itemLifeSteal;
	}

	public void setItemLifeSteal(double itemLifeSteal) {
		this.itemLifeSteal = itemLifeSteal;
	}



	
	
}
