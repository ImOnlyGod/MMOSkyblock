package CustomEssentials.Events.Misc;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ProjectileCreator {
	
	public void projectileDamage(EntityDamageByEntityEvent e) {
		fireballDmg(e);
	}
	
	public void fireballDmg(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Fireball) {
			if (e.getDamager().getCustomName().equals("HadesBladeFireball")) {				
				Fireball f = (Fireball) e.getEntity();
				Player shooter = (Player) f.getShooter();
				if (e.getEntity() == shooter) {
					e.setDamage(0);
				}
				else e.setDamage(100);
			}
		}
	}

}
