package chemistry.electrolysm.client;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.reference.Names;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

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
public class RenderTileBunsenBurner extends TileEntitySpecialRenderer {

    ModelBunsenBurner model = new ModelBunsenBurner();
    boolean renderTripod, renderTestTube;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float v4) {
        renderTripod = tileEntity instanceof TileEntityBunsenBurner;
        renderTestTube = ((TileEntityBunsenBurner)tileEntity).hasTestTube();

        //System.out.println("render");
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(CommonProxy.MODEL_BUNSEN_BURNER);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        if(renderTripod){
            model.renderTripod(0.0625F);
            if(renderTestTube){
                model.renderTestTube(0.0625F);
            }
        }
        GL11.glPopMatrix();
    }
}
