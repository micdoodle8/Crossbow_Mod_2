package micdoodle8.mods.crossbowmod.util;

import micdoodle8.mods.crossbowmod.block.CrossbowBlocks;
import micdoodle8.mods.crossbowmod.inventory.InventoryCrossbowBench;
import micdoodle8.mods.crossbowmod.item.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class Util
{
    public static void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 5), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Blocks.planks);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 6), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Blocks.cobblestone);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 6), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Blocks.stone);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 7), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 8), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Items.gold_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 3, 9), "XY", "XY", "XY", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Items.diamond);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 10), "XXX", "XYZ", "XZY", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('Y'), Items.stick, Character.valueOf('Z'), Items.string);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 11), "AXX", "XBZ", "XZY", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('Y'), Items.stick, Character.valueOf('Z'), Items.string, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 10));
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 12), "XXX", "XBZ", "XZY", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('Y'), Items.stick, Character.valueOf('Z'), Items.redstone, Character.valueOf('B'), new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 11));
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 13), "XAA", "ABZ", "AZY", Character.valueOf('X'), Items.diamond, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('Y'), Items.stick, Character.valueOf('Z'), Items.redstone, Character.valueOf('B'), new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 12));
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 14), "ZX ", "XAX", " XZ", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('A'), Blocks.redstone_torch, Character.valueOf('Z'), Blocks.glass_pane);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 15), "ZX ", "XAB", " XZ", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('A'), new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 14), Character.valueOf('Z'), Blocks.glass_pane, Character.valueOf('B'), Blocks.stone_button);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 8, 0), "X", "#", Character.valueOf('X'), Blocks.planks, Character.valueOf('#'), Items.stick);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 8, 1), "X", "#", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('#'), Items.stick);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 8, 2), "X", "#", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('#'), Items.stick);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 8, 3), "X", "#", Character.valueOf('X'), Items.gold_ingot, Character.valueOf('#'), Items.stick);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 8, 4), "X", "#", Character.valueOf('X'), Items.diamond, Character.valueOf('#'), Items.stick);
        GameRegistry.addRecipe(new ItemStack(CrossbowBlocks.crossbowBench, 1), "YYY", "ZXZ", "ZZZ", Character.valueOf('X'), Blocks.crafting_table, Character.valueOf('Y'), Items.iron_ingot, Character.valueOf('Z'), Blocks.planks);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 16), "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Items.flint_and_steel, Character.valueOf('Z'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 18), "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Items.lava_bucket, Character.valueOf('Z'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 17), "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Blocks.tnt, Character.valueOf('Z'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 19), "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Blocks.snow, Character.valueOf('Z'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 20), "GZZ", "ZRZ", "ZZG", Character.valueOf('G'), Items.glowstone_dust, Character.valueOf('Z'), Items.iron_ingot, Character.valueOf('R'), Items.redstone);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 21), "SZZ", "ZCZ", "ZZF", Character.valueOf('S'), Items.stick, Character.valueOf('C'), Items.coal, Character.valueOf('F'), Items.flint_and_steel, Character.valueOf('Z'), Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 22), "NZZ", "ZSZ", "ZZN", Character.valueOf('N'), Items.nether_wart, Character.valueOf('Z'), Items.iron_ingot, Character.valueOf('S'), Items.spider_eye);
        GameRegistry.addRecipe(new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 23), "XXZ", "XZX", "ZXC", Character.valueOf('C'), Items.redstone, Character.valueOf('Z'), new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 10), Character.valueOf('X'), Items.iron_ingot);
        
        for (EnumAttachmentType attachment : EnumAttachmentType.values())
        {
            for (EnumCrossbowFireRate fireRate : EnumCrossbowFireRate.values())
            {
                Util.addCrossbowBenchRecipe(new ItemStack(CrossbowItems.woodenCrossbowBase), attachment, EnumCrossbowMaterial.wooden, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(CrossbowItems.stoneCrossbowBase), attachment, EnumCrossbowMaterial.stone, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(CrossbowItems.ironCrossbowBase), attachment, EnumCrossbowMaterial.iron, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(CrossbowItems.goldCrossbowBase), attachment, EnumCrossbowMaterial.gold, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(CrossbowItems.diamondCrossbowBase), attachment, EnumCrossbowMaterial.diamond, fireRate);
            }
        }
        
        FMLLog.info("[CROSSBOW MOD 2] Added " + CrossbowRecipes.getRecipeMap().size() + " recipes to the Crossbow Bench");
    }
    
    public static void addCrossbowBenchRecipe(ItemStack baseCrossbow, EnumAttachmentType attachment, EnumCrossbowMaterial material, EnumCrossbowFireRate fireRate)
    {
        CrossbowRecipes.addCrossbowRecipe(new CrossbowInfo(attachment, material, fireRate), ItemCrossbow.setAttachmentAndMaterial(baseCrossbow, attachment, material, fireRate));
    }

    public static ItemStack findMatchingCrossbowRecipe(InventoryCrossbowBench inv)
    {
        ItemStack[] sticks = new ItemStack[] { inv.getStackInSlot(3), inv.getStackInSlot(4), inv.getStackInSlot(5) };
        ItemStack[] limbs = new ItemStack[] { inv.getStackInSlot(2), inv.getStackInSlot(6), inv.getStackInSlot(7), inv.getStackInSlot(8), inv.getStackInSlot(9) };
        ItemStack mechanism = inv.getStackInSlot(1);
        ItemStack attachment = inv.getStackInSlot(10);
        
        return CrossbowRecipes.findMatchingRecipe(sticks, limbs, mechanism, attachment);
    }

    public static boolean isWooden(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("material") == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack is any stone crossbow
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack is any stone crossbow
     */
    public static boolean isStone(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("material") == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack is any iron crossbow
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack is any iron crossbow
     */
    public static boolean isIron(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("material") == 2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack is any gold crossbow
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack is any gold crossbow
     */
    public static boolean isGold(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("material") == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack is any diamond crossbow
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack is any diamond crossbow
     */
    public static boolean isDiamond(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("material") == 4)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a basic scope
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a basic scope
     */
    public static boolean hasBasicScope(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a long range scope
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a long range scope
     */
    public static boolean hasLongRangeScope(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a light mechanism attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a light mechanism attachment
     */
    public static boolean hasLightMech(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("firerate") == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a medium mechanism attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a medium mechanism attachment
     */
    public static boolean hasMediumMech(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("firerate") == 2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a heavy mechanism attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a heavy mechanism attachment
     */
    public static boolean hasHeavyMech(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("firerate") == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a tri shot mechanism attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a tri shot mechanism
     *         attachment
     */
    public static boolean hasTriShotMech(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("firerate") == 4)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a Flame attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a Flame attachment
     */
    public static boolean hasFlameAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 9)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has an explosive attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has an explosive attachment
     */
    public static boolean hasExplosiveAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 8)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has a lava attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a lava attachment
     */
    public static boolean hasLavaAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has an ice attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a lava attachment
     */
    public static boolean hasIceAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 4)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * If the provided Itemstack has an ice attachment
     * 
     * @param stack
     *            The item to check
     * @return True if the provided Itemstack has a lava attachment
     */
    public static boolean hasLightningAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 7)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public static boolean hasTorchAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 6)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public static boolean hasPoisonAttachment(ItemStack stack)
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagCompound comp = stack.getTagCompound();

            if (comp.getInteger("attachment") == 5)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
