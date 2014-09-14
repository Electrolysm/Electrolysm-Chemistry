package chemistry.electrolysm.chemicals.Values;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Clarky158 on 13/09/2014.
 */
public class Chemicals
{
    public static List<ElementValue> C6H12O6 = Arrays.asList(ElementRegistry.getChemicalFromSF("C").copyWithAmount(6),
            ElementRegistry.getChemicalFromSF("H").copyWithAmount(10),
            ElementRegistry.getChemicalFromSF("O").copyWithAmount(6));


}
