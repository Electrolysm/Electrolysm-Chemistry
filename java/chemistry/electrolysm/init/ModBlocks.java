package chemistry.electrolysm.init;

import chemistry.electrolysm.block.*;
import chemistry.electrolysm.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

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
    public static Block bbGas = new BlockBBGas();
    public static Block bbElectric = new BlockBBElectric();
    public static Block massSpec = new BlockMassSpec();
    public static BlockPhosphorusTorch phosphorusTorch =  new BlockPhosphorusTorch();
    public static Block atomicCompressor = new BlockAtomicCompressor();
    public static Block cleaner = new BlockCleaner();

    public static Block waste = new BlockWaste();
    public static Fluid fluidWaste = new FluidWaste();

    public static void init(){
        GameRegistry.registerBlock(bunsenBurner, Names.Block.BUNSEN_BURNER);
        GameRegistry.registerBlock(bbGas, Names.Block.BB_GAS);
        GameRegistry.registerBlock(bbElectric, Names.Block.BB_ELECTRIC);
        GameRegistry.registerBlock(massSpec, Names.Block.MASS_SPEC);
        GameRegistry.registerBlock(phosphorusTorch, Names.Block.PHOSPHORUS_TORCH);
        GameRegistry.registerBlock(atomicCompressor, Names.Block.ATOMIC_COMPRESSOR);
        GameRegistry.registerBlock(cleaner, Names.Block.CLEANER);
        GameRegistry.registerBlock(waste, Names.Block.FLUID.WASTE);
    }
}
