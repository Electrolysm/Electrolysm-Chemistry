package chemistry.electrolysm.client;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 16/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class RenderTileMassSpec extends TileEntitySpecialRenderer {

    ModelMassSpec model = new ModelMassSpec();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float v4) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(CommonProxy.MODEL_MASS_SPEC);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        rotateByMeta(tileEntity.getBlockMetadata());
        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    private void rotateByMeta(int meta) {
        if(meta == 2)
        {
            //south
            GL11.glRotatef(-90F, 0F, 1F, 0F);
        }
        else if(meta == 5)
        {
            //west
            //GL11.glRotatef(90F, 0F, 1F, 0F);
        }
        else if(meta == 3)
        {
            //north
            GL11.glRotatef(90F, 0F, 1F, 0F);
        }
        else if(meta ==4)
        {
            //east
            GL11.glRotatef(180F, 0F, 1F, 0F);
        }
    }
}
