package CustomEssentials.Events.Items.Crafting;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomShapelessRecipe {
	
	private ItemStack[][] items = new ItemStack[4][4];
	
	public void setGrid(Inventory inv) {
		for (ItemStack item: inv) {
			if (item != null) {
				if (item.getType() != Material.BLACK_STAINED_GLASS_PANE) {
					System.out.println(item.getType() + " " +  item.getAmount());
				}
				
			}
			
		}
	}
	
	
	
	
}
