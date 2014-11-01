package chemistry.electrolysm.block.multiblock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Clarky158 on 29/10/2014.
 */
public class Pattern
{
    public int xSize;
    public int ySize;
    public int height;
    public HashMap<Location, Block> map = new HashMap<Location, Block>();

    public Pattern(int x, int y, int h){
        xSize = x;
        ySize = y;
        height = h;
    }

    public void bind(int x, int y, int h, Block block){
        if(x < xSize && y < ySize && h < height){
            map.put(new Location(x, h, y), block);
        }
    }

    public boolean matchesWorld(World world, int x, int y, int z){
        List<Boolean> checkList = new ArrayList<Boolean>();
        for(int xx = 0; xx < xSize; xx++){
            for(int yy = 0; yy < height; yy++){
                for(int zz = 0; zz < ySize; zz++){
                    //System.out.println(xx + x + " : " + yy + y + " : " + zz + z);
                    //System.out.println((map.get(new Location(world, xx + x, yy + y, zz + z))));
                    if((map.get(new Location(world, xx, yy, zz))) == (world.getBlock(x + xx, y + yy, z + zz))){
                        checkList.add(true);
                        System.out.println("true");
                    } else {
                        checkList.add(false);
                    }
                }
            }
        }
        if(checkList.contains(false)){
            return false;
        } else {
            return true;
        }
    }

}
