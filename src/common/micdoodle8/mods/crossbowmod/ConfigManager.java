package micdoodle8.mods.crossbowmod;

import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
	
	public static int idItemWoodCrossbow;
	public static int idItemStoneCrossbow;
	public static int idItemIronCrossbow;
	public static int idItemGoldCrossbow;
	public static int idItemDiamondCrossbow;
    
//    public static int idItemWoodCrossbowBase;
//    public static int idItemWoodCrossbowWithBasicScope;
//    public static int idItemWoodCrossbowWithLongScope;
//    public static int idItemWoodCrossbowWithBasicScopeAndLightMech;
//    public static int idItemWoodCrossbowWithLongScopeAndLightMech;
//    public static int idItemWoodCrossbowWithBasicScopeAndMediumMech;
//    public static int idItemWoodCrossbowWithLongScopeAndMediumMech;
//    public static int idItemWoodCrossbowWithBasicScopeAndHeavyMech;
//    public static int idItemWoodCrossbowWithLongScopeAndHeavyMech;
//    public static int idItemWoodCrossbowWithLightMech;
//    public static int idItemWoodCrossbowWithMediumMech;
//    public static int idItemWoodCrossbowWithHeavyMech;
//    public static int idItemWoodCrossbowWithExplosiveAttachment;
//    public static int idItemWoodCrossbowWithFireAttachment;
//    public static int idItemWoodCrossbowWithLavaAttachment;
//    public static int idItemWoodCrossbowWithIceAttachment;
//    public static int idItemWoodCrossbowWithLightningAttachment;
//    public static int idItemWoodCrossbowWithTorchAttachment;
//    public static int idItemWoodCrossbowWithPoisonAttachment;
//    public static int idItemWoodCrossbowWithExplosiveAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithFireAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithLavaAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithIceAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithLightningAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithTorchAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithPoisonAttachmentAndLightMech;
//    public static int idItemWoodCrossbowWithExplosiveAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithFireAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithLavaAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithIceAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithLightningAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithTorchAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithPoisonAttachmentAndMediumMech;
//    public static int idItemWoodCrossbowWithExplosiveAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithFireAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithLavaAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithIceAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithLightningAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithTorchAttachmentAndHeavyMech;
//    public static int idItemWoodCrossbowWithPoisonAttachmentAndHeavyMech;
//    
    public static int idItemWoodBolt;
//    
//    public static int idItemStoneCrossbowBase;
//    public static int idItemStoneCrossbowWithBasicScope;
//    public static int idItemStoneCrossbowWithLongScope;
//    public static int idItemStoneCrossbowWithBasicScopeAndLightMech;
//    public static int idItemStoneCrossbowWithLongScopeAndLightMech;
//    public static int idItemStoneCrossbowWithBasicScopeAndMediumMech;
//    public static int idItemStoneCrossbowWithLongScopeAndMediumMech;
//    public static int idItemStoneCrossbowWithBasicScopeAndHeavyMech;
//    public static int idItemStoneCrossbowWithLongScopeAndHeavyMech;
//    public static int idItemStoneCrossbowWithLightMech;
//    public static int idItemStoneCrossbowWithMediumMech;
//    public static int idItemStoneCrossbowWithHeavyMech;
//    public static int idItemStoneCrossbowWithExplosiveAttachment;
//    public static int idItemStoneCrossbowWithFireAttachment;
//    public static int idItemStoneCrossbowWithLavaAttachment;
//    public static int idItemStoneCrossbowWithIceAttachment;
//    public static int idItemStoneCrossbowWithLightningAttachment;
//    public static int idItemStoneCrossbowWithTorchAttachment;
//    public static int idItemStoneCrossbowWithPoisonAttachment;
//    public static int idItemStoneCrossbowWithExplosiveAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithFireAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithLavaAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithIceAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithLightningAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithTorchAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithPoisonAttachmentAndLightMech;
//    public static int idItemStoneCrossbowWithExplosiveAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithFireAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithLavaAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithIceAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithLightningAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithTorchAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithPoisonAttachmentAndMediumMech;
//    public static int idItemStoneCrossbowWithExplosiveAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithFireAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithLavaAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithIceAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithLightningAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithTorchAttachmentAndHeavyMech;
//    public static int idItemStoneCrossbowWithPoisonAttachmentAndHeavyMech;
//    
    public static int idItemStoneBolt;
