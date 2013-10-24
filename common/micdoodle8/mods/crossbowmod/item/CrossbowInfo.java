package micdoodle8.mods.crossbowmod.item;

public class CrossbowInfo
{
    private EnumAttachmentType attachment;
    private EnumCrossbowMaterial material;
    private EnumCrossbowFireRate fireRate;
    
    public CrossbowInfo(EnumAttachmentType attachment, EnumCrossbowMaterial material, EnumCrossbowFireRate fireRate)
    {
        this.attachment = attachment;
        this.material = material;
        this.fireRate = fireRate;
    }

    public EnumAttachmentType getAttachment()
    {
        return attachment;
    }
    
    public void setAttachment(EnumAttachmentType attachment)
    {
        this.attachment = attachment;
    }
    
    public EnumCrossbowMaterial getMaterial()
    {
        return material;
    }
    
    public void setMaterial(EnumCrossbowMaterial material)
    {
        this.material = material;
    }
    
    public EnumCrossbowFireRate getFireRate()
    {
        return fireRate;
    }
    
    public void setFireRate(EnumCrossbowFireRate fireRate)
    {
        this.fireRate = fireRate;
    }
}
