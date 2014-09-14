package chemistry.electrolysm.chemicals.Core;


import chemistry.electrolysm.chemicals.Values.MultiChemical;

import java.util.List;

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
public class Reaction
{
    public List<MultiChemical> inputs;
    public List<MultiChemical> outputs;
    private float energies;

    public Reaction(List<MultiChemical> in, List<MultiChemical> out)
    {
        inputs = in;
        outputs = out;
    }

    public String formEquation() {
        String in = String.valueOf(inputs).replace("[", "").replace("]", "").replace(",", " +");
        String out = String.valueOf(outputs).replace("[", "").replace("]", "").replace(",", " +");
        String arrow = "\u2192";
        return in + " " + arrow + " " + out;
    }

    public float getEnergies() {
        return energies;
    }

    public void setEnergies(float energies) {
        this.energies = energies;
    }

    public Reaction setEnergy(float e){
        this.energies = e;
        return this;
    }
}
