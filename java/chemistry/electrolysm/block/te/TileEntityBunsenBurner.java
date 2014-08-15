package chemistry.electrolysm.block.te;

import net.minecraft.tileentity.TileEntity;

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
public class TileEntityBunsenBurner extends TileEntity {

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public boolean hasTestTube() {
        return false;
    }
}