//
//    public static int idItemIronCrossbowBase;
//    public static int idItemIronCrossbowWithBasicScope;
//    public static int idItemIronCrossbowWithLongScope;
//    public static int idItemIronCrossbowWithBasicScopeAndLightMech;
//    public static int idItemIronCrossbowWithLongScopeAndLightMech;
//    public static int idItemIronCrossbowWithBasicScopeAndMediumMech;
//    public static int idItemIronCrossbowWithLongScopeAndMediumMech;
//    public static int idItemIronCrossbowWithBasicScopeAndHeavyMech;
//    public static int idItemIronCrossbowWithLongScopeAndHeavyMech;
//    public static int idItemIronCrossbowWithLightMech;
//    public static int idItemIronCrossbowWithMediumMech;
//    public static int idItemIronCrossbowWithHeavyMech;
//    public static int idItemIronCrossbowWithExplosiveAttachment;
//    public static int idItemIronCrossbowWithFireAttachment;
//    public static int idItemIronCrossbowWithLavaAttachment;
//    public static int idItemIronCrossbowWithIceAttachment;
//    public static int idItemIronCrossbowWithLightningAttachment;
//    public static int idItemIronCrossbowWithTorchAttachment;
//    public static int idItemIronCrossbowWithPoisonAttachment;
//    public static int idItemIronCrossbowWithExplosiveAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithFireAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithLavaAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithIceAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithLightningAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithTorchAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithPoisonAttachmentAndLightMech;
//    public static int idItemIronCrossbowWithExplosiveAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithFireAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithLavaAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithIceAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithLightningAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithTorchAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithPoisonAttachmentAndMediumMech;
//    public static int idItemIronCrossbowWithExplosiveAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithFireAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithLavaAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithIceAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithLightningAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithTorchAttachmentAndHeavyMech;
//    public static int idItemIronCrossbowWithPoisonAttachmentAndHeavyMech;
//    
    public static int idItemIronBolt;
//
//    public static int idItemGoldCrossbowBase;
//    public static int idItemGoldCrossbowWithBasicScope;
//    public static int idItemGoldCrossbowWithLongScope;
//    public static int idItemGoldCrossbowWithBasicScopeAndLightMech;
//    public static int idItemGoldCrossbowWithLongScopeAndLightMech;
//    public static int idItemGoldCrossbowWithBasicScopeAndMediumMech;
//    public static int idItemGoldCrossbowWithLongScopeAndMediumMech;
//    public static int idItemGoldCrossbowWithBasicScopeAndHeavyMech;
//    public static int idItemGoldCrossbowWithLongScopeAndHeavyMech;
//    public static int idItemGoldCrossbowWithLightMech;
//    public static int idItemGoldCrossbowWithMediumMech;
//    public static int idItemGoldCrossbowWithHeavyMech;
//    public static int idItemGoldCrossbowWithExplosiveAttachment;
//    public static int idItemGoldCrossbowWithFireAttachment;
//    public static int idItemGoldCrossbowWithLavaAttachment;
//    public static int idItemGoldCrossbowWithIceAttachment;
//    public static int idItemGoldCrossbowWithLightningAttachment;
//    public static int idItemGoldCrossbowWithTorchAttachment;
//    public static int idItemGoldCrossbowWithPoisonAttachment;
//    public static int idItemGoldCrossbowWithExplosiveAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithFireAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithLavaAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithIceAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithLightningAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithTorchAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithPoisonAttachmentAndLightMech;
//    public static int idItemGoldCrossbowWithExplosiveAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithFireAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithLavaAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithIceAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithLightningAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithTorchAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithPoisonAttachmentAndMediumMech;
//    public static int idItemGoldCrossbowWithExplosiveAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithFireAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithLavaAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithIceAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithLightningAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithTorchAttachmentAndHeavyMech;
//    public static int idItemGoldCrossbowWithPoisonAttachmentAndHeavyMech;
//    
    public static int idItemGoldBolt;
