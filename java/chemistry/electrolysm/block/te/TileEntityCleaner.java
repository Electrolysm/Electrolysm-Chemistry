package chemistry.electrolysm.block.te;

import chemistry.electrolysm.init.ModItems;
import chemistry.electrolysm.util.TileEntityEnergyInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 01/11/2014.
 */
public class TileEntityCleaner extends TileEntityEnergyInventory {

    public TileEntityCleaner() {
        super(2);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        //TODO
        return false;
    }

    @Override
    public String getInventoryName() {
        return "Cleaner";
    }

    public int timer = 0;
    public int maxTimer = 40;

    @Override
    public void updateEntity() {
        super.updateEntity();

        ItemStack input = this.getStackInSlot(0);
        ItemStack output = this.getStackInSlot(1);
        ItemStack tubes = new ItemStack(ModItems.testTube, 1);

        if(worldObj.isRemote){
            return;
        }
        if(input != null) {
            if (timer >= maxTimer) {
                timer = 0;
                if(output == null){
                    this.setInventorySlotContents(1, tubes);
                } else {
                    if((output.stackSize + 1) <= 64){
                        this.setInventorySlotContents(1, new ItemStack(tubes.getItem(), output.stackSize + tubes.stackSize,
                                tubes.getItemDamage()));
                    }
                }
                this.decrStackSize(0, 1);
            } else {
                timer++;
            }
        }
    }
}
