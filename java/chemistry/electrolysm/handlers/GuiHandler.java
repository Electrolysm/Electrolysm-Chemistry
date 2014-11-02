package chemistry.electrolysm.handlers;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.block.te.TileEntityCleaner;
import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.gui.container.ContainerBunsenBurner;
import chemistry.electrolysm.gui.container.ContainerCleaner;
import chemistry.electrolysm.gui.container.ContainerMassSpec;
import chemistry.electrolysm.gui.gui.GuiBunsenBurner;
import chemistry.electrolysm.gui.gui.GuiCleaner;
import chemistry.electrolysm.gui.gui.GuiMassSpec;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.naming.Reference;

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
        if (id - Referance.GUI.GUI_MASS_SPEC_ID == 0 && entity instanceof TileEntityMassSpec) {
            return new ContainerMassSpec(player.inventory, (TileEntityMassSpec) entity);
        }
        if (id - Referance.GUI.GUI_BUNSEN_BURNER_ID == 0 && entity instanceof TileEntityBunsenBurner) {
            return new ContainerBunsenBurner((TileEntityBunsenBurner) entity, player.inventory);
        }
        if (id - Referance.GUI.GUI_CLEANER_ID == 0 && entity instanceof TileEntityCleaner) {
            return new ContainerCleaner((TileEntityCleaner) entity, player.inventory);
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
        if(id - Referance.GUI.GUI_BUNSEN_BURNER_ID == 0 && entity instanceof TileEntityBunsenBurner){
            return new GuiBunsenBurner((TileEntityBunsenBurner) entity, player.inventory);
        }
        if(id - Referance.GUI.GUI_CLEANER_ID == 0 && entity instanceof TileEntityCleaner){
            return new GuiCleaner((TileEntityCleaner)entity, player.inventory);
        }
        return null;
    }
}
