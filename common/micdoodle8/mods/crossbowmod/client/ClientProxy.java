package micdoodle8.mods.crossbowmod.client;

import java.util.EnumSet;
import micdoodle8.mods.crossbowmod.CommonProxy;
import micdoodle8.mods.crossbowmod.ConfigManager;
import micdoodle8.mods.crossbowmod.block.Blocks;
import micdoodle8.mods.crossbowmod.client.gui.GuiCrossbowBench;
import micdoodle8.mods.crossbowmod.item.ItemCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemDiamondCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemGoldCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemIronCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemStoneCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemWoodCrossbow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
        TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
        CrossbowModClient.init(event);
    }

    @Override
    public void registerRenderInformation()
    {
        CrossbowModClient.registerRenderInformation();
    }

    public class ClientTickHandler implements ITickHandler
    {
        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
            if (type.equals(EnumSet.of(TickType.RENDER)))
            {
                this.onRenderTick();
            }
            else if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
                GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;

                if (guiscreen != null)
                {
                    this.onTickInGUI(guiscreen);
                }
                else
                {
                    this.onTickInGame();
                }
            }
        }

        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.RENDER, TickType.CLIENT);
        }

        @Override
        public String getLabel()
        {
            return "Crossbow Mod 2 Render/Gui";
        }

        public void onRenderTick()
        {
            CrossbowModClient.onRenderTick();
        }

        public void onTickInGUI(GuiScreen guiscreen)
        {
            CrossbowModClient.onTickInGUI(guiscreen);
        }

        public void onTickInGame()
        {
            CrossbowModClient.onTickInGame();
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }

        int blockID = world.getBlockId(x, y, z);

        if (ID == ConfigManager.GUIID_BlockCrossbowBench)
        {
            if (!(blockID == Blocks.crossbowBench.blockID))
            {
                return null;
            }
            else
            {
                return new GuiCrossbowBench(player.inventory);
            }
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

            if (MathHelper.sin(i * i2) * 1.2F > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
            {
                modelPlayer.bipedLeftArm.rotateAngleZ += MathHelper.sin(i * i2) * 1.2F;
            }

            if (MathHelper.sin(i * i2) * 1.2F > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
            {
                modelPlayer.bipedRightArm.rotateAngleZ -= MathHelper.sin(i * i2) * 0.2F;
            }

            if (i > 0 && !ModLoader.getMinecraftInstance().thePlayer.isUsingItem())
            {
                modelPlayer.bipedLeftArm.rotateAngleX += -0.5;
            }
        }
    }
}
