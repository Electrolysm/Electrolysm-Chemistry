package chemistry.electrolysm.util;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
public class BlockMachineBase extends BlockBase implements ITileEntityProvider{


    public BlockMachineBase(Material mat, String name, float harness) {
        super(mat, name, harness);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }
}
