package CustomEssentials.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import CustomEssentials.Main;
import CustomEssentials.Events.Profile;
import CustomEssentials.Events.PlayerSkills.Skills;
import CustomEssentials.Events.PlayerStats.Stats;
import CustomEssentials.Utils.Utils;

public class AdminSkillCommand implements TabExecutor{

	private Main plugin; 
	
	public AdminSkillCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("adminskill").setExecutor(this);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		List<String> action = new ArrayList<String>();
		action.add("add");
		action.add("remove");
		action.add("set");
		
		List<String> players = new ArrayList<String>();
		for (Player p:Bukkit.getServer().getOnlinePlayers()) {
			players.add(p.getName());
		}
		
		List<String> skills = new ArrayList<String>();
		skills.add("combat");
		skills.add("mining");
		skills.add("farming");
		skills.add("foraging");
		skills.add("fishing");
		skills.add("economist");
		skills.add("enchanting");
		
		List<String> actionOption = new ArrayList<String>();
		actionOption.add("xp");
		actionOption.add("levels");
		actionOption.add("xpMultiplier");
		actionOption.add("globalXpMultiplier");
		
		if (arg3.length == 1) return players;
		else if (arg3.length == 2) return skills;
		else if (arg3.length == 3) return action;
		else if (arg3.length == 4) return actionOption;
		
		return null;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		CommandSender sender = arg0;
		String[] args = arg3;
		
		if (sender instanceof Player && !sender.hasPermission("adminskill")) return false;
		if (args.length < 5) {
			sender.sendMessage("ADD INVAID COMMAND MSG");
			return false;
		}
		
		boolean valid = false;
		
		for ( Player p: Bukkit.getOnlinePlayers()) {
			if (p == Bukkit.getPlayer(args[0])) {
				valid = true;
				break;
			}
		}
			
