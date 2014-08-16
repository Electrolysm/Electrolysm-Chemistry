package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.init.ModItems;
import chemistry.electrolysm.items.ItemTestTube;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

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
public class SlotTestTube extends Slot {
    public SlotTestTube(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ItemTestTube;
    }
}
