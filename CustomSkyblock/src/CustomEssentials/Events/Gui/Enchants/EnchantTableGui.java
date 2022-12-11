package CustomEssentials.Events.Gui.Enchants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import CustomEssentials.Main;
import CustomEssentials.Events.Items.Enchants.CustomEnchants;
import CustomEssentials.Utils.Utils;

public class EnchantTableGui {
	
	private Player p;
	private Main plugin;
	private Inventory gui;
	private HashMap<Material,ArrayList<Enchantment>> materialToEnchants = new HashMap<Material,ArrayList<Enchantment>>();
	private ArrayList<ItemStack> allowedItems = new ArrayList<ItemStack>();
	private HashMap<Enchantment,ArrayList<String>> EnchantLore = new HashMap<Enchantment,ArrayList<String>>();
	private HashMap<Enchantment,Material> EnchantItem = new HashMap<Enchantment,Material>();
	private HashMap<Material,Enchantment> ItemEnchant = new HashMap<Material,Enchantment>();
	private HashMap<Enchantment,Integer> EnchantXp = new HashMap<Enchantment,Integer>();
	private HashMap<Enchantment,Integer> EnchantMoney = new HashMap<Enchantment,Integer>();
	private HashMap<Enchantment,Integer> EnchantLevelRequirement = new HashMap<Enchantment,Integer>();

	public HashMap<Enchantment, Integer> getEnchantXp() {
		return EnchantXp;
	}

	public void setEnchantXp(HashMap<Enchantment, Integer> enchantXp) {
		EnchantXp = enchantXp;
	}

	public HashMap<Enchantment, Integer> getEnchantMoney() {
		return EnchantMoney;
	}

	public void setEnchantMoney(HashMap<Enchantment, Integer> enchantMoney) {
		EnchantMoney = enchantMoney;
	}

	public HashMap<Enchantment, Integer> getEnchantLevelRequirement() {
		return EnchantLevelRequirement;
	}

	public void setEnchantLevelRequirement(HashMap<Enchantment, Integer> enchantLevelRequirement) {
		EnchantLevelRequirement = enchantLevelRequirement;
	}

	public EnchantTableGui(Player p, Main plugin) {
		this.p = p;
		this.plugin = plugin;
		this.generateAllowedItems();
		this.generateEnchantLore();
		this.generateEnchantRequirements();
		this.generateEnchantItem();
		this.generateMaterialToEnchants();
		this.createInitialGui();
	}
	
	public void generateEnchantRequirements() {
		this.EnchantLevelRequirement.put(CustomEnchants.VACUUM, 0);
		this.EnchantXp.put(CustomEnchants.VACUUM, 1000);
		this.EnchantMoney.put(CustomEnchants.VACUUM, 1000);	
		
		this.EnchantLevelRequirement.put(CustomEnchants.BRUTE, 0);
		this.EnchantXp.put(CustomEnchants.BRUTE, 1000);
		this.EnchantMoney.put(CustomEnchants.BRUTE, 1000);	
		
		this.EnchantLevelRequirement.put(CustomEnchants.EXPERIENCE_EXTRACTOR, 0);
		this.EnchantXp.put(CustomEnchants.EXPERIENCE_EXTRACTOR, 1000);
		this.EnchantMoney.put(CustomEnchants.EXPERIENCE_EXTRACTOR, 1000);
		
		this.EnchantLevelRequirement.put(CustomEnchants.PICKPOCKET, 0);
		this.EnchantXp.put(CustomEnchants.PICKPOCKET, 1000);
		this.EnchantMoney.put(CustomEnchants.PICKPOCKET, 1000);
		
	}
	
	public void generateEnchantItem() {
		this.EnchantItem.put(CustomEnchants.VACUUM, Material.HOPPER);
		this.ItemEnchant.put(Material.HOPPER, CustomEnchants.VACUUM);
		
		this.EnchantItem.put(CustomEnchants.BRUTE, Material.NETHER_STAR);
		this.ItemEnchant.put(Material.NETHER_STAR, CustomEnchants.BRUTE);

		this.EnchantItem.put(CustomEnchants.EXPERIENCE_EXTRACTOR, Material.EXPERIENCE_BOTTLE);
		this.ItemEnchant.put(Material.EXPERIENCE_BOTTLE, CustomEnchants.EXPERIENCE_EXTRACTOR);
		
		this.EnchantItem.put(CustomEnchants.PICKPOCKET, Material.GOLD_NUGGET);
		this.ItemEnchant.put(Material.GOLD_NUGGET, CustomEnchants.PICKPOCKET);
	}
	
	public void generateEnchantLore() {
		//VACUUM LORE
		ArrayList<String> vacuumLore = new ArrayList<String>();
		vacuumLore.add(Utils.chat("&7&oClick here to view levels"));
		
		this.EnchantLore.put(CustomEnchants.VACUUM, vacuumLore);
		this.EnchantLore.put(CustomEnchants.BRUTE, vacuumLore);
		this.EnchantLore.put(CustomEnchants.EXPERIENCE_EXTRACTOR, vacuumLore);
		this.EnchantLore.put(CustomEnchants.PICKPOCKET, vacuumLore);
		
	}
	
