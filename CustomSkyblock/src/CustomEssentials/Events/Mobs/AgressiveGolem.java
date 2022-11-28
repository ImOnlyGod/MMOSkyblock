package CustomEssentials.Events.Mobs;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.IronGolem;

import CustomEssentials.Utils.Utils;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.EntityIronGolem;


public class AgressiveGolem extends EntityIronGolem{

	public AgressiveGolem(Location loc) {
		super(EntityTypes.P,((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(),loc.getY(),loc.getZ());
		
		this.setCustomName(new ChatComponentText(Utils.chat("&c&lAgressive Golem")));
		this.setCustomNameVisible(true);
		this.setCanPickupLoot(false);
		
		this.bP.a(0, new PathfinderGoalNearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		
		IronGolem IG = (IronGolem) this.getBukkitEntity();
		IG.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500f);;
		IG.setHealth(500);
		IG.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1200f);
		this.getWorld().addEntity(this);
		}
		
}


