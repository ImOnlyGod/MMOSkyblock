package CustomEssentials.Events.Misc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;


public class ProjectileCreator {
	
	public double projectileDamage(Entity damager, Entity shooter, double currentDmg) {
		if ((damager instanceof Fireball)) return validProjectileDamage(damager,shooter,currentDmg);
		
		
		return currentDmg;
	}
	
	public double validProjectileDamage(Entity damager, Entity shooter, double currentDmg) {
		if ((damager.getCustomName() != null)) return fireballDamage(damager,shooter,currentDmg);
		
		
		return currentDmg;
	}
	
	public double fireballDamage(Entity damager, Entity shooter, double currentDmg) {
		if ((damager.getCustomName().equals(("HadesBladeFireball")))) return fireballDmg(damager,shooter,currentDmg);
		 return currentDmg;
	}
	
	//ADD BURST DMG
	public double fireballDmg(Entity damager, Entity shooter, double currentDmg) {
		
		Player weaponHolder = (Player) ((Fireball) damager).getShooter();
		if (weaponHolder == shooter) return 0;
		return 100;		
		
	}

}
