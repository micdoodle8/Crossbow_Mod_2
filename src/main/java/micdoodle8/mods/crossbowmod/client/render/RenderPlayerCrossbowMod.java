package micdoodle8.mods.crossbowmod.client.render;

//package micdoodle8.mods.crossbowmod;
//
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.client.renderer.entity.RenderPlayer;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.EnumAction;
//import net.minecraft.item.ItemStack;
//import net.minecraft.src.ModLoader;
//import net.minecraft.src.RenderPlayerAPI;
//import net.minecraft.src.RenderPlayerBase;
//
//import org.lwjgl.opengl.GL11;
//
//import cpw.mods.fml.client.FMLClientHandler;
//import cpw.mods.fml.common.FMLLog;
//
//public class RenderPlayerCrossbowMod extends RenderPlayerBase
//{
//	public RenderPlayerCrossbowMod(RenderPlayerAPI renderplayerapi)
//	{
//		super(renderplayerapi);
//	}
//
//	@Override
//	public void renderPlayer(EntityPlayer par1EntityPlayer, double par2, double par4, double par6, float par8, float par9)
//    {
//        ItemStack var10 = par1EntityPlayer.inventory.getCurrentItem();
//
//        if (var10 != null)
//        {
//        	if (var10.getItem() instanceof ItemCrossbow)
//            {
//                ModelPlayerCrossbowMod.aimedCrossbow = true;
//            }
//        	else
//        	{
//                ModelPlayerCrossbowMod.aimedCrossbow = false;
//        	}
//        }
//        else
//        {
//            ModelPlayerCrossbowMod.aimedCrossbow = false;
//        }
//		super.renderPlayer(par1EntityPlayer, par2, par4, par6, par8, par9);
//    }
//
//	@Override
//	public void drawFirstPersonHand(EntityPlayer player)
//    {
//		if (ModLoader.getMinecraftInstance().thePlayer.getCurrentEquippedItem() == null)
//		{
//			super.drawFirstPersonHand(player);
//			return;
//		}
//
//        ItemStack var10 = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
//        if (var10.getItem() instanceof ItemCrossbow)
//        {
//            Render var24 = RenderManager.instance.getEntityRenderObject(ModLoader.getMinecraftInstance().thePlayer);
//            RenderPlayer var26 = (RenderPlayer)var24;
//
//            var26.getModelBipedMainField().onGround = 0.0F;
//            var26.getModelBipedMainField().setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, player);
//            var26.getModelBipedMainField().bipedRightArm.render(0.0625F);
//        }
//    	else
//    	{
//            super.drawFirstPersonHand(player);
//    	}
//    }
//
//	@Override
//	public void positionSpecialItemInHand(EntityPlayer var1, float var2, EnumAction var3, ItemStack var4)
//    {
//		if (!(var4.getItem() instanceof ItemCrossbow))
//		{
//			super.positionSpecialItemInHand(var1, var2, var3, var4);
//			return;
//		}
//
//		ItemCrossbow crossbow = (ItemCrossbow) var4.getItem();
//
//		if ((Util.isDiamond(var4) || Util.isGold(var4) || Util.isIron(var4) || Util.isStone(var4) || Util.isWooden(var4)))
//		{
//            GL11.glTranslatef(0.7F, 0.825F, 0.6125F);
//            GL11.glRotatef(-7.0F, 0.0F, 1.0F, 0.0F);
//            GL11.glScalef(0.625F, -0.625F, 0.625F);
//            GL11.glRotatef(-97.0F, 1.0F, 0.0F, 0.0F);
//            GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
//		}
//		else
//		{
//			super.positionSpecialItemInHand(var1, var2, var3, var4);
//		}
//	}
// }
