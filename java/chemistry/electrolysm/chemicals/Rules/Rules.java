package chemistry.electrolysm.chemicals.Rules;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Values.ChemicalValue;
import chemistry.electrolysm.chemicals.Values.ElementValue;
import chemistry.electrolysm.chemicals.Values.MultiChemical;

import java.util.HashMap;

/**
 * Created by Clarky158 on 13/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class Rules
{
    HashMap<ChemicalValue, Rule> ruleMap = new HashMap<ChemicalValue, Rule>();

    public Rules(){
        add(new ElementRegistry().getChemicalFromSF("Cu"), new RuleShell(new int[] {2, 8, 18, 1, 0, 0, 0}));
        add(new ElementRegistry().getChemicalFromSF("Ag"), new RuleShell(new int[] {2, 8, 18, 18, 1, 0, 0}));
        add(new ElementRegistry().getChemicalFromSF("Au"), new RuleShell(new int[] {2, 8, 18, 32, 18, 1, 0}));
        add(new ElementRegistry().getChemicalFromSF("Rg"), new RuleShell(new int[] {2, 8, 18, 32, 32, 18, 1}));

        add(new ElementRegistry().getChemicalFromSF("Cr"), new RuleShell(new int[] {2, 8, 13, 1, 0, 0, 0}));
        add(new ElementRegistry().getChemicalFromSF("Mo"), new RuleShell(new int[] {2, 8, 18, 13, 1, 0, 0}));
        add(new ElementRegistry().getChemicalFromSF("W"), new RuleShell(new int[] {2, 8, 18, 32, 12, 2, 0}));
        add(new ElementRegistry().getChemicalFromSF("Sg"), new RuleShell(new int[] {2, 8, 18, 32, 32, 12, 2}));

        add(new ElementRegistry().getChemicalFromSF("H"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("N"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("O"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("F"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("Cl"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("I"), new RuleDiatomic());
        add(new ElementRegistry().getChemicalFromSF("Br"), new RuleDiatomic());
    }

    public void add(ChemicalValue chem, Rule rule){
        ruleMap.put(chem, rule);
    }

    public int[] applyShellRule(ElementValue element, int[] ints) {
        if(ruleMap.get(element) != null && ruleMap.get(element) instanceof RuleShell)
        {
            return ((RuleShell)ruleMap.get(element)).electronConfig;
        }
        return ints;
    }

    public MultiChemical applyDiatomicRule(MultiChemical chemical){
        if(chemical != null && chemical.chemical != null && chemical.chemical instanceof ElementValue){
            if(ruleMap.get(chemical.chemical) != null && ruleMap.get(chemical.chemical) instanceof RuleDiatomic){
                return ((RuleDiatomic) ruleMap.get(chemical.chemical)).apply(chemical);
            }
        }
        return chemical;
    }
}
