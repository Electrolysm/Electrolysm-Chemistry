package chemistry.electrolysm.init;

import chemistry.electrolysm.block.BlockBunsenBurner;
import chemistry.electrolysm.block.BlockMassSpec;
import chemistry.electrolysm.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by Clarky158 on 15/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class ModBlocks {

    public static Block bunsenBurner = new BlockBunsenBurner();
    public static Block massSpec = new BlockMassSpec();

    public static void init(){
        GameRegistry.registerBlock(bunsenBurner, Names.Block.BUNSEN_BURNER);
        GameRegistry.registerBlock(massSpec, Names.Block.MASS_SPEC);
    }
}
