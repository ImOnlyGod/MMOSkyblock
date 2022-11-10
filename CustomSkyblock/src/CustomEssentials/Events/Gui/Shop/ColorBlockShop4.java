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
import CustomEssentials.Events.ShopInfo.GuiItems;
import CustomEssentials.Events.ShopInfo.ItemPrices;
import CustomEssentials.Utils.CurrencyUtils;
import CustomEssentials.Utils.Utils;

public class ColorBlockShop4 implements TabExecutor{

	private Main plugin;
	private ItemPrices prices;
	private ItemPrices pricesPrevious;
	
	public ColorBlockShop4(Main plugin, ItemPrices prices) {
		this.plugin = plugin;
		this.prices = prices;
		this.pricesPrevious = this.plugin.getShopPricesPrevious();
		plugin.getCommand("shopColorBlocks4").setExecutor(this);
		
	}
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&2&lColor Blocks Shop &7(Page 4)"));
		
		//Glass Slots		
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i < 10) || (43 < i && i < 54) || (i == 17) || (i == 18)  || (i == 26) || (i == 27) || (i == 35) || (i == 36)) {
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
		
		//MainMenu Item
		ItemStack mainMenu = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta mainMenuMeta = (SkullMeta) mainMenu.getItemMeta();
		mainMenuMeta.setDisplayName(Utils.chat("&a&lBack to Main Menu"));
		GameProfile mainMenuGameProfile = new GameProfile(UUID.randomUUID(),"");
		String mainMenuValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJlNTI5YWI2YjJlYTdjNTBkOTE5MmQ4OWY4OThmZDdkYThhOWU3NTBkMzc4Mjk1ZGY3MzIwNWU3YTdlZWFlMCJ9fX0=";
		mainMenuGameProfile.getProperties().put("textures", new Property("texture",mainMenuValue));		
		
		//Next Page Item
		ItemStack nextPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta nextPageMeta = (SkullMeta) nextPage.getItemMeta();
		nextPageMeta.setDisplayName(Utils.chat("&a&lNext"));
		GameProfile nextPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String nextPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE1Y2U4NDQ4YWNiZDhlNjBjOWI2ZTkzZjQwNjJhMjAzYzQzNGFlYzUwNjgwZDlmMGQwMjhiN2MwOTEyNTczOCJ9fX0=";
		nextPageGameProfile.getProperties().put("textures", new Property("texture",nextPageValue));		
		
		//Previous Page Item
		ItemStack previousPage = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta previousPageMeta = (SkullMeta) previousPage.getItemMeta();
		previousPageMeta.setDisplayName(Utils.chat("&a&lBack"));
		GameProfile previousPageGameProfile = new GameProfile(UUID.randomUUID(),"");
		String previousPageValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk2MTcwMjJjZjlhMWQ1YTg2MDZjMDZlMzg5NGMzMTA4NzRkZmFkMjc2OTA3OTNkNjc1NjkwMTY1OGM2ZTA2NCJ9fX0=";
		previousPageGameProfile.getProperties().put("textures", new Property("texture",previousPageValue));	
		
		setGameProfiles(helpMeta, helpGameProfile);
		setGameProfiles(bankMeta, bankGameProfile);
		setGameProfiles(mainMenuMeta, mainMenuGameProfile);
		setGameProfiles(nextPageMeta, nextPageGameProfile);
		setGameProfiles(previousPageMeta, previousPageGameProfile);
				
		help.setItemMeta(helpMeta);
		menu.setItem(4, help);
		
		bank.setItemMeta(bankMeta);
		menu.setItem(49, bank);

		mainMenu.setItemMeta(mainMenuMeta);
		menu.setItem(0, mainMenu);
		
		nextPage.setItemMeta(nextPageMeta);
		menu.setItem(51, nextPage);
		
		previousPage.setItemMeta(previousPageMeta);
		menu.setItem(47, previousPage);
		
		//Vanilla items		
		ItemPrices initialPrices = new ItemPrices();
		int i = 10;
		GuiItems blocks = new GuiItems();
		for (int j = 84; j < blocks.getColorBlocks().size(); j++) {
			Material material = blocks.getColorBlocks().get(j);
			if (i==17 || i== 26 || i == 35) {
				i += 2;
			}
			if (i > 43) break;
			
			ItemStack item = new ItemStack(material);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(Utils.chat("&7&l"+item.getType()));
			List<String> lore = new ArrayList<String>();
			
			double previousItemBuyPrice = this.pricesPrevious.getItemBuyPrice().get(item.getType());
			double currentItemBuyPrice = this.prices.getItemBuyPrice().get(item.getType());
			double initialItemBuyPrice = initialPrices.getItemBuyPrice().get(item.getType());
			
			Double changePercentRecent = (double) Math.round((Math.abs(previousItemBuyPrice - currentItemBuyPrice)/currentItemBuyPrice)*10000)/100;	
			Double changePercentNet = (double) Math.round((Math.abs(initialItemBuyPrice - currentItemBuyPrice)/currentItemBuyPrice)*10000)/100;	
			
			String changeSign = "&2▲";
			String changeSign2 = "&2▲";
			if (previousItemBuyPrice > currentItemBuyPrice) changeSign = "&4▼";
			if (initialItemBuyPrice > currentItemBuyPrice) changeSign2 = "&4▼";
			
			lore.add(Utils.chat("&cBuy Price&7: &8$" + CurrencyUtils.currencyFormat(this.prices.getItemBuyPrice().get(item.getType()))));
			lore.add(Utils.chat("&aSell Price&7: &8$" +  CurrencyUtils.currencyFormat(this.prices.getItemSellPrice().get(item.getType()))));
			lore.add(Utils.chat("&6Price Change (12 Hours)&7: &8" + changePercentRecent + "% " + changeSign));
			lore.add(Utils.chat("&5Price Change (Net Total)&7: &8" + changePercentNet + "% " + changeSign2));
			
			meta.setLore(lore);
			item.setItemMeta(meta);
			menu.setItem(i, item);
			i += 1;
		}
			
		
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

	public ItemPrices getPrices() {
		return prices;
	}

	public void setPrices(ItemPrices prices) {
		this.prices = prices;
	}
	
}
