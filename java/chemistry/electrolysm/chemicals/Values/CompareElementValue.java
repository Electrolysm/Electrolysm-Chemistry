package chemistry.electrolysm.chemicals.Values;

import chemistry.electrolysm.chemicals.Core.EquationBalancing;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.EnergyLevels;

import java.util.Comparator;

/**
 * Created by Clarky158 on 12/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class CompareElementValue
{
    public static Comparator<MultiChemical> multiChem = new Comparator<MultiChemical>() {
        @Override
        public int compare(MultiChemical chem1, MultiChemical chem2) {
            if(chem1 != null && chem2 != null)
            {
                if(chem1.amountOfAtoms - chem2.amountOfAtoms == 0)
                {
                    if(chem1.chemical != null && chem2.chemical != null)
                    {
                         if(chem1.chemical.equals(chem2.chemical))
                         {
                             return 0;
                         }
                    }
                }
            }
            return -1;
        }
    };

    public static Comparator<ElementValue> element = new Comparator<ElementValue>() {
        @Override
        public int compare(ElementValue element, ElementValue element1) {
            if(element != null && element1 != null)
            {
                if(element.amount - element1.amount == 0)
                {
                    if(element.StandardName.equals(element1.StandardName))
                    {
                        if(element.chemicalName.equals(element1.chemicalName))
                        {
                            if(element.electrons - element1.electrons == 0)
                            {
                                if(element.RAM - element1.RAM == 0)
                                {
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            return 1;
        }
    };


    public static Comparator<CompoundValue> compound = new Comparator<CompoundValue>() {
        @Override
        public int compare(CompoundValue comp1, CompoundValue comp2) {
            if(comp1 != null && comp2 != null)
            {
                if(comp1.elementList.equals(comp2.elementList))
                {
                    return 0;
                }
            }
            return -1;
        }
    };
    public static Comparator<EnergyLevels.SuperSubLevel> superLevel = new Comparator<EnergyLevels.SuperSubLevel>() {
        @Override
        public int compare(EnergyLevels.SuperSubLevel level1, EnergyLevels.SuperSubLevel level2) {
            if(level1 != null && level2 != null)
            {
                if(level1.superScript - level2.superScript == 0)
                {
                    if(level1.place - level2.place == 0)
                    {
                        if(level1.subLevel.electrons - level2.subLevel.electrons == 0)
                        {
                            return 0;
                        }
                    }
                }
            }
            return -1;
        }
    };
    public static Comparator<EquationBalancing.CountedElement> countElement = new Comparator<EquationBalancing.CountedElement>() {
        @Override
        public int compare(EquationBalancing.CountedElement element1, EquationBalancing.CountedElement element2) {
            if(element1 != null && element2 != null)
            {
                if(element1.count - element2.count == 0)
                {
                    if(element1.value != null && element2.value != null)
                    {
                        if(element1.value.equals(element2.value))
                        {
                            return 0;
                        }
                    }
                }
            }
            return -1;
        }
    };
}
