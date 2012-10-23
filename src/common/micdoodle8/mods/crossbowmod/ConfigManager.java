package micdoodle8.mods.crossbowmod;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.Configuration;

public class ConfigManager 
{
	private static boolean loaded;
	
	static Configuration configuration;
	
	public ConfigManager(FMLPreInitializationEvent event)
	{
		if (!loaded)
		{
			configuration = new Configuration(event.getSuggestedConfigurationFile());
			setDefaultValues();
		}
	}
    
    public static int idItemWoodCrossbowBase;
    public static int idItemWoodCrossbowWithBasicScope;
    public static int idItemWoodCrossbowWithLongScope;
    public static int idItemWoodCrossbowWithBasicScopeAndLightMech;
    public static int idItemWoodCrossbowWithLongScopeAndLightMech;
    public static int idItemWoodCrossbowWithBasicScopeAndMediumMech;
    public static int idItemWoodCrossbowWithLongScopeAndMediumMech;
    public static int idItemWoodCrossbowWithBasicScopeAndHeavyMech;
    public static int idItemWoodCrossbowWithLongScopeAndHeavyMech;
    public static int idItemWoodCrossbowWithLightMech;
    public static int idItemWoodCrossbowWithMediumMech;
    public static int idItemWoodCrossbowWithHeavyMech;
    public static int idItemWoodCrossbowWithExplosiveAttachment;
    public static int idItemWoodCrossbowWithFireAttachment;
    public static int idItemWoodCrossbowWithLavaAttachment;
    public static int idItemWoodCrossbowWithIceAttachment;
    public static int idItemWoodCrossbowWithLightningAttachment;
    public static int idItemWoodCrossbowWithTorchAttachment;
    public static int idItemWoodCrossbowWithPoisonAttachment;
    public static int idItemWoodCrossbowWithExplosiveAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithFireAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithLavaAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithIceAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithLightningAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithTorchAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithPoisonAttachmentAndLightMech;
    public static int idItemWoodCrossbowWithExplosiveAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithFireAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithLavaAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithIceAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithLightningAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithTorchAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithPoisonAttachmentAndMediumMech;
    public static int idItemWoodCrossbowWithExplosiveAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithFireAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithLavaAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithIceAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithLightningAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithTorchAttachmentAndHeavyMech;
    public static int idItemWoodCrossbowWithPoisonAttachmentAndHeavyMech;
    
    public static int idItemWoodBolt;
    
    public static int idItemStoneCrossbowBase;
    public static int idItemStoneCrossbowWithBasicScope;
    public static int idItemStoneCrossbowWithLongScope;
    public static int idItemStoneCrossbowWithBasicScopeAndLightMech;
    public static int idItemStoneCrossbowWithLongScopeAndLightMech;
    public static int idItemStoneCrossbowWithBasicScopeAndMediumMech;
    public static int idItemStoneCrossbowWithLongScopeAndMediumMech;
    public static int idItemStoneCrossbowWithBasicScopeAndHeavyMech;
    public static int idItemStoneCrossbowWithLongScopeAndHeavyMech;
    public static int idItemStoneCrossbowWithLightMech;
    public static int idItemStoneCrossbowWithMediumMech;
    public static int idItemStoneCrossbowWithHeavyMech;
    public static int idItemStoneCrossbowWithExplosiveAttachment;
    public static int idItemStoneCrossbowWithFireAttachment;
    public static int idItemStoneCrossbowWithLavaAttachment;
    public static int idItemStoneCrossbowWithIceAttachment;
    public static int idItemStoneCrossbowWithLightningAttachment;
    public static int idItemStoneCrossbowWithTorchAttachment;
    public static int idItemStoneCrossbowWithPoisonAttachment;
    public static int idItemStoneCrossbowWithExplosiveAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithFireAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithLavaAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithIceAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithLightningAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithTorchAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithPoisonAttachmentAndLightMech;
    public static int idItemStoneCrossbowWithExplosiveAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithFireAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithLavaAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithIceAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithLightningAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithTorchAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithPoisonAttachmentAndMediumMech;
    public static int idItemStoneCrossbowWithExplosiveAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithFireAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithLavaAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithIceAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithLightningAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithTorchAttachmentAndHeavyMech;
    public static int idItemStoneCrossbowWithPoisonAttachmentAndHeavyMech;
    
    public static int idItemStoneBolt;

