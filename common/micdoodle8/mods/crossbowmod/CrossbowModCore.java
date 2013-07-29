package micdoodle8.mods.crossbowmod;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.crossbowmod.entity.EntityDiamondBolt;
import micdoodle8.mods.crossbowmod.entity.EntityGoldBolt;
import micdoodle8.mods.crossbowmod.entity.EntityIronBolt;
import micdoodle8.mods.crossbowmod.entity.EntityStoneBolt;
import micdoodle8.mods.crossbowmod.entity.EntityWoodBolt;
import micdoodle8.mods.crossbowmod.item.EnumAttachmentType;
import micdoodle8.mods.crossbowmod.item.EnumCrossbowFireRate;
import micdoodle8.mods.crossbowmod.item.EnumCrossbowMaterial;
import micdoodle8.mods.crossbowmod.item.ItemCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemDiamondCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemGoldCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemIronCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemStoneCrossbow;
import micdoodle8.mods.crossbowmod.item.ItemWoodCrossbow;
import micdoodle8.mods.crossbowmod.item.Items;
import micdoodle8.mods.crossbowmod.util.Util;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "CrossbowMod2", name = "Crossbow Mod 2 1.6.2", version = "a0.1.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CrossbowModCore
{
    @SidedProxy(clientSide = "micdoodle8.mods.crossbowmod.client.ClientProxy", serverSide = "micdoodle8.mods.crossbowmod.CommonProxy")
    public static CommonProxy proxy;
    @Instance
    public static CrossbowModCore instance;
    
    public static final String MOD_ID = "CrossbowMod2";

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
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        new Items();

        EntityRegistry.registerModEntity(EntityWoodBolt.class, "CB_WoodBolt", ConfigManager.idEntityWoodCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityStoneBolt.class, "CB_StoneBolt", ConfigManager.idEntityStoneCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityIronBolt.class, "CB_IronBolt", ConfigManager.idEntityIronCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityGoldBolt.class, "CB_GoldBolt", ConfigManager.idEntityGoldCrossbow, this, 64, 4, true);
        EntityRegistry.registerModEntity(EntityDiamondBolt.class, "CB_DiamondBolt", ConfigManager.idEntityDiamondCrossbow, this, 64, 4, true);

        NetworkRegistry.instance().registerGuiHandler(this, CrossbowModCore.proxy);
        NetworkRegistry.instance().registerChannel(new ServerPacketHandler(), CrossbowModCore.MOD_ID, Side.SERVER);

        GameRegistry.registerCraftingHandler(new CraftingHandler());

        GameRegistry.registerBlock(Items.crossbowBench, ItemBlock.class, null, CrossbowModCore.MOD_ID);

        Util.addRecipes();

        CrossbowModCore.createBench = new Achievement(491, "CreateBench", 0, 0, Items.crossbowBench, (Achievement) null).registerAchievement();
        CrossbowModCore.createCrossbow = new Achievement(492, "CreateCrossbow", 0, 2, Items.woodenCrossbowBase, CrossbowModCore.createBench).registerAchievement();
        ItemStack stack = ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
        CrossbowModCore.sniper = new Achievement(493, "Sniper", 2, 3, stack, CrossbowModCore.createCrossbow).setSpecial().registerAchievement();

        AchievementPage.registerAchievementPage(new AchievementPage("Crossbow Mod", CrossbowModCore.createBench, CrossbowModCore.createCrossbow, CrossbowModCore.sniper));

        CrossbowModCore.proxy.load(event);

        CrossbowModCore.proxy.registerRenderInformation();
    }

    public class CraftingHandler implements ICraftingHandler
    {
        @Override
        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
        {
            if (item.getItem().itemID == Items.crossbowBench.blockID)
            {
                player.addStat(CrossbowModCore.createBench, 1);
            }
        }

        @Override
        public void onSmelting(EntityPlayer player, ItemStack item)
        {
        }
    }

    public class ServerPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
        {
            CrossbowModServer.onPacketData(manager, packet, player);
        }
    }
}
