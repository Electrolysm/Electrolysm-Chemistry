package chemistry.electrolysm.chemicals;

import api.items.RecipeStack;
import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Values.Chemicals;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import chemistry.electrolysm.init.ModItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
public class ChemicalSeparation {
    public static HashMap<RecipeStack, List<MultiChemicalWeight>> stackMap = new HashMap<RecipeStack, List<MultiChemicalWeight>>();
    public static int MAX_WEIGHT = ElementRegistry.SFMap.size();
    public ChemicalSeparation(FMLInitializationEvent event) {
        MultiChemical.elements e = new MultiChemical.elements();

        bind(Blocks.stone, 92);
        bind(Blocks.grass, 36);
        bind(Blocks.dirt, 36);
        bind(Blocks.cobblestone, 92);
        bind(Blocks.planks, Arrays.asList(MultiChemical.create(new CompoundValue(Chemicals.C6H12O6), 1)), MAX_WEIGHT);

        bind(new ItemStack(Items.diamond), Arrays.asList(e.C.copyWithAmount(5)), MAX_WEIGHT);
        bind(new ItemStack(Items.potato), Arrays.asList(MultiChemical.create(new CompoundValue(Chemicals.C6H12O6), 1)), MAX_WEIGHT);
    }

    private void bind(Block block, int biggestID) {
        List<MultiChemicalWeight> list = new ArrayList<MultiChemicalWeight>();
        for (int i = 0; i < biggestID; i++) {
            Collection<ElementValue> col = ElementRegistry.SFMap.values();
            for(int n = 0; n < col.size(); n++) {
                if (col.toArray()[n] != null && ((ElementValue) col.toArray()[n]).electrons == i) {
                    list.add(new MultiChemicalWeight(MultiChemical.create((ElementValue) col.toArray()[n], 1), i));
                }
            }
        }
        bind(new ItemStack(block), list);
    }

    private void bind(Block block, List<MultiChemical> list, int weight) {
        bind(new ItemStack(block), list, weight);
    }

    private void bind(ItemStack stack, List<MultiChemical> list, int weight) {
        List<MultiChemicalWeight> ret = new ArrayList<MultiChemicalWeight>();
        for (int i = 0; i < list.size(); i++) {
            ret.add(new MultiChemicalWeight(list.get(i), weight));
        }
        bind(stack, ret);
    }

    private void bind(ItemStack stack, List<MultiChemicalWeight> list){
        bind(new RecipeStack(stack), list);
    }

    private void bind(RecipeStack stack, List<MultiChemicalWeight> list){
        stackMap.put(stack, list);
    }

    public static List<MultiChemicalWeight> getProducts(ItemStack stack) {
        return stackMap.get(new RecipeStack(stack));
    }

    public static ItemStack createItemStack(MultiChemical chem, int stackSize) {
        ItemStack stack = new ItemStack(ModItems.chemicalTestTube, stackSize);
        stack.stackTagCompound = chem.writeToNBT();
        return stack;
    }

    public static ItemStack createItemStack(ElementValue value, int amount, int stackSize) {
        ItemStack stack = new ItemStack(ModItems.chemicalTestTube, stackSize);
        stack.stackTagCompound = MultiChemical.create(value, amount).writeToNBT();
        return stack;
    }
}
