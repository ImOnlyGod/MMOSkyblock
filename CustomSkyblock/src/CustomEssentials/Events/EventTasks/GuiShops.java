package CustomEssentials.Events.EventTasks;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftFireball;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftProjectile;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import CustomEssentials.Main;
import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Misc.ProjectileCreator;
import CustomEssentials.Events.Mobs.MobLevel;
import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class GuiShops implements Listener{
	
	private Main plugin;
		
	public GuiShops(Main plugin) {
		this.plugin = plugin;
	}
		
	
	@EventHandler
	public void OnClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
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
		
		
	}
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {

	}		
	
}
	

