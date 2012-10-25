package micdoodle8.mods.crossbowmod;

import net.minecraft.src.EntityLiving;
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
