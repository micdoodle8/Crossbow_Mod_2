package micdoodle8.mods.crossbowmod.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.crossbowmod.block.Blocks;
import micdoodle8.mods.crossbowmod.inventory.InventoryCrossbowBench;
import micdoodle8.mods.crossbowmod.item.CrossbowInfo;
import micdoodle8.mods.crossbowmod.item.EnumAttachmentType;
import micdoodle8.mods.crossbowmod.item.EnumCrossbowFireRate;
import micdoodle8.mods.crossbowmod.item.EnumCrossbowMaterial;
import micdoodle8.mods.crossbowmod.item.ItemCrossbow;
import micdoodle8.mods.crossbowmod.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class Util
{
    public static Packet250CustomPayload createPacket(String channel, int packetID, Object[] input)
    {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bytes);
        try
        {
            data.write(packetID);

            if (input != null)
            {
                for (Object obj : input)
                {
                    Util.writeObjectToStream(obj, data);
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = channel;
        packet.data = bytes.toByteArray();
        packet.length = packet.data.length;

        return packet;
    }

    public static Object[] readPacketData(DataInputStream data, Class<?>[] packetDataTypes)
    {
        List<Object> result = new ArrayList<Object>();

        try
        {
            for (Class<?> curClass : packetDataTypes)
            {
                result.add(Util.readObjectFromStream(data, curClass));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result.toArray();
    }

    private static void writeObjectToStream(Object obj, DataOutputStream data) throws IOException
    {
        Class<? extends Object> objClass = obj.getClass();

        if (objClass.equals(Boolean.class))
        {
            data.writeBoolean((Boolean) obj);
        }
        else if (objClass.equals(Byte.class))
        {
            data.writeByte((Byte) obj);
        }
        else if (objClass.equals(Integer.class))
        {
            data.writeInt((Integer) obj);
        }
        else if (objClass.equals(String.class))
        {
            data.writeUTF((String) obj);
        }
        else if (objClass.equals(Double.class))
        {
            data.writeDouble((Double) obj);
        }
        else if (objClass.equals(Float.class))
        {
            data.writeFloat((Float) obj);
        }
        else if (objClass.equals(Long.class))
        {
            data.writeLong((Long) obj);
        }
        else if (objClass.equals(Short.class))
        {
            data.writeShort((Short) obj);
        }
    }

    private static Object readObjectFromStream(DataInputStream data, Class<?> curClass) throws IOException
    {
        if (curClass.equals(Boolean.class))
        {
            return data.readBoolean();
        }
        else if (curClass.equals(Byte.class))
        {
            return data.readByte();
        }
        else if (curClass.equals(Integer.class))
        {
            return data.readInt();
        }
        else if (curClass.equals(String.class))
        {
            return data.readUTF();
        }
        else if (curClass.equals(Double.class))
        {
            return data.readDouble();
        }
        else if (curClass.equals(Float.class))
        {
            return data.readFloat();
        }
        else if (curClass.equals(Long.class))
        {
            return data.readLong();
        }
        else if (curClass.equals(Short.class))
        {
            return data.readShort();
        }

        return null;
    }

    public static int readPacketID(DataInputStream data)
    {
        int result = -1;

        try
        {
            result = data.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public static void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 5), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.planks });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 6), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.cobblestone });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 6), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.stone });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 7), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 8), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotGold });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 9), new Object[] { "XY", "XY", "XY", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.diamond });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 10), new Object[] { "XXX", "XYZ", "XZY", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 11), new Object[] { "AXX", "XBZ", "XZY", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk, Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 10) });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 12), new Object[] { "XXX", "XBZ", "XZY", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 11) });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 13), new Object[] { "XAA", "ABZ", "AZY", Character.valueOf('X'), Item.diamond, Character.valueOf('A'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 12) });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 14), new Object[] { "ZX ", "XAX", " XZ", Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), Block.torchRedstoneActive, Character.valueOf('Z'), Block.thinGlass });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 15), new Object[] { "ZX ", "XAB", " XZ", Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Items.attachmentLimbBolt, 1, 14), Character.valueOf('Z'), Block.thinGlass, Character.valueOf('B'), Block.stoneButton });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 0), new Object[] { "X", "#", Character.valueOf('X'), Block.planks, Character.valueOf('#'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 1), new Object[] { "X", "#", Character.valueOf('X'), Block.cobblestone, Character.valueOf('#'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 2), new Object[] { "X", "#", Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 3), new Object[] { "X", "#", Character.valueOf('X'), Item.ingotGold, Character.valueOf('#'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 4), new Object[] { "X", "#", Character.valueOf('X'), Item.diamond, Character.valueOf('#'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Blocks.crossbowBench, 1), new Object[] { "YYY", "ZXZ", "ZZZ", Character.valueOf('X'), Block.workbench, Character.valueOf('Y'), Item.ingotIron, Character.valueOf('Z'), Block.planks });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 16), new Object[] { "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 18), new Object[] { "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Item.bucketLava, Character.valueOf('Z'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 17), new Object[] { "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Block.tnt, Character.valueOf('Z'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 19), new Object[] { "XZZ", "ZXZ", "ZZX", Character.valueOf('X'), Block.blockSnow, Character.valueOf('Z'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 20), new Object[] { "GZZ", "ZRZ", "ZZG", Character.valueOf('G'), Item.glowstone, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('R'), Item.redstone });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 21), new Object[] { "SZZ", "ZCZ", "ZZF", Character.valueOf('S'), Item.stick, Character.valueOf('C'), Item.coal, Character.valueOf('F'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 22), new Object[] { "NZZ", "ZSZ", "ZZN", Character.valueOf('N'), Item.netherStalkSeeds, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('S'), Item.spiderEye });
        GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 23), new Object[] { "XXZ", "XZX", "ZXC", Character.valueOf('C'), Item.redstone, Character.valueOf('Z'), new ItemStack(Items.attachmentLimbBolt, 1, 10), Character.valueOf('X'), Item.ingotIron });
        
        for (EnumAttachmentType attachment : EnumAttachmentType.values())
        {
            for (EnumCrossbowFireRate fireRate : EnumCrossbowFireRate.values())
            {
                Util.addCrossbowBenchRecipe(new ItemStack(Items.woodenCrossbowBase), attachment, EnumCrossbowMaterial.wooden, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(Items.stoneCrossbowBase), attachment, EnumCrossbowMaterial.stone, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(Items.ironCrossbowBase), attachment, EnumCrossbowMaterial.iron, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(Items.goldCrossbowBase), attachment, EnumCrossbowMaterial.gold, fireRate);
                Util.addCrossbowBenchRecipe(new ItemStack(Items.diamondCrossbowBase), attachment, EnumCrossbowMaterial.diamond, fireRate);
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
     * @param Itemstack
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
