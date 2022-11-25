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
		setItemName(Utils.chat("&7&lCompressed " + material.toString().replace('_', ' ')));
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.setDisplayName(getItemName());	
		//meta.setCustomModelData(material.getData().get);		
		
		
		
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