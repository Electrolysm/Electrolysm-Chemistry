package chemistry.electrolysm.init;

import chemistry.electrolysm.items.ItemChemicalTestTube;
import chemistry.electrolysm.items.ItemStand;
import chemistry.electrolysm.items.ItemTestTube;
import chemistry.electrolysm.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

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
public class ModItems
{
    public static Item testTube = new ItemTestTube();
    public static Item stand = new ItemStand();
    public static Item chemicalTestTube = new ItemChemicalTestTube();
    public static void init(){
        GameRegistry.registerItem(testTube, Names.Items.TEST_TUBE);
        GameRegistry.registerItem(stand, Names.Items.STAND);
        GameRegistry.registerItem(chemicalTestTube, Names.Items.CHEMICAL_TEST_TUBE);
    }
}
