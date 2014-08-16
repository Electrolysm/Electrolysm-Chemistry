package chemistry.electrolysm.handlers;

import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.gui.container.ContainerMassSpec;
import chemistry.electrolysm.gui.gui.GuiMassSpec;
import chemistry.electrolysm.reference.Referance;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
public class GuiHandler implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if(id - Referance.GUI.GUI_MASS_SPEC_ID == 0 && entity instanceof TileEntityMassSpec)
        {
            return new ContainerMassSpec(player.inventory, (TileEntityMassSpec)entity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if(id - Referance.GUI.GUI_MASS_SPEC_ID == 0 && entity instanceof TileEntityMassSpec)
        {
            return new GuiMassSpec(player.inventory, (TileEntityMassSpec)entity);
        }
        return null;
    }
}
