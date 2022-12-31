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
		this.buyGui = Bukkit.createInventory(null, 36,Utils.chat("&c&lBuying &8&l" + item.getType()));
		
		//Glass Slots
		for (int i = 0; i < this.buyGui.getSize(); i++) {
			if ((i < 10) || (24 < i && i < 36) || (i == 17) || (i == 18) || (i == 19)) {
				ItemStack glassSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE);	
				this.buyGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = new ItemStack(item.getType());
		setItemBuyMeta(item1,1, prices);
		this.buyGui.setItem(10, item1);
		
		ItemStack item4 = new ItemStack(item.getType(),8);
		setItemBuyMeta(item4,8, prices);
		this.buyGui.setItem(11, item4);
		
		ItemStack item8 = new ItemStack(item.getType(),16);
		setItemBuyMeta(item8,16, prices);
		this.buyGui.setItem(12, item8);
		
		ItemStack item16 = new ItemStack(item.getType(),32);
		setItemBuyMeta(item16,32, prices);
		this.buyGui.setItem(13, item16);
		
		ItemStack item32 = new ItemStack(item.getType(),64);
		setItemBuyMeta(item32,64, prices);
		this.buyGui.setItem(14, item32);
		
		ItemStack item64 = new ItemStack(item.getType(),128);
		setItemBuyMeta(item64,128, prices);
		this.buyGui.setItem(15, item64);
		
		ItemStack item128 = new ItemStack(item.getType(),256);
		setItemBuyMeta(item128,256, prices);
		this.buyGui.setItem(16, item128);
		
		ItemStack item256 = new ItemStack(item.getType(),512);
		setItemBuyMeta(item256,512, prices);
		this.buyGui.setItem(20, item256);
		
		ItemStack item512 = new ItemStack(item.getType(),1024);
		setItemBuyMeta(item512,1024, prices);
		this.buyGui.setItem(21, item512);
		
		ItemStack item1024 = new ItemStack(item.getType(),1536);
		setItemBuyMeta(item1024,1536, prices);
		this.buyGui.setItem(22, item1024);
		
		ItemStack item1536 = new ItemStack(item.getType(),2048);
		setItemBuyMeta(item1536,2048, prices);
		this.buyGui.setItem(23, item1536);
		
		ItemStack item2048 = new ItemStack(item.getType(),2304);
		setItemBuyMeta(item2048,2304, prices);
		this.buyGui.setItem(24, item2048);
	}
	
	public void createSellGui(ItemStack item, Player p, ItemPrices prices) {
		this.sellGui = Bukkit.createInventory(null, 36,Utils.chat("&a&lSelling &8&l" + item.getType()));
		
		//Glass Slots
		for (int i = 0; i < this.sellGui.getSize(); i++) {
			if ((i < 10) || (24 < i && i < 36) || (i == 17) || (i == 18) || (i == 19)) {
				ItemStack glassSlot = new ItemStack(Material.LIME_STAINED_GLASS_PANE);	
				this.sellGui.setItem(i, glassSlot);
				}					
			}
		
		//Item Amounts
		ItemStack item1 = new ItemStack(item.getType());
		setItemSellMeta(item1,1, prices );
		this.sellGui.setItem(10, item1);
		
		ItemStack item4 = new ItemStack(item.getType(),8);
		setItemSellMeta(item4,8, prices);
		this.sellGui.setItem(11, item4);
		
		ItemStack item8 = new ItemStack(item.getType(),16);
		setItemSellMeta(item8,16, prices);
		this.sellGui.setItem(12, item8);
		
		ItemStack item16 = new ItemStack(item.getType(),32);
		setItemSellMeta(item16,32, prices);
		this.sellGui.setItem(13, item16);
		
		ItemStack item32 = new ItemStack(item.getType(),64);
		setItemSellMeta(item32,64, prices);
		this.sellGui.setItem(14, item32);
		
		ItemStack item64 = new ItemStack(item.getType(),128);
		setItemSellMeta(item64,128, prices);
		this.sellGui.setItem(15, item64);
		
		ItemStack item128 = new ItemStack(item.getType(),256);
		setItemSellMeta(item128,256, prices);
		this.sellGui.setItem(16, item128);
		
		ItemStack item256 = new ItemStack(item.getType(),512);
		setItemSellMeta(item256,512, prices);
		this.sellGui.setItem(20, item256);
		
		ItemStack item512 = new ItemStack(item.getType(),1024);
		setItemSellMeta(item512,1024, prices);
		this.sellGui.setItem(21, item512);
		
		ItemStack item1024 = new ItemStack(item.getType(),1536);
		setItemSellMeta(item1024,1536, prices);
		this.sellGui.setItem(22, item1024);
		
		ItemStack item1536 = new ItemStack(item.getType(),2048);
		setItemSellMeta(item1536,2048, prices);
		this.sellGui.setItem(23, item1536);
		
		ItemStack item2048 = new ItemStack(item.getType(),2304);
		setItemSellMeta(item2048,2304, prices);
		this.sellGui.setItem(24, item2048);
	}
	
	public void setItemBuyMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " + item.getType()));
		
		List<String> lore = new ArrayList<String>();
		lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemBuyPrice().get(item.getType())*amount*1000)/1000)));
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	
	public void setItemSellMeta(ItemStack item, int amount, ItemPrices prices) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " " + item.getType()));
		
		List<String> lore = new ArrayList<String>();
		lore.add(Utils.chat("&aSell Price&7: &8$" + CurrencyUtils.currencyFormat(Math.floor(prices.getItemSellPrice().get(item.getType())*amount*1000)/1000)));
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
