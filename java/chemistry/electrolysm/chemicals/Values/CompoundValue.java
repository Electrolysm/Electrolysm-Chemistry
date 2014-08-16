package chemistry.electrolysm.chemicals.Values;

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
public class CompoundValue extends ChemicalValue
{
    public List<ElementValue> elementList;

    public CompoundValue(List<ElementValue> list) {
        super();
        elementList = list;
    }

    @Override
    public int hashCode() {
        int code = 1;
        if(elementList != null){
            code = (37 * code) + elementList.hashCode();
        }
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CompoundValue && CompareElementValue.compound.compare(this, (CompoundValue)obj) == 0;
    }
}
