package micdoodle8.mods.crossbowmod;

import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCBMod extends Item
{
    private static final String[] names = new String[] {
    	"woodBolt", // 0
    	"stoneBolt", // 1
    	"ironBolt", // 2
    	"goldBolt", // 3
    	"diamondBolt", // 4
    	"woodLimb", // 5
    	"stoneLimb", // 6
    	"ironLimb", // 7
    	"goldLimb", // 8
    	"diamondLimb", // 9
    	"mechanismSemiAuto", // 10
    	"mechanismLightAuto", // 11
    	"mechanismMediumAuto", // 12
    	"mechanismHeavyAuto", // 13
    	"attachmentShortScope", // 14
    	"attachmentLongScope", // 15
    	"attachmentFire", // 16
    	"attachmentExplosive", // 17
    	"attachmentLava", // 18
    	"attachmentIce", // 19
    	"attachmentLightning", // 20
    	"attachmentTorch", // 21
    	"attachmentPoison", // 22
    	"mechanismTriShot"}; // 23
    
    private Icon[] icons = new Icon[names.length];

    public ItemCBMod(int i)
    {
		super(i);
        this.setCreativeTab(CrossbowModCore.crossbowTab);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < names.length; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        int offset = 4;
        for (int i = offset; i < ItemCBMod.names.length + offset; i++)
        {
            String s = i < 10 ? "0" + i : "" + i;
            icons[i - offset] = par1IconRegister.registerIcon(CrossbowModCore.TEXTURE_PREFIX + "other_" + s);
        }
        
        this.itemIcon = par1IconRegister.registerIcon(this.func_111208_A());
    }

    @Override
    public Icon getIconFromDamage(int meta)
    {
        return this.icons[this.getIconIndex(meta) - 3];
    }

    public int getIconIndex(int meta)
    {
    	switch (meta)
    	{
    	case 0:
    		return 12;
    	case 1:
    		return 14;
    	case 2:
    		return 16;
    	case 3:
    		return 18;
    	case 4:
    		return 20;
    	case 5:
    		return 13;
    	case 6:
    		return 15;
    	case 7:
    		return 17;
    	case 8:
    		return 19;
    	case 9:
    		return 21;
    	case 10:
    		return 3;
    	case 11:
    		return 4;
    	case 12:
    		return 5;
    	case 13:
    		return 6;
    	case 14:
    		return 7;
    	case 15:
    		return 8;
    	case 16:
    		return 10;
    	case 17:
    		return 9;
    	case 18:
    		return 11;
    	case 19:
    		return 22;
    	case 20:
    		return 23;
    	case 21:
    		return 24;
    	case 22:
    		return 25;
    	case 23:
    		return 26;
    	default:
    		return 0;
    	}
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= names.length)
        {
            var2 = 0;
        }

        return super.getUnlocalizedName() + "." + names[var2];
    }
}
