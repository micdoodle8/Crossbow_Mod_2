package micdoodle8.mods.crossbowmod;

import micdoodle8.mods.crossbowmod.block.Blocks;
import micdoodle8.mods.crossbowmod.inventory.ContainerCrossbowBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;

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

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
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
                return new ContainerCrossbowBench(player.inventory);
            }
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
