package CustomEssentials.Events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import CustomEssentials.Main;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Misc.ProjectileCreator;
import CustomEssentials.Events.Misc.TimeGenerator;
import CustomEssentials.Events.Mobs.MobLevel;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.PlayerStats.AttackDamage;
import CustomEssentials.Events.PlayerStats.Defence;
import CustomEssentials.Events.PlayerStats.Health;
import CustomEssentials.Events.PlayerStats.Speed;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class EventsClass implements Listener{
	
	private Main plugin;
		
	public EventsClass(Main plugin) {
		this.plugin = plugin;
	}
	

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player p = event.getPlayer();
		PlayerProfileManager profiles = this.plugin.getProfileManager();
		
		if (!profiles.hasProfile(p)) {
			profiles.createPlayerProfile(p);
		}		
		
		Health playerHealth =  new Health();
		AttackDamage playerDamage = new AttackDamage();
		Defence playerArmor = new Defence();
		Speed playerSpeed = new Speed();
		
		Profile playerProfile = profiles.getPlayerProfile(p);
		Stats stats = playerProfile.getStats();
		
		int health = stats.getHealth();
		int armor = stats.getArmor();
		int magicResist = stats.getMagicResist();
		int physicalDamage = stats.getPhysicalDamage();
		int magicDamage = stats.getMagicDamage();
		int speed = stats.getSpeed();
		
		playerHealth.setPlayerHealth(p, health);
		playerArmor.setArmor(p, armor, magicResist);
		playerDamage.setDamage(p, physicalDamage, magicDamage);
		playerSpeed.setPlayerSpeed(p, speed);
		
		
			
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
			
			if (e.getCurrentItem().isSimilar(tank) && (profile.getPath() instanceof Tank)) {
				profile.setPath(new Tank());
				p.sendMessage(Utils.chat("&7&lYou have chosen the &a&lTank &7&lPath."));
			}
						
			
			e.setCancelled(true);
			return;
		}
		
	}
	
	@EventHandler
	public void OpenMenuEvent(InventoryOpenEvent e) {
		
			
	}
	
	@EventHandler
	public void HungerEvent(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		Material block = e.getBlock().getType();
		Player p = e.getPlayer();
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
		
		if (block == Material.STONE
			|| block == Material.COBBLESTONE
			|| block == Material.COAL_ORE
			|| block == Material.IRON_ORE
			|| block == Material.LAPIS_ORE
			|| block == Material.REDSTONE_ORE
			|| block == Material.GOLD_ORE
			|| block == Material.DIAMOND_ORE
			|| block == Material.EMERALD_ORE) {
			
			plugin.setDisplayStats(1);
			Double xpAmount = profile.getMining().getXPamount(block);
			
			profile.getMining().addCurrentXP(xpAmount);
		}				
		else if (block == Material.OAK_LOG
				|| block == Material.BIRCH_LOG
				|| block == Material.SPRUCE_LOG
				|| block == Material.ACACIA_LOG
				|| block == Material.DARK_OAK_LOG
				|| block == Material.JUNGLE_LOG) {
			
			plugin.setDisplayStats(2);
			Double xpAmount = profile.getForaging().getXPamount(block);
			
			profile.getForaging().addCurrentXP(xpAmount);
			
		}
		else if (block == Material.WHEAT
				|| block == Material.CARROT
				|| block == Material.POTATO
				|| block == Material.PUMPKIN
				|| block == Material.BEETROOT
				|| block == Material.SUGAR_CANE
				|| block == Material.CACTUS
				|| block == Material.MELON
				|| block == Material.COCOA_BEANS
				) {
			
			plugin.setDisplayStats(3);
			Double xpAmount = profile.getFarming().getXPamount(block);
			
			profile.getFarming().addCurrentXP(xpAmount);
		}
		
		
	}
	
	
	@EventHandler
	public void onMobKill(EntityDeathEvent e) {
				
		LivingEntity mob = e.getEntity();
		
		if (mob.getType().equals(EntityType.CREEPER) && (e.getEntity().getKiller() != null)) {
			
			Player p = e.getEntity().getKiller();
			Profile profile = plugin.getProfileManager().getPlayerProfile(p);
			
			plugin.setDisplayStats(4);
			Double xpAmount = profile.getCombat().getXPamount(mob.getType());
			
			profile.getCombat().addCurrentXP(xpAmount);
		}
	}
	
	@EventHandler
	public void fishingEvent(PlayerFishEvent e) {
		//FIX for pulling mobs
		if (e.getState() == State.CAUGHT_FISH) {
			e.getCaught().remove();
			
			ItemStack item = new ItemStack(Material.DIAMOND);
			
			Player p = e.getPlayer();
			Profile profile = plugin.getProfileManager().getPlayerProfile(p);
			plugin.setDisplayStats(5);
			profile.getFishing().addCurrentXP(10.0);
			
			p.getInventory().addItem(item);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void mobSpawnEvent(CreatureSpawnEvent e) {
		
		
		if (e.getEntity().getCustomName() == null) {
					
		String mobName = e.getEntity().getName();
		
		MobLevel level = new MobLevel();
		
		//Get the bigger value between x and z where mob spawned
		int distance = Math.max(Math.abs(e.getEntity().getLocation().getBlockX()),Math.abs(e.getEntity().getLocation().getBlockZ()));
		
	
		e.getEntity().resetMaxHealth();
		e.getEntity().setMaxHealth(level.getHealth(distance));
		e.getEntity().setHealth(level.getHealth(distance));
		
		String customName = Utils.chat("&7&l[&a&l" + level.getLevel() + "&7&l] &6&l" + mobName + " &7&l(&a&l" + e.getEntity().getHealth() + "&4♥&7&l)");	
		e.getEntity().setCustomName(customName);
		e.getEntity().setCustomNameVisible(true);
		}
	}
	
	@EventHandler
	public void mobDamageEvent(EntityDamageEvent e) {
		
		if (!(e.getEntity() instanceof LivingEntity)) return;
	
		
		LivingEntity entity = (LivingEntity) e.getEntity();		
		
		if (e.getEntityType() != EntityType.PLAYER) {
			
			if (e.getEntity().isCustomNameVisible() && e.getEntity().getCustomName().length() > 30) {
				
				String mobName = entity.getCustomName();
				StringBuilder level = new StringBuilder();
				boolean continueStr = true;
				
				for (int i=9;i < 20;i++) {
					if (mobName.charAt(i) == ']') {
						continueStr = false;
						break;
					}
					if (continueStr == true) {
						level.append(mobName.charAt(i));	
					}
					
				}
				e.getEntity().setCustomName("");
				
				String customName = Utils.chat("&7&l[&a&l" + level + "&7&l] &6&l" + entity.getName() + " &7&l(&a&l" + Math.floor(Math.max(0,entity.getHealth()-e.getFinalDamage())) + "&4♥&7&l)");
				
				e.getEntity().setCustomName(customName);				
				
								
			}			
		}
	}
	
	@EventHandler
	public void playerDamageEntityEvent(EntityDamageByEntityEvent e) {
		
		//CREATE SEPEARTE CLASS 
		ProjectileCreator projectileDamageCalulator = new ProjectileCreator();
		e.setDamage(projectileDamageCalulator.projectileDamage(e.getDamager(), e.getEntity(), e.getFinalDamage()));
		
		if (!(e.getDamager() instanceof Player)) return;
		
		Player p = (Player) e.getDamager();		
		PlayerProfileManager profile = this.plugin.getProfileManager();
		
		Stats stats = profile.getPlayerProfile(p).getStats();
		double critChance = stats.getCriticalChance();
		double critDamage = stats.getCriticalDamage();
		double damage = e.getFinalDamage();
		

	
		Random rand = new Random();
		int crit = rand.nextInt(101);
		
		if (crit <= critChance) {
			damage = damage*critDamage;
			
		}
		e.setDamage(damage);
		
		
		double health = p.getHealth();
		double lifeSteal = stats.getLifeStealHealAmount(damage);
		if (!(lifeSteal+health > p.getMaxHealth())) {
			p.setHealth(health+lifeSteal);
			
		}
		
	}
	
	@EventHandler
	public void playerRightClickEvent(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		PlayerProfileManager profiles = this.plugin.getProfileManager();
				
		ItemStats checkItem = new ItemStats(p,profiles);
		if (!checkItem.isValidWeaponItem()) return;
		
		int ID = checkItem.getItemCustomID(p.getInventory().getItemInMainHand());
		ItemStorageTable table = new ItemStorageTable();
		ItemsCore item = table.getIDtoItemsCore().get(ID);
		
		if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
		
		item.itemAbility(p, profiles.getPlayerProfile(p));
		
	}

	
}
	

