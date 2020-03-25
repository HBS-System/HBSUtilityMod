package heartbrokensouls.hbsutilitymod.lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public enum ArmurMaterialList implements IArmorMaterial
{
	//1. Name it uses to find textures, requires "modid:"
	//2. Durability, sets durability
	//3. Damage reduction sets the armur level in order of Boots, Leggings, Chestplate, then Helmet.
	//4. Sets the item used to repair the armur.
	//5. The sound that plays when you equip armur.
	//6. Toughness of said armur.
	FLUORITE("hbsutilitymod:fluorite", 38, new int[]{4, 7, 9, 4}, 15, ItemList.fluorite_plate, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F);
	/*
	Diamond levels:
	
	Iron levels:
	
	Chain levels:
	
	Gold levels:
	
	Leather levels:
	 */
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11}; 
	private String name;
	private SoundEvent equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmountArray;
	private float toughness;
	private Item repairItem;
	
	private ArmurMaterialList(String name, int durability, int[] damageReductionAmountArray, int enchantability, Item repairItem, SoundEvent equipSound, float toughness)
	{
		
		this.name = name;
		this.durability = durability;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.equipSound = equipSound;
		this.toughness = toughness;
		
	}
	@Override
	public int getDurability(EquipmentSlotType slotIn) 
	{
		
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.durability;
	
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) 
	{
		
		return this.damageReductionAmountArray[slotIn.getIndex()];
		
	}

	@Override
	public int getEnchantability() 
	{
		
		return this.enchantability;
		
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		
		return this.equipSound;
		
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		
		return Ingredient.fromItems(this.repairItem);
		
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() 
	{
		
		return this.name;
		
	}

	@Override
	public float getToughness() 
	{
		
		return this.toughness;
		
	}
	
}
