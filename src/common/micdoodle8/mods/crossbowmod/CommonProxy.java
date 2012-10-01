package micdoodle8.mods.crossbowmod;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
		//Handled client-side
	}
	
	public void load(FMLInitializationEvent event)
	{
		//Handled client-side
	}

	public void registerRenderInformation()
	{
		//Handled client-side
	}
	
	public void onCrossbowHeld(ItemStack itemstack, World world, EntityPlayer player)
	{
		//Handled client-side
	}
	
	public void onCrossbowClicked(ItemStack itemstack, World world, EntityPlayer player)
	{
		//Handled client-side
	}
	
	public boolean hasCrossbowInHand(EntityPlayer player)
	{
		return false;
//		return (player.inventory.getCurrentItem().getItem() instanceof ) TODO
	}
}
