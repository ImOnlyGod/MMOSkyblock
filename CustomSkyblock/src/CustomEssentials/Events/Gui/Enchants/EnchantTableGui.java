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
	private HashMap<String,ArrayList<String>> EnchantSpecificLore = new HashMap<String,ArrayList<String>>();
	private HashMap<Enchantment,Material> EnchantItem = new HashMap<Enchantment,Material>();
	private HashMap<Material,Enchantment> ItemEnchant = new HashMap<Material,Enchantment>();
	private HashMap<String,Integer> EnchantXpRequirement = new HashMap<String,Integer>();
	private HashMap<String,Integer> EnchantSkillRequirement = new HashMap<String,Integer>();

	public HashMap<String, Integer> getEnchantXpRequirement() {
		return EnchantXpRequirement;
	}

	public void setEnchantXpRequirement(HashMap<String, Integer> enchantXpRequirement) {
		EnchantXpRequirement = enchantXpRequirement;
	}

	public HashMap<String, Integer> getEnchantSkillRequirement() {
		return EnchantSkillRequirement;
	}

	public void setEnchantSkillRequirement(HashMap<String, Integer> enchantSkillRequirement) {
		EnchantSkillRequirement = enchantSkillRequirement;
	}

	public EnchantTableGui(Player p, Main plugin) {
		this.p = p;
		this.plugin = plugin;
		this.generateEnchantingRequirement();
		this.generateAllowedItems();
		this.generateEnchantLore();
		this.generateEnchantItem();
		this.generateMaterialToEnchants();
		this.createInitialGui();
		
	}
	
	public void generateEnchantingRequirement() { 
		this.EnchantXpRequirement.put("Vacuum 1", 1500);
		this.EnchantSkillRequirement.put("Vacuum 1", 5);
		
		this.EnchantXpRequirement.put("Brute 1", 250);
		this.EnchantSkillRequirement.put("Brute 1", 0);
		this.EnchantXpRequirement.put("Brute 2", 1000);
		this.EnchantSkillRequirement.put("Brute 2", 0);
		this.EnchantXpRequirement.put("Brute 3", 2500);
		this.EnchantSkillRequirement.put("Brute 3", 0);
		this.EnchantXpRequirement.put("Brute 4", 10000);
		this.EnchantSkillRequirement.put("Brute 4", 0);
		this.EnchantXpRequirement.put("Brute 5", 25000);
		this.EnchantSkillRequirement.put("Brute 5", 0);
		
		this.EnchantXpRequirement.put("Experience Extractor 1", 5000);
		this.EnchantSkillRequirement.put("Experience Extractor 1", 10);
		this.EnchantXpRequirement.put("Experience Extractor 2", 50000);
		this.EnchantSkillRequirement.put("Experience Extractor 2", 25);
		
		this.EnchantXpRequirement.put("Pickpocket 1", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 1", 1);
		this.EnchantXpRequirement.put("Pickpocket 2", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 2", 1);
		this.EnchantXpRequirement.put("Pickpocket 3", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 3", 1);
		this.EnchantXpRequirement.put("Pickpocket 4", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 4", 1);
		this.EnchantXpRequirement.put("Pickpocket 5", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 5", 1);
		this.EnchantXpRequirement.put("Pickpocket 6", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 6", 1);
		this.EnchantXpRequirement.put("Pickpocket 7", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 7", 1);
		this.EnchantXpRequirement.put("Pickpocket 8", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 8", 1);
		this.EnchantXpRequirement.put("Pickpocket 9", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 9", 1);
		this.EnchantXpRequirement.put("Pickpocket 10", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 10", 1);
		this.EnchantXpRequirement.put("Pickpocket 11", 1500);
		this.EnchantSkillRequirement.put("Pickpocket 11", 1);
		
		this.EnchantXpRequirement.put("Collection 1", 0);
		this.EnchantSkillRequirement.put("Collection 1", 0);
		this.EnchantXpRequirement.put("Collection 2", 0);
		this.EnchantSkillRequirement.put("Collection 2", 0);
		this.EnchantXpRequirement.put("Collection 3", 0);
		this.EnchantSkillRequirement.put("Collection 3", 0);
		
		this.EnchantXpRequirement.put("Prosperity 1", 0);
		this.EnchantSkillRequirement.put("Prosperity 1", 0);
		this.EnchantXpRequirement.put("Prosperity 2", 0);
		this.EnchantSkillRequirement.put("Prosperity 2", 0);
		this.EnchantXpRequirement.put("Prosperity 3", 0);
		this.EnchantSkillRequirement.put("Prosperity 3", 0);
		
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
		
		this.EnchantItem.put(CustomEnchants.COLLECTION, Material.EGG);
		this.ItemEnchant.put(Material.EGG, CustomEnchants.COLLECTION);

		this.EnchantItem.put(CustomEnchants.PROSPERITY, Material.ENCHANTED_GOLDEN_APPLE);
		this.ItemEnchant.put(Material.ENCHANTED_GOLDEN_APPLE, CustomEnchants.PROSPERITY);
	}
	
	public void generateEnchantLore() {
		//VACUUM LORE
		ArrayList<String> vacuumLore = new ArrayList<String>();
		vacuumLore.add(Utils.chat("&7&oClick here to view levels"));
		//ADD ENCHANT SPECIFIC LORE
		
		this.EnchantLore.put(CustomEnchants.VACUUM, vacuumLore);
		this.EnchantLore.put(CustomEnchants.BRUTE, vacuumLore);
		this.EnchantLore.put(CustomEnchants.EXPERIENCE_EXTRACTOR, vacuumLore);
		this.EnchantLore.put(CustomEnchants.PICKPOCKET, vacuumLore);
		this.EnchantLore.put(CustomEnchants.COLLECTION, vacuumLore);
		this.EnchantLore.put(CustomEnchants.PROSPERITY, vacuumLore);
		
	}
	
	public void generateMaterialToEnchants() {
		ArrayList<Enchantment> swordEnchants = new ArrayList<Enchantment>();
		swordEnchants.add(CustomEnchants.VACUUM);
		swordEnchants.add(CustomEnchants.BRUTE);
		swordEnchants.add(CustomEnchants.EXPERIENCE_EXTRACTOR);
		swordEnchants.add(CustomEnchants.PICKPOCKET);
		swordEnchants.add(CustomEnchants.COLLECTION);
		swordEnchants.add(CustomEnchants.PROSPERITY);
		
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
		axeEnchants.add(CustomEnchants.COLLECTION);
		axeEnchants.add(CustomEnchants.PROSPERITY);
		
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
		if (enchant == CustomEnchants.COLLECTION || enchant == CustomEnchants.PROSPERITY) enchantMaxLevel -= 1;
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

	public HashMap<String,ArrayList<String>> getEnchantSpecificLore() {
		return EnchantSpecificLore;
	}

	public void setEnchantSpecificLore(HashMap<String,ArrayList<String>> enchantSpecificLore) {
		EnchantSpecificLore = enchantSpecificLore;
	}

}
