package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class SlotBunsenFuel extends Slot {
    public SlotBunsenFuel(IInventory te, int id, int x, int y) {
        super(te, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack != null && stack.getItem() != null){
            return true;//stack.getItem() instanceof ItemCoal;
        }
        return super.isItemValid(stack);
    }
}
