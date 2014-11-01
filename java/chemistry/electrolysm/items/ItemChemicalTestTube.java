package chemistry.electrolysm.items;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.handlers.ColourEnumHelper;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.util.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.*;

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
public class ItemChemicalTestTube extends ItemBase {
    public ItemChemicalTestTube() {
        super(Names.Items.CHEMICAL_TEST_TUBE);
        this.setHasSubtypes(true);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b1) {
        NBTTagCompound tag = stack.getTagCompound();
        MultiChemical chem = MultiChemical.readFromNBT(tag);
        String yellow = ColourEnumHelper.YELLOW.toString();
        if (chem != null && chem.chemical instanceof ElementValue) {
            list.add("Chemical Name: " + yellow + ((ElementValue) chem.chemical).chemicalName);
            list.add("Chemical Symbol: " + yellow + chem.toBasicString());
            list.add("Chemical Type: " + yellow + "Element");
        } else if (chem != null) {
            list.add("Chemical Formula: " + yellow + chem.toString());
            list.add("Chemical Type: " + yellow + "Compound");
        }
        if (chem != null) {
            //list.add(String.valueOf(((ElementValue) chem.chemical).amount));
        }
    }

    public MultiChemical getChemical(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        MultiChemical chem = MultiChemical.readFromNBT(tag);
        return chem;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        HashMap<String, ElementValue> map = ElementRegistry.SFMap;
        for (Map.Entry<String, ElementValue> set : map.entrySet()) {
            ItemStack stack = new ItemStack(this);
            stack.stackTagCompound = MultiChemical.create(ElementRegistry.getChemicalFromSF(set.getKey()), 1).writeToNBT();
            list.add(stack);
        }
    }
}