//
//    public static int idItemDiamondCrossbowBase;
//    public static int idItemDiamondCrossbowWithBasicScope;
//    public static int idItemDiamondCrossbowWithLongScope;
//    public static int idItemDiamondCrossbowWithBasicScopeAndLightMech;
//    public static int idItemDiamondCrossbowWithLongScopeAndLightMech;
//    public static int idItemDiamondCrossbowWithBasicScopeAndMediumMech;
//    public static int idItemDiamondCrossbowWithLongScopeAndMediumMech;
//    public static int idItemDiamondCrossbowWithBasicScopeAndHeavyMech;
//    public static int idItemDiamondCrossbowWithLongScopeAndHeavyMech;
//    public static int idItemDiamondCrossbowWithLightMech;
//    public static int idItemDiamondCrossbowWithMediumMech;
//    public static int idItemDiamondCrossbowWithHeavyMech;
//    public static int idItemDiamondCrossbowWithExplosiveAttachment;
//    public static int idItemDiamondCrossbowWithFireAttachment;
//    public static int idItemDiamondCrossbowWithLavaAttachment;
//    public static int idItemDiamondCrossbowWithIceAttachment;
//    public static int idItemDiamondCrossbowWithLightningAttachment;
//    public static int idItemDiamondCrossbowWithTorchAttachment;
//    public static int idItemDiamondCrossbowWithPoisonAttachment;
//    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithFireAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithLavaAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithIceAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithLightningAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithTorchAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithPoisonAttachmentAndLightMech;
//    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithFireAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithLavaAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithIceAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithLightningAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithTorchAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithPoisonAttachmentAndMediumMech;
//    public static int idItemDiamondCrossbowWithExplosiveAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithFireAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithLavaAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithIceAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithLightningAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithTorchAttachmentAndHeavyMech;
//    public static int idItemDiamondCrossbowWithPoisonAttachmentAndHeavyMech;
    
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
	
	private void setDefaultValues()
    {
		try
		{
	        configuration.load();
	        
	        idItemWoodCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbow", 									11003).getInt(11003);
	        idItemStoneCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbow", 									11004).getInt(11004);
	        idItemIronCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbow", 									11005).getInt(11005);
	        idItemGoldCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbow", 									11006).getInt(11006);
	        idItemDiamondCrossbow = 								configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbow", 									11007).getInt(11007);
	        
//	        idItemWoodCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScope", 							11004).getInt(11004);
//	        idItemWoodCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScope", 							11005).getInt(11005);
//	        idItemWoodCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeLightMech", 					11006).getInt(11006);
//	        idItemWoodCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeLightMech", 					11007).getInt(11007);
//	        idItemWoodCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeMediumMech", 				11008).getInt(11008);
//	        idItemWoodCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeMediumMech", 					11009).getInt(11009);
//	        idItemWoodCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowBasicScopeHeavyMech", 					11010).getInt(11010);
//	        idItemWoodCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLongScopeHeavyMech", 					11011).getInt(11011);
//	        idItemWoodCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightMech", 							11012).getInt(11011);
//	        idItemWoodCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowMediumMech", 							11013).getInt(11013);
//	        idItemWoodCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowHeavyMech", 							11014).getInt(11014);
//	        idItemWoodCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowExplosiveAttachment", 					11015).getInt(11015);
//	        idItemWoodCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachment", 						11016).getInt(11016);
//	        idItemWoodCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLavaAttachment", 						11017).getInt(11017);
//	        idItemWoodCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachment", 						11018).getInt(11018);
//	        idItemWoodCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLightningAttachment", 					11019).getInt(11019);
//	        idItemWoodCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachment", 						11020).getInt(11020);
//	        idItemWoodCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowPoisonAttachment", 					11021).getInt(11021);
//	        idItemWoodCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowExplosiveAttachmentLightMech", 		11022).getInt(11022);
//	        idItemWoodCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentLightMech", 				11023).getInt(11023);
//	        idItemWoodCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLavaAttachmentLightMech", 				11024).getInt(11024);
//	        idItemWoodCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentLightMech", 				11025).getInt(11025);
//	        idItemWoodCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"WoodCrossbowLightningAttachmentLightMech", 		11026).getInt(11026);
//	        idItemWoodCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentLightMech", 			11027).getInt(11027);
//	        idItemWoodCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentLightMech", 			11028).getInt(11028);
//	        idItemWoodCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowExplosiveAttachmentMediumMech", 		11029).getInt(11029);
//	        idItemWoodCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentMediumMech", 			11030).getInt(11030);
//	        idItemWoodCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLavaAttachmentMediumMech", 			11031).getInt(11031);
//	        idItemWoodCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentMediumMech", 				11032).getInt(11032);
//	        idItemWoodCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightningAttachmentMediumMech", 		11033).getInt(11033);
//	        idItemWoodCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentMediumMech", 			11034).getInt(11034);
//	        idItemWoodCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentMediumMech", 			11035).getInt(11035);
//	        idItemWoodCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowExplosiveAttachmentHeavyMech", 		11036).getInt(11036);
//	        idItemWoodCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowFireAttachmentHeavyMech", 				11037).getInt(11037);
//	        idItemWoodCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLavaAttachmentHeavyMech", 				11038).getInt(11038);
//	        idItemWoodCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowIceAttachmentHeavyMech", 				11039).getInt(11039);
//	        idItemWoodCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowLightningAttachmentHeavyMech", 		11040).getInt(11040);
//	        idItemWoodCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowTorchAttachmentHeavyMech", 			11041).getInt(11041);
//	        idItemWoodCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodCrossbowPoisonAttachmentHeavyMech", 			11042).getInt(11042);
//
	        idItemWoodBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"WoodBolt", 										11043).getInt(11043);
//	        
//	        idItemStoneCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbow", 									11044).getInt(11044);
//	        idItemStoneCrossbowWithBasicScope = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScope", 							11045).getInt(11045);
//	        idItemStoneCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScope", 							11046).getInt(11046);
//	        idItemStoneCrossbowWithBasicScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeLightMech", 				11047).getInt(11047);
//	        idItemStoneCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeLightMech", 					11048).getInt(11048);
//	        idItemStoneCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeMediumMech", 				11049).getInt(11049);
//	        idItemStoneCrossbowWithLongScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeMediumMech", 				11050).getInt(11050);
//	        idItemStoneCrossbowWithBasicScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowBasicScopeHeavyMech", 				11051).getInt(11051);
//	        idItemStoneCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLongScopeHeavyMech", 					11052).getInt(11052);
//	        idItemStoneCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightMech", 							11053).getInt(11053);
//	        idItemStoneCrossbowWithMediumMech = 						configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowMediumMech", 							11054).getInt(11054);
//	        idItemStoneCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowHeavyMech", 							11055).getInt(11055);
//	        idItemStoneCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowExplosiveAttachment", 				11056).getInt(11056);
//	        idItemStoneCrossbowWithFireAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachment", 						11057).getInt(11057);
//	        idItemStoneCrossbowWithLavaAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLavaAttachment", 						11058).getInt(11058);
//	        idItemStoneCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachment", 						11059).getInt(11059);
//	        idItemStoneCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLightningAttachment", 				11060).getInt(11060);
//	        idItemStoneCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachment", 					11061).getInt(11061);
//	        idItemStoneCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowPoisonAttachment", 					11062).getInt(11062);
//	        idItemStoneCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowExplosiveAttachmentLightMech", 		11063).getInt(11063);
//	        idItemStoneCrossbowWithFireAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentLightMech", 			11064).getInt(11064);
//	        idItemStoneCrossbowWithLavaAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLavaAttachmentLightMech", 			11065).getInt(11065);
//	        idItemStoneCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentLightMech", 				11066).getInt(11066);
//	        idItemStoneCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"StoneCrossbowLightningAttachmentLightMech", 		11067).getInt(11067);
//	        idItemStoneCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentLightMech", 			11068).getInt(11068);
//	        idItemStoneCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentLightMech", 			11069).getInt(11069);
//	        idItemStoneCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowExplosiveAttachmentMediumMech", 		11070).getInt(11070);
//	        idItemStoneCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentMediumMech", 			11071).getInt(11071);
//	        idItemStoneCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLavaAttachmentMediumMech", 			11072).getInt(11072);
//	        idItemStoneCrossbowWithIceAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentMediumMech", 			11073).getInt(11073);
//	        idItemStoneCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightningAttachmentMediumMech", 		11074).getInt(11074);
//	        idItemStoneCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentMediumMech", 			11075).getInt(11075);
//	        idItemStoneCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentMediumMech", 			11076).getInt(11076);
//	        idItemStoneCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowExplosiveAttachmentHeavyMech", 		11077).getInt(11077);
//	        idItemStoneCrossbowWithFireAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowFireAttachmentHeavyMech", 			11078).getInt(11078);
//	        idItemStoneCrossbowWithLavaAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLavaAttachmentHeavyMech", 			11079).getInt(11079);
//	        idItemStoneCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowIceAttachmentHeavyMech", 				11080).getInt(11080);
//	        idItemStoneCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowLightningAttachmentHeavyMech", 		11081).getInt(11081);
//	        idItemStoneCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowTorchAttachmentHeavyMech", 			11082).getInt(11082);
//	        idItemStoneCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneCrossbowPoisonAttachmentHeavyMech", 			11083).getInt(11083);
//
	        idItemStoneBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"StoneBolt", 										11008).getInt(11008);
