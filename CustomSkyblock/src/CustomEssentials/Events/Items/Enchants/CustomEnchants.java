package CustomEssentials.Events.Items.Enchants;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;

public class CustomEnchants {
	
	public static final Enchantment VACUUM = new EnchantmentWrapper("vacuum","Vacuum",1,EnchantmentTarget.TOOL);
	public static final Enchantment BRUTE = new EnchantmentWrapper("brute","Brute",5,EnchantmentTarget.WEAPON);
	public static final Enchantment EXPERIENCE_EXTRACTOR = new EnchantmentWrapper("experience_extractor","Experience_extractor",2,EnchantmentTarget.WEAPON);
	public static final Enchantment PICKPOCKET = new EnchantmentWrapper("pickpocket","Pickpocket",11,EnchantmentTarget.WEAPON);
	public static final Enchantment COLLECTION = new EnchantmentWrapper("collection","Collection",4,EnchantmentTarget.WEAPON);
	public static final Enchantment PROSPERITY = new EnchantmentWrapper("prosperity","Prosperity",4,EnchantmentTarget.WEAPON);
	public static final Enchantment JIGSAW = new EnchantmentWrapper("jigsaw","Jigsaw",3,EnchantmentTarget.TOOL);
	public static final Enchantment GEM_EXTRACTOR = new EnchantmentWrapper("gem_extractor","Gem_extractor",5,EnchantmentTarget.TOOL);
	public static final Enchantment GIANT = new EnchantmentWrapper("giant","Giant",10,EnchantmentTarget.ARMOR);
	
	public static void register() {
		boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(VACUUM);
		if (!registered) {
			registerEnchantment(VACUUM);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(BRUTE);
		if (!registered) {
			registerEnchantment(BRUTE);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(EXPERIENCE_EXTRACTOR);
		if (!registered) {
			registerEnchantment(EXPERIENCE_EXTRACTOR);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(PICKPOCKET);
		if (!registered) {
			registerEnchantment(PICKPOCKET);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(COLLECTION);
		if (!registered) {
			registerEnchantment(COLLECTION);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(PROSPERITY);
		if (!registered) {
			registerEnchantment(PROSPERITY);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(JIGSAW);
		if (!registered) {
			registerEnchantment(JIGSAW);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(GEM_EXTRACTOR);
		if (!registered) {
			registerEnchantment(GEM_EXTRACTOR);
		}
		registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(GIANT);
		if (!registered) {
			registerEnchantment(GIANT);
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
