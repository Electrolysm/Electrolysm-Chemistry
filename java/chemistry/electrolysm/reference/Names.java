package chemistry.electrolysm.reference;

/**
 * Created by Clarky158 on 15/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class Names
{
    public static class Block{
        public static final String MASS_SPEC = "massSpec";
        public static final String BUNSEN_BURNER = "bunsenBurner";
        public static final String PHOSPHORUS_TORCH = "phosphorusTorch";
    }

    public static class Items {
        public static final String TEST_TUBE = "testTube";
        public static final String STAND = "stand";
        public static final String CHEMICAL_TEST_TUBE = "chemicalTestTube";
    }

    public static class TileEntity {
        public static final String TE_MAS_SPEC = "TileEntityMassSpec";
        public static final String TE_BUNSEN_BURNER = "TileEntityBunsenBurner";
    }

    public class GUI {
        public static final String BUNSEN_GUI = "Bunsen Burner and Test Tube";
    }

    public class CHAT {
        public static final String MISSING_STAND = "chat.message.bunsen.standRequired";
    }
}
