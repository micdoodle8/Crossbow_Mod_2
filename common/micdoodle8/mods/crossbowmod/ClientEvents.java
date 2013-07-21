package micdoodle8.mods.crossbowmod;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientEvents
{
	@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
//            event.manager.soundPoolSounds.addSound("cbowfire.ogg", CrossbowModCore.instance.getClass().getResource("/micdoodle8/mods/crossbowmod/resources/sounds/cbowfire.ogg"));
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
