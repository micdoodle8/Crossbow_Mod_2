package micdoodle8.mods.crossbowmod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCrossbowBench extends Block
{
	public BlockCrossbowBench(int par1)
	{
		super(par1, Material.wood);
		this.blockIndexInTexture = 1;
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public int getBlockTextureFromSide(int par1)
    {
        return par1 == 1 ? this.blockIndexInTexture + 1 : (par1 == 0 ? this.blockIndexInTexture - 1 : this.blockIndexInTexture);
    }

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		par5EntityPlayer.openGui(CrossbowModCore.instance, ConfigManager.GUIID_BlockCrossbowBench, par1World, par2, par3, par4);
		return true;
    }

	@Override
	public String getTextureFile()
	{
		return "/micdoodle8/mods/crossbowmod/resources/gui/other.png";
	}

	@Override
	public void addCreativeItems(ArrayList itemList)
    {
        if(this.blockID == Items.crossbowBench.blockID)
        {
            itemList.add(new ItemStack(this));
        }
    }
}
