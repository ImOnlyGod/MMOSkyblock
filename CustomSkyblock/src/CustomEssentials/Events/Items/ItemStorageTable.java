package CustomEssentials.Events.Items;

import java.util.HashMap;

import CustomEssentials.Events.Items.Tools.DarkPickaxe;
import CustomEssentials.Events.Items.Weapons.HadesBlade;
import CustomEssentials.Events.Items.Weapons.StarFire;
import CustomEssentials.Events.Items.Weapons.StormAxe;
import CustomEssentials.Events.Items.Weapons.ThickWoodenSword;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneBoots;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneChestplate;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneHelmet;
import CustomEssentials.Events.Items.Weapons.Armor.HardStoneArmor.HardStoneLeggings;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.DiamondSword;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.GoldenSword;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.IronSword;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.NetheriteSword;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.StoneSword;
import CustomEssentials.Events.Items.Weapons.Vanilla.Swords.WoodenSword;

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
		
		this.IDtoItemsCore.put(8, new DarkPickaxe());
		this.CmdtoItemsCore.put("darkpickaxe", new DarkPickaxe());
		
		this.IDtoItemsCore.put(9, new StarFire());
		this.CmdtoItemsCore.put("starfire", new StarFire());
		
		this.IDtoItemsCore.put(9, new StarFire());
		this.CmdtoItemsCore.put("starfire", new StarFire());
		
		//Vanilla
		this.IDtoItemsCore.put(100, new WoodenSword());
		this.CmdtoItemsCore.put("woodensword", new WoodenSword());
		
		this.IDtoItemsCore.put(101, new StoneSword());
		this.CmdtoItemsCore.put("stonesword", new StoneSword());
		
		this.IDtoItemsCore.put(102, new IronSword());
		this.CmdtoItemsCore.put("ironsword", new IronSword());
		
		this.IDtoItemsCore.put(103, new GoldenSword());
		this.CmdtoItemsCore.put("goldensword", new GoldenSword());
		
		this.IDtoItemsCore.put(104, new DiamondSword());
		this.CmdtoItemsCore.put("diamondsword", new DiamondSword());
		
		this.IDtoItemsCore.put(105, new NetheriteSword());
		this.CmdtoItemsCore.put("netheritesword", new NetheriteSword());
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
