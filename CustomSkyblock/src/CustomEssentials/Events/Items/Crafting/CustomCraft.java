package CustomEssentials.Events.Items.Crafting;

import java.util.ArrayList;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Events.Items.Crafting.ShapelessRecipes.VanillaShapelessRecipes;

public class CustomCraft {
	
	//USE MATRIX INSTEAD!
	private ItemStack[][] inputGrid = new ItemStack[4][4];
	private Inventory crafttingGUI;
	private ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
	private VanillaShapelessRecipes vanillaRecipes1 = new VanillaShapelessRecipes();
	private ItemStack[][] matchingRecipe;
	private ItemStack[][] outputRecipe;
	private Player p;
	
	public CustomCraft(Player p, Inventory inv) {
		this.p = p;
		setGrid(inv);
		checkItemSlots();
		getRecipeResult();
		
	}
	
	public void resetCraftingInventory(Inventory inv) {
		setGrid(inv);
		checkItemSlots();
		getRecipeResult();
	}
	
	public void setGrid(Inventory inv) {
		this.inputGrid[0][0] = inv.getItem(10); this.inputGrid[0][1] = inv.getItem(11); this.inputGrid[0][2] = inv.getItem(12); this.inputGrid[0][3] = inv.getItem(13);
		this.inputGrid[1][0] = inv.getItem(19); this.inputGrid[1][1] = inv.getItem(20); this.inputGrid[1][2] = inv.getItem(21); this.inputGrid[1][3] = inv.getItem(22);
		this.inputGrid[2][0] = inv.getItem(28); this.inputGrid[2][1] = inv.getItem(29); this.inputGrid[2][2] = inv.getItem(30); this.inputGrid[2][3] = inv.getItem(31);
		this.inputGrid[3][0] = inv.getItem(37); this.inputGrid[3][1] = inv.getItem(38); this.inputGrid[3][2] = inv.getItem(39); this.inputGrid[3][3] = inv.getItem(40);
		
		this.setCrafttingGUI(inv);
	}
	
	public void checkItemSlots() {
		for (int i=0;i<inputGrid.length;i++) {
			for (int j=0;j<inputGrid.length;j++) {
				
				if (this.inputGrid[i][j] == null) continue;
				if (this.itemList.contains(this.inputGrid[i][j])) continue;
				
				this.itemList.add(this.inputGrid[i][j]);
			}
		}
		
	}	
	
	public ItemStack[][] getVanillaMatchingGrid() {
		
		for (ItemStack[][] inven: this.vanillaRecipes1.getRecipeOutput().keySet()) {
			
			Boolean matching = true;
			for (int i=0;i<inven.length;i++) {
				for (int j=0;j<inven.length;j++) {
					
					if ((inven[i][j] == null) && (this.inputGrid[i][j] == null)) {
						continue;
					}
					else if ((inven[i][j] == null) && !(this.inputGrid[i][j] == null)) {
						matching = false;
						break;
					}
					else if (!(inven[i][j] == null) && (this.inputGrid[i][j] == null)) {
						matching = false;
						break;
					}
					
					
					if (!(inven[i][j].isSimilar(this.inputGrid[i][j])) || !(inven[i][j].getAmount() <= this.inputGrid[i][j].getAmount())) {
						matching = false;
						break;
					}	
				}	
			}
			
			//clean up code
			if (matching) {
				this.matchingRecipe = inven;
				this.setOutputRecipe(this.vanillaRecipes1.getRecipeOutput().get(inven));
				return this.vanillaRecipes1.getRecipeOutput().get(inven);
			}
		}
		return null;		
	}
	
	public Boolean isEnoughMaterials() {
		
		for (int i=0;i<this.inputGrid.length;i++) {
			for (int j=0;j<this.inputGrid.length;j++) {
				if ((this.matchingRecipe[i][j] == null) && (this.inputGrid[i][j] == null)) {
					continue;
				}
				else if ((this.matchingRecipe[i][j] == null) && !(this.inputGrid[i][j] == null)) {
					return false;
				}
				else if (!(this.matchingRecipe[i][j] == null) && (this.inputGrid[i][j] == null)) {
					return false;
				}
				
				if ((this.inputGrid[i][j].getAmount() - this.matchingRecipe[i][j].getAmount()) < 0) {
					return false;
				}
			}
		}
		
		
		
		return true;
	}
	
	public void reduceMaterials() {
		for (int i=0;i<this.inputGrid.length;i++) {
			for (int j=0;j<this.inputGrid.length;j++) {
				if ((this.matchingRecipe[i][j] == null) && (this.inputGrid[i][j] == null)) continue;

				int newAmount = this.inputGrid[i][j].getAmount() - this.matchingRecipe[i][j].getAmount();
				this.inputGrid[i][j].setAmount(newAmount);				
			
			}
		}
	}
	
