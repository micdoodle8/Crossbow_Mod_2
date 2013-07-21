package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.EntityLivingBase;
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

    public EntityIronBolt(World world, EntityLivingBase entityliving, Float f, Float f2)
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
        return 2.5F;
    }

    @Override
    public int getDamage()
    {
        return 5;
    }
}
