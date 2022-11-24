package CustomEssentials.Events.EventTasks;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftFireball;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftLightningStrike;
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
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import CustomEssentials.Main;
import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Misc.ProjectileCreator;
import CustomEssentials.Events.Mobs.MobLevel;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class MobEvents implements Listener{
	
	private Main plugin;
	private String hasPlayerCrit = "&c&l";
		
	public MobEvents(Main plugin) {
		this.plugin = plugin;
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
		
		if ((e.getEntity() instanceof CraftLightningStrike)) return;
		
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
		
		if (item == null) return;
		
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
	

