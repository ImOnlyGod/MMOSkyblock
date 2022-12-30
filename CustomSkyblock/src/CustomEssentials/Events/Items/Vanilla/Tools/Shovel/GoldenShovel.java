package CustomEssentials.Events.Items.Vanilla.Tools.Shovel;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class GoldenShovel extends ItemsCore{
		
	public ItemStack createItem(int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(Material.GOLDEN_SHOVEL,amount);
		ItemMeta meta = item.getItemMeta();
			
		setItemBasePhysicalDamage(3);
		setItemPhysicalDamage(3);	
		
		setItemFlags(meta);
		//Set name and lore
		setItemName(Utils.chat("&fGolden Shovel &8[&5Tier: &7F&8]"));
		meta.setDisplayName(getItemName());	
		meta.setCustomModelData(121);
		
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
		lore.add(Utils.chat("&f&l&oCommon Shovel"));
		
		return lore;
	}

}