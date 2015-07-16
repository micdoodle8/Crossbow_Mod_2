package micdoodle8.mods.crossbowmod.world;

import micdoodle8.mods.crossbowmod.entity.EntityBolt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public class DamageSourceCrossbow extends DamageSource
{
    EntityBolt source;
    EntityPlayer shooter;

    public DamageSourceCrossbow(String par1Str, EntityBolt bolt, EntityPlayer player)
    {
        super(par1Str);
        this.source = bolt;
        this.shooter = player;
    }

    public static DamageSource causePlayerDamage(EntityBolt bolt, EntityPlayer player)
    {
        return new DamageSourceCrossbow("explosion", bolt, player);
    }

    @Override
    public Entity getSourceOfDamage()
    {
        return this.source;
    }

    @Override
    public Entity getEntity()
    {
        return this.shooter;
    }
}
