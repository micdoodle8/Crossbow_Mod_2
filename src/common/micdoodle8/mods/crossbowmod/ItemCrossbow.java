package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.network.PacketDispatcher;

public class ItemCrossbow extends Item
{
	private int shootTime;
	private boolean mouseHeld;
	public int reloadStage;
	protected boolean isBoltLoaded;
	public int reloadingTime;
	public int prevReloadingTime;
	public int shootDelay;
	
	public ItemCrossbow(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(getCrossbowMaxDamage());
		this.isBoltLoaded = false;
        this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
		if (!world.isRemote)
		{
	        shootTime++;
		}
        
		EntityPlayer entityplayer = (EntityPlayer) entity;
		
		if (!world.isRemote)
		{
			this.prevReloadingTime = this.reloadingTime;
			
			if (this.reloadingTime > 0)
			{
				this.reloadingTime -= 5;
			}
			
			if (this.reloadingTime < 0)
			{
				this.reloadingTime = 0;
			}
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
		
        if (entityplayer.inventory.getCurrentItem() == itemstack)
        {
        	if (!isBoltLoaded)
        	{
        		reloadStage = 0;
        		isBoltLoaded = true;
        		this.reloadingTime = getReloadTime() * 2;
        	}
	            
            if (mouseHeld && (Util.hasHeavyMech(itemstack) || Util.hasMediumMech(itemstack) || Util.hasLightMech(itemstack)))
            {
            	shoot(itemstack, world, entityplayer, i);
            }
        }
		
        try
        {
    		mouseClicked();
        }
        catch(NoSuchMethodError e)
        {
        }
	}
	
	@SideOnly(Side.CLIENT)
	public void mouseClicked()
	{
		if (ModLoader.getMinecraftInstance().gameSettings.keyBindUseItem.pressed)
        {
        	mouseHeld = true;
    		sendMouseHeldPacket(true);
        }
        else
        {
        	mouseHeld = false;
    		sendMouseHeldPacket(false);
        }
	}
	
	private void shoot(ItemStack itemstack, World world, EntityPlayer entityplayer, int par4)
    {
    	boolean flag = entityplayer.capabilities.isCreativeMode;
    	
    	if (Util.hasLightMech(itemstack))
    	{
    		shootDelay = 24;
    	}
    	else if (Util.hasMediumMech(itemstack))
    	{
    		shootDelay = 18;
    	}
    	else if (Util.hasHeavyMech(itemstack))
    	{
    		shootDelay = 12;
    	}
    	
    	if (requiredItem(entityplayer) == null)
    	{
    		return;
    	}
    	
        if (shootTime % shootDelay == 0 && (flag || entityplayer.inventory.hasItem(requiredItem(entityplayer).shiftedIndex)))
        {
	        EntityBolt entityarrow = getEntity(world, entityplayer);

	        entityarrow.item = this.requiredItem(entityplayer);
	        
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

            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "cbowfire", 1.0F, 1.0F);
            entityplayer.inventory.consumeInventoryItem(requiredItem(entityplayer).shiftedIndex);

            if (!world.isRemote)
	        {
	        	world.spawnEntityInWorld(entityarrow);
	        	
	            if (ConfigManager.useReloadFeature)
	            {
	            	isBoltLoaded = false;
	            }
	        }
	    }
    }
    
    public EntityBolt getEntity(World world, EntityLiving entityliving)
    {
    	return null;
    }
    
    public int getCrossbowMaxDamage()
    {
    	return 0;
    }
    
    public int getReloadTime()
    {
    	return 350;
    }
    
    public Item requiredItem(EntityLiving entityliving)
    {
    	return null;
    }
    
    public String getSpriteSheetLoc()
    {
    	return "";
    }
    
    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int par4)
    { 	
    	boolean flag = entityplayer.capabilities.isCreativeMode;
        boolean flag2 = Util.hasLightMech(itemstack) || Util.hasMediumMech(itemstack) || Util.hasHeavyMech(itemstack);

        if (!flag2 && (flag || entityplayer.inventory.hasItem(requiredItem(entityplayer).shiftedIndex)))
	    {
        	if ((this.reloadingTime == 0 && isBoltLoaded) || !ConfigManager.useReloadFeature)
        	{
		        EntityBolt entityarrow = getEntity(world, entityplayer);

		        entityarrow.item = this.requiredItem(entityplayer);
	            
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

		        itemstack.damageItem(1, entityplayer);
	            world.playSoundAtEntity(entityplayer, "cbowfire", 1.0F, 1.0F);
	            entityplayer.inventory.consumeInventoryItem(requiredItem(entityplayer).shiftedIndex);

	            if (!world.isRemote)
		        {
		        	world.spawnEntityInWorld(entityarrow);
		        	
		            if (ConfigManager.useReloadFeature)
		            {
		            	isBoltLoaded = false;
		            }
		        }
        	}
	    }
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.rare;
    }
    
    public void addInformation(ItemStack var1, List var2)
    {
    	if (Util.hasBasicScope(var1))
    	{
            var2.add("Basic Scope");
    	}

    	if (Util.hasLongRangeScope(var1))
    	{
            var2.add("Long-Range Scope");
    	}

    	if (Util.hasLightMech(var1))
    	{
            var2.add("Light Mechanism");
    	}

    	if (Util.hasMediumMech(var1))
    	{
            var2.add("Medium Mechanism");
    	}

    	if (Util.hasHeavyMech(var1))
    	{
            var2.add("Heavy Mechanism");
    	}

    	if (Util.hasExplosiveAttachment(var1))
    	{
    		var2.add("Explosive Attachment");
    	}

    	if (Util.hasFlameAttachment(var1))
    	{
    		var2.add("Flame Attachment");
    	}

    	if (Util.hasLavaAttachment(var1))
    	{
    		var2.add("Lava Attachment");
    	}

    	if (Util.hasIceAttachment(var1))
    	{
    		var2.add("Frost Attachment");
    	}
    	
    	if (Util.hasLightningAttachment(var1))
    	{
    		var2.add("Lightning Attachment");
    	}
    	
    	if (Util.hasTorchAttachment(var1))
    	{
    		var2.add("Torch Attachment");
    	}
    	
    	if (Util.hasPoisonAttachment(var1))
    	{
    		var2.add("Poison Attachment");
    	}
    }

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(requiredItem(par3EntityPlayer).shiftedIndex))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
    	return getSpriteSheetLoc();
    }

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
	
    @SideOnly(Side.CLIENT)
	public void sendMouseHeldPacket(boolean b)
	{
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        DataOutputStream data = new DataOutputStream(bytes);
//        try
//        {
//            data.writeBoolean(Boolean.valueOf(b));
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        
//        Packet250CustomPayload packet = new Packet250CustomPayload();
//        packet.channel = "CrossbowMod";
//        packet.data = bytes.toByteArray();
//        packet.length = packet.data.length;
//        
//        ModLoader.sendPacket(packet);
	}
}
