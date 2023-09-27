package CustomEssentials.Events.Items.Blocks.RegenBlocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;

public class Regen_Copper_Ore extends ItemsCore{
	
	public ItemStack createItem(int amount) {
		//Create the item
		ItemStack item = new ItemStack(Material.COPPER_ORE,amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setCustomModelData(8002);
		
		item.setItemMeta(meta);
		return item;
		
	}
	
}