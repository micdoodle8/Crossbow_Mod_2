package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemCrossbow extends Item
{
	public boolean mouseHeld;
	public boolean lastMouseHeld;
	public int reloadStage;
	protected boolean isBoltLoaded;
	public int reloadingTime;
	public int prevReloadingTime;

	public ItemCrossbow(int i)
	{
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(this.getCrossbowMaxDamage());
		this.isBoltLoaded = false;
        this.setCreativeTab(CrossbowModCore.crossbowTab);
        CrossbowModCore.crossbowsList.add(this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
		if (entity instanceof EntityPlayer && ((EntityPlayer) entity).inventory.getCurrentItem() == itemstack)
		{
			EntityPlayer entityplayer = (EntityPlayer) entity;
			this.lastMouseHeld = this.mouseHeld;
        	this.mouseHeld = FMLClientHandler.instance().getClient().gameSettings.keyBindUseItem.pressed;

			this.prevReloadingTime = this.reloadingTime;

			if (this.reloadingTime > 0)
			{
				this.reloadingTime -= 5;
			}

			if (this.reloadingTime < 0)
			{
				this.reloadingTime = 0;
			}

			if (this.reloadingTime <= this.getReloadTime() / 2 && this.reloadingTime != 0)
	    	{
	    		this.reloadStage = 1;
	    	}
	    	else if (this.reloadingTime == 0)
	    	{
	    		this.reloadStage = 2;
	    	}
	    	else if (this.reloadingTime > this.getReloadTime() / 2)
	    	{
	    		this.reloadStage = 0;
	    	}

        	if (!this.isBoltLoaded)
        	{
        		this.reloadStage = 0;
        		this.isBoltLoaded = true;
        		this.reloadingTime = this.getReloadTime() * 2;
        	}

        	if ((Util.hasHeavyMech(itemstack) || Util.hasMediumMech(itemstack) || Util.hasLightMech(itemstack)) && this.mouseHeld)
        	{
        		itemstack = this.shoot(itemstack, world, entityplayer);
        	}
        	else if (this.mouseHeld && !this.lastMouseHeld && !Util.hasBasicScope(itemstack) && !Util.hasLongRangeScope(itemstack))
        	{
        		itemstack = this.shoot(itemstack, world, entityplayer);
        	}
        	else if ((Util.hasBasicScope(itemstack) || Util.hasLongRangeScope(itemstack)) && this.lastMouseHeld && !this.mouseHeld)
        	{
        		itemstack = this.shoot(itemstack, world, entityplayer);
        	}
		}
	}

	@SideOnly(Side.CLIENT)
	private ItemStack shoot(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (CrossbowModClient.shootTime <= 0)
		{
	    	if (player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, this.requiredMetadata(player))))
	    	{
		        EntityBolt entityarrow = this.getEntity(world, player);

		        entityarrow.item = this.requiredMetadata(player);

	    		if (Util.hasLightMech(itemstack))
		    	{
		    		CrossbowModClient.shootTime = 24;
		    	}
		    	else if (Util.hasMediumMech(itemstack))
		    	{
		    		CrossbowModClient.shootTime = 18;
		    	}
		    	else if (Util.hasHeavyMech(itemstack))
		    	{
		    		CrossbowModClient.shootTime = 12;
		    	}
		    	else
		    	{
		    		CrossbowModClient.shootTime = 18;
		    	}

		    	if (Util.hasFlameAttachment(itemstack))
		        {
		        	entityarrow.setFire(100);
		        	entityarrow.hasFireAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasFireAttachment = false;
		        }

		        if (Util.hasExplosiveAttachment(itemstack))
		        {
		        	entityarrow.hasExplosiveAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasExplosiveAttachment = false;
		        }

		        if (Util.hasLavaAttachment(itemstack))
		        {
		        	entityarrow.hasLavaAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasLavaAttachment = false;
		        }

		        if (Util.hasIceAttachment(itemstack))
		        {
		        	entityarrow.hasIceAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasIceAttachment = false;
		        }

		        if (Util.hasLightningAttachment(itemstack))
		        {
		        	entityarrow.hasLightningAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasLightningAttachment = false;
		        }

		        if (Util.hasTorchAttachment(itemstack))
		        {
		        	entityarrow.hasTorchAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasTorchAttachment = false;
		        }

		        if (Util.hasPoisonAttachment(itemstack))
		        {
		        	entityarrow.hasPoisonAttachment = true;
		        }
		        else
		        {
		        	entityarrow.hasPoisonAttachment = false;
		        }

	            world.playSoundAtEntity(player, "cbowfire", 1.0F, 0.92F);

		        if (world.isRemote)
		        {
					Object[] toSend = {itemstack};
					PacketDispatcher.sendPacketToServer(Util.createPacket("CrossbowMod", 0, toSend));
		        }
		        else
		        {
		            itemstack.damageItem(1, player);
		            for (int j = 0; j < player.inventory.getSizeInventory(); j++)
		            {
		            	ItemStack stack = player.inventory.getStackInSlot(j);

		            	if (stack != null && stack.getItem().shiftedIndex == Items.attachmentLimbBolt.shiftedIndex && stack.getItemDamage() == this.requiredMetadata(player))
		            	{
		            		stack.stackSize--;

		            		if (stack.stackSize <= 0)
		            		{
		            			player.inventory.setInventorySlotContents(j, null);
		            		}

		            		break;
		            	}
		            }
		        	world.spawnEntityInWorld(entityarrow);
		        }

            	this.isBoltLoaded = false;
	    	}
		}

		return itemstack;
	}

    public abstract EntityBolt getEntity(World world, EntityLiving entityliving);

    public abstract int getCrossbowMaxDamage();

    public abstract int getReloadTime();

    public abstract int requiredMetadata(EntityLiving entityliving);

    public abstract String getSpriteSheetLoc();

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List var2, boolean b)
    {
//    	stack.getItem().setIconIndex(getUpdatedCrossbowIndex(stack));

    	if (stack.getTagCompound() != null)
    	{
        	NBTTagCompound comp = stack.getTagCompound();
    		switch (comp.getInteger("attachment"))
    		{
    		case 0:
                break;
    		case 1:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 15)) + ".name"));
                break;
    		case 2:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 14)) + ".name"));
                break;
    		case 3:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 18)) + ".name"));
                break;
    		case 4:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 19)) + ".name"));
                break;
    		case 5:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 22)) + ".name"));
                break;
    		case 6:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 21)) + ".name"));
                break;
    		case 7:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 20)) + ".name"));
                break;
    		case 8:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 17)) + ".name"));
                break;
    		case 9:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 16)) + ".name"));
                break;
    		}

    		switch (comp.getInteger("firerate"))
    		{
    		case 0:
                break;
    		case 1:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 11)) + ".name"));
                break;
    		case 2:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 12)) + ".name"));
                break;
    		case 3:
                var2.add(CrossbowModCore.lang.get(Items.attachmentLimbBolt.getItemNameIS(new ItemStack(Items.attachmentLimbBolt, 1, 13)) + ".name"));
                break;
    		}
    	}

