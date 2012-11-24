package micdoodle8.mods.crossbowmod;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

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
    	"attachmentPoison"}; // 22
    
    public ItemCBMod(int i) 
    {
		super(i);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

    @Override
	public String getTextureFile()
    {
    	return "/Mic'sMods/CrossbowMod/gui/other.png";
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

    @Override
    public int getIconFromDamage(int meta)
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
    	default:
    		return 0;
    	}
    }

    @Override
    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= names.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + names[var2];
    }
}