//	        
//	        idItemIronCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbow", 									11085).getInt(11085);
//	        idItemIronCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScope", 							11086).getInt(11086);
//	        idItemIronCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScope", 							11087).getInt(11087);
//	        idItemIronCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeLightMech", 					11088).getInt(11088);
//	        idItemIronCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeLightMech", 					11089).getInt(11089);
//	        idItemIronCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeMediumMech", 				11090).getInt(11090);
//	        idItemIronCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeMediumMech", 					11091).getInt(11091);
//	        idItemIronCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowBasicScopeHeavyMech", 					11092).getInt(11092);
//	        idItemIronCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLongScopeHeavyMech", 					11093).getInt(11093);
//	        idItemIronCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightMech", 							11094).getInt(11094);
//	        idItemIronCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowMediumMech", 							11095).getInt(11095);
//	        idItemIronCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowHeavyMech", 							11096).getInt(11096);
//	        idItemIronCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowExplosiveAttachment", 					11097).getInt(11097);
//	        idItemIronCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachment", 						11098).getInt(11098);
//	        idItemIronCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLavaAttachment", 						11099).getInt(11099);
//	        idItemIronCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachment", 						11100).getInt(11100);
//	        idItemIronCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLightningAttachment", 					11101).getInt(11101);
//	        idItemIronCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachment", 						11102).getInt(11102);
//	        idItemIronCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowPoisonAttachment", 					11103).getInt(11103);
//	        idItemIronCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowExplosiveAttachmentLightMech", 		11104).getInt(11104);
//	        idItemIronCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentLightMech", 				11105).getInt(11105);
//	        idItemIronCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLavaAttachmentLightMech", 				11106).getInt(11106);
//	        idItemIronCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentLightMech", 				11107).getInt(11107);
//	        idItemIronCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"IronCrossbowLightningAttachmentLightMech", 		11108).getInt(11108);
//	        idItemIronCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentLightMech", 			11109).getInt(11109);
//	        idItemIronCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentLightMech", 			11110).getInt(11110);
//	        idItemIronCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowExplosiveAttachmentMediumMech", 		11111).getInt(11111);
//	        idItemIronCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentMediumMech", 			11112).getInt(11112);
//	        idItemIronCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLavaAttachmentMediumMech", 			11113).getInt(11113);
//	        idItemIronCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentMediumMech", 				11114).getInt(11114);
//	        idItemIronCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightningAttachmentMediumMech", 		11115).getInt(11115);
//	        idItemIronCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentMediumMech", 			11116).getInt(11116);
//	        idItemIronCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentMediumMech", 			11117).getInt(11117);
//	        idItemIronCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowExplosiveAttachmentHeavyMech", 		11118).getInt(11118);
//	        idItemIronCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowFireAttachmentHeavyMech", 				11119).getInt(11119);
//	        idItemIronCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLavaAttachmentHeavyMech", 				11120).getInt(11120);
//	        idItemIronCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowIceAttachmentHeavyMech", 				11121).getInt(11121);
//	        idItemIronCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowLightningAttachmentHeavyMech", 		11122).getInt(11122);
//	        idItemIronCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowTorchAttachmentHeavyMech", 			11123).getInt(11123);
//	        idItemIronCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"IronCrossbowPoisonAttachmentHeavyMech", 			11124).getInt(11124);
//
	        idItemIronBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"IronBolt", 										11009).getInt(11009);
