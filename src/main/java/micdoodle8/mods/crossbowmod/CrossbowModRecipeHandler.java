package micdoodle8.mods.crossbowmod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import codechicken.core.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class CrossbowModRecipeHandler extends TemplateRecipeHandler
{
    private static final ResourceLocation circuitFabricatorTexture = new ResourceLocation(CrossbowModCore.TEXTURE_DOMAIN, "textures/gui/crossbowTable.png");

    public String getRecipeId()
    {
        return "galacticraft.circuits";
    }

    @Override
    public int recipiesPerPage()
    {
        return 1;
    }

    public Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRecipes()
    {
        HashMap<ArrayList<PositionedStack>, PositionedStack> recipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

        for (Entry<HashMap<Integer, PositionedStack>, PositionedStack> stack : NEICrossbowModConfig.getCrossbowModRecipes())
        {
            ArrayList<PositionedStack> inputStacks = new ArrayList<PositionedStack>();

            for (Map.Entry<Integer, PositionedStack> input : stack.getKey().entrySet())
            {
                inputStacks.add(input.getValue());
            }

            recipes.put(inputStacks, stack.getValue());
        }

        return recipes.entrySet();
    }

    @Override
    public void drawBackground(int i)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GuiDraw.changeTexture(CrossbowModRecipeHandler.circuitFabricatorTexture);
        GuiDraw.drawTexturedModalRect(-2, 9, 3, 4, 168, 110);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public void loadTransferRects()
    {
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if (outputId.equals(this.getRecipeId()))
        {
            for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
            {
                this.arecipes.add(new CachedCircuitRecipe(irecipe));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
        {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getValue().item, result))
            {
                if (irecipe.getValue().item.getTagCompound() != null && result.getTagCompound() != null)
                {
                    NBTTagCompound nbt1 = irecipe.getValue().item.getTagCompound();
                    NBTTagCompound nbt2 = result.getTagCompound();
                    
                    if (nbt1.getInteger("attachment") == nbt2.getInteger("attachment") && nbt1.getInteger("material") == nbt2.getInteger("material") && nbt1.getInteger("firerate") == nbt2.getInteger("firerate"))
                    {
                        this.arecipes.add(new CachedCircuitRecipe(irecipe));
                    }
                }
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
        {
            for (final PositionedStack pstack : irecipe.getKey())
            {
                if (NEIServerUtils.areStacksSameTypeCrafting(ingredient, pstack.item))
                {
                    if (irecipe.getValue().item.getTagCompound() != null && pstack.item.getTagCompound() != null)
                    {
                        NBTTagCompound nbt1 = irecipe.getValue().item.getTagCompound();
                        NBTTagCompound nbt2 = pstack.item.getTagCompound();

                        if (nbt1.getInteger("attachment") == nbt2.getInteger("attachment") && nbt1.getInteger("material") == nbt2.getInteger("material") && nbt1.getInteger("firerate") == nbt2.getInteger("firerate"))
                        {
                            this.arecipes.add(new CachedCircuitRecipe(irecipe));
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<PositionedStack> getIngredientStacks(int recipe)
    {
        return (ArrayList<PositionedStack>) this.arecipes.get(recipe).getIngredients();
    }

    @Override
    public PositionedStack getResultStack(int recipe)
    {
        return this.arecipes.get(recipe).getResult();
    }

    public class CachedCircuitRecipe extends TemplateRecipeHandler.CachedRecipe
    {
        public ArrayList<PositionedStack> input;
        public PositionedStack output;

        @Override
        public ArrayList<PositionedStack> getIngredients()
        {
            return this.input;
        }

        @Override
        public PositionedStack getResult()
        {
            return this.output;
        }

        public CachedCircuitRecipe(ArrayList<PositionedStack> pstack1, PositionedStack pstack2)
        {
            this.input = pstack1;
            this.output = pstack2;
        }

        public CachedCircuitRecipe(Map.Entry<ArrayList<PositionedStack>, PositionedStack> recipe)
        {
            this(recipe.getKey(), recipe.getValue());
        }
    }

    @Override
    public String getRecipeName()
    {
        return "Circuit Fabricator";
    }

    @Override
    public String getGuiTexture()
    {
        return "/mods/galacticraftcore/textures/gui/circuitFabricator.png";
    }
}
