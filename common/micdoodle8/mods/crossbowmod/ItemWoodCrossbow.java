package micdoodle8.mods.crossbowmod;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWoodCrossbow extends ItemCrossbow
{
    public ItemWoodCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.woodenCrossbowsList.add(this);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy));
        par3List.add(ItemCrossbow.setAttachmentAndMaterial(new ItemStack(par1, 1, 0), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri));
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving, float f)
    {
        return new EntityWoodBolt(world, entityliving, 0.75F, f);
    }

    @Override
    public EntityBolt getEntity(World world, EntityLivingBase entityliving)
    {
        return new EntityWoodBolt(world, entityliving, 0.75F, 0.0F);
    }

    @Override
    public int getCrossbowMaxDamage()
    {
        return 60;
    }

    @Override
    public int getReloadTime()
    {
        return 60;
    }

    @Override
    public int requiredMetadata(EntityLivingBase entityliving)
    {
        return 0;
    }

    @Override
    public String getSpriteSheetLoc()
    {
        return "/micdoodle8/mods/crossbowmod/resources/gui/wood.png";
    }

    @Override
    public String getShortName()
    {
        return "wood";
    }
}
