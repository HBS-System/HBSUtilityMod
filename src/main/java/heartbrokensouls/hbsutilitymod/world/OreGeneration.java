package heartbrokensouls.hbsutilitymod.world;

import heartbrokensouls.hbsutilitymod.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreGeneration
{

    private static final CountRangeConfig fluorite_cfg = new CountRangeConfig(3, 30, 0, 15);
    private static final int fluorite_veinsize = 4;

	public static void setupOreGen()
    {
		
    	for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {

            if (  biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER)
            {
            	
                continue;
                
            }
            
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    		 Biome.createDecoratedFeature(Feature.ORE,
                    				 					  new OreFeatureConfig(
                    				 					  OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    				 					  BlockList.fluorite_ore.getDefaultState(),
                    				 					  fluorite_veinsize
                    				 							  			  ),
                    				 					  Placement.COUNT_RANGE,
                    				 					  fluorite_cfg
                    				 					  )
                    		);
            
        }
    	
	}
	
}
