package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        this.setCreativeTab(CreativeTabs.tabCombat);
        CrossbowModCore.crossbowsList.add(this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
		if (entity instanceof EntityPlayer && ((EntityPlayer) entity).inventory.getCurrentItem() == itemstack)
		{
			EntityPlayer entityplayer = (EntityPlayer) entity;
			lastMouseHeld = mouseHeld;
        	mouseHeld = FMLClientHandler.instance().getClient().gameSettings.keyBindUseItem.pressed;
				
			this.prevReloadingTime = this.reloadingTime;
				
			if (this.reloadingTime > 0)
			{
				this.reloadingTime -= 5;
			}
			
			if (this.reloadingTime < 0)
			{
				this.reloadingTime = 0;
			}
			
			if (this.reloadingTime <= getReloadTime() / 2 && this.reloadingTime != 0)
	    	{
	    		this.reloadStage = 1;
	    	}
	    	else if (this.reloadingTime == 0)
	    	{
	    		this.reloadStage = 2;
	    	}
	    	else if (this.reloadingTime > getReloadTime() / 2)
	    	{
	    		this.reloadStage = 0;
	    	}
			
        	if (!isBoltLoaded)
        	{
        		reloadStage = 0;
        		isBoltLoaded = true;
        		this.reloadingTime = getReloadTime() * 2;
        	}
        	
        	if ((Util.hasHeavyMech(itemstack) || Util.hasMediumMech(itemstack) || Util.hasLightMech(itemstack)) && mouseHeld)
        	{
        		itemstack = shoot(itemstack, world, entityplayer);
        	}
        	else if (mouseHeld && !lastMouseHeld)
        	{
        		itemstack = shoot(itemstack, world, entityplayer);
        	}
		}
	}

	@SideOnly(Side.CLIENT)
	private ItemStack shoot(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (CrossbowModClient.shootTime <= 0)
		{
	    	if (requiredItem(player) == null)
	    	{
	    		return itemstack;
	    	}
	    	else if (player.capabilities.isCreativeMode || player.inventory.hasItem(requiredItem(player).shiftedIndex))
	    	{
		        EntityBolt entityarrow = getEntity(world, player);

		        entityarrow.item = this.requiredItem(player);
		        
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

		        if (world.isRemote)
		        {
					Object[] toSend = {itemstack};
					PacketDispatcher.sendPacketToServer(Util.createPacket("CrossbowMod", 0, toSend));
		        }
		        else
		        {
		            itemstack.damageItem(1, player);
		            world.playSoundAtEntity(player, "cbowfire", 1.0F, 0.92F);
		            player.inventory.consumeInventoryItem(requiredItem(player).shiftedIndex);
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
    
    public abstract Item requiredItem(EntityLiving entityliving);
    
    public abstract String getSpriteSheetLoc();

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }

    @Override
    public void addInformation(ItemStack var1, List var2)
    {
    	if (Util.hasBasicScope(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentShortScope.getItemName() + ".name"));
    	}

    	if (Util.hasLongRangeScope(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentShortScope.getItemName() + ".name"));
    	}

    	if (Util.hasLightMech(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.mechanismLightAuto.getItemName() + ".name"));
    	}

    	if (Util.hasMediumMech(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.mechanismMediumAuto.getItemName() + ".name"));
    	}

    	if (Util.hasHeavyMech(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.mechanismHeavyAuto.getItemName() + ".name"));
    	}

    	if (Util.hasExplosiveAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentExplosive.getItemName() + ".name"));
    	}

    	if (Util.hasFlameAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentFire.getItemName() + ".name"));
    	}

    	if (Util.hasLavaAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentLava.getItemName() + ".name"));
    	}

    	if (Util.hasIceAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentIce.getItemName() + ".name"));
    	}
    	
    	if (Util.hasLightningAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentLightning.getItemName() + ".name"));
    	}
    	
    	if (Util.hasTorchAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentTorch.getItemName() + ".name"));
    	}
    	
    	if (Util.hasPoisonAttachment(var1))
    	{
            var2.add(LanguageRegistry.instance().getStringLocalization(Items.attachmentPoison.getItemName() + ".name"));
    	}
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(requiredItem(par3EntityPlayer).shiftedIndex))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
    	return getSpriteSheetLoc();
    }

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
}