	public void generateMaterialToEnchants() {
		ArrayList<Enchantment> swordEnchants = new ArrayList<Enchantment>();
		swordEnchants.add(CustomEnchants.VACUUM);
		swordEnchants.add(CustomEnchants.BRUTE);
		swordEnchants.add(CustomEnchants.EXPERIENCE_EXTRACTOR);
		swordEnchants.add(CustomEnchants.PICKPOCKET);
		
		this.materialToEnchants.put(Material.WOODEN_SWORD, swordEnchants);
		this.materialToEnchants.put(Material.STONE_SWORD, swordEnchants);
		this.materialToEnchants.put(Material.IRON_SWORD, swordEnchants);
		this.materialToEnchants.put(Material.GOLDEN_SWORD, swordEnchants);
		this.materialToEnchants.put(Material.DIAMOND_SWORD, swordEnchants);
		this.materialToEnchants.put(Material.NETHERITE_SWORD, swordEnchants);
		
		ArrayList<Enchantment> pickaxeEnchants = new ArrayList<Enchantment>();
		pickaxeEnchants.add(CustomEnchants.VACUUM);
		
		this.materialToEnchants.put(Material.WOODEN_PICKAXE, pickaxeEnchants);
		this.materialToEnchants.put(Material.STONE_PICKAXE, pickaxeEnchants);
		this.materialToEnchants.put(Material.IRON_PICKAXE, pickaxeEnchants);
		this.materialToEnchants.put(Material.GOLDEN_PICKAXE, pickaxeEnchants);
		this.materialToEnchants.put(Material.DIAMOND_PICKAXE, pickaxeEnchants);
		this.materialToEnchants.put(Material.NETHERITE_PICKAXE, pickaxeEnchants);
		
		ArrayList<Enchantment> axeEnchants = new ArrayList<Enchantment>();
		axeEnchants.add(CustomEnchants.VACUUM);
		axeEnchants.add(CustomEnchants.BRUTE);
		axeEnchants.add(CustomEnchants.EXPERIENCE_EXTRACTOR);
		axeEnchants.add(CustomEnchants.PICKPOCKET);
		
		this.materialToEnchants.put(Material.WOODEN_AXE, axeEnchants);
		this.materialToEnchants.put(Material.STONE_AXE, axeEnchants);
		this.materialToEnchants.put(Material.IRON_AXE, axeEnchants);
		this.materialToEnchants.put(Material.GOLDEN_AXE, axeEnchants);
		this.materialToEnchants.put(Material.DIAMOND_AXE, axeEnchants);
		this.materialToEnchants.put(Material.NETHERITE_AXE, axeEnchants);
		
		
	}
	
	public void generateAllowedItems() {
		
	}
	
	public void enchantLevelsGui(Enchantment enchant) {
		int slot = 12;
		for (int i=0;i<15;i++) {
			if (slot > 34) break;
			
			this.gui.setItem(slot, null);			
			
			if (slot==16 || slot == 25) slot += 5;
			else slot++;
		}
		
		slot = 12;
		int enchantMaxLevel = enchant.getMaxLevel()+1;
		for (int i=1;i<enchantMaxLevel;i++) {
			if (slot > 34) break;
			
			ItemStack enchantItem = new ItemStack(this.EnchantItem.get(enchant),i);
			ItemMeta enchantMeta = enchantItem.getItemMeta();
			String enchName = enchant.getKey().toString().replace("minecraft:", "").substring(1);
			char firstChar = enchant.getKey().toString().replace("minecraft:", "").toUpperCase().charAt(0);
			enchName = firstChar + enchName;
			enchantMeta.setDisplayName(Utils.chat("&a"+enchName.replace("_e", " E")+" "+i));
			
			ArrayList<String> vacuumLore = new ArrayList<String>();
			vacuumLore.add("test");
			
			enchantMeta.setLore(vacuumLore);
			enchantItem.setItemMeta(enchantMeta);
			this.gui.setItem(slot, enchantItem);			
			
			if (slot==16 || slot == 25) slot += 5;
			else slot++;			
		}		
	}
	
	public void openGui() {
		this.p.openInventory(this.gui);
	}
	
	public boolean isValidInput(ItemStack item) {
		if (item == null) return false;
		for (Material allowedMaterials: this.materialToEnchants.keySet()) {
			if (item.getType().equals(allowedMaterials)) return true;
		}
		for (ItemStack allowedItem: this.allowedItems) {
			if (item.getItemMeta().getDisplayName().equalsIgnoreCase(allowedItem.getItemMeta().getDisplayName())) return true;
		}
		return false;
	}
	
