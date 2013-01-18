package micdoodle8.mods.crossbowmod;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabCrossbows extends CreativeTabs
{
	public CreativeTabCrossbows(String label)
	{
		super(label);
	}

	@Override
    public int getTabIconItemIndex()
    {
        return Items.diamondCrossbowBase.itemID;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
    	return CrossbowModCore.lang.get("itemGroup." + this.getTabLabel());
    }
}
