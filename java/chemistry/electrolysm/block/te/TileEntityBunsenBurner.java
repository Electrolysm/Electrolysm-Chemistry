package chemistry.electrolysm.block.te;

import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.Core.Reaction;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.handlers.Reader;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

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

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean hasTestTube() {
        return getStackInSlot(0) != null || getStackInSlot(1) != null || getStackInSlot(2) != null || getStackInSlot(3) != null;
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
        //TODO isItemValidForSlot
        return false;
    }

    double fuelTick = 0;
    double fuelTimer = 0;
    public int fuelCount = 0;

    @Override
    public void updateEntity() {

        this.setActive(this.hasTestTube());
        if(worldObj.isRemote) { return; }
        if(active || !active){
            double temp = getTemp();
            fuelTick = getFuelRate(temp);
            if(fuelTick != 0 && this.getStackInSlot(4) != null && this.isFuelValid(this.getStackInSlot(4))){
                if(fuelTimer >= fuelTick){
                    fuelTimer = 0;
                    fuelCount += getFuelValue(this.getStackInSlot(4));
                    decrStackSize(4, 1);
                } else {
                    fuelTimer += 1;
                }
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
        //worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if (this.getStackInSlot(0) != null && this.getStackInSlot(1) == null && this.getStackInSlot(0).stackTagCompound != null) {
            MultiChemical chem1 = MultiChemical.readFromNBT(this.getStackInSlot(0).stackTagCompound);
            Reaction reaction = chemistry.electrolysm.chemicals.Core.Chemistry.run(
                    chem1.copyWithAmount(chem1.amountOfAtoms * getStackInSlot(0).stackSize), null);

            if (!this.isTempSufficiant(reaction)) {
                return;
            }
            this.setInventorySlotContents(2, ChemicalSeparation.createItemStack(reaction.outputs.get(0), reaction.outputs.get(0).amountOfAtoms));
            this.setInventorySlotContents(3, ChemicalSeparation.createItemStack(reaction.outputs.get(1), reaction.outputs.get(1).amountOfAtoms));
            decrStackSize(0, chem1.amountOfAtoms);
            fuelCount -= getTemp() / 8;
            System.out.println(getTemp() / 8);
            System.out.println(fuelCount);
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

        } else if (this.getStackInSlot(0) != null && this.getStackInSlot(1) != null && this.getStackInSlot(0).stackTagCompound != null
                && this.getStackInSlot(1).stackTagCompound != null) {
            MultiChemical chem1 = MultiChemical.readFromNBT(this.getStackInSlot(0).stackTagCompound);
            MultiChemical chem2 = MultiChemical.readFromNBT(this.getStackInSlot(1).stackTagCompound);
            Reaction reaction = chemistry.electrolysm.chemicals.Core.Chemistry.run(
                    chem1.copyWithAmount(chem1.amountOfAtoms * getStackInSlot(0).stackSize),
                    chem2.copyWithAmount(chem2.amountOfAtoms * getStackInSlot(1).stackSize));
            if (!this.isTempSufficiant(reaction)) {
                return;
            }
            this.setInventorySlotContents(2, ChemicalSeparation.createItemStack(reaction.outputs.get(0), reaction.outputs.get(0).amountOfAtoms));
            if(reaction.outputs.size() > 1) {
                this.setInventorySlotContents(3, ChemicalSeparation.createItemStack(reaction.outputs.get(1), reaction.outputs.get(1).amountOfAtoms));
            }
            decrStackSize(0, chem1.amountOfAtoms);
            decrStackSize(1, chem2.amountOfAtoms);
            fuelCount -= getTemp() / 8;
            System.out.println(getTemp() / 8);
            System.out.println(fuelCount);
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }


    public boolean isFuelValid(ItemStack stack){
        return getFuelValue(stack) != 0;
    }

    public int getFuelValue(ItemStack stack){
        return Reader.getFuelValue(stack);
    }

    private double getFuelRate(double temp) {
        return Math.pow((5000 / (temp + 1)), (1));
    }

    private boolean isTempSufficiant(Reaction reaction) {
        if(reaction == null) {
            return false;
        }
        double temp = this.getTemp();
        float energies = reaction.getEnergies();
        float reqTemp = convertToTempK(energies);
        return temp >= reqTemp && fuelCount >= (temp / 8);
    }

    private float convertToTempK(float energies) {
        return (float) Math.pow(Math.abs(energies), 1);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        hasStand = tag.getBoolean("hasStand");
        active = tag.getBoolean("active");
        fuelCount = tag.getInteger("fuelCount");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setBoolean("hasStand", hasStand);
        tag.setBoolean("active", active);
        tag.setInteger("fuelCount", fuelCount);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("hasStand", hasStand);
        tag.setBoolean("active", active);
        tag.setInteger("fuelCount", fuelCount);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        setHasStand(pkt.func_148857_g().getBoolean("hasStand"));
        setActive(pkt.func_148857_g().getBoolean("active"));
        fuelCount = pkt.func_148857_g().getInteger("fuelCount");
        super.onDataPacket(net, pkt);
    }
}
