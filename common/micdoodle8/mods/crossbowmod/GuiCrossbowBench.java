package micdoodle8.mods.crossbowmod;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiCrossbowBench extends GuiContainer
{
    private static final ResourceLocation crossbowTableTexture = new ResourceLocation(CrossbowModCore.TEXTURE_DOMAIN, "textures/gui/crossbowTable.png");
    
    public GuiCrossbowBench(InventoryPlayer par1InventoryPlayer)
    {
        super(new ContainerCrossbowBench(par1InventoryPlayer));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Crossbow Workbench", 10, -13, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, 202 - 113 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.func_110577_a(crossbowTableTexture);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - 202) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, 202);
    }
}
