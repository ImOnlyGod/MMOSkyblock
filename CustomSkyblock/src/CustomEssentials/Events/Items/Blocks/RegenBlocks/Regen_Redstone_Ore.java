package CustomEssentials.Events.Items.Blocks.RegenBlocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;

public class Regen_Redstone_Ore extends ItemsCore{
	
	public ItemStack createItem(int amount) {
		//Create the item
		ItemStack item = new ItemStack(Material.REDSTONE_ORE,amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setCustomModelData(8007);
		
		item.setItemMeta(meta);
		return item;
		
	}
	
}