package chemistry.electrolysm.chemicals;

import api.items.RecipeStack;
import chemistry.electrolysm.chemicals.Values.ChemicalValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Clarky158 on 07/09/2014.
 */
public class ChemicalCompression {

    public static HashMap<List<RecipeStack>, RecipeStack> map = new HashMap<List<RecipeStack>, RecipeStack>();

    public ChemicalCompression(){
        MultiChemical.elements e = new MultiChemical.elements();
    }

    private void register(List<ItemStack> inputChem, ItemStack result) {
        List<RecipeStack> list = new ArrayList<RecipeStack>();
        for (int i = 0; i < inputChem.size(); i++) {
            list.add(i, new RecipeStack(inputChem.get(i)));
        }
        map.put(list, new RecipeStack(result));
    }

    private void registerChem(List<MultiChemical> values, ItemStack result){
        List<RecipeStack> list = new ArrayList<RecipeStack>();
        for (int i = 0; i < values.size(); i++) {
            list.add(new RecipeStack(ChemicalSeparation.createItemStack(values.get(i), 1)));
        }
        map.put(list, new RecipeStack(result));
    }

    public ItemStack getProduct(ItemStack[] stacks) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        for (int i = 0; i < stacks.length; i++) {
            list.add(stacks[i]);
        }
        if(map.get(list) != null) {
            return map.get(list).getStackValue();
        }
        return null;
    }
}