		if (!(valid)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("General.player_not_found_error_msg")));
			return false;
		}
		
		try {
			Double.parseDouble(args[4]);
		} catch(Exception e) {
			sender.sendMessage(Utils.chat("NOT VALID NUMBER"));
			return false;
		}
	
		Player target = Bukkit.getPlayer(args[0]);
		Profile targetProfile = this.plugin.getProfileManager().getPlayerProfile(target);
		Double amount = Double.parseDouble(args[4]);
		
		if (args[2].equalsIgnoreCase("add")) {
			executeGive(target,getSkill(args[1],targetProfile),amount,args[3]);
		}
		else if (args[2].equalsIgnoreCase("remove")) {
			executeTake(target,getSkill(args[1],targetProfile),amount,args[3]);
		}
		else if (args[2].equalsIgnoreCase("set")) {
			executeSet(target,getSkill(args[1],targetProfile),amount,args[3]);
		}		
		
		return true;
	}
	
	public void executeGive(Player p, Skills skill, double amount, String action) {
		if (skill == null || amount < 0) return;
		
		if (action.equalsIgnoreCase("xp")) {
			skill.addCurrentXP(amount);
			p.sendMessage(skill.toString() + " xp recieved!");
			while (skill.getCurrentXP() >= skill.getMaxXP()) {
				skill.levelUp();
				addStats(skill,p);
			}
		}
		else if (action.equalsIgnoreCase("xpMultiplier")) {
			double currentMultiplier = skill.getXpMultiplier();
			skill.setXpMultiplier(currentMultiplier+amount);
		}
		else if (action.equalsIgnoreCase("globalXpMultiplier")) {
			double currentMultiplier = skill.getGlobalXpMultiplier();
			skill.setGlobalXpMultiplier(currentMultiplier+amount);
		}
		else if (action.equalsIgnoreCase("levels")) {
			for (int i=0;i<(int) amount;i++) {
				skill.levelUp();
				addStats(skill,p);
			}
		}
		
	}
	
	public void executeTake(Player p, Skills skill, double amount, String action) {
		if (skill == null || amount < 0) return;
		
		if (action.equalsIgnoreCase("xp") && (skill.getCurrentXP()-amount) >= 0) {
			skill.setCurrentXP(skill.getCurrentXP()-amount);
		}
		else if (action.equalsIgnoreCase("xpMultiplier") && (skill.getXpMultiplier()-amount) >= 0) {
			skill.setXpMultiplier(skill.getXpMultiplier()-amount);
		}
		else if (action.equalsIgnoreCase("globalXpMultiplier") && (skill.getGlobalXpMultiplier()-amount) >= 0) {
			skill.setGlobalXpMultiplier(skill.getXpMultiplier()-amount);
		}
		else if (action.equalsIgnoreCase("levels") && (skill.getLevel()-amount) >= 0) {
			int finalLevel = (int) (skill.getLevel()-amount);
			skill.setCurrentXP(0.0);
			skill.setMaxXP(10.0);
			
			for (int i=0;i<(int) amount;i++) {
				reduceStats(skill,p);
				skill.setLevel(skill.getLevel()-1);
			}
			
			skill.setLevel(0);
			for (int i=0;i<finalLevel;i++) {
				skill.levelUp();
			}			
		}
		
	}

	public void executeSet(Player p, Skills skill, double amount, String action) {
		if (skill == null || amount < 0) return;
		
		if (action.equalsIgnoreCase("xp") && amount < skill.getMaxXP()) {
			skill.setCurrentXP(amount);
		}
		else if (action.equalsIgnoreCase("xpMultiplier")) {
			skill.setXpMultiplier(amount);
		}
		else if (action.equalsIgnoreCase("globalXpMultiplier")) {
			skill.setGlobalXpMultiplier(amount);
		}
		else if (action.equalsIgnoreCase("levels")) {
			final int currentLevel = skill.getLevel();
			skill.setCurrentXP(0.0);
			skill.setMaxXP(10.0);
			
			for (int i=0;i<currentLevel;i++) {
				reduceStats(skill,p);
				skill.setLevel(skill.getLevel()-1);
			}
			
			skill.setLevel(0);
			
			for (int i=0;i<amount;i++) {
				skill.levelUp();
				addStats(skill, p);
			}			
		}
		
		
	}
	
	public Skills getSkill(String skillName, Profile playerProfile) {
		if (skillName.equalsIgnoreCase("combat")) return playerProfile.getCombat();
		else if (skillName.equalsIgnoreCase("mining")) return playerProfile.getMining();
		else if (skillName.equalsIgnoreCase("farming")) return playerProfile.getFarming();
		else if (skillName.equalsIgnoreCase("foraging")) return playerProfile.getForaging();
		else if (skillName.equalsIgnoreCase("fishing")) return playerProfile.getFishing();
		return null;
	}
	
	public void addStats(Skills skill, Player p) {
		String skillName = skill.toString().toLowerCase();
		Stats stats = this.plugin.getProfileManager().getPlayerProfile(p).getStats();
		int level = skill.getLevel();
		
		if (skillName.contains("combatskill")) stats.levelUpCombat(level);
		else if (skillName.contains("farmingskill")) stats.levelUpFarming(level);
		else if (skillName.contains("foragingskill")) stats.levelUpForaging(level);
		else if (skillName.contains("miningskill")) stats.levelUpMining(level);
		else if (skillName.contains("fishingskill")) stats.levelUpFishing(level);
	}
	
	public void reduceStats(Skills skill, Player p) {
		String skillName = skill.toString().toLowerCase();
		Stats stats = this.plugin.getProfileManager().getPlayerProfile(p).getStats();
		int level = skill.getLevel();
		
		if (skillName.contains("combatskill")) stats.levelDownCombat(level);
		else if (skillName.contains("farmingskill")) stats.levelDownFarming(level);
		else if (skillName.contains("foragingskill")) stats.levelDownForaging(level);
		else if (skillName.contains("miningskill")) stats.levelDownMining(level);
		else if (skillName.contains("fishingskill")) stats.levelDownFishing(level);
	}
}
