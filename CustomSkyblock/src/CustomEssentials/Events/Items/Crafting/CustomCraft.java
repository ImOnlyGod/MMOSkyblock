package CustomEssentials.Events.Items.Crafting;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomCraft {
	
	//USE MATRIX INSTEAD!
	private ItemStack[][] inputGrid = new ItemStack[4][4];
	private Inventory crafttingGUI;
	
	public CustomCraft(Inventory inv) {
		setGrid(inv);
	}
	
	public void setGrid(Inventory inv) {
		this.inputGrid[0][0] = inv.getItem(10); this.inputGrid[0][1] = inv.getItem(11); this.inputGrid[0][2] = inv.getItem(12); this.inputGrid[0][3] = inv.getItem(13);
		this.inputGrid[1][0] = inv.getItem(19); this.inputGrid[1][1] = inv.getItem(20); this.inputGrid[1][2] = inv.getItem(21); this.inputGrid[1][3] = inv.getItem(22);
		this.inputGrid[2][0] = inv.getItem(28); this.inputGrid[2][1] = inv.getItem(29); this.inputGrid[2][2] = inv.getItem(30); this.inputGrid[2][3] = inv.getItem(31);
		this.inputGrid[3][0] = inv.getItem(37); this.inputGrid[3][1] = inv.getItem(38); this.inputGrid[3][2] = inv.getItem(39); this.inputGrid[3][3] = inv.getItem(40);
		
		this.setCrafttingGUI(inv);
	}

	public Inventory getCrafttingGUI() {
		return crafttingGUI;
	}

	public void setCrafttingGUI(Inventory crafttingGUI) {
		this.crafttingGUI = crafttingGUI;
	}
	
	public ItemStack[][] getItems() {
		return inputGrid;
	}

	public void setItems(ItemStack[][] items) {
		this.inputGrid = items;
	}	
	
	
}
