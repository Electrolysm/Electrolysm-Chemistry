package chemistry.electrolysm.chemicals.Core;

import chemistry.electrolysm.chemicals.Values.CompareElementValue;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clarky158 on 14/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class EquationBalancing {
    public static Reaction balance(Reaction reaction)
    {
        List<MultiChemical> input = reaction.inputs;
        List<MultiChemical> output = reaction.outputs;

        List<CountedElement> inAmount = countElements(input);
        List<CountedElement> outAmount = countElements(output);
        //System.out.println("In: " + MultiChemical.create(inAmount.get(0).value, inAmount.get(0).count));
        //System.out.println("Out: " + MultiChemical.create(outAmount.get(0).value, 1));

        //System.out.println("InFull: " + inAmount);
        //System.out.println("OutFull: " + outAmount);

        try {
            if (inAmount.size() - outAmount.size() == 0) {
                for (int i = 0; i < inAmount.size(); i++) {
                    if(outAmount.contains(inAmount.get(i)))
                    {
                        return reaction;
                    }
                    else
                    {
                        throw new IllformedEquationException("Unbalanced Equation");
                    }
                }
                throw new IllformedEquationException("End of 'for' statement!");
            }
            throw new IllformedEquationException("In size amount");
        }
        catch (IllformedEquationException e) { e.printStackTrace();}
        return null;
    }

    private static Reaction balanceReaction(List<CountedElement> inAmount, List<CountedElement> outAmount) {
        //System.out.println("UNBALANCED");
        return null;
    }

    private static List<CountedElement> countElements(List<MultiChemical> chemicalList) {
        List<CountedElement> countedElements = new ArrayList<CountedElement>();

        List<CountedElement> elements = new ArrayList<CountedElement>();
        List<CountedElement> compounds = new ArrayList<CountedElement>();
        for (int i = 0; i < chemicalList.size(); i++) {
            MultiChemical chemical = chemicalList.get(i);
            int chemSize = chemical.amountOfAtoms;
            //System.out.println("ChemSize: " + chemSize);
            if(chemical.chemical instanceof ElementValue){
                elements.add(new CountedElement(((ElementValue) chemical.chemical).copyWithAmount(1),
                        (chemSize * ((ElementValue) chemical.chemical).amount)));
            }
            else if(chemical.chemical instanceof CompoundValue){
                for (int j = 0; j < ((CompoundValue) chemical.chemical).elementList.size(); j++) {
                    compounds.add(new CountedElement(((CompoundValue) chemical.chemical).elementList.get(j).copyWithAmount(1),
                            (chemSize * ((CompoundValue) chemical.chemical).elementList.get(j).amount)));
                }
            }
        }
        //System.out.println(elements + " :::: " + compounds);
        if(elements.size() != 0 && compounds.size() != 0) {
            for (int i = 0; i < elements.size(); i++) {
                for (int j = 0; j < compounds.size(); j++) {
                    if (elements.get(i).value.equals(compounds.get(i).value)) {
                        countedElements.add(new CountedElement(elements.get(i).value, (elements.get(i).count + compounds.get(j).count)));
                        //elements.remove(i);
                        //compounds.remove(j);
                    }
                    else
                    {
                        if(!countedElements.contains(new CountedElement(compounds.get(i).value, (compounds.get(i).count)))) {
                            countedElements.add(new CountedElement(elements.get(i).value, (elements.get(i).count)));
                        }
                        countedElements.add(new CountedElement(compounds.get(j).value, (compounds.get(j).count)));
                    }
                }
            }
        } else if(compounds.size() != 0 && elements.size() == 0){
            for (int j = 0; j < compounds.size(); j++) {
               countedElements.add(new CountedElement(compounds.get(j).value, (compounds.get(j).count)));
               //compounds.remove(j);0
            }
        } else if(compounds.size() == 0 && elements.size() != 0){
            for (int i = 0; i < elements.size(); i++) {
                countedElements.add(new CountedElement(elements.get(i).value, (elements.get(i).count)));
                //elements.remove(i);
            }
        }
        return countedElements;
    }

    public static class CountedElement {
        public ElementValue value;
        public int count;
        public CountedElement(ElementValue elementValue, int amount){
            value = elementValue;
            count = amount;
        }

        @Override
        public int hashCode() {
            int code = 1;
            code = (37 * code) + count;
            if(value != null) {
                code = (37 * code) + value.hashCode();
            }
            return code;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof CountedElement && CompareElementValue.countElement.compare(this, (CountedElement)obj) == 0;
        }

        @Override
        public String toString() {
            return count + "." + value.StandardName + value.amount;
        }
    }
}
