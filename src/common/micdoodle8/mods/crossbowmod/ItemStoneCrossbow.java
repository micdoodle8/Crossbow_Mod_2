package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import net.minecraft.src.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

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
    public int getCrossbowMaxDamage()
    {
    	return 200;
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