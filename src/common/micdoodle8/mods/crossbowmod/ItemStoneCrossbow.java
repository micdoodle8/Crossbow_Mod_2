package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemStoneCrossbow extends ItemCrossbow
{
    public ItemStoneCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.stoneCrossbowsList.add(this);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityStoneBolt(world, entityliving, 1.0F);
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
    		return new EntityWoodBolt(world, entityliving, 1.0F);
    	}
		return new EntityStoneBolt(world, entityliving, 1.0F);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
    }

    @Override
    public int getCrossbowMaxDamage()
    {
    	return 132;
    }

    @Override
    public int getReloadTime()
    {
    	return 70;
    }

    @Override
    public Item requiredItem(EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
        	return Items.stoneBolt;
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
        	return Items.woodBolt;
    	}
    	return Items.stoneBolt;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/Mic'sMods/CrossbowMod/gui/stone.png";
    }
}