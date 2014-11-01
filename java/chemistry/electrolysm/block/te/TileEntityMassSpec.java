package chemistry.electrolysm.block.te;

import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.MultiChemicalWeight;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.handlers.Energy;
import chemistry.electrolysm.items.ItemChemicalTestTube;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.TileEntityEnergyInventory;
import chemistry.electrolysm.util.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

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
public class TileEntityMassSpec extends TileEntityEnergyInventory
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


    public int timer = 0;
    public int maxTime = 100;
    private String STATUS_WAITING = Names.MESSAGES.GUI_MSG_WAITING;
    private String STATUS_WORKING = Names.MESSAGES.GUI_MSG_WORKING;
    private String STATUS_FULL = Names.MESSAGES.GUI_MSG_FULL;
    private String STATUS_ENERGY = Names.MESSAGES.GUI_MSG_NO_ENERGY;
    public String status = STATUS_WAITING;
    MultiChemical chem = null;
    MultiChemical lastChem = null;

    @Override
    public void updateEntity() {
        //TODO
        super.updateEntity();

        if (worldObj.isRemote) {
            return;
        }

        boolean check = inventory[2] == null || inventory[3] == null || inventory[4] == null || inventory[5] == null ||
                inventory[6] == null || inventory[7] == null || inventory[8] == null || inventory[9] == null ||
                inventory[10] == null;

        if (timer > 0 && !check) {
            status = STATUS_FULL;
        } else if (timer > 0) {
            status = STATUS_WORKING;
        }
        if(!this.canWork(Energy.massSpec)){
            status = STATUS_ENERGY;
            return;
        }

        lastChem = chem;

        ItemStack testTubes = this.getStackInSlot(1);
        ItemStack input = this.getStackInSlot(0);
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if (input != null) {
            List<MultiChemicalWeight> chemList = ChemicalSeparation.getProducts(input);
            Random random = new Random();
            if(testTubes != null && testTubes.stackSize >= 1 && input != null && chemList != null && chemList.size() > 0) {
                if(timer == maxTime) {
                    timer = 0;
                    if(random.nextInt(10) <= 4) {
                        if (!(input.getItem() instanceof ItemChemicalTestTube)) {
                            this.produce(chemList, random);
                        } else if (input.getItem() instanceof ItemChemicalTestTube) {
                            MultiChemical chem = ((ItemChemicalTestTube) input.getItem()).getChemical(input);
                            if (chem != null && chem.chemical != null && chem.chemical instanceof CompoundValue) {
                                produce(((CompoundValue) chem.chemical).elementList);
                            }
                        }
                    }
                } else {
                    timer++;
                }
            } else {
                timer = 0;
            }
        } else {
            timer = 0;
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
                } else if (this.getStackInSlot(i + 2).stackSize < 64){
                    if (this.getStackInSlot(i + 2).isItemEqual(itemChem) &&
                            this.getStackInSlot(i + 2).stackTagCompound.equals(itemChem.getTagCompound())) {
                        setInventorySlotContents(i + 2,
                                ChemicalSeparation.createItemStack(elementList.get(j), 1, this.getStackInSlot(i + 2).stackSize + elementList.get(j).amount));
                        decrStackSize(0, 1);
                        decrStackSize(1, 1);
                        break;
                    }
                } else {
                    //break;
                }
            }
            return;
        }
    }

    private void produce(List<MultiChemicalWeight> chemList, Random random) {
        for (int j = 0; j < random.nextInt(5); j++) {
            int listSize = chemList.size();
            ChanceWeight weight = new ChanceWeight(chemList.get(random.nextInt(listSize)).weight);
            if(chem == null) {
                chem = weight.getRandomChemical(random, chemList);
            }
            if(chem != null) {
                ItemStack itemChem = ChemicalSeparation.createItemStack(chem, 1);
                for (int i = 0; i < 9; i++) {
                    if (this.getStackInSlot(i + 2) == null) {
                        setInventorySlotContents(i + 2, itemChem);
                        decrStackSize(0, 1);
                        decrStackSize(1, 1);
                        chem = null;
                        return;
                    } else if (this.getStackInSlot(i + 2).stackSize < 64){
                        if (this.getStackInSlot(i + 2).isItemEqual(itemChem) &&
                                this.getStackInSlot(i + 2).stackTagCompound.equals(itemChem.getTagCompound())) {
                            setInventorySlotContents(i + 2,
                                    ChemicalSeparation.createItemStack(chem, this.getStackInSlot(i + 2).stackSize + 1));
                            decrStackSize(0, 1);
                            decrStackSize(1, 1);
                            chem = null;
                            return;
                        }
                    }
                }
            } else {
                break;
            }
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        timer = pkt.func_148857_g().getInteger("timer");
        status = pkt.func_148857_g().getString("status");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("timer", timer);
        tag.setString("status", status);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }
}
