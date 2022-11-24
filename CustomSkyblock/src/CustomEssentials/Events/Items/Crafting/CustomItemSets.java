package CustomEssentials.Events.Items.Crafting;

import java.util.ArrayList;

import org.bukkit.Material;

public class CustomItemSets {
	
	private ArrayList<Material> vanillaToCustomItems = new ArrayList<Material>();
	private ArrayList<Material> ItemsToWeapons = new ArrayList<Material>();
	
	public CustomItemSets() {
		generateVanillaToCustomItems();
	}

	private void generateVanillaToCustomItems() {
		//WOODCUTTING
		this.vanillaToCustomItems.add(Material.OAK_LOG);
		this.vanillaToCustomItems.add(Material.BIRCH_LOG);
		this.vanillaToCustomItems.add(Material.SPRUCE_LOG);
		this.vanillaToCustomItems.add(Material.DARK_OAK_LOG);
		this.vanillaToCustomItems.add(Material.JUNGLE_LOG);
		this.vanillaToCustomItems.add(Material.ACACIA_LOG);
		this.vanillaToCustomItems.add(Material.CRIMSON_STEM);
		this.vanillaToCustomItems.add(Material.WARPED_STEM);
		//MINING
		this.vanillaToCustomItems.add(Material.COBBLESTONE);
		this.vanillaToCustomItems.add(Material.CHARCOAL);
		this.vanillaToCustomItems.add(Material.RAW_IRON);
		this.vanillaToCustomItems.add(Material.RAW_COPPER);
		this.vanillaToCustomItems.add(Material.RAW_GOLD);
		this.vanillaToCustomItems.add(Material.COAL);
		this.vanillaToCustomItems.add(Material.IRON_INGOT);
		this.vanillaToCustomItems.add(Material.COPPER_INGOT);
		this.vanillaToCustomItems.add(Material.LAPIS_LAZULI);
		this.vanillaToCustomItems.add(Material.REDSTONE);
		this.vanillaToCustomItems.add(Material.GOLD_INGOT);
		this.vanillaToCustomItems.add(Material.DIAMOND);
		this.vanillaToCustomItems.add(Material.EMERALD);
		this.vanillaToCustomItems.add(Material.NETHERITE_INGOT);
		//FARMING
		this.vanillaToCustomItems.add(Material.WHEAT_SEEDS);
		this.vanillaToCustomItems.add(Material.WHEAT);
		this.vanillaToCustomItems.add(Material.BEETROOT_SEEDS);
		this.vanillaToCustomItems.add(Material.BEETROOT);
		this.vanillaToCustomItems.add(Material.CARROT);
		this.vanillaToCustomItems.add(Material.POTATO);
		this.vanillaToCustomItems.add(Material.MELON_SLICE);
		this.vanillaToCustomItems.add(Material.PUMPKIN);
		this.vanillaToCustomItems.add(Material.NETHER_WART);
		this.vanillaToCustomItems.add(Material.SUGAR_CANE);
		this.vanillaToCustomItems.add(Material.CACTUS);
		this.vanillaToCustomItems.add(Material.BAMBOO);
		this.vanillaToCustomItems.add(Material.COCOA_BEANS);
		this.vanillaToCustomItems.add(Material.KELP);
		this.vanillaToCustomItems.add(Material.VINE);
		this.vanillaToCustomItems.add(Material.GLOW_LICHEN);
		this.vanillaToCustomItems.add(Material.RED_MUSHROOM);
		this.vanillaToCustomItems.add(Material.BROWN_MUSHROOM);
		this.vanillaToCustomItems.add(Material.TWISTING_VINES);
		this.vanillaToCustomItems.add(Material.WEEPING_VINES);
		this.vanillaToCustomItems.add(Material.CRIMSON_FUNGUS);
		this.vanillaToCustomItems.add(Material.WARPED_FUNGUS);
		//COMBAT
		this.vanillaToCustomItems.add(Material.CHICKEN);
		this.vanillaToCustomItems.add(Material.RABBIT);
		this.vanillaToCustomItems.add(Material.PORKCHOP);
		this.vanillaToCustomItems.add(Material.BEEF);
		this.vanillaToCustomItems.add(Material.MUTTON);
		this.vanillaToCustomItems.add(Material.ROTTEN_FLESH);
		this.vanillaToCustomItems.add(Material.ARROW);
		this.vanillaToCustomItems.add(Material.BONE);
		this.vanillaToCustomItems.add(Material.SPIDER_EYE);
		this.vanillaToCustomItems.add(Material.STRING);
		this.vanillaToCustomItems.add(Material.GUNPOWDER);
		this.vanillaToCustomItems.add(Material.LEATHER);
		this.vanillaToCustomItems.add(Material.RABBIT_HIDE);
		this.vanillaToCustomItems.add(Material.FEATHER);
		this.vanillaToCustomItems.add(Material.SLIME_BALL);
		this.vanillaToCustomItems.add(Material.MAGMA_CREAM);
		this.vanillaToCustomItems.add(Material.INK_SAC);
		this.vanillaToCustomItems.add(Material.GLOW_INK_SAC);
		this.vanillaToCustomItems.add(Material.ENDER_PEARL);
		this.vanillaToCustomItems.add(Material.BLAZE_ROD);
		this.vanillaToCustomItems.add(Material.GHAST_TEAR);
		this.vanillaToCustomItems.add(Material.PHANTOM_MEMBRANE);
		
	}
	
	public void generateItemsToWeapons() {
		
	}

	public ArrayList<Material> getVanillaToCustomItems() {
		return vanillaToCustomItems;
	}

	public void setVanillaToCustomItems(ArrayList<Material> vanillaToCustomItems) {
		this.vanillaToCustomItems = vanillaToCustomItems;
	}

	public ArrayList<Material> getItemsToWeapons() {
		return ItemsToWeapons;
	}

	public void setItemsToWeapons(ArrayList<Material> itemsToWeapons) {
		ItemsToWeapons = itemsToWeapons;
	}
	
	
}
