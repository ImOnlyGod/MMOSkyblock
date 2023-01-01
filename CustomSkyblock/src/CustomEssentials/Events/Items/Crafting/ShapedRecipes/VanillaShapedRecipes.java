package CustomEssentials.Events.Items.Crafting.ShapedRecipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VanillaShapedRecipes {
	
	private HashMap<ItemStack[][],ItemStack[][]> recipeOutput = new HashMap<ItemStack[][],ItemStack[][]>();
	
	public VanillaShapedRecipes() {
		addDoubleItemRecipes();
		addTripleItemRecipes();
		addQuadItemRecipes();
		addStairsItemRecipes();
		addMiscItemsRecipes();
		addFillItemsRecipes();
	}
	
	
	public void addAllDoubleInputHorizontalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAll5InputLeadItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=2;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllDoubleInputVerticalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllDoubleInputDiagonalItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=1;i<4;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTripleInputSlabItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3, ItemStack outputItem) {
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAll8InputRailItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTripleInputVerticalItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<4;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllQuadInputCubeItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllQuadInputCutterItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=1;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllSixInputStairsItem(ItemStack inputItem1, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
		for (int i=2;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAllTInputLecturnItem(ItemStack inputItem1,ItemStack inputItem2, ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	
	public void addAllInputGrindStoneItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll8InputRoundItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll8InputRound2Item(ItemStack inputItem1,ItemStack inputItem2,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll5InputBoatItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll5InputPlusItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack outputItem) {

		for (int i=1;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll7InputLadderItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll3InputBowlItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll5InputRodItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}	
		
		for (int i=2;i<4;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i-2][j+2] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
		
	}
	
	public void addAll6InputsItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll6InputsDoorItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	
	
	public void addAll7InputUItem(ItemStack inputItem1,ItemStack outputItem) {
		
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}
	}
	
	public void addAll7InputsItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll7InputCampItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack outputItem) {

		for (int i=1;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i-1][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll7InputScaffoldingItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll7InputStandItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll6InputBedItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack outputItem) {

		for (int i=0;i<3;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				
				
				
				
				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	
	
	public void addAll9InputSingleItem(ItemStack inputItem1,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());

				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	public void addAll9InputItem(ItemStack inputItem1,ItemStack inputItem2,ItemStack inputItem3,ItemStack inputItem4,ItemStack inputItem5,ItemStack inputItem6,ItemStack inputItem7,ItemStack inputItem8,ItemStack inputItem9,ItemStack outputItem) {

		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				ItemStack[][] inputItems = new ItemStack[4][4];
				ItemStack[][] resultItems = new ItemStack[2][2];
				inputItems[i][j] = new ItemStack(inputItem1.getType(),inputItem1.getAmount());
				inputItems[i+1][j] = new ItemStack(inputItem2.getType(),inputItem2.getAmount());
				inputItems[i+2][j] = new ItemStack(inputItem3.getType(),inputItem3.getAmount());
				inputItems[i][j+1] = new ItemStack(inputItem4.getType(),inputItem4.getAmount());
				inputItems[i+1][j+1] = new ItemStack(inputItem5.getType(),inputItem5.getAmount());
				inputItems[i+2][j+1] = new ItemStack(inputItem6.getType(),inputItem6.getAmount());
				inputItems[i][j+2] = new ItemStack(inputItem7.getType(),inputItem7.getAmount());
				inputItems[i+1][j+2] = new ItemStack(inputItem8.getType(),inputItem8.getAmount());
				inputItems[i+2][j+2] = new ItemStack(inputItem9.getType(),inputItem9.getAmount());				

				resultItems[0][0] = new ItemStack(outputItem.getType(),outputItem.getAmount());
				resultItems[0][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][0] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				resultItems[1][1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				recipeOutput.put(inputItems, resultItems);
			}
		}		
	}
	
	
	private void addDoubleItemRecipes() {
		addAllDoubleInputHorizontalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.BIRCH_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.SPRUCE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.DARK_OAK_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.JUNGLE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.ACACIA_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.CRIMSON_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.WARPED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE), new ItemStack(Material.STONE_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT), new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.LIGHT_WEIGHTED_PRESSURE_PLATE));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.POLISHED_BLACKSTONE_PRESSURE_PLATE));
		
		addAllDoubleInputHorizontalItem(new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIGHT_GRAY_WOOL), new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GRAY_WOOL), new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BROWN_WOOL), new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.RED_WOOL), new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIME_WOOL), new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.CYAN_WOOL), new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.LIGHT_BLUE_WOOL), new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.BLUE_WOOL), new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.PURPLE_WOOL), new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.MAGENTA_WOOL), new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.PINK_WOOL), new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_CARPET,3));
		addAllDoubleInputHorizontalItem(new ItemStack(Material.MOSS_BLOCK), new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.MOSS_CARPET,3));
		
		addAllDoubleInputVerticalItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.STICK,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.STICK,4));
		
		addAllDoubleInputVerticalItem(new ItemStack(Material.COAL),new ItemStack(Material.STICK), new ItemStack(Material.TORCH,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.REDSTONE),new ItemStack(Material.STICK), new ItemStack(Material.REDSTONE_TORCH,1));
		addAllDoubleInputVerticalItem(new ItemStack(Material.BLAZE_ROD),new ItemStack(Material.POPPED_CHORUS_FRUIT), new ItemStack(Material.END_ROD,4));
		addAllDoubleInputVerticalItem(new ItemStack(Material.STICK),new ItemStack(Material.COBBLESTONE), new ItemStack(Material.LEVER));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SANDSTONE_SLAB),new ItemStack(Material.SANDSTONE_SLAB), new ItemStack(Material.CHISELED_SANDSTONE));
		addAllDoubleInputVerticalItem(new ItemStack(Material.RED_SANDSTONE_SLAB),new ItemStack(Material.RED_SANDSTONE_SLAB), new ItemStack(Material.CHISELED_RED_SANDSTONE));
		addAllDoubleInputVerticalItem(new ItemStack(Material.PURPUR_SLAB),new ItemStack(Material.PURPUR_SLAB), new ItemStack(Material.PURPUR_PILLAR));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CARVED_PUMPKIN),new ItemStack(Material.TORCH), new ItemStack(Material.JACK_O_LANTERN));
		addAllDoubleInputVerticalItem(new ItemStack(Material.QUARTZ_SLAB),new ItemStack(Material.QUARTZ_SLAB), new ItemStack(Material.CHISELED_QUARTZ_BLOCK));
		addAllDoubleInputVerticalItem(new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_PILLAR,2));
		addAllDoubleInputVerticalItem(new ItemStack(Material.NETHER_BRICK_SLAB),new ItemStack(Material.NETHER_BRICK_SLAB), new ItemStack(Material.CHISELED_NETHER_BRICKS));
		addAllDoubleInputVerticalItem(new ItemStack(Material.POLISHED_BLACKSTONE_SLAB),new ItemStack(Material.POLISHED_BLACKSTONE_SLAB), new ItemStack(Material.CHISELED_POLISHED_BLACKSTONE));
		addAllDoubleInputVerticalItem(new ItemStack(Material.SLIME_BALL),new ItemStack(Material.PISTON), new ItemStack(Material.STICKY_PISTON));
		addAllDoubleInputVerticalItem(new ItemStack(Material.FURNACE),new ItemStack(Material.MINECART), new ItemStack(Material.FURNACE_MINECART));
		addAllDoubleInputVerticalItem(new ItemStack(Material.CHEST),new ItemStack(Material.MINECART), new ItemStack(Material.CHEST_MINECART));
		addAllDoubleInputVerticalItem(new ItemStack(Material.HOPPER),new ItemStack(Material.MINECART), new ItemStack(Material.HOPPER_MINECART));
		addAllDoubleInputVerticalItem(new ItemStack(Material.TNT),new ItemStack(Material.MINECART), new ItemStack(Material.TNT_MINECART));
		
		 addAllDoubleInputDiagonalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.SHEARS));
		 addAllDoubleInputDiagonalItem(new ItemStack(Material.FISHING_ROD),new ItemStack(Material.CARROT),new ItemStack(Material.CARROT_ON_A_STICK));
		 addAllDoubleInputDiagonalItem(new ItemStack(Material.FISHING_ROD),new ItemStack(Material.WARPED_FUNGUS),new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK));
		
	}
	
	private void addTripleItemRecipes() {
		
		addAllTripleInputSlabItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.SMOOTH_STONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE),new ItemStack(Material.CUT_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE),new ItemStack(Material.CUT_RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICK_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILE_SLAB,6));
		addAllTripleInputSlabItem(new ItemStack(Material.WHEAT),new ItemStack(Material.WHEAT),new ItemStack(Material.WHEAT),new ItemStack(Material.BREAD));
		addAllTripleInputSlabItem(new ItemStack(Material.WHEAT),new ItemStack(Material.COCOA_BEANS),new ItemStack(Material.WHEAT),new ItemStack(Material.COOKIE,8));
		addAllTripleInputSlabItem(new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.PAPER,3));
				
		
		addAllTripleInputVerticalItem(new ItemStack(Material.SHULKER_SHELL),new ItemStack(Material.CHEST),new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_BOX));
		addAllTripleInputVerticalItem(new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.COPPER_INGOT),new ItemStack(Material.COPPER_INGOT), new ItemStack(Material.SPYGLASS));
		addAllTripleInputVerticalItem(new ItemStack(Material.FLINT),new ItemStack(Material.STICK),new ItemStack(Material.FEATHER), new ItemStack(Material.ARROW,4));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.TRIPWIRE_HOOK,2));
		addAllTripleInputVerticalItem(new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.COAL),new ItemStack(Material.GUNPOWDER), new ItemStack(Material.FIRE_CHARGE,3));
		addAllTripleInputVerticalItem(new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_NUGGET), new ItemStack(Material.CHAIN));
		addAllTripleInputVerticalItem(new ItemStack(Material.COAL),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND), new ItemStack(Material.SOUL_TORCH,4));
		addAllTripleInputVerticalItem(new ItemStack(Material.COAL),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL), new ItemStack(Material.SOUL_TORCH,4));
		addAllTripleInputVerticalItem(new ItemStack(Material.COPPER_INGOT),new ItemStack(Material.COPPER_INGOT),new ItemStack(Material.COPPER_INGOT), new ItemStack(Material.LIGHTNING_ROD));
		
	}
	
	private void addQuadItemRecipes() {
		addAllQuadInputCubeItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		addAllQuadInputCubeItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.CRAFTING_TABLE));
		
		addAllQuadInputCubeItem(new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.BIRCH_LOG), new ItemStack(Material.BIRCH_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SPRUCE_LOG), new ItemStack(Material.SPRUCE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.JUNGLE_LOG), new ItemStack(Material.JUNGLE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.ACACIA_LOG), new ItemStack(Material.ACACIA_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.CRIMSON_STEM), new ItemStack(Material.CRIMSON_HYPHAE,3));
		addAllQuadInputCubeItem(new ItemStack(Material.WARPED_STEM),new ItemStack(Material.WARPED_STEM), new ItemStack(Material.WARPED_HYPHAE,3));
		
		addAllQuadInputCubeItem(new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.SNOWBALL),new ItemStack(Material.SNOWBALL),new ItemStack(Material.SNOW_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.CLAY_BALL),new ItemStack(Material.CLAY_BALL),new ItemStack(Material.CLAY));
		addAllQuadInputCubeItem(new ItemStack(Material.BRICK),new ItemStack(Material.BRICK),new ItemStack(Material.BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SANDSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE,4));	
		addAllQuadInputCubeItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE_BRICKS,4));
		addAllQuadInputCubeItem(new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_BRICKS,4));
		addAllQuadInputCubeItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.POLISHED_GRANITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.POLISHED_ANDESITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.POLISHED_DIORITE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE));
		addAllQuadInputCubeItem(new ItemStack(Material.DIRT),new ItemStack(Material.GRAVEL),new ItemStack(Material.COARSE_DIRT,4));
		addAllQuadInputCubeItem(new ItemStack(Material.RED_SAND),new ItemStack(Material.RED_SAND),new ItemStack(Material.RED_SANDSTONE));
		addAllQuadInputCubeItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.POPPED_CHORUS_FRUIT),new ItemStack(Material.POPPED_CHORUS_FRUIT),new ItemStack(Material.PURPUR_PILLAR,4));
		addAllQuadInputCubeItem(new ItemStack(Material.MAGMA_CREAM),new ItemStack(Material.MAGMA_CREAM),new ItemStack(Material.MAGMA_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.NETHER_WART),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.RED_NETHER_BRICKS));
		addAllQuadInputCubeItem(new ItemStack(Material.HONEY_BOTTLE),new ItemStack(Material.HONEY_BOTTLE),new ItemStack(Material.HONEY_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.HONEYCOMB),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.HONEYCOMB_BLOCK));
		
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_OAK_LOG),new ItemStack(Material.STRIPPED_OAK_LOG),new ItemStack(Material.STRIPPED_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_BIRCH_LOG),new ItemStack(Material.STRIPPED_BIRCH_LOG), new ItemStack(Material.STRIPPED_BIRCH_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_SPRUCE_LOG),new ItemStack(Material.STRIPPED_SPRUCE_LOG), new ItemStack(Material.STRIPPED_SPRUCE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_DARK_OAK_LOG),new ItemStack(Material.STRIPPED_DARK_OAK_LOG), new ItemStack(Material.STRIPPED_DARK_OAK_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_JUNGLE_LOG),new ItemStack(Material.STRIPPED_JUNGLE_LOG), new ItemStack(Material.STRIPPED_JUNGLE_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_ACACIA_LOG),new ItemStack(Material.STRIPPED_ACACIA_LOG), new ItemStack(Material.STRIPPED_ACACIA_WOOD,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_CRIMSON_STEM),new ItemStack(Material.STRIPPED_CRIMSON_STEM), new ItemStack(Material.STRIPPED_CRIMSON_HYPHAE,3));
		addAllQuadInputCubeItem(new ItemStack(Material.STRIPPED_WARPED_STEM),new ItemStack(Material.STRIPPED_WARPED_STEM), new ItemStack(Material.STRIPPED_WARPED_HYPHAE,3));
		addAllQuadInputCubeItem(new ItemStack(Material.BASALT),new ItemStack(Material.BASALT), new ItemStack(Material.POLISHED_BASALT,4));
		addAllQuadInputCubeItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE), new ItemStack(Material.POLISHED_BLACKSTONE,4));
		addAllQuadInputCubeItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS,4));
		addAllQuadInputCubeItem(new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.AMETHYST_SHARD), new ItemStack(Material.AMETHYST_BLOCK));
		addAllQuadInputCubeItem(new ItemStack(Material.COPPER_BLOCK),new ItemStack(Material.COPPER_BLOCK), new ItemStack(Material.CUT_COPPER,4));
		addAllQuadInputCubeItem(new ItemStack(Material.POINTED_DRIPSTONE),new ItemStack(Material.POINTED_DRIPSTONE), new ItemStack(Material.DRIPSTONE_BLOCK,4));
		addAllQuadInputCubeItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_TRAPDOOR));
		addAllQuadInputCubeItem(new ItemStack(Material.RABBIT_HIDE),new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.LEATHER));
		addAllQuadInputCubeItem(new ItemStack(Material.STRING),new ItemStack(Material.STRING), new ItemStack(Material.WHITE_WOOL));
	}
	
	private void addStairsItemRecipes() {
		addAllSixInputStairsItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_STAIRS,4));
		
		addAllSixInputStairsItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.STONE),new ItemStack(Material.STONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.BRICKS),new ItemStack(Material.BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.QUARTZ_BLOCK),new ItemStack(Material.QUARTZ_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.SMOOTH_QUARTZ),new ItemStack(Material.SMOOTH_QUARTZ_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_ANDESITE),new ItemStack(Material.POLISHED_ANDESITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_DIORITE),new ItemStack(Material.POLISHED_DIORITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_GRANITE),new ItemStack(Material.POLISHED_GRANITE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.SMOOTH_SANDSTONE),new ItemStack(Material.SMOOTH_SANDSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.SMOOTH_RED_SANDSTONE),new ItemStack(Material.SMOOTH_RED_SANDSTONE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.PRISMARINE_BRICKS),new ItemStack(Material.PRISMARINE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.DARK_PRISMARINE),new ItemStack(Material.DARK_PRISMARINE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.PURPUR_BLOCK),new ItemStack(Material.PURPUR_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.CUT_COPPER),new ItemStack(Material.CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.EXPOSED_CUT_COPPER),new ItemStack(Material.EXPOSED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WEATHERED_CUT_COPPER),new ItemStack(Material.WEATHERED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.OXIDIZED_CUT_COPPER),new ItemStack(Material.OXIDIZED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WAXED_CUT_COPPER),new ItemStack(Material.WAXED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER),new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER),new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICK_STAIRS,4));
		addAllSixInputStairsItem(new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILE_STAIRS,4));
	}
	
	public void addMiscItemsRecipes() {
		
		addAll3InputBowlItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BOWL,4));
		addAll3InputBowlItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS_BOTTLE,3));
		addAll3InputBowlItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.BUCKET));
		
		addAllQuadInputCutterItem(new ItemStack(Material.STONE),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STONECUTTER));
		addAllQuadInputCutterItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.BLAZE_ROD),new ItemStack(Material.BREWING_STAND));
		
		addAll5InputLeadItem(new ItemStack(Material.STRING),new ItemStack(Material.SLIME_BALL),new ItemStack(Material.LEAD,2));
		
		addAllTInputLecturnItem(new ItemStack(Material.OAK_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		addAllTInputLecturnItem(new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.BOOKSHELF),new ItemStack(Material.LECTERN));
		
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		addAllInputGrindStoneItem(new ItemStack(Material.STICK),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.GRINDSTONE));
		
		addAll5InputBoatItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_BOAT));
		addAll5InputBoatItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.MINECART));
		
		addAll5InputRodItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STRING),new ItemStack(Material.STRING),new ItemStack(Material.FISHING_ROD));
		
		addAll5InputPlusItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.COMPASS));
		addAll5InputPlusItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.CLOCK));
		addAll5InputPlusItem(new ItemStack(Material.CARROT),new ItemStack(Material.COOKED_RABBIT),new ItemStack(Material.BAKED_POTATO),new ItemStack(Material.BOWL),new ItemStack(Material.RED_MUSHROOM),new ItemStack(Material.RABBIT_STEW));
		addAll5InputPlusItem(new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.FURNACE),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.FURNACE),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.WARPED_STEM),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.FURNACE),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.SMOKER));
		addAll5InputPlusItem(new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.GLASS),new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.TINTED_GLASS,2));
		addAll5InputPlusItem(new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.ARROW),new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.SPECTRAL_ARROW,8));
		addAll5InputPlusItem(new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.GLOWSTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE_LAMP));
			
		addAll6InputsItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_FENCE,3));
		addAll6InputsItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_FENCE,3));
		
		addAll6InputsItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_TRAPDOOR,2));
		addAll6InputsItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_TRAPDOOR,2));
	
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.WHITE_BED));
		addAll6InputBedItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WHITE_BED));
		
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.ORANGE_BED));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.ORANGE_BED));
		
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.MAGENTA_BED));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.MAGENTA_BED));
		
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.LIGHT_BLUE_BED));
		
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.YELLOW_BED));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.YELLOW_BED));
		
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.LIME_BED));
		addAll6InputBedItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.LIME_BED));
		
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.PINK_BED));
		addAll6InputBedItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.PINK_BED));
		
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.GRAY_BED));
		
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.LIGHT_GRAY_BED));
		
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CYAN_BED));
		addAll6InputBedItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.CYAN_BED));
		
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.PURPLE_BED));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.PURPLE_BED));
		
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BLUE_BED));
		addAll6InputBedItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BLUE_BED));
		
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BROWN_BED));
		addAll6InputBedItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BROWN_BED));
		
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.GREEN_BED));
		addAll6InputBedItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.GREEN_BED));
		
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.RED_BED));
		addAll6InputBedItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.RED_BED));
		
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BLACK_BED));
		addAll6InputBedItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BLACK_BED));
		
		
		addAll6InputBedItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS_PANE));
		addAll6InputBedItem(new ItemStack(Material.WHITE_STAINED_GLASS),new ItemStack(Material.WHITE_STAINED_GLASS),new ItemStack(Material.WHITE_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.ORANGE_STAINED_GLASS),new ItemStack(Material.ORANGE_STAINED_GLASS),new ItemStack(Material.ORANGE_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.RED_STAINED_GLASS),new ItemStack(Material.RED_STAINED_GLASS),new ItemStack(Material.RED_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.PINK_STAINED_GLASS),new ItemStack(Material.PINK_STAINED_GLASS),new ItemStack(Material.PINK_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.YELLOW_STAINED_GLASS),new ItemStack(Material.YELLOW_STAINED_GLASS),new ItemStack(Material.YELLOW_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.LIME_STAINED_GLASS),new ItemStack(Material.LIME_STAINED_GLASS),new ItemStack(Material.LIME_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.GREEN_STAINED_GLASS),new ItemStack(Material.GREEN_STAINED_GLASS),new ItemStack(Material.GREEN_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS),new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS),new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.CYAN_STAINED_GLASS),new ItemStack(Material.CYAN_STAINED_GLASS),new ItemStack(Material.CYAN_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.BLUE_STAINED_GLASS),new ItemStack(Material.BLUE_STAINED_GLASS),new ItemStack(Material.BLUE_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.MAGENTA_STAINED_GLASS),new ItemStack(Material.MAGENTA_STAINED_GLASS),new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.PURPLE_STAINED_GLASS),new ItemStack(Material.PURPLE_STAINED_GLASS),new ItemStack(Material.PURPLE_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.BROWN_STAINED_GLASS),new ItemStack(Material.BROWN_STAINED_GLASS),new ItemStack(Material.BROWN_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.GRAY_STAINED_GLASS),new ItemStack(Material.GRAY_STAINED_GLASS),new ItemStack(Material.GRAY_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS),new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS),new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE,16));
		addAll6InputBedItem(new ItemStack(Material.BLACK_STAINED_GLASS),new ItemStack(Material.BLACK_STAINED_GLASS),new ItemStack(Material.BLACK_STAINED_GLASS_PANE,16));
		
		addAll6InputsDoorItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_DOOR,3));
		addAll6InputsDoorItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_DOOR,3));
		
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.PAPER),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.PAPER),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.CARTOGRAPHY_TABLE));
		
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.FLINT),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.FLINT),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.FLETCHING_TABLE));
		
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		addAll6InputsDoorItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.SMITHING_TABLE));
		
		addAll6InputsItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE),new ItemStack(Material.MOSSY_COBBLESTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICKS),new ItemStack(Material.MOSSY_STONE_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE),new ItemStack(Material.ANDESITE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE),new ItemStack(Material.DIORITE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE),new ItemStack(Material.GRANITE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE),new ItemStack(Material.SANDSTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE),new ItemStack(Material.RED_SANDSTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICKS),new ItemStack(Material.BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE),new ItemStack(Material.PRISMARINE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICKS),new ItemStack(Material.RED_NETHER_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICKS),new ItemStack(Material.END_STONE_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE),new ItemStack(Material.POLISHED_BLACKSTONE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS),new ItemStack(Material.POLISHED_BLACKSTONE_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE),new ItemStack(Material.COBBLED_DEEPSLATE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE),new ItemStack(Material.POLISHED_DEEPSLATE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICKS),new ItemStack(Material.DEEPSLATE_BRICK_WALL,6));
		addAll6InputsItem(new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILES),new ItemStack(Material.DEEPSLATE_TILE_WALL,6));
		addAll6InputsItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_BARS,16));
		addAll6InputsItem(new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICK),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICKS),new ItemStack(Material.NETHER_BRICK_FENCE,6));
		
		
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.OAK_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_FENCE_GATE));
		addAll6InputsItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_FENCE_GATE));
		
		addAll6InputsItem(new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.STONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.STONE),new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.STONE),new ItemStack(Material.REPEATER));
		
		
		addAll7InputLadderItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.LADDER,3));
		addAll7InputLadderItem(new ItemStack(Material.LEATHER),new ItemStack(Material.LEATHER),new ItemStack(Material.LEATHER_HORSE_ARMOR));
		addAll7InputLadderItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.RAIL,16));
		
		addAll7InputsItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_SIGN,3));
		addAll7InputsItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_SIGN,3));
		
		addAll7InputsItem(new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.WHITE_BANNER));
		addAll7InputsItem(new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.ORANGE_BANNER));
		addAll7InputsItem(new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.MAGENTA_BANNER));
		addAll7InputsItem(new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.LIGHT_BLUE_BANNER));
		addAll7InputsItem(new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.YELLOW_BANNER));
		addAll7InputsItem(new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.LIME_BANNER));
		addAll7InputsItem(new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.PINK_BANNER));
		addAll7InputsItem(new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.GRAY_BANNER));
		addAll7InputsItem(new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.LIGHT_GRAY_BANNER));
		addAll7InputsItem(new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.CYAN_BANNER));
		addAll7InputsItem(new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.PURPLE_BANNER));
		addAll7InputsItem(new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.BLUE_BANNER));
		addAll7InputsItem(new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.BROWN_BANNER));
		addAll7InputsItem(new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.GREEN_BANNER));
		addAll7InputsItem(new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_BANNER));
		addAll7InputsItem(new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.BLACK_BANNER));
		
		addAll7InputUItem(new ItemStack(Material.OAK_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.COMPOSTER));
		addAll7InputUItem(new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.COMPOSTER));
		
		addAll7InputUItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.CAULDRON));
		
		addAll7InputCampItem(new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.STONE),new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.QUARTZ),new ItemStack(Material.STONE),new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.STONE),new ItemStack(Material.COMPARATOR));
		addAll7InputCampItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.OBSIDIAN),new ItemStack(Material.BOOK),new ItemStack(Material.OBSIDIAN),new ItemStack(Material.OBSIDIAN),new ItemStack(Material.DIAMOND),new ItemStack(Material.OBSIDIAN),new ItemStack(Material.ENCHANTING_TABLE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.COAL),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.CAMPFIRE));
		
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SAND),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.SOUL_CAMPFIRE));
		
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.OAK_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.STICK),new ItemStack(Material.BIRCH_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SPRUCE_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.STICK),new ItemStack(Material.DARK_OAK_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.STICK),new ItemStack(Material.JUNGLE_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.STICK),new ItemStack(Material.ACACIA_LOG),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.STICK),new ItemStack(Material.CRIMSON_STEM),new ItemStack(Material.SOUL_CAMPFIRE));
		addAll7InputCampItem(new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.SOUL_SOIL),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.STICK),new ItemStack(Material.WARPED_STEM),new ItemStack(Material.SOUL_CAMPFIRE));
		
		addAll7InputStandItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STONE_SLAB),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ARMOR_STAND));
	
		addAll7InputScaffoldingItem(new ItemStack(Material.BAMBOO),new ItemStack(Material.BAMBOO),new ItemStack(Material.BAMBOO),new ItemStack(Material.STRING),new ItemStack(Material.BAMBOO),new ItemStack(Material.BAMBOO),new ItemStack(Material.BAMBOO),new ItemStack(Material.SCAFFOLDING,6));
	}
	
	public void addFillItemsRecipes() {
	
		addAll8InputRailItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STONE_PRESSURE_PLATE),new ItemStack(Material.REDSTONE),new ItemStack(Material.DETECTOR_RAIL));
		addAll8InputRailItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.REDSTONE),new ItemStack(Material.POWERED_RAIL));
		
		addAll8InputRoundItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CHEST));
		addAll8InputRoundItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.CHEST));
		
		addAll8InputRoundItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.FURNACE));
		addAll8InputRoundItem(new ItemStack(Material.BLACKSTONE),new ItemStack(Material.BLACKSTONE),new ItemStack(Material.FURNACE));
		addAll8InputRoundItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.DROPPER)); 
		addAll8InputRoundItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.BARREL)); 
		addAll8InputRoundItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.BARREL)); 
		
		addAll9InputSingleItem(new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_INGOT));
		addAll9InputSingleItem(new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.COAL),new ItemStack(Material.COAL_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.COPPER_INGOT),new ItemStack(Material.COPPER_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.LAPIS_LAZULI),new ItemStack(Material.LAPIS_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.DIAMOND),new ItemStack(Material.DIAMOND_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.EMERALD),new ItemStack(Material.EMERALD_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.NETHERITE_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.WHEAT),new ItemStack(Material.HAY_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_BRICKS));
		addAll9InputSingleItem(new ItemStack(Material.SLIME_BALL),new ItemStack(Material.SLIME_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.NETHER_WART),new ItemStack(Material.NETHER_WART_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.BONE_MEAL),new ItemStack(Material.BONE_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.DRIED_KELP),new ItemStack(Material.DRIED_KELP_BLOCK));
		addAll9InputSingleItem(new ItemStack(Material.ICE),new ItemStack(Material.PACKED_ICE));
		addAll9InputSingleItem(new ItemStack(Material.PACKED_ICE),new ItemStack(Material.BLUE_ICE));
		addAll9InputSingleItem(new ItemStack(Material.MELON_SLICE),new ItemStack(Material.MELON));
		
		addAll9InputItem(new ItemStack(Material.GUNPOWDER),new ItemStack(Material.SAND),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.SAND),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.SAND),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.SAND),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.TNT));
		addAll9InputItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BOOKSHELF));
		addAll9InputItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.BOOK),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BOOKSHELF));
		
		addAll9InputItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		addAll9InputItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.REDSTONE),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.NOTE_BLOCK));
		
		addAll9InputItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.BOW),new ItemStack(Material.REDSTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.DISPENSER));
		
		addAll9InputItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		addAll9InputItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.REDSTONE),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.PISTON));
		
		
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.WHITE_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.WHITE_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.ORANGE_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.MAGENTA_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIGHT_BLUE_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.YELLOW_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIME_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIME_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.PINK_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.PINK_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.GRAY_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.GRAY_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.LIGHT_GRAY_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.CYAN_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.CYAN_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.PURPLE_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BLUE_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BLUE_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BROWN_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BROWN_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.GREEN_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.GREEN_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.RED_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.RED_TERRACOTTA));
		addAll9InputItem(new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BLACK_DYE),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.TERRACOTTA),new ItemStack(Material.BLACK_TERRACOTTA));
		
		addAll9InputItem(new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.BLACK_DYE),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.DARK_PRISMARINE));
		addAll9InputItem(new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_CRYSTALS),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_CRYSTALS),new ItemStack(Material.PRISMARINE_CRYSTALS),new ItemStack(Material.PRISMARINE_CRYSTALS),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.PRISMARINE_CRYSTALS),new ItemStack(Material.PRISMARINE_SHARD),new ItemStack(Material.SEA_LANTERN));
		addAll9InputItem(new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.HEART_OF_THE_SEA),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.NAUTILUS_SHELL),new ItemStack(Material.CONDUIT));
		addAll9InputItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),new ItemStack(Material.REDSTONE_TORCH),new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.ACTIVATOR_RAIL,6));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.OAK_SLAB),new ItemStack(Material.OAK_SLAB),new ItemStack(Material.OAK_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.BIRCH_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.SPRUCE_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.DARK_OAK_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.JUNGLE_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.ACACIA_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.CRIMSON_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.QUARTZ),new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.WARPED_SLAB),new ItemStack(Material.DAYLIGHT_DETECTOR));
		
		addAll9InputItem(new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE),new ItemStack(Material.QUARTZ),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.COBBLESTONE),new ItemStack(Material.OBSERVER));
		addAll9InputItem(new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.APPLE),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.GOLDEN_APPLE));
		addAll9InputItem(new ItemStack(Material.MILK_BUCKET),new ItemStack(Material.MILK_BUCKET),new ItemStack(Material.MILK_BUCKET),new ItemStack(Material.SUGAR),new ItemStack(Material.EGG),new ItemStack(Material.SUGAR),new ItemStack(Material.WHEAT),new ItemStack(Material.WHEAT),new ItemStack(Material.WHEAT),new ItemStack(Material.CAKE));
		addAll9InputItem(new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.CARROT),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLDEN_CARROT));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.WHITE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ORANGE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.MAGENTA_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.LIGHT_BLUE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.YELLOW_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.LIME_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PINK_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.GRAY_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.LIGHT_GRAY_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.CYAN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PURPLE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BROWN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.GREEN_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.RED_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.BLACK_WOOL),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.PAINTING));
		
		addAll9InputItem(new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.COMPASS),new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.PAPER),new ItemStack(Material.MAP));
		addAll9InputItem(new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.LEATHER),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.STICK),new ItemStack(Material.ITEM_FRAME));
		
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.WHITE_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.WHITE_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.ORANGE_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.MAGENTA_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.YELLOW_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIME_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIME_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.PINK_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.PINK_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GRAY_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.CYAN_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.CYAN_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.PURPLE_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BLUE_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BLUE_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BROWN_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BROWN_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GREEN_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.RED_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.RED_STAINED_GLASS));
		addAll9InputItem(new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BLACK_DYE),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.GLASS),new ItemStack(Material.BLACK_STAINED_GLASS));
		
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.WHITE_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.WHITE_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.ORANGE_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.ORANGE_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.MAGENTA_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.MAGENTA_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.YELLOW_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.YELLOW_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.LIME_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.LIME_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.PINK_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.PINK_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.GRAY_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAY_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.LIGHT_GRAY_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.CYAN_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.CYAN_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.PURPLE_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.PURPLE_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.BLUE_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.BLUE_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.BROWN_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.BROWN_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.GREEN_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GREEN_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.RED_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.RED_CONCRETE_POWDER));
		addAll9InputItem(new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.SAND),new ItemStack(Material.BLACK_DYE),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.BLACK_CONCRETE_POWDER));
		
		addAll9InputItem(new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.FURNACE),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.SMOOTH_STONE),new ItemStack(Material.BLAST_FURNACE));
		addAll9InputItem(new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.TORCH),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.LANTERN));
		addAll9InputItem(new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.SOUL_TORCH),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.GRAVEL),new ItemStack(Material.SOUL_LANTERN));
		
		addAll9InputItem(new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.OAK_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.BIRCH_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.SPRUCE_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.DARK_OAK_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.JUNGLE_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.ACACIA_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.CRIMSON_PLANKS),new ItemStack(Material.BEEHIVE));
		addAll9InputItem(new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.HONEYCOMB),new ItemStack(Material.WARPED_PLANKS),new ItemStack(Material.BEEHIVE));
		
		addAll9InputItem(new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.GLOWSTONE),new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.GLOWSTONE),new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.GLOWSTONE),new ItemStack(Material.CRYING_OBSIDIAN),new ItemStack(Material.RESPAWN_ANCHOR));
		addAll9InputItem(new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.CHISELED_STONE_BRICKS),new ItemStack(Material.LODESTONE));
		addAll9InputItem(new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.MELON_SLICE),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GOLD_NUGGET),new ItemStack(Material.GLISTERING_MELON_SLICE));
		
	}
	

	public HashMap<ItemStack[][],ItemStack[][]> getRecipeOutput() {
		return recipeOutput;
	}


	public void setRecipeOutput(HashMap<ItemStack[][],ItemStack[][]> recipeOutput) {
		this.recipeOutput = recipeOutput;
	}




}
