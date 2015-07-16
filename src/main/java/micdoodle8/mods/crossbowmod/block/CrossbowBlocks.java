package micdoodle8.mods.crossbowmod.block;

import micdoodle8.mods.crossbowmod.ConfigManager;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class CrossbowBlocks
{
    public static Block crossbowBench;

    public static void initBlocks()
    {
        CrossbowBlocks.crossbowBench = new BlockCrossbowBench().setHardness(2.5F).setStepSound(Block.soundTypeWood).setBlockName("crossbowBench");
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(CrossbowBlocks.crossbowBench, CrossbowBlocks.crossbowBench.getUnlocalizedName());
    }
}
