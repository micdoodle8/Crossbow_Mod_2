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
        if (!ConfigManager.loaded)
        {
            ConfigManager.configuration = new Configuration(event.getSuggestedConfigurationFile());
            this.setDefaultValues();
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

    public static int idEntityWoodCrossbow, idEntityStoneCrossbow,
            idEntityIronCrossbow, idEntityGoldCrossbow,
            idEntityDiamondCrossbow;

    public static int GUIID_BlockCrossbowBench;

    private void setDefaultValues()
    {
        try
        {
            ConfigManager.configuration.load();

            ConfigManager.idItemWoodCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "WoodCrossbow", 11003).getInt(11003);
            ConfigManager.idItemStoneCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "StoneCrossbow", 11004).getInt(11004);
            ConfigManager.idItemIronCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "IronCrossbow", 11005).getInt(11005);
            ConfigManager.idItemGoldCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "GoldCrossbow", 11006).getInt(11006);
            ConfigManager.idItemDiamondCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "DiamondCrossbow", 11007).getInt(11007);

            ConfigManager.idItemAttachLimbBolt = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "Attachments, Limbs, Bolts", 11008).getInt(11008);

            ConfigManager.idBlockCrossbowBench = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "BlockCrossbowBench", 1999).getInt(1999);

            ConfigManager.GUIID_BlockCrossbowBench = ConfigManager.configuration.get("GUI", "BlockCrossbowBenchGuiID", 193).getInt(193);

            ConfigManager.idEntityWoodCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "WoodBoltEntityID", 193).getInt(193);
            ConfigManager.idEntityStoneCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "StoneBoltEntityID", 194).getInt(194);
            ConfigManager.idEntityIronCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "IronBoltEntityID", 195).getInt(195);
            ConfigManager.idEntityGoldCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "GoldBoltEntityID", 196).getInt(196);
            ConfigManager.idEntityDiamondCrossbow = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "DiamondBoltEntityID", 197).getInt(197);

            ConfigManager.shouldCheckVersion = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "ShouldCheckVersion", true).getBoolean(true);
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "CrossbowMod has a problem loading it's configuration");
        }
        finally
        {
            ConfigManager.configuration.save();
            ConfigManager.loaded = true;
        }
    }
}
