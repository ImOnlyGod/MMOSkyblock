package CustomEssentials.Events.EventTasks;

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
import CustomEssentials.Events.PlayerStats.Defence;
import CustomEssentials.Events.PlayerStats.Health;
import CustomEssentials.Events.PlayerStats.Speed;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;


public class PlayerJoinLeave implements Listener{
	
	private Main plugin;
		
	public PlayerJoinLeave(Main plugin) {
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
		
}
	

