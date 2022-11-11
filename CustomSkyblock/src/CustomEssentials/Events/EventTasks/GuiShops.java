package CustomEssentials.Events.EventTasks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Gui.Shop.ItemsBuySellGui;
import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.ShopInfo.GuiItems;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.Utils;


public class GuiShops implements Listener{
	
	private Main plugin;
	private ItemPrices shopPrices;
		
	public GuiShops(Main plugin, ItemPrices shopPrices) {
		this.plugin = plugin;
		this.shopPrices = shopPrices;
	}
		
	
	@EventHandler
	public void OnClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (this.shopPrices == null) this.shopPrices = new ItemPrices();
		
		if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lMenu"))) {
			
			ItemStack skills = e.getInventory().getItem(18);
	
			if (e.getCurrentItem().isSimilar(skills)) {
				p.performCommand("skills");
			}
			
			e.setCancelled(true);
			return;
		}
		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lSkills")))) {
			if (e.getSlot() == 0) p.performCommand("menu");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lCraft")))) {
			if (e.getCurrentItem() == null);
			else if (e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE && !(e.getSlot() == 24 || e.getSlot() == 25 || e.getSlot() == 33 || e.getSlot() == 34)) 
				e.setCancelled(true);
			
			return;
		}
		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lChoose a Path")))) {
			
			Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
			ItemStack tank = e.getInventory().getItem(20);
			ItemStack archer = e.getInventory().getItem(21);
			ItemStack assassin = e.getInventory().getItem(22);
			
			if (e.getCurrentItem().isSimilar(tank) && (!(profile.getPath() instanceof Tank))) {
				profile.setPath(profile.getPaths().get("tank"));
				p.sendMessage(Utils.chat("&7&lYou have chosen the &a&lTank &7&lPath."));
			}
			
			if (e.getCurrentItem().isSimilar(archer) && (!(profile.getPath() instanceof Archer))) {
				profile.setPath(profile.getPaths().get("archer"));
				p.sendMessage(Utils.chat("&7&lYou have chosen the &6&lArcher &7&lPath."));
			}
			
			if (e.getCurrentItem().isSimilar(assassin) && (!(profile.getPath() instanceof Assassin))) {
				profile.setPath(profile.getPaths().get("assassin"));
				p.sendMessage(Utils.chat("&7&lYou have chosen the &4&lAssassin &7&lPath."));
			}
						
			
			e.setCancelled(true);
			return;
		}
		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lShop")))) {
			if (e.getSlot() == 19) p.performCommand("shopBlocks1");
			if (e.getSlot() == 20) p.performCommand("shopColorBlocks1");
			if (e.getSlot() == 21) p.performCommand("shopDecorativeBlocks1");
			if (e.getSlot() == 22) p.performCommand("shopFarming1");
			if (e.getSlot() == 23) p.performCommand("shopMob1");
			if (e.getSlot() == 24) p.performCommand("shopFood1");
			if (e.getSlot() == 25) p.performCommand("shopGems1");
			if (e.getSlot() == 28) p.performCommand("shopRedstone1");
			if (e.getSlot() == 29) p.performCommand("shopMisc1");
			if (e.getSlot() == 30) p.performCommand("shopBrewing1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 1)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBlocks2");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 2)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 3)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks2");
			if (e.getSlot() == 51) p.performCommand("shopBlocks4");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 4)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 1)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks2");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 2)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 3)")))) {
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks2");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks4");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 4)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks3");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopDecorativeBlocks2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopDecorativeBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopDecorativeBlocks3");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 3)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopDecorativeBlocks2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFarming2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFarming1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFood2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFood1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopGems2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());		
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopGems1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMisc2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMisc1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMob2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMob1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopRedstone2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopRedstone1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());	
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBrewing2");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());	
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBrewing1");
			e.setCancelled(true);
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());		
			return;
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&c&lBuying")))) {
			if (e.getSlot() != 4 && !(e.getInventory().getItem(e.getSlot()).getType().equals(Material.RED_STAINED_GLASS_PANE))) {
				int amount = this.shopPrices.getItemSlotPriceMultiplier().get(e.getSlot());
				PlayerBuyItemEvent(p,e.getInventory().getItem(e.getSlot()),amount);
			}
			e.setCancelled(true);
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&a&lSelling")))) {
			if (e.getSlot() != 4 && !(e.getInventory().getItem(e.getSlot()).getType().equals(Material.RED_STAINED_GLASS_PANE))) {
				int amount = this.shopPrices.getItemSlotPriceMultiplier().get(e.getSlot());
				PlayerSellItemEvent(p,e.getInventory().getItem(e.getSlot()),amount);
			}
			e.setCancelled(true);
		}	
	}
	
	
	public void generateItemActionSlots(int slot, ItemStack item, Player p, ClickType click) {
		if ((slot > 9 && slot < 17) || (slot > 18 && slot < 26) || (slot > 27 && slot < 35) || (slot > 36 && slot < 44)) {
			
			if (item == null) {
				return;
			}
			
			ItemsBuySellGui buySell = new ItemsBuySellGui(item,p, this.shopPrices);
			if (click.isLeftClick()) {
				if (!this.shopPrices.getItemBuyPrice().containsKey(item.getType())) return;
				p.openInventory(buySell.getBuyGui());
			}
			else if (click.isRightClick()) {
				if (!this.shopPrices.getItemSellPrice().containsKey(item.getType())) return;
				p.openInventory(buySell.getSellGui());
			}
			else if (click.equals(ClickType.MIDDLE)) {
				PlayerSellAllEvent(p,item);
			}
		
		}
	}
	
	//ADD MEANINGFUL MSGS FOR PURCHASE
	public void PlayerBuyItemEvent(Player p, ItemStack item, int amount) {
		
		if (this.shopPrices.getItemBuyPrice().get(item.getType()) == null) return;
		float itemPrice = this.shopPrices.getItemBuyPrice().get(item.getType());
		double totalPrice = itemPrice * amount;
		
		Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
		double playerBalance = profile.getBalance();
		
		if (!(playerBalance-totalPrice > 0)) {
			p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.invalid_payment_msg4")));
			return;
		}
		
		int freeSlots = InvenSpace(p.getInventory(),item.getMaxStackSize());
		
		//CHANGE MSG
		if (freeSlots < amount) {
			p.sendMessage("Not enough space");
			return;
		}
		
		
		ItemStack itemForPlayer = new ItemStack(item.getType(),amount);
		profile.removeBalance(totalPrice);		
		p.getInventory().addItem(itemForPlayer);	
		this.shopPrices.shiftPricesOnBuy(item.getType(), amount);
		p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.buy_item_msg") + amount + " &7of &b" + item.getType() + " &7for &c$" + totalPrice));
		p.sendMessage(Utils.chat(this.plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + profile.getBalance()));	
	}
	
	public int InvenSpace(PlayerInventory inv, int maxStackSize) {
		int count = 0;
		
		for (int i = 0; i < 36; i++) {
			if (inv.getItem(i) == null) {
				count += maxStackSize;
			}
		}
		
		return count;
	}
	
	public int CountItem(PlayerInventory inv, ItemStack item) {
		int count = 0;
		
		for (int i = 0; i < 36; i++) {
			if (inv.getItem(i) != null) {
				if (inv.getItem(i).getType() == item.getType()) {
					count += inv.getItem(i).getAmount();
				}
			}
		}
		
		return count;
	}	
	
	public void PlayerSellItemEvent(Player p, ItemStack item, int amount) {
		
		if (this.shopPrices.getItemSellPrice().get(item.getType()) == null) return;
		float itemPrice = this.shopPrices.getItemSellPrice().get(item.getType());
		double totalPrice = itemPrice * amount;
		
		Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
		
		ItemStack itemPlayer = new ItemStack(item.getType());
		
		if (!p.getInventory().containsAtLeast(itemPlayer,amount)) {
			p.sendMessage("Not enough items");
			return;
		}
		itemPlayer = new ItemStack(item.getType(),amount);
		
		p.getInventory().removeItem(itemPlayer);
		profile.addBalance(totalPrice);	
		this.shopPrices.shiftPricesOnSell(item.getType(), amount);
		p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.sell_item_msg") + amount + " &7of &b" + item.getType() + " &7for &a$" + totalPrice));
		p.sendMessage(Utils.chat(this.plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + profile.getBalance()));
	}
	
	//IMPLEMENT
	public void PlayerSellAllEvent(Player p, ItemStack item) {
		
		
		if (item == null || item.getType().equals(Material.AIR)) return;
		
		if (this.shopPrices.getItemSellPrice().get(item.getType()) == null) return;
		
		double itemPrice = this.shopPrices.getItemSellPrice().get(item.getType());
		
		
		Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
		ItemStack playerItem = new ItemStack(item.getType());
		
		int amount = CountItem(p.getInventory(),playerItem);
		
		if (amount == 0) {
			p.sendMessage("You dont have any items");
			return;
		}
		
		ItemStack sellItem = new ItemStack(item.getType(),amount);
		p.getInventory().removeItem(sellItem);
		profile.addBalance(itemPrice*amount);
		this.shopPrices.shiftPricesOnSell(item.getType(), amount);
		p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.sell_item_msg") + amount + " &7of &b" + item.getType() + " &7for &a$" + itemPrice*amount));
		p.sendMessage(Utils.chat(this.plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + profile.getBalance()));
					

	}
	
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {
		if (e.getInventory().getType() == InventoryType.WORKBENCH) {
			e.setCancelled(true);
			Player p = (Player) e.getPlayer();
			p.performCommand("craft");
		}
	}
	
	@EventHandler
	public void CloseMenuEvent(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		
		if ((e.getView().getTitle().contains(Utils.chat("&a&lSelling"))) || (e.getView().getTitle().contains(Utils.chat("&c&lBuying")))) {
			
			String menu = getPreviousMenu(e.getInventory().getItem(10));
			if (menu == null) return;
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					p.performCommand(menu);
				}
			},1);
			return;
		}		
	}
	
	public String getPreviousMenu(ItemStack item) {
		GuiItems items = new GuiItems();
		Material itemType = item.getType();
		
		if (items.getBlocks().contains(itemType)) {
			int index = items.getBlocks().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopBlocks" + page;
			return command;			
		}
		else if (items.getColorBlocks().contains(itemType)) {
			int index = items.getColorBlocks().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopColorBlocks" + page;
			return command;			
		}
		else if (items.getDecorativeBlocks().contains(itemType)) {
			int index = items.getDecorativeBlocks().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopDecorativeBlocks" + page;
			return command;			
		}
		else if (items.getFarming().contains(itemType)) {
			int index = items.getFarming().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopFarming" + page;
			return command;			
		}
		else if (items.getMobDrops().contains(itemType)) {
			int index = items.getMobDrops().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopMob" + page;
			return command;			
		}
		else if (items.getFoods().contains(itemType)) {
			int index = items.getFoods().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopFood" + page;
			return command;			
		}
		else if (items.getGems().contains(itemType)) {
			int index = items.getGems().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopGems" + page;
			return command;			
		}
		else if (items.getMisc().contains(itemType)) {
			int index = items.getMisc().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopMisc" + page;
			return command;			
		}
		else if (items.getRedstone().contains(itemType)) {
			int index = items.getRedstone().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopRedstone" + page;
			return command;			
		}
		else if (items.getBrewing().contains(itemType)) {
			int index = items.getBrewing().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopBrewing" + page;
			return command;			
		}

		return null;
	}
		
}
	