//	        
//	        idItemGoldCrossbowBase = 									configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbow", 									11126).getInt(11126);
//	        idItemGoldCrossbowWithBasicScope = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScope", 							11127).getInt(11127);
//	        idItemGoldCrossbowWithLongScope = 							configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScope", 							11128).getInt(11128);
//	        idItemGoldCrossbowWithBasicScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeLightMech", 					11129).getInt(11129);
//	        idItemGoldCrossbowWithLongScopeAndLightMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeLightMech", 					11130).getInt(11130);
//	        idItemGoldCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeMediumMech", 				11131).getInt(11131);
//	        idItemGoldCrossbowWithLongScopeAndMediumMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeMediumMech", 					11132).getInt(11132);
//	        idItemGoldCrossbowWithBasicScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowBasicScopeHeavyMech", 					11133).getInt(11133);
//	        idItemGoldCrossbowWithLongScopeAndHeavyMech = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLongScopeHeavyMech", 					11134).getInt(11134);
//	        idItemGoldCrossbowWithLightMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightMech", 							11135).getInt(11135);
//	        idItemGoldCrossbowWithMediumMech = 							configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowMediumMech", 							11136).getInt(11136);
//	        idItemGoldCrossbowWithHeavyMech = 							configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowHeavyMech", 							11137).getInt(11137);
//	        idItemGoldCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowExplosiveAttachment", 					11138).getInt(11138);
//	        idItemGoldCrossbowWithFireAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachment", 						11139).getInt(11139);
//	        idItemGoldCrossbowWithLavaAttachment = 						configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLavaAttachment", 						11140).getInt(11140);
//	        idItemGoldCrossbowWithIceAttachment = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachment", 						11141).getInt(11141);
//	        idItemGoldCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLightningAttachment", 					11142).getInt(11142);
//	        idItemGoldCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachment", 						11143).getInt(11143);
//	        idItemGoldCrossbowWithPoisonAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowPoisonAttachment", 					11144).getInt(11144);
//	        idItemGoldCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowExplosiveAttachmentLightMech", 		11145).getInt(11145);
//	        idItemGoldCrossbowWithFireAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentLightMech", 				11146).getInt(11146);
//	        idItemGoldCrossbowWithLavaAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLavaAttachmentLightMech", 				11147).getInt(11147);
//	        idItemGoldCrossbowWithIceAttachmentAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentLightMech", 				11148).getInt(11148);
//	        idItemGoldCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"GoldCrossbowLightningAttachmentLightMech", 		11149).getInt(11149);
//	        idItemGoldCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentLightMech", 			11150).getInt(11150);
//	        idItemGoldCrossbowWithPoisonAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentLightMech", 			11151).getInt(11151);
//	        idItemGoldCrossbowWithExplosiveAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowExplosiveAttachmentMediumMech", 		11152).getInt(11152);
//	        idItemGoldCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentMediumMech", 			11153).getInt(11153);
//	        idItemGoldCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLavaAttachmentMediumMech", 			11154).getInt(11154);
//	        idItemGoldCrossbowWithIceAttachmentAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentMediumMech", 				11155).getInt(11155);
//	        idItemGoldCrossbowWithLightningAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightningAttachmentMediumMech", 		11156).getInt(11156);
//	        idItemGoldCrossbowWithTorchAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentMediumMech", 			11157).getInt(11157);
//	        idItemGoldCrossbowWithPoisonAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentMediumMech", 			11158).getInt(11158);
//	        idItemGoldCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowExplosiveAttachmentHeavyMech", 		11159).getInt(11159);
//	        idItemGoldCrossbowWithFireAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowFireAttachmentHeavyMech", 				11160).getInt(11160);
//	        idItemGoldCrossbowWithLavaAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLavaAttachmentHeavyMech", 				11161).getInt(11161);
//	        idItemGoldCrossbowWithIceAttachmentAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowIceAttachmentHeavyMech", 				11162).getInt(11162);
//	        idItemGoldCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowLightningAttachmentHeavyMech", 		11163).getInt(11163);
//	        idItemGoldCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowTorchAttachmentHeavyMech", 			11164).getInt(11164);
//	        idItemGoldCrossbowWithPoisonAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldCrossbowPoisonAttachmentHeavyMech", 			11165).getInt(11165);
//
	        idItemGoldBolt = 											configuration.get(Configuration.CATEGORY_ITEM, 					"GoldBolt", 										11010).getInt(11010);
