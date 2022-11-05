package CustomEssentials.Events.Gui.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Utils.Utils;

public class ItemsBuySellGui {
	
	private Inventory buyGui;
	private Inventory sellGui;
	
	public ItemsBuySellGui(ItemStack item, Player p) {
		createBuyGui(item,p);
		createSellGui(item,p);
	
	}
	
	public void createBuyGui(ItemStack item, Player p ) {
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
		setItemBuyMeta(item1,1);
		this.buyGui.setItem(10, item1);
		
		ItemStack item4 = new ItemStack(item.getType(),4);
		setItemBuyMeta(item4,4);
		this.buyGui.setItem(11, item4);
		
		ItemStack item8 = new ItemStack(item.getType(),8);
		setItemBuyMeta(item8,8);
		this.buyGui.setItem(12, item8);
		
		ItemStack item16 = new ItemStack(item.getType(),16);
		setItemBuyMeta(item16,16);
		this.buyGui.setItem(13, item16);
		
		ItemStack item32 = new ItemStack(item.getType(),32);
		setItemBuyMeta(item32,32);
		this.buyGui.setItem(14, item32);
		
		ItemStack item64 = new ItemStack(item.getType(),64);
		setItemBuyMeta(item64,64);
		this.buyGui.setItem(15, item64);
		
		ItemStack item128 = new ItemStack(item.getType(),128);
		setItemBuyMeta(item128,128);
		this.buyGui.setItem(16, item128);
		
		ItemStack item256 = new ItemStack(item.getType(),256);
		setItemBuyMeta(item256,256);
		this.buyGui.setItem(20, item256);
		
		ItemStack item512 = new ItemStack(item.getType(),512);
		setItemBuyMeta(item512,512);
		this.buyGui.setItem(21, item512);
		
		ItemStack item1024 = new ItemStack(item.getType(),1024);
		setItemBuyMeta(item1024,1024);
		this.buyGui.setItem(22, item1024);
		
		ItemStack item1536 = new ItemStack(item.getType(),1536);
		setItemBuyMeta(item1536,1536);
		this.buyGui.setItem(23, item1536);
		
		ItemStack item2048 = new ItemStack(item.getType(),2048);
		setItemBuyMeta(item2048,2048);
		this.buyGui.setItem(24, item2048);
	}
	
	public void createSellGui(ItemStack item, Player p ) {
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
		setItemSellMeta(item1,1);
		this.sellGui.setItem(10, item1);
		
		ItemStack item4 = new ItemStack(item.getType(),4);
		setItemSellMeta(item4,4);
		this.sellGui.setItem(11, item4);
		
		ItemStack item8 = new ItemStack(item.getType(),8);
		setItemSellMeta(item8,8);
		this.sellGui.setItem(12, item8);
		
		ItemStack item16 = new ItemStack(item.getType(),16);
		setItemSellMeta(item16,16);
		this.sellGui.setItem(13, item16);
		
		ItemStack item32 = new ItemStack(item.getType(),32);
		setItemSellMeta(item32,32);
		this.sellGui.setItem(14, item32);
		
		ItemStack item64 = new ItemStack(item.getType(),64);
		setItemSellMeta(item64,64);
		this.sellGui.setItem(15, item64);
		
		ItemStack item128 = new ItemStack(item.getType(),128);
		setItemSellMeta(item128,128);
		this.sellGui.setItem(16, item128);
		
		ItemStack item256 = new ItemStack(item.getType(),256);
		setItemSellMeta(item256,256);
		this.sellGui.setItem(20, item256);
		
		ItemStack item512 = new ItemStack(item.getType(),512);
		setItemSellMeta(item512,512);
		this.sellGui.setItem(21, item512);
		
		ItemStack item1024 = new ItemStack(item.getType(),1024);
		setItemSellMeta(item1024,1024);
		this.sellGui.setItem(22, item1024);
		
		ItemStack item1536 = new ItemStack(item.getType(),1536);
		setItemSellMeta(item1536,1536);
		this.sellGui.setItem(23, item1536);
		
		ItemStack item2048 = new ItemStack(item.getType(),2048);
		setItemSellMeta(item2048,2048);
		this.sellGui.setItem(24, item2048);
	}
	
	public void setItemBuyMeta(ItemStack item, int amount) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat("&c&lBuy x" + amount + " " + item.getType()));
		item.setItemMeta(meta);
	}
	
	public void setItemSellMeta(ItemStack item, int amount) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat("&a&lSell x" + amount + " " + item.getType()));
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
