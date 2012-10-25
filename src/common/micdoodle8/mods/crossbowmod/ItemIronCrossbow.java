package micdoodle8.mods.crossbowmod;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class ItemIronCrossbow extends ItemCrossbow
{
    public ItemIronCrossbow(int par1)
    {
        super(par1);
        CrossbowModCore.ironCrossbowsList.add(this);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.ironBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityIronBolt(world, entityliving, 1.33F);
    	}
    	else if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex))
    	{
    		return new EntityStoneBolt(world, entityliving, 1.33F);
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
    		return new EntityWoodBolt(world, entityliving, 1.33F);
    	}
		return new EntityIronBolt(world, entityliving, 1.33F);
    }

    @Override
    public int getCrossbowMaxDamage()
    {
    	return 251;
    }

    @Override
    public int getReloadTime()
    {
    	return 80;
    }

    @Override
    public Item requiredItem(EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.ironBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
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
    	return Items.ironBolt;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/Mic'sMods/CrossbowMod/gui/iron.png";
    }
}