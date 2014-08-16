package chemistry.electrolysm.chemicals.Rules;

/**
 * Created by Clarky158 on 14/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class RuleShell extends Rule {
    public int[] electronConfig;
    public RuleShell(int[] config)
    {
        super();
        electronConfig = config;
    }
}
