package chemistry.electrolysm.proxy;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.block.te.TileEntityMassSpec;
import chemistry.electrolysm.client.RenderTileBunsenBurner;
import chemistry.electrolysm.client.RenderTileMassSpec;
import chemistry.electrolysm.client.itemRenderers.ItemRendererBunsenBurner;
import chemistry.electrolysm.client.itemRenderers.ItemRendererTripod;
import chemistry.electrolysm.init.ModBlocks;
import chemistry.electrolysm.init.ModItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

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
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMassSpec.class, new RenderTileMassSpec());

        MinecraftForgeClient.registerItemRenderer(ModItems.stand, new ItemRendererTripod());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bbGas), new ItemRendererBunsenBurner(0));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bbElectric), new ItemRendererBunsenBurner(1));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bunsenBurner), new ItemRendererBunsenBurner(2));
    }
}
