package micdoodle8.mods.crossbowmod.util;

import micdoodle8.mods.crossbowmod.item.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map.Entry;

public class CrossbowRecipes
{
    private static HashMap<CrossbowInfo, ItemStack> recipeMap = new HashMap<CrossbowInfo, ItemStack>();
    
    public static void addCrossbowRecipe(CrossbowInfo input, ItemStack result)
    {
        CrossbowRecipes.recipeMap.put(input, result);
    }
    
    public static ItemStack findMatchingRecipe(ItemStack[] sticks, ItemStack[] limbs, ItemStack mechanism, ItemStack attachment)
    {
        if (sticks.length != 3 || limbs.length != 5)
        {
            return null;
        }
        
        CrossbowInfo info = new CrossbowInfo(null, null, null);
        
        for (ItemStack stick : sticks)
        {
            if (stick == null || stick.getItem() != Items.stick)
            {
                return null;
            }
        }
        
        int limbDamage = 0;
        
        for (ItemStack limb : limbs)
        {
            if (limb == null || limb.getItem() != CrossbowItems.attachmentLimbBolt)
            {
                return null;
            }
            else
            {
                if (limbDamage != 0 && limb.getItemDamage() != limbDamage)
                {
                    return null;
                }
                else
                {
                    limbDamage = limb.getItemDamage();
                }
            }
        }
        
        switch (limbDamage)
        {
        case 5:
            info.setMaterial(EnumCrossbowMaterial.wooden);
            break;
        case 6:
            info.setMaterial(EnumCrossbowMaterial.stone);
            break;
        case 7:
            info.setMaterial(EnumCrossbowMaterial.iron);
            break;
        case 8:
            info.setMaterial(EnumCrossbowMaterial.gold);
            break;
        case 9:
            info.setMaterial(EnumCrossbowMaterial.diamond);
            break;
        default:
            break;
        }

        if (mechanism == null || mechanism.getItem() != CrossbowItems.attachmentLimbBolt)
        {
            return null;
        }
        else
        {
            switch (mechanism.getItemDamage())
            {
            case 10:
                info.setFireRate(EnumCrossbowFireRate.none);
                break;
            case 11:
                info.setFireRate(EnumCrossbowFireRate.light);
                break;
            case 12:
                info.setFireRate(EnumCrossbowFireRate.medium);
                break;
            case 13:
                info.setFireRate(EnumCrossbowFireRate.heavy);
                break;
            case 23:
                info.setFireRate(EnumCrossbowFireRate.tri);
                break;
            default:
                info.setFireRate(EnumCrossbowFireRate.none);
                break;
            }
        }
        
        if (attachment == null || attachment.getItem() != CrossbowItems.attachmentLimbBolt)
        {
            info.setAttachment(EnumAttachmentType.none);
        }
        else
        {
            switch (attachment.getItemDamage())
            {
            case 14:
                info.setAttachment(EnumAttachmentType.shortscope);
                break;
            case 15:
                info.setAttachment(EnumAttachmentType.longscope);
                break;
            case 16:
                info.setAttachment(EnumAttachmentType.flame);
                break;
            case 17:
                info.setAttachment(EnumAttachmentType.explosive);
                break;
            case 18:
                info.setAttachment(EnumAttachmentType.lava);
                break;
            case 19:
                info.setAttachment(EnumAttachmentType.ice);
                break;
            case 20:
                info.setAttachment(EnumAttachmentType.lightning);
                break;
            case 21:
                info.setAttachment(EnumAttachmentType.torch);
                break;
            case 22:
                info.setAttachment(EnumAttachmentType.poison);
                break;
            default:
                info.setAttachment(EnumAttachmentType.none);
                break;
            }
        }
        
        for (Entry<CrossbowInfo, ItemStack> entry : recipeMap.entrySet())
        {
            if (info.getAttachment().equals(entry.getKey().getAttachment()) && info.getMaterial().equals(entry.getKey().getMaterial()) && info.getFireRate().equals(entry.getKey().getFireRate()))
            {
                ItemStack crossbow = new ItemStack(entry.getValue().getItem(), 1, entry.getValue().getItemDamage());

                if (crossbow.stackTagCompound == null)
                {
                    crossbow.setTagCompound(new NBTTagCompound());
                }

                if (info.getAttachment() != null && info.getMaterial() != null && info.getFireRate() != null)
                {
                    crossbow.getTagCompound().setInteger("attachment", info.getAttachment().getIndex());
                    crossbow.getTagCompound().setInteger("material", info.getMaterial().getIndex());
                    crossbow.getTagCompound().setInteger("firerate", info.getFireRate().getIndex());
                }
                
                return crossbow;
            }
        }

        return null;
    }

    public static HashMap<CrossbowInfo, ItemStack> getRecipeMap()
    {
        return CrossbowRecipes.recipeMap;
    }

    public static void setRecipeMap(HashMap<CrossbowInfo, ItemStack> recipeMap)
    {
        CrossbowRecipes.recipeMap = recipeMap;
    }
}
