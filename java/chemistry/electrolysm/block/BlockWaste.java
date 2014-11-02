package chemistry.electrolysm.block;

import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.BlockFluid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Clarky158 on 02/11/2014.
 */
public class BlockWaste extends BlockFluid {


    public BlockWaste() {
        super(new FluidWaste(), Material.water, Names.Block.FLUID.WASTE);
    }
}
