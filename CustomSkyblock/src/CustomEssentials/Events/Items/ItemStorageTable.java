package CustomEssentials.Events.Items;

import java.util.HashMap;

import CustomEssentials.Events.Items.Weapons.HadesBlade;
import CustomEssentials.Events.Items.Weapons.StormAxe;
import CustomEssentials.Events.Items.Weapons.ThickWoodenSword;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneBoots;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneChestplate;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneHelmet;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneLeggings;

public class ItemStorageTable {
	
	//Identifies type of item based on it's name
	private HashMap<Integer, ItemsCore> IDtoItemsCore = new HashMap<Integer,ItemsCore>();
	private HashMap<String, ItemsCore> CmdtoItemsCore = new HashMap<String,ItemsCore>();
	
	public ItemStorageTable() {
		putItems();
	}
	
	private void putItems() {
		this.IDtoItemsCore.put(7, new ThickWoodenSword());
		this.CmdtoItemsCore.put("basicsword", new ThickWoodenSword());
		
		this.IDtoItemsCore.put(1, new HadesBlade());
		this.CmdtoItemsCore.put("hadesblade", new HadesBlade());
		
		this.IDtoItemsCore.put(2, new HardStoneHelmet());
		this.CmdtoItemsCore.put("hardstonehelmet", new HardStoneHelmet());

		this.IDtoItemsCore.put(3, new HardStoneChestplate());
		this.CmdtoItemsCore.put("hardstonechestplate", new HardStoneChestplate());

		this.IDtoItemsCore.put(4, new HardStoneLeggings());
		this.CmdtoItemsCore.put("hardstoneleggings", new HardStoneLeggings());
		
		this.IDtoItemsCore.put(5, new HardStoneBoots());
		this.CmdtoItemsCore.put("hardstoneboots", new HardStoneBoots());
		
		this.IDtoItemsCore.put(6, new StormAxe());
		this.CmdtoItemsCore.put("stormaxe", new StormAxe());
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, ItemsCore> getIDtoItemsCore() {
		return (HashMap<Integer, ItemsCore>) this.IDtoItemsCore.clone();
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, ItemsCore> getCmdtoItemsCore() {
		return (HashMap<String, ItemsCore>) this.CmdtoItemsCore.clone();
	}



	
	

}
