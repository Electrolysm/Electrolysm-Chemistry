package chemistry.electrolysm.gui.gui;

import chemistry.electrolysm.block.BlockWaste;
import chemistry.electrolysm.block.FluidWaste;
import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.block.te.TileEntityCleaner;
import chemistry.electrolysm.gui.container.ContainerBunsenBurner;
import chemistry.electrolysm.gui.container.ContainerCleaner;
import chemistry.electrolysm.proxy.CommonProxy;
import cpw.mods.fml.client.config.GuiSlider;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class GuiCleaner extends GuiContainer
{
    public TileEntityCleaner entity;
    public GuiCleaner(TileEntityCleaner te, InventoryPlayer inv) {
        super(new ContainerCleaner(te, inv));
        entity = te;
    }

    @Override
    public void initGui() {
        super.initGui();

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i2) {
        ySize = 166 + 20;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.GUI_CLEANER);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize - 10);

        int progress = (entity.timer * 40) / entity.maxTimer;
        this.drawTexturedModalRect(x + 60 + 9, y + 33, xSize, 0, progress, 27);

        int water = (entity.tankWater.getFluidAmount() * 48) / entity.tankWater.getCapacity();
        int waste = (entity.tankWaste.getFluidAmount() * 48) / entity.tankWaste.getCapacity();

        this.drawTexturedModalRect(x + 9, y - water + 73, 0, ySize - 10 - water + 48, 16, water + 1);
        this.drawTexturedModalRect(x + 151, y - waste + 73, 16, ySize - 10 - waste + 48, 16, waste + 1);
    }
}
