package chemistry.electrolysm.chemicals.QuantumEnergyLevels;

import chemistry.electrolysm.chemicals.Rules.Rules;
import chemistry.electrolysm.chemicals.Values.ElementValue;

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
public class LevelCalculator {
    public static EnergyLevels.SuperSubLevel[] calculateShells(EnergyLevels.SuperSubLevel level) {
        EnergyLevels.SuperSubLevel newFullLevel = new EnergyLevels.SuperSubLevel(level.place, level.subLevel, level.subLevel.electrons);
        int pos = 0;
        for (int i = 0; i < EnergyLevels.levelOrder.length; i++) {
            if (newFullLevel.equals(EnergyLevels.levelOrder[i])) {
                pos = i;
            }
        }
        //System.out.println(pos);
        EnergyLevels.SuperSubLevel[] array = new EnergyLevels.SuperSubLevel[pos + 1];
        for (int i = 0; i < (pos); i++) {
            array[i] = EnergyLevels.levelOrder[i];
        }
        array[pos] = level;
        return array;
    }

    public static int[] calculateShells(ElementValue element, EnergyLevels.SuperSubLevel[] levels) {
        int _1 = 0, _2 = 0, _3 = 0, _4 = 0, _5 = 0, _6 = 0, _7 = 0;
        for (int z = 0; z < levels.length; z++) {
            //System.out.println(levels[z].toString() + " : " + z);
            if (levels[z].place - 1 == 0) {
                _1 = _1 + levels[z].superScript;
            } else if (levels[z].place - 2 == 0) {
                _2 = _2 + levels[z].superScript;
            } else if (levels[z].place - 3 == 0) {
                _3 = _3 + levels[z].superScript;
            } else if (levels[z].place - 4 == 0) {
                _4 = _4 + levels[z].superScript;
            } else if (levels[z].place - 5 == 0) {
                _5 = _5 + levels[z].superScript;
            } else if (levels[z].place - 6 == 0) {
                _6 = _6 + levels[z].superScript;
            } else if (levels[z].place - 7 == 0) {
                _7 = _7 + levels[z].superScript;
            }
        }
        return new Rules().applyShellRule(element, new int[]{_1, _2, _3, _4, _5, _6, _7});
    }

    public static int calculateOuterShell(int[] levels) {
        if(levels[6] != 0) { return levels[6]; }
        else if(levels[5] != 0) { return levels[5]; }
        else if(levels[4] != 0) { return levels[4]; }
        else if(levels[3] != 0) { return levels[3]; }
        else if(levels[2] != 0) { return levels[2]; }
        else if(levels[1] != 0) { return levels[1]; }
        else if(levels[0] != 0) { return levels[0]; }
        return 0;
    }
}
