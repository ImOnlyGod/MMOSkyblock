package CustomEssentials.Events.Items.Vanilla.Swords;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class StoneSword extends ItemsCore{
		
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.STONE_SWORD,amount);
		ItemMeta meta = item.getItemMeta();
			
		setItemBasePhysicalDamage(2);
		setItemPhysicalDamage(2);	
		
		setItemFlags(meta);
		//Set name and lore
		setItemName(Utils.chat("&fStone Sword &8[&5Tier: &7F&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(101);
		
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
		lore.add(Utils.chat("&6&lDescription: &7None"));
		lore.add(Utils.chat("&6&lAbility: &7None"));
		lore.add(Utils.chat("                          "));
		lore.add(Utils.chat("&f&l&oCommon Weapon"));
		
		return lore;
	}

}