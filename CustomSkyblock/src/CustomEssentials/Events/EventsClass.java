package CustomEssentials.Events;

import java.io.File;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.CropState;
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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.metadata.FixedMetadataValue;

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
	
	public void initialisePlayerProfile(Player p) {
		PlayerProfileManager profiles = this.plugin.getProfileManager();
		
		if (!profiles.hasProfile(p)) {
			profiles.createPlayerProfile(p);
		}		
		
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player p = event.getPlayer();		
		this.plugin.readPlayerProfile(p);

		initialisePlayerProfile(p);		
					
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		PlayerProfileManager profiles = this.plugin.getProfileManager();
		File directory = this.plugin.getFolderLocation();
		
		this.plugin.writePlayerFile(directory, p);
		
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
	
	@EventHandler
	public void HungerEvent(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Block block = e.getBlock();
		
		if (block.getType() == Material.FARMLAND) return;
				
		Player p = e.getPlayer();
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
		profile.getFarming().generateCropXp();
		
		
		
		if (profile.getFarming().getCropXp().containsKey(block.getType()) || 
				block.getType() == Material.BAMBOO_SAPLING || 
				block.getType() == Material.BEETROOT_SEEDS ||
				block.getType() == Material.PUMPKIN_STEM ||
				block.getType() == Material.MELON_STEM) {
			
			Double xpAmount = 0.0; 
			if (block.getType() == Material.BAMBOO_SAPLING) xpAmount = profile.getFarming().getXPamount(Material.BAMBOO);
			else if (block.getType() == Material.BEETROOT_SEEDS) xpAmount = profile.getFarming().getXPamount(Material.BEETROOT);
			else if	(block.getType() == Material.PUMPKIN_STEM) xpAmount = profile.getFarming().getXPamount(Material.PUMPKIN);
			else if	(block.getType() == Material.MELON_STEM) xpAmount = profile.getFarming().getXPamount(Material.MELON);
			else {
				xpAmount = profile.getFarming().getXPamount(block.getType());
			}
			
			if (xpAmount == 0.0) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 2, 1);
				p.sendMessage(Utils.chat("&4You require a higher farming level to place that block!"));
				return;
			}			
		}
		
		if ((block.getBlockData() instanceof Ageable) &&
				!(block.getType() == Material.CACTUS) &&
				!(block.getType() == Material.SUGAR_CANE)) return;
		

		e.getBlock().setMetadata("placed", new FixedMetadataValue(this.plugin,"something"));
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		Material block = e.getBlock().getType();
		Player p = e.getPlayer();
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
		profile.getFarming().generateCropXp();
		profile.getForaging().generateWoodXp();
		profile.getMining().generateBlockXp();
		
		if (e.getBlock().hasMetadata("placed")) return;
		
		
		if (profile.getMining().getBlockXp().containsKey(block)) {
				
			Double xpAmount = profile.getMining().getXPamount(block);
			
			if (xpAmount == 0.0) return;
			else {
				plugin.setDisplayStats(1);
				p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
				profile.getMining().addCurrentXP(xpAmount);
			}
			
		}				
		else if (profile.getForaging().getWoodXp().containsKey(block)) {

			Double xpAmount = profile.getForaging().getXPamount(block);
			
			if (xpAmount == 0.0) return;
			else {
				plugin.setDisplayStats(2);
				p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
				profile.getForaging().addCurrentXP(xpAmount);
			}
			
			
		}
		else if (profile.getFarming().getCropXp().containsKey(block)) {			
			
			int multiplier = 1;
			
			if (profile.getFarming().getNonPlantingCrops().contains(block)) {
				multiplier = getPlantHeight(e.getBlock());
	
			}
			else {
				if (e.getBlock().getBlockData() instanceof Ageable) {
					Ageable age = (Ageable) e.getBlock().getBlockData();
					if (age.getAge() != age.getMaximumAge()) return;
				}
				
			}

			Double xpAmount = profile.getFarming().getXPamount(block);
			
			if (xpAmount == 0.0) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 2, 1);
				p.sendMessage(Utils.chat("&4You require a higher farming level to interact with that crop!"));
				return;
			}
			plugin.setDisplayStats(3);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
			
			profile.getFarming().addCurrentXP(xpAmount*multiplier);
		}
		
		
	}
	
	public int getPlantHeight(Block block) {
		Location currentLoc = block.getLocation();	
		Block blockAbove = currentLoc.add(0, 1, 0).getBlock();
		if (!(blockAbove.getType() == block.getType()) || (blockAbove.hasMetadata("placed"))) return 1;
			
		return 1 + getPlantHeight(blockAbove);
	}
	
	
	@EventHandler
	public void onMobKill(EntityDeathEvent e) {
		
		if (!(e.getEntity() instanceof LivingEntity)) return;
		
		LivingEntity mob = e.getEntity();
		
		if (!(mob.getKiller() instanceof Player)) return;
						
		Player p = mob.getKiller();	
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
				
		Double xpAmount = profile.getCombat().getXPamount(mob);
		
		if (xpAmount == 0.0) {
			p.sendMessage(Utils.chat("&4You require a higher combat level to gain any XP from killing that mob!"));
		}
		else {
			plugin.setDisplayStats(4);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
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
		if (e.getEntity() instanceof ArmorStand) return;
		
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
		if (!(e.getEntity() instanceof LivingEntity)) return;
		
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
		
		String dmgStr = String.valueOf(Math.ceil(damage));
		final String dmg = dmgStr.replace(".0", "");
		Location loc = entity.getLocation();	
		
		double posX = Math.random();
		double posY = Math.random();
		double posZ = Math.random();
		
		if (damager instanceof Player) {
			Player p = (Player) damager;
			posX += 1.5*p.getFacing().getDirection().getX();
			posY += 1.5*p.getFacing().getDirection().getY();
			posZ += 1.5*p.getFacing().getDirection().getZ();
		}
				
		ArmorStand dmgIndicator = (ArmorStand) entity.getWorld().spawn(loc.add(posX,posY,posZ), ArmorStand.class, armorstand->{
			armorstand.setInvisible(true);
			armorstand.setVisible(false);
			armorstand.setInvulnerable(true);
			armorstand.setBasePlate(false);
			armorstand.setCustomName(Utils.chat(this.hasPlayerCrit+dmg+"🗡"));
			armorstand.setCustomNameVisible(true);
			armorstand.setGravity(true);
			
		});
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			@Override
			public void run() {
				dmgIndicator.remove();				
			}
			
		}, 10L);
		
	}
		
	
}
	

