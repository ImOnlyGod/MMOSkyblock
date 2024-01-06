package CustomEssentials.WorldMechanics.playerIslands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class islandStats {
	
	private int islandId;
	private String islandName;
	private double islandSize=25;
	private int islandLevel = 0;
	private double islandCurrentXp = 0;
	private double islandLevelUpXp = 10; 
	private double islandValue = 0.0;
	private double islandBankBalance = 0.0;
	//team info
	private String islandOwner;
	private ArrayList<String> islandCoOwners = new ArrayList<String>();
	private ArrayList<String> islandAdmins = new ArrayList<String>();
	private ArrayList<String> islandMods = new ArrayList<String>();
	private ArrayList<String> islandMembers = new ArrayList<String>();	
	//island centre location
	private double centreX;
	private double centreY = 70.0;
	private double centreZ;
	private double centreYaw = 0.0;
	private double centrePitch = 0.0;
	//team spawn location
	private double teamSpawnX;
	private double teamSpawnY = 70.0;
	private double teamSpawnZ;
	private double teamSpawnYaw = 0.0;
	private double teamSpawnPitch = 0.0;
	//visitor spawn location
	private double visitorSpawnX;
	private double visitorSpawnY = 70.0;
	private double visitorSpawnZ;
	private double visitorSpawnYaw = 0.0;
	private double visitorSpawnPitch = 0.0;
	//Options
	private boolean visitors = false;
	private boolean border = true;
	private String borderColor = "Red";
	
	public islandStats(int islandID, Player owner, double x, double z) {
		this.islandId = islandID;
		this.islandName = "Default Island Name";
		this.islandOwner = owner.getUniqueId().toString();
		this.centreX = x;
		this.centreZ = z;
		this.teamSpawnX = x;
		this.teamSpawnZ = z;
		this.visitorSpawnX = x;
		this.visitorSpawnZ = z;
		
	}
	
	public void addIslandMember(Player member) {
		ArrayList<String> currentMembers = this.getIslandMembers();
		currentMembers.add(member.getUniqueId().toString());
		this.setIslandMembers(currentMembers);
	}

	public int getIslandLevel() {
		return islandLevel;
	}

	public void setIslandLevel(int islandLevel) {
		this.islandLevel = islandLevel;
	}

	public double getIslandCurrentXp() {
		return islandCurrentXp;
	}

	public void setIslandCurrentXp(double islandCurrentXp) {
		this.islandCurrentXp = islandCurrentXp;
	}

	public double getIslandLevelUpXp() {
		return islandLevelUpXp;
	}

	public void setIslandLevelUpXp(double islandLevelUpXp) {
		this.islandLevelUpXp = islandLevelUpXp;
	}

	public void setIslandSize(double islandSize) {
		this.islandSize = islandSize;
	}

	public void setCentreX(double centreX) {
		this.centreX = centreX;
	}

	public void setCentreY(double centreY) {
		this.centreY = centreY;
	}

	public void setCentreZ(double centreZ) {
		this.centreZ = centreZ;
	}

	public void setTeamSpawnX(double teamSpawnX) {
		this.teamSpawnX = teamSpawnX;
	}

	public void setTeamSpawnY(double teamSpawnY) {
		this.teamSpawnY = teamSpawnY;
	}

	public void setTeamSpawnZ(double teamSpawnZ) {
		this.teamSpawnZ = teamSpawnZ;
	}

	public void setVisitorSpawnX(double visitorSpawnX) {
		this.visitorSpawnX = visitorSpawnX;
	}

	public void setVisitorSpawnY(double visitorSpawnY) {
		this.visitorSpawnY = visitorSpawnY;
	}

	public void setVisitorSpawnZ(double visitorSpawnZ) {
		this.visitorSpawnZ = visitorSpawnZ;
	}

	public int getIslandId() {
		return islandId;
	}

	public void setIslandId(int islandId) {
		this.islandId = islandId;
	}

	public double getIslandSize() {
		return islandSize;
	}

	public void setIslandSize(int islandSize) {
		this.islandSize = islandSize;
	}

	public double getIslandValue() {
		return islandValue;
	}

	public void setIslandValue(double islandValue) {
		this.islandValue = islandValue;
	}

	public double getIslandBankBalance() {
		return islandBankBalance;
	}

	public void setIslandBankBalance(double islandBankBalance) {
		this.islandBankBalance = islandBankBalance;
	}

	public String getIslandOwner() {
		return islandOwner;
	}

	public void setIslandOwner(String islandOwner) {
		this.islandOwner = islandOwner;
	}

	public ArrayList<String> getIslandCoOwners() {
		return islandCoOwners;
	}

	public void setIslandCoOwners(ArrayList<String> islandCoOwners) {
		this.islandCoOwners = islandCoOwners;
	}

	public ArrayList<String> getIslandAdmins() {
		return islandAdmins;
	}

	public void setIslandAdmins(ArrayList<String> islandAdmins) {
		this.islandAdmins = islandAdmins;
	}

	public ArrayList<String> getIslandMods() {
		return islandMods;
	}

	public void setIslandMods(ArrayList<String> islandMods) {
		this.islandMods = islandMods;
	}

	public ArrayList<String> getIslandMembers() {
		return islandMembers;
	}

	public void setIslandMembers(ArrayList<String> islandMembers) {
		this.islandMembers = islandMembers;
	}

	public double getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		this.centreX = centreX;
	}

	public double getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		this.centreY = centreY;
	}

	public double getCentreZ() {
		return centreZ;
	}

	public void setCentreZ(int centreZ) {
		this.centreZ = centreZ;
	}

	public double getCentreYaw() {
		return centreYaw;
	}

	public void setCentreYaw(double centreYaw) {
		this.centreYaw = centreYaw;
	}

	public double getCentrePitch() {
		return centrePitch;
	}

	public void setCentrePitch(double centrePitch) {
		this.centrePitch = centrePitch;
	}

	public double getTeamSpawnX() {
		return teamSpawnX;
	}

	public void setTeamSpawnX(int teamSpawnX) {
		this.teamSpawnX = teamSpawnX;
	}

	public double getTeamSpawnY() {
		return teamSpawnY;
	}

	public void setTeamSpawnY(int teamSpawnY) {
		this.teamSpawnY = teamSpawnY;
	}

	public double getTeamSpawnZ() {
		return teamSpawnZ;
	}

	public void setTeamSpawnZ(int teamSpawnZ) {
		this.teamSpawnZ = teamSpawnZ;
	}

	public double getTeamSpawnYaw() {
		return teamSpawnYaw;
	}

	public void setTeamSpawnYaw(float teamSpawnYaw) {
		this.teamSpawnYaw = teamSpawnYaw;
	}

	public double getTeamSpawnPitch() {
		return teamSpawnPitch;
	}

	public void setTeamSpawnPitch(float teamSpawnPitch) {
		this.teamSpawnPitch = teamSpawnPitch;
	}

	public double getVisitorSpawnX() {
		return visitorSpawnX;
	}

	public void setVisitorSpawnX(int visitorSpawnX) {
		this.visitorSpawnX = visitorSpawnX;
	}

	public double getVisitorSpawnY() {
		return visitorSpawnY;
	}

	public void setVisitorSpawnY(int visitorSpawnY) {
		this.visitorSpawnY = visitorSpawnY;
	}

	public double getVisitorSpawnZ() {
		return visitorSpawnZ;
	}

	public void setVisitorSpawnZ(int visitorSpawnZ) {
		this.visitorSpawnZ = visitorSpawnZ;
	}

	public double getVisitorSpawnYaw() {
		return visitorSpawnYaw;
	}

	public void setVisitorSpawnYaw(float visitorSpawnYaw) {
		this.visitorSpawnYaw = visitorSpawnYaw;
	}

	public double getVisitorSpawnPitch() {
		return visitorSpawnPitch;
	}

	public void setVisitorSpawnPitch(float visitorSpawnPitch) {
		this.visitorSpawnPitch = visitorSpawnPitch;
	}

	public boolean isVisitors() {
		return visitors;
	}

	public void setVisitors(boolean visitors) {
		this.visitors = visitors;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getIslandName() {
		return islandName;
	}

	public void setIslandName(String islandName) {
		this.islandName = islandName;
	}
	
	
	
	
	
	
	

}
