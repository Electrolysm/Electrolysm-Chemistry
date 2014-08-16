package chemistry.electrolysm.items;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.EnergyLevels;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.LevelApplication;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.LevelCalculator;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.handlers.ColourEnumHelper;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.until.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.List;

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
public class ItemChemicalTestTube extends ItemBase
{
    public ItemChemicalTestTube(){
        super(Names.Items.CHEMICAL_TEST_TUBE);
        this.setHasSubtypes(true);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b1) {
        NBTTagCompound tag = stack.getTagCompound();
        MultiChemical chem = MultiChemical.readFromNBT(tag);
        String yellow = ColourEnumHelper.YELLOW.toString();
        if(chem != null && chem.chemical instanceof ElementValue) {
            list.add("Chemical Name: " + yellow + ((ElementValue) chem.chemical).chemicalName);
            list.add("Chemical Symbol: " + yellow + ((ElementValue) chem.chemical).StandardName);
        }
    }
}
