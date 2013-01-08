package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityDiamondBolt extends EntityBolt
{
    public EntityDiamondBolt(World world)
    {
        super(world);
    }

    public EntityDiamondBolt(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityDiamondBolt(World world, EntityLiving entityliving, Float f)
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
    	return 4F;
    }

    @Override
    public int getDamage()
    {
    	return 10;
    }
}
