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
			if ((i < 19) || (i > 34) || (i == 26) || (i == 27)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);	
				menu.setItem(i, glassSlot);
				}					
			}
		
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
		blocksMeta.setDisplayName(Utils.chat("&2&lBlocks"));
		GameProfile blocksGameProfile = new GameProfile(UUID.randomUUID(),"");
		String blocksValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzIyODM5ZDVjN2ZjMDY3ODA2MmYxYzZjOGYyN2IzMzIwOTQzODRlM2JiNWM0YjVlYmQxNjc2YjI3OWIwNmJmIn19fQ==";
		blocksGameProfile.getProperties().put("textures", new Property("texture",blocksValue));
		
		//Color Block item
		ItemStack cblocks = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta cblocksMeta = (SkullMeta) cblocks.getItemMeta();
		cblocksMeta.setDisplayName(Utils.chat("&2&lColor Blocks"));
		GameProfile cblocksGameProfile = new GameProfile(UUID.randomUUID(),"");
		String cblocksValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI0ZmY4Y2E5NTljZTc4MWFmYzI3N2FiZTM2ZjgyMTM3ZTY4N2ZlNThmY2Y0ZmY1MDhjZWQ0Mzg5MGVlNTE5ZCJ9fX0=";
		cblocksGameProfile.getProperties().put("textures", new Property("texture",cblocksValue));
		
		
		try {
			Field bankProfileField = bankMeta.getClass().getDeclaredField("profile");
			bankProfileField.setAccessible(true);
			bankProfileField.set(bankMeta,bankGameProfile);
			
			Field blocksProfileField = blocksMeta.getClass().getDeclaredField("profile");
			blocksProfileField.setAccessible(true);
			blocksProfileField.set(blocksMeta,blocksGameProfile);
			
			Field cblocksProfileField = cblocksMeta.getClass().getDeclaredField("profile");
			cblocksProfileField.setAccessible(true);
			cblocksProfileField.set(cblocksMeta,cblocksGameProfile);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		bank.setItemMeta(bankMeta);
		menu.setItem(49, bank);
			
		blocks.setItemMeta(blocksMeta);
		menu.setItem(19, blocks);
		
		cblocks.setItemMeta(cblocksMeta);
		menu.setItem(20, cblocks);
		
	
		
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
