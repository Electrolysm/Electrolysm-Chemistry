package chemistry.electrolysm.block;

import chemistry.electrolysm.block.te.TileEntityAtomicCompressor;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.BlockMachineBase;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 07/09/2014.
 */
public class BlockAtomicCompressor extends BlockMachineBase {

    public BlockAtomicCompressor() {
        super(Material.iron, Names.Block.ATOMIC_COMPRESSOR, 1.6F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAtomicCompressor();
    }
}
