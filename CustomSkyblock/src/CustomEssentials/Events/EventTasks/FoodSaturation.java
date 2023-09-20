package CustomEssentials.Events.EventTasks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import CustomEssentials.Main;


public class FoodSaturation implements Listener{
	
	private Main plugin;
		
	public FoodSaturation(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void HungerEvent(FoodLevelChangeEvent e) {
		e.setCancelled(false);
		
	}
	
	@EventHandler
	public void eatFoodEvent(PlayerItemConsumeEvent e) {
		ItemStack item = e.getItem();
		Player p = e.getPlayer();
		if (item.getType() == Material.GOLDEN_CARROT) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,60,1));
		}
	}
		
}
	

