package chemistry.electrolysm.block;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import chemistry.electrolysm.util.BlockModelBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 16/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class BlockMassSpec extends BlockModelBase implements ITileEntityProvider{

    public BlockMassSpec() {
        super(Material.iron, Names.Block.MASS_SPEC, 4F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityMassSpec();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
                                    float sideX, float sideY, float sideZ) {
        if(!player.isSneaking()){
            player.openGui(Chemistry.instance, Referance.GUI.GUI_MASS_SPEC_ID, world, x, y, z);
            return true;
        }
        return false;
    }
}
