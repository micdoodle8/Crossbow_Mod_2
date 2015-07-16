package micdoodle8.mods.crossbowmod.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class ClientEvents
{
    @SubscribeEvent
    public void onSound(SoundLoadEvent event)
    {
//        try
//        {
//            event.manager.addSound("crossbow/cbowfire.ogg");
//        }
//        catch (Exception e)
//        {
//            System.err.println("Failed to register one or more sounds.");
//        }
    }
}
