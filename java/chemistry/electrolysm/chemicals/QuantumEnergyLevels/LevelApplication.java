package chemistry.electrolysm.chemicals.QuantumEnergyLevels;


import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.Values.ElementValue;

import java.util.HashMap;

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
public class LevelApplication
{
    HashMap<ElementValue, EnergyLevels.SuperSubLevel> levelMap = new HashMap<ElementValue, EnergyLevels.SuperSubLevel>();

    public LevelApplication(){
        apply(new EnergyLevels.SuperSubLevel(1, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("H"));
        apply(new EnergyLevels.SuperSubLevel(1, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("He"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("Li"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Be"));

        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("B"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("C"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("N"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("O"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("F"));
        apply(new EnergyLevels.SuperSubLevel(2, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Ne"));

        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("Na"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Mg"));

        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("Al"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("Si"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("P"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("S"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("Cl"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Ar"));

        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("K"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Ca"));

        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 1), new ElementRegistry().getChemicalFromSF("Sc"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 2), new ElementRegistry().getChemicalFromSF("Ti"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 3), new ElementRegistry().getChemicalFromSF("V"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 4), new ElementRegistry().getChemicalFromSF("Cr"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 5), new ElementRegistry().getChemicalFromSF("Mn"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 6), new ElementRegistry().getChemicalFromSF("Fe"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 7), new ElementRegistry().getChemicalFromSF("Co"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 8), new ElementRegistry().getChemicalFromSF("Ni"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 9), new ElementRegistry().getChemicalFromSF("Cu"));
        apply(new EnergyLevels.SuperSubLevel(3, EnergyLevels.d, 10), new ElementRegistry().getChemicalFromSF("Zn"));
        //..........
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("Ga"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("Ge"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("As"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("Se"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("Br"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Kr"));

        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("Rb"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Sr"));

        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 1), new ElementRegistry().getChemicalFromSF("Y"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 2), new ElementRegistry().getChemicalFromSF("Zr"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 3), new ElementRegistry().getChemicalFromSF("Nb"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 4), new ElementRegistry().getChemicalFromSF("Mo"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 5), new ElementRegistry().getChemicalFromSF("Tc"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 6), new ElementRegistry().getChemicalFromSF("Ru"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 7), new ElementRegistry().getChemicalFromSF("Rh"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 8), new ElementRegistry().getChemicalFromSF("Pd"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 9), new ElementRegistry().getChemicalFromSF("Ag"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.d, 10), new ElementRegistry().getChemicalFromSF("Cd"));

        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("In"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("Sn"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("Sb"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("Te"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("I"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Xe"));

        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("Cs"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Ba"));

        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 1), new ElementRegistry().getChemicalFromSF("La"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 2), new ElementRegistry().getChemicalFromSF("Ce"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 3), new ElementRegistry().getChemicalFromSF("Pr"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 4), new ElementRegistry().getChemicalFromSF("Nd"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 5), new ElementRegistry().getChemicalFromSF("Pm"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 6), new ElementRegistry().getChemicalFromSF("Sm"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 7), new ElementRegistry().getChemicalFromSF("Eu"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 8), new ElementRegistry().getChemicalFromSF("Gd"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 9), new ElementRegistry().getChemicalFromSF("Tb"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 10), new ElementRegistry().getChemicalFromSF("Dy"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 11), new ElementRegistry().getChemicalFromSF("Ho"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 12), new ElementRegistry().getChemicalFromSF("Er"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 13), new ElementRegistry().getChemicalFromSF("Tm"));
        apply(new EnergyLevels.SuperSubLevel(4, EnergyLevels.f, 14), new ElementRegistry().getChemicalFromSF("Yb"));

        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 1), new ElementRegistry().getChemicalFromSF("Lu"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 2), new ElementRegistry().getChemicalFromSF("Hf"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 3), new ElementRegistry().getChemicalFromSF("Ta"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 4), new ElementRegistry().getChemicalFromSF("W"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 5), new ElementRegistry().getChemicalFromSF("Re"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 6), new ElementRegistry().getChemicalFromSF("Os"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 7), new ElementRegistry().getChemicalFromSF("Ir"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 8), new ElementRegistry().getChemicalFromSF("Pt"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 9), new ElementRegistry().getChemicalFromSF("Au"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.d, 10), new ElementRegistry().getChemicalFromSF("Hg"));

        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("Tl"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("Pb"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("Bi"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("Po"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("At"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Rn"));

        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.s, 1), new ElementRegistry().getChemicalFromSF("Fr"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.s, 2), new ElementRegistry().getChemicalFromSF("Ra"));

        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 1), new ElementRegistry().getChemicalFromSF("Ac"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 2), new ElementRegistry().getChemicalFromSF("Th"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 3), new ElementRegistry().getChemicalFromSF("Pa"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 4), new ElementRegistry().getChemicalFromSF("U"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 5), new ElementRegistry().getChemicalFromSF("Np"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 6), new ElementRegistry().getChemicalFromSF("Pu"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 7), new ElementRegistry().getChemicalFromSF("Am"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 8), new ElementRegistry().getChemicalFromSF("Cm"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 9), new ElementRegistry().getChemicalFromSF("Bk"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 10), new ElementRegistry().getChemicalFromSF("Cf"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 11), new ElementRegistry().getChemicalFromSF("Es"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 12), new ElementRegistry().getChemicalFromSF("Fm"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 13), new ElementRegistry().getChemicalFromSF("Md"));
        apply(new EnergyLevels.SuperSubLevel(5, EnergyLevels.f, 14), new ElementRegistry().getChemicalFromSF("No"));

        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 1), new ElementRegistry().getChemicalFromSF("Lr"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 2), new ElementRegistry().getChemicalFromSF("Rf"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 3), new ElementRegistry().getChemicalFromSF("Db"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 4), new ElementRegistry().getChemicalFromSF("Sg"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 5), new ElementRegistry().getChemicalFromSF("Bh"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 6), new ElementRegistry().getChemicalFromSF("Hs"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 7), new ElementRegistry().getChemicalFromSF("Mt"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 8), new ElementRegistry().getChemicalFromSF("Ds"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 9), new ElementRegistry().getChemicalFromSF("Rg"));
        apply(new EnergyLevels.SuperSubLevel(6, EnergyLevels.d, 10), new ElementRegistry().getChemicalFromSF("Cn"));

        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 1), new ElementRegistry().getChemicalFromSF("Uut"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 2), new ElementRegistry().getChemicalFromSF("Fl"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 3), new ElementRegistry().getChemicalFromSF("Uup"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 4), new ElementRegistry().getChemicalFromSF("Lv"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 5), new ElementRegistry().getChemicalFromSF("Uus"));
        apply(new EnergyLevels.SuperSubLevel(7, EnergyLevels.p, 6), new ElementRegistry().getChemicalFromSF("Uuo"));



    }

    public void apply(EnergyLevels.SuperSubLevel level, ElementValue value){
        levelMap.put(value, level);
    }

    public EnergyLevels.SuperSubLevel getLevel(ElementValue element) {
        return levelMap.get(element);
    }
}
