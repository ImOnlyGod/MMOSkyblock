package CustomEssentials.Events.Gui.Shop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.CustomItems.CompressedItems;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.CurrencyUtils;
import CustomEssentials.Utils.Utils;

public class CompressedItemOptionMenu {
	
	private Inventory buyGui;
	private Inventory sellGui;
	
	public CompressedItemOptionMenu(ItemStack item, Player p, ItemPrices prices) {
		createBuyGui(item,p, prices);
	
	}
	
	public void createBuyGui(ItemStack item, Player p, ItemPrices prices) {
		String name = item.getType().name().replace('_', ' ').toLowerCase();
		String itemName =   item.getType().name().toUpperCase().substring(0,1);
		for (int i = 1; i<  item.getType().name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}	
		this.buyGui = Bukkit.createInventory(null, 27,Utils.chat("&c&lItem Variants&8&l " + itemName));
		
		//Glass Slots
		for (int i = 0; i < this.buyGui.getSize(); i++) {
			if ((i < 10) || (i > 16)) {
				ItemStack glassSlot = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);	
				this.buyGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = new ItemStack(item.getType());
		item1.setAmount(1);
		setItemBuyMeta(item1,1, prices);
		this.buyGui.setItem(10, item1);
		
		ItemStack item2 = new CompressedItems().createItem(item.getType(),1);
		setItemBuyMeta(item2,1, prices);
		this.buyGui.setItem(11, item2);
	
	}	
	public void setItemBuyMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		String name = item.getType().name().replace('_', ' ').toLowerCase();
		String itemName =   item.getType().name().toUpperCase().substring(0,1);
		for (int i = 1; i<  item.getType().name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}		
		
		if (meta.getDisplayName().contains(Utils.chat("Compressed"))) {
			meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " Compressed " + itemName));
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000*1024)/1000)));
			lore.add(Utils.chat("&4Left Click to Buy"));
			lore.add(Utils.chat("&aRight Click to Sell"));
			lore.add(Utils.chat("&6Middle Click to Sell All"));
		}
		else {
			meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " + itemName));
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000)/1000)));
			lore.add(Utils.chat("&4Left Click to Buy"));
			lore.add(Utils.chat("&aRight Click to Sell"));
			lore.add(Utils.chat("&6Middle Click to Sell All"));
		}		
		
		meta.setLore(lore);
		item.setItemMeta(meta);
	}

	public Inventory getBuyGui() {
		return buyGui;
	}

	public void setBuyGui(Inventory buyGui) {
		this.buyGui = buyGui;
	}

	public Inventory getSellGui() {
		return sellGui;
	}

	public void setSellGui(Inventory sellGui) {
		this.sellGui = sellGui;
	}

}
