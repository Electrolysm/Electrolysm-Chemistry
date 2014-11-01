package chemistry.electrolysm.handlers.network.message;

import chemistry.electrolysm.block.te.TileEntityBunsenBurner;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 05/09/2014.
 */
public class MessageBunsenBurner implements IMessage, IMessageHandler<MessageBunsenBurner, IMessage>
{
    int x, y, z;
    double temp;
    int fuel;
    boolean hasStand;

    public MessageBunsenBurner(TileEntityBunsenBurner te){
        x = te.xCoord;
        y = te.yCoord;
        z = te.zCoord;
        temp = te.getTemp();
        hasStand = te.hasStand();
        fuel = te.fuelCount;
    }

    public MessageBunsenBurner(){ }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        temp = buf.readDouble();
        hasStand = buf.readBoolean();
        fuel = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeDouble(temp);
        buf.writeBoolean(hasStand);
        buf.writeInt(fuel);
    }

    @Override
    public IMessage onMessage(MessageBunsenBurner msg, MessageContext ctx) {
        if(msg != null) {
            TileEntity te = MinecraftServer.getServer().getEntityWorld().getTileEntity(msg.x, msg.y, msg.z);
            if(te instanceof TileEntityBunsenBurner)
            {
                ((TileEntityBunsenBurner) te).setHasStand(msg.hasStand);
                ((TileEntityBunsenBurner) te).setTemperature(msg.temp);
                ((TileEntityBunsenBurner) te).fuelCount = msg.fuel;
            }
        }
        return null;
    }
}
