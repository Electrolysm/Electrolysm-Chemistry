package chemistry.electrolysm.block.te;

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
public class TileEntityBunsenBurner extends TileEntity {

    private boolean active = true;
    private boolean hasStand;

    public boolean isActive() {
        return active;
    }

    public boolean hasTestTube() {
        return true;
    }

    public boolean hasStand() { return hasStand; }

    public void setHasStand(boolean hasStand1) { hasStand = hasStand1; }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setBoolean("hasStand", hasStand);
        tag.setBoolean("active", active);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        hasStand = tag.getBoolean("hasStand");
        active = tag.getBoolean("active");
    }
}
