package micdoodle8.mods.crossbowmod;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGoldCrossbow extends ItemCrossbow
{
    public ItemGoldCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.goldCrossbowsList.add(this);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving, float f)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;

    	if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 3)) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityGoldBolt(world, entityliving, 1.66F, f);
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 2)))
    	{
    		return new EntityIronBolt(world, entityliving, 1.66F, f);
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 1)))
    	{
    		return new EntityStoneBolt(world, entityliving, 1.66F, f);
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 0)))
    	{
    		return new EntityWoodBolt(world, entityliving, 1.66F, f);
    	}
		return new EntityGoldBolt(world, entityliving, 1.66F, f);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving)
    {
    	return this.getEntity(world, entityliving, 0.0F);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy));
        par3List.add(setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri));
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
    public int requiredMetadata(EntityLivingBase entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;

    	if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 3)) || (player.capabilities.isCreativeMode))
    	{
        	return 3;
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 2)))
    	{
        	return 2;
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 1)))
    	{
        	return 1;
    	}
    	else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 0)))
    	{
        	return 0;
    	}
    	return 3;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/micdoodle8/mods/crossbowmod/resources/gui/gold.png";
    }

    @Override
    public String getShortName()
    {
        return "gold";
    }
}