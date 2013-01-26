package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStoneCrossbow extends ItemCrossbow
{
    public ItemStoneCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.stoneCrossbowsList.add(this);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving, float f)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;

    	if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 1)) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityStoneBolt(world, entityliving, 1.0F, f);
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 0)))
    	{
    		return new EntityWoodBolt(world, entityliving, 1.0F, f);
    	}
		return new EntityStoneBolt(world, entityliving, 1.0F, f);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	return this.getEntity(world, entityliving, 0.0F);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri));
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
    public int requiredMetadata(EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;

    	if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 1)) || (player.capabilities.isCreativeMode))
    	{
        	return 1;
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 0)))
    	{
        	return 0;
    	}
    	return 1;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/micdoodle8/mods/crossbowmod/resources/gui/stone.png";
    }
}