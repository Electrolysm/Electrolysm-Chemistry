package chemistry.electrolysm.gui.gui;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import cpw.mods.fml.client.config.GuiSlider;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class GuiTempSlider implements GuiSlider.ISlider{
    TileEntityBunsenBurner entity;
    public GuiTempSlider(TileEntityBunsenBurner te){
        entity = te;
    }

    @Override
    public void onChangeSliderValue(GuiSlider slider) {
        double value = slider.getValue();
        entity.setTemperature(value);
    }
}
