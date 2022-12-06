package CustomEssentials.Events.Items.Enchants;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;

public class CustomEnchants {
	
	public static final Enchantment VACUUM = new EnchantmentWrapper("vacuum","Vacuum",1,EnchantmentTarget.TOOL);
	
	public static void register() {
		boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(VACUUM);
		if (!registered) {
			registerEnchantment(VACUUM);
		}
	}
	
	public static void registerEnchantment(Enchantment enchantment) {
		boolean registered = true;
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
			Enchantment.registerEnchantment(enchantment);
			
		} catch(Exception e) {
			registered = false;
			e.printStackTrace();
		}
		
		if (registered) {
			System.out.println("Enchantment Registered");
		}
		
		
	}
	
}
