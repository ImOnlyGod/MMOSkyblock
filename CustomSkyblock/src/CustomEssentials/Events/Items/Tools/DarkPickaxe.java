package CustomEssentials.Events.Items.Tools;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class DarkPickaxe extends ItemsCore{
		
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE,amount);
		ItemMeta meta = item.getItemMeta();
		
		
		//Add stats
		setItemBasePhysicalDamage(25);
		setItemPhysicalDamage(25);
		//meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", getItemPhysicalDamage(), Operation.ADD_NUMBER));
		setItemFlags(meta);
		
		//Set name and lore
		setItemName(Utils.chat("&8Dark Pickaxe &8[&5Tier: &7B&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(8);
		
		ArrayList<String> lore = createLore(meta);
		meta.setLore(lore);
				
	
		item.setItemMeta(meta);
		return item;
		
	}
	
	private ArrayList<String> createLore(ItemMeta meta) {
		ArrayList<String> lore = new ArrayList<String>();	
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&cDamage:&6 +"+ getItemPhysicalDamage() +"⚔"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&6&lDescription: &7Forged by darkness,"));
		lore.add(Utils.chat("&7can be used for multiple putposes!"));
		lore.add(Utils.chat("&6&lAbility: &7None"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&f&l&oRare Weapon/Tool"));
		
		return lore;
	}

}