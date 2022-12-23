package CustomEssentials.Events.Items.Weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class StarFire extends ItemsCore{
	
	
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.NETHER_STAR,amount);
		ItemMeta meta = item.getItemMeta();
		
		
		//Add stats
		setItemBasePhysicalDamage(350);
		setItemPhysicalDamage(350);
		setItemCritChance(20);
		setItemCritDamage(2);
		setItemBurstDamage(300);
		
		//meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", getItemPhysicalDamage(), Operation.ADD_NUMBER));
		setItemFlags(meta);
		
		//Set name and lore
		setItemName(Utils.chat("&bStarFire &8[&5Tier: &7A&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(9);
		
		ArrayList<String> lore = createLore(meta);
		meta.setLore(lore);
				
	
		item.setItemMeta(meta);
		return item;
		
	}
	
	private ArrayList<String> createLore(ItemMeta meta) {
		ArrayList<String> lore = new ArrayList<String>();	
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&cDamage:&6 +"+ getItemPhysicalDamage() +"⚔"));
		lore.add(Utils.chat("&5Burst Damage:&6 +"+ getItemBurstDamage() +"✶"));
		lore.add(Utils.chat("&eCritical Chance:&6 +"+ getItemCritChance() +"%✶🗡"));
		lore.add(Utils.chat("&6Critical Damage:&6 +"+ getItemCritDamage() +"x🗡"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&6&lDescription: &7Created using essence from"));
		lore.add(Utils.chat("&7from a white dwarf star."));
		lore.add(Utils.chat("&6&lAbility: &6Right Click"));
		lore.add(Utils.chat("&7Shoot a mini commet that does high damage"));
		lore.add(Utils.chat("&7in a line of 15 blocks. (&b70 Mana&7)  "));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&5&l&oEpic Weapon"));
		
		return lore;
	}
	
	@Override
	public void itemAbility(Player p, Profile profile, Main plugin) {

		int currentMana = profile.getStats().getMana();
		
		if (currentMana-70 < 0) return;
		
		profile.getStats().setMana(currentMana-70);
		
		ArmorStand starfire = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		starfire.setCustomName(p.getName().toLowerCase()+"starfiredamage");
		starfire.setInvisible(true);
		starfire.setInvulnerable(true);
		starfire.setCustomNameVisible(false);
		final Vector velocity = p.getLocation().getDirection().multiply(1);
		starfire.setVelocity(velocity);
		starfire.setHelmet(new ItemStack(Material.SEA_LANTERN));
		starfire.setCollidable(false);
		starfire.getNearbyEntities(1, 1, 1);
		DustOptions dust = new Particle.DustOptions(Color.AQUA, 10);
		new BukkitRunnable() {
			int despawnCounter = 1;
			@Override
			public void run() {
				if (despawnCounter == 30) {
					starfire.remove();
					cancel();
					return;
				}
				despawnCounter++;
				if (starfire.getNearbyEntities(2, 2, 2).size() > 0)	{
					for (Entity mob:starfire.getNearbyEntities(2, 2, 2)) {
						if (!(mob instanceof LivingEntity) || (mob instanceof Player) || (mob instanceof ArmorStand)) continue;
						LivingEntity damageableMob = (LivingEntity) mob;
						
						damageableMob.damage(profile.getStats().getBurstDamage()+100, starfire);
						EntityDamageEvent damageEvent = new EntityDamageEvent(damageableMob,DamageCause.MAGIC,profile.getStats().getBurstDamage()+100);
						damageableMob.setLastDamageCause(damageEvent);
;
					}					
				}						
						
				starfire.setVelocity(velocity.normalize().multiply(1));		
				p.spawnParticle(Particle.REDSTONE, starfire.getEyeLocation(), 1,dust);
				p.spawnParticle(Particle.SOUL_FIRE_FLAME, starfire.getEyeLocation(), 1);
			}			
		}.runTaskTimer(plugin,0,1);
		//USE FOR OTHER WEAPON
		/**
		WitherSkull f = p.launchProjectile(WitherSkull.class);
		f.setVelocity(p.getLocation().getDirection().multiply(0.5));
		f.setGlowing(true);
		f.setBounce(true);
		f.setCustomName(p.getName() + " StarFireAbility");
		f.setSilent(true);
		f.setShooter(p);	
		f.setYield(10);
		//f.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 10, true), false);
		
		final double x =  p.getLocation().getDirection().getX();
		final double y =  p.getLocation().getDirection().getY();
		final double z =  p.getLocation().getDirection().getZ();
		
		DustOptions dust = new Particle.DustOptions(Color.AQUA, 10);
		
		new BukkitRunnable() {
			int despawnCounter = 1;
			@Override
			public void run() {
				if (despawnCounter == 100) {
					f.remove();
					cancel();
					return;
				}
				despawnCounter++;
				f.setVelocity(p.getLocation().getDirection().normalize().multiply(1));		
				p.spawnParticle(Particle.REDSTONE, f.getLocation(), 1,dust);
			}			
		}.runTaskTimer(plugin,0,1);
		**/
	}
	
}