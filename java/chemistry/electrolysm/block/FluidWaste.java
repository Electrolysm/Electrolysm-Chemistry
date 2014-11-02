package chemistry.electrolysm.block;

import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Clarky158 on 02/11/2014.
 */
public class FluidWaste extends Fluid {
    public FluidWaste() {
        super("fluidWaste");
        FluidRegistry.registerFluid(this);
    }

    @Override
    public IIcon getStillIcon() {
        return BlockWaste.still;
    }

    @Override
    public IIcon getFlowingIcon() {
        return BlockWaste.flow;
    }
}
