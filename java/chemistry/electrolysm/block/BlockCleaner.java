package chemistry.electrolysm.block;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.block.te.TileEntityCleaner;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import chemistry.electrolysm.util.BlockModelBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
                                    float sideX, float sideY, float sideZ) {
        if(!player.isSneaking()){
            player.openGui(Chemistry.instance, Referance.GUI.GUI_CLEANER_ID, world, x, y, z);
            return true;
        }
        return false;
    }
}
