package chemistry.electrolysm.chemicals.Rules;

import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;

/**
 * Created by Clarky158 on 06/09/2014.
 */
public class RuleDiatomic extends Rule{

    public RuleDiatomic() { super(); }

    public MultiChemical apply(MultiChemical chem){
        if(chem.amountOfAtoms == 2 && chem.chemical instanceof ElementValue && ((ElementValue) chem.chemical).amount == 1){
            ElementValue value = ((ElementValue) chem.chemical).copyWithAmount(2);
            return new MultiChemical(value, 1);
        }
        return chem;
    }
}
