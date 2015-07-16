package micdoodle8.mods.crossbowmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import micdoodle8.mods.crossbowmod.CommonProxy;
import micdoodle8.mods.crossbowmod.block.CrossbowBlocks;
import micdoodle8.mods.crossbowmod.client.gui.GuiCrossbowBench;
import micdoodle8.mods.crossbowmod.item.*;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        CrossbowModClient.preInit(event);
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

    @Override
    public void load(FMLInitializationEvent event)
    {
        CrossbowModClient.init(event);
    }

    @Override
    public EntityPlayer getPlayerFromNetHandler(INetHandler handler)
    {
        if (handler instanceof NetHandlerPlayServer)
        {
            return ((NetHandlerPlayServer) handler).playerEntity;
        }
        else
        {
            return FMLClientHandler.instance().getClientPlayerEntity();
        }
    }

    @Override
    public void registerRenderInformation()
    {
        CrossbowModClient.registerRenderInformation();
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }

        Block blockID = world.getBlock(x, y, z);

        if (blockID == CrossbowBlocks.crossbowBench)
        {
            return new GuiCrossbowBench(player.inventory);
        }
        else
        {
            return null;
        }
    }

    public static void bipedRotationHook(ModelBiped modelPlayer, Entity entity, float var3)
    {
        if (entity instanceof EntityPlayer && ((EntityPlayer) entity).inventory.getCurrentItem() != null && ((EntityPlayer) entity).inventory.getCurrentItem().getItem() instanceof ItemCrossbow)
        {
            ItemCrossbow crossbow = (ItemCrossbow) ((EntityPlayer) entity).inventory.getCurrentItem().getItem();

            float i = (float) crossbow.reloadingTime + (crossbow.reloadingTime - crossbow.prevReloadingTime);

            float var7 = 0.0F;
            float var8 = 0.0F;
            modelPlayer.bipedRightArm.rotateAngleZ = 0.0F;
            modelPlayer.bipedLeftArm.rotateAngleZ = 0.0F;
            modelPlayer.bipedRightArm.rotateAngleY = 0.1F - var7 * 0.6F + modelPlayer.bipedHead.rotateAngleY - 0.3F;
            modelPlayer.bipedLeftArm.rotateAngleY = 0.1F - var7 * 0.6F + modelPlayer.bipedHead.rotateAngleY + 0.3F;
            modelPlayer.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F) + modelPlayer.bipedHead.rotateAngleX;
            modelPlayer.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F) + modelPlayer.bipedHead.rotateAngleX;
            modelPlayer.bipedRightArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            modelPlayer.bipedLeftArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            modelPlayer.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
            modelPlayer.bipedLeftArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
            modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
            modelPlayer.bipedLeftArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;

            modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(i * 0.067F) * 0.05F;

            float i2 = 0F;

            if (crossbow instanceof ItemWoodCrossbow)
            {
                i2 = 0.05F;
            }
            else if (crossbow instanceof ItemStoneCrossbow)
            {
                i2 = 0.0415F;
            }
            else if (crossbow instanceof ItemIronCrossbow)
            {
                i2 = 0.033F;
            }
            else if (crossbow instanceof ItemGoldCrossbow)
            {
                i2 = 0.0245F;
            }
            else if (crossbow instanceof ItemDiamondCrossbow)
            {
                i2 = 0.016F;
            }

            if (MathHelper.sin(i * i2) * 1.2F > 0 && !FMLClientHandler.instance().getClient().thePlayer.isUsingItem())
            {
                modelPlayer.bipedLeftArm.rotateAngleZ += MathHelper.sin(i * i2) * 1.2F;
            }

            if (MathHelper.sin(i * i2) * 1.2F > 0 && !FMLClientHandler.instance().getClient().thePlayer.isUsingItem())
            {
                modelPlayer.bipedRightArm.rotateAngleZ -= MathHelper.sin(i * i2) * 0.2F;
            }

            {
                modelPlayer.bipedLeftArm.rotateAngleX += -0.5;
            }
        }
    }
}
