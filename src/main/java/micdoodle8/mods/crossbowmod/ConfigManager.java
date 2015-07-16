package micdoodle8.mods.crossbowmod;

import java.util.logging.Level;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigManager
{
    private static boolean loaded;

    static Configuration configuration;

    public ConfigManager(FMLPreInitializationEvent event)
    {
        if (!ConfigManager.loaded)
        {
            ConfigManager.configuration = new Configuration(event.getSuggestedConfigurationFile());
            this.setDefaultValues();
        }
    }

//    public static int idItemWoodCrossbow;
//    public static int idItemStoneCrossbow;
//    public static int idItemIronCrossbow;
//    public static int idItemGoldCrossbow;
//    public static int idItemDiamondCrossbow;

//    public static int idItemAttachLimbBolt;

//    public static int idBlockCrossbowBench;

    public static int idEntityWoodCrossbow, idEntityStoneCrossbow,
            idEntityIronCrossbow, idEntityGoldCrossbow,
            idEntityDiamondCrossbow;

    public static int idAchievementBase;

    public static int GUIID_BlockCrossbowBench;

    private void setDefaultValues()
    {
        try
        {
            ConfigManager.configuration.load();

            ConfigManager.idAchievementBase = ConfigManager.configuration.get("Achievements", "Achievement Base", 984).getInt(984);

            ConfigManager.GUIID_BlockCrossbowBench = ConfigManager.configuration.get("GUI", "BlockCrossbowBenchGuiID", 193).getInt(193);

            ConfigManager.idEntityWoodCrossbow = ConfigManager.configuration.get("Entity", "WoodBoltEntityID", 193).getInt(193);
            ConfigManager.idEntityStoneCrossbow = ConfigManager.configuration.get("Entity", "StoneBoltEntityID", 194).getInt(194);
            ConfigManager.idEntityIronCrossbow = ConfigManager.configuration.get("Entity", "IronBoltEntityID", 195).getInt(195);
            ConfigManager.idEntityGoldCrossbow = ConfigManager.configuration.get("Entity", "GoldBoltEntityID", 196).getInt(196);
            ConfigManager.idEntityDiamondCrossbow = ConfigManager.configuration.get("Entity", "DiamondBoltEntityID", 197).getInt(197);
        }
        catch (Exception e)
        {
            FMLLog.severe("CrossbowMod has a problem loading it's configuration");
            e.printStackTrace();
        }
        finally
        {
            ConfigManager.configuration.save();
            ConfigManager.loaded = true;
        }
    }
}
