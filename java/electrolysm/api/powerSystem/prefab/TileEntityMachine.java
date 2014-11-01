package electrolysm.api.powerSystem.prefab;

import electrolysm.api.powerSystem.interfaces.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Ben on 17/07/2014.
 */
public class TileEntityMachine extends TileEntity implements IConnector, IWorkableMachine, ITeUNetworkTE
{

    TileEntity[] adjConnections = new TileEntity[6];

    @Override
    public boolean canConnect(ForgeDirection from, Object source) {
        if(source instanceof TileEntity)
        {
            TileEntity te = (TileEntity)source;
            if(te instanceof IConnector)
            {
                IConnector con = (IConnector)te;
                adjConnections[from.ordinal()] = te;
                return con.canConnect(from.getOpposite());
            }
        }
        adjConnections[from.ordinal()] = null;
        return false;
    }

    @Override
    public boolean canConnect(ForgeDirection side) {
        return true;
    }

    @Override
    public boolean[] getVisualConnections() {
        return null;
    }

    @Override
    public TileEntity[] getAdjConnections() {
        return adjConnections;
    }

    IPowerCore powerCore = null;
    IPowerCore lastCore = null;

    @Override
    public void updateEntity() {
        for (byte i = 0; i < 6; i++)
        {
            //System.out.println("updated Connections");
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.canConnect(dir, this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                    this.zCoord + dir.offsetZ));
        }
        Random rand = new Random();
        if(powerCore == null) {
            if(rand.nextInt(50) == 5) {
                powerCore = findCore(worldObj, xCoord, yCoord, zCoord);
            }
        } else {
            if(rand.nextInt(100) == 5) {
                powerCore = findCore(worldObj, xCoord, yCoord, zCoord);
            }
        }

        if(powerCore != null) {
            powerCore.registerOnNetwork(this);
            lastCore = powerCore;
        }
        else if(lastCore != null)
        {
            lastCore.clearNetwork();
            lastCore = null;
        }
    }

    @Override
    public IPowerCore findCore(World world, int x, int y, int z) {
        TileEntity[] adj = this.adjConnections;
        for (int i = 0; i < adj.length; i++) {
            if (adj[i] != null && adj[i] instanceof IConnector) {
                if (adj[i] instanceof IPowerCore) {
                    return (IPowerCore) adj[i];
                } else {
                    if (adj[i] instanceof ICable) {
                        ICable cable = (ICable) adj[i];
                        return cable.findCore(ForgeDirection.getOrientation(i).getOpposite(), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean canWork(int teu) {
        if(powerCore != null) {
            float amps = this.getAmps(teu);
            return (powerCore.canDrain(teu));
        }

        return false;
    }

    @Override
    public void work(int teU) {
        float amps = this.getAmps(teU);
        if(powerCore != null && powerCore.canDrain(teU))
        {
            powerCore.drainPower(teU);
        }
    }

    public float getAmps(int teu)
    {
        return (float)(Math.abs(Math.sin(teu)));
    }
}
