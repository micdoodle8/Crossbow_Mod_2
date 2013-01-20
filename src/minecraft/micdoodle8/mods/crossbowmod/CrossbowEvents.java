package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.FMLLog;


public class CrossbowEvents
{
	@ForgeSubscribe
	public void deathEvent(LivingDeathEvent event)
	{
		if (event.entity instanceof EntityChicken && (event.source.getSourceOfDamage() instanceof EntityWoodBolt || event.source.getSourceOfDamage() instanceof EntityStoneBolt || event.source.getSourceOfDamage() instanceof EntityIronBolt || event.source.getSourceOfDamage() instanceof EntityGoldBolt || event.source.getSourceOfDamage() instanceof EntityDiamondBolt) && event.source.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer var2 = (EntityPlayer)event.source.getEntity();
            EntityChicken entityChicken = (EntityChicken)event.entity;
            double var3 = var2.posX - entityChicken.posX;
            double var5 = var2.posZ - entityChicken.posZ;

            if (var3 * var3 + var5 * var5 >= 3750.0D && Util.hasLongRangeScope(var2.inventory.getCurrentItem()))
            {
                var2.addStat(CrossbowModCore.sniper, 1);
            }
        }
		
//		FMLLog.info("1 " + (event.source.getEntity() instanceof EntityPlayer) + " " + (event.source.getSourceOfDamage() instanceof EntityBolt));
//		
//		if (event.entity instanceof EntityCreeper && ((event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) || event.source.getSourceOfDamage() instanceof EntityBolt)/* && (event.source.getSourceOfDamage() instanceof EntityWoodBolt || event.source.getSourceOfDamage() instanceof EntityStoneBolt || event.source.getSourceOfDamage() instanceof EntityIronBolt || event.source.getSourceOfDamage() instanceof EntityGoldBolt || event.source.getSourceOfDamage() instanceof EntityDiamondBolt)*/)
//		{
//			FMLLog.info("2");
//            EntityPlayer player = (EntityPlayer)event.source.getEntity();
//            EntityBolt bolt = (EntityBolt) event.source.getSourceOfDamage();
//            
//            if ((player != null && player.inventory.getCurrentItem() != null && Util.hasExplosiveAttachment(player.inventory.getCurrentItem())) || (bolt != null && bolt.hasExplosiveAttachment))
//            {
//        		FMLLog.info("3");
//        		player.addStat(CrossbowModCore.payback, 1);
//            }
//		}
	}
	
//	@ForgeSubscribe
//	public void rotatePlayerModel(PlayerModelRotationEvent event)
//	{
//		ModelBiped biped = event.instance;
//        float var8 = 0.0F;
//        float var9 = 0.0F;
//        biped.bipedRightArm.rotateAngleZ = 0.0F;
//        biped.bipedLeftArm.rotateAngleZ = 0.0F;
//        biped.bipedRightArm.rotateAngleY = -(0.1F - var8 * 0.6F) + biped.bipedHead.rotateAngleY;
//        biped.bipedLeftArm.rotateAngleY = 0.1F - var8 * 0.6F + biped.bipedHead.rotateAngleY + 0.4F;
//        biped.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + biped.bipedHead.rotateAngleX;
//        biped.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + biped.bipedHead.rotateAngleX;
//        biped.bipedRightArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
//        biped.bipedLeftArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
//        biped.bipedRightArm.rotateAngleZ += MathHelper.cos(event.legYaw * 0.09F) * 0.05F + 0.05F;
//        biped.bipedLeftArm.rotateAngleZ -= MathHelper.cos(event.legYaw * 0.09F) * 0.05F + 0.05F;
//        biped.bipedRightArm.rotateAngleX += MathHelper.sin(event.legYaw * 0.067F) * 0.05F;
//        biped.bipedLeftArm.rotateAngleX -= MathHelper.sin(event.legYaw * 0.067F) * 0.05F;
//	}
}
