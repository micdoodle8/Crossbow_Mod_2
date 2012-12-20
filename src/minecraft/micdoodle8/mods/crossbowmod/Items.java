package micdoodle8.mods.crossbowmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items 
{
	public static Block crossbowBench;
	
	public static ItemWoodCrossbow woodenCrossbowBase;
	public static ItemStoneCrossbow stoneCrossbowBase;
	public static ItemIronCrossbow ironCrossbowBase;
	public static ItemGoldCrossbow goldCrossbowBase;
	public static ItemDiamondCrossbow diamondCrossbowBase;
	
	public static Item attachmentLimbBolt;
	
	public Items()
	{
		crossbowBench = new BlockCrossbowBench(ConfigManager.idBlockCrossbowBench).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("crossbowBench");

	    woodenCrossbowBase = (ItemWoodCrossbow) new ItemWoodCrossbow(ConfigManager.idItemWoodCrossbow - 256).setIconIndex(0).setItemName("woodenCrossbow").setMaxStackSize(1);
		stoneCrossbowBase = (ItemStoneCrossbow) new ItemStoneCrossbow(ConfigManager.idItemStoneCrossbow - 256).setIconIndex(0).setItemName("stoneCrossbow").setMaxStackSize(1);
		ironCrossbowBase = (ItemIronCrossbow) new ItemIronCrossbow(ConfigManager.idItemIronCrossbow - 256).setIconIndex(0).setItemName("ironCrossbow").setMaxStackSize(1);
		goldCrossbowBase = (ItemGoldCrossbow) new ItemGoldCrossbow(ConfigManager.idItemGoldCrossbow - 256).setIconIndex(0).setItemName("goldCrossbow").setMaxStackSize(1);
		diamondCrossbowBase = (ItemDiamondCrossbow) new ItemDiamondCrossbow(ConfigManager.idItemDiamondCrossbow - 256).setIconIndex(0).setItemName("diamondCrossbow").setMaxStackSize(1);
		attachmentLimbBolt = (new ItemCBMod(ConfigManager.idItemAttachLimbBolt)).setItemName("attachLimbBolt");
	}
	
	public static void addNames()
	{
        addName(woodenCrossbowBase);
        addName(stoneCrossbowBase);
        addName(ironCrossbowBase);
        addName(goldCrossbowBase);
        addName(diamondCrossbowBase);
        
        addNameWithMetadata("item.attachLimbBolt.woodBolt.name");
        addNameWithMetadata("item.attachLimbBolt.stoneBolt.name");
        addNameWithMetadata("item.attachLimbBolt.ironBolt.name");
        addNameWithMetadata("item.attachLimbBolt.goldBolt.name");
        addNameWithMetadata("item.attachLimbBolt.diamondBolt.name");
        
        addNameWithMetadata("item.attachLimbBolt.woodLimb.name");
        addNameWithMetadata("item.attachLimbBolt.stoneLimb.name");
        addNameWithMetadata("item.attachLimbBolt.ironLimb.name");
        addNameWithMetadata("item.attachLimbBolt.goldLimb.name");
        addNameWithMetadata("item.attachLimbBolt.diamondLimb.name");
        
        addNameWithMetadata("item.attachLimbBolt.mechanismSemiAuto.name");
        addNameWithMetadata("item.attachLimbBolt.mechanismLightAuto.name");
        addNameWithMetadata("item.attachLimbBolt.mechanismMediumAuto.name");
        addNameWithMetadata("item.attachLimbBolt.mechanismHeavyAuto.name");
        
        addNameWithMetadata("item.attachLimbBolt.attachmentShortScope.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentLongScope.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentExplosive.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentFire.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentLava.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentIce.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentLightning.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentTorch.name");
        addNameWithMetadata("item.attachLimbBolt.attachmentPoison.name");
        
        addName(crossbowBench);
	}
	
	private static void addName(Item item)
	{
        LanguageRegistry.instance().addStringLocalization(item.getItemName() + ".name", CrossbowModCore.lang.get(item.getItemName() + ".name"));
	}
	
	private static void addNameWithMetadata(String string)
	{
        LanguageRegistry.instance().addStringLocalization(string, CrossbowModCore.lang.get(string));
	}
	
	private static void addName(Block block)
	{
        LanguageRegistry.instance().addStringLocalization(block.getBlockName() + ".name", CrossbowModCore.lang.get(block.getBlockName() + ".name"));
	}
}
