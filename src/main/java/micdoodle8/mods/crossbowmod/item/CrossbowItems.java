package micdoodle8.mods.crossbowmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class CrossbowItems
{
    public static ItemWoodCrossbow woodenCrossbowBase;
    public static ItemStoneCrossbow stoneCrossbowBase;
    public static ItemIronCrossbow ironCrossbowBase;
    public static ItemGoldCrossbow goldCrossbowBase;
    public static ItemDiamondCrossbow diamondCrossbowBase;

    public static Item attachmentLimbBolt;

    public static void initItems()
    {
        CrossbowItems.woodenCrossbowBase = (ItemWoodCrossbow) new ItemWoodCrossbow().setUnlocalizedName("woodenCrossbow").setMaxStackSize(1);
        CrossbowItems.stoneCrossbowBase = (ItemStoneCrossbow) new ItemStoneCrossbow().setUnlocalizedName("stoneCrossbow").setMaxStackSize(1);
        CrossbowItems.ironCrossbowBase = (ItemIronCrossbow) new ItemIronCrossbow().setUnlocalizedName("ironCrossbow").setMaxStackSize(1);
        CrossbowItems.goldCrossbowBase = (ItemGoldCrossbow) new ItemGoldCrossbow().setUnlocalizedName("goldCrossbow").setMaxStackSize(1);
        CrossbowItems.diamondCrossbowBase = (ItemDiamondCrossbow) new ItemDiamondCrossbow().setUnlocalizedName("diamondCrossbow").setMaxStackSize(1);
        CrossbowItems.attachmentLimbBolt = new ItemCBMod().setUnlocalizedName("attachLimbBolt");

        GameRegistry.registerItem(CrossbowItems.woodenCrossbowBase, CrossbowItems.woodenCrossbowBase.getUnlocalizedName());
        GameRegistry.registerItem(CrossbowItems.stoneCrossbowBase, CrossbowItems.stoneCrossbowBase.getUnlocalizedName());
        GameRegistry.registerItem(CrossbowItems.ironCrossbowBase, CrossbowItems.ironCrossbowBase.getUnlocalizedName());
        GameRegistry.registerItem(CrossbowItems.goldCrossbowBase, CrossbowItems.goldCrossbowBase.getUnlocalizedName());
        GameRegistry.registerItem(CrossbowItems.diamondCrossbowBase, CrossbowItems.diamondCrossbowBase.getUnlocalizedName());
        GameRegistry.registerItem(CrossbowItems.attachmentLimbBolt, CrossbowItems.attachmentLimbBolt.getUnlocalizedName());
    }
}
