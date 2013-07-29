package micdoodle8.mods.crossbowmod.client;

import java.util.EnumSet;
import micdoodle8.mods.crossbowmod.CommonProxy;
import micdoodle8.mods.crossbowmod.ConfigManager;
import micdoodle8.mods.crossbowmod.client.gui.GuiCrossbowBench;
import micdoodle8.mods.crossbowmod.item.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
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
            if (!(blockID == Items.crossbowBench.blockID))
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
}
