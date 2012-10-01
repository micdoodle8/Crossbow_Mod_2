package micdoodle8.mods.crossbowmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import cpw.mods.fml.common.network.Player;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;

public class CrossbowModServer
{
	public static void onPacketData(NetworkManager networkmanager, Packet250CustomPayload packet, Player player)
    {
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        
        int packetID = Util.readPacketID(data);
        
        if (packetID == 1)
        {
        	
        }
    }
}
