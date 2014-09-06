package chemistry.electrolysm.gui.container;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class ContainerBunsenBurner extends Container {
    public TileEntityBunsenBurner entity;

    public ContainerBunsenBurner(TileEntityBunsenBurner te, InventoryPlayer inv) {
        super();
        entity = te;

        for (int i = 0; i < 2; i++) {
            //Inputs
            int[] inputX = new int[]{0, 36};
            int[] inputY = new int[]{0, 0};
            int inOffsetX = 18, inOffsetY = 50 - 15;
            this.addSlotToContainer(new SlotTestTubeFull(te, i, inputX[i] + inOffsetX, inputY[i] + inOffsetY));
            //Outputs
            int[] outputX = new int[]{0, 36};
            int[] outputY = new int[]{0, 0};
            int offsetX = 107, offsetY = 50 - 15;
            this.addSlotToContainer(new SlotOutput(te, i + 2, outputX[i] + offsetX, outputY[i] + offsetY));
        }
        //FuelSlot
        this.addSlotToContainer(new SlotBunsenFuel(te, 4, 8, -2));

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
