package CustomEssentials.Events.Mobs.CustomMobs;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.generator.model.ModelBlueprint;
import com.ticxo.modelengine.api.model.ActiveModel;

import CustomEssentials.Utils.Utils;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.EntityIronGolem;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.level.World;


public class AgressiveGolem extends EntityIronGolem{

	public AgressiveGolem(Location loc,int level) {
		super(EntityTypes.P,((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(),loc.getY(),loc.getZ());
		
		this.setCustomName(new ChatComponentText(Utils.chat("&7&l[&a&l" + level + "&7&l] &6&l" +"&c&lAgressive Golem")));
		this.setCustomNameVisible(true);
		this.setCanPickupLoot(false);
		
		this.bP.a(0, new PathfinderGoalNearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		
		IronGolem IG = (IronGolem) this.getBukkitEntity();
		
		ModelBlueprint model = ModelEngineAPI.getBlueprint("rocky");
		ActiveModel mob = ModelEngineAPI.createActiveModel(model);
		ModelEngineAPI.getOrCreateModeledEntity(IG).addModel(mob, true);
		
		ArmorStand nameTag = (ArmorStand) IG.getWorld().spawn(loc.add(0,3,0), ArmorStand.class, armorstand->{
			armorstand.setInvisible(true);
			armorstand.setVisible(false);
			armorstand.setInvulnerable(true);
			armorstand.setBasePlate(false);
			armorstand.setCustomName(IG.getCustomName());
			armorstand.setCustomNameVisible(true);
			armorstand.setGravity(true);
			armorstand.setCollidable(false);
			
		});
		
		IG.addPassenger(nameTag);
		IG.setInvisible(true);
		IG.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500f);;
		IG.setHealth(500);
		IG.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1200f);
		this.getWorld().addEntity(this,CreatureSpawnEvent.SpawnReason.NATURAL);
		}
		
}


