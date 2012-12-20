package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityIronBolt extends EntityBolt
{
    public EntityIronBolt(World world)
    {
        super(world);
    }
    
    public EntityIronBolt(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }
    
    public EntityIronBolt(World world, EntityLiving entityliving, Float f)
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
    	return 2.5F;
    }

    @Override
    public int getDamage()
    {
    	return 5;
    }
}
