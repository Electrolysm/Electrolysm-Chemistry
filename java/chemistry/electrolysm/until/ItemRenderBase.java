package chemistry.electrolysm.until;

import chemistry.electrolysm.proxy.CommonProxy;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
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
public class ItemRenderBase implements IItemRenderer{

    public ItemRenderBase(){}

    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType)
    {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... objects)
    {
        switch (type)
        {
            case ENTITY:
            {
                render(0, 1F, 0F);
                return;
            }
            case EQUIPPED:
            {
                render(0.25F, 1, 0.75F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                render(0, 1, 0);
                return;
            }
            case INVENTORY:
            {
                render(-0.2F, 0, 0);
                return;
            }
            default:
            {
            }
        }
    }

    public void render(float x, float y, float z) {
    }
}
