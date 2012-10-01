package micdoodle8.mods.crossbowmod;

import java.util.List;
import net.minecraft.src.*;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityStoneBolt extends EntityBolt
{
    public EntityStoneBolt(World world)
    {
        super(world);
    }
    
    public EntityStoneBolt(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }
    
    public EntityStoneBolt(World world, EntityLiving entityliving, Float f)
    {
        super(world, entityliving, f);
    }
    
    @Override
    protected void entityInit()
    {
    	super.entityInit();
    }
    
    @Override
    public float getSpeed()
    {
    	return 1.75F;
    }

    @Override
    public int getDamage()
    {
    	return 4;
    }
}