//    	if (Util.hasBasicScope(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentShortScope.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasLongRangeScope(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentShortScope.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasLightMech(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.mechanismLightAuto.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasMediumMech(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.mechanismMediumAuto.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasHeavyMech(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.mechanismHeavyAuto.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasExplosiveAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentExplosive.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasFlameAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentFire.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasLavaAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentLava.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasIceAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentIce.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasLightningAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentLightning.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasTorchAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentTorch.getItemName() + ".name"));
//    	}
//
//    	if (Util.hasPoisonAttachment(var1))
//    	{
//            var2.add(CrossbowModCore.lang.get(Items.attachmentPoison.getItemName() + ".name"));
//    	}
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItemStack(new ItemStack(Items.attachmentLimbBolt, 1, this.requiredMetadata(par3EntityPlayer))))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
    	return this.getSpriteSheetLoc();
    }

    public static ItemStack setAttachmentAndMaterial(ItemStack stack, EnumAttachmentType type, EnumCrossbowMaterial material, EnumCrossbowFireRate fireRate)
    {
        if (stack.stackTagCompound == null)
        {
        	stack.setTagCompound(new NBTTagCompound());
        }

        if (type != null && material != null && fireRate != null)
        {
        	stack.getTagCompound().setInteger("attachment", type.getIndex());
        	stack.getTagCompound().setInteger("material", material.getIndex());
        	stack.getTagCompound().setInteger("firerate", fireRate.getIndex());
        }

        return stack;
    }

    public int getUpdatedCrossbowIndex(ItemStack stack)
    {
    	if (stack.getTagCompound() != null)
    	{
        	NBTTagCompound comp = stack.getTagCompound();
        	switch (comp.getInteger("material"))
        	{
//        	case 0:
//        	case 1:
//        	case 2:
//        	case 3:
//        	case 4:
        	default:
        		switch (comp.getInteger("attachment"))
        		{
        		case 0:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 0;
        			case 1:
        				return 9;
        			case 2:
        				return 10;
        			case 3:
        				return 11;
        			}
        		case 1:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 2;
        			case 1:
        				return 4;
        			case 2:
        				return 6;
        			case 3:
        				return 8;
        			}
        		case 2:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 1;
        			case 1:
        				return 3;
        			case 2:
        				return 4;
        			case 3:
        				return 7;
        			}
        		case 3:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 52;
        			case 1:
        				return 53;
        			case 2:
        				return 54;
        			case 3:
        				return 55;
        			}
        		case 4:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 56;
        			case 1:
        				return 57;
        			case 2:
        				return 58;
        			case 3:
        				return 59;
        			}
        		case 5:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 100;
        			case 1:
        				return 101;
        			case 2:
        				return 102;
        			case 3:
        				return 103;
        			}
        		case 6:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 96;
        			case 1:
        				return 97;
        			case 2:
        				return 98;
        			case 3:
        				return 99;
        			}
        		case 7:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
        				return 60;
        			case 1:
        				return 61;
        			case 2:
        				return 62;
        			case 3:
        				return 63;
        			}
        		case 8:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
    					return 12;
        			case 1:
    					return 13;
        			case 2:
    					return 14;
        			case 3:
    					return 15;
        			}
        		case 9:
        			switch (comp.getInteger("firerate"))
        			{
        			case 0:
    					return 48;
        			case 1:
    					return 49;
        			case 2:
    					return 50;
        			case 3:
    					return 51;
        			}
        		}
        	}
    	}

    	return 0;
    }

