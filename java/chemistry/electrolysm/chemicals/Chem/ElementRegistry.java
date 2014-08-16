package chemistry.electrolysm.chemicals.Chem;

import chemistry.electrolysm.chemicals.Values.ElementValue;

import java.util.HashMap;

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
public class ElementRegistry {
    HashMap<String, ElementValue> SFMap = new HashMap<String, ElementValue>();

    public ElementRegistry(){
        put("Hydrogen", "H", 1, 1);
        put("Helium", "He", 2, 4);
        put("Lithium", "Li", 3, 7);
        put("Beryllium", "Be", 4, 9);
        put("Boron", "B", 5, 11);
        put("Carbon", "C", 6, 12);
        put("Nitrogen", "N", 7, 14);
        put("Oxygen", "O", 8, 16);
        put("Fluorine", "F", 9, 19);
        put("Neon", "Ne", 10, 20);
        put("Sodium", "Na", 11, 23);
        put("Magnesium", "Mg", 12, 24);
        put("Aluminium", "Al", 13, 27);
        put("Silicon", "S", 14, 28);
        put("Phosphorus", "P", 15, 31);
        put("Sulphur", "S", 16, 32);
        put("Chlorine", "Cl", 17, 35);
        put("Argon", "Ar", 18, 40);
        put("Potassium", "K", 19, 39);
        put("Calcium", "Ca", 20, 40);
        put("Scandium", "Sc", 21, 45);
        put("Titanium", "Ti", 22, 48);
        put("Vanadium", "V", 23, 51);
        put("Chromium", "Cr", 24, 52);
        put("Manganese", "Mn", 25, 55);
        put("Iron", "Fe", 26, 56);
        put("Cobalt", "Co", 27, 59);
        put("Nickel", "Ni", 28, 59);
        put("Copper", "Cu", 29, 63);
        put("Zinc", "Zn", 30, 65);
        put("Gallium", "Ga", 31, 70);
        put("Germanium", "Ge", 32, 73);
        put("Arsenic", "As", 33, 75);
        put("Selenium", "Se", 34, 79);
        put("Bromine", "Br", 35, 80);
        put("Krypton", "Kr", 36, 84);
        put("Rubidium", "Rb", 37, 85);
        put("Strontium", "Sr", 38, 88);
        put("Yttrium", "Y", 39, 89);
        put("Zirconium", "Zr", 40, 91);
        put("Niobium", "Nb", 41, 93);
        put("Molybdenum", "Mo", 42, 96);
        put("Technetium", "Tc", 43, 98);
        put("Ruthenium", "Ru", 44, 101);
        put("Rhodium", "Rh", 45, 103);
        put("Palladium", "Pd", 46, 106);
        put("Silver", "Ag", 47, 108);
        put("Cadmium", "Cd", 48, 112);

        put("Indium", "In", 49, 115);
        put("Tin", "Sn", 50, 119);
        put("Antimony", "Sb", 51, 122);
        put("Tellurium", "Te", 52, 128);
        put("Iodine", "I", 53, 127);

        put("Xenon", "Xe", 54, 131);
        put("Caesium", "Cs", 55, 133);
        put("Barium", "Ba", 56, 137);
        put("Lanthanum", "La", 57, 139);
        put("Cerium", "Ce", 58, 140);
        put("Praseodymium", "Pr", 59, 141);
        put("Neodymium", "Nd", 60, 144);
        put("Promethium", "Pm", 61, 145);
        put( "Samarium", "Sm", 62, 150);
        put("Europium", "Eu", 63, 152);
        put("Gadolinium", "Gd", 64, 157);
        put("Terbium", "Tb", 65, 159);
        put("Dysprosium", "Dy", 66, 163);
        put("Holmium", "Ho", 67, 165);
        put("Erbium", "Er", 68, 167);
        put("Thulium", "Tm", 69, 169);
        put("Ytterbium", "Yb", 70, 173);
        put("Lutetium", "Lu", 71, 135);
        put("Hafnium", "Hf", 72, 178);
        put("Tantalum", "Ta", 73, 181);
        put("Tungsten", "W", 74, 184);
        put("Rhenium", "Re", 75, 186);
        put("Osmium", "Os", 76, 190);
        put("Iridium", "Ir", 77, 192);
        put("Platinum", "Pt", 78, 195);
        put("Gold", "Au", 79, 197);
        put("Mercury", "Hg", 80, 201);
        put("Thallium", "Tl", 81, 204);
        put("Lead", "Pb", 82, 207);
        put("Bismuth", "Bi", 83, 209);
        put("Polonium", "Po", 84, 209);
        put("Astatine", "At", 85, 210);
        put("Radon", "Rn", 86, 22);
        put("Francium", "Fr", 87, 223);
        put("Radium", "Ra", 88, 226);
        put("Actinium", "Ac", 89, 227);
        put("Thorium", "Th", 90, 232);
        put("Protactinium", "Pa", 91, 231);
        put("Uranium", "U", 92, 238);
        put("Neptunium", "Np", 93, 237);
        put("Plutonium", "Pu", 94, 244);
        put("Americium", "Am", 95, 243);
        put("Curium", "Cm", 96, 247);
        put("Burkelium", "Bk", 97, 247);
        put("Californium", "Cf", 98, 251);
        put("Einsteinium", "Es", 99, 525);
        put("Fermium", "Fm", 100, 257);
        put("Mendelevium", "Md", 101, 258);
        put("Nobelium", "No", 102, 259);
        put("Lawrencium", "Lr", 103, 262);
        put("Rutherfordium", "Rf", 104, 267);
        put("Dubnium", "Db", 105, 268);
        put("Seaborgium", "Sg", 106, 271);
        put("Bohrium", "Bh", 107, 272);
        put("Hassium", "Hs", 108, 270);
        put("Meitnerium", "Mt", 109, 276);
        put("Darmstadtium", "Ds", 110, 281);
        put("Roentgenium", "Rg", 111, 280);
        put("Copernicium", "Cn", 112, 285);
        put("Ununtrium", "Uut", 113, 284);
        put("Flerovium", "Fl", 114, 289);
        put("Ununpentium", "Uup", 115, 288);
        put("Livermorium", "Lv", 116, 293);
        put("Ununseptium", "Uus", 117, 294);
        put("Ununoctium", "Uuo", 118, 294);
    }

    private void put(String name, String SF, int electrons, int mass) {
        SFMap.put(SF, new ElementValue(name, SF, electrons, mass));
    }

    public ElementValue getChemicalFromSF(String first) {
        return SFMap.get(first);
    }
}
