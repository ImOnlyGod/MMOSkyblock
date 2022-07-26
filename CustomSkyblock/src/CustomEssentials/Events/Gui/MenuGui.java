package CustomEssentials.Events.Gui;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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

import CustomEssentials.Utils.Utils;
import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.Misc.TimeGenerator;

public class MenuGui implements TabExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public MenuGui(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("menu").setExecutor(this);
		
	}
	
	public Inventory createGui(Player p) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&a&lMenu"));
		
		//Glass Slots
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i != 13) && ((i < 18) || (i > 35))) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				menu.setItem(i, glassSlot);
			}
						
		}
		
		//Player Head
		ItemStack stats = new ItemStack(Material.PLAYER_HEAD,1);		
		
		SkullMeta statsMeta = (SkullMeta) stats.getItemMeta();
		
		statsMeta.setOwningPlayer(p);
		statsMeta.setDisplayName(Utils.chat("&c&lStats: &7") + p.getName());
		
		Profile profile = plugin.getProfileManager().getPlayerProfile(p);
		
		
		int mana = profile.getStats().getTotalMana();
		int physicalDamage= profile.getStats().getPhysicalDamage();
		int magicDamage = profile.getStats().getMagicDamage();
		int armor = profile.getStats().getArmor();
		int magicResist = profile.getStats().getMagicResist();
		double speed = profile.getStats().getSpeed();
		double critChance = Math.round(profile.getStats().getCriticalChance()*100.0)/100.0;
		double critDamage = Math.round(profile.getStats().getCriticalDamage()*100)/100.0;
		double burstChance = Math.round(profile.getStats().getBurstChance()*100)/100.0;
		double burstDamage = Math.round(profile.getStats().getBurstDamage()*100)/100.0;
		int CDR = profile.getStats().getCooldownReduction();
		double lifeSteal = Math.round(profile.getStats().getLifeSteal()*100)/100.0;
				
		List<String> statsLore = new ArrayList<String>();
		
		statsLore.add(Utils.chat("&7HP: &c") + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		statsLore.add(Utils.chat("&7Mana: &b") + mana);
		statsLore.add(Utils.chat("&7Defence: &1") + armor + Utils.chat(" &f| &5") + magicResist);
		statsLore.add(Utils.chat("&7Damage: &4") + physicalDamage + Utils.chat(" &f| &b") + magicDamage);
		statsLore.add(Utils.chat("&7Crit: &4") + critDamage + Utils.chat("x &f| &b") + critChance + '%');
		statsLore.add(Utils.chat("&7Burst: &c") + burstDamage + Utils.chat("x &f| &b") + burstChance + '%');
		statsLore.add(Utils.chat("&7LifeSteal: &f") + lifeSteal + Utils.chat("% &f| &b") );
		statsLore.add(Utils.chat("&7Speed: &f") + speed + Utils.chat(" &f| &b") + CDR);
		
		statsMeta.setLore(statsLore);
		stats.setItemMeta(statsMeta);
		
		menu.setItem(13, stats);;
		//Clock item
		int playTime = profile.getPlayTime();
		String playTimeFormat = TimeGenerator.secondsToString(playTime);
		
		Date currentDate = new Date();
		SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatDay = new SimpleDateFormat("EEEE");
		SimpleDateFormat formatZone = new SimpleDateFormat("z");
		
		ItemStack time = new ItemStack(Material.CLOCK,1);	
		ItemMeta timeMeta = time.getItemMeta();
		
		timeMeta.setDisplayName(Utils.chat("&6&lTime:"));
		List<String> timeLore = new ArrayList<String>();
		timeLore.add(Utils.chat("&7Day: &a") + formatDay.format(currentDate));
		timeLore.add(Utils.chat("&7Date: &a") + formatDate.format(currentDate));
		timeLore.add(Utils.chat("&7Time: &a") + formatTime.format(currentDate));
		timeLore.add(Utils.chat("&7TimeZone: &a") + formatZone.format(currentDate));
		timeLore.add(Utils.chat("&7PlayTime: &a") + playTimeFormat);
		timeMeta.setLore(timeLore);
		time.setItemMeta(timeMeta);
		menu.setItem(26, time);
		
		//Skills item
		ItemStack skills = new ItemStack(Material.BOOK,1);
		ItemMeta skillsMeta = skills.getItemMeta();
		
		skillsMeta.setDisplayName(Utils.chat("&a&lSkills"));
		List<String> SkillsLore = new ArrayList<String>();
		SkillsLore.add(Utils.chat("&7&oClick to see Skill Progression!"));
		
		skillsMeta.setLore(SkillsLore);
		skills.setItemMeta(skillsMeta);
		menu.setItem(18, skills);
		
		//BANK/MONEY item
		ItemStack bank = new ItemStack(Material.PLAYER_HEAD,1);		
		SkullMeta bankMeta = (SkullMeta) bank.getItemMeta();
		bankMeta.setDisplayName(Utils.chat("&a&lBalance"));
		GameProfile gameProfile = new GameProfile(UUID.randomUUID(),"");
		String bankValue = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTlkZGZiMDNjOGY3Zjc4MDA5YjgzNDRiNzgzMGY0YTg0MThmYTRiYzBlYjMzN2EzMzA1OGFiYjdhMDVlOTNlMSJ9fX0=";
		gameProfile.getProperties().put("textures", new Property("texture",bankValue));
		
		try {
			Field profileField = bankMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(bankMeta,gameProfile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> bankLore = new ArrayList<String>();
		bankLore.add(Utils.chat("&7Current Balance: &a$" + Math.round(profile.getBalance()*100)/100));
		
		bankMeta.setLore(bankLore);
		bank.setItemMeta(bankMeta);
		menu.setItem(22, bank);
		
		//Path item
		ItemStack path = new ItemStack(Material.ENDER_EYE,1);
		ItemMeta pathMeta = path.getItemMeta();
		
		pathMeta.setDisplayName(Utils.chat("&5&lPath"));
		List<String> pathLore = new ArrayList<String>();
		pathLore.add(Utils.chat("&7&oClick to see Path Information!"));
		
		pathMeta.setLore(pathLore);
		path.setItemMeta(pathMeta);
		menu.setItem(23, path);
		
		
		//Crafting Item
		ItemStack craft = new ItemStack(Material.CRAFTING_TABLE,1);
		ItemMeta craftMeta = craft.getItemMeta();
		
		craftMeta.setDisplayName(Utils.chat("&5&lCrafting"));
		List<String> craftLore = new ArrayList<String>();
		craftLore.add(Utils.chat("&7&oClick to open a virtual crafting grid!"));
		
		craftMeta.setLore(craftLore);
		craft.setItemMeta(craftMeta);
		menu.setItem(31, craft);
		
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
		Inventory menu = createGui(p);
		
		p.openInventory(menu);
		
		return true;
	}
	
}
