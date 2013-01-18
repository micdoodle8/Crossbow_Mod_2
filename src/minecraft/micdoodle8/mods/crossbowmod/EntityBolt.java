package micdoodle8.mods.crossbowmod;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityBolt extends Entity
{
    public float speed;
    public float slowdown;
    public float curvature;
    public float precision;
    public float hitBox;
    public int dmg;
    public int item = -1;
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
        this.setPosition(d, d1, d2);
    }

    public EntityBolt(World world, EntityLiving entityliving, float f)
    {
        this(world);
        this.shooter = entityliving;
        this.shotByPlayer = entityliving instanceof EntityPlayer;
        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setArrowHeading(this.motionX, this.motionY, this.motionZ, f * 1.5F);
    }

    @Override
    protected void entityInit()
    {
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.arrowShake = 0;
        this.ticksFlying = 0;
        this.setSize(0.5F, 0.5F);
        this.yOffset = 0.0F;
        this.hitBox = 0.3F;
        this.slowdown = 0.99F;
        this.curvature = 0.01F;
        this.dmg = this.getDamage();
        this.precision = 1.0F;
        this.ttlInGround = 1200;
    }

    @Override
    public void setDead()
    {
        this.shooter = null;
        super.setDead();
    }

    public void setArrowHeading(double par1, double par3, double par5, float par7)
    {
        float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= var9;
        par3 /= var9;
        par5 /= var9;
        par1 += this.rand.nextGaussian() * 0.007499999832361937D * 0;
        par3 += this.rand.nextGaussian() * 0.007499999832361937D * 0;
        par5 += this.rand.nextGaussian() * 0.007499999832361937D * 0;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public void setVelocity(double d, double d1, double d2)
    {
        this.motionX = d;
        this.motionY = d1;
        this.motionZ = d2;
        if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(d * d + d2 * d2);
            this.prevRotationYaw = this.rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
            this.prevRotationPitch = this.rotationPitch = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
        }
    }

    @Override
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
        if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)((Math.atan2(this.motionX, this.motionZ) * 180D) / 3.1415927410125732D);
            this.prevRotationPitch = this.rotationPitch = (float)((Math.atan2(this.motionY, f) * 180D) / 3.1415927410125732D);
        }
        if(this.arrowShake > 0)
        {
            this.arrowShake--;
        }
        if(this.inGround)
        {
            int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            int j = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if(i != this.inTile || j != this.inData)
            {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2F;
                this.motionY *= this.rand.nextFloat() * 0.2F;
                this.motionZ *= this.rand.nextFloat() * 0.2F;
                this.ticksInGround = 0;
                this.ticksFlying = 0;
            } else
            {
                this.ticksInGround++;
                this.tickInGround();
                if(this.ticksInGround == this.ttlInGround)
                {
                	this.setDead();
                }
                return;
            }
        } else
        {
            this.ticksFlying++;
        }
        this.tickFlying();
        Vec3 vec3d = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        Vec3 vec3d1 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3d, vec3d1);
        vec3d = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        vec3d1 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if(movingobjectposition != null)
        {
            vec3d1 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }
        Entity entity = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        for(int k = 0; k < list.size(); k++)
        {
            Entity entity2 = (Entity)list.get(k);
            if(!this.canBeShot(entity2))
            {
                continue;
            }
            float f3 = this.hitBox;
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
        if(movingobjectposition != null && (entity != this.shooter || this.ticksFlying > 2) && (this.onHit()))
        {
            Entity entity1 = movingobjectposition.entityHit;
            if(entity1 != null)
            {
            	if (!this.worldObj.isRemote)
            	{
                    if(this.onHitTarget(entity1) && this.hasTorchAttachment == false)
                    {
                        if((entity1 instanceof EntityLiving) && !(entity1 instanceof EntityPlayer))
                        {
                            ++((EntityLiving)entity1).arrowHitTimer;
                        }

                        entity1.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.shooter), this.arrowCritical ? this.dmg * 2 : this.dmg);
                        this.setDead();
                    }
            	}
            }
            else
            {
            	this.xTile = movingobjectposition.blockX;
                this.yTile = movingobjectposition.blockY;
                this.zTile = movingobjectposition.blockZ;
                this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
                this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                Block block = Block.blocksList[this.inTile];
                if (block != null && !(block instanceof BlockFlower))
                {
                    if(this.onHitBlock(movingobjectposition))
                    {
                        this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
                        this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
                        this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
                        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                        this.posX -= (this.motionX / f2) * 0.05000000074505806D;
                        this.posY -= (this.motionY / f2) * 0.05000000074505806D;
                        this.posZ -= (this.motionZ / f2) * 0.05000000074505806D;
                        this.inGround = true;
                        this.arrowShake = 7;
                        this.arrowCritical = false;
                    }
                }
            }
        }
        if (movingobjectposition != null && !this.worldObj.isRemote)
        {
            Entity entity1 = movingobjectposition.entityHit;
            if (entity1 != null && entity1 instanceof EntityLiving && entity1 != this.shooter)
            {
                if (this.hasExplosiveAttachment && ((EntityLiving)entity1).arrowHitTimer < 10)
                {
                	this.worldObj.createExplosion(this, (int)Math.floor(((EntityLiving)entity1).posX), (int)((EntityLiving)entity1).posY, (int)Math.floor(((EntityLiving)entity1).posZ), 1, true);
                }

                if (this.hasIceAttachment)
                {
                	((EntityLiving)entity1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 280, 3));
                }

                if (this.hasPoisonAttachment)
                {
                	((EntityLiving)entity1).addPotionEffect(new PotionEffect(Potion.poison.id, 280, 3));
                }

                if (this.hasLightningAttachment)
                {
                	this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, entity1.posX, entity1.posY, entity1.posZ));
                    this.setDead();
                }
            }
        }

        this.posX += this.motionX;
        this.posZ += this.motionZ;
        this.posY += this.motionY;
        this.handleMotionUpdate();
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)((Math.atan2(this.motionX, this.motionZ) * 180D) / 3.1415927410125732D);
        for(this.rotationPitch = (float)((Math.atan2(this.motionY, f1) * 180D) / 3.1415927410125732D); this.rotationPitch - this.prevRotationPitch < -180F; this.prevRotationPitch -= 360F) { }
        for(; this.rotationPitch - this.prevRotationPitch >= 180F; this.prevRotationPitch += 360F) { }
        for(; this.rotationYaw - this.prevRotationYaw < -180F; this.prevRotationYaw -= 360F) { }
        for(; this.rotationYaw - this.prevRotationYaw >= 180F; this.prevRotationYaw += 360F) { }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public void handleMotionUpdate()
    {
            float f = this.slowdown;
            if(this.handleWaterMovement())
            {
                for(int i = 0; i < 4; i++)
                {
                    float f1 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f1, this.posY - this.motionY * f1, this.posZ - this.motionZ * f1, this.motionX, this.motionY, this.motionZ);
                }

                f *= 0.8F;
            }
            this.motionX *= f;
            this.motionY *= f;
            this.motionZ *= f;
            this.motionY -= this.curvature;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setShort("xTile", (short)this.xTile);
        nbttagcompound.setShort("yTile", (short)this.yTile);
        nbttagcompound.setShort("zTile", (short)this.zTile);
        nbttagcompound.setByte("inTile", (byte)this.inTile);
        nbttagcompound.setByte("inData", (byte)this.inData);
        nbttagcompound.setByte("shake", (byte)this.arrowShake);
        nbttagcompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        nbttagcompound.setBoolean("player", this.shotByPlayer);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = nbttagcompound.getByte("inTile") & 0xff;
        this.inData = nbttagcompound.getByte("inData") & 0xff;
        this.arrowShake = nbttagcompound.getByte("shake") & 0xff;
        this.inGround = nbttagcompound.getByte("inGround") == 1;
        this.shotByPlayer = nbttagcompound.getBoolean("player");
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if(this.worldObj.isRemote || entityplayer.capabilities.isCreativeMode)
        {
        	FMLLog.info("daonsfpansfpansf");
            return;
        }

        if(this.inGround && this.shotByPlayer && this.arrowShake <= 0 && entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.attachmentLimbBolt, 1, this.item)))
        {
            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.onItemPickup(this, 1);
            this.setDead();
        }
    }

    public boolean canBeShot(Entity entity)
    {
        return entity.canBeCollidedWith() && (entity != this.shooter || this.ticksFlying >= 2) && (!(entity instanceof EntityLiving) || ((EntityLiving)entity).deathTime <= 0);
    }

    public boolean onHit()
    {
        return true;
    }

    public boolean onHitTarget(Entity entity)
    {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.7F));

        if (!(entity instanceof EntityLiving))
        {
        	return true;
        }

        EntityLiving entityliving = (EntityLiving) entity;

        if (this.hasFireAttachment || this.hasLavaAttachment)
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
        if (this.hasLightningAttachment)
        {
        	this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));
            this.setDead();
        }

        if (this.hasExplosiveAttachment)
        {
        	if (this.rand.nextInt(2) == 0)
        		this.worldObj.spawnParticle("explode", this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ, 0D, 0.2D, 0D);

            if (this.ticksInGround >= 40)
        	{
            	this.worldObj.createExplosion(this, (int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), 4, true);
                this.setDead();
        	}
        }

    	if (this.hasFireAttachment)
        {
        	this.worldObj.setBlockWithNotify((int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), Block.fire.blockID);
            this.setDead();
        }

        if (this.hasLavaAttachment)
        {
        	this.worldObj.setBlockWithNotify((int)Math.floor(this.posX), (int)this.posY, (int)Math.floor(this.posZ), Block.lavaMoving.blockID);
            this.setDead();
        }

        if (this.hasTorchAttachment)
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
        return this.onHitBlock();
    }

    public boolean onHitBlock()
    {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.7F));
        return true;
    }

    @Override
    public float getShadowSize()
    {
        return 0.0F;
    }
}
