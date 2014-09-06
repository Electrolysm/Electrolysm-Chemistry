package chemistry.electrolysm.block.te;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.Core.Reaction;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.until.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 15/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TileEntityBunsenBurner extends TileEntityInventory {

    private boolean active = true;
    private boolean hasStand;
    private double temperature = 237D;

    public TileEntityBunsenBurner() {
        super(5);
    }

    public boolean isActive() {
        return active;
    }

    public boolean hasTestTube() {
        return true;
    }

    public boolean hasStand() { return hasStand; }

    public void setHasStand(boolean hasStand1) { hasStand = hasStand1; }

    public double getTemp(){
        return (float)temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = (float)temperature;
    }

    @Override
    public String getInventoryName() {
        return Names.GUI.BUNSEN_GUI;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        //TODO
        return false;
    }

    @Override
    public void updateEntity() {
        //TODO
        //System.out.println(this.getStackInSlot(0) + " : " + this.getStackInSlot(1));
        if (this.getStackInSlot(0) != null && this.getStackInSlot(1) == null && this.getStackInSlot(0).stackTagCompound != null) {
            MultiChemical chem1 = MultiChemical.readFromNBT(this.getStackInSlot(0).stackTagCompound);
            Reaction reaction = chemistry.electrolysm.chemicals.Core.Chemistry.run(
                    chem1.copyWithAmount(chem1.amountOfAtoms * getStackInSlot(0).stackSize), null);

            if (reaction == null) {
                return;
            }
            this.setInventorySlotContents(2, ChemicalSeparation.createItemStack(reaction.outputs.get(0), reaction.outputs.get(0).amountOfAtoms));
        } else if (this.getStackInSlot(0) != null && this.getStackInSlot(1) != null && this.getStackInSlot(0).stackTagCompound != null
                && this.getStackInSlot(1).stackTagCompound != null) {
            MultiChemical chem1 = MultiChemical.readFromNBT(this.getStackInSlot(0).stackTagCompound);
            MultiChemical chem2 = MultiChemical.readFromNBT(this.getStackInSlot(0).stackTagCompound);
            Reaction reaction = chemistry.electrolysm.chemicals.Core.Chemistry.run(
                    chem1.copyWithAmount(chem1.amountOfAtoms * getStackInSlot(0).stackSize),
                    chem2.copyWithAmount(chem2.amountOfAtoms * getStackInSlot(1).stackSize));

            if (reaction == null) {
                return;
            }
            this.setInventorySlotContents(2, ChemicalSeparation.createItemStack(reaction.outputs.get(0), reaction.outputs.get(0).amountOfAtoms));
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        hasStand = tag.getBoolean("hasStand");
        active = tag.getBoolean("active");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setBoolean("hasStand", hasStand);
        tag.setBoolean("active", active);
    }
}
