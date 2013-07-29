package micdoodle8.mods.crossbowmod;

import micdoodle8.mods.crossbowmod.item.Items;
import net.minecraft.creativetab.CreativeTabs;

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

    // @Override
    // @SideOnly(Side.CLIENT)
    // public String getTranslatedTabLabel()
    // {
    // return CrossbowModCore.lang.get("itemGroup." + this.getTabLabel());
    // }
}
