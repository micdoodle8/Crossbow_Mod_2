package micdoodle8.mods.crossbowmod;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.FMLLog;

public class ClientEvents 
{
	@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            event.manager.soundPoolSounds.addSound("cbowfire.ogg", CrossbowModCore.instance.getClass().getResource("/Mic'sMods/CrossbowMod/sounds/cbowfire.ogg"));            
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
