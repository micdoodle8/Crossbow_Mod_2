package micdoodle8.mods.crossbowmod.item;

import java.util.List;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import micdoodle8.mods.crossbowmod.entity.EntityBolt;
import micdoodle8.mods.crossbowmod.entity.EntityIronBolt;
import micdoodle8.mods.crossbowmod.entity.EntityStoneBolt;
import micdoodle8.mods.crossbowmod.entity.EntityWoodBolt;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIronCrossbow extends ItemCrossbow
{
    public ItemIronCrossbow()
    {
        super();
        CrossbowModCore.ironCrossbowsList.add(this);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving, float f)
    {
        EntityPlayer player = (EntityPlayer) entityliving;

        if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 2)) || player.capabilities.isCreativeMode)
        {
            return new EntityIronBolt(world, entityliving, 1.33F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 1)))
        {
            return new EntityStoneBolt(world, entityliving, 1.33F, f);
        }
        else if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 0)))
        {
            return new EntityWoodBolt(world, entityliving, 1.33F, f);
        }
        return new EntityIronBolt(world, entityliving, 1.33F, f);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving)
    {
        return this.getEntity(world, entityliving, 0.0F);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri));
    }

    @Override
    public int getCrossbowMaxDamage()
    {
        return 251;
    }

    @Override
    public int getReloadTime()
    {
        return 16;
    }

    @Override
    public int requiredMetadata(EntityLivingBase entityliving)
    {
        EntityPlayer player = (EntityPlayer) entityliving;

        if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 2)) || player.capabilities.isCreativeMode)
        {
            return 2;
        }
        else if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 1)))
        {
            return 1;
        }
        else if (player.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 0)))
        {
            return 0;
        }
        return 2;
    }

    @Override
    public String getSpriteSheetLoc()
    {
        return "/micdoodle8/mods/crossbowmod/resources/gui/iron.png";
    }

    @Override
    public String getShortName()
    {
        return "iron";
    }
}
