package chemistry.electrolysm.block.te;

import chemistry.electrolysm.block.BlockWaste;
import chemistry.electrolysm.init.ModBlocks;
import chemistry.electrolysm.init.ModItems;
import chemistry.electrolysm.items.ItemChemicalTestTube;
import chemistry.electrolysm.util.TileEntityEnergyInventory;
import com.sun.istack.internal.NotNull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * Created by Clarky158 on 01/11/2014.
 */
public class TileEntityCleaner extends TileEntityEnergyInventory implements IFluidHandler{

    public TileEntityCleaner() {
        super(2);
    }

    int CAPACITY = 1000;
    int WASTE_AMOUNT = 500;
    int WATER_AMOUNT = 500;
    FluidStack FLUID_WASTE = new FluidStack(ModBlocks.fluidWaste, WASTE_AMOUNT);

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if(slot == 0 && stack != null && stack.getItem() != null){
            //Input
            if(stack.getItem() instanceof ItemChemicalTestTube){
                return true;
            }
        }
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
        if(input != null && tankCheck()) {
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
                changeTankValues();
            } else {
                timer++;
            }
        }
    }

    private boolean tankCheck() {
        return (tankWaste.getFluidAmount() + WASTE_AMOUNT) <= tankWaste.getCapacity() &&
                tankWater.getFluidAmount() >= WATER_AMOUNT;
    }

    private void changeTankValues() {
        tankWater.drain(WATER_AMOUNT, true);
        tankWaste.fill(FLUID_WASTE, true);
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public FluidTank tankWater = new FluidTank(CAPACITY);
    public FluidTank tankWaste = new FluidTank(CAPACITY);

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if(from != ForgeDirection.DOWN && from != ForgeDirection.UP){
            if(tankWater.getFluid() == null || tankWater.getFluidAmount() == 0){
                tankWater.setFluid(resource);
                return resource.amount;
            }
            else if(tankWater.getFluid() != null){
                if(tankWater.getFluid().isFluidEqual(resource) &&
                        (tankWater.getFluidAmount() + resource.amount) <= tankWater.getCapacity()){
                    tankWater.setFluid(new FluidStack(resource.getFluid(), tankWater.getFluidAmount() + resource.amount));
                    return tankWater.getFluidAmount() + resource.amount;
                }
            }
        }
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if(from == ForgeDirection.DOWN){
            if(tankWaste.getFluidAmount() > maxDrain){
                tankWaste.setFluid(new FluidStack(tankWaste.getFluid(), tankWaste.getFluidAmount() - maxDrain));
                return new FluidStack(tankWaste.getFluid(), tankWaste.getFluidAmount() - maxDrain);
            }
            else if(tankWaste.getFluidAmount() <= maxDrain){
                tankWaste.setFluid(null);
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        if(from != ForgeDirection.DOWN && from != ForgeDirection.UP && fluid == FluidRegistry.WATER) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        if(from == ForgeDirection.DOWN && fluid != FluidRegistry.WATER){
            return true;
        }
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        if(from == ForgeDirection.DOWN){
            return new FluidTankInfo[] { tankWaste.getInfo() };
        }
        return new FluidTankInfo[] { tankWater.getInfo() };
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        tankWater.readFromNBT(pkt.func_148857_g().getCompoundTag("tankWater"));
        tankWaste.readFromNBT(pkt.func_148857_g().getCompoundTag("tankWaste"));
        timer = pkt.func_148857_g().getInteger("timer");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound waste = new NBTTagCompound();
        NBTTagCompound water = new NBTTagCompound();
        tag.setTag("tankWaste", tankWaste.writeToNBT(waste));
        tag.setTag("tankWater", tankWater.writeToNBT(water));
        tag.setInteger("timer", timer);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }
}
