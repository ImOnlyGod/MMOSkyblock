package CustomEssentials.Events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftFireball;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftProjectile;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
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

import CustomEssentials.Main;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Misc.ProjectileCreator;
import CustomEssentials.Events.Mobs.MobLevel;
import CustomEssentials.Events.PlayerPath.Paths.Archer;
import CustomEssentials.Events.PlayerPath.Paths.Assassin;
import CustomEssentials.Events.PlayerPath.Paths.Tank;
import CustomEssentials.Events.PlayerStats.Defence;
import CustomEssentials.Events.PlayerStats.Health;
import CustomEssentials.Events.PlayerStats.Speed;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class EventsClass implements Listener{
	
	private Main plugin;
	private String hasPlayerCrit = "&c&l";
		
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
		//AttackDamage playerDamage = new AttackDamage();
		Defence playerArmor = new Defence();
		Speed playerSpeed = new Speed();
		
		Profile playerProfile = profiles.getPlayerProfile(p);
		Stats stats = playerProfile.getStats();
		
		int health = stats.getHealth();
		int armor = stats.getArmor();
		int magicResist = stats.getMagicResist();
		int physicalDamage = stats.getPhysicalDamage() + playerProfile.getPath().getStats().getPhysicalDamage();
		int magicDamage = stats.getMagicDamage();
		int speed = stats.getSpeed();
		
		playerHealth.setPlayerHealth(p, health);
		playerArmor.setArmor(p, armor, magicResist);
		p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(physicalDamage);
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
			ItemStack archer = e.getInventory().getItem(21);
			ItemStack assassin = e.getInventory().getItem(22);
			
			if (e.getCurrentItem().isSimilar(tank) && (!(profile.getPath() instanceof Tank))) {
				profile.setPath(new Tank());
				p.sendMessage(Utils.chat("&7&lYou have chosen the &a&lTank &7&lPath."));
			}
			
			if (e.getCurrentItem().isSimilar(archer) && (!(profile.getPath() instanceof Archer))) {
				profile.setPath(new Archer());
				p.sendMessage(Utils.chat("&7&lYou have chosen the &6&lArcher &7&lPath."));
			}
			
			if (e.getCurrentItem().isSimilar(assassin) && (!(profile.getPath() instanceof Assassin))) {
				profile.setPath(new Assassin());
				p.sendMessage(Utils.chat("&7&lYou have chosen the &4&lAssassin &7&lPath."));
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
		
		if (!(e.getEntity() instanceof LivingEntity)) return;
		
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
	
	//ADD FALL DMG CAUSE!!
	@EventHandler
	public void mobDamageEvent(EntityDamageEvent e) {
		
		this.hasPlayerCrit = "&c&l";
		if (e.getEntityType().equals(EntityType.ARMOR_STAND) || (e.getEntity() instanceof CraftArmorStand)) return;
		
		//COMPRESS INTO ONE FUNCTION!
		LivingEntity entity = (LivingEntity) e.getEntity();		
		
		if ((e.getEntityType() != EntityType.PLAYER)) {
			
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerDamageEntityEvent(EntityDamageByEntityEvent e) {
		
		//CREATE SEPEARTE CLASS 
		ProjectileCreator projectileDamageCalulator = new ProjectileCreator();
		e.setDamage(projectileDamageCalulator.projectileDamage(e.getDamager(), e.getEntity(), e.getFinalDamage()));
		this.hasPlayerCrit = "&c&l";
		
		if (!(e.getEntity() instanceof LivingEntity)) {
			return;	
		}
		
		//ADD ARROW DMG SKELETON
		if ((!(e.getDamager() instanceof Player)) && (e.getEntity() instanceof LivingEntity)) {
			
			
			LivingEntity entity = (LivingEntity) getDamagerEntity(e.getDamager());	
			
			if (entity.isCustomNameVisible() && entity.getCustomName().length() > 30) {
				
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
				
				String levelAmount = "";
				
				for (int i=0;i < level.length();i++) {
					if (level.charAt(i) == '§') break;
					levelAmount = levelAmount + level.charAt(i);
				}
				
				float lvl = Float.parseFloat(levelAmount);
				
				//CHANGE THE ARMOR DEFENCE RATIO!
				if (e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					e.setDamage(lvl*10/p.getAttribute(Attribute.GENERIC_ARMOR).getBaseValue());	
				}
				else e.setDamage(lvl*10);
				
			}
		}
		else {
			
					
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
				this.hasPlayerCrit = "&6&l";
				
			}
			e.setDamage(damage);
			
			
			double health = p.getHealth();
			double lifeSteal = stats.getLifeStealHealAmount(damage);
			if (!(lifeSteal+health > p.getMaxHealth())) {
				p.setHealth(health+lifeSteal);
			}
			
		}
		
		//COMPRESS INTO ONE FUNCTION!
		if ((e.getEntityType() != EntityType.PLAYER)) {
				
			if (e.getEntity().isCustomNameVisible() && e.getEntity().getCustomName().length() > 30) {
				LivingEntity entity = (LivingEntity) e.getEntity();	
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
		//ADD DAMAGE INDICATOR
		damageIndicator(e.getEntity(),e.getFinalDamage(),e.getDamager());
				
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
	
	public Entity getDamagerEntity(Entity damager) {
		if ((damager instanceof CraftProjectile) || (damager instanceof CraftFireball) || (damager instanceof Projectile)) {
			Projectile arrow = (Projectile) damager;
			Entity entity = (Entity) arrow.getShooter();
			
		
			
			return entity;
			
		}
		
		LivingEntity entity = (LivingEntity) damager;
		return (Entity) entity;
	}
	
	
	public void damageIndicator(Entity entity, double damage, Entity damager) {
		if ((entity instanceof CraftArmorStand) || (entity.getType().equals(EntityType.ARMOR_STAND))) return;
		
		String dmg = String.valueOf(Math.ceil(damage));
		dmg = dmg.replace(".0", "");
		Location loc = entity.getLocation();	
		
		double posX = Math.random();
		double posY = Math.random();
		double posZ = Math.random();
		
		if (damager instanceof Player) {
			Player p = (Player) damager;
			posX += 1*p.getFacing().getDirection().getX();
			posY += 1*p.getFacing().getDirection().getY();
			posZ += 1*p.getFacing().getDirection().getZ();
		}
		
		ArmorStand dmgIndicator = (ArmorStand) entity.getWorld().spawnEntity(loc.add(posX,posY-0.5,posZ), EntityType.ARMOR_STAND);
		dmgIndicator.setVisible(false);
		dmgIndicator.setInvisible(true);
		dmgIndicator.setInvulnerable(true);
		dmgIndicator.setCustomName("");
		dmgIndicator.setCustomName(Utils.chat(this.hasPlayerCrit+dmg+"🗡"));
		dmgIndicator.setCustomNameVisible(true);
		dmgIndicator.setGravity(false);
		dmgIndicator.setCollidable(false);
		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			@Override
			public void run() {
				dmgIndicator.remove();				
			}
			
		}, 15L);
		
	}
		
	
}
	

