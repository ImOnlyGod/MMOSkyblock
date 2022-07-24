package CustomEssentials.Utils;

import CustomEssentials.Events.Profile;

public class StatsUtil {
	
	public static String miningActionBarMessage(Profile profile) {
		return Utils.chat("&b&lMining&7&l: (&c&l" + 
				Math.toIntExact(profile.getMining().getLevel()) + 
				"&7&l) &8&l[&a&l" + 
				Math.floor(profile.getMining().getCurrentXP()) + 
				"&7&l/&a&l" + Math.floor(profile.getMining().getMaxXP()) + "&8&l]");
	}
	
	public static String miningActionBarLevelUp(Profile profile) {
		return Utils.chat("&aYou have levelled up Mining to&7: &5" + 
				Math.toIntExact(profile.getMining().getLevel()));
	}
	
	public static String foragingActionBarMessage(Profile profile) {
		return Utils.chat("&5&lForaging&7&l: (&c&l" + 
				Math.toIntExact(profile.getForaging().getLevel()) + 
				"&7&l) &8&l[&a&l" + 
				Math.floor(profile.getForaging().getCurrentXP()) + 
				"&7&l/&a&l" + Math.floor(profile.getForaging().getMaxXP()) + "&8&l]");
	}
	
	public static String foragingActionBarLevelUp(Profile profile) {
		return Utils.chat("&aYou have levelled up Foraging to&7: &5" + 
				Math.toIntExact(profile.getForaging().getLevel()));
	}
	
	public static String farmingActionBarMessage(Profile profile) {
		return Utils.chat("&a&lFarming&7&l: (&c&l" + 
				Math.toIntExact(profile.getFarming().getLevel()) + 
				"&7&l) &8&l[&a&l" + 
				Math.floor(profile.getFarming().getCurrentXP()) + 
				"&7&l/&a&l" + Math.floor(profile.getFarming().getMaxXP()) + "&8&l]");
	}
	
	public static String farmingActionBarLevelUp(Profile profile) {
		return Utils.chat("&aYou have levelled up Farming to&7: &5" + 
				Math.toIntExact(profile.getFarming().getLevel()));
	}
	
	public static String combatActionBarMessage(Profile profile) {
		return Utils.chat("&4&lCombat&7&l: (&c&l" + 
				Math.toIntExact(profile.getCombat().getLevel()) + 
				"&7&l) &8&l[&a&l" + 
				Math.floor(profile.getCombat().getCurrentXP()) + 
				"&7&l/&a&l" + Math.floor(profile.getCombat().getMaxXP()) + "&8&l]");
	}
	
	public static String combatActionBarLevelUp(Profile profile) {
		return Utils.chat("&aYou have levelled up Combat to&7: &5" +
				Math.toIntExact(profile.getCombat().getLevel()));
	}
	
	public static String fishingActionBarMessage(Profile profile) {
		return Utils.chat("&d&lFishing&7&l: (&c&l" + 
				Math.toIntExact(profile.getFishing().getLevel()) + 
				"&7&l) &8&l[&a&l" + 
				Math.floor(profile.getFishing().getCurrentXP()) + 
				"&7&l/&a&l" + Math.floor(profile.getFishing().getMaxXP()) + "&8&l]");
	}
	
	public static String fishingActionBarLevelUp(Profile profile) {
		return Utils.chat("&aYou have levelled up Fishing to&7: &5" + 
				Math.toIntExact(profile.getFishing().getLevel()));
	}
	
	

}
