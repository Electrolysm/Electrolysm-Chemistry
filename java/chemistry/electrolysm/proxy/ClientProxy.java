package chemistry.electrolysm.proxy;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.client.RenderTileBunsenBurner;
import cpw.mods.fml.client.registry.ClientRegistry;

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
public class ClientProxy extends CommonProxy{

    public static void register(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBunsenBurner.class, new RenderTileBunsenBurner());
    }
}