    public static int idItemIronCrossbowBase;
    public static int idItemIronCrossbowWithBasicScope;
    public static int idItemIronCrossbowWithLongScope;
    public static int idItemIronCrossbowWithBasicScopeAndLightMech;
    public static int idItemIronCrossbowWithLongScopeAndLightMech;
    public static int idItemIronCrossbowWithBasicScopeAndMediumMech;
    public static int idItemIronCrossbowWithLongScopeAndMediumMech;
    public static int idItemIronCrossbowWithBasicScopeAndHeavyMech;
    public static int idItemIronCrossbowWithLongScopeAndHeavyMech;
    public static int idItemIronCrossbowWithLightMech;
    public static int idItemIronCrossbowWithMediumMech;
    public static int idItemIronCrossbowWithHeavyMech;
    public static int idItemIronCrossbowWithExplosiveAttachment;
    public static int idItemIronCrossbowWithFireAttachment;
    public static int idItemIronCrossbowWithLavaAttachment;
    public static int idItemIronCrossbowWithIceAttachment;
    public static int idItemIronCrossbowWithLightningAttachment;
    public static int idItemIronCrossbowWithTorchAttachment;
    public static int idItemIronCrossbowWithPoisonAttachment;
    public static int idItemIronCrossbowWithExplosiveAttachmentAndLightMech;
    public static int idItemIronCrossbowWithFireAttachmentAndLightMech;
    public static int idItemIronCrossbowWithLavaAttachmentAndLightMech;
    public static int idItemIronCrossbowWithIceAttachmentAndLightMech;
    public static int idItemIronCrossbowWithLightningAttachmentAndLightMech;
    public static int idItemIronCrossbowWithTorchAttachmentAndLightMech;
    public static int idItemIronCrossbowWithPoisonAttachmentAndLightMech;
    public static int idItemIronCrossbowWithExplosiveAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithFireAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithLavaAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithIceAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithLightningAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithTorchAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithPoisonAttachmentAndMediumMech;
    public static int idItemIronCrossbowWithExplosiveAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithFireAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithLavaAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithIceAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithLightningAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithTorchAttachmentAndHeavyMech;
    public static int idItemIronCrossbowWithPoisonAttachmentAndHeavyMech;
    
    public static int idItemIronBolt;

    public static int idItemGoldCrossbowBase;
    public static int idItemGoldCrossbowWithBasicScope;
    public static int idItemGoldCrossbowWithLongScope;
    public static int idItemGoldCrossbowWithBasicScopeAndLightMech;
    public static int idItemGoldCrossbowWithLongScopeAndLightMech;
    public static int idItemGoldCrossbowWithBasicScopeAndMediumMech;
    public static int idItemGoldCrossbowWithLongScopeAndMediumMech;
    public static int idItemGoldCrossbowWithBasicScopeAndHeavyMech;
    public static int idItemGoldCrossbowWithLongScopeAndHeavyMech;
    public static int idItemGoldCrossbowWithLightMech;
    public static int idItemGoldCrossbowWithMediumMech;
    public static int idItemGoldCrossbowWithHeavyMech;
    public static int idItemGoldCrossbowWithExplosiveAttachment;
    public static int idItemGoldCrossbowWithFireAttachment;
    public static int idItemGoldCrossbowWithLavaAttachment;
    public static int idItemGoldCrossbowWithIceAttachment;
    public static int idItemGoldCrossbowWithLightningAttachment;
    public static int idItemGoldCrossbowWithTorchAttachment;
    public static int idItemGoldCrossbowWithPoisonAttachment;
    public static int idItemGoldCrossbowWithExplosiveAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithFireAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithLavaAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithIceAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithLightningAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithTorchAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithPoisonAttachmentAndLightMech;
    public static int idItemGoldCrossbowWithExplosiveAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithFireAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithLavaAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithIceAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithLightningAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithTorchAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithPoisonAttachmentAndMediumMech;
    public static int idItemGoldCrossbowWithExplosiveAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithFireAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithLavaAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithIceAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithLightningAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithTorchAttachmentAndHeavyMech;
    public static int idItemGoldCrossbowWithPoisonAttachmentAndHeavyMech;
    
    public static int idItemGoldBolt;

