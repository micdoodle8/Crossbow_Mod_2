package micdoodle8.mods.crossbowmod;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		CrossbowModClient.preInit(event);
	}
	
	@Override
	public void load(FMLInitializationEvent event)
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		TickRegistry.registerScheduledTickHandler(new ClientScheduledTickHandler(), Side.CLIENT);
		CrossbowModClient.init(event);
    	FMLClientHandler.instance().getClient().sndManager.soundPoolSounds.addSound("cbowfire.ogg", CrossbowModCore.instance.getClass().getResource("/Mic'sMods/CrossbowMod/sounds/cbowfire.ogg")); 
	}

	@Override
	public void registerRenderInformation()
	{
		CrossbowModClient.registerRenderInformation();
	}
	
	public class ClientTickHandler implements ITickHandler
	{
	    @Override
	    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	    @Override
	    public void tickEnd(EnumSet<TickType> type, Object... tickData)
	    {
	        if (type.equals(EnumSet.of(TickType.RENDER)))
	        {
	            onRenderTick();
	        }
	        else if (type.equals(EnumSet.of(TickType.CLIENT)))
	        {
	            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
	            
	            if (guiscreen != null)
	            {
	                onTickInGUI(guiscreen);
	            } 
	            else 
	            {
	                onTickInGame();
	            }
	        }
	    }

	    @Override
	    public EnumSet<TickType> ticks()
	    {
	        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	    }

	    @Override
	    public String getLabel() { return "Crossbow Mod 2 Render/Gui"; }


	    public void onRenderTick()
	    {
	    	CrossbowModClient.onRenderTick();
	    }

	    public void onTickInGUI(GuiScreen guiscreen)
	    {
	    	CrossbowModClient.onTickInGUI(guiscreen);
	    }

	    public void onTickInGame()
	    {
	    	CrossbowModClient.onTickInGame();
	    }
	}
	
	public class ClientScheduledTickHandler implements IScheduledTickHandler
	{
		@Override
		public void tickStart(EnumSet<TickType> type, Object... tickData) 
		{
			
		}

		@Override
		public void tickEnd(EnumSet<TickType> type, Object... tickData) { }

		@Override
		public EnumSet<TickType> ticks() 
		{
			return EnumSet.of(TickType.CLIENT);
		}

		@Override
		public String getLabel() 
		{
			return "Crossbow Mod 2 Scheduled";
		}

		@Override
		public int nextTickSpacing() 
		{
			return 4;
		}
	}
	
//	public class ClientPacketHandler implements IPacketHandler
//	{
//		@Override
//		public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player) 
//		{
//			CrossbowModClient.onPacketData(manager, packet, player);
//		}
//	}
}
