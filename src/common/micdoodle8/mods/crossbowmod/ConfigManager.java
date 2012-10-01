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
	        idItemWoodCrossbowBase = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbow", Configuration.CATEGORY_ITEM, 11003).value);
	        idItemWoodCrossbowWithBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowBasicScope", Configuration.CATEGORY_ITEM, 11004).value);
	        idItemWoodCrossbowWithLongScope = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLongScope", Configuration.CATEGORY_ITEM, 11005).value);
	        idItemWoodCrossbowWithBasicScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowBasicScopeLightMech", Configuration.CATEGORY_ITEM, 11006).value);
	        idItemWoodCrossbowWithLongScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLongScopeLightMech", Configuration.CATEGORY_ITEM, 11007).value);
	        idItemWoodCrossbowWithBasicScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowBasicScopeMediumMech", Configuration.CATEGORY_ITEM, 11008).value);
	        idItemWoodCrossbowWithLongScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLongScopeMediumMech", Configuration.CATEGORY_ITEM, 11009).value);
	        idItemWoodCrossbowWithBasicScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowBasicScopeHeavyMech", Configuration.CATEGORY_ITEM, 11010).value);
	        idItemWoodCrossbowWithLongScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLongScopeHeavyMech", Configuration.CATEGORY_ITEM, 11011).value);
	        idItemWoodCrossbowWithLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLightMech", Configuration.CATEGORY_ITEM, 11012).value);
	        idItemWoodCrossbowWithMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowMediumMech", Configuration.CATEGORY_ITEM, 11013).value);
	        idItemWoodCrossbowWithHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowHeavyMech", Configuration.CATEGORY_ITEM, 11014).value);
	        idItemWoodCrossbowWithExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowExplosiveAttachment", Configuration.CATEGORY_ITEM, 11015).value);
	        idItemWoodCrossbowWithFireAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowFireAttachment", Configuration.CATEGORY_ITEM, 11016).value);
	        idItemWoodCrossbowWithLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLavaAttachment", Configuration.CATEGORY_ITEM, 11017).value);
	        idItemWoodCrossbowWithIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowIceAttachment", Configuration.CATEGORY_ITEM, 11018).value);
	        idItemWoodCrossbowWithLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLightningAttachment", Configuration.CATEGORY_ITEM, 11019).value);
	        idItemWoodCrossbowWithTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowTorchAttachment", Configuration.CATEGORY_ITEM, 11020).value);
	        idItemWoodCrossbowWithPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowPoisonAttachment", Configuration.CATEGORY_ITEM, 11021).value);
	        idItemWoodCrossbowWithExplosiveAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowExplosiveAttachmentLightMech", Configuration.CATEGORY_ITEM, 11022).value);
	        idItemWoodCrossbowWithFireAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowFireAttachmentLightMech", Configuration.CATEGORY_ITEM, 11023).value);
	        idItemWoodCrossbowWithLavaAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLavaAttachmentLightMech", Configuration.CATEGORY_ITEM, 11024).value);
	        idItemWoodCrossbowWithIceAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowIceAttachmentLightMech", Configuration.CATEGORY_ITEM, 11025).value);
	        idItemWoodCrossbowWithLightningAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLightningAttachmentLightMech", Configuration.CATEGORY_ITEM, 11026).value);
	        idItemWoodCrossbowWithTorchAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowTorchAttachmentLightMech", Configuration.CATEGORY_ITEM, 11027).value);
	        idItemWoodCrossbowWithPoisonAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowPoisonAttachmentLightMech", Configuration.CATEGORY_ITEM, 11028).value);
	        idItemWoodCrossbowWithExplosiveAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowExplosiveAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11029).value);
	        idItemWoodCrossbowWithFireAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowFireAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11030).value);
	        idItemWoodCrossbowWithLavaAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLavaAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11031).value);
	        idItemWoodCrossbowWithIceAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowIceAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11032).value);
	        idItemWoodCrossbowWithLightningAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLightningAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11033).value);
	        idItemWoodCrossbowWithTorchAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowTorchAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11034).value);
	        idItemWoodCrossbowWithPoisonAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowPoisonAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11035).value);
	        idItemWoodCrossbowWithExplosiveAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowExplosiveAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11036).value);
	        idItemWoodCrossbowWithFireAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowFireAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11037).value);
	        idItemWoodCrossbowWithLavaAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLavaAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11038).value);
	        idItemWoodCrossbowWithIceAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowIceAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11039).value);
	        idItemWoodCrossbowWithLightningAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowLightningAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11040).value);
	        idItemWoodCrossbowWithTorchAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowTorchAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11041).value);
	        idItemWoodCrossbowWithPoisonAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("WoodCrossbowPoisonAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11042).value);
	        
	        idItemWoodBolt = Integer.parseInt(configuration.getOrCreateIntProperty("WoodBolt", Configuration.CATEGORY_ITEM, 11043).value);
	
	        idItemStoneCrossbowBase = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbow", Configuration.CATEGORY_ITEM, 11044).value);
	        idItemStoneCrossbowWithBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowBasicScope", Configuration.CATEGORY_ITEM, 11045).value);
	        idItemStoneCrossbowWithLongScope = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLongScope", Configuration.CATEGORY_ITEM, 11046).value);
	        idItemStoneCrossbowWithBasicScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowBasicScopeLightMech", Configuration.CATEGORY_ITEM, 11047).value);
	        idItemStoneCrossbowWithLongScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLongScopeLightMech", Configuration.CATEGORY_ITEM, 11048).value);
	        idItemStoneCrossbowWithBasicScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowBasicScopeMediumMech", Configuration.CATEGORY_ITEM, 11049).value);
	        idItemStoneCrossbowWithLongScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLongScopeMediumMech", Configuration.CATEGORY_ITEM, 11050).value);
	        idItemStoneCrossbowWithBasicScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowBasicScopeHeavyMech", Configuration.CATEGORY_ITEM, 11051).value);
	        idItemStoneCrossbowWithLongScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLongScopeHeavyMech", Configuration.CATEGORY_ITEM, 11052).value);
	        idItemStoneCrossbowWithLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLightMech", Configuration.CATEGORY_ITEM, 11053).value);
	        idItemStoneCrossbowWithMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowMediumMech", Configuration.CATEGORY_ITEM, 11054).value);
	        idItemStoneCrossbowWithHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowHeavyMech", Configuration.CATEGORY_ITEM, 11055).value);
	        idItemStoneCrossbowWithExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowExplosiveAttachment", Configuration.CATEGORY_ITEM, 11056).value);
	        idItemStoneCrossbowWithFireAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowFireAttachment", Configuration.CATEGORY_ITEM, 11057).value);
	        idItemStoneCrossbowWithLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLavaAttachment", Configuration.CATEGORY_ITEM, 11058).value);
	        idItemStoneCrossbowWithIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowIceAttachment", Configuration.CATEGORY_ITEM, 11059).value);
	        idItemStoneCrossbowWithLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLightningAttachment", Configuration.CATEGORY_ITEM, 11060).value);
	        idItemStoneCrossbowWithTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowTorchAttachment", Configuration.CATEGORY_ITEM, 11061).value);
	        idItemStoneCrossbowWithPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowPoisonAttachment", Configuration.CATEGORY_ITEM, 11062).value);
	        idItemStoneCrossbowWithExplosiveAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowExplosiveAttachmentLightMech", Configuration.CATEGORY_ITEM, 11063).value);
	        idItemStoneCrossbowWithFireAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowFireAttachmentLightMech", Configuration.CATEGORY_ITEM, 11064).value);
	        idItemStoneCrossbowWithLavaAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLavaAttachmentLightMech", Configuration.CATEGORY_ITEM, 11065).value);
	        idItemStoneCrossbowWithIceAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowIceAttachmentLightMech", Configuration.CATEGORY_ITEM, 11066).value);
	        idItemStoneCrossbowWithLightningAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLightningAttachmentLightMech", Configuration.CATEGORY_ITEM, 11067).value);
	        idItemStoneCrossbowWithTorchAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowTorchAttachmentLightMech", Configuration.CATEGORY_ITEM, 11068).value);
	        idItemStoneCrossbowWithPoisonAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowPoisonAttachmentLightMech", Configuration.CATEGORY_ITEM, 11069).value);
	        idItemStoneCrossbowWithExplosiveAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowExplosiveAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11070).value);
	        idItemStoneCrossbowWithFireAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowFireAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11071).value);
	        idItemStoneCrossbowWithLavaAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLavaAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11072).value);
	        idItemStoneCrossbowWithIceAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowIceAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11073).value);
	        idItemStoneCrossbowWithLightningAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLightningAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11074).value);
	        idItemStoneCrossbowWithTorchAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowTorchAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11075).value);
	        idItemStoneCrossbowWithPoisonAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowPoisonAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11076).value);
	        idItemStoneCrossbowWithExplosiveAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowExplosiveAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11077).value);
	        idItemStoneCrossbowWithFireAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowFireAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11078).value);
	        idItemStoneCrossbowWithLavaAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLavaAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11079).value);
	        idItemStoneCrossbowWithIceAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowIceAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11080).value);
	        idItemStoneCrossbowWithLightningAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowLightningAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11081).value);
	        idItemStoneCrossbowWithTorchAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowTorchAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11082).value);
	        idItemStoneCrossbowWithPoisonAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("StoneCrossbowPoisonAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11083).value);
	        
	        idItemStoneBolt = Integer.parseInt(configuration.getOrCreateIntProperty("StoneBolt", Configuration.CATEGORY_ITEM, 11084).value);
	
	        idItemIronCrossbowBase = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbow", Configuration.CATEGORY_ITEM, 11085).value);
	        idItemIronCrossbowWithBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowBasicScope", Configuration.CATEGORY_ITEM, 11086).value);
	        idItemIronCrossbowWithLongScope = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLongScope", Configuration.CATEGORY_ITEM, 11087).value);
	        idItemIronCrossbowWithBasicScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowBasicScopeLightMech", Configuration.CATEGORY_ITEM, 11088).value);
	        idItemIronCrossbowWithLongScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLongScopeLightMech", Configuration.CATEGORY_ITEM, 11089).value);
	        idItemIronCrossbowWithBasicScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowBasicScopeMediumMech", Configuration.CATEGORY_ITEM, 11090).value);
	        idItemIronCrossbowWithLongScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLongScopeMediumMech", Configuration.CATEGORY_ITEM, 11091).value);
	        idItemIronCrossbowWithBasicScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowBasicScopeHeavyMech", Configuration.CATEGORY_ITEM, 11092).value);
	        idItemIronCrossbowWithLongScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLongScopeHeavyMech", Configuration.CATEGORY_ITEM, 11093).value);
	        idItemIronCrossbowWithLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLightMech", Configuration.CATEGORY_ITEM, 11094).value);
	        idItemIronCrossbowWithMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowMediumMech", Configuration.CATEGORY_ITEM, 11095).value);
	        idItemIronCrossbowWithHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowHeavyMech", Configuration.CATEGORY_ITEM, 11096).value);
	        idItemIronCrossbowWithExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowExplosiveAttachment", Configuration.CATEGORY_ITEM, 11097).value);
	        idItemIronCrossbowWithFireAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowFireAttachment", Configuration.CATEGORY_ITEM, 11098).value);
	        idItemIronCrossbowWithLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLavaAttachment", Configuration.CATEGORY_ITEM, 11099).value);
	        idItemIronCrossbowWithIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowIceAttachment", Configuration.CATEGORY_ITEM, 11100).value);
	        idItemIronCrossbowWithLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLightningAttachment", Configuration.CATEGORY_ITEM, 11101).value);
	        idItemIronCrossbowWithTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowTorchAttachment", Configuration.CATEGORY_ITEM, 11102).value);
	        idItemIronCrossbowWithPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowPoisonAttachment", Configuration.CATEGORY_ITEM, 11103).value);
	        idItemIronCrossbowWithExplosiveAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowExplosiveAttachmentLightMech", Configuration.CATEGORY_ITEM, 11104).value);
	        idItemIronCrossbowWithFireAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowFireAttachmentLightMech", Configuration.CATEGORY_ITEM, 11105).value);
	        idItemIronCrossbowWithLavaAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLavaAttachmentLightMech", Configuration.CATEGORY_ITEM, 11106).value);
	        idItemIronCrossbowWithIceAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowIceAttachmentLightMech", Configuration.CATEGORY_ITEM, 11107).value);
	        idItemIronCrossbowWithLightningAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLightningAttachmentLightMech", Configuration.CATEGORY_ITEM, 11108).value);
	        idItemIronCrossbowWithTorchAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowTorchAttachmentLightMech", Configuration.CATEGORY_ITEM, 11109).value);
	        idItemIronCrossbowWithPoisonAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowPoisonAttachmentLightMech", Configuration.CATEGORY_ITEM, 11110).value);
	        idItemIronCrossbowWithExplosiveAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowExplosiveAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11111).value);
	        idItemIronCrossbowWithFireAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowFireAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11112).value);
	        idItemIronCrossbowWithLavaAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLavaAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11113).value);
	        idItemIronCrossbowWithIceAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowIceAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11114).value);
	        idItemIronCrossbowWithLightningAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLightningAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11115).value);
	        idItemIronCrossbowWithTorchAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowTorchAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11116).value);
	        idItemIronCrossbowWithPoisonAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowPoisonAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11117).value);
	        idItemIronCrossbowWithExplosiveAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowExplosiveAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11118).value);
	        idItemIronCrossbowWithFireAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowFireAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11119).value);
	        idItemIronCrossbowWithLavaAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLavaAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11120).value);
	        idItemIronCrossbowWithIceAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowIceAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11121).value);
	        idItemIronCrossbowWithLightningAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowLightningAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11122).value);
	        idItemIronCrossbowWithTorchAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowTorchAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11123).value);
	        idItemIronCrossbowWithPoisonAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("IronCrossbowPoisonAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11124).value);
	        
	        idItemIronBolt = Integer.parseInt(configuration.getOrCreateIntProperty("IronBolt", Configuration.CATEGORY_ITEM, 11125).value);
	
	        idItemGoldCrossbowBase = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbow", Configuration.CATEGORY_ITEM, 11126).value);
	        idItemGoldCrossbowWithBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowBasicScope", Configuration.CATEGORY_ITEM, 11127).value);
	        idItemGoldCrossbowWithLongScope = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLongScope", Configuration.CATEGORY_ITEM, 11128).value);
	        idItemGoldCrossbowWithBasicScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowBasicScopeLightMech", Configuration.CATEGORY_ITEM, 11129).value);
	        idItemGoldCrossbowWithLongScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLongScopeLightMech", Configuration.CATEGORY_ITEM, 11130).value);
	        idItemGoldCrossbowWithBasicScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowBasicScopeMediumMech", Configuration.CATEGORY_ITEM, 11131).value);
	        idItemGoldCrossbowWithLongScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLongScopeMediumMech", Configuration.CATEGORY_ITEM, 11132).value);
	        idItemGoldCrossbowWithBasicScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowBasicScopeHeavyMech", Configuration.CATEGORY_ITEM, 11133).value);
	        idItemGoldCrossbowWithLongScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLongScopeHeavyMech", Configuration.CATEGORY_ITEM, 11134).value);
	        idItemGoldCrossbowWithLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLightMech", Configuration.CATEGORY_ITEM, 11135).value);
	        idItemGoldCrossbowWithMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowMediumMech", Configuration.CATEGORY_ITEM, 11136).value);
	        idItemGoldCrossbowWithHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowHeavyMech", Configuration.CATEGORY_ITEM, 11137).value);
	        idItemGoldCrossbowWithExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowExplosiveAttachment", Configuration.CATEGORY_ITEM, 11138).value);
	        idItemGoldCrossbowWithFireAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowFireAttachment", Configuration.CATEGORY_ITEM, 11139).value);
	        idItemGoldCrossbowWithLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLavaAttachment", Configuration.CATEGORY_ITEM, 11140).value);
	        idItemGoldCrossbowWithIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowIceAttachment", Configuration.CATEGORY_ITEM, 11141).value);
	        idItemGoldCrossbowWithLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLightningAttachment", Configuration.CATEGORY_ITEM, 11142).value);
	        idItemGoldCrossbowWithTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowTorchAttachment", Configuration.CATEGORY_ITEM, 11143).value);
	        idItemGoldCrossbowWithPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowPoisonAttachment", Configuration.CATEGORY_ITEM, 11144).value);
	        idItemGoldCrossbowWithExplosiveAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowExplosiveAttachmentLightMech", Configuration.CATEGORY_ITEM, 11145).value);
	        idItemGoldCrossbowWithFireAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowFireAttachmentLightMech", Configuration.CATEGORY_ITEM, 11146).value);
	        idItemGoldCrossbowWithLavaAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLavaAttachmentLightMech", Configuration.CATEGORY_ITEM, 11147).value);
	        idItemGoldCrossbowWithIceAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowIceAttachmentLightMech", Configuration.CATEGORY_ITEM, 11148).value);
	        idItemGoldCrossbowWithLightningAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLightningAttachmentLightMech", Configuration.CATEGORY_ITEM, 11149).value);
	        idItemGoldCrossbowWithTorchAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowTorchAttachmentLightMech", Configuration.CATEGORY_ITEM, 11150).value);
	        idItemGoldCrossbowWithPoisonAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowPoisonAttachmentLightMech", Configuration.CATEGORY_ITEM, 11151).value);
	        idItemGoldCrossbowWithExplosiveAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowExplosiveAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11152).value);
	        idItemGoldCrossbowWithFireAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowFireAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11153).value);
	        idItemGoldCrossbowWithLavaAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLavaAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11154).value);
	        idItemGoldCrossbowWithIceAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowIceAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11155).value);
	        idItemGoldCrossbowWithLightningAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLightningAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11156).value);
	        idItemGoldCrossbowWithTorchAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowTorchAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11157).value);
	        idItemGoldCrossbowWithPoisonAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowPoisonAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11158).value);
	        idItemGoldCrossbowWithExplosiveAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowExplosiveAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11159).value);
	        idItemGoldCrossbowWithFireAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowFireAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11160).value);
	        idItemGoldCrossbowWithLavaAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLavaAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11161).value);
	        idItemGoldCrossbowWithIceAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowIceAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11162).value);
	        idItemGoldCrossbowWithLightningAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowLightningAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11163).value);
	        idItemGoldCrossbowWithTorchAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowTorchAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11164).value);
	        idItemGoldCrossbowWithPoisonAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("GoldCrossbowPoisonAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11165).value);
	        
	        idItemGoldBolt = Integer.parseInt(configuration.getOrCreateIntProperty("GoldBolt", Configuration.CATEGORY_ITEM, 11166).value);
	
	        idItemDiamondCrossbowBase = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbow", Configuration.CATEGORY_ITEM, 11167).value);
	        idItemDiamondCrossbowWithBasicScope = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowBasicScope", Configuration.CATEGORY_ITEM, 11168).value);
	        idItemDiamondCrossbowWithLongScope = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLongScope", Configuration.CATEGORY_ITEM, 11169).value);
	        idItemDiamondCrossbowWithBasicScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowBasicScopeLightMech", Configuration.CATEGORY_ITEM, 11170).value);
	        idItemDiamondCrossbowWithLongScopeAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLongScopeLightMech", Configuration.CATEGORY_ITEM, 11171).value);
	        idItemDiamondCrossbowWithBasicScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowBasicScopeMediumMech", Configuration.CATEGORY_ITEM, 11172).value);
	        idItemDiamondCrossbowWithLongScopeAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLongScopeMediumMech", Configuration.CATEGORY_ITEM, 11173).value);
	        idItemDiamondCrossbowWithBasicScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowBasicScopeHeavyMech", Configuration.CATEGORY_ITEM, 11174).value);
	        idItemDiamondCrossbowWithLongScopeAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLongScopeHeavyMech", Configuration.CATEGORY_ITEM, 11175).value);
	        idItemDiamondCrossbowWithLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLightMech", Configuration.CATEGORY_ITEM, 11176).value);
	        idItemDiamondCrossbowWithMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowMediumMech", Configuration.CATEGORY_ITEM, 11177).value);
	        idItemDiamondCrossbowWithHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowHeavyMech", Configuration.CATEGORY_ITEM, 11178).value);
	        idItemDiamondCrossbowWithExplosiveAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowExplosiveAttachment", Configuration.CATEGORY_ITEM, 11179).value);
	        idItemDiamondCrossbowWithFireAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowFireAttachment", Configuration.CATEGORY_ITEM, 11180).value);
	        idItemDiamondCrossbowWithLavaAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLavaAttachment", Configuration.CATEGORY_ITEM, 11181).value);
	        idItemDiamondCrossbowWithIceAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowIceAttachment", Configuration.CATEGORY_ITEM, 11182).value);
	        idItemDiamondCrossbowWithLightningAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLightningAttachment", Configuration.CATEGORY_ITEM, 11183).value);
	        idItemDiamondCrossbowWithTorchAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowTorchAttachment", Configuration.CATEGORY_ITEM, 11184).value);
	        idItemDiamondCrossbowWithPoisonAttachment = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowPoisonAttachment", Configuration.CATEGORY_ITEM, 11185).value);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowExplosiveAttachmentLightMech", Configuration.CATEGORY_ITEM, 11186).value);
	        idItemDiamondCrossbowWithFireAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowFireAttachmentLightMech", Configuration.CATEGORY_ITEM, 11187).value);
	        idItemDiamondCrossbowWithLavaAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLavaAttachmentLightMech", Configuration.CATEGORY_ITEM, 11188).value);
	        idItemDiamondCrossbowWithIceAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowIceAttachmentLightMech", Configuration.CATEGORY_ITEM, 11189).value);
	        idItemDiamondCrossbowWithLightningAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLightningAttachmentLightMech", Configuration.CATEGORY_ITEM, 11190).value);
	        idItemDiamondCrossbowWithTorchAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowTorchAttachmentLightMech", Configuration.CATEGORY_ITEM, 11191).value);
	        idItemDiamondCrossbowWithPoisonAttachmentAndLightMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowPoisonAttachmentLightMech", Configuration.CATEGORY_ITEM, 11192).value);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowExplosiveAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11193).value);
	        idItemDiamondCrossbowWithFireAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowFireAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11194).value);
	        idItemDiamondCrossbowWithLavaAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLavaAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11195).value);
	        idItemDiamondCrossbowWithIceAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowIceAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11196).value);
	        idItemDiamondCrossbowWithLightningAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLightningAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11197).value);
	        idItemDiamondCrossbowWithTorchAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowTorchAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11198).value);
	        idItemDiamondCrossbowWithPoisonAttachmentAndMediumMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowPoisonAttachmentMediumMech", Configuration.CATEGORY_ITEM, 11199).value);
	        idItemDiamondCrossbowWithExplosiveAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowExplosiveAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11200).value);
	        idItemDiamondCrossbowWithFireAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowFireAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11201).value);
	        idItemDiamondCrossbowWithLavaAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLavaAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11202).value);
	        idItemDiamondCrossbowWithIceAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowIceAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11203).value);
	        idItemDiamondCrossbowWithLightningAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowLightningAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11204).value);
	        idItemDiamondCrossbowWithTorchAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowTorchAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11205).value);
	        idItemDiamondCrossbowWithPoisonAttachmentAndHeavyMech = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondCrossbowPoisonAttachmentHeavyMech", Configuration.CATEGORY_ITEM, 11206).value);
	        
	        idItemDiamondBolt = Integer.parseInt(configuration.getOrCreateIntProperty("DiamondBolt", Configuration.CATEGORY_ITEM, 11207).value);
	        
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
