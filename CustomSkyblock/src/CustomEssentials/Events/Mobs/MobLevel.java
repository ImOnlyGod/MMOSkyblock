package CustomEssentials.Events.Mobs;

public class MobLevel{
	
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	private void setDistanceLevel(int dist) {
		this.level = Math.max(1,Math.toIntExact(Math.abs(dist)/100));
	}
	
	public int getHealth(int dist) {
		setDistanceLevel(dist);
		int health = (int) Math.max(1,Math.floor(this.level * 200));
		
		return health;		
	}
		
}
