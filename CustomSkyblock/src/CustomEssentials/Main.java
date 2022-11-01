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
import CustomEssentials.Commands.PlayerEconomy.BalanceCommand;
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
		new BalanceCommand(this);
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
			playerData.set("General.Balance", profile.getBalance());
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
			setPathStats(profile.getPath(),"GeneralPath",playerData);
			
			Path tankPath = profile.getPaths().get("tank");	
			//TANK PATH
			setPathStats(tankPath,"TankPath",playerData);
			
			Path archerPath = profile.getPaths().get("archer");	
			//ARCHER PATH			
			setPathStats(archerPath,"ArcherPath",playerData);
			
			Path assassinPath = profile.getPaths().get("assassin");	
			//ASSASSIN PATH
			setPathStats(assassinPath,"AssassinPath",playerData);
						
			
			playerData.save(PlayerFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void setPathStats(Path path, String storedPathName, FileConfiguration playerData) {
		Stats pathStats = path.getStats();
		
		playerData.set(storedPathName + ".Name", path.getName());
		playerData.set(storedPathName + ".level", path.getLevel());
		playerData.set(storedPathName + ".xp",path.getCurrentXP());
		playerData.set(storedPathName + ".MaxXp", path.getMaxXP());
		playerData.set(storedPathName + ".prestige", path.getPrestige());
		playerData.set(storedPathName + ".Health", pathStats.getHealth());
		playerData.set(storedPathName + ".Armor", pathStats.getArmor());
		playerData.set(storedPathName + ".MagicResist", pathStats.getMagicResist());
		playerData.set(storedPathName + ".PhysicalDamage", pathStats.getPhysicalDamage());
		playerData.set(storedPathName + ".MagicDamage", pathStats.getMagicDamage());
		playerData.set(storedPathName + ".Mana", pathStats.getMana());
		playerData.set(storedPathName + ".TotalMana", pathStats.getTotalMana());
		playerData.set(storedPathName + ".Speed", pathStats.getSpeed());
		playerData.set(storedPathName + ".Crit_Damage", pathStats.getCriticalDamage());
		playerData.set(storedPathName + ".Crit_Chance", pathStats.getCriticalChance());
		playerData.set(storedPathName + ".Burst_Damage", pathStats.getBurstDamage());
		playerData.set(storedPathName + ".Burst_Chance", pathStats.getBurstChance());
		playerData.set(storedPathName + ".CooldownReduction", pathStats.getCooldownReduction());
		playerData.set(storedPathName + ".LifeSteal", pathStats.getLifeSteal());
		playerData.set(storedPathName + ".ManaRegen", pathStats.getManaRegen());
		playerData.set(storedPathName + ".DefaultHealth", pathStats.getDefaultHealth());
		playerData.set(storedPathName + ".DefaultArmor", pathStats.getDefaultArmor());
		playerData.set(storedPathName + ".DefaultMagicResist", pathStats.getDefaultMR());
		playerData.set(storedPathName + ".DefaultPhysicalDamage", pathStats.getDefaultPhysicalDamage());
		playerData.set(storedPathName + ".DefaultMagicDamage", pathStats.getDefaultMagicDamage());
		playerData.set(storedPathName + ".DefaultMana", pathStats.getDefaultMana());
		playerData.set(storedPathName + ".DefaultSpeed", pathStats.getDefaultSpeed());
		playerData.set(storedPathName + ".DefaultCrit_Damage", pathStats.getDefaultCritDmg());
		playerData.set(storedPathName + ".DefaultCrit_Chance", pathStats.getDefaultCritChance());
		playerData.set(storedPathName + ".DefaultBurst_Damage", pathStats.getDefaultBurstDmg());
		playerData.set(storedPathName + ".DefaultBurst_Chance", pathStats.getDefaultBurstChance());
		playerData.set(storedPathName + ".DefaultCooldownReduction", pathStats.getDefaultCDR());
		playerData.set(storedPathName + ".DefaultLifeSteal", pathStats.getDefaultLifeSteal());
		playerData.set(storedPathName + ".DefaultManaRegen", pathStats.getDefaultManaRegen());
		
		
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
		playerProfile.setBalance(playerData.getInt("General.Balance"));
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
		
		playerPath.setLevel(playerData.getInt("GeneralPath.level"));
		playerPath.setCurrentXP((Double) playerData.get("GeneralPath.xp"));
		playerPath.setMaxXP((Double) playerData.get("GeneralPath.MaxXp"));
		playerPath.setPrestige(playerData.getInt("GeneralPath.prestige"));
		
		getPathStats(playerPath,"GeneralPath",playerData);
		
		//TANK PATH
		Path tankPath = playerProfile.getPaths().get("tank");
		
		getPathStats(tankPath,"TankPath",playerData);
				
		//ARCHER PATH
		Path archerPath = playerProfile.getPaths().get("archer");
		
		getPathStats(archerPath,"ArcherPath",playerData);
		
		
		//ASSASSIN PATH
		Path assassinPath = playerProfile.getPaths().get("assassin");
		
		getPathStats(assassinPath,"AssassinPath",playerData);
		
	}
	
	
	public void getPathStats(Path path, String storedPathName, FileConfiguration playerData) {
		Stats pathStats = path.getStats();
		
		path.setLevel(playerData.getInt(storedPathName + ".level"));
		path.setCurrentXP((Double) playerData.get(storedPathName + ".xp"));
		path.setMaxXP((Double) playerData.get(storedPathName + ".MaxXp"));
		path.setPrestige(playerData.getInt(storedPathName + ".prestige"));
		pathStats.setHealth(playerData.getInt(storedPathName + ".Health"));
		pathStats.setArmor(playerData.getInt(storedPathName + ".Armor"));
		pathStats.setMagicResist(playerData.getInt(storedPathName + ".MagicResist"));
		pathStats.setPhysicalDamage(playerData.getInt(storedPathName + ".PhysicalDamage"));
		pathStats.setMagicDamage(playerData.getInt(storedPathName + ".MagicDamage"));
		pathStats.setMana(playerData.getInt(storedPathName + ".Mana"));
		pathStats.setTotalMana(playerData.getInt(storedPathName + ".TotalMana"));
		pathStats.setSpeed((double) playerData.getInt(storedPathName + ".Speed"));
		pathStats.setCriticalDamage((double) playerData.get(storedPathName + ".Crit_Damage"));
		pathStats.setCriticalChance((double) playerData.get(storedPathName + ".Crit_Chance"));
		pathStats.setBurstDamage((double) playerData.get(storedPathName + ".Burst_Damage"));
		pathStats.setBurstChance((double) playerData.get(storedPathName + ".Burst_Chance"));
		pathStats.setCooldownReduction(playerData.getInt(storedPathName + ".CooldownReduction"));
		pathStats.setLifeSteal((double) playerData.get(storedPathName + ".LifeSteal"));
		pathStats.setManaRegen(playerData.getInt(storedPathName + ".ManaRegen"));
		
		pathStats.setDefaultHealth(playerData.getInt(storedPathName + ".DefaultHealth"));
		pathStats.setDefaultArmor(playerData.getInt(storedPathName + ".DefaultArmor"));
		pathStats.setDefaultMR(playerData.getInt(storedPathName + ".DefaultMagicResist"));
		pathStats.setDefaultPhysicalDamage(playerData.getInt(storedPathName + ".DefaultPhysicalDamage"));
		pathStats.setDefaultMagicDamage(playerData.getInt(storedPathName + ".DefaultMagicDamage"));
		pathStats.setDefaultMana(playerData.getInt(storedPathName + ".DefaultMana"));
		pathStats.setDefaultSpeed(playerData.getInt(storedPathName + ".DefaultSpeed"));
		pathStats.setDefaultCritDmg((double) playerData.get(storedPathName + ".DefaultCrit_Damage"));
		pathStats.setDefaultCritChance((double) playerData.get(storedPathName + ".DefaultCrit_Chance"));
		pathStats.setDefaultBurstDmg((double) playerData.get(storedPathName + ".DefaultBurst_Damage"));
		pathStats.setDefaultBurstChance((double) playerData.get(storedPathName + ".DefaultBurst_Chance"));
		pathStats.setDefaultCDR(playerData.getInt(storedPathName + ".DefaultCooldownReduction"));
		pathStats.setDefaultLifeSteal((double) playerData.get(storedPathName + ".DefaultLifeSteal"));
		pathStats.setDefaultManaRegen(playerData.getInt(storedPathName + ".DefaultManaRegen"));
		
		
	}
	
	public File getFolderLocation() {
		return playerDataFolderLocation;
	}


	public void setFolderLocation(File folderLocation) {
		this.playerDataFolderLocation = folderLocation;
	}
	

}
	
	
