package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.text.DecimalFormat;
import java.util.EnumSet;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

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

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.Player;

public class CrossbowModClient 
{
	private Minecraft mcinstance = ModLoader.getMinecraftInstance();

    private static DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
	
	public static void preInit(FMLPreInitializationEvent event)
	{
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
		FMLClientHandler.instance().getClient().sndManager.soundPoolSounds.addSound("cbowfire.ogg", CrossbowModCore.instance.getClass().getResource("/Mic'sMods/CrossbowMod/sounds/cbowfire.ogg"));
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
	
	                          mc.gameSettings.noclipRate += (float)var3 * 0.25F;
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
		
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowBase.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithBasicScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLongScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithExplosiveAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithFlameAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLavaAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithIceAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLightningAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithTorchAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithPoisonAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex, itemRenderer);

		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowBase.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithBasicScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLongScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithExplosiveAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithFlameAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLavaAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithIceAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLightningAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithTorchAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithPoisonAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex, itemRenderer);

		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowBase.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithBasicScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLongScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithExplosiveAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithFlameAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLavaAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithIceAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLightningAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithTorchAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithPoisonAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex, itemRenderer);

		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowBase.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithBasicScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLongScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithExplosiveAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithFlameAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLavaAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithIceAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLightningAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithTorchAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithPoisonAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex, itemRenderer);

		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowBase.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithBasicScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLongScope.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithExplosiveAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithFlameAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLavaAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithIceAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLightningAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithTorchAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithPoisonAttachment.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex, itemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex, itemRenderer);
		
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
	
	public static void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        Minecraft mcinstance = FMLClientHandler.instance().getClient();
        
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        
        int packetID = Util.readPacketID(data);
        
        if (packetID == 0)
        {
        	
        }
    }
}
