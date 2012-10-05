package micdoodle8.mods.crossbowmod;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderWoodBolt extends Render
{
    public RenderWoodBolt()
    {
    }

    public void renderArrow(EntityWoodBolt entitywoodbolt, double d, double d1, double d2, float f, float f1)
    {
        if (entitywoodbolt.prevRotationYaw == 0.0F && entitywoodbolt.prevRotationPitch == 0.0F)
        {
            return;
        }

        loadTexture("/Mic'sMods/CrossbowMod/items/woodenbolt.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(entitywoodbolt.prevRotationYaw + (entitywoodbolt.rotationYaw - entitywoodbolt.prevRotationYaw) * f1 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entitywoodbolt.prevRotationPitch + (entitywoodbolt.rotationPitch - entitywoodbolt.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
        Tessellator var10 = Tessellator.instance;
        byte var11 = 0;
        float var12 = 0.0F;
        float var13 = 0.5F;
        float var14 = (float)(0 + var11 * 10) / 32.0F;
        float var15 = (float)(5 + var11 * 10) / 32.0F;
        float var16 = 0.0F;
        float var17 = 0.15625F;
        float var18 = (float)(5 + var11 * 10) / 32.0F;
        float var19 = (float)(10 + var11 * 10) / 32.0F;
        float var20 = 0.05625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float var21 = (float)entitywoodbolt.arrowShake - f1;

        if (var21 > 0.0F)
        {
            float var22 = -MathHelper.sin(var21 * 3.0F) * var21;
            GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
        }

        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(var20, var20, var20);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
        var10.draw();
        GL11.glNormal3f(-var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
        var10.draw();

        for (int var23 = 0; var23 < 4; ++var23)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, var20);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
            var10.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
            var10.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
            var10.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
            var10.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    @Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderArrow((EntityWoodBolt)entity, d, d1, d2, f, f1);
    }
}
