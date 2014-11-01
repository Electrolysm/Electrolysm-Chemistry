package chemistry.electrolysm.block;

import chemistry.electrolysm.block.te.TileEntityCleaner;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.BlockModelBase;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 01/11/2014.
 */
public class BlockCleaner extends BlockModelBase
{

    public BlockCleaner() {
        super(Material.iron, Names.Block.CLEANER, 5F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityCleaner();
    }
}
