package chemistry.electrolysm.chemicals.Chem;

import chemistry.electrolysm.chemicals.Values.ElementValue;

import java.util.ArrayList;
import java.util.List;

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
public class Reactivity {

    private List<ElementValue> reactivitySeries = new ArrayList<ElementValue>();

    public Reactivity()
    {
        addReactivity(0, new ElementRegistry().getChemicalFromSF("Pt"));
        addReactivity(1, new ElementRegistry().getChemicalFromSF("Au"));
        addReactivity(2, new ElementRegistry().getChemicalFromSF("Ag"));
        addReactivity(3, new ElementRegistry().getChemicalFromSF("Hg"));
        addReactivity(4, new ElementRegistry().getChemicalFromSF("Cu"));
        addReactivity(5, new ElementRegistry().getChemicalFromSF("H"));
        addReactivity(6, new ElementRegistry().getChemicalFromSF("Pb"));
        addReactivity(7, new ElementRegistry().getChemicalFromSF("Sn"));
        addReactivity(8, new ElementRegistry().getChemicalFromSF("Fe"));
        addReactivity(9, new ElementRegistry().getChemicalFromSF("Zn"));
        addReactivity(10, new ElementRegistry().getChemicalFromSF("Al"));
        addReactivity(11, new ElementRegistry().getChemicalFromSF("Mg"));
        addReactivity(12, new ElementRegistry().getChemicalFromSF("Ca"));
        addReactivity(13, new ElementRegistry().getChemicalFromSF("Na"));
        addReactivity(14, new ElementRegistry().getChemicalFromSF("K"));
    }

    //14 == greatist
    //0 == least
    public void addReactivity(int reactivity, ElementValue element)
    {
        reactivitySeries.add(reactivity, element);
    }

    public List<ElementValue> getReactivitySeries() {
        return reactivitySeries;
    }
}
