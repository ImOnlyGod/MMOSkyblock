package CustomEssentials.Events.Mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalAvoidTarget;
import net.minecraft.world.entity.ai.goal.PathfinderGoalPanic;
import net.minecraft.world.entity.monster.EntityZombie;






public class Basic_Zombie extends EntityZombie{

	@SuppressWarnings("deprecation")
	public Basic_Zombie(Location loc) {
		super(((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(),loc.getY(),loc.getZ());
		
				
		this.setCustomName(null);
		this.setCustomName(new ChatComponentText("Noob"));
		this.setCustomNameVisible(true);
		
		this.setCanPickupLoot(false);
		
		this.bP.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 15,1,1));
		this.bP.a(1, new PathfinderGoalPanic(this,5));
		
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET,1);
		Zombie zombie = (Zombie) this.getBukkitEntity();
		
		zombie.setMaxHealth(500);
		zombie.setHealth(500);
		zombie.getEquipment().setHelmet(helmet);
		
		
		this.getWorld().addEntity(this);
		}
		
	
}


