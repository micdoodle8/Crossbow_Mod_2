package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Packet250CustomPayload;
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
		GameRegistry.addRecipe(new ItemStack(Items.attachmentExplosive, 1), new Object[] {
			"AY ", 
			"YZY",
			" YA",
			Character.valueOf('Y'), Item.ingotIron, Character.valueOf('A'), Item.ingotGold, Character.valueOf('Z'), Block.tnt
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentFire, 1), new Object[] {
			"AY ", 
			"YZY",
			" YA",
			Character.valueOf('Y'), Item.ingotIron, Character.valueOf('A'), Item.ingotGold, Character.valueOf('Z'), Item.flintAndSteel
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLava, 1), new Object[] {
			"AY ", 
			"YZY",
			" YA",
			Character.valueOf('Y'), Item.ingotIron, Character.valueOf('A'), Item.ingotGold, Character.valueOf('Z'), Item.bucketLava
		});
		GameRegistry.addRecipe(new ItemStack(Items.woodLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.planks
		});
		GameRegistry.addRecipe(new ItemStack(Items.stoneLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.cobblestone
		});
		GameRegistry.addRecipe(new ItemStack(Items.stoneLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Block.stone
		});
		GameRegistry.addRecipe(new ItemStack(Items.ironLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.goldLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotGold
		});
		GameRegistry.addRecipe(new ItemStack(Items.diamondLimb, 3), new Object[] {
			"XY", 
			"XY",
			"XY",
			Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.diamond
		});
		GameRegistry.addRecipe(new ItemStack(Items.mechanismSemiAuto, 1), new Object[] {
			"XXX", 
			"XYZ",
			"XZY",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk
		});
		GameRegistry.addRecipe(new ItemStack(Items.mechanismLightAuto, 1), new Object[] {
			"AXX", 
			"XBZ",
			"XZY",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.silk, Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Items.mechanismSemiAuto
		});
		GameRegistry.addRecipe(new ItemStack(Items.mechanismMediumAuto, 1), new Object[] {
			"XXX", 
			"XBZ",
			"XZY",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), Items.mechanismLightAuto
		});
		GameRegistry.addRecipe(new ItemStack(Items.mechanismHeavyAuto, 1), new Object[] {
			"XAA", 
			"ABZ",
			"AZY",
			Character.valueOf('X'), Item.diamond, Character.valueOf('A'), Item.ingotIron, Character.valueOf('Y'), Item.stick, Character.valueOf('Z'), Item.redstone, Character.valueOf('B'), Items.mechanismMediumAuto
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentShortScope, 1), new Object[] {
			"ZX ", 
			"XAX",
			" XZ",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), Block.torchRedstoneActive, Character.valueOf('Z'), Block.thinGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLongScope, 1), new Object[] {
			"ZX ", 
			"XAB",
			" XZ",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('A'), Items.attachmentShortScope, Character.valueOf('Z'), Block.thinGlass, Character.valueOf('B'), Block.button
		});
		GameRegistry.addRecipe(new ItemStack(Items.woodBolt, 8), new Object[] {
			"X", 
			"#",
			Character.valueOf('X'), Block.planks, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.stoneBolt, 8), new Object[] {
			"X", 
			"#",
			Character.valueOf('X'), Block.cobblestone, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.ironBolt, 8), new Object[] {
			"X", 
			"#",
			Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.goldBolt, 8), new Object[] {
			"X", 
			"#",
			Character.valueOf('X'), Item.ingotGold, Character.valueOf('#'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.diamondBolt, 8), new Object[] {
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
		GameRegistry.addRecipe(new ItemStack(Items.attachmentFire, 1), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLava, 1), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Item.bucketLava, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentExplosive, 1), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Block.tnt, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentIce, 1), new Object[] {
			"XZZ",
			"ZXZ",
			"ZZX",
			Character.valueOf('X'), Block.blockSnow, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentLightning, 1), new Object[] {
			"GZZ",
			"ZRZ",
			"ZZG",
			Character.valueOf('G'), Item.lightStoneDust, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('R'), Item.redstone
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentTorch, 1), new Object[] {
			"SZZ",
			"ZCZ",
			"ZZF",
			Character.valueOf('S'), Item.stick, Character.valueOf('C'), Item.coal, Character.valueOf('F'), Item.flintAndSteel, Character.valueOf('Z'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.attachmentPoison, 1), new Object[] {
			"NZZ",
			"ZSZ",
			"ZZN",
			Character.valueOf('N'), Block.netherStalk, Character.valueOf('Z'), Item.ingotIron, Character.valueOf('S'), Item.spiderEye
		});
	}
	
	public static ItemStack findMatchingCrossbowRecipe(InventoryCrossbowBench inventoryBlockCrossbowBench)
	{
		// If sticks are in the right spots
		if (inventoryBlockCrossbowBench.getStackInSlot(3) != null && inventoryBlockCrossbowBench.getStackInSlot(3).itemID == Item.stick.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(4) != null && inventoryBlockCrossbowBench.getStackInSlot(4).itemID == Item.stick.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(5) != null && inventoryBlockCrossbowBench.getStackInSlot(5).itemID == Item.stick.shiftedIndex)
		{
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).itemID == Items.woodLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).itemID == Items.woodLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).itemID == Items.woodLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).itemID == Items.woodLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).itemID == Items.woodLimb.shiftedIndex)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.woodenCrossbowBase);
				}
				
				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithBasicScope);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLongScope);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithBasicScopeAndLightMech);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLongScopeAndLightMech);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithBasicScopeAndMediumMech);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLongScopeAndMediumMech);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithBasicScopeAndHeavyMech);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLongScopeAndHeavyMech);
				}
				
				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.woodenCrossbowWithLightMech);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.woodenCrossbowWithMediumMech);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.woodenCrossbowWithHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithIceAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithIceAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithIceAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithIceAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithExplosiveAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithExplosiveAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithFlameAttachment);
				}
				
				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithFlameAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithFlameAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithFlameAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLightningAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLightningAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLightningAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLightningAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLavaAttachment);
				}
				
				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLavaAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLavaAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithLavaAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithTorchAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithTorchAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithTorchAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithTorchAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithPoisonAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithPoisonAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithPoisonAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).itemID == Items.stoneLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).itemID == Items.stoneLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).itemID == Items.stoneLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).itemID == Items.stoneLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).itemID == Items.stoneLimb.shiftedIndex)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.stoneCrossbowBase);
				}
				
				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithBasicScope);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLongScope);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithBasicScopeAndLightMech);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLongScopeAndLightMech);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithBasicScopeAndMediumMech);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLongScopeAndMediumMech);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithBasicScopeAndHeavyMech);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLongScopeAndHeavyMech);
				}
				
				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.stoneCrossbowWithLightMech);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.stoneCrossbowWithMediumMech);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.stoneCrossbowWithHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithIceAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithIceAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithIceAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithIceAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithExplosiveAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithExplosiveAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithFlameAttachment);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLightningAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLightningAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLightningAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLightningAttachmentAndHeavyMech);
				}
				
				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithFlameAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithFlameAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithFlameAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLavaAttachment);
				}
				
				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLavaAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLavaAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithLavaAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithTorchAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithTorchAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithTorchAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithTorchAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithPoisonAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithPoisonAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithPoisonAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).itemID == Items.ironLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).itemID == Items.ironLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).itemID == Items.ironLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).itemID == Items.ironLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).itemID == Items.ironLimb.shiftedIndex)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.ironCrossbowBase);
				}
				
				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithBasicScope);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLongScope);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithBasicScopeAndLightMech);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLongScopeAndLightMech);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithBasicScopeAndMediumMech);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLongScopeAndMediumMech);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithBasicScopeAndHeavyMech);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLongScopeAndHeavyMech);
				}
				
				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.ironCrossbowWithLightMech);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.ironCrossbowWithMediumMech);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.ironCrossbowWithHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLightningAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLightningAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLightningAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLightningAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithIceAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithIceAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithIceAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithIceAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithExplosiveAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithExplosiveAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithExplosiveAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithFlameAttachment);
				}
				
				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithFlameAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithFlameAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithFlameAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLavaAttachment);
				}
				
				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLavaAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLavaAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithLavaAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithTorchAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithTorchAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithTorchAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithTorchAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithPoisonAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithPoisonAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithPoisonAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.ironCrossbowWithPoisonAttachmentAndHeavyMech);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).itemID == Items.goldLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).itemID == Items.goldLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).itemID == Items.goldLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).itemID == Items.goldLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).itemID == Items.goldLimb.shiftedIndex)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.goldCrossbowBase);
				}
				
				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithBasicScope);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLongScope);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithBasicScopeAndLightMech);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLongScopeAndLightMech);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithBasicScopeAndMediumMech);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLongScopeAndMediumMech);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithBasicScopeAndHeavyMech);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLongScopeAndHeavyMech);
				}
				
				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.goldCrossbowWithLightMech);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.goldCrossbowWithMediumMech);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.goldCrossbowWithHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithIceAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithIceAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithIceAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithIceAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithExplosiveAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithExplosiveAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithExplosiveAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithFlameAttachment);
				}
				
				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithFlameAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithFlameAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithFlameAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLavaAttachment);
				}
				
				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLavaAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLavaAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLavaAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLightningAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLightningAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLightningAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithLightningAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithTorchAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithTorchAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithTorchAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithTorchAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithPoisonAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithPoisonAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithPoisonAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.goldCrossbowWithPoisonAttachmentAndHeavyMech);
				}
			}
			// If the limbs are the right material and in the correct position
			if (inventoryBlockCrossbowBench.getStackInSlot(2) != null && inventoryBlockCrossbowBench.getStackInSlot(2).itemID == Items.diamondLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(6) != null && inventoryBlockCrossbowBench.getStackInSlot(6).itemID == Items.diamondLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(7) != null && inventoryBlockCrossbowBench.getStackInSlot(7).itemID == Items.diamondLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(8) != null && inventoryBlockCrossbowBench.getStackInSlot(8).itemID == Items.diamondLimb.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(9) != null && inventoryBlockCrossbowBench.getStackInSlot(9).itemID == Items.diamondLimb.shiftedIndex)
			{
				// If there is a semi-auto mechanism
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.diamondCrossbowBase);
				}
				
				// If there is a semi-auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithBasicScope);
				}

				// If there is a semi-auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLongScope);
				}

				// If there is a light auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithBasicScopeAndLightMech);
				}

				// If there is a light auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLongScopeAndLightMech);
				}

				// If there is a medium auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithBasicScopeAndMediumMech);
				}

				// If there is a medium auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLongScopeAndMediumMech);
				}

				// If there is a heavy auto mechanism and a basic scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentShortScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithBasicScopeAndHeavyMech);
				}

				// If there is a heavy auto mechanism and a long scope
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLongScope.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLongScopeAndHeavyMech);
				}
				
				// If there is a light mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.diamondCrossbowWithLightMech);
				}

				// If there is a medium mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.diamondCrossbowWithMediumMech);
				}

				// If there is a heavy mechanism
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) == null)
				{
					return new ItemStack(Items.diamondCrossbowWithHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithIceAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithIceAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithIceAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentIce.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithIceAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithExplosiveAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithExplosiveAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentExplosive.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithFlameAttachment);
				}
				
				// If there is a light auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithFlameAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithFlameAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an Flame attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentFire.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithFlameAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLavaAttachment);
				}
				
				// If there is a light auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLavaAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLavaAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an lava attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLava.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLavaAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLightningAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLightningAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLightningAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentLightning.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithLightningAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithTorchAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithTorchAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithTorchAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentTorch.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithTorchAttachmentAndHeavyMech);
				}
				
				// If there is a semi-auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID ==Items.mechanismSemiAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithPoisonAttachment);
				}
				
				// If there is a light auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismLightAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithPoisonAttachmentAndLightMech);
				}
				
				// If there is a medium auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismMediumAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithPoisonAttachmentAndMediumMech);
				}
				
				// If there is a heavy auto mechanism and an explosive attachment
				else
				if (inventoryBlockCrossbowBench.getStackInSlot(1) != null && inventoryBlockCrossbowBench.getStackInSlot(1).itemID == Items.mechanismHeavyAuto.shiftedIndex && inventoryBlockCrossbowBench.getStackInSlot(10) != null && inventoryBlockCrossbowBench.getStackInSlot(10).itemID == Items.attachmentPoison.shiftedIndex)
				{
					return new ItemStack(Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech);
				}
			}
		}
		return null;
	}
	
	public static boolean isWooden(ItemStack Itemstack)
	{
		if (Itemstack != null
				&& (Itemstack.itemID == Items.woodenCrossbowBase.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScope.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScope.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack is any stone crossbow
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack is any stone crossbow
	 */
	public static boolean isStone(ItemStack Itemstack)
	{
		if (Itemstack != null
				&& (Itemstack.itemID == Items.stoneCrossbowBase.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScope.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScope.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack is any iron crossbow
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack is any iron crossbow
	 */
	public static boolean isIron(ItemStack Itemstack)
	{
		if (Itemstack != null
				&& (Itemstack.itemID == Items.ironCrossbowBase.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScope.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScope.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack is any gold crossbow
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack is any gold crossbow
	 */
	public static boolean isGold(ItemStack Itemstack)
	{
		if (Itemstack != null
				&& (Itemstack.itemID == Items.goldCrossbowBase.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScope.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScope.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack is any diamond crossbow
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack is any diamond crossbow
	 */
	public static boolean isDiamond(ItemStack Itemstack)
	{
		if (Itemstack != null
				&& (Itemstack.itemID == Items.diamondCrossbowBase.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScope.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScope.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a basic scope
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a basic scope
	 */
	public static boolean hasBasicScope(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScope.shiftedIndex 
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScope.shiftedIndex 
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScope.shiftedIndex 
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScope.shiftedIndex 
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScope.shiftedIndex 
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a long range scope
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a long range scope
	 */
	public static boolean hasLongRangeScope(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithLongScope.shiftedIndex 
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScope.shiftedIndex 
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScope.shiftedIndex 
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScope.shiftedIndex 
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScope.shiftedIndex 
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex 
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex  
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a light mechanism attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a light mechanism attachment
	 */
	public static boolean hasLightMech(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a medium mechanism attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a medium mechanism attachment
	 */
	public static boolean hasMediumMech(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a heavy mechanism attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a heavy mechanism attachment
	 */
	public static boolean hasHeavyMech(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithBasicScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLongScopeAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex))
		{
			return true;
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
	public static boolean hasFlameAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithFlameAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithFlameAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has an explosive attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has an explosive attachment
	 */
	public static boolean hasExplosiveAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithExplosiveAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has a lava attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a lava attachment
	 */
	public static boolean hasLavaAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLavaAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLavaAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has an ice attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a lava attachment
	 */
	public static boolean hasIceAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithIceAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithIceAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * If the provided Itemstack has an ice attachment
	 * @param Itemstack The item to check
	 * @return True if the provided Itemstack has a lava attachment
	 */
	public static boolean hasLightningAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithLightningAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithLightningAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean hasTorchAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithTorchAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithTorchAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean hasPoisonAttachment(ItemStack Itemstack)
	{
		if (Itemstack != null 
				&& (Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.woodenCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.stoneCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.ironCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.goldCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachment.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndHeavyMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndMediumMech.shiftedIndex
				|| Itemstack.itemID == Items.diamondCrossbowWithPoisonAttachmentAndLightMech.shiftedIndex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
