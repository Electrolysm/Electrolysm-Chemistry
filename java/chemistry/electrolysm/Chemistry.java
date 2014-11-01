package chemistry.electrolysm;

import chemistry.electrolysm.block.multiblock.PatternLoader;
import chemistry.electrolysm.chemicals.Chem.ElementRegistry;
import chemistry.electrolysm.chemicals.ChemicalSeparation;
import chemistry.electrolysm.handlers.GuiHandler;
import chemistry.electrolysm.handlers.network.MessageRegistry;
import chemistry.electrolysm.init.ChemistryTab;
import chemistry.electrolysm.proxy.ClientProxy;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.reference.Referance;
import chemistry.electrolysm.init.ModBlocks;
import chemistry.electrolysm.init.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

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

@Mod(modid = Referance.MOD_REF.MOD_ID, name = Referance.MOD_REF.MOD_ID, version = Referance.MOD_REF.VERSION/*, dependencies = "required-after:Electrolysm"*/)
public class Chemistry {

    public static CreativeTabs creativeTab = new ChemistryTab(CreativeTabs.getNextID(), Referance.MOD_REF.MOD_ID);
    public static CommonProxy proxy = new CommonProxy();
    @Mod.Instance(Referance.MOD_REF.MOD_ID)
    public static Chemistry instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        MessageRegistry.init();
        new ElementRegistry(event);
        new ChemicalSeparation(event);
        PatternLoader.addPatterns();
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void clientInit(FMLInitializationEvent event){
        ClientProxy.register();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        GameRegistry.addSmelting(ModItems.chemicalTestTube, new ItemStack(ModItems.testTube), 0F);
    }
}
