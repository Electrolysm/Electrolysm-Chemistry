package chemistry.electrolysm.until;

import chemistry.electrolysm.Chemistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
public class BlockBase extends Block {

    public BlockBase(Material mat, String name, float harness) {
        super(mat);
        this.setCreativeTab(Chemistry.creativeTab);
        this.setBlockName(name);
        this.setHardness(harness);
    }
}
