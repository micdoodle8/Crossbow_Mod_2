package micdoodle8.mods.crossbowmod.item;

import java.util.List;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import micdoodle8.mods.crossbowmod.entity.EntityBolt;
import micdoodle8.mods.crossbowmod.entity.EntityDiamondBolt;
import micdoodle8.mods.crossbowmod.entity.EntityGoldBolt;
import micdoodle8.mods.crossbowmod.entity.EntityIronBolt;
import micdoodle8.mods.crossbowmod.entity.EntityStoneBolt;
import micdoodle8.mods.crossbowmod.entity.EntityWoodBolt;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDiamondCrossbow extends ItemCrossbow
{
    public ItemDiamondCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.diamondCrossbowsList.add(this);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving, float f)
    {
        EntityPlayer player = (EntityPlayer) entityliving;

        if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 4)) || player.capabilities.isCreativeMode)
        {
            return new EntityDiamondBolt(world, entityliving, 2F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 3)))
        {
            return new EntityGoldBolt(world, entityliving, 2F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 2)))
        {
            return new EntityIronBolt(world, entityliving, 2F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 1)))
        {
            return new EntityStoneBolt(world, entityliving, 2F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 0)))
        {
            return new EntityWoodBolt(world, entityliving, 2F, f);
        }

        return new EntityDiamondBolt(world, entityliving, 2F, f);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving)
    {
        return this.getEntity(world, entityliving, 0.0F);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri));
    }

    @Override
    public int getCrossbowMaxDamage()
    {
        return 1562;
    }

    @Override
    public int getReloadTime()
    {
        return 100;
    }

    @Override
    public int requiredMetadata(EntityLivingBase entityliving)
    {
        EntityPlayer player = (EntityPlayer) entityliving;

        if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 4)) || player.capabilities.isCreativeMode)
        {
            return 4;
        }
        else if (player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, 3)))
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

        return 4;
    }

    @Override
    public String getSpriteSheetLoc()
    {
        return "/micdoodle8/mods/crossbowmod/resources/gui/diamond.png";
    }

    @Override
    public String getShortName()
    {
        return "diamond";
    }
}
