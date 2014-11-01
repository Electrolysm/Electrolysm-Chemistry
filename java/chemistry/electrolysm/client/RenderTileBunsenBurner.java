package chemistry.electrolysm.client;

import chemistry.electrolysm.block.BlockBBElectric;
import chemistry.electrolysm.block.BlockBBGas;
import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.reference.Names;
import net.minecraft.block.Block;
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
        renderTripod = ((TileEntityBunsenBurner)tileEntity).hasStand();
        renderTestTube = ((TileEntityBunsenBurner)tileEntity).hasTestTube();

        //System.out.println("render");
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        rotateByMeta(tileEntity.getBlockMetadata());

        Block block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
        if(block instanceof BlockBBElectric){
            bindTexture(CommonProxy.MODEL_BB_ELECTRIC);
        } else if (block instanceof BlockBBGas){
            bindTexture(CommonProxy.MODEL_BB_GAS);
        } else {
            bindTexture(CommonProxy.MODEL_BUNSEN_BURNER);
        }
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        if(renderTripod){
            model.renderStand(0.0625F);
            if(renderTestTube){
                model.renderTestTube(0.0625F);
            }
        }
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
           GL11.glRotatef(180F, 0F, 1F, 0F);
        }
        else if(meta == 3)
        {
            //north
            GL11.glRotatef(90F, 0F, 1F, 0F);
        }
        else if(meta ==4)
        {
            //east
            GL11.glRotatef(0F, 0F, 1F, 0F);
        }
    }
}
