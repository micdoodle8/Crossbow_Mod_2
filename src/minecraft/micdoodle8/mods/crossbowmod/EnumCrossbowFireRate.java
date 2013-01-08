package micdoodle8.mods.crossbowmod;

public enum EnumCrossbowFireRate
{
	none("none", 0),
	light("light", 1),
	medium("medium", 2),
	heavy("heavy", 3);

	private final String name;
	private final int index;

    private EnumCrossbowFireRate(String string, int index)
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
