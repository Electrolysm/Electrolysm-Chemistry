package chemistry.electrolysm.block.te;

import chemistry.electrolysm.block.multiblock.MultiBlockHelper;
import chemistry.electrolysm.chemicals.ChemicalCompression;
import chemistry.electrolysm.util.TileEntityInventory;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 07/09/2014.
 */
public class TileEntityAtomicCompressor extends TileEntityInventory {

    public TileEntityAtomicCompressor() {
        super(10);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        //TODO isItemValidForSlot
        return false;
    }

    @Override
    public String getInventoryName() {
        return "Atomic Compressor";
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        ItemStack[] stackArray = this.getStackArray();
        ItemStack product = new ChemicalCompression().getProduct(stackArray);

        //MultiBlockCode
        this.multiBlock();
    }

    private void multiBlock() {
        boolean check = MultiBlockHelper.isPartOfMultiBlock(worldObj, xCoord, yCoord, zCoord);
        System.out.println(check);
    }

    private ItemStack[] getStackArray() {
        ItemStack[] stacks = new ItemStack[9];
        for (int i = 0; i < 9; i++) {
            stacks[i] = this.getStackInSlot(i);
        } return stacks;
    }
}
