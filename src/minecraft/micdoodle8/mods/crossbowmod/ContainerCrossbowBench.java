package micdoodle8.mods.crossbowmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerCrossbowBench extends Container
{
    public InventoryCrossbowBench craftMatrix = new InventoryCrossbowBench(this);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private EntityPlayer player;

    public ContainerCrossbowBench(InventoryPlayer par1InventoryPlayer)
    {
    	this.worldObj = par1InventoryPlayer.player.worldObj;
        this.addSlotToContainer(new SlotCrossbowBenchResult(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 142, 36));
        int var6;
        int var7;
        this.player = par1InventoryPlayer.player;

        //Mech, Limb, Stick, Stick, Stick
        for (var6 = 1; var6 < 6; ++var6)
        {
            this.addSlotToContainer(new Slot(this.craftMatrix, var6, (16 + var6 * 18) - 18, 36));
        }
        //Middle-Top Limb
        this.addSlotToContainer(new Slot(this.craftMatrix, 6, 16 + 18, 36 - 18));
        //Middle-Bottom Limb
        this.addSlotToContainer(new Slot(this.craftMatrix, 7, 16 + 18, 36 + 18));
        //Top Limb
        this.addSlotToContainer(new Slot(this.craftMatrix, 8, 16 + (18 * 2), 36 + (18 * 2)));
        //Bottom Limb
        this.addSlotToContainer(new Slot(this.craftMatrix, 9, 16 + (18 * 2), 36 - (18 * 2)));
        //Scope
        this.addSlotToContainer(new Slot(this.craftMatrix, 10, 15 + (18 * 4), 36 - (18 * 2)));

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 102 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 160));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int var2 = 0; var2 < 9; ++var2)
            {
                ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.dropPlayerItem(var3);
                }
            }
        }
    }

    @Override
	public void onCraftMatrixChanged(IInventory par1IInventory)
    {
    	if (Util.findMatchingCrossbowRecipe(this.craftMatrix) != null)
    	{
            this.craftResult.setInventorySlotContents(0, Util.findMatchingCrossbowRecipe(this.craftMatrix));
            
            player.addStat(CrossbowModCore.createCrossbow, 1);
    	}
    }

    @Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 0)
            {
                if (!this.mergeItemStack(var4, 11, 46, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par1 >= 10 && par1 < 37)
            {
                if (!this.mergeItemStack(var4, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par1 >= 37 && par1 < 46)
            {
                if (!this.mergeItemStack(var4, 11, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 11, 46, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(par1EntityPlayer, var4);
        }

        return var2;
    }
}