    public static int idItemDiamondCrossbowBase;
    public static int idItemDiamondCrossbowWithBasicScope;
    public static int idItemDiamondCrossbowWithLongScope;
    public static int idItemDiamondCrossbowWithBasicScopeAndLightMech;
    public static int idItemDiamondCrossbowWithLongScopeAndLightMech;
    public static int idItemDiamondCrossbowWithBasicScopeAndMediumMech;
    public static int idItemDiamondCrossbowWithLongScopeAndMediumMech;
    public static int idItemDiamondCrossbowWithBasicScopeAndHeavyMech;
    public static int idItemDiamondCrossbowWithLongScopeAndHeavyMech;
    public static int idItemDiamondCrossbowWithLightMech;
    public static int idItemDiamondCrossbowWithMediumMech;
    public static int idItemDiamondCrossbowWithHeavyMech;
    public static int idItemDiamondCrossbowWithExplosiveAttachment;
    public static int idItemDiamondCrossbowWithFireAttachment;
    public static int idItemDiamondCrossbowWithLavaAttachment;
    public static int idItemDiamondCrossbowWithIceAttachment;
    public static int idItemDiamondCrossbowWithLightningAttachment;
    public static int idItemDiamondCrossbowWithTorchAttachment;
    public static int idItemDiamondCrossbowWithPoisonAttachment;
    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithFireAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithLavaAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithIceAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithLightningAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithTorchAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithPoisonAttachmentAndLightMech;
    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithFireAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithLavaAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithIceAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithLightningAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithTorchAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithPoisonAttachmentAndMediumMech;
    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithFireAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithLavaAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithIceAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithLightningAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithTorchAttachmentAndHeavyMech;
    public static int idItemDiamondCrossbowWithPoisonAttachmentAndHeavyMech;
    
    public static int idItemDiamondBolt;
    
    public static int idBlockCrossbowBench;
    
    public static int idItemWoodLimb;
    public static int idItemStoneLimb;
    public static int idItemIronLimb;
    public static int idItemGoldLimb;
    public static int idItemDiamondLimb;
    
    public static int idItemSemiAutoMechanism, idItemLightAutoMechanism, idItemMediumAutoMechanism, idItemHeavyAutoMechanism;
    
    public static int idItemBasicScope, idItemLongRangeScope;
    
    public static int idItemFlameAttachment, idItemExplosiveAttachment, idItemLavaAttachment, idItemIceAttachment, idItemLightningAttachment, idItemTorchAttachment, idItemPoisonAttachment;
    
    public static int idEntityWoodCrossbow, idEntityStoneCrossbow;

	public static int idEntityIronCrossbow;

	public static int idEntityGoldCrossbow;

	public static int idEntityDiamondCrossbow;
    
    public static int GUIID_BlockCrossbowBench;
    
    public static boolean shouldDisplayLongRangeScope = true;
    
    public static boolean shouldDisplayBasicScope = true;
    
	public static boolean shouldCheckVersion = true;
	
	public static boolean useReloadFeature = true;
	
