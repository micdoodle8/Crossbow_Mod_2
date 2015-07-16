package micdoodle8.mods.crossbowmod;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.crossbowmod.block.CrossbowBlocks;
import micdoodle8.mods.crossbowmod.entity.EntityDiamondBolt;
import micdoodle8.mods.crossbowmod.entity.EntityGoldBolt;
import micdoodle8.mods.crossbowmod.entity.EntityIronBolt;
import micdoodle8.mods.crossbowmod.entity.EntityStoneBolt;
import micdoodle8.mods.crossbowmod.entity.EntityWoodBolt;
import micdoodle8.mods.crossbowmod.item.*;
import micdoodle8.mods.crossbowmod.item.CrossbowItems;
import micdoodle8.mods.crossbowmod.network.CrossbowModChannelHandler;
import micdoodle8.mods.crossbowmod.util.Util;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "CrossbowMod2", name = "Crossbow Mod 2 1.6", version = "a0.1.6")
public class CrossbowModCore
{
    @SidedProxy(clientSide = "micdoodle8.mods.crossbowmod.client.ClientProxy", serverSide = "micdoodle8.mods.crossbowmod.CommonProxy")
    public static CommonProxy proxy;
    @Instance
    public static CrossbowModCore instance;

    public static final String MOD_ID = "CrossbowMod2";

    public static CrossbowModChannelHandler packetPipeline;

    public static final String TEXTURE_DOMAIN = CrossbowModCore.MOD_ID.toLowerCase();
    public static final String TEXTURE_PREFIX = CrossbowModCore.TEXTURE_DOMAIN + ":";

    public static long firstBootTime = System.currentTimeMillis();

    public static List<ItemCrossbow> crossbowsList = new ArrayList<ItemCrossbow>();
    public static List<ItemWoodCrossbow> woodenCrossbowsList = new ArrayList<ItemWoodCrossbow>();
    public static List<ItemStoneCrossbow> stoneCrossbowsList = new ArrayList<ItemStoneCrossbow>();
    public static List<ItemIronCrossbow> ironCrossbowsList = new ArrayList<ItemIronCrossbow>();
    public static List<ItemGoldCrossbow> goldCrossbowsList = new ArrayList<ItemGoldCrossbow>();
    public static List<ItemDiamondCrossbow> diamondCrossbowsList = new ArrayList<ItemDiamondCrossbow>();

    public static final CreativeTabs crossbowTab = new CreativeTabCrossbows("crossbows");

    public static Achievement createBench;
    public static Achievement createCrossbow;
    public static Achievement sniper;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new CrossbowEvents());

        new ConfigManager(event);

        CrossbowModCore.proxy.preInit(event);

        CrossbowItems.initItems();
        CrossbowBlocks.initBlocks();
        CrossbowBlocks.registerBlocks();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        packetPipeline = CrossbowModChannelHandler.init();

        EntityRegistry.registerModEntity(EntityWoodBolt.class, "CB_WoodBolt", ConfigManager.idEntityWoodCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityStoneBolt.class, "CB_StoneBolt", ConfigManager.idEntityStoneCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityIronBolt.class, "CB_IronBolt", ConfigManager.idEntityIronCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityGoldBolt.class, "CB_GoldBolt", ConfigManager.idEntityGoldCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityDiamondBolt.class, "CB_DiamondBolt", ConfigManager.idEntityDiamondCrossbow, this, 64, 4, true);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, CrossbowModCore.proxy);
//        NetworkRegistry.INSTANCE.registerChannel(new ServerPacketHandler(), CrossbowModCore.MOD_ID, Side.SERVER);

//        GameRegistry.registerCraftingHandler(new CraftingHandler());

        Util.addRecipes();

        CrossbowModCore.createBench = new Achievement("achievement.createBench", "CreateBench", 0, 0, CrossbowBlocks.crossbowBench, (Achievement) null).registerStat();
        CrossbowModCore.createCrossbow = new Achievement("achievement.createCrossbow", "CreateCrossbow", 0, 2, CrossbowItems.woodenCrossbowBase, CrossbowModCore.createBench).registerStat();
        CrossbowModCore.sniper = new Achievement("achievement.sniper", "Sniper", 2, 3, ItemCrossbow.setAttachmentAndMaterial(new ItemStack(CrossbowItems.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none), CrossbowModCore.createCrossbow).setSpecial().registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage("Crossbow Mod", CrossbowModCore.createBench, CrossbowModCore.createCrossbow, CrossbowModCore.sniper));

        CrossbowModCore.proxy.load(event);

        CrossbowModCore.proxy.registerRenderInformation();
    }

//    public class CraftingHandler implements ICraftingHandler
//    {
//        @Override
//        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
//        {
//            if (item.getItem().itemID == CrossbowBlocks.crossbowBench.blockID)
//            {
//                player.addStat(CrossbowModCore.createBench, 1);
//            }
//        }
//
//        @Override
//        public void onSmelting(EntityPlayer player, ItemStack item)
//        {
//        }
//    }
}
