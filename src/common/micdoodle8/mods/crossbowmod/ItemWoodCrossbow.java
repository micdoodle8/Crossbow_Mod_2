package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import net.minecraft.src.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

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
    	return 100;
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