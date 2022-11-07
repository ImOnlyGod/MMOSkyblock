package CustomEssentials.Events.ShopInfo;

import java.util.ArrayList;

import org.bukkit.Material;

public class GuiItems {
	
	ArrayList<Material> blocks = new ArrayList<Material>();
	ArrayList<Material> colorBlocks = new ArrayList<Material>();
	ArrayList<Material> decorativeBlocks = new ArrayList<Material>();
	ArrayList<Material> farming = new ArrayList<Material>();
	ArrayList<Material> foods = new ArrayList<Material>();
	ArrayList<Material> misc = new ArrayList<Material>();
	ArrayList<Material> gems = new ArrayList<Material>();
	ArrayList<Material> mobDrops = new ArrayList<Material>();
	ArrayList<Material> redstone = new ArrayList<Material>();
	ArrayList<Material> brewing = new ArrayList<Material>();
	
	public GuiItems() {
		setBlocksItems();
		setColorBlocksItems();
		setDecorationItems();
		setFarmingItems();
		setFoodItems();
		setMiscItems();
		setGemsItems();
		setMobItems();
		setRedstoneItems();
		setBrewingItems();
	}
	
	public void setBlocksItems() {
		this.blocks.add(Material.STONE);
		this.blocks.add(Material.COBBLESTONE);
		this.blocks.add(Material.MOSSY_COBBLESTONE);
		this.blocks.add(Material.GRANITE);
		this.blocks.add(Material.DIORITE);
		this.blocks.add(Material.ANDESITE);
		this.blocks.add(Material.STONE_BRICKS);
		this.blocks.add(Material.MOSSY_STONE_BRICKS);
		this.blocks.add(Material.CRACKED_STONE_BRICKS);
		this.blocks.add(Material.CHISELED_STONE_BRICKS);
		this.blocks.add(Material.POLISHED_GRANITE);
		this.blocks.add(Material.POLISHED_DIORITE);
		this.blocks.add(Material.POLISHED_ANDESITE);
		this.blocks.add(Material.DIRT);
		this.blocks.add(Material.ROOTED_DIRT);
		this.blocks.add(Material.GRASS_BLOCK);
		this.blocks.add(Material.PODZOL);
		this.blocks.add(Material.MYCELIUM);
		this.blocks.add(Material.SAND);
		this.blocks.add(Material.RED_SAND);
		this.blocks.add(Material.SANDSTONE);
		this.blocks.add(Material.RED_SANDSTONE);
		this.blocks.add(Material.SMOOTH_SANDSTONE);
		this.blocks.add(Material.SMOOTH_RED_SANDSTONE);
		this.blocks.add(Material.CHISELED_SANDSTONE);
		this.blocks.add(Material.CHISELED_RED_SANDSTONE);
		this.blocks.add(Material.OAK_PLANKS);
		this.blocks.add(Material.BIRCH_PLANKS);
		this.blocks.add(Material.SPRUCE_PLANKS);
		this.blocks.add(Material.DARK_OAK_PLANKS);
		this.blocks.add(Material.JUNGLE_PLANKS);
		this.blocks.add(Material.ACACIA_PLANKS);
		this.blocks.add(Material.OAK_LOG);
		this.blocks.add(Material.BIRCH_LOG);
		this.blocks.add(Material.SPRUCE_LOG);
		this.blocks.add(Material.DARK_OAK_LOG);
		this.blocks.add(Material.JUNGLE_LOG);
		this.blocks.add(Material.ACACIA_LOG);
		this.blocks.add(Material.GRAVEL);
		this.blocks.add(Material.CLAY);
		this.blocks.add(Material.BRICKS);
		this.blocks.add(Material.SNOW_BLOCK);
		this.blocks.add(Material.ICE);
		this.blocks.add(Material.PACKED_ICE);
		this.blocks.add(Material.BLUE_ICE);
		this.blocks.add(Material.OBSIDIAN);
		this.blocks.add(Material.PRISMARINE);
		this.blocks.add(Material.PRISMARINE_BRICKS);
		this.blocks.add(Material.DARK_PRISMARINE);
		this.blocks.add(Material.SEA_LANTERN);
		this.blocks.add(Material.DEAD_TUBE_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_BRAIN_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_BUBBLE_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_FIRE_CORAL_BLOCK);
		this.blocks.add(Material.DEAD_HORN_CORAL_BLOCK);
		this.blocks.add(Material.TUBE_CORAL_BLOCK);
		this.blocks.add(Material.BRAIN_CORAL_BLOCK);
		this.blocks.add(Material.BUBBLE_CORAL_BLOCK);
		this.blocks.add(Material.FIRE_CORAL_BLOCK);
		this.blocks.add(Material.HORN_CORAL_BLOCK);
		this.blocks.add(Material.NETHERRACK);
		this.blocks.add(Material.CRIMSON_NYLIUM);
		this.blocks.add(Material.WARPED_NYLIUM);
		this.blocks.add(Material.NETHER_BRICKS);
		this.blocks.add(Material.RED_NETHER_BRICKS);
		this.blocks.add(Material.CRACKED_NETHER_BRICKS);
		this.blocks.add(Material.CHISELED_NETHER_BRICKS);
		this.blocks.add(Material.CRIMSON_PLANKS);
		this.blocks.add(Material.WARPED_PLANKS);
		this.blocks.add(Material.CRIMSON_STEM);
		this.blocks.add(Material.WARPED_STEM);
		this.blocks.add(Material.WARPED_HYPHAE);
		this.blocks.add(Material.NETHER_WART_BLOCK);
		this.blocks.add(Material.WARPED_WART_BLOCK);
		this.blocks.add(Material.SOUL_SAND);
		this.blocks.add(Material.MAGMA_BLOCK);
		this.blocks.add(Material.GLOWSTONE);
		this.blocks.add(Material.BONE_BLOCK);
		this.blocks.add(Material.BLACKSTONE);
		this.blocks.add(Material.POLISHED_BLACKSTONE);
		this.blocks.add(Material.POLISHED_BLACKSTONE_BRICKS);
		this.blocks.add(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
		this.blocks.add(Material.CRYING_OBSIDIAN);
		this.blocks.add(Material.QUARTZ_BLOCK);
		this.blocks.add(Material.CHISELED_QUARTZ_BLOCK);
		this.blocks.add(Material.QUARTZ_PILLAR);
		this.blocks.add(Material.DEAD_TUBE_CORAL_BLOCK);
		this.blocks.add(Material.END_STONE);
		this.blocks.add(Material.PURPUR_BLOCK);
		this.blocks.add(Material.PURPUR_PILLAR);
	}
	
	public void setColorBlocksItems() {
		this.colorBlocks.add(Material.GLASS);
		this.colorBlocks.add(Material.WHITE_STAINED_GLASS);
		this.colorBlocks.add(Material.ORANGE_STAINED_GLASS);
		this.colorBlocks.add(Material.MAGENTA_STAINED_GLASS);
		this.colorBlocks.add(Material.LIGHT_BLUE_STAINED_GLASS);
		this.colorBlocks.add(Material.YELLOW_STAINED_GLASS);
		this.colorBlocks.add(Material.LIME_STAINED_GLASS);
		this.colorBlocks.add(Material.PINK_STAINED_GLASS);
		this.colorBlocks.add(Material.GRAY_STAINED_GLASS);
		this.colorBlocks.add(Material.LIGHT_GRAY_STAINED_GLASS);
		this.colorBlocks.add(Material.CYAN_STAINED_GLASS);
		this.colorBlocks.add(Material.PURPLE_STAINED_GLASS);
		this.colorBlocks.add(Material.BLUE_STAINED_GLASS);
		this.colorBlocks.add(Material.BROWN_STAINED_GLASS);
		this.colorBlocks.add(Material.GREEN_STAINED_GLASS);
		this.colorBlocks.add(Material.RED_STAINED_GLASS);
		this.colorBlocks.add(Material.TINTED_GLASS);
		this.colorBlocks.add(Material.TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_WOOL);
		this.colorBlocks.add(Material.ORANGE_WOOL);
		this.colorBlocks.add(Material.MAGENTA_WOOL);
		this.colorBlocks.add(Material.LIGHT_BLUE_WOOL);
		this.colorBlocks.add(Material.YELLOW_WOOL);
		this.colorBlocks.add(Material.LIME_WOOL);
		this.colorBlocks.add(Material.PINK_WOOL);
		this.colorBlocks.add(Material.GRAY_WOOL);
		this.colorBlocks.add(Material.LIGHT_GRAY_WOOL);
		this.colorBlocks.add(Material.CYAN_WOOL);
		this.colorBlocks.add(Material.PURPLE_WOOL);
		this.colorBlocks.add(Material.BLUE_WOOL);
		this.colorBlocks.add(Material.BROWN_WOOL);
		this.colorBlocks.add(Material.GREEN_WOOL);
		this.colorBlocks.add(Material.RED_WOOL);
		this.colorBlocks.add(Material.WHITE_TERRACOTTA);
		this.colorBlocks.add(Material.ORANGE_TERRACOTTA);
		this.colorBlocks.add(Material.MAGENTA_TERRACOTTA);
		this.colorBlocks.add(Material.LIGHT_BLUE_TERRACOTTA);
		this.colorBlocks.add(Material.YELLOW_TERRACOTTA);
		this.colorBlocks.add(Material.LIME_TERRACOTTA);
		this.colorBlocks.add(Material.PINK_TERRACOTTA);
		this.colorBlocks.add(Material.GRAY_TERRACOTTA);
		this.colorBlocks.add(Material.LIGHT_GRAY_TERRACOTTA);
		this.colorBlocks.add(Material.CYAN_TERRACOTTA);
		this.colorBlocks.add(Material.PURPLE_TERRACOTTA);
		this.colorBlocks.add(Material.BLUE_TERRACOTTA);
		this.colorBlocks.add(Material.BROWN_TERRACOTTA);
		this.colorBlocks.add(Material.GREEN_TERRACOTTA);
		this.colorBlocks.add(Material.RED_TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.ORANGE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.MAGENTA_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.YELLOW_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.LIME_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.PINK_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.GRAY_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.CYAN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.PURPLE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.BLUE_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.BROWN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.GREEN_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.RED_GLAZED_TERRACOTTA);
		this.colorBlocks.add(Material.WHITE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.ORANGE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.MAGENTA_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIGHT_BLUE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.YELLOW_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIME_CONCRETE_POWDER);
		this.colorBlocks.add(Material.PINK_CONCRETE_POWDER);
		this.colorBlocks.add(Material.GRAY_CONCRETE_POWDER);
		this.colorBlocks.add(Material.LIGHT_GRAY_CONCRETE_POWDER);
		this.colorBlocks.add(Material.CYAN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.PURPLE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.BLUE_CONCRETE_POWDER);
		this.colorBlocks.add(Material.BROWN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.GREEN_CONCRETE_POWDER);
		this.colorBlocks.add(Material.RED_CONCRETE_POWDER);
		this.colorBlocks.add(Material.WHITE_CONCRETE);
		this.colorBlocks.add(Material.ORANGE_CONCRETE);
		this.colorBlocks.add(Material.MAGENTA_CONCRETE);
		this.colorBlocks.add(Material.LIGHT_BLUE_CONCRETE);
		this.colorBlocks.add(Material.YELLOW_CONCRETE);
		this.colorBlocks.add(Material.LIME_CONCRETE);
		this.colorBlocks.add(Material.PINK_CONCRETE);
		this.colorBlocks.add(Material.GRAY_CONCRETE);
		this.colorBlocks.add(Material.LIGHT_GRAY_CONCRETE);
		this.colorBlocks.add(Material.CYAN_CONCRETE);
		this.colorBlocks.add(Material.PURPLE_CONCRETE);
		this.colorBlocks.add(Material.BLUE_CONCRETE);
		this.colorBlocks.add(Material.BROWN_CONCRETE);
		this.colorBlocks.add(Material.GREEN_CONCRETE);
		this.colorBlocks.add(Material.RED_CONCRETE);
	}
	
	public void setDecorationItems() {
		this.decorativeBlocks.add(Material.TORCH);
		this.decorativeBlocks.add(Material.SOUL_TORCH);
		this.decorativeBlocks.add(Material.IRON_BARS);
		this.decorativeBlocks.add(Material.CHAIN);
		this.decorativeBlocks.add(Material.LILY_PAD);
		this.decorativeBlocks.add(Material.OAK_SAPLING);
		this.decorativeBlocks.add(Material.BIRCH_SAPLING);
		this.decorativeBlocks.add(Material.SPRUCE_SAPLING);
		this.decorativeBlocks.add(Material.DARK_OAK_SAPLING);
		this.decorativeBlocks.add(Material.JUNGLE_SAPLING);
		this.decorativeBlocks.add(Material.ACACIA_SAPLING);
		this.decorativeBlocks.add(Material.OAK_LEAVES);
		this.decorativeBlocks.add(Material.BIRCH_LEAVES);
		this.decorativeBlocks.add(Material.SPRUCE_LEAVES);
		this.decorativeBlocks.add(Material.DARK_OAK_LEAVES);
		this.decorativeBlocks.add(Material.JUNGLE_LEAVES);
		this.decorativeBlocks.add(Material.ACACIA_LEAVES);
		this.decorativeBlocks.add(Material.AZALEA_LEAVES);
		this.decorativeBlocks.add(Material.FLOWERING_AZALEA_LEAVES);
		this.decorativeBlocks.add(Material.GRASS);
		this.decorativeBlocks.add(Material.FERN);
		this.decorativeBlocks.add(Material.AZALEA);
		this.decorativeBlocks.add(Material.FLOWERING_AZALEA);
		this.decorativeBlocks.add(Material.DEAD_BUSH);
		this.decorativeBlocks.add(Material.SEAGRASS);
		this.decorativeBlocks.add(Material.SEA_PICKLE);
		this.decorativeBlocks.add(Material.DANDELION);
		this.decorativeBlocks.add(Material.POPPY);
		this.decorativeBlocks.add(Material.BLUE_ORCHID);
		this.decorativeBlocks.add(Material.ALLIUM);
		this.decorativeBlocks.add(Material.AZURE_BLUET);
		this.decorativeBlocks.add(Material.RED_TULIP);
		this.decorativeBlocks.add(Material.ORANGE_TULIP);
		this.decorativeBlocks.add(Material.WHITE_TULIP);
		this.decorativeBlocks.add(Material.PINK_TULIP);
		this.decorativeBlocks.add(Material.OXEYE_DAISY);
		this.decorativeBlocks.add(Material.CORNFLOWER);
		this.decorativeBlocks.add(Material.LILY_OF_THE_VALLEY);
		this.decorativeBlocks.add(Material.WITHER_ROSE);
		this.decorativeBlocks.add(Material.SPORE_BLOSSOM);
		this.decorativeBlocks.add(Material.ORANGE_TULIP);
		this.decorativeBlocks.add(Material.SUNFLOWER);
		this.decorativeBlocks.add(Material.LILAC);
		this.decorativeBlocks.add(Material.ROSE_BUSH);
		this.decorativeBlocks.add(Material.ORANGE_TULIP);
		this.decorativeBlocks.add(Material.PEONY);
		this.decorativeBlocks.add(Material.TALL_GRASS);
		this.decorativeBlocks.add(Material.LARGE_FERN);		
		this.decorativeBlocks.add(Material.CRIMSON_ROOTS);
		this.decorativeBlocks.add(Material.WARPED_ROOTS);
		this.decorativeBlocks.add(Material.NETHER_SPROUTS);
		this.decorativeBlocks.add(Material.ORANGE_TULIP);
		this.decorativeBlocks.add(Material.MOSS_BLOCK);
		this.decorativeBlocks.add(Material.HANGING_ROOTS);
		this.decorativeBlocks.add(Material.BIG_DRIPLEAF);
		this.decorativeBlocks.add(Material.SMALL_DRIPLEAF);
		this.decorativeBlocks.add(Material.TUBE_CORAL);
		this.decorativeBlocks.add(Material.BUBBLE_CORAL);
		this.decorativeBlocks.add(Material.BRAIN_CORAL);
		this.decorativeBlocks.add(Material.FIRE_CORAL);
		this.decorativeBlocks.add(Material.HORN_CORAL);
		this.decorativeBlocks.add(Material.DEAD_TUBE_CORAL);
		this.decorativeBlocks.add(Material.DEAD_BUBBLE_CORAL);
		this.decorativeBlocks.add(Material.DEAD_BRAIN_CORAL);
		this.decorativeBlocks.add(Material.DEAD_FIRE_CORAL);
		this.decorativeBlocks.add(Material.DEAD_HORN_CORAL);
		this.decorativeBlocks.add(Material.TUBE_CORAL_FAN);
		this.decorativeBlocks.add(Material.BUBBLE_CORAL_FAN);
		this.decorativeBlocks.add(Material.BRAIN_CORAL_FAN);
		this.decorativeBlocks.add(Material.FIRE_CORAL_FAN);
		this.decorativeBlocks.add(Material.HORN_CORAL_FAN);
		this.decorativeBlocks.add(Material.DEAD_TUBE_CORAL_FAN);
		this.decorativeBlocks.add(Material.DEAD_BUBBLE_CORAL_FAN);
		this.decorativeBlocks.add(Material.DEAD_BRAIN_CORAL_FAN);
		this.decorativeBlocks.add(Material.DEAD_FIRE_CORAL_FAN);
		this.decorativeBlocks.add(Material.DEAD_HORN_CORAL_FAN);
		this.decorativeBlocks.add(Material.SHROOMLIGHT);
		
	}
	
	public void setFarmingItems() {
		this.farming.add(Material.WHEAT_SEEDS);
		this.farming.add(Material.WHEAT);
		this.farming.add(Material.BEETROOT_SEEDS);
		this.farming.add(Material.BEETROOT);
		this.farming.add(Material.CARROT);
		this.farming.add(Material.POTATO);
		this.farming.add(Material.MELON_SEEDS);
		this.farming.add(Material.MELON_SLICE);
		this.farming.add(Material.PUMPKIN);
		this.farming.add(Material.NETHER_WART);
		this.farming.add(Material.SUGAR_CANE);
		this.farming.add(Material.CACTUS);
		this.farming.add(Material.BAMBOO);
		this.farming.add(Material.COCOA_BEANS);
		this.farming.add(Material.KELP);
		this.farming.add(Material.VINE);
		this.farming.add(Material.GLOW_LICHEN);
		this.farming.add(Material.RED_MUSHROOM);
		this.farming.add(Material.BROWN_MUSHROOM);
		this.farming.add(Material.TWISTING_VINES);
		this.farming.add(Material.WEEPING_VINES);
		this.farming.add(Material.CRIMSON_FUNGUS);
		this.farming.add(Material.WARPED_FUNGUS);
		
	}
	
	public void setFoodItems() {
		this.foods.add(Material.ROTTEN_FLESH);
		this.foods.add(Material.SPIDER_EYE);
		this.foods.add(Material.APPLE);
		this.foods.add(Material.GOLDEN_APPLE);
		this.foods.add(Material.ENCHANTED_GOLDEN_APPLE);
		this.foods.add(Material.MELON_SLICE);
		this.foods.add(Material.DRIED_KELP);
		this.foods.add(Material.SWEET_BERRIES);
		this.foods.add(Material.GLOW_BERRIES);
		this.foods.add(Material.COOKIE);
		this.foods.add(Material.BREAD);
		this.foods.add(Material.BEETROOT);
		this.foods.add(Material.POTATO);
		this.foods.add(Material.POISONOUS_POTATO);
		this.foods.add(Material.BAKED_POTATO);
		this.foods.add(Material.CARROT);
		this.foods.add(Material.GOLDEN_CARROT);
		this.foods.add(Material.CHICKEN);
		this.foods.add(Material.RABBIT);
		this.foods.add(Material.PORKCHOP);
		this.foods.add(Material.BEEF);
		this.foods.add(Material.MUTTON);
		this.foods.add(Material.COOKED_CHICKEN);
		this.foods.add(Material.COOKED_RABBIT);
		this.foods.add(Material.COOKED_PORKCHOP);
		this.foods.add(Material.COOKED_BEEF);
		this.foods.add(Material.COOKED_MUTTON);
		this.foods.add(Material.SALMON);
		this.foods.add(Material.COD);
		this.foods.add(Material.TROPICAL_FISH);
		this.foods.add(Material.PUFFERFISH);
		this.foods.add(Material.COOKED_SALMON);
		this.foods.add(Material.COOKED_COD);
		this.foods.add(Material.PUMPKIN_PIE);
		this.foods.add(Material.MUSHROOM_STEW);
		this.foods.add(Material.BEETROOT_SOUP);
		this.foods.add(Material.RABBIT_STEW);
		this.foods.add(Material.CAKE);
		this.foods.add(Material.HONEY_BOTTLE);
		this.foods.add(Material.CHORUS_FRUIT);
	}
	
	public void setMobItems() {
		this.mobDrops.add(Material.CHICKEN);
		this.mobDrops.add(Material.RABBIT);
		this.mobDrops.add(Material.PORKCHOP);
		this.mobDrops.add(Material.BEEF);
		this.mobDrops.add(Material.MUTTON);
		this.mobDrops.add(Material.ROTTEN_FLESH);
		this.mobDrops.add(Material.ARROW);
		this.mobDrops.add(Material.BONE);
		this.mobDrops.add(Material.SPIDER_EYE);
		this.mobDrops.add(Material.STRING);
		this.mobDrops.add(Material.GUNPOWDER);
		this.mobDrops.add(Material.GLOWSTONE_DUST);
		this.mobDrops.add(Material.LEATHER);
		this.mobDrops.add(Material.RABBIT_HIDE);
		this.mobDrops.add(Material.FEATHER);
		this.mobDrops.add(Material.SLIME_BALL);
		this.mobDrops.add(Material.MAGMA_CREAM);
		this.mobDrops.add(Material.INK_SAC);
		this.mobDrops.add(Material.GLOW_INK_SAC);
		this.mobDrops.add(Material.ENDER_PEARL);
		this.mobDrops.add(Material.BLAZE_ROD);
		this.mobDrops.add(Material.GHAST_TEAR);
		this.mobDrops.add(Material.POPPY);
		this.mobDrops.add(Material.WITHER_ROSE);
		this.mobDrops.add(Material.IRON_INGOT);
		this.mobDrops.add(Material.GOLD_NUGGET);
		this.mobDrops.add(Material.GOLD_INGOT);
		this.mobDrops.add(Material.EMERALD);
		this.mobDrops.add(Material.PRISMARINE_CRYSTALS);
		this.mobDrops.add(Material.PRISMARINE_SHARD);
		this.mobDrops.add(Material.PHANTOM_MEMBRANE);
		this.mobDrops.add(Material.WITHER_SKELETON_SKULL);	
	}
	
	public void setGemsItems() {
		this.gems.add(Material.COAL);
		this.gems.add(Material.RAW_IRON);
		this.gems.add(Material.IRON_INGOT);
		this.gems.add(Material.RAW_COPPER);
		this.gems.add(Material.COPPER_INGOT);
		this.gems.add(Material.LAPIS_LAZULI);
		this.gems.add(Material.REDSTONE);
		this.gems.add(Material.RAW_GOLD);
		this.gems.add(Material.GOLD_INGOT);
		this.gems.add(Material.DIAMOND);
		this.gems.add(Material.EMERALD);
		this.gems.add(Material.NETHERITE_SCRAP);
		this.gems.add(Material.NETHERITE_INGOT);
	}
	
	public void setRedstoneItems() {
		this.redstone.add(Material.REDSTONE);
		this.redstone.add(Material.REDSTONE_TORCH);
		this.redstone.add(Material.REDSTONE_BLOCK);
		this.redstone.add(Material.REPEATER);
		this.redstone.add(Material.COMPARATOR);
		this.redstone.add(Material.PISTON);
		this.redstone.add(Material.STICKY_PISTON);
		this.redstone.add(Material.SLIME_BLOCK);
		this.redstone.add(Material.HONEY_BLOCK);
		this.redstone.add(Material.OBSERVER);
		this.redstone.add(Material.HOPPER);
		this.redstone.add(Material.MINECART);
		this.redstone.add(Material.RAIL);
		this.redstone.add(Material.POWERED_RAIL);
		this.redstone.add(Material.DETECTOR_RAIL);
		this.redstone.add(Material.ACTIVATOR_RAIL);
		this.redstone.add(Material.DISPENSER);
		this.redstone.add(Material.DROPPER);
		this.redstone.add(Material.LEVER);
		this.redstone.add(Material.STONE_BUTTON);
		this.redstone.add(Material.STONE_PRESSURE_PLATE);
		this.redstone.add(Material.LECTERN);
		this.redstone.add(Material.TARGET);
		this.redstone.add(Material.LIGHTNING_ROD);
		this.redstone.add(Material.DAYLIGHT_DETECTOR);
		this.redstone.add(Material.TRIPWIRE_HOOK);
		this.redstone.add(Material.CHEST);
		this.redstone.add(Material.TRAPPED_CHEST);
		this.redstone.add(Material.TNT);
		this.redstone.add(Material.REDSTONE_LAMP);
		this.redstone.add(Material.NOTE_BLOCK);
		this.redstone.add(Material.IRON_TRAPDOOR);
	}
	
	public void setMiscItems() {
		this.misc.add(Material.ENCHANTING_TABLE);
		this.misc.add(Material.ENDER_CHEST);
		this.misc.add(Material.JUKEBOX);
		this.misc.add(Material.ANVIL);
		this.misc.add(Material.PAINTING);
		this.misc.add(Material.ITEM_FRAME);
		this.misc.add(Material.GLOW_ITEM_FRAME);
		this.misc.add(Material.FLOWER_POT);
		this.misc.add(Material.ARMOR_STAND);
		this.misc.add(Material.WHITE_BANNER);
		this.misc.add(Material.LOOM);
		this.misc.add(Material.COMPOSTER);
		this.misc.add(Material.BARREL);
		this.misc.add(Material.FURNACE);
		this.misc.add(Material.SMOKER);
		this.misc.add(Material.BLAST_FURNACE);
		this.misc.add(Material.CARTOGRAPHY_TABLE);
		this.misc.add(Material.FLETCHING_TABLE);
		this.misc.add(Material.GRINDSTONE);
		this.misc.add(Material.SMITHING_TABLE);
		this.misc.add(Material.STONECUTTER);
		this.misc.add(Material.BELL);
		this.misc.add(Material.BEE_NEST);
		this.misc.add(Material.BEEHIVE);
		this.misc.add(Material.LODESTONE);
		this.misc.add(Material.RESPAWN_ANCHOR);
		this.misc.add(Material.CANDLE);
		this.misc.add(Material.POINTED_DRIPSTONE);
		this.misc.add(Material.SCAFFOLDING);
		this.misc.add(Material.BUCKET);
		this.misc.add(Material.WATER_BUCKET);
		this.misc.add(Material.LAVA_BUCKET);
		this.misc.add(Material.POWDER_SNOW_BUCKET);
		this.misc.add(Material.NAME_TAG);
		this.misc.add(Material.BOOK);
	}
	
	public void setBrewingItems() {
		this.brewing.add(Material.BREWING_STAND);
		this.brewing.add(Material.CAULDRON);
		this.brewing.add(Material.POTION);
		this.brewing.add(Material.NETHER_WART);
		this.brewing.add(Material.BLAZE_POWDER);
		this.brewing.add(Material.BLAZE_ROD);
		this.brewing.add(Material.REDSTONE);
		this.brewing.add(Material.GLOWSTONE_DUST);
		this.brewing.add(Material.GUNPOWDER);
		this.brewing.add(Material.SUGAR);
		this.brewing.add(Material.SPIDER_EYE);
		this.brewing.add(Material.FERMENTED_SPIDER_EYE);
		this.brewing.add(Material.GLISTERING_MELON_SLICE);
		this.brewing.add(Material.MAGMA_CREAM);
		this.brewing.add(Material.GHAST_TEAR);
		this.brewing.add(Material.GOLDEN_CARROT);
		this.brewing.add(Material.PUFFERFISH);
	}
	
	public ArrayList<Material> getBlocks() {
		return blocks;
	}
	public void setBlocks(ArrayList<Material> blocks) {
		this.blocks = blocks;
	}
	public ArrayList<Material> getColorBlocks() {
		return colorBlocks;
	}
	public void setColorBlocks(ArrayList<Material> colorBlocks) {
		this.colorBlocks = colorBlocks;
	}
	public ArrayList<Material> getDecorativeBlocks() {
		return decorativeBlocks;
	}
	public void setDecorativeBlocks(ArrayList<Material> decorativeBlocks) {
		this.decorativeBlocks = decorativeBlocks;
	}
	public ArrayList<Material> getFarming() {
		return farming;
	}
	public void setFarming(ArrayList<Material> farming) {
		this.farming = farming;
	}
	public ArrayList<Material> getFoods() {
		return foods;
	}
	public void setFoods(ArrayList<Material> foods) {
		this.foods = foods;
	}
	public ArrayList<Material> getMisc() {
		return misc;
	}
	public void setMisc(ArrayList<Material> misc) {
		this.misc = misc;
	}
	public ArrayList<Material> getGems() {
		return gems;
	}
	public void setGems(ArrayList<Material> gems) {
		this.gems = gems;
	}
	public ArrayList<Material> getMobDrops() {
		return mobDrops;
	}
	public void setMobDrops(ArrayList<Material> mobDrops) {
		this.mobDrops = mobDrops;
	}
	public ArrayList<Material> getRedstone() {
		return redstone;
	}
	public void setRedstone(ArrayList<Material> redstone) {
		this.redstone = redstone;
	}
	public ArrayList<Material> getBrewing() {
		return brewing;
	}
	public void setBrewing(ArrayList<Material> brewing) {
		this.brewing = brewing;
	}
	

}
