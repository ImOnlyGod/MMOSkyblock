package CustomEssentials.Events.EventTasks;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.Enchants.CustomEnchants;
import CustomEssentials.Utils.Utils;


public class SkillsFunctioning implements Listener{
	
	private Main plugin;
		
	public SkillsFunctioning(Main plugin) {
		this.plugin = plugin;
	}
				
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Block block = e.getBlock();
		
		if (block.getType() == Material.FARMLAND) return;
		
		if (block.getType() == Material.SPAWNER) {
			String spawnerName = e.getItemInHand().getItemMeta().getDisplayName();
			if (spawnerName.equals( Utils.chat("&6Wild Pig &7Spawner"))) {
				CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
				spawner.setSpawnedType(EntityType.PIG);
				spawner.update();
			}
			else if (spawnerName.equals(Utils.chat("&6Agressive Golem &7Spawner"))) {
				CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
				spawner.setSpawnedType(EntityType.IRON_GOLEM);
				spawner.update();
			}
			else if (spawnerName.equals(Utils.chat("&6Basic Zombie &7Spawner"))) {
				CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
				spawner.setSpawnedType(EntityType.ZOMBIE);
				spawner.update();
			}
			e.getBlock().setMetadata(spawnerName, new FixedMetadataValue(this.plugin,"spawner"));
			
		}
				
		if (e.getItemInHand().getItemMeta().hasDisplayName()) {
			if (e.getItemInHand().getItemMeta().getDisplayName().contains(Utils.chat("&7&lCompressed"))) {
				e.setCancelled(true);
				return;
			}			
		}
	
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
	
	public boolean checkEnchantsBlockBreak(Player p, Block block) {
		
		if (p.getInventory().getItemInMainHand() == null) return true;
		if (!p.getInventory().getItemInMainHand().hasItemMeta()) return true;
		if (!block.isPreferredTool(p.getInventory().getItemInMainHand())) return false;
		if (p.getGameMode() == GameMode.CREATIVE) return true;
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		for (ItemStack item :block.getDrops()) {
			drops.add(item);
		}

		if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.GEM_EXTRACTOR)) {
			int enchantLevel = p.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.GEM_EXTRACTOR);
			int increaseDrops = new Random().nextInt(2);
			for (ItemStack item :drops) {
				int amount = item.getAmount();
				if (enchantLevel == 1 && increaseDrops == 1) item.setAmount(amount*2);
				else if (enchantLevel == 2)  item.setAmount(amount*2);
				else if (enchantLevel == 3) {
					if (increaseDrops == 1) item.setAmount(amount*3);
					else item.setAmount(amount*2);
				}
				else if (enchantLevel == 4)  item.setAmount(amount*3);
			}
		}
		else if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.JIGSAW)) {
			//FUNCTION WITH CUSTOM SPANWERS
			ArrayList<ItemStack> silkdrops = new ArrayList<ItemStack>();
			ItemStack item = new ItemStack(block.getType());
			int enchantLevel = p.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.JIGSAW);
			if (block.getType() == Material.SPAWNER) {
				CreatureSpawner spawner = (CreatureSpawner) block.getState();
				item.setData(spawner.getData());
				ItemMeta meta = item.getItemMeta();
				if (spawner.hasMetadata(Utils.chat("&6Wild Pig &7Spawner"))) meta.setDisplayName(Utils.chat("&6Wild Pig &7Spawner"));
				else if (spawner.hasMetadata(Utils.chat("&6Agressive Golem &7Spawner")))  meta.setDisplayName(Utils.chat("&6Agressive Golem &7Spawner"));
				else if (spawner.hasMetadata(Utils.chat("&6Basic Zombie &7Spawner")))  meta.setDisplayName(Utils.chat("&6Basic Zombie &7Spawner"));
				
				item.setItemMeta(meta);
			}
			if (block.getType() == Material.SPAWNER && enchantLevel > 1) silkdrops.add(item);
			else if (block.getType() == Material.SPAWNER && enchantLevel == 1);
			else silkdrops.add(item);

			drops = silkdrops;
			
		}
		if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.VACUUM)) {
			for (ItemStack item :drops) {
				p.getInventory().addItem(item);
			}			
		}
		else {
			for (ItemStack item :drops) {
				p.getWorld().dropItemNaturally(block.getLocation(),item);
			}
		}
		return false;
	}
	
	@EventHandler
	public void miningBlock(BlockDamageEvent e) {
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Material block = e.getBlock().getType();
		Player p = e.getPlayer();
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
		profile.getFarming().generateCropXp();
		profile.getForaging().generateWoodXp();
		profile.getMining().generateBlockXp();
		ItemStack item = p.getInventory().getItemInMainHand();
		if (item != null) {
			if (item.hasItemMeta()) {
				if (item.getItemMeta().hasEnchant(CustomEnchants.EXPERIENCE_EXTRACTOR)) {
					int currentXp = e.getExpToDrop();
					double multiplier = item.getItemMeta().getEnchantLevel(CustomEnchants.EXPERIENCE_EXTRACTOR)*0.5;
					p.giveExp((int) (currentXp + (currentXp*multiplier)));
				}
			}			
		}
		
		e.setDropItems(checkEnchantsBlockBreak(p,e.getBlock()));
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
	
}
	

