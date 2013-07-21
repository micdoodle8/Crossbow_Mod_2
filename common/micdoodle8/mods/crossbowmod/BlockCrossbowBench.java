package micdoodle8.mods.crossbowmod;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrossbowBench extends Block
{
    private Icon[] icons = new Icon[3];
    
	public BlockCrossbowBench(int par1)
	{
		super(par1, Material.wood);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return CrossbowModCore.crossbowTab;
    }

	@Override
	public Icon getIcon(int side, int meta)
    {
	    ForgeDirection direction = ForgeDirection.getOrientation(side);
	    
	    if (direction == ForgeDirection.UP)
	    {
	        return this.icons[2];
	    }
	    else if (direction == ForgeDirection.DOWN)
	    {
	        return this.icons[0];
	    }
	    else
	    {
	        return this.icons[1];
	    }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
	    for (int i = 1; i <= 3; i++)
	    {
	        this.icons[i - 1] = par1IconRegister.registerIcon(CrossbowModCore.TEXTURE_PREFIX + "other_0" + i);
	    }
	    
	    this.blockIcon = this.icons[1];
    }

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		par5EntityPlayer.openGui(CrossbowModCore.instance, ConfigManager.GUIID_BlockCrossbowBench, par1World, par2, par3, par4);
		return true;
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
