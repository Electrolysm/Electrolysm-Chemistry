package chemistry.electrolysm.chemicals.QuantumEnergyLevels;

import chemistry.electrolysm.chemicals.Values.CompareElementValue;

import java.util.ArrayList;
import java.util.Arrays;
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
public class EnergyLevels
{
    public static SubLevel s = new SubLevel(2, "s");
    public static SubLevel p = new SubLevel(6, "p");
    public static SubLevel d = new SubLevel(10, "d");
    public static SubLevel f = new SubLevel(14, "f");
    public static SubLevel g = new SubLevel(18, "g");

    public static SuperSubLevel _1s2 = new SuperSubLevel(1, s, 2);
    public static SuperSubLevel _2s2 = new SuperSubLevel(2, s, 2);
    public static SuperSubLevel _2p6 = new SuperSubLevel(2, p, 6);
    public static SuperSubLevel _3s2 = new SuperSubLevel(3, s, 2);
    public static SuperSubLevel _3p6 = new SuperSubLevel(3, p, 6);
    public static SuperSubLevel _4s2 = new SuperSubLevel(4, s, 2);
    public static SuperSubLevel _3d10 = new SuperSubLevel(3, d, 10);
    public static SuperSubLevel _4p6 = new SuperSubLevel(4, p, 6);
    public static SuperSubLevel _5s2 = new SuperSubLevel(5, s, 2);
    public static SuperSubLevel _4d10 = new SuperSubLevel(4, d, 10);
    public static SuperSubLevel _5p6 = new SuperSubLevel(5, p, 6);
    public static SuperSubLevel _6s2 = new SuperSubLevel(6, s, 2);
    public static SuperSubLevel _4f14 = new SuperSubLevel(4, f, 14);
    public static SuperSubLevel _5d10 = new SuperSubLevel(5, d, 10);
    public static SuperSubLevel _6p6 = new SuperSubLevel(6, p, 6);
    public static SuperSubLevel _7s2 = new SuperSubLevel(7, s, 2);
    public static SuperSubLevel _5f14 = new SuperSubLevel(5, f, 14);
    public static SuperSubLevel _6d10 = new SuperSubLevel(6, d, 10);
    public static SuperSubLevel _7p6 = new SuperSubLevel(7, p, 6);

    public static SuperSubLevel[] levelOrder = new SuperSubLevel[] {_1s2, _2s2, _2p6, _3s2, _3p6, _4s2, _3d10, _4p6, _5s2, _4d10, _5p6, _6s2,
                                                             _4f14, _5d10, _6p6, _7s2, _5f14, _6d10, _7p6};

    public static List<SuperSubLevel> levelList = new ArrayList<SuperSubLevel>(Arrays.asList(levelOrder));

    public static class SubLevel {
        public String name;
        public int electrons;
        public SubLevel(int electrons1, String names) {
            electrons = electrons1;
            name = names;
        }
    }

    public static class SuperSubLevel {
        public SubLevel subLevel;
        public int place;
        public int superScript;
        public SuperSubLevel(int place1, SubLevel level, int superScpt) {
            place = place1;
            subLevel = level;
            superScript = superScpt;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof SuperSubLevel && CompareElementValue.superLevel.compare(this, (SuperSubLevel) obj) == 0;
        }

        @Override
        public String toString() {
            return place + "." + subLevel.name + "." + superScript;
        }
    }
}
