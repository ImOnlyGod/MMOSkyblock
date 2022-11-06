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
		this.itemBuyPrice.put(Material.GRANITE, (float) 20.0);
		this.itemBuyPrice.put(Material.DIORITE, (float) 20.0);
		this.itemBuyPrice.put(Material.ANDESITE, (float) 20.0);
		this.itemBuyPrice.put(Material.POLISHED_GRANITE, (float) 25.0);
		this.itemBuyPrice.put(Material.POLISHED_DIORITE, (float) 25.0);
		this.itemBuyPrice.put(Material.POLISHED_ANDESITE, (float) 25.0);
		this.itemBuyPrice.put(Material.DIRT, (float) 50.0);
		this.itemBuyPrice.put(Material.GRASS_BLOCK, (float) 100.0);
		this.itemBuyPrice.put(Material.PODZOL, (float) 110.0);
		this.itemBuyPrice.put(Material.MYCELIUM, (float) 1500.0);
	}
	
	public void setItemSellPrices() {
		this.itemSellPrice.put(Material.STONE, (float) 0.0);
		this.itemSellPrice.put(Material.COBBLESTONE, (float) 0.0);
		this.itemSellPrice.put(Material.DIRT, (float) 0.0);
		this.itemSellPrice.put(Material.GRASS_BLOCK, (float) 0.0);
	}
	
	public void setItemSlotPrice() {
		this.itemSlotPriceMultiplier.put(10, 1);
		this.itemSlotPriceMultiplier.put(11, 8);
		this.itemSlotPriceMultiplier.put(12, 16);
		this.itemSlotPriceMultiplier.put(13, 32);
		this.itemSlotPriceMultiplier.put(14, 64);
		this.itemSlotPriceMultiplier.put(15, 128);
		this.itemSlotPriceMultiplier.put(16, 256);
		this.itemSlotPriceMultiplier.put(20, 512);
		this.itemSlotPriceMultiplier.put(21, 1024);
		this.itemSlotPriceMultiplier.put(22, 1536);
		this.itemSlotPriceMultiplier.put(23, 2048);
		this.itemSlotPriceMultiplier.put(24, 2304);
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
