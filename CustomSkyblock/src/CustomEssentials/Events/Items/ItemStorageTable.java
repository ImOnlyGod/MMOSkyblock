package CustomEssentials.Events.Items;

import java.util.HashMap;

import CustomEssentials.Events.Items.Weapons.BasicSword;
import CustomEssentials.Events.Items.Weapons.HadesBlade;

public class ItemStorageTable {
	
	//Identifies type of item based on it's name
	private HashMap<Integer, ItemsCore> IDtoItemsCore = new HashMap<Integer,ItemsCore>();
	private HashMap<String, ItemsCore> CmdtoItemsCore = new HashMap<String,ItemsCore>();
	
	public ItemStorageTable() {
		putItems();
	}
	
	private void putItems() {
		this.IDtoItemsCore.put(0, new BasicSword());
		this.CmdtoItemsCore.put("basicsword", new BasicSword());
		
		this.IDtoItemsCore.put(1, new HadesBlade());
		this.CmdtoItemsCore.put("hadesblade", new HadesBlade());
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, ItemsCore> getIDtoItemsCore() {
		return (HashMap<Integer, ItemsCore>) this.IDtoItemsCore.clone();
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, ItemsCore> getCmdtoItemsCore() {
		return (HashMap<String, ItemsCore>) this.CmdtoItemsCore.clone();
	}



	
	

}
