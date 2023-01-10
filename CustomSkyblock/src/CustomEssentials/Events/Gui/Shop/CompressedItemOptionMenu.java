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
		createSellGui(item,p, prices);
	
	}
	
	public void createBuyGui(ItemStack item, Player p, ItemPrices prices) {
		this.buyGui = Bukkit.createInventory(null, 27,Utils.chat("&c&lBuy Options&8&l " + item.getType()));
		
		//Glass Slots
		for (int i = 0; i < this.buyGui.getSize(); i++) {
			if ((i < 10) || (i > 16)) {
				ItemStack glassSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE);	
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
	
	public void createSellGui(ItemStack item, Player p, ItemPrices prices) {
		this.sellGui = Bukkit.createInventory(null, 36,Utils.chat("&a&lSell Options&8&l " + item.getType()));
		
		//Glass Slots
		for (int i = 0; i < this.buyGui.getSize(); i++) {
			if ((i < 10) || (i > 16)) {
				ItemStack glassSlot = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);	
				this.sellGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = new ItemStack(item.getType());
		item1.setAmount(1);
		setItemSellMeta(item1,1, prices);
		this.sellGui.setItem(10, item1);
		
		ItemStack item2 = new CompressedItems().createItem(item.getType(),1);
		setItemSellMeta(item2,1, prices);
		this.sellGui.setItem(11, item2);
	}
	
	public void setItemBuyMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		if (meta.getDisplayName().contains("Compressed")) {
			meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " +  meta.getDisplayName()));
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000*1024)/1000)));
		}
		else {
			meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " + item.getType()));
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000)/1000)));
		}		
		
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public void setItemSellMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		if (meta.getDisplayName().contains("Compressed")) {
			meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " " +  meta.getDisplayName()));
			lore.add(Utils.chat("&aSell Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemSellPrice().get(item.getType())*amount*1000*1024)/1000)));
		}
		else {
			meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " " + item.getType()));
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
