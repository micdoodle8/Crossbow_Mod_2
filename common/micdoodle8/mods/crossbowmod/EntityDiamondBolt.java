package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.EntityLivingBase;
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

    public EntityDiamondBolt(World world, EntityLivingBase entityliving, Float f, Float f2)
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
        return 4F;
    }

    @Override
    public int getDamage()
    {
        return 10;
    }
}
