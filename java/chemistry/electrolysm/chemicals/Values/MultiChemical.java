package chemistry.electrolysm.chemicals.Values;

import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import com.sun.org.apache.xpath.internal.operations.Mult;
import net.minecraft.nbt.NBTTagCompound;
import scala.xml.Elem;

import java.util.ArrayList;
import java.util.List;

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
public class MultiChemical {
    public ChemicalValue chemical;
    public int amountOfAtoms;
    public MultiChemical(ChemicalValue chemicalValue, int amount) {
        amountOfAtoms = amount;
        chemical = chemicalValue;
    }

    public MultiChemical copyWithAmount(int amount){
        this.amountOfAtoms = amount;
        return this;
    }

    public String toBasicString() {
        if (chemical instanceof ElementValue) {
            if (amountOfAtoms == 1) {
                if (((ElementValue) chemical).amount == 1) {
                    return ((ElementValue) chemical).StandardName;
                } else {
                    return ((ElementValue) chemical).StandardName + ((ElementValue) chemical).amount;
                }
            }
            return amountOfAtoms + ((ElementValue) chemical).StandardName;
        } else if (chemical instanceof CompoundValue) {
            List<ElementValue> list = ((CompoundValue) chemical).elementList;
            String formula = "";
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) != null) {
                    if (list.get(i).amount == 1) {
                        formula = formula + list.get(i).StandardName;
                    } else {
                        formula = formula + list.get(i).StandardName + list.get(i).amount;
                    }
                }
            }
            return amountOfAtoms + formula;
        }
        else if(chemical instanceof ChemicalValue)
        {
            return "Chemical: " + chemical;
        }
        return "Broken: " + chemical;
    }

    public static MultiChemical create(ChemicalValue chemicalValue, int amount) {
        if(amount <= 0) {
            return null;
        }
        return new MultiChemical(chemicalValue, amount);
    }

    @Override
    public int hashCode() {
        int code = 1;
        if (chemical != null) {
            code = (37 * code) + chemical.hashCode();
            code = (37 * code) + amountOfAtoms;
        }
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MultiChemical && CompareElementValue.multiChem.compare(this, (MultiChemical)obj) == 0;
    }

    @Override
    public String toString() {
        return this.toBasicString();
    }

    public NBTTagCompound writeToNBT(){
        NBTTagCompound tag = new NBTTagCompound();
        String code = ("chem:");
        String codeElement = code + "element:";
        String codeCompound = code + "compound:";
        tag.setInteger(code + "atoms", amountOfAtoms);
        if(chemical instanceof ElementValue){
            tag.setBoolean(codeElement, true);
            ElementValue element = (ElementValue) chemical;
            tag.setString(codeElement + "chemName", element.chemicalName);
            tag.setString(codeElement + "SF", element.StandardName);
            tag.setInteger(codeElement + "amount", element.amount);
            tag.setInteger(codeElement + "RAM", element.RAM);
            tag.setInteger(codeElement + "electrons", element.electrons);
        }
        else if(chemical instanceof CompoundValue){
            tag.setBoolean(codeCompound, true);
            CompoundValue value = (CompoundValue) chemical;
            tag.setInteger(codeCompound + "listSize", ((CompoundValue) chemical).elementList.size());
            for (int i = 0; i < value.elementList.size(); i++) {
                ElementValue element = value.elementList.get(i);
                tag.setString(codeCompound + "chemName" + i, element.chemicalName);
                tag.setString(codeCompound + "SF" + i, element.StandardName);
                tag.setInteger(codeCompound + "amount" + i, element.amount);
                tag.setInteger(codeCompound + "RAM" + i, element.RAM);
                tag.setInteger(codeCompound + "electrons" + i, element.electrons);
            }
        }
        return tag;
    }

    public static MultiChemical readFromNBT(NBTTagCompound tag)
    {
        if(tag == null) { return null; }
        String code = ("chem:");
        String codeElement = code + "element:";
        String codeCompound = code + "compound:";

        int amountAtoms = tag.getInteger(code + "atoms");
        if(tag.getBoolean(codeElement)){
            String name = tag.getString(codeElement + "chemName");
            String SF = tag.getString(codeElement + "SF");
            int amount = tag.getInteger(codeElement + "amouent");
            int ram = tag.getInteger(codeElement + "RAM");
            int electrons = tag.getInteger(codeElement + "electrons");
            ElementValue value = new ElementValue(name, SF, electrons, ram, amount);
            return MultiChemical.create(value, amountAtoms);
        }
        else if(tag.getBoolean(codeCompound)){
            int listSize = tag.getInteger(codeCompound + "listSize");
            List<ElementValue> list = new ArrayList<ElementValue>();
            for(int i = 0; i < listSize; i++)
            {
                String name = tag.getString(codeCompound + "chemName" + i);
                String sf = tag.getString(codeCompound + "SF" + i);
                int amount = tag.getInteger(codeCompound + "amount" + i);
                int ram = tag.getInteger(codeCompound + "RAM" + i);
                int electrons = tag.getInteger(codeCompound + "electrons" + i);
                list.add(new ElementValue(name, sf, electrons, ram, amount));
            }
            return MultiChemical.create(new CompoundValue(list), amountAtoms);
        }
        return null;
    }


    public static class elements{
        public MultiChemical H = MultiChemical.create(new ElementRegistry().getChemicalFromSF("H"), 1);
        public MultiChemical He = MultiChemical.create(new ElementRegistry().getChemicalFromSF("He"), 1);
        public MultiChemical Li = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Li"), 1);
        public MultiChemical Be = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Be"), 1);
        public MultiChemical B = MultiChemical.create(new ElementRegistry().getChemicalFromSF("B"), 1);
        public MultiChemical C = MultiChemical.create(new ElementRegistry().getChemicalFromSF("C"), 1);
        public MultiChemical N = MultiChemical.create(new ElementRegistry().getChemicalFromSF("N"), 1);
        public MultiChemical O = MultiChemical.create(new ElementRegistry().getChemicalFromSF("O"), 1);
        public MultiChemical F = MultiChemical.create(new ElementRegistry().getChemicalFromSF("F"), 1);
        public MultiChemical Ne = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Ne"), 1);
        public MultiChemical Na = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Na"), 1);
        public MultiChemical Mg = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Mg"), 1);
        public MultiChemical Al = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Al"), 1);
        public MultiChemical Si = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Si"), 1);
        public MultiChemical P = MultiChemical.create(new ElementRegistry().getChemicalFromSF("P"), 1);
        public MultiChemical S = MultiChemical.create(new ElementRegistry().getChemicalFromSF("S"), 1);
        public MultiChemical Cl = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Cl"), 1);
        public MultiChemical Ar = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Ar"), 1);
        public MultiChemical K = MultiChemical.create(new ElementRegistry().getChemicalFromSF("K"), 1);
        public MultiChemical Ca = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Ca"), 1);
        public MultiChemical Sc = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Sc"), 1);
        public MultiChemical Ti = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Ti"), 1);
        public MultiChemical V = MultiChemical.create(new ElementRegistry().getChemicalFromSF("V"), 1);
        public MultiChemical Cr = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Cr"), 1);
        public MultiChemical Mn = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Mn"), 1);
        public MultiChemical Fe = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Fe"), 1);
        public MultiChemical Co = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Co"), 1);
        public MultiChemical Ni = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Ni"), 1);
        public MultiChemical Cu = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Cu"), 1);
        public MultiChemical Zn = MultiChemical.create(new ElementRegistry().getChemicalFromSF("Zn"), 1);
    }
}
