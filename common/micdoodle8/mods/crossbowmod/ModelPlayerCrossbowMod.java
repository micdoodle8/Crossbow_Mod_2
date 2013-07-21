//package micdoodle8.mods.crossbowmod;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.src.ModLoader;
//import net.minecraft.src.ModelPlayerAPI;
//import net.minecraft.src.ModelPlayerBase;
//import net.minecraft.util.MathHelper;
//
//public class ModelPlayerCrossbowMod extends ModelPlayerBase
//{
//    public static boolean aimedCrossbow;
//
//	public ModelPlayerCrossbowMod(ModelPlayerAPI modelplayerapi)
//	{
//		super(modelplayerapi);
//		this.aimedCrossbow = false;
//	}
//
//	@Override
//	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity entity)
//    {
//		super.setRotationAngles(var1, var2, var3, var4, var5, var6, entity);
//
//		if ( ModLoader.getMinecraftInstance().thePlayer.getCurrentEquippedItem() == null)
//		{
//			return;
//		}
//
//		ItemStack item = ModLoader.getMinecraftInstance().thePlayer.getCurrentEquippedItem();
//
//		if (!(item.getItem() instanceof ItemCrossbow))
//		{
//			return;
//		}
//
//		ItemCrossbow crossbow = (ItemCrossbow) item.getItem();
//
//		float i = (float) crossbow.reloadingTime + (crossbow.reloadingTime - crossbow.prevReloadingTime);
//
//		if (this.aimedCrossbow)
//		{
//			float var7 = 0.0F;
//	        float var8 = 0.0F;
//	        modelPlayer.bipedRightArm.rotateAngleZ = 0.0F;
//	        modelPlayer.bipedLeftArm.rotateAngleZ = 0.0F;
//	        modelPlayer.bipedRightArm.rotateAngleY = (0.1F - var7 * 0.6F) + modelPlayer.bipedHead.rotateAngleY - 0.3F;
//	        modelPlayer.bipedLeftArm.rotateAngleY = 0.1F - var7 * 0.6F + modelPlayer.bipedHead.rotateAngleY + 0.3F;
//	        modelPlayer.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + modelPlayer.bipedHead.rotateAngleX;
//	        modelPlayer.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + modelPlayer.bipedHead.rotateAngleX;
//	        modelPlayer.bipedRightArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
//	        modelPlayer.bipedLeftArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
//	        modelPlayer.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
//	        modelPlayer.bipedLeftArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
//	        modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
//	        modelPlayer.bipedLeftArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
//		}
//
//        modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(i * 0.067F) * 0.05F;
//
//        float i2 = 0F;
//
//        if (item.getItem() instanceof ItemWoodCrossbow)
//        {
//        	i2 = 0.05F;
//        }
//        else if (item.getItem() instanceof ItemStoneCrossbow)
//        {
//        	i2 = 0.0415F;
//        }
//        else if (item.getItem() instanceof ItemIronCrossbow)
//        {
//        	i2 = 0.033F;
//        }
//        else if (item.getItem() instanceof ItemGoldCrossbow)
//        {
//        	i2 = 0.0245F;
//        }
//        else if (item.getItem() instanceof ItemDiamondCrossbow)
//        {
//        	i2 = 0.016F;
//        }
//
//        if ((MathHelper.sin(i * i2) * 1.2F) > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
//        	modelPlayer.bipedLeftArm.rotateAngleZ += MathHelper.sin(i * i2) * 1.2F;
//
//        if ((MathHelper.sin(i * i2) * 1.2F) > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
//        	modelPlayer.bipedRightArm.rotateAngleZ -= MathHelper.sin(i * i2) * 0.2F;
//
//        if (i > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
//        {
//            modelPlayer.bipedLeftArm.rotateAngleX += -(0.5);
//        }
//    }
//}
