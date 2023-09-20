package CustomEssentials.Events.Items.Generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import CustomEssentials.Events.Items.ItemsCore;
import CustomEssentials.Utils.Utils;

public class IronGenerator extends ItemsCore{
	
//INCOMPLETE - MAKING GUI FIRST
public ItemStack createItem(int amount) {
		
		//Create the item -
		ItemStack item = new ItemStack(Material.IRON_BLOCK,amount);
		ItemMeta meta = item.getItemMeta();
		setItemName(Utils.chat("&fIron Generator &8[&Level: &71]"));
		meta.setDisplayName(getItemName());	
		
		
		return item;
		
	}
	

}
