package CustomEssentials.Events.Items;

import java.util.HashMap;

import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Coal_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Copper_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Diamond_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Emerald_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Gold_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Iron_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Lapis_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Redstone_Ore;
import CustomEssentials.Events.Items.Blocks.RegenBlocks.Regen_Stone;
import CustomEssentials.Events.Items.Tools.DarkPickaxe;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.DiamondBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.GoldenBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.IronBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.LetherBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Boots.NetheriteBoots;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.DiamondChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.GoldenChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.IronChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.LetherChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Chestplate.NetheriteChestplate;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.DiamondHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.GoldenHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.IronHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.LetherHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.NetheriteHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Helmet.TurtleHelmet;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.DiamondLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.GoldenLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.IronLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.LetherLeggings;
import CustomEssentials.Events.Items.Vanilla.Armor.Leggings.NetheriteLeggings;
import CustomEssentials.Events.Items.Vanilla.Bows.Bow;
import CustomEssentials.Events.Items.Vanilla.Bows.CrossBow;
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
		
		//Vanilla Regen Block
		this.IDtoItemsCore.put(8000, new Regen_Emerald_Ore());
		this.CmdtoItemsCore.put("emeraldore", new Regen_Emerald_Ore());
		
		this.IDtoItemsCore.put(8001, new Regen_Coal_Ore());
		this.CmdtoItemsCore.put("coalore", new Regen_Coal_Ore());
		
		this.IDtoItemsCore.put(8002, new Regen_Copper_Ore());
		this.CmdtoItemsCore.put("copperore", new Regen_Copper_Ore());
		
		this.IDtoItemsCore.put(8003, new Regen_Diamond_Ore());
		this.CmdtoItemsCore.put("diamondore", new Regen_Diamond_Ore());
		
		this.IDtoItemsCore.put(8004, new Regen_Gold_Ore());
		this.CmdtoItemsCore.put("goldore", new Regen_Gold_Ore());
		
		this.IDtoItemsCore.put(8005, new Regen_Iron_Ore());
		this.CmdtoItemsCore.put("ironore", new Regen_Iron_Ore());
		
		this.IDtoItemsCore.put(8006, new Regen_Lapis_Ore());
		this.CmdtoItemsCore.put("lapisore", new Regen_Lapis_Ore());
		
		this.IDtoItemsCore.put(8007, new Regen_Redstone_Ore());
		this.CmdtoItemsCore.put("redstoneore", new Regen_Redstone_Ore());
		
		this.IDtoItemsCore.put(8008, new Regen_Stone());
		this.CmdtoItemsCore.put("stone", new Regen_Stone());
		
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
		
		this.IDtoItemsCore.put(130, new LetherHelmet());
		this.CmdtoItemsCore.put("leatherhelmet", new LetherHelmet());
		
		this.IDtoItemsCore.put(131, new IronHelmet());
		this.CmdtoItemsCore.put("ironhelmet", new IronHelmet());
		
		this.IDtoItemsCore.put(132, new GoldenHelmet());
		this.CmdtoItemsCore.put("goldenhelmet", new GoldenHelmet());
		
		this.IDtoItemsCore.put(133, new DiamondHelmet());
		this.CmdtoItemsCore.put("diamondhelmet", new DiamondHelmet());
		
		this.IDtoItemsCore.put(134, new NetheriteHelmet());
		this.CmdtoItemsCore.put("netheritehelmet", new NetheriteHelmet());
		
		this.IDtoItemsCore.put(135, new TurtleHelmet());
		this.CmdtoItemsCore.put("turtlehelmet", new TurtleHelmet());
		
		this.IDtoItemsCore.put(136, new LetherChestplate());
		this.CmdtoItemsCore.put("leatherchestplate", new LetherChestplate());
		
		this.IDtoItemsCore.put(137, new IronChestplate());
		this.CmdtoItemsCore.put("ironchestplate", new IronChestplate());
		
		this.IDtoItemsCore.put(138, new GoldenChestplate());
		this.CmdtoItemsCore.put("goldenchestplate", new GoldenChestplate());
		
		this.IDtoItemsCore.put(139, new DiamondChestplate());
		this.CmdtoItemsCore.put("diamondchestplate", new DiamondChestplate());
		
		this.IDtoItemsCore.put(140, new NetheriteChestplate());
		this.CmdtoItemsCore.put("netheritechestplate", new NetheriteChestplate());
		
		this.IDtoItemsCore.put(141, new LetherLeggings());
		this.CmdtoItemsCore.put("leatherleggings", new LetherLeggings());
		
		this.IDtoItemsCore.put(142, new IronLeggings());
		this.CmdtoItemsCore.put("ironleggings", new IronLeggings());
		
		this.IDtoItemsCore.put(143, new GoldenLeggings());
		this.CmdtoItemsCore.put("goldenleggings", new GoldenLeggings());
		
		this.IDtoItemsCore.put(144, new DiamondLeggings());
		this.CmdtoItemsCore.put("diamondleggings", new DiamondLeggings());
		
		this.IDtoItemsCore.put(145, new NetheriteLeggings());
		this.CmdtoItemsCore.put("netheriteleggings", new NetheriteLeggings());
		
		this.IDtoItemsCore.put(146, new LetherBoots());
		this.CmdtoItemsCore.put("leatherboots", new LetherBoots());
		
		this.IDtoItemsCore.put(147, new IronBoots());
		this.CmdtoItemsCore.put("ironboots", new IronBoots());
		
		this.IDtoItemsCore.put(148, new GoldenBoots());
		this.CmdtoItemsCore.put("goldenboots", new GoldenBoots());
		
		this.IDtoItemsCore.put(149, new DiamondBoots());
		this.CmdtoItemsCore.put("diamondboots", new DiamondBoots());
		
		this.IDtoItemsCore.put(150, new NetheriteBoots());
		this.CmdtoItemsCore.put("netheriteboots", new NetheriteBoots());
		
		this.IDtoItemsCore.put(151, new Bow());
		this.CmdtoItemsCore.put("bow", new Bow());

		this.IDtoItemsCore.put(152, new CrossBow());
		this.CmdtoItemsCore.put("crossbow", new CrossBow());
		
		
		
		
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
