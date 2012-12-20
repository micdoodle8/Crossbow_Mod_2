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
	
	public static boolean shouldCheckVersion;
	
	public static int idItemWoodCrossbow;
	public static int idItemStoneCrossbow;
	public static int idItemIronCrossbow;
	public static int idItemGoldCrossbow;
	public static int idItemDiamondCrossbow;

	public static int idItemAttachLimbBolt;
    
    public static int idBlockCrossbowBench;
    
    public static int idEntityWoodCrossbow, idEntityStoneCrossbow, idEntityIronCrossbow, idEntityGoldCrossbow, idEntityDiamondCrossbow;
    
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
	        
	        idItemAttachLimbBolt = 									configuration.get(Configuration.CATEGORY_ITEM, 					"Attachments, Limbs, Bolts", 						11008).getInt(11008);
	        
	        idBlockCrossbowBench = 									configuration.get(Configuration.CATEGORY_BLOCK, 				"BlockCrossbowBench", 								1999).getInt(1999);

	        GUIID_BlockCrossbowBench = 								configuration.get("GUI",	 									"BlockCrossbowBenchGuiID", 							193).getInt(193);

	        idEntityWoodCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"WoodBoltEntityID", 								193).getInt(193);
	        idEntityStoneCrossbow = 								configuration.get(Configuration.CATEGORY_ITEM,	 				"StoneBoltEntityID", 								194).getInt(194);
	        idEntityIronCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"IronBoltEntityID", 								195).getInt(195);
	        idEntityGoldCrossbow = 									configuration.get(Configuration.CATEGORY_ITEM,	 				"GoldBoltEntityID", 								196).getInt(196);
	        idEntityDiamondCrossbow = 								configuration.get(Configuration.CATEGORY_ITEM,	 				"DiamondBoltEntityID", 								197).getInt(197);
		
	        shouldCheckVersion = 									configuration.get(Configuration.CATEGORY_GENERAL,               "ShouldCheckVersion",                               true).getBoolean(true);
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
