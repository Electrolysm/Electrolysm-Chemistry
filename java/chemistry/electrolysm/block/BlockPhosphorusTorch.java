package chemistry.electrolysm.block;

import chemistry.electrolysm.Chemistry;
import chemistry.electrolysm.client.particle.EntityPhosphorusFlameFX;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Clarky158 on 06/09/2014.
 */
public class BlockPhosphorusTorch extends BlockTorch
{
    public IIcon iconFX;

    public BlockPhosphorusTorch(){
        super();
        this.setCreativeTab(Chemistry.creativeTab);
        this.setBlockName(Names.Block.PHOSPHORUS_TORCH);
        this.setLightLevel(1F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        iconFX = reg.registerIcon("chemistry:phosFX");
        blockIcon = reg.registerIcon("chemistry:torch_on");
    }

    public float red = 1F, green = 1F, blue = 1F;
    public int RED_META = 1;
    public int GREEN_META = 2;
    public int BLUE_META = 4;

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float sideX,
                                    float sideY, float sideZ) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        red = 0F;
        blue = 0.2F;
        green = 0.9F;
        int l = world.getBlockMetadata(x, y, z);
        double d0 = (double) ((float) x + 0.5F);
        double d1 = (double) ((float) y + 0.7F);
        double d2 = (double) ((float) z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/blocks/particle/phosFX.png"));
        for(int i = 0; i < 2; i++) {
            if (l == 1) {
                world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPhosphorusFlameFX(world, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, red, green, blue));
            } else if (l == 2) {
                world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPhosphorusFlameFX(world, d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, red, green, blue));
            } else if (l == 3) {
                world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPhosphorusFlameFX(world, d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D, red, green, blue));
            } else if (l == 4) {
                world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPhosphorusFlameFX(world, d0, d1 + d3, d2 + d4, 0D, 0D, 0D, red, green, blue));
            } else {
                world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPhosphorusFlameFX(world, d0, d1, d2, 0.0D, 0.0D, 0.0D, red, green, blue));
            }
        }
    }
}