//	        
//	        idItemDiamondCrossbowBase = 								configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbow", 									11167).getInt(11167);
//	        idItemDiamondCrossbowWithBasicScope = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScope", 						11168).getInt(11168);
//	        idItemDiamondCrossbowWithLongScope = 						configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScope", 						11169).getInt(11169);
//	        idItemDiamondCrossbowWithBasicScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeLightMech", 				11170).getInt(11170);
//	        idItemDiamondCrossbowWithLongScopeAndLightMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeLightMech", 				11171).getInt(11171);
//	        idItemDiamondCrossbowWithBasicScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeMediumMech", 				11172).getInt(11172);
//	        idItemDiamondCrossbowWithLongScopeAndMediumMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeMediumMech", 				11173).getInt(11173);
//	        idItemDiamondCrossbowWithBasicScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowBasicScopeHeavyMech", 				11174).getInt(11174);
//	        idItemDiamondCrossbowWithLongScopeAndHeavyMech = 			configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLongScopeHeavyMech", 				11175).getInt(11175);
//	        idItemDiamondCrossbowWithLightMech = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightMech", 						11176).getInt(11176);
//	        idItemDiamondCrossbowWithMediumMech = 						configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowMediumMech", 						11177).getInt(11177);
//	        idItemDiamondCrossbowWithHeavyMech = 						configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowHeavyMech", 						11178).getInt(11178);
//	        idItemDiamondCrossbowWithExplosiveAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowExplosiveAttachment", 				11179).getInt(11179);
//	        idItemDiamondCrossbowWithFireAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachment", 					11180).getInt(11180);
//	        idItemDiamondCrossbowWithLavaAttachment = 					configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLavaAttachment", 					11181).getInt(11181);
//	        idItemDiamondCrossbowWithIceAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachment", 					11182).getInt(11182);
//	        idItemDiamondCrossbowWithLightningAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLightningAttachment", 				11183).getInt(11183);
//	        idItemDiamondCrossbowWithTorchAttachment = 					configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachment", 					11184).getInt(11184);
//	        idItemDiamondCrossbowWithPoisonAttachment = 				configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowPoisonAttachment", 					11185).getInt(11185);
//	        idItemDiamondCrossbowWithExplosiveAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowExplosiveAttachmentLightMech", 		11186).getInt(11186);
//	        idItemDiamondCrossbowWithFireAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentLightMech", 			11187).getInt(11187);
//	        idItemDiamondCrossbowWithLavaAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLavaAttachmentLightMech", 			11188).getInt(11188);
//	        idItemDiamondCrossbowWithIceAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentLightMech", 			11189).getInt(11189);
//	        idItemDiamondCrossbowWithLightningAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondCrossbowLightningAttachmentLightMech", 		11190).getInt(11190);
//	        idItemDiamondCrossbowWithTorchAttachmentAndLightMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentLightMech", 			11191).getInt(11191);
//	        idItemDiamondCrossbowWithPoisonAttachmentAndLightMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentLightMech", 		11192).getInt(11192);
//	        idItemDiamondCrossbowWithExplosiveAttachmentAndMediumMech = configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowExplosiveAttachmentMediumMech", 	11193).getInt(11193);
//	        idItemDiamondCrossbowWithFireAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentMediumMech", 			11194).getInt(11194);
//	        idItemDiamondCrossbowWithLavaAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLavaAttachmentMediumMech", 			11195).getInt(11195);
//	        idItemDiamondCrossbowWithIceAttachmentAndMediumMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentMediumMech", 			11196).getInt(11196);
//	        idItemDiamondCrossbowWithLightningAttachmentAndMediumMech = configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightningAttachmentMediumMech", 	11197).getInt(11197);
//	        idItemDiamondCrossbowWithTorchAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentMediumMech", 		11198).getInt(11198);
//	        idItemDiamondCrossbowWithPoisonAttachmentAndMediumMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentMediumMech", 		11199).getInt(11199);
//	        idItemDiamondCrossbowWithExplosiveAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowExplosiveAttachmentHeavyMech", 		11200).getInt(11200);
//	        idItemDiamondCrossbowWithFireAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowFireAttachmentHeavyMech", 			11201).getInt(11201);
//	        idItemDiamondCrossbowWithLavaAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLavaAttachmentHeavyMech", 			11202).getInt(11202);
//	        idItemDiamondCrossbowWithIceAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowIceAttachmentHeavyMech", 			11203).getInt(11203);
//	        idItemDiamondCrossbowWithLightningAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowLightningAttachmentHeavyMech", 		11204).getInt(11204);
//	        idItemDiamondCrossbowWithTorchAttachmentAndHeavyMech = 		configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowTorchAttachmentHeavyMech", 			11205).getInt(11205);
//	        idItemDiamondCrossbowWithPoisonAttachmentAndHeavyMech = 	configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondCrossbowPoisonAttachmentHeavyMech", 		11206).getInt(11206);

	        idItemDiamondBolt = 										configuration.get(Configuration.CATEGORY_ITEM, 					"DiamondBolt", 										11011).getInt(11011);

	        idBlockCrossbowBench = 										configuration.get(Configuration.CATEGORY_BLOCK, 				"BlockCrossbowBench", 								1999).getInt(1999);

	        idItemWoodLimb = 											configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodLimb", 										11012).getInt(11012);
	        idItemStoneLimb = 											configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneLimb", 										11013).getInt(11013);
	        idItemIronLimb = 											configuration.get(Configuration.CATEGORY_ITEM,	 				"IronLimb", 										11014).getInt(11014);
	        idItemGoldLimb = 											configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldLimb", 										11015).getInt(11015);
	        idItemDiamondLimb = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondLimb", 										11016).getInt(11016);

	        idItemSemiAutoMechanism = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"SemiAutoMechanism", 								11017).getInt(11017);
	        idItemLightAutoMechanism = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"LightAutoMechanism", 								11018).getInt(11018);
	        idItemMediumAutoMechanism = 								configuration.get(Configuration.CATEGORY_ITEM,	 				"MediumAutoMechanism", 								11019).getInt(11019);
	        idItemHeavyAutoMechanism = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"HeavyAutoMechanism", 								11020).getInt(11020);

	        idItemBasicScope = 											configuration.get(Configuration.CATEGORY_ITEM,	 				"BasicScope", 										11021).getInt(11021);
	        idItemLongRangeScope = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"LongRangeScope", 									11022).getInt(11022);
	        idItemFlameAttachment = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"FlameAttachment", 									11023).getInt(11023);
	        idItemExplosiveAttachment = 								configuration.get(Configuration.CATEGORY_ITEM,	 				"ExplosiveAttachment", 								11024).getInt(11024);
	        idItemLavaAttachment = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"LavaAttachment", 									11025).getInt(11025);
	        idItemIceAttachment = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"FrostAttachment", 									11026).getInt(11026);
	        idItemLightningAttachment = 								configuration.get(Configuration.CATEGORY_ITEM,	 				"LightningAttachment", 								11027).getInt(11027);
	        idItemTorchAttachment = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"TorchAttachment", 									11028).getInt(11028);
	        idItemPoisonAttachment = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"PoisonAttachment", 								11029).getInt(11029);

	        GUIID_BlockCrossbowBench = 									configuration.get("GUI",	 									"BlockCrossbowBenchGuiID", 							193).getInt(193);

	        idEntityWoodCrossbow = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodBoltEntityID", 								193).getInt(193);
	        idEntityStoneCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneBoltEntityID", 								194).getInt(194);
	        idEntityIronCrossbow = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"IronBoltEntityID", 								195).getInt(195);
	        idEntityGoldCrossbow = 										configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldBoltEntityID", 								196).getInt(196);
	        idEntityDiamondCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondBoltEntityID", 								197).getInt(197);
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
