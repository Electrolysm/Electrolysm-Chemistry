package chemistry.electrolysm.init;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
public class ChemistryTab extends CreativeTabs {

    String TabLabel;

    public ChemistryTab(int position, String tabID)
    {
        super(position, tabID); //The constructor for your tab
        TabLabel = tabID;
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.testTube;
    }


    public String getTranslatedTabLabel()
    {
        return TabLabel; //The name of the tab ingame
    }
}
