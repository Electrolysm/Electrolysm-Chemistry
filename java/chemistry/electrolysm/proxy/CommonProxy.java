package chemistry.electrolysm.proxy;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;

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
public class CommonProxy
{
    public static String MOD_ID_LOWER = Referance.MOD_REF.MOD_ID.toLowerCase().replace("electrolysm | ", "");
    public static ResourceLocation MODEL_BUNSEN_BURNER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelBunsenBurner.png");

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityBunsenBurner.class, Names.TileEntity.TE_BUNSEN_BURNER);
    }
}
