package micdoodle8.mods.crossbowmod.client.render.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.crossbowmod.item.*;
import micdoodle8.mods.crossbowmod.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class ItemRendererCrossbowMod implements IItemRenderer
{
    private Minecraft mcinstance = FMLClientHandler.instance().getClient();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        switch (type)
        {
        case ENTITY:
            return false;
        case EQUIPPED:
            return true;
        case EQUIPPED_FIRST_PERSON:
            return true;
        case INVENTORY:
            return false;
        case FIRST_PERSON_MAP:
            return false;
        }
        return false;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        if (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            if (!(item.getItem() instanceof ItemCrossbow))
            {
                return;
            }

            ItemCrossbow crossbow = (ItemCrossbow) item.getItem();

            EntityPlayer par1EntityLiving = (EntityPlayer) data[1];
            float i = (float) crossbow.reloadingTime + (crossbow.reloadingTime - crossbow.prevReloadingTime);
            float i2 = 0f;

            if (par1EntityLiving.inventory.getCurrentItem() == null || !(par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemCrossbow))
            {
                return;
            }
            
            GL11.glPushMatrix();

            if (par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemWoodCrossbow)
            {
                i2 = (float) Math.sin((double) i / 20);
            }
            else if (par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemStoneCrossbow)
            {
                i2 = (float) Math.sin((double) i / 30);
            }
            else if (par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemIronCrossbow)
            {
                i2 = (float) Math.sin((double) i / 40);
            }
            else if (par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemGoldCrossbow)
            {
                i2 = (float) Math.sin((double) i / 50);
            }
            else if (par1EntityLiving.inventory.getCurrentItem().getItem() instanceof ItemDiamondCrossbow)
            {
                i2 = (float) Math.sin((double) i / 60);
            }

            if (i2 < 0)
            {
                i2 = 0f;
            }

            if (!(this.mcinstance.currentScreen != null && this.mcinstance.currentScreen.allowUserInput) && (Mouse.getEventDWheel() != 0 || Keyboard.isKeyDown(Keyboard.KEY_0) || Keyboard.isKeyDown(Keyboard.KEY_1) || Keyboard.isKeyDown(Keyboard.KEY_2) || Keyboard.isKeyDown(Keyboard.KEY_3) || Keyboard.isKeyDown(Keyboard.KEY_4) || Keyboard.isKeyDown(Keyboard.KEY_5) || Keyboard.isKeyDown(Keyboard.KEY_6) || Keyboard.isKeyDown(Keyboard.KEY_7) || Keyboard.isKeyDown(Keyboard.KEY_8) || Keyboard.isKeyDown(Keyboard.KEY_9)))
            {
                i2 = 0;
            }

            if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
            {
                GL11.glTranslatef(0.0F, -(Math.abs(i2) / 2), 0.0F);

                if (par1EntityLiving.getItemInUseCount() > 0)
                {
                    GL11.glRotatef(-335F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.5F, 0.0F);
                    GL11.glTranslatef(0.0F, -0.5F, 0.0F);
                    GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
                }

                if (Util.isDiamond(item) || Util.isGold(item) || Util.isIron(item) || Util.isStone(item) || Util.isWooden(item))
                {
                    GL11.glRotatef(80F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-62F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-39F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(-1.5F, -1.4F, -0.7F);
                }
            }
            else
            {
                GL11.glTranslatef(0.7F, 0.225F, 0.6125F);
                GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-110.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.1F, -0.9F, 0.15F);
                GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(1.3F, 1.3F, 1.3F);
            }

            
            this.renderItemCustom(type, item, data);
            GL11.glPopMatrix();
            GL11.glPushMatrix();

            float f28 = item.getMaxItemUseDuration() - ((float) par1EntityLiving.getItemInUseCount() - 1 + 1.0F);
            float f32 = f28 / 50F;
            f32 = (f32 * f32 + f32 * 2.0F) / 3F;

            if (f32 > 1.0F)
            {
                f32 = 1.0F;
            }

            if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
            {
                GL11.glRotatef(-330F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(1F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.5F, 0.15F);
                GL11.glTranslatef(0.0F, 0.05F, -0.25F);//
                GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(331F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(2F, 1.0F, 0.0F, 1.0F);
                GL11.glScalef(0.7F, 0.7F, 0.7F);

                if (Util.isDiamond(item) || Util.isGold(item) || Util.isIron(item) || Util.isStone(item) || Util.isWooden(item))
                {
                    GL11.glRotatef(83F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-62F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-45F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(-1.5F, -1.22F, -0.7F);
                }
            }
            else
            {
                GL11.glTranslatef(0.7F, 0.225F, 0.6125F);
                GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-110.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.05F, -0.7F, 0.15F);
                GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(1.3F, 1.3F, 1.3F);
            }

            if (crossbow.reloadingTime <= 0 && (par1EntityLiving.inventory.hasItemStack(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, crossbow.requiredMetadata(par1EntityLiving))) || par1EntityLiving.capabilities.isCreativeMode))
            {
                if (crossbow.requiredMetadata(par1EntityLiving) == 4)
                {
                    this.renderItemCustom(type, new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 4), data);
                }
                else if (crossbow.requiredMetadata(par1EntityLiving) == 3)
                {
                    this.renderItemCustom(type, new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 3), data);
                }
                else if (crossbow.requiredMetadata(par1EntityLiving) == 2)
                {
                    this.renderItemCustom(type, new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 2), data);
                }
                else if (crossbow.requiredMetadata(par1EntityLiving) == 1)
                {
                    this.renderItemCustom(type, new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 1), data);
                }
                else if (crossbow.requiredMetadata(par1EntityLiving) == 0)
                {
                    this.renderItemCustom(type, new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 0), data);
                }
            }

            GL11.glPopMatrix();
        }
    }

    private void renderItemCustom(ItemRenderType type, ItemStack item, Object... data)
    {
        int par3 = 0;
        EntityLivingBase par1EntityLiving = (EntityLivingBase) data[1];
        GL11.glPushMatrix();

        Tessellator var4 = Tessellator.instance;
        IIcon icon = par1EntityLiving.getItemIcon(item, par3);

        float f = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
        float var10 = 0.0F;
        float var11 = 0.3F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(-var10, -var11, 0.0F);
        float var12 = 1.5F;
        GL11.glScalef(var12, var12, var12);
        GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
        ItemRenderer.renderItemIn2D(var4, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);

        GL11.glPopMatrix();
    }
}