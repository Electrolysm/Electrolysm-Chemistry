package chemistry.electrolysm.handlers.network.message;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class MessageBunsenBurner implements IMessage, IMessageHandler<MessageBunsenBurner, IMessage>
{
    int x, y, z;
    boolean hasStand;

    public MessageBunsenBurner(TileEntityBunsenBurner te){
        x = te.xCoord;
        y = te.yCoord;
        z = te.zCoord;
        hasStand = te.hasStand();
    }

    public MessageBunsenBurner(){ }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        hasStand = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeBoolean(hasStand);
    }

    @Override
    public IMessage onMessage(MessageBunsenBurner msg, MessageContext ctx) {
        if(msg != null) {
            TileEntity te = MinecraftServer.getServer().getEntityWorld().getTileEntity(msg.x, msg.y, msg.z);
            if(te instanceof TileEntityBunsenBurner)
            {
                ((TileEntityBunsenBurner) te).setHasStand(msg.hasStand);
            }
        }
        return null;
    }
}
