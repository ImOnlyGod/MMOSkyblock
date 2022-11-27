package CustomEssentials.Events.Gui.Skills;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerSkills.Skills;
import CustomEssentials.Utils.Utils;

public class SkillProgression {
	
	private Player p;
	private Profile profile;
	private Skills skill;
	private Main plugin;
	private String skillName;
	
	public SkillProgression(Main plugin, Player p, Skills skill, String skillName) {
		this.p = p;
		this.plugin = plugin;
		this.skill = skill;
		this.profile = this.plugin.getProfileManager().getPlayerProfile(p);
		this.setSkillName(skillName);
	}
	
	public void createSkillGui() {
		
		Inventory gui = Bukkit.createInventory(null, 45,Utils.chat(this.skillName+" &7&lProgression"));
		
		//Generate Glass
		for (int i=1;i<45;i++) {
			if (i<10 || i == 17 || i == 27 || i > 34) {
				gui.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
			}
			else if ((i > 9 && i <17) || (i > 27 && i < 35)) {
				gui.setItem(i, new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));
			}
		}
		
		int level = this.skill.getLevel();
		
		ItemStack currentLevel = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta currentLevelmeta = currentLevel.getItemMeta();
		currentLevelmeta.setDisplayName(Utils.chat("&7&lLevel &6&l"+level));
		
		ItemStack nextLevel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta nextLevelmeta = nextLevel.getItemMeta();
		nextLevelmeta.setDisplayName(Utils.chat("&7&lLevel &c&l"+(level+1)));
		
		ArrayList<String> currentLore = new ArrayList<String>();
		currentLore.add(Utils.chat("&f&lXp: &7"+Math.round(skill.getCurrentXP())+"/"+Math.round(skill.getMaxXP())));
		ArrayList<String> nextLore = new ArrayList<String>();
		nextLore.add(Utils.chat(""));
		nextLore.add(Utils.chat("&f&lPerks: &7"));		
		for (int i=0; i<SkillLoreFromString().size();i++) {
			nextLore.add(Utils.chat("&2+ " + SkillLoreFromString().get(i)));
		}
		
		currentLevelmeta.setLore(currentLore);
		nextLevelmeta.setLore(nextLore);
		currentLevel.setItemMeta(currentLevelmeta);
		nextLevel.setItemMeta(nextLevelmeta);		
		
		if (level < 4) {
			for (int i=18;i<(18+level);i++) {
				ItemStack completedLevel = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
				ItemMeta completedLevelMeta = completedLevel.getItemMeta();
				completedLevelMeta.setDisplayName(Utils.chat("&7&lLevel &a&l"+(i-18)));
				completedLevel.setItemMeta(completedLevelMeta);
				gui.setItem(i, completedLevel);
			}
			
			gui.setItem(level+18, currentLevel);
			gui.setItem(level+19, nextLevel);
			
			for (int i=(20+level);i<(27);i++) {
				ItemStack upcommingLevel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				ItemMeta upcommingLevelMeta = upcommingLevel.getItemMeta();
				upcommingLevelMeta.setDisplayName(Utils.chat("&7&lLevel &4&l"+(i-18)));
				
				ArrayList<String> upcommingLore = new ArrayList<String>();
				upcommingLore.add(Utils.chat(""));
				upcommingLore.add(Utils.chat("&f&lPerks: &4&l???"));
				
				upcommingLevelMeta.setLore(upcommingLore);
				upcommingLevel.setItemMeta(upcommingLevelMeta);
				gui.setItem(i, upcommingLevel);
			}
			
		}
		else {
			for (int i=18;i<(22);i++) {
				ItemStack completedLevel = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
				ItemMeta completedLevelMeta = completedLevel.getItemMeta();
				completedLevelMeta.setDisplayName(Utils.chat("&7&lLevel &a&l"+(level-(22-i))));
				completedLevel.setItemMeta(completedLevelMeta);
				gui.setItem(i, completedLevel);
			}			
			gui.setItem(22, currentLevel);
			gui.setItem(23, nextLevel);
			for (int i=24;i<(27);i++) {
				ItemStack upcommingLevel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				ItemMeta upcommingLevelMeta = upcommingLevel.getItemMeta();
				upcommingLevelMeta.setDisplayName(Utils.chat("&7&lLevel &4&l"+(level+5-(27-i))));
				
				ArrayList<String> upcommingLore = new ArrayList<String>();
				upcommingLore.add(Utils.chat(""));
				upcommingLore.add(Utils.chat("&f&lPerks: &4&l???"));
				
				upcommingLevelMeta.setLore(upcommingLore);
				upcommingLevel.setItemMeta(upcommingLevelMeta);
				gui.setItem(i, upcommingLevel);
			}			
		}
		//ADD ITEM FOR TOP AND GOING BACK
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
		gui.setItem(0, mainMenu);
		
		//ADD INFORMATION
		ItemStack info = new ItemStack(Material.BOOK);
		ItemMeta infoMeta = info.getItemMeta();
		infoMeta.setDisplayName(Utils.chat("&a&lSkill Information"));
		info.setItemMeta(infoMeta);
		gui.setItem(4, info);
		
		
		this.p.openInventory(gui);
	}
	
	public ArrayList<String> SkillLoreFromString() {
		
		if (this.getSkillName() == "&8&lMining") return this.getProfile().getStats().calclevelUpMining(this.skill.getLevel()+1);
		else if (this.getSkillName() == "&a&lFarming") return this.getProfile().getStats().calclevelUpFarming(this.skill.getLevel()+1);
		else if (this.getSkillName() == "&c&lCombat") return this.getProfile().getStats().calclevelUpCombat(this.skill.getLevel()+1);
		else if (this.getSkillName() == "&6&lForaging") return this.getProfile().getStats().calclevelUpForaging(this.skill.getLevel()+1);
		else if (this.getSkillName() == "&b&lFishing") return this.getProfile().getStats().calclevelUpFishing(this.skill.getLevel()+1);
		
		return null;
	}
	
	

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	

}
