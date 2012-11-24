package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemGoldCrossbow extends ItemCrossbow
{
    public ItemGoldCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.goldCrossbowsList.add(this);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.goldBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityGoldBolt(world, entityliving, 1.66F);
    	}
    	else if (player.inventory.hasItem(Items.ironBolt.shiftedIndex))
    	{
    		return new EntityIronBolt(world, entityliving, 1.66F);
    	}
    	else if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex))
    	{
    		return new EntityStoneBolt(world, entityliving, 1.66F);
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
    		return new EntityWoodBolt(world, entityliving, 1.66F);
    	}
		return new EntityGoldBolt(world, entityliving, 1.66F);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
    }

    @Override
    public int getCrossbowMaxDamage()
    {
    	return 33;
    }

    @Override
    public int getReloadTime()
    {
    	return 90;
    }

    @Override
    public Item requiredItem(EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.goldBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
        	return Items.goldBolt;
    	}
    	else if (player.inventory.hasItem(Items.ironBolt.shiftedIndex))
    	{
        	return Items.ironBolt;
    	}
    	else if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex))
    	{
        	return Items.stoneBolt;
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
        	return Items.woodBolt;
    	}
    	return Items.goldBolt;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/Mic'sMods/CrossbowMod/gui/gold.png";
    }
}