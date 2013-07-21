package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.Player;

public class CrossbowModServer
{
    public static void onPacketData(INetworkManager networkmanager, Packet250CustomPayload packet, Player p)
    {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        int packetID = Util.readPacketID(data);
        EntityPlayerMP player = (EntityPlayerMP) p;

        if (packetID == 0)
        {
            Class[] decodeAs = { ItemStack.class, Boolean.class };
            Object[] packetReadout = Util.readPacketData(data, decodeAs);

            if (player.worldObj != null)
            {
                CrossbowModServer.shootServer(player, (Boolean) packetReadout[1]);
            }
        }
    }

    public static void shootServer(EntityPlayer entityplayer, boolean triShot)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();

        World world = entityplayer.worldObj;

        if (itemstack == null || !(itemstack.getItem() instanceof ItemCrossbow))
        {
            return;
        }

        ItemCrossbow crossbow = (ItemCrossbow) itemstack.getItem();

        EntityBolt entityarrow = crossbow.getEntity(world, entityplayer);
        EntityBolt entityarrow2 = crossbow.getEntity(world, entityplayer, -10.0F);
        EntityBolt entityarrow3 = crossbow.getEntity(world, entityplayer, 10.0F);

        entityarrow.item = crossbow.requiredMetadata(entityplayer);
        entityarrow2.item = crossbow.requiredMetadata(entityplayer);
        entityarrow3.item = crossbow.requiredMetadata(entityplayer);

        if (Util.hasFlameAttachment(itemstack))
        {
            entityarrow.setFire(100);
            entityarrow.hasFireAttachment = true;
            entityarrow2.setFire(100);
            entityarrow2.hasFireAttachment = true;
            entityarrow3.setFire(100);
            entityarrow3.hasFireAttachment = true;
        }
        else
        {
            entityarrow.hasFireAttachment = false;
            entityarrow2.hasFireAttachment = false;
            entityarrow3.hasFireAttachment = false;
        }

        if (Util.hasExplosiveAttachment(itemstack))
        {
            entityarrow.hasExplosiveAttachment = true;
            entityarrow2.hasExplosiveAttachment = true;
            entityarrow3.hasExplosiveAttachment = true;
        }
        else
        {
            entityarrow.hasExplosiveAttachment = false;
            entityarrow2.hasExplosiveAttachment = false;
            entityarrow3.hasExplosiveAttachment = false;
        }

        if (Util.hasLavaAttachment(itemstack))
        {
            entityarrow.hasLavaAttachment = true;
            entityarrow2.hasLavaAttachment = true;
            entityarrow3.hasLavaAttachment = true;
        }
        else
        {
            entityarrow.hasLavaAttachment = false;
            entityarrow2.hasLavaAttachment = false;
            entityarrow3.hasLavaAttachment = false;
        }

        if (Util.hasIceAttachment(itemstack))
        {
            entityarrow.hasIceAttachment = true;
            entityarrow2.hasIceAttachment = true;
            entityarrow3.hasIceAttachment = true;
        }
        else
        {
            entityarrow.hasIceAttachment = false;
            entityarrow2.hasIceAttachment = false;
            entityarrow3.hasIceAttachment = false;
        }

        if (Util.hasLightningAttachment(itemstack))
        {
            entityarrow.hasLightningAttachment = true;
            entityarrow2.hasLightningAttachment = true;
            entityarrow3.hasLightningAttachment = true;
        }
        else
        {
            entityarrow.hasLightningAttachment = false;
            entityarrow2.hasLightningAttachment = false;
            entityarrow3.hasLightningAttachment = false;
        }

        if (Util.hasTorchAttachment(itemstack))
        {
            entityarrow.hasTorchAttachment = true;
            entityarrow2.hasTorchAttachment = true;
            entityarrow3.hasTorchAttachment = true;
        }
        else
        {
            entityarrow.hasTorchAttachment = false;
            entityarrow2.hasTorchAttachment = false;
            entityarrow3.hasTorchAttachment = false;
        }

        if (Util.hasPoisonAttachment(itemstack))
        {
            entityarrow.hasPoisonAttachment = true;
            entityarrow2.hasPoisonAttachment = true;
            entityarrow3.hasPoisonAttachment = true;
        }
        else
        {
            entityarrow.hasPoisonAttachment = false;
            entityarrow2.hasPoisonAttachment = false;
            entityarrow3.hasPoisonAttachment = false;
        }

        itemstack.damageItem(1, entityplayer);
        world.playSoundAtEntity(entityplayer, "cbowfire", 1.0F, 0.92F);

        int totalBolts = 0;

        for (int j = 0; j < entityplayer.inventory.getSizeInventory(); j++)
        {
            ItemStack stack = entityplayer.inventory.getStackInSlot(j);

            if (stack != null && stack.getItem().itemID == Items.attachmentLimbBolt.itemID && stack.getItemDamage() == crossbow.requiredMetadata(entityplayer))
            {
                totalBolts += stack.stackSize;
            }
        }

        for (int j = 0; j < entityplayer.inventory.getSizeInventory(); j++)
        {
            ItemStack stack = entityplayer.inventory.getStackInSlot(j);

            if (stack != null && stack.getItem().itemID == Items.attachmentLimbBolt.itemID && stack.getItemDamage() == crossbow.requiredMetadata(entityplayer))
            {
                stack.stackSize--;

                if (Util.hasTriShotMech(itemstack))
                {
                    stack.stackSize -= 2;
                }

                if (stack.stackSize <= 0)
                {
                    entityplayer.inventory.setInventorySlotContents(j, null);
                }

                break;
            }
        }

        world.spawnEntityInWorld(entityarrow);

        if (triShot && (totalBolts >= 2 || entityplayer.capabilities.isCreativeMode))
        {
            world.spawnEntityInWorld(entityarrow2);

            if (totalBolts >= 3 || entityplayer.capabilities.isCreativeMode)
            {
                world.spawnEntityInWorld(entityarrow3);
            }
        }
    }
}
