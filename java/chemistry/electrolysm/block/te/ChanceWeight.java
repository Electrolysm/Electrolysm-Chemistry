package chemistry.electrolysm.block.te;

import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.chemicals.MultiChemicalWeight;
import chemistry.electrolysm.chemicals.Values.MultiChemical;

import java.util.List;
import java.util.Random;

/**
 * Created by Clarky158 on 13/09/2014.
 */
public class ChanceWeight {
    public int weight;
    public ChanceWeight(int w){
        weight = w;
    }

    public static int func_76270_a(List<MultiChemicalWeight> paramArrayOfItem) {
        int i = 0;
        for (MultiChemicalWeight localItem : paramArrayOfItem) {
            i += localItem.weight;
        }
        return i;
    }

    public static MultiChemical func_76269_a(Random paramRandom, List<MultiChemicalWeight> paramArrayOfItem, int paramInt)
    {
        if (paramInt <= 0) {
            throw new IllegalArgumentException();
        }

        int i = paramRandom.nextInt(paramInt);
        for (MultiChemicalWeight localItem : paramArrayOfItem) {
            i -= localItem.weight;
            if (i < 0) {
                return localItem.chemical;
            }
        }
        return null;
    }

    public static MultiChemical getRandomChemical(Random paramRandom, List<MultiChemicalWeight> paramArrayOfItem) {
        return func_76269_a(paramRandom, paramArrayOfItem, func_76270_a(paramArrayOfItem));
    }

}
