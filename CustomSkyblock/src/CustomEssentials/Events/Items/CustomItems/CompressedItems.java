package CustomEssentials.Events.Items.CustomItems;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;


public class CompressedItems extends ItemsCore{
	
	public ItemStack createItem(Material material, int amount) {
		
		//Create the item
		ItemStack item = new ItemStack(material,amount);
		ItemMeta meta = item.getItemMeta();
		
		//Set name and lore
		setItemFlags(meta);
		String name = material.name().replace('_', ' ').toLowerCase();
		String itemName =  material.name().toUpperCase().substring(0,1);
		for (int i = 1; i< material.name().length();i++) {
			if (name.charAt(i-1) == ' ') itemName += name.toUpperCase().charAt(i);

			else itemName += name.charAt(i);
		}		
		
		setItemName(Utils.chat("&7&lCompressed " + itemName));
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.setDisplayName(getItemName());		
		
		
		ArrayList<String> lore = createLore(meta);
		meta.setLore(lore);
		item.setItemMeta(meta);
	
		
		return item;
		
	}
	
	@Override
	public void setItemFlags(ItemMeta meta) {
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	}
	
	private ArrayList<String> createLore(ItemMeta meta) {
		ArrayList<String> lore = new ArrayList<String>();	
		lore.add(Utils.chat("&a&l&oUnCommon Item"));
		
		return lore;
	}

}