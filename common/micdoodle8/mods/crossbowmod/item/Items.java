package micdoodle8.mods.crossbowmod.item;

import micdoodle8.mods.crossbowmod.ConfigManager;
import net.minecraft.item.Item;

public class Items
{
    public static ItemWoodCrossbow woodenCrossbowBase;
    public static ItemStoneCrossbow stoneCrossbowBase;
    public static ItemIronCrossbow ironCrossbowBase;
    public static ItemGoldCrossbow goldCrossbowBase;
    public static ItemDiamondCrossbow diamondCrossbowBase;

    public static Item attachmentLimbBolt;

    public static void initItems()
    {
        Items.woodenCrossbowBase = (ItemWoodCrossbow) new ItemWoodCrossbow(ConfigManager.idItemWoodCrossbow - 256).setUnlocalizedName("woodenCrossbow").setMaxStackSize(1);
        Items.stoneCrossbowBase = (ItemStoneCrossbow) new ItemStoneCrossbow(ConfigManager.idItemStoneCrossbow - 256).setUnlocalizedName("stoneCrossbow").setMaxStackSize(1);
        Items.ironCrossbowBase = (ItemIronCrossbow) new ItemIronCrossbow(ConfigManager.idItemIronCrossbow - 256).setUnlocalizedName("ironCrossbow").setMaxStackSize(1);
        Items.goldCrossbowBase = (ItemGoldCrossbow) new ItemGoldCrossbow(ConfigManager.idItemGoldCrossbow - 256).setUnlocalizedName("goldCrossbow").setMaxStackSize(1);
        Items.diamondCrossbowBase = (ItemDiamondCrossbow) new ItemDiamondCrossbow(ConfigManager.idItemDiamondCrossbow - 256).setUnlocalizedName("diamondCrossbow").setMaxStackSize(1);
        Items.attachmentLimbBolt = new ItemCBMod(ConfigManager.idItemAttachLimbBolt).setUnlocalizedName("attachLimbBolt");
    }
}
