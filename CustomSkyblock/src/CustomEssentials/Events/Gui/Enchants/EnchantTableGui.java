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
	private HashMap<Enchantment,String> EnchantTier = new HashMap<Enchantment,String>();

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
		this.generateEnchantTier();
		this.generateEnchantingRequirement();
		this.generateEnchantLevelLore();		
		this.generateAllowedItems();
		this.generateEnchantLore();
		this.generateEnchantItem();
		this.generateMaterialToEnchants();
		this.createInitialGui();
		
	}
	
	public void generateEnchantTier() {
		String basic = Utils.chat("&7&lBasic Tier");
		String common = Utils.chat("&e&lCommon Tier");
		String rare = Utils.chat("&a&lRare Tier");
		String epic = Utils.chat("&c&lEpic Tier");
		String mythic = Utils.chat("&5&lMythic Tier");
		String god = Utils.chat("&6&lGod Tier");
		this.EnchantTier.put(CustomEnchants.VACUUM, common);
		this.EnchantTier.put(CustomEnchants.BRUTE, rare);
		this.EnchantTier.put(CustomEnchants.COLLECTION, epic);
		this.EnchantTier.put(CustomEnchants.EXPERIENCE_EXTRACTOR, epic);
		this.EnchantTier.put(CustomEnchants.PICKPOCKET, epic);
		this.EnchantTier.put(CustomEnchants.PROSPERITY, epic);
		this.EnchantTier.put(CustomEnchants.JIGSAW, epic);
		this.EnchantTier.put(CustomEnchants.GEM_EXTRACTOR, rare);
		this.EnchantTier.put(CustomEnchants.GIANT, common);
	}
	
	public void addRequirementLores(ArrayList<String> lore, String enchantName) {
		int enchantingLevel = this.plugin.getProfileManager().getPlayerProfile(this.p).getEnchanting().getLevel();
		String hasRequirement = "&4";
		String hasDone = " &f&l(&a&l✓&f&l)";
		if (p.getTotalExperience() >= this.EnchantXpRequirement.get(enchantName)) {
			hasRequirement = "&a";
			
		}
		else {
			hasRequirement = "&4";
			hasDone = " &f&l(&4&l✗&f&l)";
		}
		lore.add(Utils.chat("&f- " + hasRequirement + "Cost " + this.EnchantXpRequirement.get(enchantName) + " Experience Points" + hasDone));
		if (enchantingLevel >= this.EnchantSkillRequirement.get(enchantName)) {
			hasRequirement = "&a";
			hasDone = " &f&l(&a&l✓&f&l)";
		}
		else {
			hasRequirement = "&4";
			hasDone = " &f&l(&4&l✗&f&l)";
		}
		lore.add(Utils.chat("&f- " + hasRequirement + "Requires " + this.EnchantSkillRequirement.get(enchantName) + " Enchanting Skill Level" + hasDone));
	}
	
	public void generateEnchantLevelLore() {
		//VACUUM LORES
		ArrayList<String> vacuumLore1 = new ArrayList<String>();
		vacuumLore1.add(Utils.chat(""));
		vacuumLore1.add(Utils.chat("&f&lEnchant Info"));
		vacuumLore1.add(Utils.chat("&7Drops/Loot/Blocks are automatically put"));
		vacuumLore1.add(Utils.chat("&7into your inventory upon mining a block or"));
		vacuumLore1.add(Utils.chat("&7killing a mob."));
		vacuumLore1.add(Utils.chat(""));
		vacuumLore1.add(Utils.chat("&f&lEnchant Requirements"));		
		addRequirementLores(vacuumLore1,"Vacuum 1");		
		//BRUTE LORES
		ArrayList<String> bruteLore1 = new ArrayList<String>();
		bruteLore1.add(Utils.chat(""));
		bruteLore1.add(Utils.chat("&f&lEnchant Info"));
		bruteLore1.add(Utils.chat("&7Increases the damage of the weapon by"));
		bruteLore1.add(Utils.chat("&75% for a minimum of 1 damage."));
		addRequirementLores(bruteLore1,"Brute 1");
		ArrayList<String> bruteLore2 = new ArrayList<String>();
		bruteLore2.add(Utils.chat(""));
		bruteLore2.add(Utils.chat("&f&lEnchant Info"));
		bruteLore2.add(Utils.chat("&7Increases the damage of the weapon by"));
		bruteLore2.add(Utils.chat("&710% for a minimum of 2 damage."));
		addRequirementLores(bruteLore2,"Brute 2");
		ArrayList<String> bruteLore3 = new ArrayList<String>();
		bruteLore3.add(Utils.chat(""));
		bruteLore3.add(Utils.chat("&f&lEnchant Info"));
		bruteLore3.add(Utils.chat("&7Increases the damage of the weapon by"));
		bruteLore3.add(Utils.chat("&715% for a minimum of 3 damage."));
		addRequirementLores(bruteLore3,"Brute 3");
		ArrayList<String> bruteLore4 = new ArrayList<String>();
		bruteLore4.add(Utils.chat(""));
		bruteLore4.add(Utils.chat("&f&lEnchant Info"));
		bruteLore4.add(Utils.chat("&7Increases the damage of the weapon by"));
		bruteLore4.add(Utils.chat("&720% for a minimum of 4 damage."));
		addRequirementLores(bruteLore4,"Brute 4");
		ArrayList<String> bruteLore5 = new ArrayList<String>();
		bruteLore5.add(Utils.chat(""));
		bruteLore5.add(Utils.chat("&f&lEnchant Info"));
		bruteLore5.add(Utils.chat("&7Increases the damage of the weapon by"));
		bruteLore5.add(Utils.chat("&725% for a minimum of 5 damage."));
		addRequirementLores(bruteLore5,"Brute 5");
		//Experience LORES
		ArrayList<String> experienceLore1 = new ArrayList<String>();
		experienceLore1.add(Utils.chat(""));
		experienceLore1.add(Utils.chat("&f&lEnchant Info"));
		experienceLore1.add(Utils.chat("&7Gain 50% more experience upon slaying"));
		experienceLore1.add(Utils.chat("&7a mob."));
		addRequirementLores(experienceLore1,"Experience Extractor 1");
		ArrayList<String> experienceLore2 = new ArrayList<String>();
		experienceLore2.add(Utils.chat(""));
		experienceLore2.add(Utils.chat("&f&lEnchant Info"));
		experienceLore2.add(Utils.chat("&7Gain 100% more experience upon slaying"));
		experienceLore2.add(Utils.chat("&7a mob."));
		addRequirementLores(experienceLore2,"Experience Extractor 2");
		//PICKPOCKET LORES
		ArrayList<String> pickpocketLore1 = new ArrayList<String>();
		pickpocketLore1.add(Utils.chat(""));
		pickpocketLore1.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore1.add(Utils.chat("&7Gain money upon slaying a mob, based on"));
		pickpocketLore1.add(Utils.chat("&7the mob tier."));
		addRequirementLores(pickpocketLore1,"Pickpocket 1");
		ArrayList<String> pickpocketLore2 = new ArrayList<String>();
		pickpocketLore2.add(Utils.chat(""));
		pickpocketLore2.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore2.add(Utils.chat("&7Gain 10% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore2,"Pickpocket 2");
		ArrayList<String> pickpocketLore3 = new ArrayList<String>();
		pickpocketLore3.add(Utils.chat(""));
		pickpocketLore3.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore3.add(Utils.chat("&7Gain 20% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore3,"Pickpocket 3");
		ArrayList<String> pickpocketLore4 = new ArrayList<String>();
		pickpocketLore4.add(Utils.chat(""));
		pickpocketLore4.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore4.add(Utils.chat("&7Gain 30% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore4,"Pickpocket 4");
		ArrayList<String> pickpocketLore5 = new ArrayList<String>();
		pickpocketLore5.add(Utils.chat(""));
		pickpocketLore5.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore5.add(Utils.chat("&7Gain 40% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore5,"Pickpocket 5");
		ArrayList<String> pickpocketLore6 = new ArrayList<String>();
		pickpocketLore6.add(Utils.chat(""));
		pickpocketLore6.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore6.add(Utils.chat("&7Gain 50% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore6,"Pickpocket 6");
		ArrayList<String> pickpocketLore7 = new ArrayList<String>();
		pickpocketLore7.add(Utils.chat(""));
		pickpocketLore7.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore7.add(Utils.chat("&7Gain 60% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore7,"Pickpocket 7");
		ArrayList<String> pickpocketLore8 = new ArrayList<String>();
		pickpocketLore8.add(Utils.chat(""));
		pickpocketLore8.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore8.add(Utils.chat("&7Gain 70% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore8,"Pickpocket 8");
		ArrayList<String> pickpocketLore9 = new ArrayList<String>();
		pickpocketLore9.add(Utils.chat(""));
		pickpocketLore9.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore9.add(Utils.chat("&7Gain 80% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore9,"Pickpocket 9");
		ArrayList<String> pickpocketLore10 = new ArrayList<String>();
		pickpocketLore10.add(Utils.chat(""));
		pickpocketLore10.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore10.add(Utils.chat("&7Gain 90% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore10,"Pickpocket 10");
		ArrayList<String> pickpocketLore11 = new ArrayList<String>();
		pickpocketLore11.add(Utils.chat(""));
		pickpocketLore11.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore11.add(Utils.chat("&7Gain 100% more money upon slaying a mob."));
		addRequirementLores(pickpocketLore11,"Pickpocket 11");
		//COLLECTION LORES
		ArrayList<String> collectionLore1 = new ArrayList<String>();
		collectionLore1.add(Utils.chat(""));
		collectionLore1.add(Utils.chat("&f&lEnchant Info"));
		collectionLore1.add(Utils.chat("&7Gain 25% more drops upon slaying"));
		collectionLore1.add(Utils.chat("&7a mob."));
		addRequirementLores(collectionLore1,"Collection 1");
		ArrayList<String> collectionLore2 = new ArrayList<String>();
		collectionLore2.add(Utils.chat(""));
		collectionLore2.add(Utils.chat("&f&lEnchant Info"));
		collectionLore2.add(Utils.chat("&7Gain 50% more drops upon slaying"));
		collectionLore2.add(Utils.chat("&7a mob."));
		addRequirementLores(collectionLore2,"Collection 2");
		ArrayList<String> collectionLore3 = new ArrayList<String>();
		collectionLore3.add(Utils.chat(""));
		collectionLore3.add(Utils.chat("&f&lEnchant Info"));
		collectionLore3.add(Utils.chat("&7Gain 75% more drops upon slaying"));
		collectionLore3.add(Utils.chat("&7a mob."));
		addRequirementLores(collectionLore3,"Collection 3");
		//PROSPERITY LORES
		ArrayList<String> prosperityLore1 = new ArrayList<String>();
		prosperityLore1.add(Utils.chat(""));
		prosperityLore1.add(Utils.chat("&f&lEnchant Info"));
		prosperityLore1.add(Utils.chat("&7Gain 10 luck."));
		addRequirementLores(prosperityLore1,"Collection 1");
		ArrayList<String> prosperityLore2 = new ArrayList<String>();
		prosperityLore2.add(Utils.chat(""));
		prosperityLore2.add(Utils.chat("&f&lEnchant Info"));
		prosperityLore2.add(Utils.chat("&7Gain 20 luck."));
		addRequirementLores(prosperityLore1,"Collection 1");
		ArrayList<String> prosperityLore3 = new ArrayList<String>();
		prosperityLore3.add(Utils.chat(""));
		prosperityLore3.add(Utils.chat("&f&lEnchant Info"));
		prosperityLore3.add(Utils.chat("&7Gain 30 luck."));
		addRequirementLores(prosperityLore1,"Collection 1");
		//JIGSAW LORES
		ArrayList<String> jigsawLore1 = new ArrayList<String>();
		jigsawLore1.add(Utils.chat(""));
		jigsawLore1.add(Utils.chat("&f&lEnchant Info"));
		jigsawLore1.add(Utils.chat("&7Breaking blocks will allow you to obtain"));
		jigsawLore1.add(Utils.chat("&7their original form. This enchant level is"));
		jigsawLore1.add(Utils.chat("&7very similar to silktouch."));
		addRequirementLores(jigsawLore1,"Jigsaw 1");
		ArrayList<String> jigsawLore2 = new ArrayList<String>();
		jigsawLore2.add(Utils.chat(""));
		jigsawLore2.add(Utils.chat("&f&lEnchant Info"));
		jigsawLore2.add(Utils.chat("&7Allows spawners to be mined and obtained as"));
		jigsawLore2.add(Utils.chat("&7an item. Additionally, keeps the perks of all"));
		jigsawLore2.add(Utils.chat("&7previous levels of the enchant."));
		addRequirementLores(jigsawLore2,"Jigsaw 2");
		//GEM EXTRACTOR LORES
		ArrayList<String> gemLore1 = new ArrayList<String>();
		gemLore1.add(Utils.chat(""));
		gemLore1.add(Utils.chat("&f&lEnchant Info"));
		gemLore1.add(Utils.chat("&7Get 50% more drops from breaking ores or "));
		gemLore1.add(Utils.chat("&7other specfic blocks."));
		addRequirementLores(gemLore1,"Gem Extractor 1");
		ArrayList<String> gemLore2 = new ArrayList<String>();
		gemLore2.add(Utils.chat(""));
		gemLore2.add(Utils.chat("&f&lEnchant Info"));
		gemLore2.add(Utils.chat("&7Get 100% more drops from breaking ores or "));
		gemLore2.add(Utils.chat("&7other specfic blocks."));
		addRequirementLores(gemLore2,"Gem Extractor 2");
		ArrayList<String> gemLore3 = new ArrayList<String>();
		gemLore3.add(Utils.chat(""));
		gemLore3.add(Utils.chat("&f&lEnchant Info"));
		gemLore3.add(Utils.chat("&7Get 150% more drops from breaking ores or "));
		gemLore3.add(Utils.chat("&7other specfic blocks."));
		addRequirementLores(gemLore3,"Gem Extractor 3");
		ArrayList<String> gemLore4 = new ArrayList<String>();
		gemLore4.add(Utils.chat(""));
		gemLore4.add(Utils.chat("&f&lEnchant Info"));
		gemLore4.add(Utils.chat("&7Get 200% more drops from breaking ores or "));
		gemLore4.add(Utils.chat("&7other specfic blocks."));
		addRequirementLores(gemLore4,"Gem Extractor 4");
		//GIANT LORES
		ArrayList<String> giantLore1 = new ArrayList<String>();
		giantLore1.add(Utils.chat(""));
		giantLore1.add(Utils.chat("&f&lEnchant Info"));
		giantLore1.add(Utils.chat("&7Gain an additional 10 max Health."));
		addRequirementLores(giantLore1,"Giant 1");
		ArrayList<String> giantLore2 = new ArrayList<String>();
		giantLore2.add(Utils.chat(""));
		giantLore2.add(Utils.chat("&f&lEnchant Info"));
		giantLore2.add(Utils.chat("&7Gain an additional 20 max Health."));
		addRequirementLores(giantLore2,"Giant 2");
		ArrayList<String> giantLore3 = new ArrayList<String>();
		giantLore3.add(Utils.chat(""));
		giantLore3.add(Utils.chat("&f&lEnchant Info"));
		giantLore3.add(Utils.chat("&7Gain an additional 30 max Health."));
		addRequirementLores(giantLore3,"Giant 3");
		ArrayList<String> giantLore4 = new ArrayList<String>();
		giantLore4.add(Utils.chat(""));
		giantLore4.add(Utils.chat("&f&lEnchant Info"));
		giantLore4.add(Utils.chat("&7Gain an additional 40 max Health."));
		addRequirementLores(giantLore4,"Giant 4");
		ArrayList<String> giantLore5 = new ArrayList<String>();
		giantLore5.add(Utils.chat(""));
		giantLore5.add(Utils.chat("&f&lEnchant Info"));
		giantLore5.add(Utils.chat("&7Gain an additional 50 max Health."));
		addRequirementLores(giantLore5,"Giant 5");
		ArrayList<String> giantLore6 = new ArrayList<String>();
		giantLore6.add(Utils.chat(""));
		giantLore6.add(Utils.chat("&f&lEnchant Info"));
		giantLore6.add(Utils.chat("&7Gain an additional 60 max Health."));
		addRequirementLores(giantLore6,"Giant 6");
		ArrayList<String> giantLore7 = new ArrayList<String>();
		giantLore7.add(Utils.chat(""));
		giantLore7.add(Utils.chat("&f&lEnchant Info"));
		giantLore7.add(Utils.chat("&7Gain an additional 70 max Health."));
		addRequirementLores(giantLore7,"Giant 7");
		ArrayList<String> giantLore8 = new ArrayList<String>();
		giantLore8.add(Utils.chat(""));
		giantLore8.add(Utils.chat("&f&lEnchant Info"));
		giantLore8.add(Utils.chat("&7Gain an additional 80 max Health."));
		addRequirementLores(giantLore8,"Giant 8");
		ArrayList<String> giantLore9 = new ArrayList<String>();
		giantLore9.add(Utils.chat(""));
		giantLore9.add(Utils.chat("&f&lEnchant Info"));
		giantLore9.add(Utils.chat("&7Gain an additional 90 max Health."));
		addRequirementLores(giantLore9,"Giant 9");
		ArrayList<String> giantLore10 = new ArrayList<String>();
		giantLore10.add(Utils.chat(""));
		giantLore10.add(Utils.chat("&f&lEnchant Info"));
		giantLore10.add(Utils.chat("&7Gain an additional 100 max Health."));
		addRequirementLores(giantLore10,"Giant 10");
		
		this.EnchantSpecificLore.put(Utils.chat("&eVacuum 1"), vacuumLore1);
		this.EnchantSpecificLore.put(Utils.chat("&aBrute 1"), bruteLore1);
		this.EnchantSpecificLore.put(Utils.chat("&aBrute 2"), bruteLore2);
		this.EnchantSpecificLore.put(Utils.chat("&aBrute 3"), bruteLore3);
		this.EnchantSpecificLore.put(Utils.chat("&aBrute 4"), bruteLore4);
		this.EnchantSpecificLore.put(Utils.chat("&aBrute 5"), bruteLore5);
		this.EnchantSpecificLore.put(Utils.chat("&cExperience Extractor 1"), experienceLore1);
		this.EnchantSpecificLore.put(Utils.chat("&cExperience Extractor 2"), experienceLore2);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 1"), pickpocketLore1);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 2"), pickpocketLore2);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 3"), pickpocketLore3);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 4"), pickpocketLore4);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 5"), pickpocketLore5);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 6"), pickpocketLore6);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 7"), pickpocketLore7);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 8"), pickpocketLore8);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 9"), pickpocketLore9);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 10"), pickpocketLore10);
		this.EnchantSpecificLore.put(Utils.chat("&cPickpocket 11"), pickpocketLore11);
		this.EnchantSpecificLore.put(Utils.chat("&cCollection 1"), collectionLore1);
		this.EnchantSpecificLore.put(Utils.chat("&cCollection 2"), collectionLore2);
		this.EnchantSpecificLore.put(Utils.chat("&cCollection 3"), collectionLore3);
		this.EnchantSpecificLore.put(Utils.chat("&cProsperity 1"), prosperityLore1);
		this.EnchantSpecificLore.put(Utils.chat("&cProsperity 2"), prosperityLore2);
		this.EnchantSpecificLore.put(Utils.chat("&cProsperity 3"), prosperityLore3);
		this.EnchantSpecificLore.put(Utils.chat("&cJigsaw 1"), jigsawLore1);
		this.EnchantSpecificLore.put(Utils.chat("&cJigsaw 2"), jigsawLore2);
		this.EnchantSpecificLore.put(Utils.chat("&aGem Extractor 1"), gemLore1);
		this.EnchantSpecificLore.put(Utils.chat("&aGem Extractor 2"), gemLore2);
		this.EnchantSpecificLore.put(Utils.chat("&aGem Extractor 3"), gemLore3);
		this.EnchantSpecificLore.put(Utils.chat("&aGem Extractor 4"), gemLore4);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 1"), giantLore1);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 2"), giantLore2);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 3"), giantLore3);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 4"), giantLore4);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 5"), giantLore5);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 6"), giantLore6);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 7"), giantLore7);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 8"), giantLore8);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 9"), giantLore9);
		this.EnchantSpecificLore.put(Utils.chat("&eGiant 10"), giantLore10);
	}	
	
	public void generateEnchantingRequirement() { 
		this.EnchantXpRequirement.put("Vacuum 1", 1500);
		this.EnchantSkillRequirement.put("Vacuum 1", 0);
		
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
		
		this.EnchantXpRequirement.put("Jigsaw 1", 0);
		this.EnchantSkillRequirement.put("Jigsaw 1", 0);
		this.EnchantXpRequirement.put("Jigsaw 2", 0);
		this.EnchantSkillRequirement.put("Jigsaw 2", 0);
		
		this.EnchantXpRequirement.put("Gem Extractor 1", 0);
		this.EnchantSkillRequirement.put("Gem Extractor 1", 0);
		this.EnchantXpRequirement.put("Gem Extractor 2", 0);
		this.EnchantSkillRequirement.put("Gem Extractor 2", 0);
		this.EnchantXpRequirement.put("Gem Extractor 3", 0);
		this.EnchantSkillRequirement.put("Gem Extractor 3", 0);
		this.EnchantXpRequirement.put("Gem Extractor 4", 0);
		this.EnchantSkillRequirement.put("Gem Extractor 4", 0);
		
		this.EnchantXpRequirement.put("Giant 1", 0);
		this.EnchantSkillRequirement.put("Giant 1", 0);
		this.EnchantXpRequirement.put("Giant 2", 0);
		this.EnchantSkillRequirement.put("Giant 2", 0);
		this.EnchantXpRequirement.put("Giant 3", 0);
		this.EnchantSkillRequirement.put("Giant 3", 0);
		this.EnchantXpRequirement.put("Giant 4", 0);
		this.EnchantSkillRequirement.put("Giant 4", 0);
		this.EnchantXpRequirement.put("Giant 5", 0);
		this.EnchantSkillRequirement.put("Giant 5", 0);
		this.EnchantXpRequirement.put("Giant 6", 0);
		this.EnchantSkillRequirement.put("Giant 6", 0);
		this.EnchantXpRequirement.put("Giant 7", 0);
		this.EnchantSkillRequirement.put("Giant 7", 0);
		this.EnchantXpRequirement.put("Giant 8", 0);
		this.EnchantSkillRequirement.put("Giant 8", 0);
		this.EnchantXpRequirement.put("Giant 9", 0);
		this.EnchantSkillRequirement.put("Giant 9", 0);
		this.EnchantXpRequirement.put("Giant 10", 0);
		this.EnchantSkillRequirement.put("Giant 10", 0);
		
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
		
		this.EnchantItem.put(CustomEnchants.JIGSAW, Material.AMETHYST_SHARD);
		this.ItemEnchant.put(Material.AMETHYST_SHARD, CustomEnchants.JIGSAW);
		
		this.EnchantItem.put(CustomEnchants.GEM_EXTRACTOR, Material.EMERALD);
		this.ItemEnchant.put(Material.EMERALD, CustomEnchants.GEM_EXTRACTOR);
		
		this.EnchantItem.put(CustomEnchants.GIANT, Material.OAK_LOG);
		this.ItemEnchant.put(Material.OAK_LOG, CustomEnchants.GIANT);
	}
	
	public void generateEnchantLore() {
		//VACUUM LORE
		ArrayList<String> vacuumLore = new ArrayList<String>();
		vacuumLore.add(Utils.chat("&7&oClick here to view levels"));
		vacuumLore.add("");
		vacuumLore.add(Utils.chat("&f&lEnchant Info"));
		vacuumLore.add(Utils.chat("&7Drops/Loot/Blocks are automatically put"));
		vacuumLore.add(Utils.chat("&7into your inventory upon mining a block or"));
		vacuumLore.add(Utils.chat("&7killing a mob."));
		vacuumLore.add("");
		vacuumLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 1));
		vacuumLore.add(Utils.chat("&f&lApplies on:&7 Tools/Weapons"));
		vacuumLore.add("");
		vacuumLore.add(this.EnchantTier.get(CustomEnchants.VACUUM));
		//BRUTE LORE
		ArrayList<String> bruteLore = new ArrayList<String>();
		bruteLore.add(Utils.chat("&7&oClick here to view levels"));
		bruteLore.add("");
		bruteLore.add(Utils.chat("&f&lEnchant Info"));
		bruteLore.add(Utils.chat("&7Increases the damage of the weapon"));
		bruteLore.add(Utils.chat("&7based on the level of enchantment and"));
		bruteLore.add(Utils.chat("&7the base damage of the weapon."));
		bruteLore.add("");
		bruteLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 5));
		bruteLore.add(Utils.chat("&f&lApplies on:&7 Weapons"));
		bruteLore.add("");
		bruteLore.add(this.EnchantTier.get(CustomEnchants.BRUTE));
		//Experience LORE
		ArrayList<String> experienceLore = new ArrayList<String>();
		experienceLore.add(Utils.chat("&7&oClick here to view levels"));
		experienceLore.add("");
		experienceLore.add(Utils.chat("&f&lEnchant Info"));
		experienceLore.add(Utils.chat("&7Gain a boost of experience upon"));
		experienceLore.add(Utils.chat("&7slaying a mob. Increased based on the"));
		experienceLore.add(Utils.chat("&7level of enchantment."));
		experienceLore.add("");
		experienceLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 2));
		experienceLore.add(Utils.chat("&f&lApplies on:&7 Weapons"));
		experienceLore.add("");
		experienceLore.add(this.EnchantTier.get(CustomEnchants.EXPERIENCE_EXTRACTOR));
		//PICKPOCKET LORE
		ArrayList<String> pickpocketLore = new ArrayList<String>();
		pickpocketLore.add(Utils.chat("&7&oClick here to view levels"));
		pickpocketLore.add("");
		pickpocketLore.add(Utils.chat("&f&lEnchant Info"));
		pickpocketLore.add(Utils.chat("&7Gain money upon slaying a mob, increased"));
		pickpocketLore.add(Utils.chat("&7based on the level of enchantment and"));
		pickpocketLore.add(Utils.chat("&7the tier of the mob."));
		pickpocketLore.add("");
		pickpocketLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 11));
		pickpocketLore.add(Utils.chat("&f&lApplies on:&7 Weapons"));
		pickpocketLore.add("");
		pickpocketLore.add(this.EnchantTier.get(CustomEnchants.PICKPOCKET));
		//COLLECTION LORE
		ArrayList<String> collectionLore = new ArrayList<String>();
		collectionLore.add(Utils.chat("&7&oClick here to view levels"));
		collectionLore.add("");
		collectionLore.add(Utils.chat("&f&lEnchant Info"));
		collectionLore.add(Utils.chat("&7Increases the amount of drops obtained"));
		collectionLore.add(Utils.chat("&7upon slaying a mob, based on the level"));
		collectionLore.add(Utils.chat("&7of the enchantment."));
		collectionLore.add("");
		collectionLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 3));
		collectionLore.add(Utils.chat("&f&lApplies on:&7 Weapons"));
		collectionLore.add("");
		collectionLore.add(this.EnchantTier.get(CustomEnchants.COLLECTION));
		//PROSPERITY LORE
		ArrayList<String> prosperityLore = new ArrayList<String>();
		prosperityLore.add(Utils.chat("&7&oClick here to view levels"));
		prosperityLore.add("");
		prosperityLore.add(Utils.chat("&f&lEnchant Info"));
		prosperityLore.add(Utils.chat("&7Increases the luck stat of the weapon"));
		prosperityLore.add(Utils.chat("&7based on the level of enchantment."));
		prosperityLore.add("");
		prosperityLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 3));
		prosperityLore.add(Utils.chat("&f&lApplies on:&7 Weapons"));
		prosperityLore.add("");
		prosperityLore.add(this.EnchantTier.get(CustomEnchants.PROSPERITY));
		//JIGSAW LORE
		ArrayList<String> jigsawLore = new ArrayList<String>();
		jigsawLore.add(Utils.chat("&7&oClick here to view levels"));
		jigsawLore.add("");
		jigsawLore.add(Utils.chat("&f&lEnchant Info"));
		jigsawLore.add(Utils.chat("&7Allows you to obtain certain blocks"));
		jigsawLore.add(Utils.chat("&7that cannot be obtained normally."));
		jigsawLore.add("");
		jigsawLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 2));
		jigsawLore.add(Utils.chat("&f&lApplies on:&7 Pickaxe"));
		jigsawLore.add("");
		jigsawLore.add(this.EnchantTier.get(CustomEnchants.JIGSAW));
		//GEM EXTRACTOR LORE
		ArrayList<String> gemLore = new ArrayList<String>();
		gemLore.add(Utils.chat("&7&oClick here to view levels"));
		gemLore.add("");
		gemLore.add(Utils.chat("&f&lEnchant Info"));
		gemLore.add(Utils.chat("&7Allows you to obtain increased drops from"));
		gemLore.add(Utils.chat("&7certain blocks."));
		gemLore.add("");
		gemLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 4));
		gemLore.add(Utils.chat("&f&lApplies on:&7 Pickaxe"));
		gemLore.add("");
		gemLore.add(this.EnchantTier.get(CustomEnchants.GEM_EXTRACTOR));
		//GIANT LORE
		ArrayList<String> giantLore = new ArrayList<String>();
		giantLore.add(Utils.chat("&7&oClick here to view levels"));
		giantLore.add("");
		giantLore.add(Utils.chat("&f&lEnchant Info"));
		giantLore.add(Utils.chat("&7Grants max health based on enchant"));
		giantLore.add(Utils.chat("&7level."));
		giantLore.add("");
		giantLore.add(Utils.chat("&f&lMax Enchant Level: &7" + 10));
		giantLore.add(Utils.chat("&f&lApplies on:&7 Armor"));
		giantLore.add("");
		giantLore.add(this.EnchantTier.get(CustomEnchants.GIANT));
		
		//ADD ENCHANT SPECIFIC LORE
		this.EnchantLore.put(CustomEnchants.BRUTE, bruteLore);
		this.EnchantLore.put(CustomEnchants.VACUUM, vacuumLore);		
		this.EnchantLore.put(CustomEnchants.EXPERIENCE_EXTRACTOR, experienceLore);
		this.EnchantLore.put(CustomEnchants.PICKPOCKET, pickpocketLore);
		this.EnchantLore.put(CustomEnchants.COLLECTION, collectionLore);
		this.EnchantLore.put(CustomEnchants.PROSPERITY, prosperityLore);
		this.EnchantLore.put(CustomEnchants.JIGSAW, jigsawLore);
		this.EnchantLore.put(CustomEnchants.GEM_EXTRACTOR, gemLore);
		this.EnchantLore.put(CustomEnchants.GIANT, giantLore);
		
		
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
		pickaxeEnchants.add(CustomEnchants.JIGSAW);
		pickaxeEnchants.add(CustomEnchants.GEM_EXTRACTOR);
		pickaxeEnchants.add(CustomEnchants.EXPERIENCE_EXTRACTOR);
		
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
		
		ArrayList<Enchantment> helmetEnchants = new ArrayList<Enchantment>();
		helmetEnchants.add(CustomEnchants.GIANT);
		
		this.materialToEnchants.put(Material.LEATHER_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.CHAINMAIL_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.IRON_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.GOLDEN_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.DIAMOND_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.NETHERITE_HELMET, helmetEnchants);
		this.materialToEnchants.put(Material.TURTLE_HELMET, helmetEnchants);
		
		
		ArrayList<Enchantment> chestplateEnchants = new ArrayList<Enchantment>();
		chestplateEnchants.add(CustomEnchants.GIANT);
		
		this.materialToEnchants.put(Material.LEATHER_CHESTPLATE, chestplateEnchants);
		this.materialToEnchants.put(Material.CHAINMAIL_CHESTPLATE, chestplateEnchants);
		this.materialToEnchants.put(Material.IRON_CHESTPLATE, chestplateEnchants);
		this.materialToEnchants.put(Material.GOLDEN_CHESTPLATE, chestplateEnchants);
		this.materialToEnchants.put(Material.DIAMOND_CHESTPLATE, chestplateEnchants);
		this.materialToEnchants.put(Material.NETHERITE_CHESTPLATE, chestplateEnchants);
		
		ArrayList<Enchantment> leggingsEnchants = new ArrayList<Enchantment>();
		leggingsEnchants.add(CustomEnchants.GIANT);
		
		this.materialToEnchants.put(Material.LEATHER_LEGGINGS, leggingsEnchants);
		this.materialToEnchants.put(Material.CHAINMAIL_LEGGINGS, leggingsEnchants);
		this.materialToEnchants.put(Material.IRON_LEGGINGS, leggingsEnchants);
		this.materialToEnchants.put(Material.GOLDEN_LEGGINGS, leggingsEnchants);
		this.materialToEnchants.put(Material.DIAMOND_LEGGINGS, leggingsEnchants);
		this.materialToEnchants.put(Material.NETHERITE_LEGGINGS, leggingsEnchants);
		
		ArrayList<Enchantment> bootsEnchants = new ArrayList<Enchantment>();
		bootsEnchants.add(CustomEnchants.GIANT);
		
		this.materialToEnchants.put(Material.LEATHER_BOOTS, bootsEnchants);
		this.materialToEnchants.put(Material.CHAINMAIL_BOOTS, bootsEnchants);
		this.materialToEnchants.put(Material.IRON_BOOTS, bootsEnchants);
		this.materialToEnchants.put(Material.GOLDEN_BOOTS, bootsEnchants);
		this.materialToEnchants.put(Material.DIAMOND_BOOTS, bootsEnchants);
		this.materialToEnchants.put(Material.NETHERITE_BOOTS, bootsEnchants);
		
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
		if (enchant == CustomEnchants.COLLECTION || enchant == CustomEnchants.PROSPERITY || enchant == CustomEnchants.JIGSAW || enchant == CustomEnchants.GEM_EXTRACTOR) enchantMaxLevel -= 1;
		for (int i=1;i<enchantMaxLevel;i++) {
			if (slot > 34) break;
			
			ItemStack enchantItem = new ItemStack(this.EnchantItem.get(enchant),i);
			ItemMeta enchantMeta = enchantItem.getItemMeta();
			String enchName = enchant.getKey().toString().replace("minecraft:", "").substring(1);
			char firstChar = enchant.getKey().toString().replace("minecraft:", "").toUpperCase().charAt(0);
			enchName = firstChar + enchName;
			enchantMeta.setDisplayName(Utils.chat(this.EnchantTier.get(enchant).substring(0,2)+enchName.replace("_e", " E")+" "+i));;
			
			enchantMeta.setLore(this.getEnchantSpecificLore().get(enchantMeta.getDisplayName()));
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
			enchantMeta.setDisplayName(Utils.chat(this.EnchantTier.get(ench).substring(0,2)+enchName.replace("_e", " E")));
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

	public HashMap<Enchantment,String> getEnchantTier() {
		return EnchantTier;
	}

	public void setEnchantTier(HashMap<Enchantment,String> enchantTier) {
		EnchantTier = enchantTier;
	}

}
