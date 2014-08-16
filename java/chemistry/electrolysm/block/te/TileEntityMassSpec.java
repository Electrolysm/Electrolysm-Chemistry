package chemistry.electrolysm.block.te;

import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.until.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.List;
import java.util.Random;

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
public class TileEntityMassSpec extends TileEntityInventory
{
    public TileEntityMassSpec(){
        inventory = new ItemStack[11];
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        //TODO
        return true;
    }

    @Override
    public String getInventoryName() {
        return "Mass Spec.";
    }

    @Override
    public void updateEntity() {
        //TODO
        super.updateEntity();

        ItemStack testTubes = this.getStackInSlot(1);
        ItemStack input = this.getStackInSlot(0);
        List<MultiChemical> chemList = new ChemicalSeparation().getProducts(input);
        Random random = new Random();

        if(testTubes != null && testTubes.stackSize >= 4 && input != null && chemList != null && chemList.size() > 0)
        {
            this.produce(chemList, random);
        }
    }

    private void produce(List<MultiChemical> chemList, Random random) {
        for (int j = 0; j < random.nextInt(5); j++) {
            int listSize = chemList.size();
            MultiChemical chem = chemList.get(random.nextInt(listSize));
            ItemStack itemChem = ChemicalSeparation.createItemStack(chem, 1);
            for (int i = 0; i < 9; i++) {
                if (this.getStackInSlot(i + 2) == null) {
                    setInventorySlotContents(i + 2, itemChem);
                    decrStackSize(0, 1);
                    decrStackSize(1, 1);
                    return;
                } else {
                    if (this.getStackInSlot(i + 2).isItemEqual(itemChem) &&
                            this.getStackInSlot(i + 2).stackTagCompound.equals(itemChem.getTagCompound())) {
                        setInventorySlotContents(i + 2,
                                ChemicalSeparation.createItemStack(chem, this.getStackInSlot(i + 2).stackSize + 1));
                        decrStackSize(0, 1);
                        decrStackSize(1, 1);
                        return;
                    }
                }
            }
        }
    }
}
