package chemistry.electrolysm.block;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import chemistry.electrolysm.init.ModItems;
import chemistry.electrolysm.reference.Names;
import chemistry.electrolysm.reference.Referance;
import chemistry.electrolysm.util.BlockModelBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;

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
public class BlockBunsenBurner extends BlockModelBase
{
    public BlockBunsenBurner() {
        super(Material.iron, Names.Block.BUNSEN_BURNER, 2.3F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBunsenBurner();
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        TileEntity worldTe = world.getTileEntity(x, y, z);
        if(worldTe instanceof TileEntityBunsenBurner) {
            TileEntityBunsenBurner te = (TileEntityBunsenBurner) worldTe;
            if(te.isActive()) {
                double d0 = (double) ((float) x + 0.5F);
                double d1 = (double) ((float) y + 0.7F);
                double d2 = (double) ((float) z + 0.5F);

                for (int i = 0; i < 10; i++) {
                    world.spawnParticle("flame", d0, d1 + 0.12F, d2, 0.0D, 0.0D, 0.0D);
                    world.spawnParticle("smoke", d0, d1 + 0.12F, d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
                                    float sideX, float sideY, float sideZ) {
        if(world.getTileEntity(x, y, z) instanceof TileEntityBunsenBurner){
            TileEntityBunsenBurner te = (TileEntityBunsenBurner) world.getTileEntity(x, y, z);
            if(player.isSneaking() && player.getHeldItem() == null) {
                if(te.hasStand()) {
                    if (!world.isRemote) {
                        player.dropItem(ModItems.stand, 1);
                    }
                    te.setHasStand(false);
                    return true;
                }
            }
            else {
                if(te.hasStand()) {
                    player.openGui(Chemistry.instance, Referance.GUI.GUI_BUNSEN_BURNER_ID, world, x, y, z);
                    return true;
                } else {
                    if(world.isRemote) {
                        player.addChatMessage(new ChatComponentTranslation(I18n.format(Names.MESSAGES.MISSING_STAND)));
                    }
                }
            }
        }
        return false;
    }
}
