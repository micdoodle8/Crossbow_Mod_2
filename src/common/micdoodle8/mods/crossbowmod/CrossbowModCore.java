package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.World;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "CrossbowMod2", name = "Crossbow Mod 2 1.3.2", version = "v1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, connectionHandler = ConnectionHandler.class)
public class CrossbowModCore 
{
	@SidedProxy(clientSide = "micdoodle8.mods.crossbowmod.ClientProxy", serverSide = "micdoodle8.mods.crossbowmod.CommonProxy")
	public static CommonProxy proxy;
	@Instance
	public static CrossbowModCore instance;
	
	public static long firstBootTime = System.currentTimeMillis();
	
	private static long hasBooted;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManager(event);
		
		proxy.preInit(event);
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.load(event);
		
		new Items();
		
		EntityRegistry.registerModEntity(EntityWoodBolt.class, "CB_WoodBolt", ConfigManager.idEntityWoodCrossbow, this, 64, 4, true);
		EntityRegistry.registerModEntity(EntityStoneBolt.class, "CB_StoneBolt", ConfigManager.idEntityStoneCrossbow, this, 64, 4, true);
		EntityRegistry.registerModEntity(EntityIronBolt.class, "CB_IronBolt", ConfigManager.idEntityIronCrossbow, this, 64, 4, true);
		EntityRegistry.registerModEntity(EntityGoldBolt.class, "CB_GoldBolt", ConfigManager.idEntityGoldCrossbow, this, 64, 4, true);
		EntityRegistry.registerModEntity(EntityDiamondBolt.class, "CB_DiamondBolt", ConfigManager.idEntityDiamondCrossbow, this, 64, 4, true);
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		GameRegistry.registerBlock(Items.crossbowBench);
		
		Items.addNames();
		
		Util.addRecipes();
		
		proxy.registerRenderInformation();
	}
	
	public class GuiHandler implements IGuiHandler
	{
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
		{
			if (!world.blockExists(x, y, z))
			{
				return null;
			}
			
			int blockID = world.getBlockId(x, y, z);

			if (ID == ConfigManager.GUIID_BlockCrossbowBench)
			{
				if (!(blockID == Items.crossbowBench.blockID))
				{
					return null;
				}
				else
				{
					FMLLog.info("server");
					return new ContainerCrossbowBench(player.inventory);
				}
			}
			else
			{
				return null;
			}
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
		{
			if (!world.blockExists(x, y, z))
			{
				return null;
			}
			
			int blockID = world.getBlockId(x, y, z);

			if (ID == ConfigManager.GUIID_BlockCrossbowBench)
			{
				if (!(blockID == Items.crossbowBench.blockID))
				{
					return null;
				}
				else
				{
					FMLLog.info("client");
					return new GuiCrossbowBench(player.inventory);
				}
			}
			else
			{
				return null;
			}
		}
	}
	
	public class ServerPacketHandler implements IPacketHandler
	{
		@Override
		public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player) 
		{
			CrossbowModServer.onPacketData(manager, packet, player);
		}
	}
}
