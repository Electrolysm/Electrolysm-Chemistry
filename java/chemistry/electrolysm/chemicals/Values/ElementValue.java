package chemistry.electrolysm.chemicals.Values;

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
public class ElementValue extends ChemicalValue {

    public String chemicalName;
    public String StandardName;
    public int electrons;
    public int RAM;
    public int amount;

    public ElementValue(String fullName, String SF, int NoElectrons, int mass, int amount1) {
        chemicalName = fullName;
        StandardName = SF;
        electrons = NoElectrons;
        RAM = mass;
        amount = amount1;
    }

    public ElementValue(String fullName, String SF, int NoElectrons, int mass) {
        this(fullName, SF, NoElectrons, mass, 1);
    }

    public ElementValue copyWithAmount(int amount1){
        return new ElementValue(chemicalName, StandardName, electrons, RAM, amount1);
    }

    @Override
    public int hashCode() {
        int code = 1;
        if(chemicalName != null) {
            code = (37 * code) + chemicalName.hashCode();
        }
        if(StandardName != null){
            code = (37 * code) + StandardName.hashCode();
        }
        code = (37 * code) + electrons;
        code = (37 * code) + RAM;
        code = (37 * code) + amount;
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElementValue && CompareElementValue.element.compare(this, (ElementValue)obj) == 0;
    }
}
