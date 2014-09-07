package chemistry.electrolysm.chemicals;

import api.items.RecipeStack;
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
    }

    private void register(List<ItemStack> stacks, ItemStack result) {
        List<RecipeStack> list = new ArrayList<RecipeStack>();
        for (int i = 0; i < stacks.size(); i++) {
            list.add(i, new RecipeStack(stacks.get(i)));
        }
        map.put(list, new RecipeStack(result));
    }

    public ItemStack getProduct(ItemStack[] stacks) {
        return null;
    }
}
