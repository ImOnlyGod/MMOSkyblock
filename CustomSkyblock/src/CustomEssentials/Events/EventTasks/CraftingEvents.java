package CustomEssentials.Events.EventTasks;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Main;
import CustomEssentials.Events.Gui.Enchants.EnchantTableGui;
import CustomEssentials.Events.Items.Enchants.CustomEnchants;
import CustomEssentials.Utils.Utils;


public class CraftingEvents implements Listener{
	
	private Main plugin;
		
	public CraftingEvents(Main plugin) {
		this.setPlugin(plugin);
	}
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {
		if (e.getInventory().getType() == InventoryType.WORKBENCH) {
			e.setCancelled(true);
			Player p = (Player) e.getPlayer();
			p.performCommand("craft");
		}
		else if (e.getInventory().getType() == InventoryType.ENCHANTING) {
			e.setCancelled(true);
			Player p = (Player) e.getPlayer();
			EnchantTableGui gui = new EnchantTableGui(p, this.plugin);
			gui.createInitialGui();
		}
	}
	
	
	
	@EventHandler
	public void PlayerDragEvent(InventoryDragEvent e) {
		
		if ((e.getView().getTitle().equals("Crafting") || 
				e.getView().getTitle().equals("Chest") || 
				e.getView().getTitle().equals("Large Chest") || 
				e.getView().getTitle().equals("Inventory") ||
				e.getView().getTitle().equals("Furnace") || 
				e.getView().getTitle().equals("Trapped Chest") || 
				e.getView().getTitle().equals("Large Trapped Chest") || 
				e.getView().getTitle().equals("Repair & Name") || 
				e.getView().getTitle().equals("Enchant") || 
				e.getView().getTitle().equals("Loom") || 
				e.getView().getTitle().equals("Barrel") || 
				e.getView().getTitle().equals("Smoker") || 
				e.getView().getTitle().equals("Blast Furnace") || 
				e.getView().getTitle().equals("Cartography Table") || 
				e.getView().getTitle().equals("Repair & Disenchant") || 
				e.getView().getTitle().equals("Upgrade Gear") || 
				e.getView().getTitle().equals("Stonecutter") || 
				e.getView().getTitle().equals("Item Hopper") || 
				e.getView().getTitle().equals("Dropper") || 
				e.getView().getTitle().equals("Dispenser") ||
				e.getView().getTitle().equals("Ender Chest") ||
				e.getView().getTitle().equals("Shulker Box") ||
				e.getView().getTitle().equals("Minecart with Chest"))) {
			return;
		}			
		else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&2&lCraft"))) {
			for (int i: e.getRawSlots()) {	
				if (i == 24) {
					e.setCancelled(true);
					return;
				}
				if (i > e.getView().getTopInventory().getSize()) continue;
				if (e.getView().getTopInventory().getItem(i) == null) continue;
				if (e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)) || e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.RED_STAINED_GLASS_PANE)) ||
						e.getView().getTopInventory().getItem(i).isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE))) {
					e.setCancelled(true);
					return;
				}
			}
			return;
		}
		for (int i: e.getRawSlots()) {	
			if (i < (e.getInventory().getSize())) {
				e.setCancelled(true);
				return;
			}
		}
	
	}
	
	@EventHandler
	public void putItemInEnchantTable(PrepareItemEnchantEvent e) {
		//MAYBE CUSTOM GUI??/
		System.out.println(e.getEnchantmentBonus()); //POWER OF BOOKSHELV
		e.getOffers()[0] = new EnchantmentOffer(CustomEnchants.VACUUM, 1, 10);
		e.getOffers()[1] = new EnchantmentOffer(CustomEnchants.VACUUM, 1, 30);
		e.getOffers()[2] = new EnchantmentOffer(CustomEnchants.VACUUM, 1, 60);
		
	}
	
	@EventHandler
	public void enchantingEvent(EnchantItemEvent e) {
		e.setExpLevelCost(50);
		//e.getEnchantsToAdd().remove(Enchantment.PROTECTION_ENVIRONMENTAL);
		//e.getEnchantsToAdd().remove(Enchantment.PROTECTION_EXPLOSIONS);
		//e.getEnchantsToAdd().remove(Enchantment.PROTECTION_FALL);
		//e.getEnchantsToAdd().remove(Enchantment.PROTECTION_FIRE);
		//e.getEnchantsToAdd().remove(Enchantment.PROTECTION_PROJECTILE);
		//e.getEnchantsToAdd().remove(Enchantment.DURABILITY);
		//e.getEnchantsToAdd().replace(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		e.getEnchantsToAdd().put(CustomEnchants.VACUUM, 1);
		for (Enchantment enchant: e.getEnchantsToAdd().keySet()) {
			if (e.getItem().getItemMeta().hasCustomModelData()) {
				//replace damage if sharpness
				this.addCustomItemEnchantmentLore(e.getItem(), enchant, e.getEnchantsToAdd().get(enchant));
			}
			else this.addVanillaItemEnchantmentLore(e.getItem(), enchant, e.getEnchantsToAdd().get(enchant));
		}
		
	}
	
	@EventHandler
	public void putItemInAnvil(PrepareAnvilEvent e) {
		
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
		String enchantText = Utils.chat("&a+ &7"+enchantName + " " + level);
		int index = lore.indexOf(Utils.chat("&6&lEnchantments: "));
		lore.add(index+1, enchantText);
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		
	}
	

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
			
	
}
	

