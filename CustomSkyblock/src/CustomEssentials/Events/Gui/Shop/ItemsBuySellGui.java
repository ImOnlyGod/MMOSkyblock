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

import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.CurrencyUtils;
import CustomEssentials.Utils.Utils;

public class ItemsBuySellGui {
	
	private Inventory buyGui;
	private Inventory sellGui;
	
	public ItemsBuySellGui(ItemStack item, Player p, ItemPrices prices) {
		createBuyGui(item,p, prices);
		createSellGui(item,p, prices);
	
	}
	
	public void createBuyGui(ItemStack item, Player p, ItemPrices prices) {
		String name = item.getType().name().replace('_', ' ').toLowerCase();
		String itemName =   item.getType().name().toUpperCase().substring(0,1);
		for (int i = 1; i<  item.getType().name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}	
		if (item.getItemMeta().getDisplayName().contains("Compressed")) {
			this.buyGui = Bukkit.createInventory(null, 36,Utils.chat("&c&lBuying &8&lCompressed " + itemName));
		}
		else {
			this.buyGui = Bukkit.createInventory(null, 36,Utils.chat("&c&lBuying &8&l" + itemName));
		}
		
		//Glass Slots
		for (int i = 0; i < this.buyGui.getSize(); i++) {
			if ((i < 10) || (24 < i && i < 36) || (i == 17) || (i == 18) || (i == 19)) {
				ItemStack glassSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE);	
				this.buyGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = item;
		item1.setAmount(1);
		setItemBuyMeta(item1,1, prices);
		this.buyGui.setItem(10, item1);
		
		ItemStack item4 = item;
		item4.setAmount(8);
		setItemBuyMeta(item4,8, prices);
		this.buyGui.setItem(11, item4);
		
		ItemStack item8 = item;
		item8.setAmount(16);
		setItemBuyMeta(item8,16, prices);
		this.buyGui.setItem(12, item8);
		
		ItemStack item16 = item;
		item16.setAmount(32);
		setItemBuyMeta(item16,32, prices);
		this.buyGui.setItem(13, item16);
		
		ItemStack item32 = item;
		item32.setAmount(64);
		setItemBuyMeta(item32,64, prices);
		this.buyGui.setItem(14, item32);
		
		ItemStack item64 = item;
		item64.setAmount(128);
		setItemBuyMeta(item64,128, prices);
		this.buyGui.setItem(15, item64);
		
		ItemStack item128 = item;
		item128.setAmount(256);
		setItemBuyMeta(item128,256, prices);
		this.buyGui.setItem(16, item128);
		
		ItemStack item256 = item;
		item256.setAmount(512);
		setItemBuyMeta(item256,512, prices);
		this.buyGui.setItem(20, item256);
		
		ItemStack item512 = item;
		item512.setAmount(1024);
		setItemBuyMeta(item512,1024, prices);
		this.buyGui.setItem(21, item512);
		
		ItemStack item1024 = item;
		item1024.setAmount(1536);
		setItemBuyMeta(item1024,1536, prices);
		this.buyGui.setItem(22, item1024);
		
		ItemStack item1536 = item;
		item1536.setAmount(2048);
		setItemBuyMeta(item1536,2048, prices);
		this.buyGui.setItem(23, item1536);
		
		ItemStack item2048 = item;
		item2048.setAmount(2304);
		setItemBuyMeta(item2048,2304, prices);
		this.buyGui.setItem(24, item2048);
	}
	
	public void createSellGui(ItemStack item, Player p, ItemPrices prices) {
		String name = item.getType().name().replace('_', ' ').toLowerCase();
		String itemName =   item.getType().name().toUpperCase().substring(0,1);
		for (int i = 1; i<  item.getType().name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}	
		if (item.getItemMeta().getDisplayName().contains("Compressed")) {
			this.sellGui = Bukkit.createInventory(null, 36,Utils.chat("&a&lSelling &8&lCompressed " + itemName));
		}
		else {
			this.sellGui = Bukkit.createInventory(null, 36,Utils.chat("&a&lSelling &8&l" + itemName));
		}
		
		//Glass Slots
		for (int i = 0; i < this.sellGui.getSize(); i++) {
			if ((i < 10) || (24 < i && i < 36) || (i == 17) || (i == 18) || (i == 19)) {
				ItemStack glassSlot = new ItemStack(Material.LIME_STAINED_GLASS_PANE);	
				this.sellGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = item;
		item1.setAmount(1);
		setItemSellMeta(item1,1, prices);
		this.sellGui.setItem(10, item1);
		
		ItemStack item4 = item;
		item4.setAmount(8);
		setItemSellMeta(item4,8, prices);
		this.sellGui.setItem(11, item4);
		
		ItemStack item8 = item;
		item8.setAmount(16);
		setItemSellMeta(item8,16, prices);
		this.sellGui.setItem(12, item8);
		
		ItemStack item16 = item;
		item16.setAmount(32);
		setItemSellMeta(item16,32, prices);
		this.sellGui.setItem(13, item16);
		
		ItemStack item32 = item;
		item32.setAmount(64);
		setItemSellMeta(item32,64, prices);
		this.sellGui.setItem(14, item32);
		
		ItemStack item64 = item;
		item64.setAmount(128);
		setItemSellMeta(item64,128, prices);
		this.sellGui.setItem(15, item64);
		
		ItemStack item128 = item;
		item128.setAmount(256);
		setItemSellMeta(item128,256, prices);
		this.sellGui.setItem(16, item128);
		
		ItemStack item256 = item;
		item256.setAmount(512);
		setItemSellMeta(item256,512, prices);
		this.sellGui.setItem(20, item256);
		
		ItemStack item512 = item;
		item512.setAmount(1024);
		setItemSellMeta(item512,1024, prices);
		this.sellGui.setItem(21, item512);
		
		ItemStack item1024 = item;
		item1024.setAmount(1536);
		setItemSellMeta(item1024,1536, prices);
		this.sellGui.setItem(22, item1024);
		
		ItemStack item1536 = item;
		item1536.setAmount(2048);
		setItemSellMeta(item1536,2048, prices);
		this.sellGui.setItem(23, item1536);
		
		ItemStack item2048 = item;
		item2048.setAmount(2304);
		setItemSellMeta(item2048,2304, prices);
		this.sellGui.setItem(24, item2048);
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
		}
		else {
			meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " + itemName));
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000)/1000)));
		}		
		
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public void setItemSellMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		String name = item.getType().name().replace('_', ' ').toLowerCase();
		String itemName =   item.getType().name().toUpperCase().substring(0,1);
		for (int i = 1; i<  item.getType().name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}	
		
		if (meta.getDisplayName().contains(Utils.chat("Compressed"))) {
			meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " Compressed " + itemName));
			lore.add(Utils.chat("&aSell Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemSellPrice().get(item.getType())*amount*1000*1024)/1000)));
		}
		else {
			meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " " + itemName));
			lore.add(Utils.chat("&aSell Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemSellPrice().get(item.getType())*amount*1000)/1000)));
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