	public boolean checkInventorySpace(Inventory playerInven, ItemStack item, int minSpace) {
		
		int stackSize = item.getMaxStackSize();
		int space = 0;
		
		for (int i = 0; i<36; i++) {
			
			ItemStack anItem = playerInven.getItem(i);
			if (anItem == null) return true;
			
			if (anItem.isSimilar(item)) {
				space += (stackSize - anItem.getAmount());
			}
			
			if (space >= minSpace) return true;
			
		}
		
		
		return false;
	}
	
	public void convertMaterials(Inventory playerInven,Inventory craftingInven, int slot, int amount, Boolean isCursor) {
		
		int iteration = 0;
		int itemAmount = this.outputRecipe[0][0].getAmount();
		
		while (iteration < amount) {
			if (!isEnoughMaterials()) return;
			
			if (isCursor && ((p.getItemOnCursor().getAmount() + craftingInven.getItem(slot).getAmount()) < 64) && (p.getItemOnCursor().getType() == Material.AIR || p.getItemOnCursor().isSimilar(this.crafttingGUI.getItem(slot)))) {
				
				int amountAdded = 0;
				if (p.getItemOnCursor().getType() != Material.AIR) {
					amountAdded += p.getItemOnCursor().getAmount();
				}
				
				ItemStack addItem = new ItemStack(this.crafttingGUI.getItem(slot).getType(),this.crafttingGUI.getItem(slot).getAmount()+amountAdded);
				p.setItemOnCursor(addItem);
				reduceMaterials();
				
			}
			
			else if (!isCursor) {
				System.out.println(itemAmount);
				if (!checkInventorySpace(playerInven,craftingInven.getItem(slot),itemAmount)) return;
				playerInven.addItem(new ItemStack(this.crafttingGUI.getItem(slot).getType(),itemAmount));
				reduceMaterials();
			}
			else break;
			
			iteration++;
		}
		
	}
	
	public void processOutputClick(Inventory playerInven, Inventory craftingInven,  int slot,  ClickType click) {
		//CHECK ALL OTHER SLOTS ARE NONE
		if (craftingInven.getItem(slot) == null || craftingInven.getItem(slot).isSimilar(new ItemStack(Material.RED_STAINED_GLASS_PANE))) return;
		
		int freeInvenSpace = getInvenFreeSpace(playerInven, this.crafttingGUI.getItem(slot));
		
		if (freeInvenSpace == 0) return;
		
		if (click.isShiftClick()) {
			convertMaterials(playerInven, craftingInven, slot, Math.min(100,freeInvenSpace),false);	
		}
		else {
			convertMaterials(playerInven, craftingInven, slot, 1,true);
			
		}
		resetCraftingInventory(craftingInven);				
		
	}
	
	public int getInvenFreeSpace(Inventory playerInven, ItemStack item) {

		int space = 0;
		for (ItemStack anItem: playerInven.getContents()) {
			if (anItem == null) space += item.getMaxStackSize();
		}
		
		return space;
		
		
	}
	
	public void resetOutputGui() {
		
		this.crafttingGUI.setItem(24, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		this.crafttingGUI.setItem(25, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		this.crafttingGUI.setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		this.crafttingGUI.setItem(34, new ItemStack(Material.RED_STAINED_GLASS_PANE));	
	}
	
	
	
	public void setOutputGui(ItemStack[][] output) {
		
		this.crafttingGUI.setItem(24, output[0][0]);	
		this.crafttingGUI.setItem(25, output[0][1]);	
		this.crafttingGUI.setItem(33, output[1][0]);	
		this.crafttingGUI.setItem(34, output[1][1]);	
	}
	
	
	public void getRecipeResult() {
		
		if (itemList.size() == 0) {
			this.crafttingGUI.setItem(24, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(25, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(34, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			return;
		}
		
		ItemStack[][] outputGrid = getVanillaMatchingGrid();
		
		if (outputGrid == null) {
			this.crafttingGUI.setItem(24, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(25, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			this.crafttingGUI.setItem(34, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			return;
		}
		
		setOutputGui(outputGrid);
		
		
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

	public ArrayList<ItemStack> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemStack> itemList) {
		this.itemList = itemList;
	}

	public ItemStack[][] getMatchingRecipe() {
		return matchingRecipe;
	}

	public void setMatchingRecipe(ItemStack[][] matchingRecipe) {
		this.matchingRecipe = matchingRecipe;
	}

	public ItemStack[][] getOutputRecipe() {
		return outputRecipe;
	}

	public void setOutputRecipe(ItemStack[][] outputRecipe) {
		this.outputRecipe = outputRecipe;
	}	
	
	
}
