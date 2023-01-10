package CustomEssentials.Events.EventTasks;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftArrow;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftFireball;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftLightningStrike;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftProjectile;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.EntitiesLoadEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.generator.model.ModelBlueprint;
import com.ticxo.modelengine.api.model.ActiveModel;

import CustomEssentials.Main;
import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.ItemStorageTable;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Events.Items.Enchants.CustomEnchants;
import CustomEssentials.Events.Items.Weapons.StormAxe;
import CustomEssentials.Events.Misc.ProjectileCreator;
import CustomEssentials.Events.Mobs.MobLevel;
import CustomEssentials.Events.Mobs.MobMappings;
import CustomEssentials.Events.Mobs.CustomMobs.AgressiveGolem;
import CustomEssentials.Events.Mobs.CustomMobs.Basic_Zombie;
import CustomEssentials.Events.Mobs.CustomMobs.WildPig;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class MobEvents implements Listener{
	
	private Main plugin;
	private String hasPlayerCrit = "&c&l";
	private HashMap<EntityType,String> mobNames = new HashMap<EntityType,String>();
	private MobMappings mobMaps = new MobMappings();
	private HashMap<String,Long> cooldowns = new HashMap<String,Long>();
		
	public MobEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	public void generateMobNames() {
		//this.mobNames.put(Entity, hasPlayerCrit)
	}
	
	public boolean hasInvenSpace(Player p, ItemStack drop) {
		
		Inventory inv = p.getInventory();
		for (int i=0;i<36;i++) {
			ItemStack item = inv.getItem(i);
			if (item == null) return true;
			if (!item.isSimilar(drop)) continue;
			if (item.getAmount() + drop.getAmount() < item.getMaxStackSize()) return true;
		}
		
		return false;
		
	}
			
	public void vacuumFeature(Player p, List<ItemStack> drops) {
		
		int i =0;
		for (ItemStack item:drops) {
			if (!hasInvenSpace(p,item)) continue;;	
			p.getInventory().addItem(item);
			drops.set(i, null);
			i++;
		}				
	}
	
	public void collectionFeature(List<ItemStack> drops, int enchantLevel) {
		
		int i =0;
		for (ItemStack item:drops) {
			int currentAmount = item.getAmount();
			double multiplier = 1 + (enchantLevel*0.25); 
			int newAmount = currentAmount;
			Random chance = new Random();
			
			if (currentAmount < 4 && enchantLevel < 5) {
				if (chance.nextDouble(multiplier) > 1) newAmount += chance.nextInt(1,enchantLevel+1); 
			}
			else newAmount = (int) (currentAmount * multiplier * chance.nextInt(enchantLevel));
				
			item.setAmount(newAmount);
			drops.set(i, item);
			i++;
		}				
	}
	
	@EventHandler
	public void onMobKill(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) return;
		if (e.getEntity() instanceof Player) return;
		if (e.getEntity().getCustomName() == null) return;
		LivingEntity mob = e.getEntity();
		
		if (mob.getCustomName().contains("Agressive Golem")) {
			for (Entity passenger:mob.getPassengers()) {
				passenger.remove();
			}		
		}
		
		e.setDroppedExp((int) mobMaps.getXPamount(mob));
		Entity killer = null;
		if (e.getEntity().getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK || mob.getLastDamageCause().getCause() == DamageCause.PROJECTILE) {
			killer  = ((EntityDamageByEntityEvent) e.getEntity().getLastDamageCause()).getDamager();
		}
		
		if (!(killer instanceof Player) && !(killer instanceof Fireball) && !(killer instanceof ArmorStand) && !(mob.getLastDamageCause().getCause() == DamageCause.LIGHTNING)) return;
					
		Player p = null;	
		if (mob.getLastDamageCause().getCause() == DamageCause.LIGHTNING) {
			EntityDamageByEntityEvent cause = (EntityDamageByEntityEvent) mob.getLastDamageCause();
			Entity lightningStrike = cause.getDamager();
			if (lightningStrike.getCustomName().contains("stormaxedamage")) {				
				String userPlayerName = lightningStrike.getName().replace("stormaxedamage", "");
				for (Player player: Bukkit.getOnlinePlayers()) {
					if (!player.getName().equalsIgnoreCase(userPlayerName)) continue;
					p = player;
					break;
				}
			}
			else return;
		}
		else if (killer instanceof Player)	p = mob.getKiller();
		else p = (Player) this.getDamagerEntity(killer);		
		
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
		
		ItemStack item = p.getInventory().getItemInMainHand();		
		if (item == null) return;
		if (!item.hasItemMeta()) return;
		//Check for probability
		if (item.getItemMeta().hasEnchant(CustomEnchants.COLLECTION)) collectionFeature(e.getDrops(), item.getItemMeta().getEnchantLevel(CustomEnchants.COLLECTION));
		
		int playerLuck = profile.getStats().getLuck();
		for (ItemStack luckyDrop: this.mobMaps.getLuckyDrops(mob,playerLuck)) {
			e.getDrops().add(luckyDrop);
		}	
		
		
		if (item.getItemMeta().hasEnchant(CustomEnchants.VACUUM)) this.vacuumFeature(p, e.getDrops());
		if (item.getItemMeta().hasEnchant(CustomEnchants.EXPERIENCE_EXTRACTOR)) {
			int currentXp = Math.max(1, e.getDroppedExp());
			double multiplier = item.getItemMeta().getEnchantLevel(CustomEnchants.EXPERIENCE_EXTRACTOR)*0.5;
			
			if (mob.getKiller() instanceof Player) e.setDroppedExp((int) (currentXp + (currentXp*multiplier)));
			else p.giveExp((int) (currentXp + (currentXp*multiplier)));
		}
		if (item.getItemMeta().hasEnchant(CustomEnchants.PICKPOCKET)) {
			double initialMoney = mobMaps.getMoneyamount(mob);
			int enchantLevel = item.getItemMeta().getEnchantLevel(CustomEnchants.PICKPOCKET);
			double totalMoney = initialMoney + (initialMoney*0.1*(enchantLevel-1));
			profile.addBalance(totalMoney);
		}	
		
	}
	
	@EventHandler
	public void ArrowTracing(EntityShootBowEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		if (!e.getBow().getItemMeta().hasEnchant(CustomEnchants.ACCURACY)) return;
		
		int enchantLevel = e.getBow().getItemMeta().getEnchantLevel(CustomEnchants.ACCURACY);
		
		Player p = (Player) e.getEntity();
		Projectile arrow = (Projectile) e.getProjectile();
		
		final Vector velocity = arrow.getVelocity();
		
		new BukkitRunnable() {
			int despawnCounter = 1;
			@Override
			public void run() {
				if (despawnCounter == 100) {
					arrow.remove();
					cancel();
					return;
				}
				despawnCounter++;
				if (arrow.getNearbyEntities(enchantLevel, enchantLevel, enchantLevel).size() > 0)	{
					for (Entity mob:arrow.getNearbyEntities(enchantLevel, enchantLevel, enchantLevel)) {
						if (!(mob instanceof LivingEntity) || (mob instanceof Player) || (mob instanceof ArmorStand)) continue;
						LivingEntity damageableMob = (LivingEntity) mob;
						
						double speed = arrow.getVelocity().length();
						arrow.setVelocity(velocity.normalize().add(damageableMob.getLocation().toVector().subtract(arrow.getLocation().toVector())).normalize().multiply(speed));
					}					
				}					
			}			
		}.runTaskTimer(plugin,0,1);
		
		
	}
	
	@EventHandler
	public void mobLoading(EntitiesLoadEvent e) {
		
		for (Entity entity: e.getEntities()) {
			if (!(entity instanceof LivingEntity)) continue;
			if (entity.getCustomName() == null) continue;
		
			if (entity.getCustomName().contains("Agressive Golem")) {
				if (ModelEngineAPI.getOrCreateModeledEntity(entity).getModel("rocky") != null) continue;
				else {
					ModelBlueprint model = ModelEngineAPI.getBlueprint("rocky");
					ActiveModel mob = ModelEngineAPI.createActiveModel(model);
					ModelEngineAPI.getOrCreateModeledEntity(entity).addModel(mob, true);
					
					for (Entity passenger:entity.getPassengers()) {
						passenger.remove();
					}	
					
					ArmorStand nameTag = (ArmorStand) entity.getWorld().spawn(entity.getLocation().add(0,3,0), ArmorStand.class, armorstand->{
						armorstand.setInvisible(true);
						armorstand.setVisible(false);
						armorstand.setInvulnerable(true);
						armorstand.setBasePlate(false);
						armorstand.setCustomName(entity.getCustomName());
						armorstand.setCustomNameVisible(true);
						armorstand.setGravity(true);
						armorstand.setCollidable(false);
						
					});
					entity.addPassenger(nameTag);
				}
				
			}
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
	
	@EventHandler
	public void spawnerMobsEvent(SpawnerSpawnEvent e) {
		Location loc = e.getLocation();
		if (e.getSpawner().hasMetadata(Utils.chat("&6Wild Pig &7Spawner"))) {			
			new WildPig(loc,1);
			e.setCancelled(true);
		}
		else if (e.getSpawner().hasMetadata(Utils.chat("&6Agressive Golem &7Spawner"))) {			
			new AgressiveGolem(loc,1);
			e.setCancelled(true);
		}
		else if (e.getSpawner().hasMetadata(Utils.chat("&6Basic Zombie &7Spawner"))) {			
			new Basic_Zombie(loc,1);
			e.setCancelled(true);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void mobSpawnEvent(CreatureSpawnEvent e) {
		
		if (e.getSpawnReason().equals(SpawnReason.LIGHTNING)) {
			e.getEntity().setCustomName(null);;
		}
		
		if (!(e.getEntity() instanceof LivingEntity)) return;
		if (e.getEntity() instanceof ArmorStand) return;
		
		MobLevel level = new MobLevel();
		
		//Get the bigger value between x and z where mob spawned
		int distance = Math.max(Math.abs(e.getEntity().getLocation().getBlockX()),Math.abs(e.getEntity().getLocation().getBlockZ()));
		
		String mobName;
		String customName;
		if (e.getEntity().getCustomName() == null) {
			mobName = e.getEntity().getName();
			e.getEntity().resetMaxHealth();
			e.getEntity().setMaxHealth(level.getHealth(distance));
			e.getEntity().setHealth(level.getHealth(distance));
			customName = Utils.chat("&7&l[&a&l" + level.getLevel() + "&7&l] &6&l" + mobName + " &7&l(&a&l" +  Math.floor(e.getEntity().getHealth()) + "&4♥&7&l)");
		}
		else {
			mobName = e.getEntity().getCustomName();
			customName = Utils.chat(mobName + " &7&l(&a&l" +  Math.floor(e.getEntity().getHealth()) + "&4♥&7&l)");
		}
		
		
		e.getEntity().setCustomName(customName);
		e.getEntity().setCustomNameVisible(true);
		
		if (e.getEntity().getCustomName().contains("Agressive Golem")) {
			for (Entity passenger:e.getEntity().getPassengers()) {
				passenger.setCustomName("");
				passenger.setCustomName(customName);
			}		
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
				
				String healthString = "";
				for (int i=0;i<mobName.length();i++) {
					if (mobName.charAt(i) == '(') {
						for (int j=i+5;j<mobName.length()-8;j++) {
							healthString += mobName.charAt(j);
						}
						break;
					}
				}
				
				String customName = mobName.replace(healthString,""+Math.max(0.0,Math.floor(entity.getHealth()-e.getFinalDamage())));
				
				e.getEntity().setCustomName("");
				e.getEntity().setCustomName(customName);		
				
				if (e.getEntity().getCustomName().contains("Agressive Golem")) {
					for (Entity passenger:e.getEntity().getPassengers()) {
						passenger.setCustomName("");
						passenger.setCustomName(customName);
					}		
				}
				
												
			}
			return;
		}	
		
	
	}	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerDamageEntityEvent(EntityDamageByEntityEvent e) {
		
		//System.out.println(model.getModelId());
		//CREATE SEPEARTE CLASS 
		ProjectileCreator projectileDamageCalulator = new ProjectileCreator();
		e.setDamage(projectileDamageCalulator.projectileDamage(e.getDamager(), e.getEntity(), e.getFinalDamage()));
		this.hasPlayerCrit = "&c&l";
		
		if (!(e.getEntity() instanceof LivingEntity)) {
			return;	
		}
		if ((e.getEntity().getCustomName() == null && e.getEntity().getType() != EntityType.PLAYER)) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getEntity() instanceof ArmorStand) {
			if (e.getEntity().getCustomName().contains("starfiredamage")) {
				e.setCancelled(true);
				return;
			}
		}
		
		if (e.getDamager() instanceof CraftLightningStrike) {
			
			e.setDamage(10);
			if (e.getDamager().getCustomName().contains("stormaxedamage")) {				
				
				String userPlayerName = e.getDamager().getName().replace("stormaxedamage", "");
				Player userPlayer = null;
				for (Player p: Bukkit.getOnlinePlayers()) {
					if (!p.getName().equalsIgnoreCase(userPlayerName)) continue;
					
					userPlayer = p;
					break;
				}
				Stats userStats = this.plugin.getProfileManager().getPlayerProfile(userPlayer).getStats();
				double damage = userStats.getMagicDamage();
				e.setDamage(damage);
				if (!(e.getEntity() instanceof LivingEntity)) return;
				
				if (!(e.getEntity() instanceof Player)) return;
				else {
					Player p = (Player) e.getEntity();
					
					if (!p.equals(userPlayer)) return;
					e.setCancelled(true);
					p.setFireTicks(0);
				}				
			}			
		}
		
		if (e.getDamager() instanceof CraftArrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() instanceof Player) {
				Player shooter = (Player) arrow.getShooter();
				Stats shooterStats = this.plugin.getProfileManager().getPlayerProfile(shooter).getStats();
				e.setDamage(shooterStats.getRangedDamage());
			}
			else e.setDamage(50);
		}
		
		//ADD ARROW DMG SKELETON
		if ((!(e.getDamager() instanceof Player)) && (e.getEntity() instanceof LivingEntity)) {
			
			if (e.getDamager() instanceof LivingEntity) {
				
				LivingEntity entity = (LivingEntity) getDamagerEntity(e.getDamager());	
				
				if (entity.isCustomNameVisible() && entity.getCustomName().length() > 30) {
					
					if (e.getDamager().getCustomName().contains("Agressive Golem")) {
						if (ModelEngineAPI.getOrCreateModeledEntity(e.getDamager()).getModel("rocky") != null) {
							ModelEngineAPI.getOrCreateModeledEntity(e.getDamager()).getModel("rocky").getAnimationHandler().playAnimation("punch",0.0001, 30, 7.8, true);
						}
						else {
							ModelBlueprint model = ModelEngineAPI.getBlueprint("rocky");
							ActiveModel mob = ModelEngineAPI.createActiveModel(model);
							ModelEngineAPI.getOrCreateModeledEntity(e.getDamager()).addModel(mob, true);
							
							for (Entity passenger:e.getDamager().getPassengers()) {
								passenger.remove();
							}	
							
							ArmorStand nameTag = (ArmorStand) e.getDamager().getWorld().spawn(e.getDamager().getLocation().add(0,3,0), ArmorStand.class, armorstand->{
								armorstand.setInvisible(true);
								armorstand.setVisible(false);
								armorstand.setInvulnerable(true);
								armorstand.setBasePlate(false);
								armorstand.setCustomName(e.getDamager().getCustomName());
								armorstand.setCustomNameVisible(true);
								armorstand.setGravity(true);
								armorstand.setCollidable(false);
								
							});
							e.getDamager().addPassenger(nameTag);
						}
						
					}
					
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
						double armor = this.plugin.getProfileManager().getPlayerProfile(p).getStats().getArmor();
						e.setDamage(e.getDamage()*lvl*10/armor);	
					}
					else e.setDamage(lvl*10*e.getDamage());
				}
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
	
				String healthString = "";
				for (int i=0;i<mobName.length();i++) {
					if (mobName.charAt(i) == '(') {
						for (int j=i+5;j<mobName.length()-8;j++) {
							healthString += mobName.charAt(j);
						}
						break;
					}
				}
				
				String customName = mobName.replace(healthString,""+Math.max(0,Math.floor(entity.getHealth()-e.getFinalDamage())));
				e.getEntity().setCustomName("");
				
				//String customName = Utils.chat("&7&l[&a&l" + level + "&7&l] &6&l" + entity.getName() + " &7&l(&a&l" + Math.floor(Math.max(0,entity.getHealth()-e.getFinalDamage())) + "&4♥&7&l)");
				
				e.getEntity().setCustomName(customName);
				
				if (e.getEntity().getCustomName().contains("Agressive Golem")) {
					for (Entity passenger:e.getEntity().getPassengers()) {
						passenger.setCustomName("");
						passenger.setCustomName(customName);
					}		
				}
				
				
												
			}	
				
			
			
		}
		//ADD DAMAGE INDICATOR
		damageIndicator(e.getEntity(),e.getFinalDamage(),e.getDamager());
				
	}

	public boolean isAbilityCooldown(String name) {
		if (!this.cooldowns.containsKey(name)) return false;
		
		long cD = (this.cooldowns.get(name)-System.currentTimeMillis())/1000;
		
		if (cD > 0) return true;
		
		return false;
	}
	
	public void handleCooldown(ItemsCore item, Player p, Profile playerProfile) {
		String itemName = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + p.getDisplayName();
		if (isAbilityCooldown(itemName)) {
			long cD = ((this.cooldowns.get(itemName)-System.currentTimeMillis())/1000);
			p.sendMessage(Utils.chat("&bYou can use that ability in " + cD + " seconds!"));
		}
		else {
			item.itemAbility(p, playerProfile, this.plugin);
			if (!this.cooldowns.containsKey(itemName)) this.cooldowns.put(itemName, System.currentTimeMillis() + (1 * 1000));
			else this.cooldowns.replace(itemName, System.currentTimeMillis() + (1 * 1000));
		}
	}
	
	public void handleCooldownStormAxe(ItemsCore item, Player p, Profile playerProfile, Action action, Block block) {
		String itemName = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + p.getDisplayName();
		if (isAbilityCooldown(itemName)) {
			long cD = ((this.cooldowns.get(itemName)-System.currentTimeMillis())/1000);
			p.sendMessage(Utils.chat("&bYou can use that ability in " + cD + " seconds!"));
		}
		else {
			if ((action.equals(Action.RIGHT_CLICK_AIR))) {
				((StormAxe) item).axeAbility(p,  playerProfile, p.getLocation());
			}
			else {
				((StormAxe) item).axeAbility(p,  playerProfile, block.getLocation());
			}
			if (!this.cooldowns.containsKey(itemName)) this.cooldowns.put(itemName, System.currentTimeMillis() + (25 * 1000));
			else this.cooldowns.replace(itemName, System.currentTimeMillis() + (25 * 1000));
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
		
		if (item == null) return;
		
		if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
		

		if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1) {
			this.handleCooldown(item, p, profiles.getPlayerProfile(p));			
		}
		else if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 9) {
			this.handleCooldown(item, p, profiles.getPlayerProfile(p));			
		}
		else if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 6) {
			this.handleCooldownStormAxe(item, p, profiles.getPlayerProfile(p), e.getAction(), e.getClickedBlock());
		}
		
		
	}
	
	public Entity getDamagerEntity(Entity damager) {
		if ((damager instanceof CraftProjectile) || (damager instanceof CraftFireball) || (damager instanceof Projectile) || (damager instanceof CraftArrow)) {
			Projectile arrow = (Projectile) damager;
			Entity entity = (Entity) arrow.getShooter();

			return entity;
		}
		else if (damager instanceof CraftArmorStand)  {
			if (damager.getCustomName().contains("starfiredamage")) {				
				String userPlayerName = damager.getName().replace("starfiredamage", "");
				for (Player player: Bukkit.getOnlinePlayers()) {
					if (!player.getName().equalsIgnoreCase(userPlayerName)) continue;
					return player;
				}
			}
		}
		
		LivingEntity entity = (LivingEntity) damager;
		return entity;
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

	public HashMap<String,Long> getCooldowns() {
		return cooldowns;
	}

	public void setCooldowns(HashMap<String,Long> cooldowns) {
		this.cooldowns = cooldowns;
	}

	public HashMap<EntityType,String> getMobNames() {
		return mobNames;
	}

	public void setMobNames(HashMap<EntityType,String> mobNames) {
		this.mobNames = mobNames;
	}
	
	
	
		
	
}
	

