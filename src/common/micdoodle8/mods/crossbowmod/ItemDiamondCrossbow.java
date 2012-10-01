package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import net.minecraft.src.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

public class ItemDiamondCrossbow extends ItemCrossbow
{
    public ItemDiamondCrossbow(int par1)
    {
        super(par1);
    }
    
    @Override
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.diamondBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
    		return new EntityDiamondBolt(world, entityliving, 2F);
    	}
    	else if (player.inventory.hasItem(Items.goldBolt.shiftedIndex))
    	{
    		return new EntityGoldBolt(world, entityliving, 2F);
    	}
    	else if (player.inventory.hasItem(Items.ironBolt.shiftedIndex))
    	{
    		return new EntityIronBolt(world, entityliving, 2F);
    	}
    	else if (player.inventory.hasItem(Items.stoneBolt.shiftedIndex))
    	{
    		return new EntityStoneBolt(world, entityliving, 2F);
    	}
    	else if (player.inventory.hasItem(Items.woodBolt.shiftedIndex))
    	{
    		return new EntityWoodBolt(world, entityliving, 2F);
    	}

    	return new EntityDiamondBolt(world, entityliving, 2F);
    }

    @Override
    public int getCrossbowMaxDamage()
    {
    	return 756;
    }

    @Override
    public int getReloadTime()
    {
    	return 100;
    }

    @Override
    public Item requiredItem(EntityLiving entityliving)
    {
    	EntityPlayer player = (EntityPlayer) entityliving;
    	
    	if (player.inventory.hasItem(Items.diamondBolt.shiftedIndex) || (player.capabilities.isCreativeMode))
    	{
        	return Items.diamondBolt;
    	}
    	else if (player.inventory.hasItem(Items.goldBolt.shiftedIndex))
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
    	
    	return Items.diamondBolt;
    }

    @Override
    public String getSpriteSheetLoc()
    {
    	return "/Mic'sMods/CrossbowMod/gui/diamond.png";
    }
}