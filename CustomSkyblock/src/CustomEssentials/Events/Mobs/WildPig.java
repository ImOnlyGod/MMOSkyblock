package CustomEssentials.Events.Mobs;

import java.lang.reflect.Field;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.attribute.CraftAttributeMap;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Pig;

import CustomEssentials.Utils.Utils;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.attributes.AttributeBase;
import net.minecraft.world.entity.ai.attributes.AttributeMapBase;
import net.minecraft.world.entity.ai.attributes.AttributeModifiable;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.EntityPig;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.player.EntityHuman;


public class WildPig extends EntityPig{

	private static Field attributeField;

    static {
        try {
            attributeField = AttributeMapBase.class.getDeclaredField("b");
            attributeField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
	
	public WildPig(Location loc,int level) {
		super(EntityTypes.an,((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(),loc.getY(),loc.getZ());
		
		try {
            registerGenericAttribute(this.getBukkitEntity(), Attribute.GENERIC_ATTACK_DAMAGE);
            registerGenericAttribute(this.getBukkitEntity(), Attribute.GENERIC_FOLLOW_RANGE);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
				
		this.setCustomName(null);
		this.setCustomName(new ChatComponentText(Utils.chat("&7&l[&a&l" + level + "&7&l] &6&l" +"&5&lWild Pig")));
		this.setCustomNameVisible(true);
		this.setCanPickupLoot(false);		
		
		Pig pig = (Pig) this.getBukkitEntity();
		
		pig.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(100f);
		pig.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3f);
		pig.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50f);
		
		pig.setHealth(50);
		this.getWorld().addEntity(this);
	}
	
	
	
	@Override
    public void initPathfinder() {
		super.initPathfinder(); 

        //  current attributes            add an attribute       the attribute to add            |lambda|        attribute value(acts very weird)
        this.getAttributeMap().b().add(new AttributeModifiable(GenericAttributes.f, (a) -> {a.setValue(1.0);}));
        this.getAttributeMap().b().add(new AttributeModifiable(GenericAttributes.a, (a) -> {a.setValue(1.0);}));
        // Adds attack goal to pig
        this.bP.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, false));

        this.bP.a(0, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
        this.bP.a(0, new PathfinderGoalNearestAttackableTarget<EntityZombie>(this, EntityZombie.class, true));
        this.bP.a(0, new PathfinderGoalFloat(this));
        this.bP.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
    }

    public void registerGenericAttribute(org.bukkit.entity.Entity entity, Attribute attribute) throws IllegalAccessException {
        AttributeMapBase attributeMapBase = ((CraftLivingEntity)entity).getHandle().getAttributeMap();
        @SuppressWarnings("unchecked")
		Map<AttributeBase, AttributeModifiable> map = (Map<AttributeBase, AttributeModifiable>) attributeField.get(attributeMapBase);
        AttributeBase attributeBase = CraftAttributeMap.toMinecraft(attribute);
        AttributeModifiable attributeModifiable = new AttributeModifiable(attributeBase, AttributeModifiable::getAttribute);
        map.put(attributeBase, attributeModifiable);
    }

}
	
	


