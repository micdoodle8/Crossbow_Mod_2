package micdoodle8.mods.crossbowmod;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class ItemWoodCrossbow extends ItemCrossbow
{
    public ItemWoodCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.woodenCrossbowsList.add(this);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
		return new EntityWoodBolt(world, entityliving, 0.75F);
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
    public Item requiredItem(EntityLiving entityliving)
    {
    	return Items.woodBolt;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/Mic'sMods/CrossbowMod/gui/wood.png";
    }
}