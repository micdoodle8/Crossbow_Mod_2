package micdoodle8.mods.crossbowmod;

import net.minecraft.src.CreativeTabs;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class CreativeTabCrossbows extends CreativeTabs
{
	public CreativeTabCrossbows(String label) 
	{
		super(label);
	}
	
	@Override
    public int getTabIconItemIndex()
    {
        return Items.diamondCrossbowBase.shiftedIndex;
    }
	
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
    	return CrossbowModCore.lang.get("itemGroup." + this.getTabLabel());
    }
}
