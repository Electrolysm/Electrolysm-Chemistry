package chemistry.electrolysm.block;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.init.ModItems;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import chemistry.electrolysm.util.BlockModelBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;

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
public class BlockBBGas extends BlockBunsenBurner
{
    public BlockBBGas() {
        super();
        this.setBlockName(Names.Block.BB_GAS);
    }
}
