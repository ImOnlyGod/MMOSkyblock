package CustomEssentials;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import CustomEssentials.Commands.AdminItemCommand;
import CustomEssentials.Commands.AdminSkillCommand;
import CustomEssentials.Commands.BaseCommands;
import CustomEssentials.Commands.CustomMobsCommand;
import CustomEssentials.Commands.CustomSpawnerCommand;
import CustomEssentials.Commands.EatCommand;
import CustomEssentials.Commands.FlyCommand;
import CustomEssentials.Commands.WeaponTabCommand;
import CustomEssentials.Commands.PlayerEconomy.AdminEcoCommand;
import CustomEssentials.Commands.PlayerEconomy.BalanceCommand;
import CustomEssentials.Commands.PlayerEconomy.PayCommand;
import CustomEssentials.Events.PlayerProfileManager;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.EventTasks.CraftingEvents;
import CustomEssentials.Events.EventTasks.FishingEvents;
import CustomEssentials.Events.EventTasks.FoodSaturation;
import CustomEssentials.Events.EventTasks.GuiShops;
import CustomEssentials.Events.EventTasks.MobEvents;
import CustomEssentials.Events.EventTasks.PlayerJoinLeave;
import CustomEssentials.Events.EventTasks.SkillsFunctioning;
import CustomEssentials.Events.Gui.CraftGui;
import CustomEssentials.Events.Gui.MenuGui;
import CustomEssentials.Events.Gui.Path.PathGui;
import CustomEssentials.Events.Gui.Path.PathSelectionGui;
import CustomEssentials.Events.Gui.Shop.BlockShop1;
import CustomEssentials.Events.Gui.Shop.BlockShop2;
import CustomEssentials.Events.Gui.Shop.BlockShop3;
import CustomEssentials.Events.Gui.Shop.BlockShop4;
import CustomEssentials.Events.Gui.Shop.BrewingShop1;
import CustomEssentials.Events.Gui.Shop.BrewingShop2;
import CustomEssentials.Events.Gui.Shop.ColorBlockShop1;
import CustomEssentials.Events.Gui.Shop.ColorBlockShop2;
import CustomEssentials.Events.Gui.Shop.ColorBlockShop3;
import CustomEssentials.Events.Gui.Shop.ColorBlockShop4;
import CustomEssentials.Events.Gui.Shop.DecorativeBlockShop1;
import CustomEssentials.Events.Gui.Shop.DecorativeBlockShop2;
import CustomEssentials.Events.Gui.Shop.DecorativeBlockShop3;
import CustomEssentials.Events.Gui.Shop.FarmingShop1;
import CustomEssentials.Events.Gui.Shop.FarmingShop2;
import CustomEssentials.Events.Gui.Shop.FoodShop1;
import CustomEssentials.Events.Gui.Shop.FoodShop2;
import CustomEssentials.Events.Gui.Shop.GemsShop1;
import CustomEssentials.Events.Gui.Shop.GemsShop2;
import CustomEssentials.Events.Gui.Shop.MainShopMenu;
import CustomEssentials.Events.Gui.Shop.MiscShop1;
import CustomEssentials.Events.Gui.Shop.MiscShop2;
import CustomEssentials.Events.Gui.Shop.MobDropsShop1;
import CustomEssentials.Events.Gui.Shop.MobDropsShop2;
import CustomEssentials.Events.Gui.Shop.RedstoneShop1;
import CustomEssentials.Events.Gui.Shop.RedstoneShop2;
import CustomEssentials.Events.Gui.Skills.SkillsGui;
import CustomEssentials.Events.Items.ItemStats;
import CustomEssentials.Events.Items.Enchants.CustomEnchants;
import CustomEssentials.Events.PlayerPath.Paths.Path;
import CustomEssentials.Events.PlayerSkills.Skills;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.ArmorUtils;
import CustomEssentials.Utils.HealthUtils;
import CustomEssentials.Utils.ManaUtils;
import CustomEssentials.Utils.StatsUtil;
import CustomEssentials.WorldMechanics.VoidChunkGenerator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin{

	private PlayerProfileManager profileManager;
	private int displayStats = 0;
	private File playerDataFolderLocation;
	private ItemPrices shopPrices;
	private File shopPricesLocation;
	private ArrayList<Block> regenBlockList = new ArrayList<Block>();
	private ArrayList<Integer> regenBlockIDList = new ArrayList<Integer>();
	private File regenBlockListLocation;
	private Connection databaseConnection;
	
	public ArrayList<Block> getRegenBlockList() {
		return regenBlockList;
	}

	public void setRegenBlockList(ArrayList<Block> regenBlockList) {
		this.regenBlockList = regenBlockList;
	}

	public ItemPrices getShopPrices() {
		return shopPrices;
	}

	public void setShopPrices(ItemPrices shopPrices) {
		this.shopPrices = shopPrices;
	}


	private ItemPrices shopPricesPrevious;
	
	public ItemPrices getShopPricesPrevious() {
		return shopPricesPrevious;
	}


	public void setShopPricesPrevious(ItemPrices shopPricesPrevious) {
		this.shopPricesPrevious = shopPricesPrevious;
	}


	public void generateShopGui() {
		new BlockShop1(this, this.shopPrices);
		new BlockShop2(this, this.shopPrices);
		new BlockShop3(this, this.shopPrices);
		new BlockShop4(this, this.shopPrices);
		new ColorBlockShop1(this, this.shopPrices);
		new ColorBlockShop2(this, this.shopPrices);
		new ColorBlockShop3(this, this.shopPrices);
		new ColorBlockShop4(this, this.shopPrices);
		new DecorativeBlockShop1(this, this.shopPrices);
		new DecorativeBlockShop2(this, this.shopPrices);
		new DecorativeBlockShop3(this, this.shopPrices);
		new FarmingShop1(this, this.shopPrices);
		new FarmingShop2(this, this.shopPrices);
		new FoodShop1(this, this.shopPrices);
		new FoodShop2(this, this.shopPrices);
		new GemsShop1(this, this.shopPrices);
		new GemsShop2(this, this.shopPrices);
		new MiscShop1(this, this.shopPrices);
		new MiscShop2(this, this.shopPrices);
		new MobDropsShop1(this, this.shopPrices);
		new MobDropsShop2(this, this.shopPrices);
		new RedstoneShop1(this, this.shopPrices);
		new RedstoneShop2(this, this.shopPrices);
		new BrewingShop1(this, this.shopPrices);
		new BrewingShop2(this, this.shopPrices);
	}
	
	public void connectDatabase() {
		
		File directory = this.regenBlockListLocation;
		String FileName = "database";
		String path = directory.getPath();
		File databaseFile = new File(path + "\\" + FileName + ".yml");	
		if (!databaseFile.exists()) {
			try {
				databaseFile.createNewFile();
				FileConfiguration databaseData = YamlConfiguration.loadConfiguration(databaseFile);	
				
				databaseData.set("url", "");
				databaseData.set("username", "");
				databaseData.set("password", "");
				
				databaseData.save(databaseFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			return;
		}			
		
		FileConfiguration databaseData = YamlConfiguration.loadConfiguration(databaseFile);
		
		String url = (String) databaseData.get("url");
		String user = (String) databaseData.get("username");
		String pass = (String) databaseData.get("password");
		
		if (url == null) return;
		
		try {
			Connection connection = DriverManager.getConnection(url,user,pass);
			this.setDatabaseConnection(connection);
			System.out.println("Connected to the Database.");
		} catch (SQLException e) {
			System.out.println("Unable to connect to the Database.");
			e.printStackTrace();
		}
		
	}
	
	public void setupDBTables() {
		try {
			Statement statement = this.databaseConnection.createStatement();
			String createBlockRegenTable = "CREATE TABLE IF NOT EXISTS regenBlockData(id varchar(10), x double, y double, z double, worldName varchar(10), custom_item_id int)";
			statement.execute(createBlockRegenTable);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onEnable() {
			
		//getServer().getConsoleSender().sendMessage(Utils.chat("&aPlugin has been enabled!"));
		generatePlayerFolder();	
		generateShopFile();
		generateRegenBlockListFile();
		this.profileManager = new PlayerProfileManager(this);
		//connectDatabase();
		//setupDBTables();
		CustomEnchants.register();
				
		this.generateplayerIslands();
		
		new MenuGui(this);
		new SkillsGui(this);
		new PathSelectionGui(this);
		new PathGui(this);
		new MainShopMenu(this);
		new CraftGui(this);
		new WeaponTabCommand(this);
		new CustomSpawnerCommand(this);
		new CustomMobsCommand(this);
		new BaseCommands(this);
		readShopData();
		readRegenBlockData();
		getServer().getPluginManager().registerEvents(new MobEvents(this), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinLeave(this), this);
		getServer().getPluginManager().registerEvents(new GuiShops(this, this.shopPrices), this);
		getServer().getPluginManager().registerEvents(new SkillsFunctioning(this, this.regenBlockList, this.regenBlockIDList), this);
		getServer().getPluginManager().registerEvents(new FoodSaturation(this), this);
		getServer().getPluginManager().registerEvents(new FishingEvents(this), this);
		getServer().getPluginManager().registerEvents(new CraftingEvents(this), this);
		
		loadConfig();
				
		new FlyCommand(this);
		new EatCommand(this);
		new BalanceCommand(this);
		new PayCommand(this);
		new AdminEcoCommand(this);
		new AdminSkillCommand(this);
		new AdminItemCommand(this);
		
		this.generateShopGui();		
		
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
				int currentMana = stats.getMana();
				int manaRegen = stats.getManaRegen();
				int TotalMana = stats.getTotalMana();
				
				//Sets item stats
				ItemStats setStats = new ItemStats(p,profileManager);
				setStats.setItemStats();		
				
				if (currentMana < TotalMana) {
					if (currentMana + Math.max(manaRegen, 1) > TotalMana) {
						stats.setMana(TotalMana);
					}
					else stats.setMana(currentMana+Math.max(manaRegen, 1));
				}
				
				if (currentMana > TotalMana) stats.setMana(TotalMana);
								
				String health = HealthUtils.getActionBarHealthText(p);
				String armor = ArmorUtils.getActionBarArmorText(profile);
				String mana = ManaUtils.getActionBarManaText(p,currentMana, TotalMana);
				
				
				
				if (displayStats == 0) {
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(health + armor + mana));
				}
				else if (displayStats == 1) {
					
					String mining = StatsUtil.miningActionBarMessage(profile);
					
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(mining));
					
					while (profile.getMining().getCurrentXP() >= profile.getMining().getMaxXP()) {
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
					
					while (profile.getForaging().getCurrentXP() >= profile.getForaging().getMaxXP()) {
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
					
					while (profile.getFarming().getCurrentXP() >= profile.getFarming().getMaxXP()) {
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
					
					while (profile.getCombat().getCurrentXP() >= profile.getCombat().getMaxXP()) {
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
					
					while (profile.getFishing().getCurrentXP() >= profile.getFishing().getMaxXP()) {
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
		saveShopPrices();
		savePlayerData();
		saveRegenBlockData();
		
		try {
			this.databaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		saveConfig();
		getServer().getConsoleSender().sendMessage("Plugin has been disabled!");
		
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void createVoidWorld(String worldName, WorldType worldType) {
		WorldCreator wc = new WorldCreator(worldName);
		wc.environment(World.Environment.NORMAL);
		wc.type(worldType);
		
		wc.generator(new VoidChunkGenerator());
		
		wc.createWorld();
	}
	
	public void generateplayerIslands() {
		String worldName = "voidIslands";
		if (Bukkit.getWorld(worldName) != null)	return;
		
		WorldType worldType = WorldType.NORMAL;
		
		this.createVoidWorld(worldName, worldType);				
		
	}
	
	public void generateRegenBlockListFile() {
		setRegenBlockListLocation(this.getDataFolder());
	}
	
	public void saveRegenBlockData() {		
		
		setRegenBlockListLocation(this.regenBlockListLocation);
		writeRegenBlockData(this.regenBlockListLocation);
	}	
	
	public void addRegenBlockDataToDB(String id, double x, double y, double z, String worldName, int custom_item_id) {
		
		try {
			PreparedStatement addRegenBlockToDB = this.getDatabaseConnection().prepareStatement("INSERT INTO regenBlockData(id, x, y, z, worldName, custom_item_id) VALUES (?, ?, ?, ?, ?, ?)");
			addRegenBlockToDB.setString(1, id);
			addRegenBlockToDB.setDouble(2, x);
			addRegenBlockToDB.setDouble(3, y);
			addRegenBlockToDB.setDouble(4, z);
			addRegenBlockToDB.setString(5, worldName);
			addRegenBlockToDB.setInt(6, custom_item_id);
			
			addRegenBlockToDB.executeUpdate();
			addRegenBlockToDB.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void writeRegenBlockData(File directory) {
		String FileName = "regen_block_data";
		String path = directory.getPath();
		File RegenBlockFile = new File(path + "\\" + FileName + ".yml");	
		RegenBlockFile.delete();
		RegenBlockFile = new File(path + "\\" + FileName + ".yml");
		
		if (!RegenBlockFile.exists())
			try {
				RegenBlockFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		FileConfiguration regenBlockData = YamlConfiguration.loadConfiguration(RegenBlockFile);	
		
		try {
			PreparedStatement removeOLDRegenBlocks = this.getDatabaseConnection().prepareStatement("DELETE FROM regenBlockData");
			
			removeOLDRegenBlocks.executeUpdate();
			removeOLDRegenBlocks.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			int blockNum = 0;
			for (Block block : this.regenBlockList) {
				String blockNumStr = String.valueOf(blockNum);
				
				this.addRegenBlockDataToDB(blockNumStr,block.getLocation().getX(),block.getLocation().getY(),block.getLocation().getZ(),block.getLocation().getWorld().getName(),this.regenBlockIDList.get(blockNum));			
				
				regenBlockData.createSection(blockNumStr);
				regenBlockData.set(blockNumStr+"."+"x", block.getLocation().getX());
				regenBlockData.set(blockNumStr+"."+"y", block.getLocation().getY());
				regenBlockData.set(blockNumStr+"."+"z", block.getLocation().getZ());
				regenBlockData.set(blockNumStr+"."+"worldName", block.getLocation().getWorld().getName());	
				regenBlockData.set(blockNumStr+"."+"id", this.regenBlockIDList.get(blockNum));	
				blockNum++;
			}
			
			regenBlockData.save(RegenBlockFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		
	}
	
	public void readRegenBlockData() {
		
		String FileName = "regen_block_data";
		String path = this.getShopPricesLocation().getPath();
		File RegenBlockFile = new File(path + "\\" + FileName + ".yml");
		
		if (!RegenBlockFile.exists()) return;
				
		FileConfiguration regenBlockData = YamlConfiguration.loadConfiguration(RegenBlockFile);
		
		int numBlocks = 0;
		try {
			LineNumberReader lnr = new LineNumberReader(new FileReader(RegenBlockFile));
			while (lnr.readLine() != null)	numBlocks +=1;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		numBlocks = numBlocks/6;
		
		int blockNum = 0;
		//FIND AMOUNT OF LINES
		for (int i=0;i<numBlocks;i++) {
			String blockNumStr = String.valueOf(blockNum);
			if (regenBlockData.get(blockNumStr+"."+"x").equals(null)) break;

			double x = (double) regenBlockData.get(blockNumStr+"."+"x");
			double y = (double) regenBlockData.get(blockNumStr+"."+"y");
			double z = (double) regenBlockData.get(blockNumStr+"."+"z");
			String worldName = (String) regenBlockData.get(blockNumStr+"."+"worldName");
			int customModelData = (int) regenBlockData.get(blockNumStr+"."+"id");
			World world = this.getServer().getWorld(worldName);
			Location loc = new Location(world, x, y, z);
			
			this.regenBlockList.add(loc.getBlock());
			this.regenBlockIDList.add(customModelData);
			
			blockNum++;
			
		}
		
	}
	
	public void generateShopFile() {
		setShopPricesLocation(this.getDataFolder());
	}
	
	public void saveShopPrices() {
		setShopPricesLocation(this.shopPricesLocation);
		writeShopPrice(this.shopPricesLocation);
	}
	
	public void writeShopPrice(File directory) {
		String FileName = "shop_prices";
		String path = directory.getPath();
		File ShopFile = new File(path + "\\" + FileName + ".yml");
		
		if (!ShopFile.exists())
			try {
				ShopFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		FileConfiguration shopData = YamlConfiguration.loadConfiguration(ShopFile);		
		try {
			shopData.createSection("Buy");
			shopData.createSection("Sell");	
			
			for (Material item : this.shopPrices.getItemBuyPrice().keySet()) {
				String itemName = item.toString();
				shopData.set("Buy."+itemName, this.shopPrices.getItemBuyPrice().get(item));
				shopData.set("Sell."+itemName, this.shopPrices.getItemSellPrice().get(item));
			}
			
			shopData.save(ShopFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void readShopData() {
				
		String FileName = "shop_prices";
		String path = this.getShopPricesLocation().getPath();
		File ShopFile = new File(path + "\\" + FileName + ".yml");
		this.shopPrices = new ItemPrices();
		this.shopPricesPrevious = new ItemPrices();
		if (!ShopFile.exists()) return;
				
		FileConfiguration shopData = YamlConfiguration.loadConfiguration(ShopFile);
		for (Material item : this.shopPrices.getItemBuyPrice().keySet()) {
			String itemName = item.toString();
			double buy = (double) shopData.get("Buy." + itemName);    
			double sell = (double) shopData.get("Sell." + itemName); 
			this.shopPrices.getItemBuyPrice().replace(item, (float) buy);
			this.shopPrices.getItemSellPrice().replace(item, (float) sell);
			this.shopPricesPrevious.getItemBuyPrice().replace(item, (float) buy);
			this.shopPricesPrevious.getItemSellPrice().replace(item, (float) sell);
		}
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
				e.printStackTrace();
			}

		
		Profile profile = this.getProfileManager().getPlayerProfile(player);
		Stats stats = profile.getStats();
		//IMPLEMENT
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
			
			playerData.set("CombatSkill.xpMultiplier", combat.getXpMultiplier());
			playerData.set("FarmingSkill.xpMultiplier", farming.getXpMultiplier());
			playerData.set("FishingSkill.xpMultiplier", fishing.getXpMultiplier());
			playerData.set("ForagingSkill.xpMultiplier", foraging.getXpMultiplier());
			playerData.set("MiningSkill.xpMultiplier", mining.getXpMultiplier());
			
			playerData.set("CombatSkill.globalXpMultiplier", combat.getGlobalXpMultiplier());
			playerData.set("FarmingSkill.globalXpMultiplier", farming.getGlobalXpMultiplier());
			playerData.set("FishingSkill.globalXpMultiplier", fishing.getGlobalXpMultiplier());
			playerData.set("ForagingSkill.globalXpMultiplier", foraging.getGlobalXpMultiplier());
			playerData.set("MiningSkill.globalXpMultiplier", mining.getGlobalXpMultiplier());
			
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
		playerData.set(storedPathName + ".skillpoints", path.getSkillPoints());
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
		
		combat.setXpMultiplier(((Double) playerData.get("CombatSkill.xpMultiplier")));
		farming.setXpMultiplier((Double) playerData.get("FarmingSkill.xpMultiplier"));
		fishing.setXpMultiplier((Double) playerData.get("FishingSkill.xpMultiplier"));
		foraging.setXpMultiplier((Double) playerData.get("ForagingSkill.xpMultiplier"));
		mining.setXpMultiplier((Double) playerData.get("MiningSkill.xpMultiplier"));
		
		combat.setGlobalXpMultiplier(((Double) playerData.get("CombatSkill.globalXpMultiplier")));
		farming.setGlobalXpMultiplier((Double) playerData.get("FarmingSkill.globalXpMultiplier"));
		fishing.setGlobalXpMultiplier((Double) playerData.get("FishingSkill.globalXpMultiplier"));
		foraging.setGlobalXpMultiplier((Double) playerData.get("ForagingSkill.globalXpMultiplier"));
		mining.setGlobalXpMultiplier((Double) playerData.get("MiningSkill.globalXpMultiplier"));
		
		//GENERAL PATH
		playerProfile.setPath(playerProfile.getPaths().get(playerData.get("GeneralPath.Name")));
		Path playerPath = playerProfile.getPath();
		
		playerPath.setLevel(playerData.getInt("GeneralPath.level"));
		playerPath.setCurrentXP((Double) playerData.get("GeneralPath.xp"));
		playerPath.setMaxXP((Double) playerData.get("GeneralPath.MaxXp"));
		playerPath.setSkillPoints(playerData.getInt("GeneralPath.skillPoints"));
		playerPath.setSkillPointsMax(playerData.getInt("GeneralPath.skillPointsMax"));
		
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
		path.setSkillPoints(playerData.getInt(storedPathName + ".skillPoints"));
		path.setSkillPointsMax(playerData.getInt(storedPathName + ".skillPointsMax"));
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


	public File getShopPricesLocation() {
		return shopPricesLocation;
	}


	public void setShopPricesLocation(File shopPricesLocation) {
		this.shopPricesLocation = shopPricesLocation;
	}

	public File getRegenBlockListLocation() {
		return regenBlockListLocation;
	}

	public void setRegenBlockListLocation(File regenBlockListLocation) {
		this.regenBlockListLocation = regenBlockListLocation;
	}

	public ArrayList<Integer> getRegenBlockIDList() {
		return regenBlockIDList;
	}

	public void setRegenBlockIDList(ArrayList<Integer> regenBlockIDList) {
		this.regenBlockIDList = regenBlockIDList;
	}

	public Connection getDatabaseConnection() {
		return databaseConnection;
	}

	public void setDatabaseConnection(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
	

}
	
	
