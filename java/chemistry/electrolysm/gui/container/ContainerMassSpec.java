package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.block.te.TileEntityMassSpec;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
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
public class ContainerMassSpec extends Container{

    private TileEntityMassSpec entity;
    public ContainerMassSpec(InventoryPlayer inventoryPlayer, TileEntityMassSpec entityMassSpec) {
        entity = entityMassSpec;

        this.addSlotToContainer(new Slot(entity, 0, 8, 17 - 3 - 16));
        this.addSlotToContainer(new SlotTestTube(entity, 1, 36, 17 - 3 - 16));

        for (int store = 0; store < 9; ++store)
        {
            this.addSlotToContainer(new SlotOutput(entity, store + 2, 8 + store * 18, 42 + 16));
        }


        for (int invRow = 0; invRow < 3; ++invRow)
        {
            for (int invCol = 0; invCol < 9; ++invCol)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int actionBar = 0; actionBar < 9; ++actionBar)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBar, 8 + actionBar * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNo)
    {
        ItemStack stack = null;
        Slot slot = (Slot)inventorySlots.get(slotNo);
        if(slot != null && slot.getHasStack())
        {
            //this.mergeItemStack()
        }
        return null;
    }
}
