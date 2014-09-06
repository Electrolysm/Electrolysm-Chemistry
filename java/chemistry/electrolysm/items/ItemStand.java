package chemistry.electrolysm.items;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.handlers.network.MessageRegistry;
import chemistry.electrolysm.handlers.network.message.MessageBunsenBurner;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.until.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
public class ItemStand extends ItemBase
{
    public ItemStand() {
        super(Names.Items.STAND);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
                             float clickX, float clickY, float clickZ) {
        if(world.getTileEntity(x, y, z) instanceof TileEntityBunsenBurner){
            TileEntityBunsenBurner te = (TileEntityBunsenBurner) world.getTileEntity(x, y, z);
            if(!te.hasStand()){
                te.setHasStand(true);
                stack.stackSize--;
                MessageRegistry.INSTANCE.sendToServer(new MessageBunsenBurner(te));
                return true;
            }
        }
        return false;
    }
}
