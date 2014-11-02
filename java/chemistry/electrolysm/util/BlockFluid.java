package chemistry.electrolysm.util;

import chemistry.electrolysm.Chemistry;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Clarky158 on 02/11/2014.
 */
public class BlockFluid extends BlockFluidClassic {

    public BlockFluid(Fluid fluid, Material material, String name) {
        super(fluid, material);
        this.setBlockName(name);
        this.setCreativeTab(Chemistry.creativeTab);
    }
}
