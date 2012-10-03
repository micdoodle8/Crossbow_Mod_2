package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.src.ModelPlayerAPI;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.RenderPlayerAPI;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.Player;

public class CrossbowModClient 
{
	private Minecraft mcinstance = ModLoader.getMinecraftInstance();

    private static DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
	
	public static void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
		
		try
		{
			RenderPlayerAPI.register("CrossbowMod2", RenderPlayerCrossbowMod.class);
			ModelPlayerAPI.register("CrossbowMod2", ModelPlayerCrossbowMod.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void init(FMLInitializationEvent event)
	{
	}
	
	public static void onRenderTick()
	{
		Minecraft mc = ModLoader.getMinecraftInstance();

		if (mc == null || mc.thePlayer == null || mc.thePlayer.getCurrentEquippedItem() == null)
		{
			return;
		}
		
		if (mc.thePlayer.isUsingItem() && Util.hasLongRangeScope(mc.thePlayer.getCurrentEquippedItem()) && mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping())
		{
			mc.gameSettings.hideGUI = true;
			mc.gameSettings.noclip = true;
			ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			int k = scaledresolution.getScaledHeight();
			mc.entityRenderer.setupOverlayRendering();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/Mic'sMods/CrossbowMod/gui/attachmentLongScope.png"));
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(i / 2 - 2 * k, k, -90D, 0.0D, 1.0D);
			tessellator.addVertexWithUV(i / 2 + 2 * k, k, -90D, 1.0D, 1.0D);
			tessellator.addVertexWithUV(i / 2 + 2 * k, 0.0D, -90D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(i / 2 - 2 * k, 0.0D, -90D, 0.0D, 0.0D);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			String var1 = String.valueOf((getZoom() / 2) - 0.5);
			mc.fontRenderer.drawString("Zoom: " + var1, i / 2 - 5 - (mc.fontRenderer.getStringWidth(var1)), k / 6, 4210752);

			float var3;

			while (Mouse.next())
			{
				KeyBinding.setKeyBindState(Mouse.getEventButton() - 100, Mouse.getEventButtonState());

				if (Mouse.getEventButtonState())
				{
					KeyBinding.onTick(Mouse.getEventButton() - 100);
				}

				if (Mouse.hasWheel() && !Double.isNaN(Mouse.getEventDWheel()))
				{
					try
					{
						zoom(Double.parseDouble(oneDigit.format(Mouse.getEventDWheel() / 60)));
					}
					catch (NumberFormatException e)
					{
						zoom(0D);
					}
				}

				if (System.currentTimeMillis() - CrossbowModCore.firstBootTime <= 10L)
				{
					var3 = Mouse.getEventDWheel();

					if (var3 != 0)
					{
						mc.thePlayer.inventory.changeCurrentItem((int) var3);

						if (mc.gameSettings.noclip)
						{
							if (var3 > 0)
							{
								var3 = -1;
							}

							if (var3 < 0)
							{
								var3 = 1;
							}

							mc.gameSettings.noclipRate += var3 * 0.25F;
						}
					}

					if (mc.currentScreen == null)
					{
						if (!mc.inGameHasFocus && Mouse.getEventButtonState())
						{
							mc.setIngameFocus();
						}
					}
					else if (mc.currentScreen != null)
					{
						mc.currentScreen.handleMouseInput();
					}
				}
			}
		}
		else if (mc.thePlayer.isUsingItem() && Util.hasBasicScope(mc.thePlayer.getCurrentEquippedItem()) && mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping())
		{
			mc.gameSettings.hideGUI = true;
	        ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	        int i = scaledresolution.getScaledWidth();
	        int k = scaledresolution.getScaledHeight();
	        mc.entityRenderer.setupOverlayRendering();
	        GL11.glEnable(GL11.GL_BLEND);
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/Mic'sMods/CrossbowMod/gui/attachmentShortScope.png"));
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(i / 2 - 2 * k, k, -90D, 0.0D, 1.0D);
			tessellator.addVertexWithUV(i / 2 + 2 * k, k, -90D, 1.0D, 1.0D);
			tessellator.addVertexWithUV(i / 2 + 2 * k, 0.0D, -90D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(i / 2 - 2 * k, 0.0D, -90D, 0.0D, 0.0D);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		else
		{
			try 
			{
		        ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34, 1);
			} 
			catch (Exception ex) 
			{
		        ex.printStackTrace();
			}
			mc.gameSettings.hideGUI = false;
			mc.gameSettings.noclip = false;
		}
	}
	
	public static void onTickInGUI(GuiScreen guiscreen)
    {

    }

    public static void onTickInGame()
    {
		
    }

	public static void registerRenderInformation()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodBolt.class, new RenderWoodBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneBolt.class, new RenderStoneBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityIronBolt.class, new RenderIronBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldBolt.class, new RenderGoldBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondBolt.class, new RenderDiamondBolt());
		
		IItemRenderer itemRenderer = new ItemRendererCrossbowMod();
		
		int i;
		
		for (i = 0; i < CrossbowModCore.crossbowsList.size(); i++)
		{
			ItemCrossbow crossbow = (ItemCrossbow) CrossbowModCore.crossbowsList.get(i);
			
			MinecraftForgeClient.registerItemRenderer(crossbow.shiftedIndex, itemRenderer);
		}
		
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/wood.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/stone.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/iron.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/gold.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/diamond.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/other.png");
		MinecraftForgeClient.preloadTexture("/Mic'sMods/CrossbowMod/gui/Crossbow.png");
		
	}
	
	public static void zoom(double d)
	{
		if (getZoom() < 10 && getZoom() > 1)
		{
			try 
			{
		        ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34, getZoom() + d);
			} 
			catch (Exception ex) 
			{
		        ex.printStackTrace();
			}
		}
		if (getZoom() >= 10 && d < 0)
		{
			try 
			{
		        ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34, getZoom() + d);
			} 
			catch (Exception ex) 
			{
		        ex.printStackTrace();
			}
		}
		if (getZoom() <= 1 && d > 0)
		{
			try 
			{
		        ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34, getZoom() + d);
			} 
			catch (Exception ex) 
			{
		        ex.printStackTrace();
			}
		}
		if (getZoom() < 1)
		{
	        ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34, 1);
		}
	}

	public static double getZoom()
	{  
		double zoom = 0;
		
		try 
		{
			zoom = (Double) ModLoader.getPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 34);
		} 
		catch (Exception ex) 
		{
	        ex.printStackTrace();
		}
		
		return zoom;
	}
	
//	public static void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player)
//    {
//        Minecraft mcinstance = FMLClientHandler.instance().getClient();
//        
//		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
//        
//        int packetID = Util.readPacketID(data);
//        
//        if (packetID == 0)
//        {
//        	
//        }
//    }
}
