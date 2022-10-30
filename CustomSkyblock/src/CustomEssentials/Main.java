package CustomEssentials;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
import CustomEssentials.Events.PlayerSkills.Skills;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.ArmorUtils;
import CustomEssentials.Utils.HealthUtils;
import CustomEssentials.Utils.ManaUtils;
import CustomEssentials.Utils.StatsUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin{

	private PlayerProfileManager profileManager;
	private int displayStats = 0;
	private File playerDataFolderLocation;

	
	@Override
	public void onEnable() {
		
		//getServer().getConsoleSender().sendMessage(Utils.chat("&aPlugin has been enabled!"));
		generatePlayerFolder();								
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
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			readPlayerProfile(p);
		}
		
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
				int manaRegen = stats.getManaRegen();
				int TotalMana = stats.getTotalMana();
				
				//Sets item stats
				ItemStats setStats = new ItemStats(p,profileManager);
				setStats.setItemStats();		
				
				if (currentMana < TotalMana) stats.setMana(currentMana+Math.max(manaRegen, 1));
				
								
				String health = HealthUtils.getActionBarHealthText(p);
				String armor = ArmorUtils.getActionBarArmorText(profile);
				String mana = ManaUtils.getActionBarManaText(p,currentMana, TotalMana);
				
				
				
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
		
		savePlayerData();
		getServer().getConsoleSender().sendMessage("Plugin has been disabled!");
		
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

	public void savePlayerData() {
				
		setFolderLocation(this.playerDataFolderLocation);
		writeAllPlayerFile(this.playerDataFolderLocation);

	}
	
	public void writeAllPlayerFile(File directory) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			writePlayerFile(directory,(Player) p);
		}
	}
	
	public void writePlayerFile(File directory, Player player) {
		String FileName = player.getUniqueId().toString();
		String path = directory.getPath();
		File PlayerFile = new File(path + "\\" + FileName + ".yml");
		if (!PlayerFile.exists())
			try {
				PlayerFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		Profile profile = this.getProfileManager().getPlayerProfile(player);
		Stats stats = profile.getStats();
		//IMPLEMENT
		Stats pathStats = profile.getPath().getStats();
		Skills combat = profile.getCombat();
		Skills farming = profile.getFarming();
		Skills fishing = profile.getFishing();
		Skills foraging = profile.getForaging();
		Skills mining = profile.getMining();
		
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(PlayerFile);		
		try {
			playerData.createSection("General");
			playerData.createSection("Stats");
			playerData.createSection("CombatSkill");
			playerData.createSection("FarmingSkill");
			playerData.createSection("FishingSkill");
			playerData.createSection("ForagingSkill");
			playerData.createSection("MiningSkill");
			playerData.createSection("GeneralPath");
			playerData.createSection("TankPath");
			playerData.createSection("ArcherPath");
			playerData.createSection("AssassinPath");
			
			playerData.set("General.PlayTime", profile.getPlayTime());
			playerData.set("Stats.Health", stats.getHealth());
			playerData.set("Stats.Armor", stats.getArmor());
			playerData.set("Stats.MagicResist", stats.getMagicResist());
			playerData.set("Stats.PhysicalDamage", stats.getPhysicalDamage());
			playerData.set("Stats.MagicDamage", stats.getMagicDamage());
			playerData.set("Stats.Mana", stats.getMana());
			playerData.set("Stats.TotalMana", stats.getTotalMana());
			playerData.set("Stats.Speed", stats.getSpeed());
			playerData.set("Stats.Crit_Damage", stats.getCriticalDamage());
			playerData.set("Stats.Crit_Chance", stats.getCriticalChance());
			playerData.set("Stats.Burst_Damage", stats.getBurstDamage());
			playerData.set("Stats.Burst_Chance", stats.getBurstChance());
			playerData.set("Stats.CooldownReduction", stats.getCooldownReduction());
			playerData.set("Stats.LifeSteal", stats.getLifeSteal());
			playerData.set("Stats.ManaRegen", stats.getManaRegen());
			playerData.set("Stats.DefaultHealth", stats.getDefaultHealth());
			playerData.set("Stats.DefaultArmor", stats.getDefaultArmor());
			playerData.set("Stats.DefaultMagicResist", stats.getDefaultMR());
			playerData.set("Stats.DefaultPhysicalDamage", stats.getDefaultPhysicalDamage());
			playerData.set("Stats.DefaultMagicDamage", stats.getDefaultMagicDamage());
			playerData.set("Stats.DefaultMana", stats.getDefaultMana());
			playerData.set("Stats.DefaultSpeed", stats.getDefaultSpeed());
			playerData.set("Stats.DefaultCrit_Damage", stats.getDefaultCritDmg());
			playerData.set("Stats.DefaultCrit_Chance", stats.getDefaultCritChance());
			playerData.set("Stats.DefaultBurst_Damage", stats.getDefaultBurstDmg());
			playerData.set("Stats.DefaultBurst_Chance", stats.getDefaultBurstChance());
			playerData.set("Stats.DefaultCooldownReduction", stats.getDefaultCDR());
			playerData.set("Stats.DefaultLifeSteal", stats.getDefaultLifeSteal());
			playerData.set("Stats.DefaultManaRegen", stats.getDefaultManaRegen());
			
			playerData.set("CombatSkill.level", combat.getLevel());
			playerData.set("FarmingSkill.level", farming.getLevel());
			playerData.set("FishingSkill.level", fishing.getLevel());
			playerData.set("ForagingSkill.level", foraging.getLevel());
			playerData.set("MiningSkill.level", mining.getLevel());
			
			playerData.set("CombatSkill.xp", combat.getCurrentXP());
			playerData.set("FarmingSkill.xp", farming.getCurrentXP());
			playerData.set("FishingSkill.xp", fishing.getCurrentXP());
			playerData.set("ForagingSkill.xp", foraging.getCurrentXP());
			playerData.set("MiningSkill.xp", mining.getCurrentXP());
			
			playerData.set("CombatSkill.MaxXp", combat.getMaxXP());
			playerData.set("FarmingSkill.MaxXp", farming.getMaxXP());
			playerData.set("FishingSkill.MaxXp", fishing.getMaxXP());
			playerData.set("ForagingSkill.MaxXp", foraging.getMaxXP());
			playerData.set("MiningSkill.MaxXp", mining.getMaxXP());
			
			//CURRENT PATH
			playerData.set("GeneralPath.Name", profile.getPath().getName());
			playerData.set("GeneralPath.level", profile.getPath().getLevel());
			playerData.set("GeneralPath.xp", profile.getPath().getCurrentXP());
			playerData.set("GeneralPath.MaxXp", profile.getPath().getMaxXP());
			playerData.set("GeneralPath.prestige", profile.getPath().getPrestige());
			playerData.set("GeneralPath.Health", pathStats.getHealth());
			playerData.set("GeneralPath.Armor", pathStats.getArmor());
			playerData.set("GeneralPath.MagicResist", pathStats.getMagicResist());
			playerData.set("GeneralPath.PhysicalDamage", pathStats.getPhysicalDamage());
			playerData.set("GeneralPath.MagicDamage", pathStats.getMagicDamage());
			playerData.set("GeneralPath.Mana", pathStats.getMana());
			playerData.set("GeneralPath.TotalMana", pathStats.getTotalMana());
			playerData.set("GeneralPath.Speed", pathStats.getSpeed());
			playerData.set("GeneralPath.Crit_Damage", pathStats.getCriticalDamage());
			playerData.set("GeneralPath.Crit_Chance", pathStats.getCriticalChance());
			playerData.set("GeneralPath.Burst_Damage", pathStats.getBurstDamage());
			playerData.set("GeneralPath.Burst_Chance", pathStats.getBurstChance());
			playerData.set("GeneralPath.CooldownReduction", pathStats.getCooldownReduction());
			playerData.set("GeneralPath.LifeSteal", pathStats.getLifeSteal());
			playerData.set("GeneralPath.ManaRegen", pathStats.getManaRegen());
			playerData.set("GeneralPath.DefaultHealth", pathStats.getDefaultHealth());
			playerData.set("GeneralPath.DefaultArmor", pathStats.getDefaultArmor());
			playerData.set("GeneralPath.DefaultMagicResist", pathStats.getDefaultMR());
			playerData.set("GeneralPath.DefaultPhysicalDamage", pathStats.getDefaultPhysicalDamage());
			playerData.set("GeneralPath.DefaultMagicDamage", pathStats.getDefaultMagicDamage());
			playerData.set("GeneralPath.DefaultMana", pathStats.getDefaultMana());
			playerData.set("GeneralPath.DefaultSpeed", pathStats.getDefaultSpeed());
			playerData.set("GeneralPath.DefaultCrit_Damage", pathStats.getDefaultCritDmg());
			playerData.set("GeneralPath.DefaultCrit_Chance", pathStats.getDefaultCritChance());
			playerData.set("GeneralPath.DefaultBurst_Damage", pathStats.getDefaultBurstDmg());
			playerData.set("GeneralPath.DefaultBurst_Chance", pathStats.getDefaultBurstChance());
			playerData.set("GeneralPath.DefaultCooldownReduction", pathStats.getDefaultCDR());
			playerData.set("GeneralPath.DefaultLifeSteal", pathStats.getDefaultLifeSteal());
			playerData.set("GeneralPath.DefaultManaRegen", pathStats.getDefaultManaRegen());
			
			Path tankPath = profile.getPaths().get("tank");	
			Stats tankStats = tankPath.getStats();
			//TANK PATH
			playerData.set("TankPath.Name", tankPath.getName());
			playerData.set("TankPath.level", tankPath.getLevel());
			playerData.set("TankPath.xp",tankPath.getCurrentXP());
			playerData.set("TankPath.MaxXp", tankPath.getMaxXP());
			playerData.set("TankPath.prestige", tankPath.getPrestige());
			playerData.set("TankPath.Health", tankStats.getHealth());
			playerData.set("TankPath.Armor", tankStats.getArmor());
			playerData.set("TankPath.MagicResist", tankStats.getMagicResist());
			playerData.set("TankPath.PhysicalDamage", tankStats.getPhysicalDamage());
			playerData.set("TankPath.MagicDamage", tankStats.getMagicDamage());
			playerData.set("TankPath.Mana", tankStats.getMana());
			playerData.set("TankPath.TotalMana", tankStats.getTotalMana());
			playerData.set("TankPath.Speed", tankStats.getSpeed());
			playerData.set("TankPath.Crit_Damage", tankStats.getCriticalDamage());
			playerData.set("TankPath.Crit_Chance", tankStats.getCriticalChance());
			playerData.set("TankPath.Burst_Damage", tankStats.getBurstDamage());
			playerData.set("TankPath.Burst_Chance", tankStats.getBurstChance());
			playerData.set("TankPath.CooldownReduction", tankStats.getCooldownReduction());
			playerData.set("TankPath.LifeSteal", tankStats.getLifeSteal());
			playerData.set("TankPath.ManaRegen", tankStats.getManaRegen());
			playerData.set("TankPath.DefaultHealth", tankStats.getDefaultHealth());
			playerData.set("TankPath.DefaultArmor", tankStats.getDefaultArmor());
			playerData.set("TankPath.DefaultMagicResist", tankStats.getDefaultMR());
			playerData.set("TankPath.DefaultPhysicalDamage", tankStats.getDefaultPhysicalDamage());
			playerData.set("TankPath.DefaultMagicDamage", tankStats.getDefaultMagicDamage());
			playerData.set("TankPath.DefaultMana", tankStats.getDefaultMana());
			playerData.set("TankPath.DefaultSpeed", tankStats.getDefaultSpeed());
			playerData.set("TankPath.DefaultCrit_Damage", tankStats.getDefaultCritDmg());
			playerData.set("TankPath.DefaultCrit_Chance", tankStats.getDefaultCritChance());
			playerData.set("TankPath.DefaultBurst_Damage", tankStats.getDefaultBurstDmg());
			playerData.set("TankPath.DefaultBurst_Chance", tankStats.getDefaultBurstChance());
			playerData.set("TankPath.DefaultCooldownReduction", tankStats.getDefaultCDR());
			playerData.set("TankPath.DefaultLifeSteal", tankStats.getDefaultLifeSteal());
			playerData.set("TankPath.DefaultManaRegen", tankStats.getDefaultManaRegen());
			
			Path archerPath = profile.getPaths().get("archer");	
			Stats archerStats = archerPath.getStats();
			//ARCHER PATH
			playerData.set("ArcherPath.Name", archerPath.getName());
			playerData.set("ArcherPath.level", archerPath.getLevel());
			playerData.set("ArcherPath.xp",archerPath.getCurrentXP());
			playerData.set("ArcherPath.MaxXp", archerPath.getMaxXP());
			playerData.set("ArcherPath.prestige", archerPath.getPrestige());
			playerData.set("ArcherPath.Health", archerStats.getHealth());
			playerData.set("ArcherPath.Armor", archerStats.getArmor());
			playerData.set("ArcherPath.MagicResist", archerStats.getMagicResist());
			playerData.set("ArcherPath.PhysicalDamage", archerStats.getPhysicalDamage());
			playerData.set("ArcherPath.MagicDamage", archerStats.getMagicDamage());
			playerData.set("ArcherPath.Mana", archerStats.getMana());
			playerData.set("ArcherPath.TotalMana", archerStats.getTotalMana());
			playerData.set("ArcherPath.Speed", archerStats.getSpeed());
			playerData.set("ArcherPath.Crit_Damage", archerStats.getCriticalDamage());
			playerData.set("ArcherPath.Crit_Chance", archerStats.getCriticalChance());
			playerData.set("ArcherPath.Burst_Damage", archerStats.getBurstDamage());
			playerData.set("ArcherPath.Burst_Chance", archerStats.getBurstChance());
			playerData.set("ArcherPath.CooldownReduction", archerStats.getCooldownReduction());
			playerData.set("ArcherPath.LifeSteal", archerStats.getLifeSteal());
			playerData.set("ArcherPath.ManaRegen", archerStats.getManaRegen());
			playerData.set("ArcherPath.DefaultHealth", archerStats.getDefaultHealth());
			playerData.set("ArcherPath.DefaultArmor", archerStats.getDefaultArmor());
			playerData.set("ArcherPath.DefaultMagicResist", archerStats.getDefaultMR());
			playerData.set("ArcherPath.DefaultPhysicalDamage", archerStats.getDefaultPhysicalDamage());
			playerData.set("ArcherPath.DefaultMagicDamage", archerStats.getDefaultMagicDamage());
			playerData.set("ArcherPath.DefaultMana", archerStats.getDefaultMana());
			playerData.set("ArcherPath.DefaultSpeed", archerStats.getDefaultSpeed());
			playerData.set("ArcherPath.DefaultCrit_Damage", archerStats.getDefaultCritDmg());
			playerData.set("ArcherPath.DefaultCrit_Chance", archerStats.getDefaultCritChance());
			playerData.set("ArcherPath.DefaultBurst_Damage", archerStats.getDefaultBurstDmg());
			playerData.set("ArcherPath.DefaultBurst_Chance", archerStats.getDefaultBurstChance());
			playerData.set("ArcherPath.DefaultCooldownReduction", archerStats.getDefaultCDR());
			playerData.set("ArcherPath.DefaultLifeSteal", archerStats.getDefaultLifeSteal());
			playerData.set("ArcherPath.DefaultManaRegen", archerStats.getDefaultManaRegen());
			
			Path assassinPath = profile.getPaths().get("assassin");	
			Stats assassinStats = assassinPath.getStats();
			//ARCHER PATH
			playerData.set("AssassinPath.Name", assassinPath.getName());
			playerData.set("AssassinPath.level", assassinPath.getLevel());
			playerData.set("AssassinPath.xp",assassinPath.getCurrentXP());
			playerData.set("AssassinPath.MaxXp", assassinPath.getMaxXP());
			playerData.set("AssassinPath.prestige", assassinPath.getPrestige());
			playerData.set("AssassinPath.Health", assassinStats.getHealth());
			playerData.set("AssassinPath.Armor", assassinStats.getArmor());
			playerData.set("AssassinPath.MagicResist", assassinStats.getMagicResist());
			playerData.set("AssassinPath.PhysicalDamage", assassinStats.getPhysicalDamage());
			playerData.set("AssassinPath.MagicDamage", assassinStats.getMagicDamage());
			playerData.set("AssassinPath.Mana", assassinStats.getMana());
			playerData.set("AssassinPath.TotalMana", assassinStats.getTotalMana());
			playerData.set("AssassinPath.Speed", assassinStats.getSpeed());
			playerData.set("AssassinPath.Crit_Damage", assassinStats.getCriticalDamage());
			playerData.set("AssassinPath.Crit_Chance", assassinStats.getCriticalChance());
			playerData.set("AssassinPath.Burst_Damage", assassinStats.getBurstDamage());
			playerData.set("AssassinPath.Burst_Chance", assassinStats.getBurstChance());
			playerData.set("AssassinPath.CooldownReduction", assassinStats.getCooldownReduction());
			playerData.set("AssassinPath.LifeSteal", assassinStats.getLifeSteal());
			playerData.set("AssassinPath.ManaRegen", assassinStats.getManaRegen());
			playerData.set("AssassinPath.DefaultHealth", assassinStats.getDefaultHealth());
			playerData.set("AssassinPath.DefaultArmor", assassinStats.getDefaultArmor());
			playerData.set("AssassinPath.DefaultMagicResist", assassinStats.getDefaultMR());
			playerData.set("AssassinPath.DefaultPhysicalDamage", assassinStats.getDefaultPhysicalDamage());
			playerData.set("AssassinPath.DefaultMagicDamage", assassinStats.getDefaultMagicDamage());
			playerData.set("AssassinPath.DefaultMana", assassinStats.getDefaultMana());
			playerData.set("AssassinPath.DefaultSpeed", assassinStats.getDefaultSpeed());
			playerData.set("AssassinPath.DefaultCrit_Damage", assassinStats.getDefaultCritDmg());
			playerData.set("AssassinPath.DefaultCrit_Chance", assassinStats.getDefaultCritChance());
			playerData.set("AssassinPath.DefaultBurst_Damage", assassinStats.getDefaultBurstDmg());
			playerData.set("AssassinPath.DefaultBurst_Chance", assassinStats.getDefaultBurstChance());
			playerData.set("AssassinPath.DefaultCooldownReduction", assassinStats.getDefaultCDR());
			playerData.set("AssassinPath.DefaultLifeSteal", assassinStats.getDefaultLifeSteal());
			playerData.set("AssassinPath.DefaultManaRegen", assassinStats.getDefaultManaRegen());
						
			
			playerData.save(PlayerFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generatePlayerFolder() {
		String path = this.getDataFolder().getPath();
		File directory = new File(path.concat("\\PlayerData"));
		if (!directory.exists()) directory.mkdir();
		
		setFolderLocation(directory);
	}
	
	public Boolean containsPlayerData(Player p) {
		String FileName = p.getUniqueId().toString();
		String path = this.getFolderLocation().getPath();
		
		File PlayerFile = new File(path + "\\" + FileName + ".yml");
		if (!PlayerFile.exists()) return false;
					
		return true;
	}

	public void readPlayerProfile(Player p) {
		
		if (!containsPlayerData(p)) return;
		
		String FileName = p.getUniqueId().toString();
		String path = this.getFolderLocation().getPath();
		File PlayerFile = new File(path + "\\" + FileName + ".yml");
		
		PlayerProfileManager profiles = this.getProfileManager();
		if (!profiles.hasProfile(p)) {
			profiles.createPlayerProfile(p);
		}
		
		Profile playerProfile = profiles.getPlayerProfile(p);
		Stats stats =  playerProfile.getStats();
		
		Skills combat = playerProfile.getCombat();
		Skills farming = playerProfile.getFarming();
		Skills fishing = playerProfile.getFishing();
		Skills foraging = playerProfile.getForaging();
		Skills mining = playerProfile.getMining();
		
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(PlayerFile);
		
		playerProfile.setPlayTime(playerData.getInt("General.PlayTime"));
		stats.setHealth(playerData.getInt("Stats.Health"));
		stats.setArmor(playerData.getInt("Stats.Armor"));
		stats.setMagicResist(playerData.getInt("Stats.MagicResist"));
		stats.setPhysicalDamage(playerData.getInt("Stats.PhysicalDamage"));
		stats.setMagicDamage(playerData.getInt("Stats.MagicDamage"));
		stats.setMana(playerData.getInt("Stats.Mana"));
		stats.setTotalMana(playerData.getInt("Stats.TotalMana"));
		stats.setSpeed((double) playerData.getInt("Stats.Speed"));
		stats.setCriticalDamage((double) playerData.get("Stats.Crit_Damage"));
		stats.setCriticalChance((double) playerData.get("Stats.Crit_Chance"));
		stats.setBurstDamage((double) playerData.get("Stats.Burst_Damage"));
		stats.setBurstChance((double) playerData.get("Stats.Burst_Chance"));
		stats.setCooldownReduction(playerData.getInt("Stats.CooldownReduction"));
		stats.setLifeSteal((double) playerData.get("Stats.LifeSteal"));
		stats.setManaRegen(playerData.getInt("Stats.ManaRegen"));
		
		stats.setDefaultHealth(playerData.getInt("Stats.DefaultHealth"));
		stats.setDefaultArmor(playerData.getInt("Stats.DefaultArmor"));
		stats.setDefaultMR(playerData.getInt("Stats.DefaultMagicResist"));
		stats.setDefaultPhysicalDamage(playerData.getInt("Stats.DefaultPhysicalDamage"));
		stats.setDefaultMagicDamage(playerData.getInt("Stats.DefaultMagicDamage"));
		stats.setDefaultMana(playerData.getInt("Stats.DefaultMana"));
		stats.setDefaultSpeed(playerData.getInt("Stats.DefaultSpeed"));
		stats.setDefaultCritDmg((double) playerData.get("Stats.DefaultCrit_Damage"));
		stats.setDefaultCritChance((double) playerData.get("Stats.DefaultCrit_Chance"));
		stats.setDefaultBurstDmg((double) playerData.get("Stats.DefaultBurst_Damage"));
		stats.setDefaultBurstChance((double) playerData.get("Stats.DefaultBurst_Chance"));
		stats.setDefaultCDR(playerData.getInt("Stats.DefaultCooldownReduction"));
		stats.setDefaultLifeSteal((double) playerData.get("Stats.DefaultLifeSteal"));
		stats.setDefaultManaRegen(playerData.getInt("Stats.DefaultManaRegen"));
		
		combat.setLevel(playerData.getInt("CombatSkill.level"));
		farming.setLevel(playerData.getInt("FarmingSkill.level"));
		fishing.setLevel(playerData.getInt("FishingSkill.level"));
		foraging.setLevel(playerData.getInt("ForagingSkill.level"));
		mining.setLevel(playerData.getInt("MiningSkill.level"));
		
		combat.setCurrentXP((Double) playerData.get("CombatSkill.xp"));
		farming.setCurrentXP((Double) playerData.get("FarmingSkill.xp"));
		fishing.setCurrentXP((Double) playerData.get("FishingSkill.xp"));
		foraging.setCurrentXP((Double) playerData.get("ForagingSkill.xp"));
		mining.setCurrentXP((Double) playerData.get("MiningSkill.xp"));
		
		combat.setMaxXP((Double) playerData.get("CombatSkill.MaxXp"));
		farming.setMaxXP((Double) playerData.get("FarmingSkill.MaxXp"));
		fishing.setMaxXP((Double) playerData.get("FishingSkill.MaxXp"));
		foraging.setMaxXP((Double) playerData.get("ForagingSkill.MaxXp"));
		mining.setMaxXP((Double) playerData.get("MiningSkill.MaxXp"));
		
		//GENERAL PATH
		playerProfile.setPath(playerProfile.getPaths().get(playerData.get("GeneralPath.Name")));
		Path playerPath = playerProfile.getPath();
		Stats pathStats = playerPath.getStats();
		
		playerPath.setLevel(playerData.getInt("GeneralPath.level"));
		playerPath.setCurrentXP((Double) playerData.get("GeneralPath.xp"));
		playerPath.setMaxXP((Double) playerData.get("GeneralPath.MaxXp"));
		playerPath.setPrestige(playerData.getInt("GeneralPath.prestige"));
		pathStats.setHealth(playerData.getInt("GeneralPath.Health"));
		pathStats.setArmor(playerData.getInt("GeneralPath.Armor"));
		pathStats.setMagicResist(playerData.getInt("GeneralPath.MagicResist"));
		pathStats.setPhysicalDamage(playerData.getInt("GeneralPath.PhysicalDamage"));
		pathStats.setMagicDamage(playerData.getInt("GeneralPath.MagicDamage"));
		pathStats.setMana(playerData.getInt("GeneralPath.Mana"));
		pathStats.setTotalMana(playerData.getInt("GeneralPath.TotalMana"));
		pathStats.setSpeed((double) playerData.getInt("GeneralPath.Speed"));
		pathStats.setCriticalDamage((double) playerData.get("GeneralPath.Crit_Damage"));
		pathStats.setCriticalChance((double) playerData.get("GeneralPath.Crit_Chance"));
		pathStats.setBurstDamage((double) playerData.get("GeneralPath.Burst_Damage"));
		pathStats.setBurstChance((double) playerData.get("GeneralPath.Burst_Chance"));
		pathStats.setCooldownReduction(playerData.getInt("GeneralPath.CooldownReduction"));
		pathStats.setLifeSteal((double) playerData.get("GeneralPath.LifeSteal"));
		pathStats.setManaRegen(playerData.getInt("GeneralPath.ManaRegen"));
		
		pathStats.setDefaultHealth(playerData.getInt("GeneralPath.DefaultHealth"));
		pathStats.setDefaultArmor(playerData.getInt("GeneralPath.DefaultArmor"));
		pathStats.setDefaultMR(playerData.getInt("GeneralPath.DefaultMagicResist"));
		pathStats.setDefaultPhysicalDamage(playerData.getInt("GeneralPath.DefaultPhysicalDamage"));
		pathStats.setDefaultMagicDamage(playerData.getInt("GeneralPath.DefaultMagicDamage"));
		pathStats.setDefaultMana(playerData.getInt("GeneralPath.DefaultMana"));
		pathStats.setDefaultSpeed(playerData.getInt("GeneralPath.DefaultSpeed"));
		pathStats.setDefaultCritDmg((double) playerData.get("GeneralPath.DefaultCrit_Damage"));
		pathStats.setDefaultCritChance((double) playerData.get("GeneralPath.DefaultCrit_Chance"));
		pathStats.setDefaultBurstDmg((double) playerData.get("GeneralPath.DefaultBurst_Damage"));
		pathStats.setDefaultBurstChance((double) playerData.get("GeneralPath.DefaultBurst_Chance"));
		pathStats.setDefaultCDR(playerData.getInt("GeneralPath.DefaultCooldownReduction"));
		pathStats.setDefaultLifeSteal((double) playerData.get("GeneralPath.DefaultLifeSteal"));
		pathStats.setDefaultManaRegen(playerData.getInt("GeneralPath.DefaultManaRegen"));

		//TANK PATH
		Path tankPath = playerProfile.getPaths().get("tank");
		Stats tankStats = tankPath.getStats();
		
		tankPath.setLevel(playerData.getInt("TankPath.level"));
		tankPath.setCurrentXP((Double) playerData.get("TankPath.xp"));
		tankPath.setMaxXP((Double) playerData.get("TankPath.MaxXp"));
		tankPath.setPrestige(playerData.getInt("TankPath.prestige"));
		tankStats.setHealth(playerData.getInt("TankPath.Health"));
		tankStats.setArmor(playerData.getInt("TankPath.Armor"));
		tankStats.setMagicResist(playerData.getInt("TankPath.MagicResist"));
		tankStats.setPhysicalDamage(playerData.getInt("TankPath.PhysicalDamage"));
		tankStats.setMagicDamage(playerData.getInt("TankPath.MagicDamage"));
		tankStats.setMana(playerData.getInt("TankPath.Mana"));
		tankStats.setTotalMana(playerData.getInt("TankPath.TotalMana"));
		tankStats.setSpeed((double) playerData.getInt("TankPath.Speed"));
		tankStats.setCriticalDamage((double) playerData.get("TankPath.Crit_Damage"));
		tankStats.setCriticalChance((double) playerData.get("TankPath.Crit_Chance"));
		tankStats.setBurstDamage((double) playerData.get("TankPath.Burst_Damage"));
		tankStats.setBurstChance((double) playerData.get("TankPath.Burst_Chance"));
		tankStats.setCooldownReduction(playerData.getInt("TankPath.CooldownReduction"));
		tankStats.setLifeSteal((double) playerData.get("TankPath.LifeSteal"));
		tankStats.setManaRegen(playerData.getInt("TankPath.ManaRegen"));
		
		tankStats.setDefaultHealth(playerData.getInt("TankPath.DefaultHealth"));
		tankStats.setDefaultArmor(playerData.getInt("TankPath.DefaultArmor"));
		tankStats.setDefaultMR(playerData.getInt("TankPath.DefaultMagicResist"));
		tankStats.setDefaultPhysicalDamage(playerData.getInt("TankPath.DefaultPhysicalDamage"));
		tankStats.setDefaultMagicDamage(playerData.getInt("TankPath.DefaultMagicDamage"));
		tankStats.setDefaultMana(playerData.getInt("TankPath.DefaultMana"));
		tankStats.setDefaultSpeed(playerData.getInt("TankPath.DefaultSpeed"));
		tankStats.setDefaultCritDmg((double) playerData.get("TankPath.DefaultCrit_Damage"));
		tankStats.setDefaultCritChance((double) playerData.get("TankPath.DefaultCrit_Chance"));
		tankStats.setDefaultBurstDmg((double) playerData.get("TankPath.DefaultBurst_Damage"));
		tankStats.setDefaultBurstChance((double) playerData.get("TankPath.DefaultBurst_Chance"));
		tankStats.setDefaultCDR(playerData.getInt("TankPath.DefaultCooldownReduction"));
		tankStats.setDefaultLifeSteal((double) playerData.get("TankPath.DefaultLifeSteal"));
		tankStats.setDefaultManaRegen(playerData.getInt("TankPath.DefaultManaRegen"));
		
		//ARCHER PATH
		Path archerPath = playerProfile.getPaths().get("archer");
		Stats archerStats = archerPath.getStats();
		
		archerPath.setLevel(playerData.getInt("ArcherPath.level"));
		archerPath.setCurrentXP((Double) playerData.get("ArcherPath.xp"));
		archerPath.setMaxXP((Double) playerData.get("ArcherPath.MaxXp"));
		archerPath.setPrestige(playerData.getInt("ArcherPath.prestige"));
		archerStats.setHealth(playerData.getInt("ArcherPath.Health"));
		archerStats.setArmor(playerData.getInt("ArcherPath.Armor"));
		archerStats.setMagicResist(playerData.getInt("ArcherPath.MagicResist"));
		archerStats.setPhysicalDamage(playerData.getInt("ArcherPath.PhysicalDamage"));
		archerStats.setMagicDamage(playerData.getInt("ArcherPath.MagicDamage"));
		archerStats.setMana(playerData.getInt("ArcherPath.Mana"));
		archerStats.setTotalMana(playerData.getInt("ArcherPath.TotalMana"));
		archerStats.setSpeed((double) playerData.getInt("ArcherPath.Speed"));
		archerStats.setCriticalDamage((double) playerData.get("ArcherPath.Crit_Damage"));
		archerStats.setCriticalChance((double) playerData.get("ArcherPath.Crit_Chance"));
		archerStats.setBurstDamage((double) playerData.get("ArcherPath.Burst_Damage"));
		archerStats.setBurstChance((double) playerData.get("ArcherPath.Burst_Chance"));
		archerStats.setCooldownReduction(playerData.getInt("ArcherPath.CooldownReduction"));
		archerStats.setLifeSteal((double) playerData.get("ArcherPath.LifeSteal"));
		archerStats.setManaRegen(playerData.getInt("ArcherPath.ManaRegen"));
		
		archerStats.setDefaultHealth(playerData.getInt("ArcherPath.DefaultHealth"));
		archerStats.setDefaultArmor(playerData.getInt("ArcherPath.DefaultArmor"));
		archerStats.setDefaultMR(playerData.getInt("ArcherPath.DefaultMagicResist"));
		archerStats.setDefaultPhysicalDamage(playerData.getInt("ArcherPath.DefaultPhysicalDamage"));
		archerStats.setDefaultMagicDamage(playerData.getInt("ArcherPath.DefaultMagicDamage"));
		archerStats.setDefaultMana(playerData.getInt("ArcherPath.DefaultMana"));
		archerStats.setDefaultSpeed(playerData.getInt("ArcherPath.DefaultSpeed"));
		archerStats.setDefaultCritDmg((double) playerData.get("ArcherPath.DefaultCrit_Damage"));
		archerStats.setDefaultCritChance((double) playerData.get("ArcherPath.DefaultCrit_Chance"));
		archerStats.setDefaultBurstDmg((double) playerData.get("ArcherPath.DefaultBurst_Damage"));
		archerStats.setDefaultBurstChance((double) playerData.get("ArcherPath.DefaultBurst_Chance"));
		archerStats.setDefaultCDR(playerData.getInt("ArcherPath.DefaultCooldownReduction"));
		archerStats.setDefaultLifeSteal((double) playerData.get("ArcherPath.DefaultLifeSteal"));
		archerStats.setDefaultManaRegen(playerData.getInt("ArcherPath.DefaultManaRegen"));
		
		//ASSASSIN PATH
		Path assassinPath = playerProfile.getPaths().get("assassin");
		Stats assassinStats = assassinPath.getStats();
		
		assassinPath.setLevel(playerData.getInt("AssassinPath.level"));
		assassinPath.setCurrentXP((Double) playerData.get("AssassinPath.xp"));
		assassinPath.setMaxXP((Double) playerData.get("AssassinPath.MaxXp"));
		assassinPath.setPrestige(playerData.getInt("AssassinPath.prestige"));
		assassinStats.setHealth(playerData.getInt("AssassinPath.Health"));
		assassinStats.setArmor(playerData.getInt("AssassinPath.Armor"));
		assassinStats.setMagicResist(playerData.getInt("AssassinPath.MagicResist"));
		assassinStats.setPhysicalDamage(playerData.getInt("AssassinPath.PhysicalDamage"));
		assassinStats.setMagicDamage(playerData.getInt("AssassinPath.MagicDamage"));
		assassinStats.setMana(playerData.getInt("AssassinPath.Mana"));
		assassinStats.setTotalMana(playerData.getInt("AssassinPath.TotalMana"));
		assassinStats.setSpeed((double) playerData.getInt("AssassinPath.Speed"));
		assassinStats.setCriticalDamage((double) playerData.get("AssassinPath.Crit_Damage"));
		assassinStats.setCriticalChance((double) playerData.get("AssassinPath.Crit_Chance"));
		assassinStats.setBurstDamage((double) playerData.get("AssassinPath.Burst_Damage"));
		assassinStats.setBurstChance((double) playerData.get("AssassinPath.Burst_Chance"));
		assassinStats.setCooldownReduction(playerData.getInt("AssassinPath.CooldownReduction"));
		assassinStats.setLifeSteal((double) playerData.get("AssassinPath.LifeSteal"));
		assassinStats.setManaRegen(playerData.getInt("AssassinPath.ManaRegen"));
		
		assassinStats.setDefaultHealth(playerData.getInt("AssassinPath.DefaultHealth"));
		assassinStats.setDefaultArmor(playerData.getInt("AssassinPath.DefaultArmor"));
		assassinStats.setDefaultMR(playerData.getInt("AssassinPath.DefaultMagicResist"));
		assassinStats.setDefaultPhysicalDamage(playerData.getInt("AssassinPath.DefaultPhysicalDamage"));
		assassinStats.setDefaultMagicDamage(playerData.getInt("AssassinPath.DefaultMagicDamage"));
		assassinStats.setDefaultMana(playerData.getInt("AssassinPath.DefaultMana"));
		assassinStats.setDefaultSpeed(playerData.getInt("AssassinPath.DefaultSpeed"));
		assassinStats.setDefaultCritDmg((double) playerData.get("AssassinPath.DefaultCrit_Damage"));
		assassinStats.setDefaultCritChance((double) playerData.get("AssassinPath.DefaultCrit_Chance"));
		assassinStats.setDefaultBurstDmg((double) playerData.get("AssassinPath.DefaultBurst_Damage"));
		assassinStats.setDefaultBurstChance((double) playerData.get("AssassinPath.DefaultBurst_Chance"));
		assassinStats.setDefaultCDR(playerData.getInt("AssassinPath.DefaultCooldownReduction"));
		assassinStats.setDefaultLifeSteal((double) playerData.get("AssassinPath.DefaultLifeSteal"));
		assassinStats.setDefaultManaRegen(playerData.getInt("AssassinPath.DefaultManaRegen"));
		
		
	}
	
	public File getFolderLocation() {
		return playerDataFolderLocation;
	}


	public void setFolderLocation(File folderLocation) {
		this.playerDataFolderLocation = folderLocation;
	}
	

}
	
	
