package chemistry.electrolysm.block.te;

import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.MultiChemicalWeight;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.items.ItemChemicalTestTube;
import chemistry.electrolysm.until.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import scala.reflect.api.Types;

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
        super(11);
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

        if(worldObj.isRemote) { return; }

        ItemStack testTubes = this.getStackInSlot(1);
        ItemStack input = this.getStackInSlot(0);
        if(input != null) {
            List<MultiChemicalWeight> chemList = ChemicalSeparation.getProducts(input);
            Random random = new Random();

            if (testTubes != null && testTubes.stackSize >= 1 && input != null && chemList != null && chemList.size() > 0) {
                this.produce(chemList, random);
            } else if (testTubes != null && testTubes.stackSize >= 1 && input != null && chemList == null
                    && input.getItem() instanceof ItemChemicalTestTube) {
                MultiChemical chem = ((ItemChemicalTestTube) input.getItem()).getChemical(input);
                if (chem != null && chem.chemical != null && chem.chemical instanceof CompoundValue) {
                    produce(((CompoundValue) chem.chemical).elementList);
                }
            }
        }
    }

    private void produce(List<ElementValue> elementList) {
        for (int j = 0; j < elementList.size(); j++) {
            ItemStack itemChem = ChemicalSeparation.createItemStack(elementList.get(j), 1, elementList.get(j).amount);
            for (int i = 0; i < 9; i++) {
                if (this.getStackInSlot(i + 2) == null) {
                    setInventorySlotContents(i + 2, itemChem);
                    decrStackSize(0, 1);
                    decrStackSize(1, 1);
                    break;
                } else {
                    if (this.getStackInSlot(i + 2).isItemEqual(itemChem) &&
                            this.getStackInSlot(i + 2).stackTagCompound.equals(itemChem.getTagCompound())) {
                        setInventorySlotContents(i + 2,
                                ChemicalSeparation.createItemStack(elementList.get(j), 1, this.getStackInSlot(i + 2).stackSize + elementList.get(j).amount));
                        decrStackSize(0, 1);
                        decrStackSize(1, 1);
                        break;
                    }
                }
            }
        }
    }

    private void produce(List<MultiChemicalWeight> chemList, Random random) {
        for (int j = 0; j < random.nextInt(5); j++) {
            int listSize = chemList.size();
            ChanceWeight weight = new ChanceWeight(chemList.get(random.nextInt(listSize)).weight);
            MultiChemical chem = weight.getRandomChemical(random, chemList);
            if(chem != null) {
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
}
