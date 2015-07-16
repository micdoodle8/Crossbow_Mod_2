package micdoodle8.mods.crossbowmod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import micdoodle8.mods.crossbowmod.block.CrossbowBlocks;
import micdoodle8.mods.crossbowmod.inventory.ContainerCrossbowBench;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
{
    public void preInit(FMLPreInitializationEvent event)
    {
        // Handled client-side
    }

    public void load(FMLInitializationEvent event)
    {
        // Handled client-side
    }

    public void registerRenderInformation()
    {
        // Handled client-side
    }

    public EntityPlayer getPlayerFromNetHandler(INetHandler handler)
    {
        if (handler instanceof NetHandlerPlayServer)
        {
            return ((NetHandlerPlayServer) handler).playerEntity;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }

        Block blockID = world.getBlock(x, y, z);

        if (blockID == CrossbowBlocks.crossbowBench)
        {
            return new ContainerCrossbowBench(player.inventory);
        }
        else
        {
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }
}
