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
        addReactivity(0, ElementRegistry.getChemicalFromSF("Pt"));
        addReactivity(1, ElementRegistry.getChemicalFromSF("Au"));
        addReactivity(2, ElementRegistry.getChemicalFromSF("Ag"));
        addReactivity(3, ElementRegistry.getChemicalFromSF("Hg"));
        addReactivity(4, ElementRegistry.getChemicalFromSF("Cu"));
        addReactivity(5, ElementRegistry.getChemicalFromSF("H"));
        addReactivity(6, ElementRegistry.getChemicalFromSF("Pb"));
        addReactivity(7, ElementRegistry.getChemicalFromSF("Sn"));
        addReactivity(8, ElementRegistry.getChemicalFromSF("Fe"));
        addReactivity(9, ElementRegistry.getChemicalFromSF("Zn"));
        addReactivity(10, ElementRegistry.getChemicalFromSF("Al"));
        addReactivity(11, ElementRegistry.getChemicalFromSF("Mg"));
        addReactivity(12, ElementRegistry.getChemicalFromSF("Ca"));
        addReactivity(13, ElementRegistry.getChemicalFromSF("Na"));
        addReactivity(14, ElementRegistry.getChemicalFromSF("K"));
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