	public void generateValidInventory() {
		if (!this.isValidInput(this.gui.getItem(19))) {
			this.createInitialGui();
			return;
		}
		ItemStack item = this.gui.getItem(19);
		ArrayList<Enchantment> enchants = this.materialToEnchants.get(item.getType());
		for (int i=0;i<45;i++) {
			if (this.gui.getItem(i)==null) continue;
			if (this.gui.getItem(i).getType().equals(Material.RED_STAINED_GLASS_PANE)) {
				this.gui.setItem(i, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
			}
		}
		
		//Sword GUI
		generateSwordEnchants(enchants);
	}
	
	public void generateSwordEnchants(ArrayList<Enchantment> enchants) {
		
		for (int i=12;i<35;i++) {
			this.gui.setItem(i, null);
			
			if (i==16 || i == 25) i += 4;
		}		
		
		int slot = 12;
		for (Enchantment ench: enchants) {
			if (slot > 34) break;
			if (this.gui.getItem(19).getItemMeta().hasEnchant(ench)) {
				
			}
			ItemStack enchantItem = new ItemStack(this.EnchantItem.get(ench));
			ItemMeta enchantMeta = enchantItem.getItemMeta();
			
			if (this.gui.getItem(19).getItemMeta().hasEnchant(ench)) {
				enchantMeta.addEnchant(ench, 1, false);
				enchantMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}
			
			
			String enchName = ench.getKey().toString().replace("minecraft:", "").substring(1);
			char firstChar = ench.getKey().toString().replace("minecraft:", "").toUpperCase().charAt(0);
			enchName = firstChar + enchName;
			enchantMeta.setDisplayName(Utils.chat("&7"+enchName.replace("_e", " E")));
			enchantMeta.setLore(this.EnchantLore.get(ench));
			enchantItem.setItemMeta(enchantMeta);
			
			
			
			this.gui.setItem(slot, enchantItem);
			if (slot==16 || slot == 25) slot += 5;
			else slot++;
		}
		
	}
	
	public void createInitialGui() {
		this.gui = Bukkit.createInventory(null, 45,Utils.chat("&5&lEnchanting Station"));
		
		//add glass
		for (int i=0;i<45;i++) {
			if (i < 2 || i == 36 || i ==37) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
				this.gui.setItem(i, glassSlot);
			}
			else if (i < 12 || i == 17 || i == 18 || i == 20 || (i>25 && i<30) || (i>34)) {
				ItemStack glassSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
				this.gui.setItem(i, glassSlot);
			}			
		}	
		
		//INFO item
		ItemStack infoItem = new ItemStack(Material.BOOK);
		ItemMeta infoItemMeta = infoItem.getItemMeta();
		infoItemMeta.setDisplayName(Utils.chat("&a&lEnchants"));
		
		infoItem.setItemMeta(infoItemMeta);
		this.gui.setItem(5, infoItem);
		
		//next item
		ItemStack nextPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta nextPageMeta = (SkullMeta) nextPage.getItemMeta();
		nextPageMeta.setDisplayName(Utils.chat("&a&lNext"));
		GameProfile nextPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String nextPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1Y2U4NDQ4YWNiZDhlNjBjOWI2ZTkzZjQwNjJhMjAzYzQzNGFlYzUwNjgwZDlmMGQwMjhiN2MwOTEyNTczOCJ9fX0=";
		nextPageGameProfile.getProperties().put("textures", new Property("texture",nextPageValue));		
		
		try {
			Field profileField = nextPageMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(nextPageMeta, nextPageGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		nextPage.setItemMeta(nextPageMeta);
		this.gui.setItem(42, nextPage);		
		//add enchantment
		
	}

	public HashMap<Material,ArrayList<Enchantment>> getMaterialToEnchants() {
		return materialToEnchants;
	}

	public void setMaterialToEnchants(HashMap<Material,ArrayList<Enchantment>> materialToEnchants) {
		this.materialToEnchants = materialToEnchants;
	}

	public ArrayList<ItemStack> getAllowedItems() {
		return allowedItems;
	}

	public void setAllowedItems(ArrayList<ItemStack> allowedItems) {
		this.allowedItems = allowedItems;
	}

	public Inventory getGui() {
		return gui;
	}

	public void setGui(Inventory gui) {
		this.gui = gui;
	}

	public HashMap<Enchantment,ArrayList<String>> getEnchantLore() {
		return EnchantLore;
	}

	public void setEnchantLore(HashMap<Enchantment,ArrayList<String>> enchantLore) {
		EnchantLore = enchantLore;
	}

	public HashMap<Enchantment,Material> getEnchantItem() {
		return EnchantItem;
	}

	public void setEnchantItem(HashMap<Enchantment,Material> enchantItem) {
		EnchantItem = enchantItem;
	}

	public HashMap<Material,Enchantment> getItemEnchant() {
		return ItemEnchant;
	}

	public void setItemEnchant(HashMap<Material,Enchantment> itemEnchant) {
		ItemEnchant = itemEnchant;
	}

}
