package chemistry.electrolysm.block.multiblock;

import net.minecraft.world.World;

/**
 * Created by Clarky158 on 29/10/2014.
 */
public class Location
{
    public World world;
    int x, y, z;

    public Location(World w, int xx, int yy, int zz)
    {
        world = w;
        x = xx;
        y = yy;
        z = zz;
    }

    public Location(int xx, int yy, int zz){
        this(null, xx, yy, zz);
    }

}
