package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class CrossbowEvents
{
    @ForgeSubscribe
    public void deathEvent(LivingDeathEvent event)
    {
        if (event.entity instanceof EntityChicken && (event.source.getSourceOfDamage() instanceof EntityWoodBolt || event.source.getSourceOfDamage() instanceof EntityStoneBolt || event.source.getSourceOfDamage() instanceof EntityIronBolt || event.source.getSourceOfDamage() instanceof EntityGoldBolt || event.source.getSourceOfDamage() instanceof EntityDiamondBolt) && event.source.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer var2 = (EntityPlayer) event.source.getEntity();
            EntityChicken entityChicken = (EntityChicken) event.entity;
            double var3 = var2.posX - entityChicken.posX;
            double var5 = var2.posZ - entityChicken.posZ;

            if (var3 * var3 + var5 * var5 >= 3750.0D && Util.hasLongRangeScope(var2.inventory.getCurrentItem()))
            {
                var2.addStat(CrossbowModCore.sniper, 1);
            }
        }
    }
}
