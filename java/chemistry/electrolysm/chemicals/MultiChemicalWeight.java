package chemistry.electrolysm.chemicals;

import chemistry.electrolysm.chemicals.Values.MultiChemical;

/**
 * Created by Clarky158 on 13/09/2014.
 */
public class MultiChemicalWeight {
    public MultiChemical chemical;
    public int weight;
    public MultiChemicalWeight(MultiChemical chem, int w){
        chemical = chem;
        weight = w;
    }
}