	private void setDefaultValues()
    {
		try
		{
	        configuration.load();
	        
	        idItemWoodCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbow", 									11003).getInt(11003);
	        idItemWoodCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScope", 							11004).getInt(11004);
	        idItemWoodCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScope", 							11005).getInt(11005);
	        idItemWoodCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeLightMech", 					11006).getInt(11006);
	        idItemWoodCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeLightMech", 					11007).getInt(11007);
	        idItemWoodCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeMediumMech", 				11008).getInt(11008);
	        idItemWoodCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeMediumMech", 					11009).getInt(11009);
	        idItemWoodCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeHeavyMech", 					11010).getInt(11010);
	        idItemWoodCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeHeavyMech", 					11011).getInt(11011);
	        idItemWoodCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightMech", 							11012).getInt(11011);
	        idItemWoodCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowMediumMech", 							11013).getInt(11013);
	        idItemWoodCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowHeavyMech", 							11014).getInt(11014);
	        idItemWoodCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowExplosiveAttachment", 					11015).getInt(11015);
	        idItemWoodCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachment", 						11016).getInt(11016);
	        idItemWoodCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLavaAttachment", 						11017).getInt(11017);
	        idItemWoodCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachment", 						11018).getInt(11018);
	        idItemWoodCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLightningAttachment", 					11019).getInt(11019);
	        idItemWoodCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachment", 						11020).getInt(11020);
	        idItemWoodCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowPoisonAttachment", 					11021).getInt(11021);
	        idItemWoodCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowExplosiveAttachmentLightMech", 		11022).getInt(11022);
	        idItemWoodCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentLightMech", 				11023).getInt(11023);
	        idItemWoodCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLavaAttachmentLightMech", 				11024).getInt(11024);
	        idItemWoodCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentLightMech", 				11025).getInt(11025);
	        idItemWoodCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLightningAttachmentLightMech", 		11026).getInt(11026);
	        idItemWoodCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentLightMech", 			11027).getInt(11027);
	        idItemWoodCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentLightMech", 			11028).getInt(11028);
	        idItemWoodCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowExplosiveAttachmentMediumMech", 		11029).getInt(11029);
	        idItemWoodCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentMediumMech", 			11030).getInt(11030);
	        idItemWoodCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLavaAttachmentMediumMech", 			11031).getInt(11031);
	        idItemWoodCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentMediumMech", 				11032).getInt(11032);
	        idItemWoodCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightningAttachmentMediumMech", 		11033).getInt(11033);
	        idItemWoodCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentMediumMech", 			11034).getInt(11034);
	        idItemWoodCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentMediumMech", 			11035).getInt(11035);
	        idItemWoodCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowExplosiveAttachmentHeavyMech", 		11036).getInt(11036);
	        idItemWoodCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentHeavyMech", 				11037).getInt(11037);
	        idItemWoodCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLavaAttachmentHeavyMech", 				11038).getInt(11038);
	        idItemWoodCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentHeavyMech", 				11039).getInt(11039);
	        idItemWoodCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightningAttachmentHeavyMech", 		11040).getInt(11040);
	        idItemWoodCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentHeavyMech", 			11041).getInt(11041);
	        idItemWoodCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentHeavyMech", 			11042).getInt(11042);

	        idItemWoodBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"WoodBolt", 										11043).getInt(11043);
	        
	        idItemStoneCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbow", 									ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithBasicScope = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScope", 							ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScope", 							ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithBasicScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeLightMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeLightMech", 					ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLongScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithBasicScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeHeavyMech", 					ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightMech", 							ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithMediumMech = 						configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowMediumMech", 							ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowHeavyMech", 							ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowExplosiveAttachment", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithFireAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachment", 						ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLavaAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLavaAttachment", 						ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachment", 						ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLightningAttachment", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachment", 					ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowPoisonAttachment", 					ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowExplosiveAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithFireAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLavaAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLavaAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLightningAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowExplosiveAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLavaAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithIceAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightningAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowExplosiveAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithFireAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLavaAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLavaAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightningAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemStoneCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);

	        idItemStoneBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"StoneBolt", 										ddddddd).getInt(ddddddd);
	        
