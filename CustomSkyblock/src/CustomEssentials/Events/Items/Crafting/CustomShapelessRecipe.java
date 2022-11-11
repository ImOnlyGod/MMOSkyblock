package CustomEssentials.Events.Items.Crafting;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomShapelessRecipe {
	
	//USE MATRIX INSTEAD!
	private ItemStack[][] items = new ItemStack[4][4];
	
	public void setGrid(Inventory inv) {
		this.items[0][0] = inv.getItem(10);
		this.items[0][1] = inv.getItem(11);
		this.items[0][2] = inv.getItem(12);
		this.items[0][3] = inv.getItem(13);
		this.items[1][0] = inv.getItem(19);
		this.items[0][1] = inv.getItem(20);
		this.items[0][2] = inv.getItem(21);
		this.items[0][3] = inv.getItem(22);
		this.items[2][0] = inv.getItem(28);
		this.items[0][1] = inv.getItem(29);
		this.items[0][2] = inv.getItem(30);
		this.items[0][3] = inv.getItem(31);
		this.items[3][0] = inv.getItem(37);
		this.items[0][1] = inv.getItem(38);
		this.items[0][2] = inv.getItem(39);
		this.items[0][3] = inv.getItem(40);
		
		inv.setItem(24, new CustomShapelessItemMap().woodenPlanks(items));
	}
	
	
	
	
}
