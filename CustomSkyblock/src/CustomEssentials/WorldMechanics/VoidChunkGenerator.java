package CustomEssentials.WorldMechanics;

import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class VoidChunkGenerator extends ChunkGenerator{
	
	@SuppressWarnings("deprecation")
	@Override
	@Nonnull
	public ChunkData generateChunkData(@Nonnull World world,@Nonnull Random random, int x, int z, @Nonnull BiomeGrid biome) {
		return createChunkData(world);
	}

}
