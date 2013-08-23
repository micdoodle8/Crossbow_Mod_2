package micdoodle8.mods.crossbowmod.client;

import java.text.DecimalFormat;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import micdoodle8.mods.crossbowmod.client.render.RenderDiamondBolt;
import micdoodle8.mods.crossbowmod.client.render.RenderGoldBolt;
import micdoodle8.mods.crossbowmod.client.render.RenderIronBolt;
import micdoodle8.mods.crossbowmod.client.render.RenderStoneBolt;
import micdoodle8.mods.crossbowmod.client.render.RenderWoodBolt;
import micdoodle8.mods.crossbowmod.client.render.item.ItemRendererCrossbowMod;
import micdoodle8.mods.crossbowmod.entity.EntityDiamondBolt;
import micdoodle8.mods.crossbowmod.entity.EntityGoldBolt;
import micdoodle8.mods.crossbowmod.entity.EntityIronBolt;
import micdoodle8.mods.crossbowmod.entity.EntityStoneBolt;
import micdoodle8.mods.crossbowmod.entity.EntityWoodBolt;
import micdoodle8.mods.crossbowmod.item.ItemCrossbow;
import micdoodle8.mods.crossbowmod.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CrossbowModClient
{
    private static DecimalFormat oneDigit = new DecimalFormat("#,##0.0");

    public static int shootTime = 0;

    private static final ResourceLocation longScopeTexture = new ResourceLocation(CrossbowModCore.TEXTURE_DOMAIN, "textures/gui/longScope.png");
    private static final ResourceLocation shortScopeTexture = new ResourceLocation(CrossbowModCore.TEXTURE_DOMAIN, "textures/gui/shortScope.png");

    public static void preInit(FMLPreInitializationEvent event)
    {
    }

    public static void init(FMLInitializationEvent event)
    {
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.createBench.getName(), "First Step");
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.createBench.getName() + ".desc", "Create a Crossbow Bench");
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.createCrossbow.getName(), "Well-Prepared!");
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.createCrossbow.getName() + ".desc", "Create any crossbow on a Crossbow Crafting Bench");
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.sniper.getName(), "Sniper King");
        LanguageRegistry.instance().addStringLocalization(CrossbowModCore.sniper.getName() + ".desc", "Kill a chicken with any crossbow bolt from more than 75 meters away using a long range scope");
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
            mc.renderEngine.func_110577_a(CrossbowModClient.longScopeTexture);
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

            String var1 = String.valueOf(CrossbowModClient.getZoom() / 2 - 0.5);
            mc.fontRenderer.drawString("Zoom: " + var1, i / 2 - 5 - mc.fontRenderer.getStringWidth(var1), k / 6, 4210752);

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
                        CrossbowModClient.zoom(Double.parseDouble(CrossbowModClient.oneDigit.format(Mouse.getEventDWheel() / 60)));
                    }
                    catch (NumberFormatException e)
                    {
                        CrossbowModClient.zoom(0D);
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
            mc.renderEngine.func_110577_a(CrossbowModClient.shortScopeTexture);
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
            CrossbowModClient.zoom(-1D);

            try
            {
                ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39, 1);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void onTickInGUI(GuiScreen guiscreen)
    {

    }

    public static void onTickInGame()
    {
        if (CrossbowModClient.shootTime > 0)
        {
            CrossbowModClient.shootTime--;
        }
    }

    public static int remoteVer;
    public static int localVer = 59;

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
            ItemCrossbow crossbow = CrossbowModCore.crossbowsList.get(i);

            MinecraftForgeClient.registerItemRenderer(crossbow.itemID, itemRenderer);
        }

    }

    public static void zoom(double d)
    {
        if (CrossbowModClient.getZoom() < 10 && CrossbowModClient.getZoom() > 1)
        {
            try
            {
                ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39, CrossbowModClient.getZoom() + d);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (CrossbowModClient.getZoom() >= 10 && d < 0)
        {
            try
            {
                ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39, CrossbowModClient.getZoom() + d);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (CrossbowModClient.getZoom() <= 1 && d > 0)
        {
            try
            {
                ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39, CrossbowModClient.getZoom() + d);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (CrossbowModClient.getZoom() < 1)
        {
            ModLoader.setPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39, 1);
        }
    }

    public static double getZoom()
    {
        double zoom = 0;

        try
        {
            zoom = (Double) ModLoader.getPrivateValue(EntityRenderer.class, ModLoader.getMinecraftInstance().entityRenderer, 39);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return zoom;
    }

    // public static void onPacketData(NetworkManager manager,
    // Packet250CustomPayload packet, Player player)
    // {
    // Minecraft mcinstance = FMLClientHandler.instance().getClient();
    //
    // DataInputStream data = new DataInputStream(new
    // ByteArrayInputStream(packet.data));
    //
    // int packetID = Util.readPacketID(data);
    //
    // if (packetID == 0)
    // {
    //
    // }
    // }
}
