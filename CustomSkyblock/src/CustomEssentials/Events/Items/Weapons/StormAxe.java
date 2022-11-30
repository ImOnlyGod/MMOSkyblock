package CustomEssentials.Events.Items.Weapons;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class StormAxe extends ItemsCore{
	
	
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.STONE_AXE,amount);
		ItemMeta meta = item.getItemMeta();
		
		
		//Add stats
		setItemPhysicalDamage(250);
		setItemManaStat(400);
		setItemCritChance(15);
		setItemCritDamage(0.6);
		setItemBurstDamage(300);
		
		//meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", getItemPhysicalDamage(), Operation.ADD_NUMBER));
		setItemFlags(meta);
		
		//Set name and lore
		setItemName(Utils.chat("&fStorm Axe &8[&5Tier: &7A&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(6);
		
		ArrayList<String> lore = createLore(meta);
		meta.setLore(lore);
				
	
		item.setItemMeta(meta);
		return item;
		
	}
	
	private ArrayList<String> createLore(ItemMeta meta) {
		ArrayList<String> lore = new ArrayList<String>();	
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&cDamage:&6 +"+ getItemPhysicalDamage() +"⚔"));
		lore.add(Utils.chat("&5Burst Damage:&6 +"+ getItemBurstDamage() +"⚔"));
		lore.add(Utils.chat("&eCritical Chance:&6 +"+ getItemCritChance() +"%✶🗡"));
		lore.add(Utils.chat("&6Critical Damage:&6 +"+ getItemCritDamage() +"x🗡"));
		lore.add(Utils.chat("&bMana:&6 +"+ getItemManaStat() +"✶"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&6&lDescription: &7Created by the"));
		lore.add(Utils.chat("&7core of thunder!"));
		lore.add(Utils.chat("&6&lAbility: &6Right Click"));
		lore.add(Utils.chat("&7Creates a ThunderStorm "));
		lore.add(Utils.chat("&7near the User (&b55 Mana&7)"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&c&l&oEpic Weapon"));
		
		return lore;
	}
	
	public void axeAbility(Player p, Profile profile, Location loc) {

		int currentMana = profile.getStats().getMana();
		if (currentMana-55 < 0) return;
		profile.getStats().setMana(currentMana-55);
		
		Location playerLoc = p.getLocation();
		
		String name = p.getName().toLowerCase() + "stormaxedamage";
		LightningStrike lightning1 = p.getWorld().strikeLightning(loc.add(2, 0, 0));
		lightning1.setCustomName(name);
		LightningStrike lightning2 = p.getWorld().strikeLightning(loc.add(2, 0, 2));
		lightning2.setCustomName(name);
		LightningStrike lightning3 = p.getWorld().strikeLightning(loc.add(0, 0, 2));
		lightning3.setCustomName(name);
		LightningStrike lightning4 = p.getWorld().strikeLightning(loc.add(-2, 0, 0));
		lightning4.setCustomName(name);
		LightningStrike lightning5 = p.getWorld().strikeLightning(loc.add(-2, 0, -2));
		lightning5.setCustomName(name);
		LightningStrike lightning6 = p.getWorld().strikeLightning(loc.add(0, 0, -2));
		lightning6.setCustomName(name);

		
		
		
		
	}

}