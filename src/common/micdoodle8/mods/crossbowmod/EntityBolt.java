package micdoodle8.mods.crossbowmod;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.*;

public abstract class EntityBolt extends Entity
{
    public float speed;
    public float slowdown;
    public float curvature;
    public float precision;
    public float hitBox;
    public int dmg;
    public Item item;
    public int ttlInGround;
    public int xTile;
    public int yTile;
    public int zTile;
    public int inTile;
    public int inData;
    public boolean inGround;
    public int arrowShake;
    public EntityLiving shooter;
    public int ticksInGround;
    public int ticksFlying;
    public boolean shotByPlayer;
    public boolean arrowCritical = false;
    public boolean hasFireAttachment = false;
    public boolean hasExplosiveAttachment = false;
    public boolean hasLavaAttachment = false;
    public boolean hasIceAttachment = false;
    public boolean hasLightningAttachment = false;
    public boolean hasTorchAttachment = false;
    public boolean hasPoisonAttachment = false;

    public EntityBolt(World world)
    {
        super(world);
    }

    public EntityBolt(World world, double d, double d1, double d2)
    {
        this(world);
        setPosition(d, d1, d2);
    }

    public EntityBolt(World world, EntityLiving entityliving, float f)
    {
        this(world);
        shooter = entityliving;
        shotByPlayer = entityliving instanceof EntityPlayer;
        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setArrowHeading(this.motionX, this.motionY, this.motionZ, f * 1.5F);
    }

    @Override
    protected void entityInit()
    {
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inGround = false;
        arrowShake = 0;
        ticksFlying = 0;
        setSize(0.5F, 0.5F);
        yOffset = 0.0F;
        hitBox = 0.3F;
        slowdown = 0.99F;
        curvature = 0.01F;
        dmg = getDamage();
        precision = 1.0F;
        ttlInGround = 1200;
    }

    @Override
    public void setDead()
    {
        shooter = null;
        super.setDead();
    }

