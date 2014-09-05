package chemistry.electrolysm.chemicals;

import api.items.RecipeStack;
import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Values.ChemicalValue;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ChemicalSeparation
{
    HashMap<RecipeStack, List<MultiChemical>> stackMap = new HashMap<RecipeStack, List<MultiChemical>>();

    public ChemicalSeparation(){
        MultiChemical.elements e = new MultiChemical.elements();
        bind(new ItemStack(Blocks.cobblestone), Arrays.asList(e.B, e.Mg, e.Na, e.Ti, e.Fe, e.Ni, e.Co));
        bind(new ItemStack(Items.diamond), Arrays.asList(e.C.copyWithAmount(5)));

        List<ElementValue> list = Arrays.asList(new ElementRegistry().getChemicalFromSF("C").copyWithAmount(6),
                new ElementRegistry().getChemicalFromSF("H").copyWithAmount(10),
                new ElementRegistry().getChemicalFromSF("O").copyWithAmount(5));
        bind(new ItemStack(Items.potato), Arrays.asList(MultiChemical.create(new CompoundValue(list), 1)));
    }

    private void bind(ItemStack stack, List<MultiChemical> list) {
        stackMap.put(new RecipeStack(stack), list);
    }

    public List<MultiChemical> getProducts(ItemStack stack){
        return stackMap.get(new RecipeStack(stack));
    }

    public static ItemStack createItemStack(MultiChemical chem, int stackSize) {
        ItemStack stack = new ItemStack(ModItems.chemicalTestTube, stackSize);
        stack.stackTagCompound = chem.writeToNBT();
        return stack;
    }

    public static ItemStack createItemStack(ElementValue value, int amount ,int stackSize){
        ItemStack stack = new ItemStack(ModItems.chemicalTestTube, stackSize);
        stack.stackTagCompound = MultiChemical.create(value, amount).writeToNBT();
        return stack;
    }
}
