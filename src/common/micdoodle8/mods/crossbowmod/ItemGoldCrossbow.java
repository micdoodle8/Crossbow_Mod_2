package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import net.minecraft.src.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

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