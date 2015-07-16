package micdoodle8.mods.crossbowmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.crossbowmod.item.CrossbowItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCrossbows extends CreativeTabs
{
    public CreativeTabCrossbows(String label)
    {
        super(label);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return CrossbowItems.diamondCrossbowBase;
    }

    // @Override
    // @SideOnly(Side.CLIENT)
    // public String getTranslatedTabLabel()
    // {
    // return CrossbowModCore.lang.get("itemGroup." + this.getTabLabel());
    // }
}
