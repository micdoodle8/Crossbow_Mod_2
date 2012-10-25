package micdoodle8.mods.crossbowmod;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityGoldBolt extends EntityBolt
{
    public EntityGoldBolt(World world)
    {
        super(world);
    }
    
    public EntityGoldBolt(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }
    
    public EntityGoldBolt(World world, EntityLiving entityliving, Float f)
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
    	return 3.25F;
    }

    @Override
    public int getDamage()
    {
    	return 7;
    }
}
