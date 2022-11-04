package CustomEssentials.Events.ShopInfo;

import java.util.HashMap;

import org.bukkit.Material;

public class ItemPrices {
	
	HashMap<Material,Float> itemBuyPrice = new HashMap<Material, Float>();
	HashMap<Material,Float> itemSellPrice = new HashMap<Material, Float>();

	public ItemPrices() {
		setItemBuyPrices();
		setItemSellPrices();
		
	}
	
	public void setItemBuyPrices() {
		this.itemBuyPrice.put(Material.STONE, (float) 10.0);
		this.itemBuyPrice.put(Material.COBBLESTONE, (float) 7.5);
		this.itemBuyPrice.put(Material.DIRT, (float) 50.0);
		this.itemBuyPrice.put(Material.GRASS, (float) 100.0);
	}
	
	public void setItemSellPrices() {
		this.itemBuyPrice.put(Material.STONE, (float) 0.0);
		this.itemBuyPrice.put(Material.COBBLESTONE, (float) 0.0);
		this.itemBuyPrice.put(Material.DIRT, (float) 0.0);
		this.itemBuyPrice.put(Material.GRASS, (float) 0.0);
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
