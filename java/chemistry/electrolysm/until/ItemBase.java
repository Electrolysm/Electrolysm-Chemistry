package chemistry.electrolysm.until;

import chemistry.electrolysm.Chemistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

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
public class ItemBase extends Item
{
    public ItemBase(String name){
        super();
        this.setCreativeTab(Chemistry.creativeTab);
        this.setUnlocalizedName(name);
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        itemIcon = reg.registerIcon("chemistry:" + this.getUnlocalizedName().replace(".name", "").replace("item.", ""));
    }
}
