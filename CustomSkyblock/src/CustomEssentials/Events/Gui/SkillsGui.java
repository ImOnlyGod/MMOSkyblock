package CustomEssentials.Events.Gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
	
	public Inventory createGui(Player p, Profile playerProfile) {
		
		Inventory menu = Bukkit.createInventory(null, 54,Utils.chat("&a&lSkills"));
		
		//Glass Slots
		for (int i = 0; i < menu.getSize(); i++) {
			if ((i < 19) || (i > 34)) {
				ItemStack glassSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				menu.setItem(i, glassSlot);
			}
						
		}
		
		//Player Skills
		MiningSkill mining = playerProfile.getMining();
		int miningLevel = mining.getLevel();
		Double currentMiningXp = mining.getCurrentXP();
		Double finalMiningXp = mining.getMaxXP();
		
		FarmingSkill farming = playerProfile.getFarming();
		int farmingLevel = farming.getLevel();
		Double currentFarmingXp = farming.getCurrentXP();
		Double finalFarmingXp = farming.getMaxXP();
		
		CombatSkill combat = playerProfile.getCombat();
		int combatLevel = combat.getLevel();
		Double currentCombatXp = combat.getCurrentXP();
		Double finalCombatXp = combat.getMaxXP();
		
		ForagingSkill foraging = playerProfile.getForaging();
		int foragingLevel = foraging.getLevel();
		Double currentForagingXp = foraging.getCurrentXP();
		Double finalForagingXp = foraging.getMaxXP();
		
		FishingSkill fishing = playerProfile.getFishing();
		int fishingLevel = fishing.getLevel();
		Double currentFishingXp = fishing.getCurrentXP();
		Double finalFishinXP = fishing.getMaxXP();
		
		
		
		//Add mining item
		ItemStack miningItem = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta miningItemMeta = miningItem.getItemMeta();
		miningItemMeta.setDisplayName(Utils.chat("&8&lMining Skill"));
		
		List<String> miningSkillLore = new ArrayList<String>();
		miningSkillLore.add(Utils.chat("&f&lLevel: &7" + miningLevel));
		miningSkillLore.add(Utils.chat("&f&lXp: &7" + currentMiningXp + "/" + finalMiningXp));

		
		miningItemMeta.setLore(miningSkillLore);
		miningItem.setItemMeta(miningItemMeta);
		menu.setItem(19, miningItem);
		
		
		
		//Add farming item
		
		//Add combat item
		
		//Add foraging item
		
		//Add fishing item
		
		
		
		
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
