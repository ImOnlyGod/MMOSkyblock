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
	private HashMap<Material,ArrayList<Enchantment>> materialToEnchants = new HashMap<Material,ArrayList<Enchantment>>();
	private ArrayList<ItemStack> allowedItems = new ArrayList<ItemStack>();
	
	
	public EnchantTableGui(Player p, Main plugin) {
		this.p = p;
		this.plugin = plugin;
		this.generateAllowedItems();
		this.generateMaterialToEnchants();
	}
	
	public void generateAllowedItems() {
		
	}
	
	public void generateMaterialToEnchants() {
		ArrayList<Enchantment> swordEnchants = new ArrayList<Enchantment>();
		swordEnchants.add(CustomEnchants.VACUUM);
		
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
	}
	
	public void createInitialGui() {
		Inventory gui = Bukkit.createInventory(null, 45,Utils.chat("&5&lEnchanting Station &7(Page 1)"));
		
		//add glass
		for (int i=0;i<45;i++) {
			if (i < 2 || i == 36 || i ==37) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
				gui.setItem(i, glassSlot);
			}
			else if (i < 12 || i == 17 || i == 18 || i == 20 || (i>25 && i<30) || (i>34)) {
				ItemStack glassSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
				gui.setItem(i, glassSlot);
			}			
		}	
		
		//INFO item
		ItemStack infoItem = new ItemStack(Material.BOOK);
		ItemMeta infoItemMeta = infoItem.getItemMeta();
		infoItemMeta.setDisplayName(Utils.chat("&a&lEnchants"));
		
		infoItem.setItemMeta(infoItemMeta);
		gui.setItem(5, infoItem);
		
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
		gui.setItem(42, nextPage);		
		//add enchantment
		
		
		this.p.openInventory(gui);
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

}
