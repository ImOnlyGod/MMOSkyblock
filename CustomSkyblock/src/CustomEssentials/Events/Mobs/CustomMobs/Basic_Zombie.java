package CustomEssentials.Events.Mobs.CustomMobs;

import org.bukkit.Location;


import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import CustomEssentials.Utils.Utils;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalAvoidTarget;
import net.minecraft.world.entity.ai.goal.PathfinderGoalPanic;
import net.minecraft.world.entity.monster.EntityZombie;


public class Basic_Zombie extends EntityZombie{

	public Basic_Zombie(Location loc, int level) {
		super(((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(),loc.getY(),loc.getZ());
		
		this.setCustomName(new ChatComponentText(Utils.chat("&7&l[&a&l" + level + "&7&l] &6&l" +"&7&lBasic Zombie")));
		this.setCanPickupLoot(false);
		this.bP.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 15,1,1));
		this.bP.a(1, new PathfinderGoalPanic(this,1));
		
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET,1);
		Zombie zombie = (Zombie) this.getBukkitEntity();
		zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500f);
		zombie.setHealth(500);
		zombie.getEquipment().setHelmet(helmet);
		zombie.setCanPickupItems(true);
		this.getWorld().addEntity(this,CreatureSpawnEvent.SpawnReason.NATURAL);			
		
		}
	
		
	
}


