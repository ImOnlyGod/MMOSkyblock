package CustomEssentials.Events.EventTasks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Gui.Shop.ItemsBuySellGui;
import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.Utils;


public class GuiShops implements Listener{
	
	private Main plugin;
	private ItemPrices shopPrices;
		
	public GuiShops(Main plugin) {
		this.plugin = plugin;
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
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBlocks2");
			if ((e.getSlot() > 9 && e.getSlot() < 17) || (e.getSlot() > 18 && e.getSlot() < 26) || (e.getSlot() > 27 && e.getSlot() < 35) || (e.getSlot() > 36 && e.getSlot() < 44)) {
				ItemsBuySellGui buySell = new ItemsBuySellGui(e.getInventory().getItem(e.getSlot()),p);
				if (e.getClick().isLeftClick()) {
					p.openInventory(buySell.getBuyGui());
				}
				else if (e.getClick().isRightClick()) {
					p.openInventory(buySell.getSellGui());
				}
			
			}
			
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopDecorativeBlocks2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopDecorativeBlocks1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFarming2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFarming1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFood2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFood1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopGems2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopGems1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMisc2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMisc1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMob2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMob1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopRedstone2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopRedstone1");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 1)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBrewing2");
			e.setCancelled(true);
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 2)")))) {
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBrewing1");
			e.setCancelled(true);
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
	
	//ADD MEANINGFUL MSGS FOR PURCHASE
	public void PlayerBuyItemEvent(Player p, ItemStack item, int amount) {
		float itemPrice = this.shopPrices.getItemBuyPrice().get(item.getType());
		double totalPrice = itemPrice * amount;
		
		Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
		double playerBalance = profile.getBalance();
		
		if (!(playerBalance-totalPrice > 0)) {
			p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.invalid_payment_msg4")));
			return;
		}
		
		int freeSlots = InvenSpace(p.getInventory(),item.getMaxStackSize());
		p.sendMessage(""+freeSlots);
		if (freeSlots < amount) {
			p.sendMessage("Not enough space");
			return;
		}
		
		
		ItemStack itemForPlayer = new ItemStack(item.getType(),amount);
		
		p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.buy_item_msg") + amount + " &7of &b" + item.getType() + " &7for &c$" + totalPrice));
		p.sendMessage(Utils.chat(this.plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + profile.getBalance()));
		profile.removeBalance(totalPrice);		
		p.getInventory().addItem(itemForPlayer);	
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
	
	
	public void PlayerSellItemEvent(Player p, ItemStack item, int amount) {
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
		p.sendMessage(Utils.chat("&7[&cShop&7]" + this.plugin.getConfig().getString("BalanceCommand.sell_item_msg") + amount + " &7of &b" + item.getType() + " &7for &a$" + totalPrice));
		p.sendMessage(Utils.chat(this.plugin.getConfig().getString("BalanceCommand.reciever_new_bal_msg") + profile.getBalance()));
		profile.addBalance(totalPrice);			
	}
	
	//IMPLEMENT
	public void PlayerSellAllEvent(Player p, ItemStack item) {
		
	}
	
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {

	}		
	
}
	

