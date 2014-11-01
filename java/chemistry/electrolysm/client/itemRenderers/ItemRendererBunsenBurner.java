package chemistry.electrolysm.client.itemRenderers;

import chemistry.electrolysm.block.BlockBBElectric;
import chemistry.electrolysm.block.BlockBBGas;
import chemistry.electrolysm.client.ModelBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.util.ItemRenderBase;
import cpw.mods.fml.client.FMLClientHandler;
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
public class ItemRendererBunsenBurner extends ItemRenderBase {


    ModelBunsenBurner model = new ModelBunsenBurner();
    int meta;

    public ItemRendererBunsenBurner(int i) {
        super();
        meta = i;
    }

    @Override
    public void render(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glTranslatef(0.2F, 1F, 0F);

        if(meta == 0){
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_BB_GAS);
        } else if (meta == 1){
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_BB_ELECTRIC);
        } else {
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_BUNSEN_BURNER);
        }
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        // Render
        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        //model.renderStand(0.0625F);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}