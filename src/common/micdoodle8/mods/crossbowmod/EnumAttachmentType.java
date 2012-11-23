package micdoodle8.mods.crossbowmod;

public enum EnumAttachmentType 
{
	none("none", 0),
	longscope("longscope", 1), 
	shortscope("shortscope", 2), 
	lava("lava", 3), 
	ice("ice", 4), 
	poison("poison", 5), 
	torch("torch", 6), 
	lightning("lightning", 7), 
	explosive("explosive", 8);
	
	private final String name;
	private final int index;

    private EnumAttachmentType(String string, int index)
    {
        this.name = string;
        this.index = index;
    }

    public String getName()
    {
        return this.name;
    }

    public int getIndex()
    {
        return this.index;
    }
}
