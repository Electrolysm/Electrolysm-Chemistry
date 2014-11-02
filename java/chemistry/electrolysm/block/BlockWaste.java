package chemistry.electrolysm.block;

import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.BlockFluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Clarky158 on 02/11/2014.
 */
public class BlockWaste extends BlockFluid {

    public static IIcon flow;
    public static IIcon still;

    public BlockWaste() {
        super(new FluidWaste(), Material.water, Names.Block.FLUID.WASTE);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        flow = reg.registerIcon("chemistry:waste_flow");
        still = reg.registerIcon("chemistry:waste_still");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side <= 1)
        {
            return this.still;
        }
        else
        {
            return this.flow;
        }
    }
}
