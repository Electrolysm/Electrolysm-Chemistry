package chemistry.electrolysm.proxy;

import chemistry.electrolysm.block.te.TileEntityAtomicCompressor;
import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.block.te.TileEntityCleaner;
import chemistry.electrolysm.block.te.TileEntityMassSpec;
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
    public static ResourceLocation MODEL_BB_GAS = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelBBGas.png");
    public static ResourceLocation MODEL_BB_ELECTRIC = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelBBElectric.png");
    public static ResourceLocation MODEL_MASS_SPEC = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelMassSpec.png");
    public static ResourceLocation MODEL_CLEANER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelCleaner.png");

    public static ResourceLocation GUI_MASS_SPEC = new ResourceLocation(MOD_ID_LOWER, "textures/gui/GuiMassSpec.png");
    public static ResourceLocation GUI_BUNSEN_BURNER = new ResourceLocation(MOD_ID_LOWER, "textures/gui/GuiBunsenBurner.png");
    public static ResourceLocation GUI_CLEANER = new ResourceLocation(MOD_ID_LOWER, "textures/gui/GuiCleaner.png");

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityBunsenBurner.class, Names.TileEntity.TE_BUNSEN_BURNER);
        GameRegistry.registerTileEntity(TileEntityMassSpec.class, Names.TileEntity.TE_MAS_SPEC);
        GameRegistry.registerTileEntity(TileEntityAtomicCompressor.class, Names.TileEntity.TE_ATOMIC_COMPRESSOR);
        GameRegistry.registerTileEntity(TileEntityCleaner.class, Names.TileEntity.TE_CLEANER);
    }
}
