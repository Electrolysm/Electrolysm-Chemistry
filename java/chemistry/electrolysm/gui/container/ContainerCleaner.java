package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.block.te.TileEntityCleaner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 02/11/2014.
 */
public class ContainerCleaner extends Container {
    public TileEntityCleaner entity;

    public ContainerCleaner(TileEntityCleaner te, InventoryPlayer inv) {
        super();
        entity = te;

        this.addSlotToContainer(new Slot(te, 0, 37, 30));
        this.addSlotToContainer(new Slot(te, 1, 123, 30));

        //PlayerInv
        for (int invRow = 0; invRow < 3; ++invRow) {
            for (int invCol = 0; invCol < 9; ++invCol) {
                this.addSlotToContainer(new Slot(inv, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int actionBar = 0; actionBar < 9; ++actionBar) {
            this.addSlotToContainer(new Slot(inv, actionBar, 8 + actionBar * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return null;
    }

    @Override
    protected void retrySlotClick(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) { }
}
