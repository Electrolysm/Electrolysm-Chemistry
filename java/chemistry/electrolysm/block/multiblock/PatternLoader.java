package chemistry.electrolysm.block.multiblock;

import chemistry.electrolysm.init.ModBlocks;
import net.minecraft.block.Block;

import java.util.*;

/**
 * Created by Clarky158 on 29/10/2014.
 */
public class PatternLoader
{
    static List<Pattern> list = new ArrayList<Pattern>();

    public static List<Pattern> getLoadedPatterns(){
        //System.out.println(list);
        //return list;
        List<Pattern> list1 = new ArrayList<Pattern>();
        Pattern pattern = new Pattern(1, 1, 3);
        pattern.bind(0, 0, 0, ModBlocks.atomicCompressor);
        pattern.bind(0, 0, 1, Block.getBlockFromItem(MultiBlockHelper.blockSteel.getItem()));
        pattern.bind(0, 0, 2, Block.getBlockFromItem(MultiBlockHelper.blockSteel.getItem()));
        list.add(pattern);
        return list;
    }

    public static void addPatterns(){
        addCompressorPattern();
    }

    public static void addCompressorPattern(){
        int xV = 2;
        int yV = 2;
        int hV = 4;
        Pattern pattern = new Pattern(xV, yV, hV);
        pattern.bind(0, 0, 0, ModBlocks.atomicCompressor);
        pattern.bind(1, 0, 0, ModBlocks.atomicCompressor);
        pattern.bind(0, 1, 0, ModBlocks.atomicCompressor);
        pattern.bind(1, 1, 0, ModBlocks.atomicCompressor);

        for(int x = 0; x < xV; x++){
            for(int y = 1; y < yV; y++){
                for(int h = 0; h < hV; h++){
                    pattern.bind(x, y, h, Block.getBlockFromItem(MultiBlockHelper.blockSteel.getItem()));
                }
            }
        }
        list.add(pattern);
    }
}
