package CustomEssentials.Events.Items.Crafting;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomShapelessItemMap {
	
	public ItemStack woodenPlanks(ItemStack[][] items) {
		int nullCounter = 0;
		int woodCounter = 0;
		int amount = 1;
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				System.out.println(j);
				if (items[i][j] == null) {
					
				}
				else if (items[i][j].getType() == Material.OAK_LOG) {
					woodCounter++;
				}
			}
		}
		
		if (woodCounter == 1) {
			return new ItemStack(Material.OAK_PLANKS,amount);
		}
		
		
		return null;
	}
	
}
