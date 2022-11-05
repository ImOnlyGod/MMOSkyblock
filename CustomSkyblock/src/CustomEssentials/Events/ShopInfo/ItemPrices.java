package CustomEssentials.Events.ShopInfo;

import java.util.HashMap;

import org.bukkit.Material;

public class ItemPrices {
	
	HashMap<Material,Float> itemBuyPrice = new HashMap<Material, Float>();
	HashMap<Material,Float> itemSellPrice = new HashMap<Material, Float>();
	HashMap<Integer,Integer> itemSlotPriceMultiplier = new HashMap<Integer, Integer>();

	public ItemPrices() {
		setItemBuyPrices();
		setItemSellPrices();
		setItemSlotPrice();
		
	}
	
	public void setItemBuyPrices() {
		this.itemBuyPrice.put(Material.STONE, (float) 10.0);
		this.itemBuyPrice.put(Material.COBBLESTONE, (float) 7.5);
		this.itemBuyPrice.put(Material.DIRT, (float) 50.0);
		this.itemBuyPrice.put(Material.GRASS_BLOCK, (float) 100.0);
	}
	
	public void setItemSellPrices() {
		this.itemSellPrice.put(Material.STONE, (float) 0.0);
		this.itemSellPrice.put(Material.COBBLESTONE, (float) 0.0);
		this.itemSellPrice.put(Material.DIRT, (float) 0.0);
		this.itemSellPrice.put(Material.GRASS_BLOCK, (float) 0.0);
	}
	
	public void setItemSlotPrice() {
		this.itemSlotPriceMultiplier.put(10, 1);
		this.itemSlotPriceMultiplier.put(11, 4);
		this.itemSlotPriceMultiplier.put(12, 8);
		this.itemSlotPriceMultiplier.put(13, 16);
		this.itemSlotPriceMultiplier.put(14, 32);
		this.itemSlotPriceMultiplier.put(15, 48);
		this.itemSlotPriceMultiplier.put(16, 64);
		this.itemSlotPriceMultiplier.put(20, 128);
		this.itemSlotPriceMultiplier.put(21, 256);
		this.itemSlotPriceMultiplier.put(22, 512);
		this.itemSlotPriceMultiplier.put(23, 1024);
		this.itemSlotPriceMultiplier.put(24, 1536);
		this.itemSlotPriceMultiplier.put(25, 2048);
	}
	
	public HashMap<Integer, Integer> getItemSlotPriceMultiplier() {
		return itemSlotPriceMultiplier;
	}

	public void setItemSlotPriceMultiplier(HashMap<Integer, Integer> itemSlotPriceMultiplier) {
		this.itemSlotPriceMultiplier = itemSlotPriceMultiplier;
	}

	public HashMap<Material, Float> getItemBuyPrice() {
		return itemBuyPrice;
	}

	public void setItemBuyPrice(HashMap<Material, Float> itemBuyPrice) {
		this.itemBuyPrice = itemBuyPrice;
	}

	public HashMap<Material, Float> getItemSellPrice() {
		return itemSellPrice;
	}

	public void setItemSellPrice(HashMap<Material, Float> itemSellPrice) {
		this.itemSellPrice = itemSellPrice;
	}
	
	
	
	
}
