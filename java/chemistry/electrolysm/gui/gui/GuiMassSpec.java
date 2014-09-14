package chemistry.electrolysm.gui.gui;

import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.gui.container.ContainerMassSpec;
import chemistry.electrolysm.handlers.ColourEnumHelper;
import chemistry.electrolysm.proxy.CommonProxy;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

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
public class GuiMassSpec extends GuiContainer{
    public TileEntityMassSpec entity;
    public GuiMassSpec(InventoryPlayer inventory, TileEntityMassSpec entityMassSpec) {
        super(new ContainerMassSpec(inventory, entityMassSpec));
        entity = entityMassSpec;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i2) {
        ySize = 166 + 20;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.GUI_MASS_SPEC);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        //Draw progress bar
        int progress = (entity.timer * 114) / entity.maxTime;
        if(progress > 0) {
            this.drawTexturedModalRect(x + 56, y + 9, 5, 227, progress, 16);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.drawCenteredString(fontRendererObj, ColourEnumHelper.WHITE + I18n.format(entity.status, new Object[0]), 85, 32, 4210752);
    }
}
