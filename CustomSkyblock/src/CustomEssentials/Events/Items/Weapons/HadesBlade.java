package CustomEssentials.Events.Items.Weapons;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class HadesBlade extends ItemsCore{
	
	
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.GOLDEN_SWORD,amount);
		ItemMeta meta = item.getItemMeta();
		
		
		//Add stats
		setItemPhysicalDamage(100);
		setItemManaStat(100);
		setItemCritChance(25);
		setItemCritDamage(0.75);
		
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", getItemPhysicalDamage(), Operation.ADD_NUMBER));
		setItemFlags(meta);
		
		//Set name and lore
		setItemName(Utils.chat("&6Hades Blade &8[&5Tier: &7B&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(1);
		
		ArrayList<String> lore = createLore(meta);
		meta.setLore(lore);
				
	
		item.setItemMeta(meta);
		return item;
		
	}
	
	private ArrayList<String> createLore(ItemMeta meta) {
		ArrayList<String> lore = new ArrayList<String>();	
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&cDamage:&6 +"+ getItemPhysicalDamage() +"⚔"));
		lore.add(Utils.chat("&eCritical Chance:&6 +"+ getItemCritChance() +"%✶🗡"));
		lore.add(Utils.chat("&6Critical Damage:&6 +"+ getItemCritDamage() +"x🗡"));
		lore.add(Utils.chat("&bMana:&6 +"+ getItemManaStat() +"✶"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&6&lDescription: &7Forged by shards of hell."));
		lore.add(Utils.chat("&6&lAbility: &6Right Click"));
		lore.add(Utils.chat("&7Launch a fireball &7(&b30 Mana&7)         "));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&e&l&oRare Weapon"));
		
		return lore;
	}
	
	@Override
	public void itemAbility(Player p, Profile profile) {

		int currentMana = profile.getStats().getMana();
		
		if (currentMana-30 < 0) return;
		
		profile.getStats().setMana(currentMana-30);
		
		Fireball f = p.launchProjectile(Fireball.class);
	
		f.setVelocity(p.getLocation().getDirection());
		f.setIsIncendiary(false);
		f.setGlowing(true);
		f.setBounce(true);
		f.setCustomName("HadesBladeFireball");
		f.setYield(5);	
		f.setSilent(true);
		f.setShooter(p);	
		
		
		
	}

}