package CustomEssentials.Events.Items;

import java.util.HashMap;

import CustomEssentials.Events.Items.Tools.DarkPickaxe;
import CustomEssentials.Events.Items.Vanilla.Swords.DiamondSword;
import CustomEssentials.Events.Items.Vanilla.Swords.GoldenSword;
import CustomEssentials.Events.Items.Vanilla.Swords.IronSword;
import CustomEssentials.Events.Items.Vanilla.Swords.NetheriteSword;
import CustomEssentials.Events.Items.Vanilla.Swords.StoneSword;
import CustomEssentials.Events.Items.Vanilla.Swords.WoodenSword;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.DiamondAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.GoldenAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.IronAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.NetheriteAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.StoneAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Axe.WoodenAxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.DiamondHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.GoldenHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.IronHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.NetheriteHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.StoneHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Hoe.WoodenHoe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.DiamondPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.GoldenPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.IronPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.NetheritePickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.StonePickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Pickaxe.WoodenPickaxe;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.DiamondShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.GoldenShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.IronShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.NetheriteShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.StoneShovel;
import CustomEssentials.Events.Items.Vanilla.Tools.Shovel.WoodenShovel;
import CustomEssentials.Events.Items.Weapons.HadesBlade;
import CustomEssentials.Events.Items.Weapons.StarFire;
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
		
		this.IDtoItemsCore.put(106, new WoodenPickaxe());
		this.CmdtoItemsCore.put("woodenpickaxe", new WoodenPickaxe());
		
		this.IDtoItemsCore.put(107, new StonePickaxe());
		this.CmdtoItemsCore.put("stonepickaxe", new StonePickaxe());
		
		this.IDtoItemsCore.put(108, new IronPickaxe());
		this.CmdtoItemsCore.put("ironpickaxe", new IronPickaxe());
		
		this.IDtoItemsCore.put(109, new GoldenPickaxe());
		this.CmdtoItemsCore.put("goldenpickaxe", new GoldenPickaxe());
		
		this.IDtoItemsCore.put(110, new DiamondPickaxe());
		this.CmdtoItemsCore.put("diamondpickaxe", new DiamondPickaxe());
		
		this.IDtoItemsCore.put(111, new NetheritePickaxe());
		this.CmdtoItemsCore.put("netheritepickaxe", new NetheritePickaxe());
		
		this.IDtoItemsCore.put(112, new WoodenAxe());
		this.CmdtoItemsCore.put("woodenaxe", new WoodenAxe());
		
		this.IDtoItemsCore.put(113, new StoneAxe());
		this.CmdtoItemsCore.put("stoneaxe", new StoneAxe());
		
		this.IDtoItemsCore.put(114, new IronAxe());
		this.CmdtoItemsCore.put("ironaxe", new IronAxe());
		
		this.IDtoItemsCore.put(115, new GoldenAxe());
		this.CmdtoItemsCore.put("goldenaxe", new GoldenAxe());
		
		this.IDtoItemsCore.put(116, new DiamondAxe());
		this.CmdtoItemsCore.put("diamondaxe", new DiamondAxe());
		
		this.IDtoItemsCore.put(117, new NetheriteAxe());
		this.CmdtoItemsCore.put("netheriteaxe", new NetheriteAxe());
		
		this.IDtoItemsCore.put(118, new WoodenShovel());
		this.CmdtoItemsCore.put("woodenshovel", new WoodenShovel());
		
		this.IDtoItemsCore.put(119, new StoneShovel());
		this.CmdtoItemsCore.put("stoneshovel", new StoneShovel());
		
		this.IDtoItemsCore.put(120, new IronShovel());
		this.CmdtoItemsCore.put("ironshovel", new IronShovel());
		
		this.IDtoItemsCore.put(121, new GoldenShovel());
		this.CmdtoItemsCore.put("goldenshovel", new GoldenShovel());
		
		this.IDtoItemsCore.put(122, new DiamondShovel());
		this.CmdtoItemsCore.put("diamondshovel", new DiamondShovel());
		
		this.IDtoItemsCore.put(123, new NetheriteShovel());
		this.CmdtoItemsCore.put("netheriteshovel", new NetheriteShovel());
		
		this.IDtoItemsCore.put(124, new WoodenHoe());
		this.CmdtoItemsCore.put("woodenhoe", new WoodenHoe());
		
		this.IDtoItemsCore.put(125, new StoneHoe());
		this.CmdtoItemsCore.put("stonehoe", new StoneHoe());
		
		this.IDtoItemsCore.put(126, new IronHoe());
		this.CmdtoItemsCore.put("ironhoe", new IronHoe());
		
		this.IDtoItemsCore.put(127, new GoldenHoe());
		this.CmdtoItemsCore.put("goldenhoe", new GoldenHoe());
		
		this.IDtoItemsCore.put(128, new DiamondHoe());
		this.CmdtoItemsCore.put("diamondhoe", new DiamondHoe());
		
		this.IDtoItemsCore.put(129, new NetheriteHoe());
		this.CmdtoItemsCore.put("netheritehoe", new NetheriteHoe());
		
		
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
