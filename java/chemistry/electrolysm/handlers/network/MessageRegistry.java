package chemistry.electrolysm.handlers.network;

import chemistry.electrolysm.handlers.network.message.MessageBunsenBurner;
import chemistry.electrolysm.proxy.CommonProxy;
import chemistry.electrolysm.reference.Referance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class MessageRegistry {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CommonProxy.MOD_ID_LOWER);
    public static void init(){
        INSTANCE.registerMessage(MessageBunsenBurner.class, MessageBunsenBurner.class, 0, Side.SERVER);
    }
}
