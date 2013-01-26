package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.Explosion;
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
                    writeObjectToStream(obj, data);
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

    public static Object[] readPacketData(DataInputStream data, Class[] packetDataTypes)
    {
        List result = new ArrayList<Object>();

        try
        {
            for (Class curClass : packetDataTypes)
            {
                result.add(readObjectFromStream(data, curClass));
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
        Class objClass = obj.getClass();

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

    private static Object readObjectFromStream(DataInputStream data, Class curClass) throws IOException
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
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 5), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.planks
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 6), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.cobblestone
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 6), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.stone
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 7), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 8), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotGold
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 3, 9), new Object[] {
			"XY",
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.diamond
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 10), new Object[] {
			"XXX",
			"XYZ",
			"XZY",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 11), new Object[] {
			"AXX",
			"XBZ",
			"XZY",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk, Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 10)
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 12), new Object[] {
			"XXX",
			"XBZ",
			"XZY",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 11)
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 13), new Object[] {
			"XAA",
			"ABZ",
			"AZY",
			Character.valueOf('X'), Item.diamond, Character.valueOf('A'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), new ItemStack(Items.attachmentLimbBolt, 1, 12)
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 14), new Object[] {
			"ZX ",
			"XAX",
			" XZ",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), Block.torchRedstoneActive, Character.valueOf('Z'), Block.thinGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 15), new Object[] {
			"ZX ",
			"XAB",
			" XZ",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Items.attachmentLimbBolt, 1, 14), Character.valueOf('Z'), Block.thinGlass, Character.valueOf('B'), Block.stoneButton
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 0), new Object[] {
			"X",
			"#",
			Character.valueOf('X'), Block.planks, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 1), new Object[] {
			"X",
			"#",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 2), new Object[] {
			"X",
			"#",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 3), new Object[] {
			"X",
			"#",
			Character.valueOf('X'), Item.ingotGold, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 8, 4), new Object[] {
			"X",
			"#",
			Character.valueOf('X'), Item.diamond, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.crossbowBench, 1), new Object[] {
			"YYY",
			"ZXZ",
			"ZZZ",
			Character.valueOf('X'), Block.workbench, Character.valueOf('Y'), Item.ingotIron, Character.valueOf('Z'), Block.planks
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 16), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 18), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Item.bucketLava, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 17), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Block.tnt, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 19), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Block.blockSnow, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 20), new Object[] {
			"GZZ",
			"ZRZ",
			"ZZG",
			Character.valueOf('G'), Item.lightStoneDust, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('R'), Item.redstone
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 21), new Object[] {
			"SZZ",
			"ZCZ",
			"ZZF",
			Character.valueOf('S'), Item.stick, Character.valueOf('C'), Item.coal, Character.valueOf('F'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 22), new Object[] {
			"NZZ",
			"ZSZ",
			"ZZN",
			Character.valueOf('N'), Item.netherStalkSeeds, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('S'), Item.spiderEye
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLimbBolt, 1, 23), new Object[] {
			"XXZ",
			"XZX",
			"ZXC",
			Character.valueOf('C'), Item.redstone, Character.valueOf('Z'), new ItemStack(Items.attachmentLimbBolt, 1, 10), Character.valueOf('X'), Item.ingotIron
		});
	}

	public static ItemStack findMatchingCrossbowRecipe(InventoryCrossbowBench inventoryBlockCrossbowBench)
	{
		// If sticks are in the right spots
		if (inventoryBlockCrossbowBench.getStackInSlot(3) != null && inventoryBlockCrossbowBench.getStackInSlot(3).itemID == Item.stick.itemID && inventoryBlockCrossbowBench.getStackInSlot(4) != null && inventoryBlockCrossbowBench.getStackInSlot(4).itemID == Item.stick.itemID && inventoryBlockCrossbowBench.getStackInSlot(5) != null && inventoryBlockCrossbowBench.getStackInSlot(5).itemID == Item.stick.itemID)
		{
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).getItemDamage() == 5 && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).getItemDamage() == 5 && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).getItemDamage() == 5 && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).getItemDamage() == 5 && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).getItemDamage() == 5)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.heavy);
				}

				// If there is a tri shot mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.woodenCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.wooden, EnumCrossbowFireRate.tri);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).getItemDamage() == 6 && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).getItemDamage() == 6 && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).getItemDamage() == 6 && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).getItemDamage() == 6 && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).getItemDamage() == 6)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.heavy);
				}

				// If there is a tri shot mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.stoneCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.stone, EnumCrossbowFireRate.tri);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).getItemDamage() == 7 && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).getItemDamage() == 7 && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).getItemDamage() == 7 && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).getItemDamage() == 7 && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).getItemDamage() == 7)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.heavy);
				}

				// If there is a tri shot mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.ironCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.iron, EnumCrossbowFireRate.tri);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).getItemDamage() == 8 && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).getItemDamage() == 8 && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).getItemDamage() == 8 && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).getItemDamage() == 8 && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).getItemDamage() == 8)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.heavy);
				}

				// If there is a tri shot mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.goldCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.gold, EnumCrossbowFireRate.tri);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).getItemDamage() == 9 && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).getItemDamage() == 9 && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).getItemDamage() == 9 && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).getItemDamage() == 9 && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).getItemDamage() == 9)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 14)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.shortscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 15)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.longscope, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.none, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 19)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.ice, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 17)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.explosive, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 16)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.flame, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 20)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lightning, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 18)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.lava, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 21)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.torch, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}

				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 10 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.none);
				}

				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 11 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.light);
				}

				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 12 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.medium);
				}

				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 13 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.heavy);
				}

				// If there is a tri shot mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).getItemDamage() == 23 && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).getItemDamage() == 22)
				{
					return ItemCrossbow.setAttachmentAndMaterial(new ItemStack(Items.diamondCrossbowBase), EnumAttachmentType.poison, EnumCrossbowMaterial.diamond, EnumCrossbowFireRate.tri);
				}
			}
		}
		return null;
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowBase.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack is any stone crossbow
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.stoneCrossbowBase.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack is any iron crossbow
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.ironCrossbowBase.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack is any gold crossbow
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.goldCrossbowBase.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack is any diamond crossbow
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.diamondCrossbowBase.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a basic scope
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScope.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a long range scope
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScope.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a light mechanism attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a medium mechanism attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a heavy mechanism attachment
	 * @param Itemstack The item to check
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
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a tri shot mechanism attachment
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
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has an explosive attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has a lava attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has an ice attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	/**
	 * If the provided Itemstack has an ice attachment
	 * @param Itemstack The item to check
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
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

//		if (Itemstack != null
//				&& (Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachment.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
//				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

    public static Explosion createExplosion(Entity par1Entity, EntityPlayer player, double par2, double par4, double par6, float par8, boolean par9)
    {
    	FMLLog.info("sadsdasd" + (player == null));
        return newExplosion(par1Entity, player, par2, par4, par6, par8, false, par9);
    }

    /**
     * returns a new explosion. Does initiation (at time of writing Explosion is not finished)
     */
    public static Explosion newExplosion(Entity par1Entity, EntityPlayer player, double par2, double par4, double par6, float par8, boolean par9, boolean par10)
    {
    	ExplosionCrossbow var11 = new ExplosionCrossbow(par1Entity.worldObj, par1Entity, player, par2, par4, par6, par8);
        var11.isFlaming = par9;
        var11.isSmoking = par10;
        var11.doExplosionA();
        var11.doExplosionB(true);
        return var11;
    }
}
