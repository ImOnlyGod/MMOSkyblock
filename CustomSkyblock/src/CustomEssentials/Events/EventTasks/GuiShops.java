package CustomEssentials.Events.EventTasks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.mojang.authlib.yggdrasil.response.ProfileSearchResultsResponse;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Gui.Enchants.EnchantTableGui;
import CustomEssentials.Events.Gui.Path.PathStatsGui;
import CustomEssentials.Events.Gui.Shop.ItemsBuySellGui;
import CustomEssentials.Events.Gui.Skills.SkillProgression;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Items.Crafting.CustomCraft;
import CustomEssentials.Events.Items.Crafting.CustomCraftingItemSet;
import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.ShopInfo.GuiItems;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.Utils;


public class GuiShops implements Listener{
	
	private Main plugin;
	private ItemPrices shopPrices;
	private CustomCraftingItemSet craftingRecipeSet = new CustomCraftingItemSet();
		
	public GuiShops(Main plugin, ItemPrices shopPrices) {
		this.plugin = plugin;
		this.shopPrices = shopPrices;
	}
	
	public Boolean isValidClick(ClickType click) {
		if (click.isShiftClick() || click.isKeyboardClick() || click == ClickType.DOUBLE_CLICK) {
			return false;				
		}
		return true;
	}
	
