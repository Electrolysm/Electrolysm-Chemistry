package chemistry.electrolysm.chemicals.Core;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Chem.Reactivity;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.EnergyLevels;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.LevelApplication;
import chemistry.electrolysm.chemicals.QuantumEnergyLevels.LevelCalculator;
import chemistry.electrolysm.chemicals.Values.ChemicalValue;
import chemistry.electrolysm.chemicals.Values.CompoundValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Clarky158 on 11/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class Chemistry{

    public static Reaction run(MultiChemical chem1, MultiChemical chem2) {
        List<MultiChemical> reactedChemicals = reactReactants(checkForErrors(chem1), checkForErrors(chem2));
        if (reactedChemicals != null) {
            List<MultiChemical> outputs = reactedChemicals;
            List<MultiChemical> inputs = new ArrayList<MultiChemical>(Arrays.asList(chem1, chem2));
            //equation balancer
            Reaction reaction = EquationBalancing.balance(new Reaction(inputs, outputs));
            //System.out.println(reaction);
            if (reaction != null) {
                return reaction;
                //Newly added levels need fixing
            }
        }
        return null;
    }

    private static MultiChemical checkForErrors(MultiChemical chem) {
        if(chem != null)
        {
            if(chem.chemical != null && chem.amountOfAtoms != 0)
            {
                if(chem.chemical instanceof ElementValue)
                {
                    ElementValue value = (ElementValue) chem.chemical;
                    if(value.amount > 1)
                    {
                        MultiChemical newValue = MultiChemical.create(value.copyWithAmount(1), chem.amountOfAtoms * value.amount);
                        //print(String.valueOf(newValue));
                        return newValue;
                    }
                }/*
                else if(chem.chemical instanceof CompoundValue)
                {
                    CompoundValue value = (CompoundValue) chem.chemical;
                    List<ElementValue> newList = new ArrayList<ElementValue>();
                    for (int i = 0; i < value.elementList.size(); i++) {
                        ElementValue element = value.elementList.get(i);
                        if(element.amount > 1)
                        {
                            newList.add()
                        }
                    }
                }*/
            }
        }
        return chem;
    }

    private static List<MultiChemical> reactReactants(MultiChemical chem1, MultiChemical chem2) {
        //TODO Double bonds not supported.
        //TODO Displacement reactions need to be re-done to take electrons into account.
        //ThermalDecomp
        if(chem1 != null && chem2 == null && chem1.chemical instanceof CompoundValue)
        {
            return thermalDecompReaction((CompoundValue)chem1.chemical, chem1.amountOfAtoms);
        }
        //Synthesis
        if(chem1 != null && chem2 != null && chem1.equals(chem2) && chem1.chemical instanceof ElementValue && chem2.chemical instanceof ElementValue)
        {
            return synthesisReaction(chem1, chem2);
        }
        //Synthesis
        else if(chem1 != null && chem2 != null && chem1.chemical instanceof ElementValue && chem2.chemical instanceof ElementValue) {
            return synthesisReaction(chem1, chem2);
        }
        //SingleDisplacement;
        else if(chem1 != null && chem2 != null && chem1.chemical instanceof ElementValue && chem2.chemical instanceof CompoundValue){
            return singleDispacement(chem1, chem2);
        }
        //DoubleDisplacement
        //Combustion
        else if(chem1 != null && chem2 != null && chem2.chemical instanceof ElementValue){
            if(((ElementValue)chem2.chemical).copyWithAmount(1).equals(ElementRegistry.getChemicalFromSF("O"))){

            }
        }
        return null;
    }

    private static List<MultiChemical> singleDispacement(MultiChemical chem1, MultiChemical chem2) {
        List<MultiChemical> returnList = new ArrayList<MultiChemical>();
        List<ElementValue> reactivitySeries = new Reactivity().getReactivitySeries();
        ElementValue replacer = (ElementValue)chem1.chemical;
        CompoundValue compound = (CompoundValue)chem2.chemical;

        ElementValue mostReactive = null;
        ElementValue leastReactive = null;
        //System.out.println(compound.elementList.size());
        for (int i = 0; i < compound.elementList.size(); i++) {
            if(reactivitySeries.contains(compound.elementList.get(i).copyWithAmount(1)) &&
                    reactivitySeries.contains(replacer.copyWithAmount(1)) &&
                    Math.min(reactivitySeries.indexOf(compound.elementList.get(i)), reactivitySeries.indexOf(replacer))
                    >= 0)
            {
                mostReactive = reactivitySeries.get(Math.max(reactivitySeries.indexOf
                        (compound.elementList.get(i)), reactivitySeries.indexOf(replacer)));
                leastReactive = reactivitySeries.get(Math.min(reactivitySeries.indexOf
                        (compound.elementList.get(i)), reactivitySeries.indexOf(replacer)));
                /*System.out.println("MathCheck: " + Math.min(reactivitySeries.indexOf
                        (compound.elementList.get(i)), reactivitySeries.indexOf(replacer)));*/
            }
        }
        List<ElementValue> compoundList = new ArrayList<ElementValue>(compound.elementList);
        compoundList.remove(leastReactive);
        compoundList.add(mostReactive);
        returnList.add(MultiChemical.create(new CompoundValue(compoundList), 1));
        returnList.add(MultiChemical.create(leastReactive, 1));
        return returnList;
    }

    private static List<MultiChemical> synthesisReaction(MultiChemical chem1, MultiChemical chem2)
    {
        if(chem1.equals(chem2) && chem1.chemical instanceof ElementValue && chem2.chemical instanceof ElementValue)
        {
            List<MultiChemical> listChem = new ArrayList<MultiChemical>();
            int chem1_outer = applyShellWorkings((ElementValue)chem1.chemical) * getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[0];
            int chem2_outer = applyShellWorkings((ElementValue)chem2.chemical) * getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[1];

            int calculated = chem1_outer + chem2_outer;
            List<ElementValue> list = Arrays.asList(((ElementValue)chem1.chemical).copyWithAmount(2));
            if(makesFullShell(calculated))
            {
                listChem.add(new MultiChemical(new CompoundValue(list), getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[2]));
                return listChem;
            }
        }
        else if(chem1.chemical instanceof ElementValue && chem2.chemical instanceof ElementValue) {
            List<MultiChemical> listChem = new ArrayList<MultiChemical>();
            int chem1_outer = applyShellWorkings((ElementValue)chem1.chemical) * getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[0];
            int chem2_outer = applyShellWorkings((ElementValue)chem2.chemical) * getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[1];

            //print("Outer Shells: " + chem1_outer + " : " + chem2_outer);

            int calculated = chem1_outer + chem2_outer;
            List<ElementValue> list = Arrays.asList(((ElementValue)chem1.chemical).copyWithAmount(getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[0]),
                    ((ElementValue)chem2.chemical).copyWithAmount(getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[1]));
            boolean canMakeShell = isEvenlyDivisable(calculated, chem2.amountOfAtoms) &&
                    makesFullShell(calculated / chem2.amountOfAtoms);
            if((makesFullShell(calculated)) || canMakeShell)
            {
                listChem.add(MultiChemical.create(new CompoundValue(list), getRatio(chem1.amountOfAtoms, chem2.amountOfAtoms)[2]));
                return listChem;
            }
        }
        else if(chem1.chemical instanceof ElementValue && chem2.chemical instanceof ElementValue) {
            List<MultiChemical> listChem = new ArrayList<MultiChemical>();
            int chem1_outer = applyShellWorkings((ElementValue)chem1.chemical);
            int chem2_outer = applyShellWorkings((ElementValue)chem2.chemical);

            int calculated = chem1_outer + chem2_outer;
            List<ElementValue> list = Arrays.asList(((ElementValue)chem1.chemical), ((ElementValue)chem2.chemical));
            if(makesFullShell(calculated))
            {
                if(chem1.amountOfAtoms == chem2.amountOfAtoms) {
                    listChem.add(MultiChemical.create(new CompoundValue(list), chem1.amountOfAtoms));
                    return listChem;
                }
                listChem.add(MultiChemical.create(new CompoundValue(list), Math.min(chem1.amountOfAtoms, chem2.amountOfAtoms)));
                return listChem;
            }
        }
        return null;
    }

    private static List<MultiChemical> thermalDecompReaction(CompoundValue chem1, int times) {
        List<ElementValue> list = chem1.elementList;
        List<MultiChemical> chemList = new ArrayList<MultiChemical>();
        for (int i = 0; i < list.size(); i++) {
            chemList.add(MultiChemical.create(list.get(i), list.get(i).amount * times));
        }
        return chemList;
    }

    public static boolean isEvenlyDivisable(int a, int b) {
        return a % b == 0.0000F;
    }

    private static int[] getRatio(int atoms1, int atoms2) {
        int[] ratioFull = new int[]{atoms1, atoms2, 1};

        if (atoms1 > atoms2) {
            int first = atoms1 / atoms2;
            int second = atoms2 / atoms2;
            if (!isEvenlyDivisable(atoms1, atoms2)) {
                return ratioFull;
            }
            return new int[]{first, second, atoms2};
        } else {
            int first = atoms1 / atoms1;
            int second = atoms2 / atoms1;
            if (!isEvenlyDivisable(atoms2, atoms1)) {
                return ratioFull;
            }
            return new int[]{first, second, atoms1};
        }
    }

    private static boolean makesFullShell(int full) {
        int[] max_shell_size = new int[]{2, 8, 8, 8};
        if(full == 2 || full == 8)
        {
            return true;
        }
        return false;
    }

    //Gets number of electrons in outer shell
    private static int applyShellWorkings(ElementValue element) {
        EnergyLevels.SuperSubLevel level = new LevelApplication().getLevel(element.copyWithAmount(1));
        return LevelCalculator.calculateOuterShell(LevelCalculator.calculateShells(element, LevelCalculator.calculateShells(level)));
    }

    private static ChemicalValue convertToChemical(String first) {
        if (first.contains("#")) {
            String[] indevElements = first.split("#");
            List<ElementValue> elementList = new ArrayList<ElementValue>();
            for (int i = 0; i < indevElements.length; i++) {
                if (indevElements[i].matches(".*\\d.*")) {
                    ElementValue base = ElementRegistry.getChemicalFromSF(indevElements[i].replaceAll("[0-9]", ""));
                    elementList.add(base.copyWithAmount(Integer.parseInt(indevElements[i].replaceAll("[A-Za-z]", ""))));
                } else {
                    elementList.add(ElementRegistry.getChemicalFromSF(indevElements[i]));
                }
            }
            return new CompoundValue(elementList);
        }
        String data = first;
        if (ElementRegistry.getChemicalFromSF(data.replaceAll("[0-9]", "")) != null) {
            ElementValue value = ElementRegistry.getChemicalFromSF(data.replaceAll("[0-9]", ""));
            if (value != null && (!(first.replaceAll("[A-Za-z]", "").equals(""))) && first.replaceAll("[A-Za-z]", "") != null) {
                ElementValue elementValue = value.copyWithAmount(Integer.parseInt(first.replaceAll("[A-Za-z]", "")));
                return elementValue;
            }
            return value;
        }
        return null;
    }

    public static void print(String msg) { System.out.println(msg); }

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}