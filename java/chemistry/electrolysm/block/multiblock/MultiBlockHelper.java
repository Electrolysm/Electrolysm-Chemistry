package chemistry.electrolysm.block.multiblock;

import electrolysm.api.items.Fetcher;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

/**
 * Created by Clarky158 on 29/10/2014.
 */
public class MultiBlockHelper {

    public static ItemStack blockSteel = Fetcher.getItem("steelBlock", 1);

    public Location getMasterBlock(List<Location> list){
        if(list != null) {
            int randInt = new Random().nextInt(list.size());
            Location loc = list.get(randInt);
            if(loc != null){
                return loc;
            } else {
                return getMasterBlock(list);
            }
        }
        return null;
    }

    public static boolean isPartOfMultiBlock(World world, int x, int y, int z){
        List<Pattern> list = getLoadedPatterns();
        for (int i = 0; i < list.size(); i++) {
            Pattern pattern = list.get(i);
            if(pattern.matchesWorld(world, x, y, z)) {
                return true;
            }
        }
        return false;
    }

    public static List<Pattern> getLoadedPatterns() {
        return PatternLoader.getLoadedPatterns();
    }
}
