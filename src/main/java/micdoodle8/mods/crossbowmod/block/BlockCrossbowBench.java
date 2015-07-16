package micdoodle8.mods.crossbowmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.crossbowmod.ConfigManager;
import micdoodle8.mods.crossbowmod.CrossbowModCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCrossbowBench extends Block
{
    private IIcon[] icons = new IIcon[3];

    public BlockCrossbowBench()
    {
        super(Material.wood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return CrossbowModCore.crossbowTab;
    }

    @Override
    public IIcon getIcon(int side, int meta)
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
    public void registerBlockIcons(IIconRegister par1IconRegister)
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

//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    @Override
//    public void addCreativeItems(ArrayList itemList)
//    {
//        itemList.add(new ItemStack(this));
//    }
}
