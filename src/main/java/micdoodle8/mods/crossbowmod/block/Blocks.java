package micdoodle8.mods.crossbowmod.block;

import micdoodle8.mods.crossbowmod.ConfigManager;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks
{
    public static Block crossbowBench;

    public static void initBlocks()
    {
        Blocks.crossbowBench = new BlockCrossbowBench(ConfigManager.idBlockCrossbowBench).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("crossbowBench");
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(Blocks.crossbowBench, ItemBlock.class, null, CrossbowModCore.MOD_ID);
    }
}