	public Boolean isValidCraftingClick(ClickType click, InventoryView invenView, Inventory clickedInven, ItemStack clickedItem, int clickedSlot, ItemStack hoveredItem) {
		
		if (click.isKeyboardClick()) {
			if (clickedInven == invenView.getBottomInventory()) return true;		
			if ((clickedSlot > 9 && clickedSlot < 14) || (clickedSlot > 18 && clickedSlot < 23) || (clickedSlot > 27 && clickedSlot < 32) || (clickedSlot > 36 && clickedSlot < 41)) return true;			
			
			return false;				
		}
		else if (click.isShiftClick())  {	
			if (clickedItem == null) return true;
			if (clickedItem.isSimilar(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)) || clickedItem.isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE)) ||
					clickedItem.isSimilar(new ItemStack(Material.RED_STAINED_GLASS_PANE)) || clickedItem.isSimilar(invenView.getTopInventory().getItem(24))) return false;
			
			if (clickedInven == invenView.getBottomInventory()) return true;
			
			if ((clickedSlot > 9 && clickedSlot < 14) || (clickedSlot > 18 && clickedSlot < 23) || (clickedSlot > 27 && clickedSlot < 32) 
					|| (clickedSlot > 36 && clickedSlot < 41) || clickedSlot == 24) return true;
			
			return false;			
		}
		else if (click == ClickType.DOUBLE_CLICK) {
			if (hoveredItem == null) return false;
			if (hoveredItem.isSimilar(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)) || hoveredItem.isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE)) ||
					hoveredItem.isSimilar(new ItemStack(Material.RED_STAINED_GLASS_PANE)) || hoveredItem.isSimilar(invenView.getTopInventory().getItem(24))) return false;
			
			
			return true;
		}
		if (clickedItem == null) return true;
		if (clickedInven == invenView.getBottomInventory()) return true;
		if (clickedInven == invenView.getTopInventory() && ((clickedSlot > 9 && clickedSlot < 14) || (clickedSlot > 18 && clickedSlot < 23) || (clickedSlot > 27 && clickedSlot < 32) 
				|| (clickedSlot > 36 && clickedSlot < 41)) && (clickedSlot != 24) && (clickedSlot != 25) && (clickedSlot != 33) && (clickedSlot != 34)) return true;
		
		return false;
	}
	
	
	@EventHandler
	public void OnClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Profile playerProfile = this.plugin.getProfileManager().getPlayerProfile(p);
		
		if (this.shopPrices == null) this.shopPrices = new ItemPrices();
		
		if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lMenu"))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}			
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null) return;
			if (e.getSlot() == 18) p.performCommand("skills");
			else if (e.getSlot() == 23) p.performCommand("path");
			else if (e.getSlot() == 31) p.performCommand("craft");
			
			return;
		}
		else 
			if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lPath Info"))) {
				ClickType click = e.getClick();
				if (!isValidClick(click)) {
					e.setCancelled(true);				
				}
				if (e.getClickedInventory() != e.getView().getTopInventory()) {
					return;
				}			
				e.setCancelled(true);				
				if (e.getSlot() == 0) p.performCommand("menu");
				else if (e.getSlot() == 40) p.performCommand("pathselector");
				else if (e.getSlot() == 22) {
					PathStatsGui openPathStats = new PathStatsGui(p,playerProfile);
					openPathStats.openPage1();
				}
				
				return;
			}		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lSkills")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			
			if (e.getSlot() == 0) p.performCommand("menu");
			else if (e.getSlot() == 19) {
				SkillProgression progressionMenu = new SkillProgression(this.plugin,p,playerProfile.getMining(),"&8&lMining");
				progressionMenu.createSkillGui();
			}
			else if (e.getSlot() == 20) {
				SkillProgression progressionMenu = new SkillProgression(this.plugin,p,playerProfile.getFarming(),"&a&lFarming");
				progressionMenu.createSkillGui();
			}
			else if (e.getSlot() == 21) {
				SkillProgression progressionMenu = new SkillProgression(this.plugin,p,playerProfile.getCombat(),"&c&lCombat");
				progressionMenu.createSkillGui();
			}
			else if (e.getSlot() == 22) {
				SkillProgression progressionMenu = new SkillProgression(this.plugin,p,playerProfile.getForaging(),"&6&lForaging");
				progressionMenu.createSkillGui();
			}
			else if (e.getSlot() == 23) {
				SkillProgression progressionMenu = new SkillProgression(this.plugin,p,playerProfile.getFishing(),"&b&lFishing");
				progressionMenu.createSkillGui();
			}
			
			return;
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&7&lProgression")))) {	
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("skills");
			
			return;
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&7&lProgress &7(Page")))) {	
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			
			PathStatsGui openPathStats = new PathStatsGui(p,playerProfile);
			String title = e.getView().getTitle();
			int currentPage = openPathStats.getCurrentPage(title);
			
			if (e.getSlot() == 50) openPathStats.nextPage(currentPage+1);
			else if (e.getSlot() == 49) p.performCommand("path");
			if (currentPage != 1 && e.getSlot() == 48) openPathStats.previousPage(currentPage-1);			
			
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lEnchanting Station")))) {
			EnchantTableGui enchantTable = new EnchantTableGui(p,this.plugin);
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory()!=e.getView().getTopInventory() && !enchantTable.isValidInput(e.getCurrentItem())) return;	
			if (e.getClickedInventory()!=e.getView().getTopInventory() && enchantTable.isValidInput(e.getCurrentItem()) && e.getView().getTopInventory().getItem(19)!=null) return;
			if (e.getClickedInventory() == e.getView().getTopInventory()) e.setCancelled(true);
			
			if (e.getSlot()==19 && e.getClickedInventory()==e.getView().getTopInventory() && e.getCurrentItem() != null) {
				
				if (this.InvenSpace((PlayerInventory) e.getView().getBottomInventory(), 1) > 0) {
					e.getView().getBottomInventory().addItem(e.getCurrentItem());
				}
				else {
					//IMPLEMENT ITEM STORAGE WHEN INVEN IS FULL
				}
				e.getView().setItem(19, null);
				e.setCancelled(true);
				enchantTable.setGui(e.getView().getTopInventory());
				enchantTable.generateValidInventory();	
				enchantTable.openGui();
			}
			if (e.getClickedInventory()==e.getView().getBottomInventory() && enchantTable.isValidInput(e.getCurrentItem()) && e.getView().getTopInventory().getItem(19)==null) {
				e.getView().getTopInventory().setItem(19, e.getView().getBottomInventory().getItem(e.getSlot()));
				e.getView().getBottomInventory().setItem(e.getSlot(), null);		
				e.setCancelled(true);
				enchantTable.setGui(e.getView().getTopInventory());
				enchantTable.generateValidInventory();	
				enchantTable.openGui();
			}
			if (e.getCurrentItem()==null) return;
			if (enchantTable.getItemEnchant().get(e.getCurrentItem().getType()) != null) {
				enchantTable.setGui(e.getView().getTopInventory());
				ItemStack currentItem = e.getView().getTopInventory().getItem(12);
				if (!currentItem.getItemMeta().getLore().contains(Utils.chat("&7&oClick here to view levels"))) {
					
					int spaceIndex = 0;
					for (int i=0; i<e.getCurrentItem().getItemMeta().getDisplayName().length();i++) {
						char chr = e.getCurrentItem().getItemMeta().getDisplayName().charAt(i);
						if (chr == ' ') spaceIndex = i;
					}					
					
					int enchantLevel = Integer.parseInt(e.getCurrentItem().getItemMeta().getDisplayName().substring(spaceIndex+1));
					Enchantment addEnchant = enchantTable.getItemEnchant().get(e.getCurrentItem().getType());
					
					int playerXp = p.getTotalExperience();
					int playerEnchantingLevel = this.plugin.getProfileManager().getPlayerProfile(p).getEnchanting().getLevel();
					
					String itemName = e.getCurrentItem().getItemMeta().getDisplayName().substring(2);
					
					int requiredXp = enchantTable.getEnchantXpRequirement().get(itemName);
					int requiredEnchantingLevel = enchantTable.getEnchantSkillRequirement().get(itemName);
					
					ItemStack enchantingItem = e.getView().getTopInventory().getItem(19);
					
					addingEnchantments(enchantingItem,addEnchant,enchantLevel,playerXp,requiredXp,playerEnchantingLevel,requiredEnchantingLevel,p);
					
					Inventory updateGui = enchantTable.getGui();
					updateGui.setItem(19, enchantingItem);
					
					enchantTable.setGui(updateGui);
					enchantTable.generateValidInventory();
					enchantTable.openGui();
					
				}
				else {
					enchantTable.enchantLevelsGui(enchantTable.getItemEnchant().get(e.getCurrentItem().getType()));
					enchantTable.openGui();
				}
							
				
			}			
			
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lCraft")))) {
			
			if (!isValidCraftingClick(e.getClick(),e.getView(),e.getClickedInventory(),e.getCurrentItem(),e.getSlot(),e.getCursor())) e.setCancelled(true);
										
			if (e.getCurrentItem() == null);
			
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					CustomCraft recipe = new CustomCraft(p, e.getView().getTopInventory(), craftingRecipeSet);
					
					if ((e.getClickedInventory() == e.getView().getTopInventory()) && (e.getSlot() == 24)) {
						recipe.processOutputClick(e.getView().getBottomInventory(), e.getView().getTopInventory(), e.getSlot(), e.getClick());
					}
					
				}
			},1);			
						
			return;
		}
		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lChoose a Path")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			Profile profile = this.plugin.getProfileManager().getPlayerProfile(p);
			ItemStack tank = e.getInventory().getItem(20);
			ItemStack archer = e.getInventory().getItem(21);
			ItemStack assassin = e.getInventory().getItem(22);
			
			if (e.getSlot() == 0) p.performCommand("path");
			
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
						
			return;
		}
		
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lShop")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);		
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
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 1)")))) {		
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			
			
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBlocks2");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			
			
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 3)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks2");
			if (e.getSlot() == 51) p.performCommand("shopBlocks4");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8&lBlocks Shop &7(Page 4)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);

			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks2");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks3");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 3)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks2");
			if (e.getSlot() == 51) p.performCommand("shopColorBlocks4");
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lColor Blocks Shop &7(Page 4)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopColorBlocks3");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopDecorativeBlocks2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopDecorativeBlocks1");
			if (e.getSlot() == 51) p.performCommand("shopDecorativeBlocks3");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lDecorative Blocks Shop &7(Page 3)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopDecorativeBlocks2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFarming2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lFarming Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFarming1");
		
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopFood2");
			
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&6&lFood Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopFood1");
		
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopGems2");
			
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());		
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lGems Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopGems1");
		
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMisc2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&f&lMiscellaneous Blocks Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMisc1");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopMob2");
		
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&c&lMob Drops Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopMob1");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopRedstone2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&4&lRedstone Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopRedstone1");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());	
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 1)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 51) p.performCommand("shopBrewing2");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());	
			return;
		}
		else if ((e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lBrewing Shop &7(Page 2)")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			if (e.getSlot() == 0) p.performCommand("shop");
			if (e.getSlot() == 47) p.performCommand("shopBrewing1");
			
			generateItemActionSlots(e.getSlot(),e.getCurrentItem(),p,e.getClick());		
			return;
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&c&lBuying")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}			
			e.setCancelled(true);
			
			if (e.getSlot() != 4 && !(e.getView().getTopInventory().getItem(e.getSlot()).getType().equals(Material.RED_STAINED_GLASS_PANE))) {
				int amount = this.shopPrices.getItemSlotPriceMultiplier().get(e.getSlot());
				PlayerBuyItemEvent(p,e.getInventory().getItem(e.getSlot()),amount);
			}
			
		}
		else if ((e.getView().getTitle().contains(Utils.chat("&a&lSelling")))) {
			ClickType click = e.getClick();
			if (!isValidClick(click)) {
				e.setCancelled(true);				
			}
			if (e.getClickedInventory() != e.getView().getTopInventory()) {
				return;
			}
			e.setCancelled(true);
			
			if (e.getSlot() != 4 && !(e.getView().getTopInventory().getItem(e.getSlot()).getType().equals(Material.LIME_STAINED_GLASS_PANE))) {
				int amount = this.shopPrices.getItemSlotPriceMultiplier().get(e.getSlot());
				PlayerSellItemEvent(p,e.getInventory().getItem(e.getSlot()),amount);
			}
			
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
		else if (e.getView().getTitle().contains(Utils.chat("&7&lProgression"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					p.performCommand("skills");
				}
			},1);
			return;
		}
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&a&lSkills"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						p.performCommand("menu");
					}					
				}
			},1);
			return;
		}
		else if (e.getView().getTitle().contains(Utils.chat("Shop &7(Page"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						p.performCommand("shop");
					}					
				}
			},1);
			return;
		}		
		else if (e.getView().getTitle().contains(Utils.chat("&2&lCraft"))) {
			Inventory craftingGUI = e.getView().getTopInventory();			
			for (int i=10; i<14; i++) {
				if (craftingGUI.getItem(i) != null)	p.getWorld().dropItem(p.getLocation(), craftingGUI.getItem(i));
			}
			for (int i=19; i<23; i++) {
				if (craftingGUI.getItem(i) != null)	p.getWorld().dropItem(p.getLocation(), craftingGUI.getItem(i));
			}
			for (int i=28; i<32; i++) {
				if (craftingGUI.getItem(i) != null)	p.getWorld().dropItem(p.getLocation(), craftingGUI.getItem(i));
			}
			for (int i=37; i<41; i++) {
				if (craftingGUI.getItem(i) != null)	p.getWorld().dropItem(p.getLocation(), craftingGUI.getItem(i));
			}
		}
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lPath Info"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						p.performCommand("menu");
					}					
				}
			},1);
			return;
		}
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lChoose a Path"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						p.performCommand("path");
					}					
				}
			},1);
			return;
		}
		else if (e.getView().getTitle().contains(Utils.chat("&7&lProgress &7(Page"))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						p.performCommand("path");
					}					
				}
			},1);
			return;
		}
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lEnchanting Station"))) {
			ItemStack enchantedItem = e.getView().getTopInventory().getItem(19);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					
					if (p.getOpenInventory().getTitle().equalsIgnoreCase("Crafting")) {
						if (enchantedItem != null) 	e.getPlayer().getInventory().addItem(enchantedItem);
					}					
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
		else if (items.getGems().contains(itemType)) {
			int index = items.getGems().indexOf(itemType);
			int page = Math.floorDiv(index, 28) + 1;
			String command = "ShopGems" + page;
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
	
	public void addingEnchantments(ItemStack enchantingItem, Enchantment addEnchant, int enchantLevel, int playerXp, int requiredXp, int playerSkillLevel, int requiredSkillLevel, Player p) {
		
		if (requiredXp > playerXp || requiredSkillLevel > playerSkillLevel) {
			p.sendMessage(Utils.chat("&c&lYou do not meet the requirements for apply that enchantment!"));
			return;
		}
		
		if (enchantingItem.getItemMeta().hasEnchant(addEnchant)) {
			if (enchantingItem.getItemMeta().getEnchantLevel(addEnchant) < enchantLevel) {
				enchantingItem.addEnchantment(addEnchant, enchantLevel);
				if (enchantingItem.getItemMeta().hasCustomModelData()) this.addCustomItemEnchantmentLore(enchantingItem, addEnchant, enchantLevel);
				else this.addVanillaItemEnchantmentLore(enchantingItem, addEnchant, enchantLevel);
			}
			else {
				p.sendMessage(Utils.chat("&c&lYou already have the same enchantment!"));
				return;
			}
		}
		else {
			enchantingItem.addEnchantment(addEnchant, enchantLevel);
			if (enchantingItem.getItemMeta().hasCustomModelData()) this.addCustomItemEnchantmentLore(enchantingItem, addEnchant, enchantLevel);
			else this.addVanillaItemEnchantmentLore(enchantingItem, addEnchant, enchantLevel);
		}
		p.setTotalExperience(0);
		p.setLevel(0);
		p.setExp(0);
		p.giveExp(playerXp-requiredXp);
		p.sendMessage(Utils.chat("&d&lThat enchantment cost you &a" + requiredXp + " experience!"));
	}
	
	public void addVanillaItemEnchantmentLore(ItemStack item, Enchantment enchant, int level) {
		
	}
	
	public void addCustomItemEnchantmentLore(ItemStack item, Enchantment enchant, int level) {
		
		ItemMeta meta = item.getItemMeta();		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> lore = (ArrayList<String>) meta.getLore();
		
		if (!lore.contains(Utils.chat("&6&lEnchantments: "))) {
			for (int i=2;i<lore.size();i++) {
				if (!lore.get(i).equalsIgnoreCase(Utils.chat("                          "))) continue;
				lore.add(i+1, Utils.chat("&6&lEnchantments: "));
				break;
			}
		}
		//Add diff color based on rarity
		String enchantName = enchant.getKey().toString().toLowerCase().replace("minecraft:","");
		char firstChar = enchantName.toUpperCase().charAt(0);
		enchantName = firstChar + enchantName.substring(1);
		String enchantText = Utils.chat("&a+ &7"+enchantName.replace("_e", " E") + " " + level);
		int index = lore.indexOf(Utils.chat("&6&lEnchantments: "));
		
		if (enchantName.equalsIgnoreCase("Brute")) {
			index = this.updateStatLores(lore, meta, level, index, Utils.chat("&cDamage:&6"));	
		}
		if (enchantName.equalsIgnoreCase("Prosperity")) {
			index = this.updateStatLores(lore, meta, level, index, Utils.chat("&1Luck:&6"));
		}
		if (enchantName.equalsIgnoreCase("Giant")) {
			index = this.updateStatLores(lore, meta, level, index, Utils.chat("&4Health:&6"));			
		}
		
		boolean containsEnchant = false; 
		
		for (int i=0;i<lore.size();i++) {
			if (!lore.get(i).contains(Utils.chat("&a+ &7"+enchantName))) continue;
			lore.set(i, enchantText);
			containsEnchant = true;
			break;
			}
		
		
		if (!containsEnchant) lore.add(index+1, enchantText);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
	}
	
	public int updateStatLores(ArrayList<String> lore, ItemMeta meta, int level, int index, String statString) {

		ItemsCore updateStat = new ItemStorageTable().getIDtoItemsCore().get(meta.getCustomModelData());
		updateStat.createItem(1);
		String updatedLore = updateStat.addHealth(level);
		if (statString.equals(Utils.chat("&1Luck:&6"))) updatedLore = updateStat.addLuck(level);
		else if (statString.equals(Utils.chat("&cDamage:&6"))) updatedLore = updateStat.addBruteDamage(level);
		
		Boolean hasStat = false;
		
		for (int i=0;i<lore.size();i++) {
			
			if (!lore.get(i).contains(statString)) continue;
			lore.set(i, updatedLore);
			hasStat = true;
			break;
		}
		
		if (!hasStat) {
			lore.add(index-1, updatedLore);
			index += 1;
		}
		
		return index;
	}


	public CustomCraftingItemSet getCraftingRecipeSet() {
		return craftingRecipeSet;
	}


	public void setCraftingRecipeSet(CustomCraftingItemSet craftingRecipeSet) {
		this.craftingRecipeSet = craftingRecipeSet;
	}
		
}
	

