package heartbrokensouls.hbsutilitymod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import heartbrokensouls.hbsutilitymod.lists.ArmurMaterialList;
import heartbrokensouls.hbsutilitymod.lists.BlockList;
import heartbrokensouls.hbsutilitymod.lists.ItemList;
import heartbrokensouls.hbsutilitymod.lists.ToolMaterials;
import heartbrokensouls.hbsutilitymod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hbsutilitymod")
public class Main 
{

	public static Main instance;
	public static final String modid = "hbsutilitymod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public Main() 
	{
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) 
    {
		
		OreGeneration.setupOreGen();
		logger.info("Setup Method Registered");
		
	}

	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		
		logger.info("clientRegistries Method Registered");
		
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			
			event.getRegistry().registerAll
			(
				
				ItemList.compression_plate = new Item(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64)).setRegistryName(location("compression_plate")),
				
				ItemList.compressed_coal = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("compressed_coal")),
				
				ItemList.diamond_shard = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("diamond_shard")),
						
				ItemList.diamond_chunk = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("diamond_chunk")),
				
				ItemList.compressed_coal_block = new BlockItem(BlockList.compressed_coal_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.compressed_coal_block.getRegistryName()),
						
				ItemList.fluorite_ore = new BlockItem(BlockList.fluorite_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.fluorite_ore.getRegistryName()),
										
				ItemList.fluorite_block = new BlockItem(BlockList.fluorite_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.fluorite_block.getRegistryName()),
						
				ItemList.fluorite_gem = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("fluorite_gem")),
						
				ItemList.fluorite_plate = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("fluorite_plate")),
				
				ItemList.fluorite_sword = new SwordItem(ToolMaterials.FLUORITE, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("fluorite_sword")),
				
				ItemList.fluorite_pickaxe = new PickaxeItem(ToolMaterials.FLUORITE, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("fluorite_pickaxe")),
				
				ItemList.fluorite_axe = new AxeItem(ToolMaterials.FLUORITE, 5, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("fluorite_axe")),
				
				ItemList.fluorite_shovel = new ShovelItem(ToolMaterials.FLUORITE, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("fluorite_shovel")),
				
				ItemList.fluorite_hoe = new HoeItem(ToolMaterials.FLUORITE, 0.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("fluorite_hoe")),
				
				ItemList.fluorite_helmet = new ArmorItem(ArmurMaterialList.FLUORITE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("fluorite_helmet")),
				
				ItemList.fluorite_chestplate = new ArmorItem(ArmurMaterialList.FLUORITE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("fluorite_chestplate")),
						
				ItemList.fluorite_leggings = new ArmorItem(ArmurMaterialList.FLUORITE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("fluorite_leggings")),
								
				ItemList.fluorite_boots = new ArmorItem(ArmurMaterialList.FLUORITE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("fluorite_boots"))
				
			);
			
			logger.info("Items registered.");
			
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			
			event.getRegistry().registerAll
			(
				
				BlockList.compressed_coal_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(9.0f, 9.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("compressed_coal_block")),

				BlockList.fluorite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)).setRegistryName(location("fluorite_ore")),

				BlockList.fluorite_block = new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(5.0f, 5.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(3).sound(SoundType.METAL)).setRegistryName(location("fluorite_block"))				

			);
			
			logger.info("Blocks registered.");
			
		}
		
		private static ResourceLocation location(String name)
		{
			
			return new ResourceLocation(modid, name);
			
		}
		
	}
	
}
