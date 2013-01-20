package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityWoodBolt extends EntityBolt
{
    public EntityWoodBolt(World world)
    {
        super(world);
    }

    public EntityWoodBolt(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityWoodBolt(World world, EntityLiving entityliving, Float f, Float f2)
    {
        super(world, entityliving, f, f2);
    }

    @Override
    protected void entityInit()
    {
    	super.entityInit();
    }

    @Override
    public float getSpeed()
    {
    	return 1.0F;
    }

    @Override
    public int getDamage()
    {
    	return 3;
    }
}
