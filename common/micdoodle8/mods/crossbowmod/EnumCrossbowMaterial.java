package micdoodle8.mods.crossbowmod;

public enum EnumCrossbowMaterial
{
	wooden("wooden", 0),
	stone("stone", 1),
	iron("iron", 2),
	gold("gold", 3),
	diamond("diamond", 4);

	private final String name;
	private final int index;

    private EnumCrossbowMaterial(String string, int index)
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
