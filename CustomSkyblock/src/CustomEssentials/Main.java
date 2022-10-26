package CustomEssentials;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import CustomEssentials.Commands.CustomMobsCommand;
import CustomEssentials.Commands.EatCommand;
import CustomEssentials.Commands.FlyCommand;
import CustomEssentials.Commands.WeaponCommand;
import CustomEssentials.Events.EventsClass;
import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Gui.MenuGui;
import CustomEssentials.Events.Gui.PathSelectionGui;
import CustomEssentials.Events.Gui.SkillsGui;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.ArmorUtils;
import CustomEssentials.Utils.HealthUtils;
import CustomEssentials.Utils.ManaUtils;
import CustomEssentials.Utils.StatsUtil;
import CustomEssentials.Utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin{

	private PlayerProfileManager profileManager;
	private int displayStats = 0;

	
	@Override
	public void onEnable() {
		
		//getServer().getConsoleSender().sendMessage(Utils.chat("&aPlugin has been enabled!"));
										
		this.profileManager = new PlayerProfileManager(this);
		
		new MenuGui(this);
		new SkillsGui(this);
		new PathSelectionGui(this);
		getServer().getPluginManager().registerEvents(new EventsClass(this), this);
		
		loadConfig();
		
		new FlyCommand(this);
		new EatCommand(this);
		new WeaponCommand(this);
		new CustomMobsCommand(this);
		
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
				
		@Override
		public void run() {
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				
				
				PlayerProfileManager profiles = getProfileManager();
				Profile profile = getProfileManager().getPlayerProfile(p);
				
				if (!profiles.hasProfile(p)) {
					profiles.createPlayerProfile(p);
				}
								
				profiles.getPlayerProfile(p).incrementPlayTime();
				Stats stats = profileManager.getPlayerProfile(p).getStats();
				Stats pathStats = profileManager.getPlayerProfile(p).getPath().getStats();
				int currentMana = stats.getMana();
				int TotalMana = stats.getTotalMana();
				
				//Sets item stats
				ItemStats setStats = new ItemStats(p,profileManager);
				setStats.setItemStats();		
				
				if (currentMana < TotalMana) stats.setMana(currentMana+1);
				
								
				String health = HealthUtils.getActionBarHealthText(p);
				String armor = ArmorUtils.getActionBarArmorText(profile);
				String mana = ManaUtils.getActionBarManaText(p,currentMana, TotalMana);
				
				p.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(stats.getArmor() + pathStats.getArmor());
				p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(stats.getDefaultHealth() + pathStats.getDefaultHealth());
				p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(stats.getDefaultPhysicalDamage() + pathStats.getDefaultPhysicalDamage());
				
				
				if (displayStats == 0) {
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(health + armor + mana));
				}
				else if (displayStats == 1) {
					
					String mining = StatsUtil.miningActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(mining));
					
					if (profile.getMining().getCurrentXP() >= profile.getMining().getMaxXP()) {
						profile.getMining().levelUp();
						int level = profile.getMining().getLevel();
						profile.getStats().levelUpMining(level);
						
						p.sendMessage(StatsUtil.miningActionBarLevelUp(profile));	
					}
					
					displayStats = 0;
				}
				else if (displayStats == 2) {
					
					String foraging = StatsUtil.foragingActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(foraging));
					
					if (profile.getForaging().getCurrentXP() >= profile.getForaging().getMaxXP()) {
						profile.getForaging().levelUp();
						int level = profile.getForaging().getLevel();
						profile.getStats().levelUpForaging(level);
						
						
						p.sendMessage(StatsUtil.foragingActionBarLevelUp(profile));	
					}
					
					displayStats = 0;
				}
				else if (displayStats == 3) {

					String farming = StatsUtil.farmingActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(farming));
					
					if (profile.getFarming().getCurrentXP() >= profile.getFarming().getMaxXP()) {
						profile.getFarming().levelUp();
						int level = profile.getFarming().getLevel();
						profile.getStats().levelUpFarming(level);
						
						p.sendMessage(StatsUtil.farmingActionBarLevelUp(profile));	
					}
					
					displayStats = 0;	
				
			}
				else if (displayStats == 4) {

					String combat = StatsUtil.combatActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(combat));
					
					if (profile.getCombat().getCurrentXP() >= profile.getCombat().getMaxXP()) {
						profile.getCombat().levelUp();
						int level = profile.getCombat().getLevel();
						profile.getStats().levelUpCombat(level);
						
						p.sendMessage(StatsUtil.combatActionBarLevelUp(profile));	
					}
					
					displayStats = 0;
			}
				else if (displayStats == 5) {
					
					String fishing = StatsUtil.fishingActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(fishing));
					
					if (profile.getFishing().getCurrentXP() >= profile.getFishing().getMaxXP()) {
						profile.getFishing().levelUp();
						int level = profile.getFishing().getLevel();
						profile.getStats().levelUpFishing(level);
						
						p.sendMessage(StatsUtil.fishingActionBarLevelUp(profile));	
					}
					
					displayStats = 0;
				}
		}
		}
		}	
		, 40, 20);
	}
	
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(Utils.chat("&cPlugin has been disabled!"));
		
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public PlayerProfileManager getProfileManager() {
		return profileManager;
	}
	
	public void setProfileManager(PlayerProfileManager p) {	
		this.profileManager = p;	
	}

	public int getDisplayStats() {
		return displayStats;
	}

	public void setDisplayStats(int displayStats) {
		this.displayStats = displayStats;
	}


}
	
	
