package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import cpw.mods.fml.common.network.Player;

public class CrossbowModServer
{
	public static void onPacketData(NetworkManager networkmanager, Packet250CustomPayload packet, Player p)
    {
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        int packetID = Util.readPacketID(data);
        EntityPlayerMP player = (EntityPlayerMP)p;
        
        if (packetID == 0)
        {
            Class[] decodeAs = {Boolean.class};
            Object[] packetReadout = Util.readPacketData(data, decodeAs);
            
        	if (player != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemCrossbow)
        	{
        		ItemCrossbow crossbow = (ItemCrossbow) player.inventory.getCurrentItem().getItem();
        		
        		crossbow.mouseHeld = Boolean.valueOf((Boolean) packetReadout[0]);
        	}
        }
    }
}
