package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.items.ItemChemicalTestTube;
import chemistry.electrolysm.items.ItemTestTube;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class SlotTestTubeFull extends SlotTestTube {
    public SlotTestTubeFull(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ItemChemicalTestTube;
    }
}
