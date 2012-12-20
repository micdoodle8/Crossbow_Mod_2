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
        EntityPlayerMP player = (EntityPlayerMP)p;
        
        if (packetID == 0)
        {
        	Class[] decodeAs = {ItemStack.class};
        	Object[] packetReadout = Util.readPacketData(data, decodeAs);
        	
        	if (player.worldObj != null)
        	{
            	ItemStack item = (ItemStack) packetReadout[0];
            	World world = player.worldObj;
            	
            	shootServer(player);
        	}
        }
    }
	
	public static void shootServer(EntityPlayer entityplayer)
	{
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		
		World world = entityplayer.worldObj;
		
		if (itemstack == null || !(itemstack.getItem() instanceof ItemCrossbow))
		{
			return;
		}
		
		ItemCrossbow crossbow = (ItemCrossbow) itemstack.getItem();
		
		EntityBolt entityarrow = crossbow.getEntity(world, entityplayer);

        entityarrow.item = crossbow.requiredMetadata(entityplayer);
        
        if (Util.hasFlameAttachment(itemstack))
        {
        	entityarrow.setFire(100);
        	entityarrow.hasFireAttachment = true;
        }
        else
        {
        	entityarrow.hasFireAttachment = false;
        }
        
        if (Util.hasExplosiveAttachment(itemstack))
        {
        	entityarrow.hasExplosiveAttachment = true;
        }
        else
        {
        	entityarrow.hasExplosiveAttachment = false;
        }
        
        if (Util.hasLavaAttachment(itemstack))
        {
        	entityarrow.hasLavaAttachment = true;
        }
        else
        {
        	entityarrow.hasLavaAttachment = false;
        }
        
        if (Util.hasIceAttachment(itemstack))
        {
        	entityarrow.hasIceAttachment = true;
        }
        else
        {
        	entityarrow.hasIceAttachment = false;
        }
        
        if (Util.hasLightningAttachment(itemstack))
        {
        	entityarrow.hasLightningAttachment = true;
        }
        else
        {
        	entityarrow.hasLightningAttachment = false;
        }
        
        if (Util.hasTorchAttachment(itemstack))
        {
        	entityarrow.hasTorchAttachment = true;
        }
        else
        {
        	entityarrow.hasTorchAttachment = false;
        }
        
        if (Util.hasPoisonAttachment(itemstack))
        {
        	entityarrow.hasPoisonAttachment = true;
        }
        else
        {
        	entityarrow.hasPoisonAttachment = false;
        }

        itemstack.damageItem(1, entityplayer);
        world.playSoundAtEntity(entityplayer, "cbowfire", 1.0F, 0.92F);
        for (int j = 0; j < entityplayer.inventory.getSizeInventory(); j++)
        {
        	ItemStack stack = entityplayer.inventory.getStackInSlot(j);
        	
        	if (stack != null && stack.getItem().shiftedIndex == Items.attachmentLimbBolt.shiftedIndex && stack.getItemDamage() == crossbow.requiredMetadata(entityplayer))
        	{
        		stack.stackSize--;
        		break;
        	}
        }

    	world.spawnEntityInWorld(entityarrow);
	}
}
