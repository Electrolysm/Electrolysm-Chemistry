package chemistry.electrolysm.gui.gui;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.gui.container.ContainerBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import cpw.mods.fml.client.config.GuiSlider;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class GuiBunsenBurner extends GuiContainer
{
    public TileEntityBunsenBurner entity;
    public GuiBunsenBurner(TileEntityBunsenBurner te, InventoryPlayer inv) {
        super(new ContainerBunsenBurner(te, inv));
        entity = te;
    }

    @Override
    public void initGui() {
        super.initGui();

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        buttonList.add(new GuiSlider(0, x + 17, y + 60, 143, 20, "Temperature: ", "K", 0D, 1500D, entity.getTemp(), false, true,
                new GuiTempSlider(entity)));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i2) {
        ySize = 166 + 20;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.GUI_BUNSEN_BURNER);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        fontRendererObj.drawString("Fuel Count: " + entity.fuelCount, x + 35, y + 12, 4210752);
    }
}
