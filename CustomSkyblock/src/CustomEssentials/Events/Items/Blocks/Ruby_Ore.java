package CustomEssentials.Events.Items.Blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import CustomEssentials.Events.Items.ItemsCore;

public class Ruby_Ore extends ItemsCore{
	
	
	public ItemStack createItem(int amount) {
		//Create the item
		ItemStack item = new ItemStack(Material.EMERALD_ORE,amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setCustomModelData(8000);
		
		item.setItemMeta(meta);
		return item;
		
	}
	
}