    public void setArrowHeading(double par1, double par3, double par5, float par7)
    {
        float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)var9;
        par3 /= (double)var9;
        par5 /= (double)var9;
        par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)0;
        par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)0;
        par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)0;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)var10) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(double d, double d1, double d2)
    {
        motionX = d;
        motionY = d1;
        motionZ = d2;
        if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(d * d + d2 * d2);
            prevRotationYaw = rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
            prevRotationPitch = rotationPitch = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
        }
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9)
    {
        this.setPosition(par1, par3, par5);
        this.setRotation(par7, par8);
    }
    
    public abstract float getSpeed();
    
    public abstract int getDamage();

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
            prevRotationYaw = rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
            prevRotationPitch = rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D);
        }
        if(arrowShake > 0)
        {
            arrowShake--;
        }
        if(inGround)
        {
            int i = worldObj.getBlockId(xTile, yTile, zTile);
            int j = worldObj.getBlockMetadata(xTile, yTile, zTile);
            if(i != inTile || j != inData)
            {
                inGround = false;
                motionX *= rand.nextFloat() * 0.2F;
                motionY *= rand.nextFloat() * 0.2F;
                motionZ *= rand.nextFloat() * 0.2F;
                ticksInGround = 0;
                ticksFlying = 0;
            } else
            {
                ticksInGround++;
                tickInGround();
                if(ticksInGround == ttlInGround)
                {
                	setDead();
                }
                return;
            }
        } else
        {
            ticksFlying++;
        }
        tickFlying();
        Vec3 vec3d = Vec3.createVectorHelper(posX, posY, posZ);
        Vec3 vec3d1 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks(vec3d, vec3d1);
        vec3d = Vec3.createVectorHelper(posX, posY, posZ);
        vec3d1 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
        if(movingobjectposition != null)
        {
            vec3d1 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }
        Entity entity = null;
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        for(int k = 0; k < list.size(); k++)
        {
            Entity entity2 = (Entity)list.get(k);
            if(!canBeShot(entity2))
            {
                continue;
            }
            float f3 = hitBox;
            AxisAlignedBB axisalignedbb = entity2.boundingBox.expand(f3, f3, f3);
            MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3d, vec3d1);
            if(movingobjectposition1 == null)
            {
                continue;
            }
            double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);
            if(d1 < d || d == 0.0D)
            {
                entity = entity2;
                d = d1;
            }
        }

        if(entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if(movingobjectposition != null && (entity != shooter || ticksFlying > 2) && (onHit()))
        {
            Entity entity1 = movingobjectposition.entityHit;
            if(entity1 != null)
            {
            	if (!worldObj.isRemote)
            	{
                    if(onHitTarget(entity1) && hasTorchAttachment == false)
                    {
                        if((entity1 instanceof EntityLiving) && !(entity1 instanceof EntityPlayer))
                        {
                            ++((EntityLiving)entity1).arrowHitTempCounter;
                        }
                        
                        entity1.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)shooter), this.arrowCritical ? dmg * 2 : dmg);
                        setDead();
                    }
            	}
            }
            else
            {
            	xTile = movingobjectposition.blockX;
                yTile = movingobjectposition.blockY;
                zTile = movingobjectposition.blockZ;
                inTile = worldObj.getBlockId(xTile, yTile, zTile);
                inData = worldObj.getBlockMetadata(xTile, yTile, zTile);
                Block block = Block.blocksList[inTile];
                if (block != null && !(block instanceof BlockFlower))
                {
                    if(onHitBlock(movingobjectposition))
                    {
                        motionX = (float)(movingobjectposition.hitVec.xCoord - posX);
                        motionY = (float)(movingobjectposition.hitVec.yCoord - posY);
                        motionZ = (float)(movingobjectposition.hitVec.zCoord - posZ);
                        float f2 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
                        posX -= (motionX / (double)f2) * 0.05000000074505806D;
                        posY -= (motionY / (double)f2) * 0.05000000074505806D;
                        posZ -= (motionZ / (double)f2) * 0.05000000074505806D;
                        inGround = true;
                        arrowShake = 7;
                        this.arrowCritical = false;
                    }
                }
            }
        }
        if (movingobjectposition != null && !worldObj.isRemote)
        {
            Entity entity1 = movingobjectposition.entityHit;
            if (entity1 != null && entity1 instanceof EntityLiving && entity1 != shooter)
            {
                if (hasExplosiveAttachment && ((EntityLiving)entity1).arrowHitTempCounter < 10)
                {
                	this.worldObj.createExplosion(this, (int)Math.floor(((EntityLiving)entity1).posX), (int)((EntityLiving)entity1).posY, (int)Math.floor(((EntityLiving)entity1).posZ), 1, true);
                }
                
                if (hasIceAttachment)
                {
                	((EntityLiving)entity1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 280, 3));
                }
                
                if (hasPoisonAttachment)
                {
                	((EntityLiving)entity1).addPotionEffect(new PotionEffect(Potion.poison.id, 280, 3));
                }
                
                if (hasLightningAttachment)
                {
                	this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, entity1.posX, entity1.posY, entity1.posZ));
                    this.setDead();
                }
            }
        }
        
        FMLLog.info("" + this.inGround);

            posX += motionX;
            posZ += motionZ;
            posY += motionY;
            handleMotionUpdate();
        float f1 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
        for(rotationPitch = (float)((Math.atan2(motionY, f1) * 180D) / 3.1415927410125732D); rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
        for(; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
        for(; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
        for(; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
        rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
        rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
        setPosition(posX, posY, posZ);
    }

    public void handleMotionUpdate()
    {
            float f = slowdown;
            if(handleWaterMovement())
            {
                for(int i = 0; i < 4; i++)
                {
                    float f1 = 0.25F;
                    worldObj.spawnParticle("bubble", posX - motionX * (double)f1, posY - motionY * (double)f1, posZ - motionZ * (double)f1, motionX, motionY, motionZ);
                }

                f *= 0.8F;
            }
            motionX *= f;
            motionY *= f;
            motionZ *= f;
            motionY -= curvature;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setShort("xTile", (short)xTile);
        nbttagcompound.setShort("yTile", (short)yTile);
        nbttagcompound.setShort("zTile", (short)zTile);
        nbttagcompound.setByte("inTile", (byte)inTile);
        nbttagcompound.setByte("inData", (byte)inData);
        nbttagcompound.setByte("shake", (byte)arrowShake);
        nbttagcompound.setByte("inGround", (byte)(inGround ? 1 : 0));
        nbttagcompound.setBoolean("player", shotByPlayer);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        xTile = nbttagcompound.getShort("xTile");
        yTile = nbttagcompound.getShort("yTile");
        zTile = nbttagcompound.getShort("zTile");
        inTile = nbttagcompound.getByte("inTile") & 0xff;
        inData = nbttagcompound.getByte("inData") & 0xff;
        arrowShake = nbttagcompound.getByte("shake") & 0xff;
        inGround = nbttagcompound.getByte("inGround") == 1;
        shotByPlayer = nbttagcompound.getBoolean("player");
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if(item == null || worldObj.isRemote || entityplayer.capabilities.isCreativeMode)
        {
            return;
        }
        
        if(inGround && shotByPlayer && arrowShake <= 0 && entityplayer.inventory.addItemStackToInventory(new ItemStack(this.item)))
        {
            worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.onItemPickup(this, 1);
            setDead();
        }
    }

    public boolean canBeShot(Entity entity)
    {
        return entity.canBeCollidedWith() && (entity != shooter || ticksFlying >= 2) && (!(entity instanceof EntityLiving) || ((EntityLiving)entity).deathTime <= 0);
    }

    public boolean onHit()
    {
        return true;
    }

    public boolean onHitTarget(Entity entity)
    {
        worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.7F));
        
        if (!(entity instanceof EntityLiving))
        {
        	return true;
        }
        
        EntityLiving entityliving = (EntityLiving) entity;
        
        if (hasFireAttachment || hasLavaAttachment)
        {
        	entityliving.setFire(100);
        }
        
        return true;
    }

    public void tickFlying()
    {
    }

    public void tickInGround()
    {
        if (hasLightningAttachment)
        {
        	this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));
            this.setDead();
        }
        
        if (hasExplosiveAttachment)
        {
        	if (rand.nextInt(2) == 0)
        		this.worldObj.spawnParticle("explode", this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ, 0D, 0.2D, 0D);
        	
            if (ticksInGround >= 40)
        	{
            	this.worldObj.createExplosion(this, (int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), 4, true);
                this.setDead();
        	}
        }
    	
    	if (hasFireAttachment)
        {
        	this.worldObj.setBlockWithNotify((int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), Block.fire.blockID);
            this.setDead();
        }
        
        if (hasLavaAttachment)
        {
        	this.worldObj.setBlockWithNotify((int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), Block.lavaMoving.blockID);
            this.setDead();
        }
        
        if (hasTorchAttachment)
        {
        	if (this.worldObj.getBlockId((int)Math.floor(this.posX), (int)Math.floor(this.posY), (int)Math.floor(this.posZ)) == 0)
        	{
	        	this.worldObj.setBlockWithNotify((int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), Block.torchWood.blockID);
	            this.setDead();
        	}
        	else
        	{
        		this.setDead();
        	}
        }
    }

    public boolean onHitBlock(MovingObjectPosition movingobjectposition)
    {
        return onHitBlock();
    }

    public boolean onHitBlock()
    {
        worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.7F));
        return true;
    }

    @Override
    public float getShadowSize()
    {
        return 0.0F;
    }
}