	        idItemIronCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbow", 									ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScope", 							ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScope", 							ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeLightMech", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeLightMech", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeMediumMech", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeHeavyMech", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeHeavyMech", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightMech", 							ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowMediumMech", 							ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowHeavyMech", 							ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowExplosiveAttachment", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachment", 						ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLavaAttachment", 						ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachment", 						ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLightningAttachment", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachment", 						ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowPoisonAttachment", 					ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowExplosiveAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLavaAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLightningAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowExplosiveAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLavaAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightningAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowExplosiveAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLavaAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightningAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemIronCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);

	        idItemIronBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"IronBolt", 										ddddddd).getInt(ddddddd);
	        
	        idItemGoldCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbow", 									ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScope", 							ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScope", 							ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeLightMech", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeLightMech", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeMediumMech", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeHeavyMech", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeHeavyMech", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightMech", 							ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowMediumMech", 							ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowHeavyMech", 							ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowExplosiveAttachment", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachment", 						ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLavaAttachment", 						ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachment", 						ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLightningAttachment", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachment", 						ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowPoisonAttachment", 					ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowExplosiveAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLavaAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentLightMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLightningAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowExplosiveAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLavaAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightningAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowExplosiveAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLavaAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightningAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemGoldCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);

	        idItemGoldBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"GoldBolt", 										ddddddd).getInt(ddddddd);
	        
	        idItemDiamondCrossbowBase = 								configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbow", 									ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithBasicScope = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScope", 						ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLongScope = 						configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScope", 						ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithBasicScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeLightMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLongScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeLightMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLongScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeMediumMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithBasicScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLongScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeHeavyMech", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLightMech = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightMech", 						ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithMediumMech = 						configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowMediumMech", 						ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithHeavyMech = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowHeavyMech", 						ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowExplosiveAttachment", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithFireAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachment", 					ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLavaAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLavaAttachment", 					ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithIceAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachment", 					ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLightningAttachment", 				ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachment", 					ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithPoisonAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowPoisonAttachment", 					ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowExplosiveAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithFireAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLavaAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLavaAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithIceAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLightningAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentLightMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithPoisonAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentLightMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndMediumMech = configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowExplosiveAttachmentMediumMech", 	ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLavaAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithIceAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentMediumMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLightningAttachmentAndMediumMech = configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightningAttachmentMediumMech", 	ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithTorchAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithPoisonAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentMediumMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowExplosiveAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithFireAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLavaAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLavaAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithIceAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightningAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentHeavyMech", 			ddddddd).getInt(ddddddd);
	        idItemDiamondCrossbowWithPoisonAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentHeavyMech", 		ddddddd).getInt(ddddddd);

	        idItemDiamondBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondBolt", 									ddddddd).getInt(ddddddd);
	        
	        idBlockCrossbowBench = Integer.parseInt(configuration.getOrCreateBlockIdProperty("BlockCrossbowBench", 1999).value);
	        
	        idItemWoodLimb = Integer.parseInt(configuration.getOrCreateIntProperty("WoodLimb", Configuration.CATEGORY_ITEM, 11208).value);
	        idItemStoneLimb = Integer.parseInt(configuration.getOrCreateIntProperty("StoneLimb", Configuration.CATEGORY_ITEM, 11209).value);
	        idItemIronLimb = Integer.parseInt(configuration.getOrCreateIntProperty("IronLimb", Configuration.CATEGORY_ITEM, 11210).value);
	        idItemGoldLimb = Integer.parseInt(configuration.getOrCreateIntProperty("GoldLimb", Configuration.CATEGORY_ITEM, 11211).value);
	        idItemDiamondLimb = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondLimb", Configuration.CATEGORY_ITEM, 11212).value);
	        
	        idItemSemiAutoMechanism = Integer.parseInt(configuration.getOrCreateIntProperty("SemiAutoMechanism", Configuration.CATEGORY_ITEM, 11213).value);
	        idItemLightAutoMechanism = Integer.parseInt(configuration.getOrCreateIntProperty("LightAutoMechanism", Configuration.CATEGORY_ITEM, 11214).value);
	        idItemMediumAutoMechanism = Integer.parseInt(configuration.getOrCreateIntProperty("MediumAutoMechanism", Configuration.CATEGORY_ITEM, 11215).value);
	        idItemHeavyAutoMechanism = Integer.parseInt(configuration.getOrCreateIntProperty("HeavyAutoMechanism", Configuration.CATEGORY_ITEM, 11216).value);
	        
	        idItemBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("BasicScope", Configuration.CATEGORY_ITEM, 11217).value);
	        idItemLongRangeScope = Integer.parseInt(configuration.getOrCreateIntProperty("LongRangeScope", Configuration.CATEGORY_ITEM, 11218).value);
	        idItemFlameAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("FlameAttachment", Configuration.CATEGORY_ITEM, 11219).value);
	        idItemExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("ExplosiveAttachment", Configuration.CATEGORY_ITEM, 11220).value);
	        idItemLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("LavaAttachment", Configuration.CATEGORY_ITEM, 11221).value);
	        idItemIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("FrostAttachment", Configuration.CATEGORY_ITEM, 11222).value);
	        idItemLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("LightningAttachment", Configuration.CATEGORY_ITEM, 11223).value);
	        idItemTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("TorchAttachment", Configuration.CATEGORY_ITEM, 11224).value);
	        idItemPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("PoisonAttachment", Configuration.CATEGORY_ITEM, 11225).value);
	        
	        GUIID_BlockCrossbowBench = Integer.parseInt(configuration.getOrCreateIntProperty("BlockCrossbowBenchGuiID", Configuration.CATEGORY_GENERAL, 193).value);
	        
	        idEntityWoodCrossbow = Integer.parseInt(configuration.getOrCreateIntProperty("WoodBoltEntityID", Configuration.CATEGORY_GENERAL, 193).value);
	        idEntityStoneCrossbow = Integer.parseInt(configuration.getOrCreateIntProperty("StoneBoltEntityID", Configuration.CATEGORY_GENERAL, 194).value);
	        idEntityIronCrossbow = Integer.parseInt(configuration.getOrCreateIntProperty("IronBoltEntityID", Configuration.CATEGORY_GENERAL, 195).value);
	        idEntityGoldCrossbow = Integer.parseInt(configuration.getOrCreateIntProperty("GoldBoltEntityID", Configuration.CATEGORY_GENERAL, 196).value);
	        idEntityDiamondCrossbow = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondBoltEntityID", Configuration.CATEGORY_GENERAL, 197).value);
	        
	        shouldCheckVersion = Boolean.parseBoolean(configuration.getOrCreateBooleanProperty("ShouldCheckVersion", Configuration.CATEGORY_GENERAL, true).value);
	        
	        useReloadFeature = Boolean.parseBoolean(configuration.getOrCreateBooleanProperty("RequireReload", Configuration.CATEGORY_GENERAL, true).value);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "CrossbowMod has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