//	if (stack.getTagCompound() != null)
//	{
//    	NBTTagCompound comp = stack.getTagCompound();
//    	switch (comp.getInteger("material"))
//    	{
//    	case 0:
//    		switch (comp.getInteger("attachment"))
//    		{
//    		case 0:
//    		case 1:
//    		case 2:
//    		case 3:
//    		case 4:
//    		case 5:
//    		case 6:
//    		case 7:
//    		case 8:
//    		}
//    	case 1:
//    		switch (comp.getInteger("attachment"))
//    		{
//    		case 0:
//    		case 1:
//    		case 2:
//    		case 3:
//    		case 4:
//    		case 5:
//    		case 6:
//    		case 7:
//    		case 8:
//    		}
//    	case 2:
//    		switch (comp.getInteger("attachment"))
//    		{
//    		case 0:
//    		case 1:
//    		case 2:
//    		case 3:
//    		case 4:
//    		case 5:
//    		case 6:
//    		case 7:
//    		case 8:
//    		}
//    	case 3:
//    		switch (comp.getInteger("attachment"))
//    		{
//    		case 0:
//    		case 1:
//    		case 2:
//    		case 3:
//    		case 4:
//    		case 5:
//    		case 6:
//    		case 7:
//    		case 8:
//    		}
//    	case 4:
//    		switch (comp.getInteger("attachment"))
//    		{
//    		case 0:
//    		case 1:
//    		case 2:
//    		case 3:
//    		case 4:
//    		case 5:
//    		case 6:
//    		case 7:
//    		case 8:
//    		}
//    	}
//	}

    @Override
    @SideOnly(Side.CLIENT)
    public int getIconIndex(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
    	if (!(ModLoader.getMinecraftInstance().currentScreen != null && ModLoader.getMinecraftInstance().currentScreen.allowUserInput) && (Mouse.getEventDWheel() != 0 || (Keyboard.isKeyDown(Keyboard.KEY_0) || Keyboard.isKeyDown(Keyboard.KEY_1) || Keyboard.isKeyDown(Keyboard.KEY_2) || Keyboard.isKeyDown(Keyboard.KEY_3) || Keyboard.isKeyDown(Keyboard.KEY_4) || Keyboard.isKeyDown(Keyboard.KEY_5) || Keyboard.isKeyDown(Keyboard.KEY_6) || Keyboard.isKeyDown(Keyboard.KEY_7) || Keyboard.isKeyDown(Keyboard.KEY_8) || Keyboard.isKeyDown(Keyboard.KEY_9))))
		{
        	return this.iconIndex;
		}
        if (this.reloadStage == 0)
        {
        	return this.iconIndex;
        }
        else if (this.reloadStage == 1)
        {
        	return this.iconIndex + 16;
        }
        else if (this.reloadStage == 2)
        {
        	return this.iconIndex + 32;
        }
        else return 0;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    @Override
    public int getIconIndex(ItemStack stack, int pass)
    {
    	return this.getUpdatedCrossbowIndex(stack);
    }
}
