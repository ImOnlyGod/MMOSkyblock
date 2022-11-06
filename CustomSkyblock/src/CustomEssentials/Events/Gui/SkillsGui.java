package CustomEssentials.Events.Gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerSkills.CombatSkill;
import CustomEssentials.Events.PlayerSkills.FarmingSkill;
import CustomEssentials.Events.PlayerSkills.FishingSkill;
import CustomEssentials.Events.PlayerSkills.ForagingSkill;
import CustomEssentials.Events.PlayerSkills.MiningSkill;
import CustomEssentials.Utils.Utils;

public class SkillsGui implements TabExecutor{

	private Main plugin;
	
	public SkillsGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("skills").setExecutor(this);
		
	}
	
	public String progressionBarGenerator(float progressionPercent) {
		String progressionBarGreen = "";
		String progressionBarRed = "";
				
		
		//Move to separate function
		String progressionBar = "▊";
		for (int i=0; i < 20; i++) {
			if (((int) progressionPercent/5) > i) {
				progressionBarGreen += progressionBar;
				}
			else progressionBarRed += progressionBar;
			
		}
		
		String skillProgressionBar = Utils.chat("&a" + progressionBarGreen + "&c" + progressionBarRed);
		return skillProgressionBar;
	}
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&a&lSkills"));
		
		//Glass Slots
		for (int i = 1; i < menu.getSize(); i++) {
			if ((i < 19) || (i > 34) || (i == 26) || (i == 27)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				menu.setItem(i, glassSlot);
			}
						
		}
			
		//Player Skills and generating lore requirements
		MiningSkill mining = playerProfile.getMining();
		int miningLevel = mining.getLevel();
		Double currentMiningXp = mining.getCurrentXP();
		Double finalMiningXp = mining.getMaxXP();
		ArrayList<String> miningLevelUpReward = playerProfile.getStats().calclevelUpMining(miningLevel);
		int miningProgressionPercent = (int) (100*currentMiningXp/finalMiningXp);
		String miningProgressionBar = progressionBarGenerator(miningProgressionPercent);
		
		FarmingSkill farming = playerProfile.getFarming();
		int farmingLevel = farming.getLevel();
		Double currentFarmingXp = farming.getCurrentXP();
		Double finalFarmingXp = farming.getMaxXP();
		ArrayList<String> farmingLevelUpReward = playerProfile.getStats().calclevelUpFarming(farmingLevel); //CHANGE TO PROPER SKILL
		int farmingProgressionPercent = (int) (100*currentFarmingXp/finalFarmingXp);
		String farmingProgressionBar = progressionBarGenerator(farmingProgressionPercent);
		
		CombatSkill combat = playerProfile.getCombat();
		int combatLevel = combat.getLevel();
		Double currentCombatXp = combat.getCurrentXP();
		Double finalCombatXp = combat.getMaxXP();
		ArrayList<String> combatLevelUpReward = playerProfile.getStats().calclevelUpCombat(combatLevel);
		int combatProgressionPercent = (int) (100*currentCombatXp/finalCombatXp);
		String combatProgressionBar = progressionBarGenerator(combatProgressionPercent);
		
		ForagingSkill foraging = playerProfile.getForaging();
		int foragingLevel = foraging.getLevel();
		Double currentForagingXp = foraging.getCurrentXP();
		Double finalForagingXp = foraging.getMaxXP();
		ArrayList<String> foragingLevelUpReward = playerProfile.getStats().calclevelUpForaging(foragingLevel);
		int foragingProgressionPercent = (int) (100*currentForagingXp/finalForagingXp);
		String foragingProgressionBar = progressionBarGenerator(foragingProgressionPercent);
		
		FishingSkill fishing = playerProfile.getFishing();
		int fishingLevel = fishing.getLevel();
		Double currentFishingXp = fishing.getCurrentXP();
		Double finalFishingXp = fishing.getMaxXP();
		ArrayList<String> fishingLevelUpReward = playerProfile.getStats().calclevelUpFishing(fishingLevel);
		int fishingProgressionPercent = (int) (100*currentFishingXp/finalFishingXp);
		String fishingProgressionBar = progressionBarGenerator(fishingProgressionPercent);
		
		
		
		//Add mining item
		ItemStack miningItem = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta miningItemMeta = miningItem.getItemMeta();
		miningItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		miningItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		miningItemMeta.setDisplayName(Utils.chat("&8&l        &nMining Skill"));
		
		List<String> miningSkillLore = new ArrayList<String>();
		miningSkillLore.add(Utils.chat("&f&lLevel: &7" + miningLevel));
		miningSkillLore.add(Utils.chat("&f&lXp: &7" + Math.floor(currentMiningXp) + "/" + Math.floor(finalMiningXp)));
		miningSkillLore.add(Utils.chat(""));
		miningSkillLore.add(Utils.chat("&7Mine stone and Ore blocks"));
		miningSkillLore.add(Utils.chat("&7to gain more experience."));
		miningSkillLore.add(Utils.chat(""));
		miningSkillLore.add(Utils.chat("&f&lNext Level: &7" + (miningLevel+1)));
		miningSkillLore.add(Utils.chat(""));
		miningSkillLore.add(Utils.chat("&7&l&m|----->&f&lProgress&7&l&m<-----|"));
		miningSkillLore.add(miningProgressionBar);
		miningSkillLore.add(Utils.chat("&7&l&m|-------->&f" + miningProgressionPercent + "%&7&l&m<--------|"));
		miningSkillLore.add(Utils.chat(""));
		miningSkillLore.add(Utils.chat("&7Levelling up this skill"));
		miningSkillLore.add(Utils.chat("&7will provide more defensive"));
		miningSkillLore.add(Utils.chat("&7stats."));
		miningSkillLore.add(Utils.chat(""));
		miningSkillLore.add(Utils.chat("&f&lUpcomming Perks:"));
		for (int i=0; i<miningLevelUpReward.size();i++) {
			miningSkillLore.add(Utils.chat("&2+ " + miningLevelUpReward.get(i)));
		}

		miningItemMeta.setLore(miningSkillLore);
		miningItem.setItemMeta(miningItemMeta);
		menu.setItem(19, miningItem);
		
		//Add farming item
		ItemStack farmingItem = new ItemStack(Material.STONE_HOE);
		ItemMeta farmingItemMeta = farmingItem.getItemMeta();
		farmingItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		farmingItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		farmingItemMeta.setDisplayName(Utils.chat("&a&l        &nFarming Skill"));
		
		List<String> farmingSkillLore = new ArrayList<String>();
		farmingSkillLore.add(Utils.chat("&f&lLevel: &7" + farmingLevel));
		farmingSkillLore.add(Utils.chat("&f&lXp: &7" + Math.floor(currentFarmingXp) + "/" + Math.floor(finalFarmingXp)));
		farmingSkillLore.add(Utils.chat(""));
		farmingSkillLore.add(Utils.chat("&7Farm crops to gain more"));
		farmingSkillLore.add(Utils.chat("&7experience."));
		farmingSkillLore.add(Utils.chat(""));
		farmingSkillLore.add(Utils.chat("&f&lNext Level: &7" + (farmingLevel+1)));
		farmingSkillLore.add(Utils.chat(""));
		farmingSkillLore.add(Utils.chat("&7&l&m|----->&f&lProgress&7&l&m<-----|"));
		farmingSkillLore.add(farmingProgressionBar);
		farmingSkillLore.add(Utils.chat("&7&l&m|-------->&f" + farmingProgressionPercent + "%&7&l&m<--------|"));
		farmingSkillLore.add(Utils.chat(""));
		farmingSkillLore.add(Utils.chat("&7Levelling up this skill"));
		farmingSkillLore.add(Utils.chat("&7will provide more health"));
		farmingSkillLore.add(Utils.chat("&7stats."));
		farmingSkillLore.add(Utils.chat(""));
		farmingSkillLore.add(Utils.chat("&f&lUpcomming Perks:"));
		for (int i=0; i<farmingLevelUpReward.size();i++) {
			farmingSkillLore.add(Utils.chat("&2+ " + farmingLevelUpReward.get(i)));
		}

		farmingItemMeta.setLore(farmingSkillLore);
		farmingItem.setItemMeta(farmingItemMeta);
		menu.setItem(20, farmingItem);
		
		//Add combat item
		ItemStack combatItem = new ItemStack(Material.IRON_SWORD);
		ItemMeta combatItemMeta = combatItem.getItemMeta();
		combatItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		combatItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		combatItemMeta.setDisplayName(Utils.chat("&c&l        &nCombat Skill"));
		
		List<String> combatSkillLore = new ArrayList<String>();
		combatSkillLore.add(Utils.chat("&f&lLevel: &7" + combatLevel));
		combatSkillLore.add(Utils.chat("&f&lXp: &7" + Math.floor(currentCombatXp) + "/" + Math.floor(finalCombatXp)));
		combatSkillLore.add(Utils.chat(""));
		combatSkillLore.add(Utils.chat("&7Kill animals and monsters"));
		combatSkillLore.add(Utils.chat("&7to gain more experience."));
		combatSkillLore.add(Utils.chat(""));
		combatSkillLore.add(Utils.chat("&f&lNext Level: &7" + (combatLevel+1)));
		combatSkillLore.add(Utils.chat(""));
		combatSkillLore.add(Utils.chat("&7&l&m|----->&f&lProgress&7&l&m<-----|"));
		combatSkillLore.add(combatProgressionBar);
		combatSkillLore.add(Utils.chat("&7&l&m|-------->&f" + combatProgressionPercent + "%&7&l&m<--------|"));
		combatSkillLore.add(Utils.chat(""));
		combatSkillLore.add(Utils.chat("&7Levelling up this skill"));
		combatSkillLore.add(Utils.chat("&7will provide more offensive"));
		combatSkillLore.add(Utils.chat("&7stats."));
		combatSkillLore.add(Utils.chat(""));
		combatSkillLore.add(Utils.chat("&f&lUpcomming Perks:"));
		for (int i=0; i<combatLevelUpReward.size();i++) {
			combatSkillLore.add(Utils.chat("&2+ " + combatLevelUpReward.get(i)));
		}

		combatItemMeta.setLore(combatSkillLore);
		combatItem.setItemMeta(combatItemMeta);
		menu.setItem(21, combatItem);
		
		//Add foraging item
		ItemStack foragingItem = new ItemStack(Material.STONE_AXE);
		ItemMeta foragingItemMeta = foragingItem.getItemMeta();
		foragingItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		foragingItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		foragingItemMeta.setDisplayName(Utils.chat("&6&l        &nForaging Skill"));
		
		List<String> foragingSkillLore = new ArrayList<String>();
		foragingSkillLore.add(Utils.chat("&f&lLevel: &7" + foragingLevel));
		foragingSkillLore.add(Utils.chat("&f&lXp: &7" + Math.floor(currentForagingXp) + "/" + Math.floor(finalForagingXp)));
		foragingSkillLore.add(Utils.chat(""));
		foragingSkillLore.add(Utils.chat("&7Chop down wood from trees"));
		foragingSkillLore.add(Utils.chat("&7to gain more experience."));
		foragingSkillLore.add(Utils.chat(""));
		foragingSkillLore.add(Utils.chat("&f&lNext Level: &7" + (foragingLevel+1)));
		foragingSkillLore.add(Utils.chat(""));
		foragingSkillLore.add(Utils.chat("&7&l&m|----->&f&lProgress&7&l&m<-----|"));
		foragingSkillLore.add(foragingProgressionBar);
		foragingSkillLore.add(Utils.chat("&7&l&m|-------->&f" + foragingProgressionPercent + "%&7&l&m<--------|"));
		foragingSkillLore.add(Utils.chat(""));
		foragingSkillLore.add(Utils.chat("&7Levelling up this skill"));
		foragingSkillLore.add(Utils.chat("&7will provide a mixture of"));
		foragingSkillLore.add(Utils.chat("&7stats."));
		foragingSkillLore.add(Utils.chat(""));
		foragingSkillLore.add(Utils.chat("&f&lUpcomming Perks:"));
		for (int i=0; i<foragingLevelUpReward.size();i++) {
			foragingSkillLore.add(Utils.chat("&2+ " + foragingLevelUpReward.get(i)));
		}

		foragingItemMeta.setLore(foragingSkillLore);
		foragingItem.setItemMeta(foragingItemMeta);
		menu.setItem(22, foragingItem);
		
		//Add fishing item
		ItemStack fishingItem = new ItemStack(Material.FISHING_ROD);
		ItemMeta fishingItemMeta = fishingItem.getItemMeta();
		fishingItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		fishingItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		fishingItemMeta.setDisplayName(Utils.chat("&b&l        &nFishing Skill"));
		
		List<String> fishingSkillLore = new ArrayList<String>();
		fishingSkillLore.add(Utils.chat("&f&lLevel: &7" + fishingLevel));
		fishingSkillLore.add(Utils.chat("&f&lXp: &7" + Math.floor(currentFishingXp) + "/" + Math.floor(finalFishingXp)));
		fishingSkillLore.add(Utils.chat(""));
		fishingSkillLore.add(Utils.chat("&7Go fishing to gain more"));
		fishingSkillLore.add(Utils.chat("&7experience."));
		fishingSkillLore.add(Utils.chat(""));
		fishingSkillLore.add(Utils.chat("&f&lNext Level: &7" + (fishingLevel+1)));
		fishingSkillLore.add(Utils.chat(""));
		fishingSkillLore.add(Utils.chat("&7&l&m|----->&f&lProgress&7&l&m<-----|"));
		fishingSkillLore.add(fishingProgressionBar);
		fishingSkillLore.add(Utils.chat("&7&l&m|-------->&f" + fishingProgressionPercent + "%&7&l&m<--------|"));
		fishingSkillLore.add(Utils.chat(""));
		fishingSkillLore.add(Utils.chat("&7Levelling up this skill"));
		fishingSkillLore.add(Utils.chat("&7will provide more utility"));
		fishingSkillLore.add(Utils.chat("&7stats."));
		fishingSkillLore.add(Utils.chat(""));
		fishingSkillLore.add(Utils.chat("&f&lUpcomming Perks:"));
		for (int i=0; i<fishingLevelUpReward.size();i++) {
			fishingSkillLore.add(Utils.chat("&2+ " + fishingLevelUpReward.get(i)));
		}

		fishingItemMeta.setLore(fishingSkillLore);
		fishingItem.setItemMeta(fishingItemMeta);
		menu.setItem(23, fishingItem);
		
		
		//Back to Main Menu Item
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lBack to Main Menu"));
		GameProfile mainMenuGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mainMenuValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJlNTI5YWI2YjJlYTdjNTBkOTE5MmQ4OWY4OThmZDdkYThhOWU3NTBkMzc4Mjk1ZGY3MzIwNWU3YTdlZWFlMCJ9fX0=";
		mainMenuGameProfile.getProperties().put("textures", new Property("texture",mainMenuValue));	
		
		try {
			Field profileField = mainMenuMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(mainMenuMeta, mainMenuGameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainMenu.setItemMeta(mainMenuMeta);
		menu.setItem(0, mainMenu);
		
		
		return menu;
				
	}
	

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;
		Profile playerProfile = this.plugin.getProfileManager().getPlayerProfile(p);
		
		
		Inventory menu = createGui(p, playerProfile);
		
		p.openInventory(menu);
		
		return true;
	}
	
}
