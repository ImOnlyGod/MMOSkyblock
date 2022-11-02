package CustomEssentials.Events.Gui.Shop;

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

public class MainShopMenu implements TabExecutor{

	private Main plugin;
	
	public MainShopMenu(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("shop").setExecutor(this);
		plugin.getCommand("market").setExecutor(this);
		
	}
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&a&lShop"));
		
		//Glass Slots
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i < 10) || (i > 43) || (i == 17) || (i == 36)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);	
				menu.setItem(i, glassSlot);
				}					
			}
		
		for (int i = 0; i < menu.getSize(); i++) {
			if ((9 < i && i < 17) || (36 < i && i < 44) || (i == 18) || (i == 26) || (i == 27) || (i == 35)) {
				ItemStack glassSlot = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);	
				menu.setItem(i, glassSlot);
				}					
			}
		
		//ADD LORE
		//HELP 
		ItemStack help = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta helpMeta = (SkullMeta) help.getItemMeta();
		helpMeta.setDisplayName(Utils.chat("&3&lShop Guide"));
		GameProfile helpGameProfile = new GameProfile(UUID.randomUUID(),"");
		String helpValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2UzZGViNTdlYWEyZjRkNDAzYWQ1NzI4M2NlOGI0MTgwNWVlNWI2ZGU5MTJlZTJiNGVhNzM2YTlkMWY0NjVhNyJ9fX0=";
		helpGameProfile.getProperties().put("textures", new Property("texture",helpValue));
		
		//BANK/MONEY item
		ItemStack bank = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta bankMeta = (SkullMeta) bank.getItemMeta();
		bankMeta.setDisplayName(Utils.chat("&7Current Balance: &a$" + Math.round(playerProfile.getBalance()*100)/100));
		GameProfile bankGameProfile = new GameProfile(UUID.randomUUID(),"");
		String bankValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTc2YmM2ODU0N2M3NmJhNDYyNTA4NTAyOTgwNDY0N2I4MmY4MTY3MDVjOGJiNjFlMzdkMTQ4NWE3NWM3MmM1ZiJ9fX0=";
		bankGameProfile.getProperties().put("textures", new Property("texture",bankValue));
				
		//Basic Block item
		ItemStack blocks = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta blocksMeta = (SkullMeta) blocks.getItemMeta();
		blocksMeta.setDisplayName(Utils.chat("&7&lBlocks"));
		GameProfile blocksGameProfile = new GameProfile(UUID.randomUUID(),"");
		String blocksValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzIyODM5ZDVjN2ZjMDY3ODA2MmYxYzZjOGYyN2IzMzIwOTQzODRlM2JiNWM0YjVlYmQxNjc2YjI3OWIwNmJmIn19fQ==";
		blocksGameProfile.getProperties().put("textures", new Property("texture",blocksValue));
		
		//Color Block item
		ItemStack cBlocks = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta cBlocksMeta = (SkullMeta) cBlocks.getItemMeta();
		cBlocksMeta.setDisplayName(Utils.chat("&2&lColor Blocks"));
		GameProfile cBlocksGameProfile = new GameProfile(UUID.randomUUID(),"");
		String cBlocksValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI0ZmY4Y2E5NTljZTc4MWFmYzI3N2FiZTM2ZjgyMTM3ZTY4N2ZlNThmY2Y0ZmY1MDhjZWQ0Mzg5MGVlNTE5ZCJ9fX0=";
		cBlocksGameProfile.getProperties().put("textures", new Property("texture",cBlocksValue));
		
		//Decoration Block item
		ItemStack decorationBlocks = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta decorationBlocksMeta = (SkullMeta) decorationBlocks.getItemMeta();
		decorationBlocksMeta.setDisplayName(Utils.chat("&d&lDecoration Items"));
		GameProfile decorationBlocksGameProfile = new GameProfile(UUID.randomUUID(),"");
		String decorationBlocksValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJiNDFmMWYwZDhlZmM2ZmM5MzgzYTZiODE0NjE1OWUxNjVhMzlhNDA5ZWYwZmVkYmM0NTg0MmI2NTY0NDFlNyJ9fX0=";
		decorationBlocksGameProfile.getProperties().put("textures", new Property("texture",decorationBlocksValue));
		
		//Farming Block item
		ItemStack farming = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta farmingMeta = (SkullMeta) farming.getItemMeta();
		farmingMeta.setDisplayName(Utils.chat("&a&lFarming Crops"));
		GameProfile farmingGameProfile = new GameProfile(UUID.randomUUID(),"");
		String farmingValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWIyZDZlMTA0YmVlMGVhZWUzYzFjZTM1ODQyMTZlNWRiY2E1MTdmOWMyNjE0MTU2ZDAwMDRhNGUyYmM3MTEzNSJ9fX0=";
		farmingGameProfile.getProperties().put("textures", new Property("texture",farmingValue));
		
		//MobDrops items
		ItemStack mobDrops = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mobDropsMeta = (SkullMeta) mobDrops.getItemMeta();
		mobDropsMeta.setDisplayName(Utils.chat("&c&lMob Drops"));
		GameProfile mobDropsGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mobDropsValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWU1MGI3NmVhNDU5ODc2YmZlZTE2ZmRiMDE1OTE3NzI2OWRkY2JhZDExZDMyYTE3OWMxODBhMGJjNGUxMWZiNSJ9fX0=";
		mobDropsGameProfile.getProperties().put("textures", new Property("texture",mobDropsValue));
		
		//Food items
		ItemStack food = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta foodMeta = (SkullMeta) food.getItemMeta();
		foodMeta.setDisplayName(Utils.chat("&6&lFoods"));
		GameProfile foodGameProfile = new GameProfile(UUID.randomUUID(),"");
		String foodValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNThiYWQyYzJkNDgzNzQxYWUwYTdiNGE0YmY0MzQyMTI3MGIwZTVkZWI0NjRkNGY4NWZkNzY4OGIxYTYwYjRlOSJ9fX0=";
		foodGameProfile.getProperties().put("textures", new Property("texture",foodValue));
		
		//Gems items
		ItemStack gems = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta gemsMeta = (SkullMeta) gems.getItemMeta();
		gemsMeta.setDisplayName(Utils.chat("&b&lGems and Ingots"));
		GameProfile gemsGameProfile = new GameProfile(UUID.randomUUID(),"");
		String gemsValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI2MGE1NjEwNmM5YWU1NTU3YTEyZDVjYzI5MTU5MWYyZWFmMjY3NzAxMmQzYmVlYzU4ZDQ1OGRkYjkyYWViOSJ9fX0=";
		gemsGameProfile.getProperties().put("textures", new Property("texture",gemsValue));
		
		//Redstone Items
		ItemStack redstone = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta redstoneMeta = (SkullMeta) redstone.getItemMeta();
		redstoneMeta.setDisplayName(Utils.chat("&4&lRedstone Items"));
		GameProfile redstoneGameProfile = new GameProfile(UUID.randomUUID(),"");
		String redstoneValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk5MzY2YTNmMjMzNTZkNDRjYjNhNzIyZjgxODdjN2QwN2JhOTc1MDFmNzZkMTVmMmIzMTFlN2ZmZTVhNGRhYyJ9fX0=";
		redstoneGameProfile.getProperties().put("textures", new Property("texture",redstoneValue));
		
		//Misc Items
		ItemStack misc = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta miscMeta = (SkullMeta) misc.getItemMeta();
		miscMeta.setDisplayName(Utils.chat("&f&lMiscellaneous Items"));
		GameProfile miscGameProfile = new GameProfile(UUID.randomUUID(),"");
		String miscValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDVlZWVmN2M3OWJmMmY5YTQxNDVmMTA2MGYyZjIwNTQ1NDdhOTMwNGNhZWZkN2Q4ZGIwMmMzMjQzMmQ3MTRkNyJ9fX0=";
		miscGameProfile.getProperties().put("textures", new Property("texture",miscValue));
		
		//Spawners
		ItemStack spawners = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta spawnersMeta = (SkullMeta) spawners.getItemMeta();
		spawnersMeta.setDisplayName(Utils.chat("&8&lSpawners"));
		GameProfile spawnersGameProfile = new GameProfile(UUID.randomUUID(),"");
		String spawnersValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGViMDdlZWEzODBhZjU4ZGM5MWVlZWUxNWQ5NWQ4NzkwYTA3ODFjNjk1ZWMwYThmZDhmZTMxZDQ4MzljYTU2MiJ9fX0=";
		spawnersGameProfile.getProperties().put("textures", new Property("texture",spawnersValue));
		
		//Brewing
		ItemStack brewing = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta brewingMeta = (SkullMeta) brewing.getItemMeta();
		brewingMeta.setDisplayName(Utils.chat("&5&lBrewing Materials"));
		GameProfile brewingGameProfile = new GameProfile(UUID.randomUUID(),"");
		String brewingValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTAzMjdmYjM0MzE5Zjg5YWM1YWI0OGI0ZDc5MjUxZjEzZjA2N2ViZWE3ZGE1Zjg4Yjc1ZjQ3OWE3Mzg5OTI0ZSJ9fX0=";
		brewingGameProfile.getProperties().put("textures", new Property("texture",brewingValue));
		
		//Coming Soon
		ItemStack comingSoon = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta comingSoonMeta = (SkullMeta) comingSoon.getItemMeta();
		comingSoonMeta.setDisplayName(Utils.chat("&e&lComing Soon!"));
		GameProfile comingSoonGameProfile = new GameProfile(UUID.randomUUID(),"");
		String comingSoonValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzhiMGI1N2UzY2VlYmQ2NzNkZjlkMmNmMjRkMzk3OWEzMzE2ZTYxZDNiNjU4ZDJhMzQ4Y2QxZTYyODBiMiJ9fX0=";
		comingSoonGameProfile.getProperties().put("textures", new Property("texture",comingSoonValue));
		
		setGameProfiles(helpMeta, helpGameProfile);
		setGameProfiles(bankMeta, bankGameProfile);
		setGameProfiles(blocksMeta, blocksGameProfile);
		setGameProfiles(cBlocksMeta, cBlocksGameProfile);
		setGameProfiles(decorationBlocksMeta, decorationBlocksGameProfile);
		setGameProfiles(farmingMeta, farmingGameProfile);
		setGameProfiles(mobDropsMeta, mobDropsGameProfile);
		setGameProfiles(foodMeta, foodGameProfile);
		setGameProfiles(gemsMeta, gemsGameProfile);
		setGameProfiles(redstoneMeta, redstoneGameProfile);
		setGameProfiles(miscMeta, miscGameProfile);
		setGameProfiles(spawnersMeta, spawnersGameProfile);
		setGameProfiles(brewingMeta, brewingGameProfile);
		setGameProfiles(comingSoonMeta, comingSoonGameProfile);
				
		help.setItemMeta(helpMeta);
		menu.setItem(4, help);
		
		bank.setItemMeta(bankMeta);
		menu.setItem(49, bank);
			
		blocks.setItemMeta(blocksMeta);
		menu.setItem(19, blocks);
		
		cBlocks.setItemMeta(cBlocksMeta);
		menu.setItem(20, cBlocks);
		
		decorationBlocks.setItemMeta(decorationBlocksMeta);
		menu.setItem(21, decorationBlocks);
		
		farming.setItemMeta(farmingMeta);
		menu.setItem(22, farming);
		
		mobDrops.setItemMeta(mobDropsMeta);
		menu.setItem(23, mobDrops);
		
		food.setItemMeta(foodMeta);
		menu.setItem(24, food);
		
		gems.setItemMeta(gemsMeta);
		menu.setItem(25, gems);
		
		redstone.setItemMeta(redstoneMeta);
		menu.setItem(28, redstone);
		
		misc.setItemMeta(miscMeta);
		menu.setItem(29, misc);
		
		spawners.setItemMeta(spawnersMeta);
		menu.setItem(31, spawners);
		
		brewing.setItemMeta(brewingMeta);
		menu.setItem(30, brewing);
		
		comingSoon.setItemMeta(comingSoonMeta);
		menu.setItem(32, comingSoon);
		menu.setItem(33, comingSoon);
		menu.setItem(34, comingSoon);
		
		return menu;
	}
	
	public void setGameProfiles(SkullMeta meta, GameProfile gameProfile) {
		try {
			Field profileField = meta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(meta, gameProfile);					
		} catch (Exception e) {
			e.printStackTrace();
		}
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
