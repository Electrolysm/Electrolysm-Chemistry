package electrolysm.api.powerSystem.tesla;

import electrolysm.api.powerSystem.prefab.TEPowerCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Clarky158 on 01/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TeslaTransmittingServer //implements ICustomTeslaServer
{

    static List<TeslaTower> towerList = new ArrayList<TeslaTower>();

    public static void registerSendingTesla(TeslaTower tower) {
        if (!towerList.contains(tower)) {
            towerList.add(tower);
        }
    }

    /**
     * Returns true if frequency is in use
     * @param frequency
     * @return
     */
    public static TeslaTower doesFrequencyExist(int frequency) {
        for (int i = 0; i < towerList.size(); i++) {
            if (towerList.get(i).getFreq() - frequency == 0) {
                return towerList.get(i);
            }
        }
        return null;
    }

    public static boolean removeTesla(TeslaTower tower) {
        if (towerList.contains(tower)) {
            towerList.remove(tower);
            return true;
        }
        return false;
    }

    public static TeslaTower getTeslaTower(World world, int x, int y, int z, int freq, int range) {
        for (int i = 0; i < towerList.size(); i++) {
            TeslaTower teslaTower = towerList.get(i);
            if (isInRange(teslaTower, x, y, z, range) && statsMatch(teslaTower, world.provider.dimensionId, freq)) {
                TileEntity te = world.getTileEntity(teslaTower.x(), teslaTower.y(), teslaTower.z());
                if (te instanceof TETeslaTower) {
                    ((TETeslaTower) te).registerReciever(new Receiver(world.provider.dimensionId, x, y, z, freq));
                    return teslaTower;
                }
            }
        }
        return null;
    }

    public static void clearTileEntities(){
        for (int i = 0; i < towerList.size(); i++) {
            if(towerList.get(i) != null && towerList.get(i).getTeslaTower() != null) {
                towerList.get(i).getTeslaTower().receiverList.clear();
            }
        }
    }

    private static boolean statsMatch(TeslaTower teslaTower, int worldID, int freq) {
        return teslaTower.getWorldData()[0] == worldID && teslaTower.getFreq() - freq == 0;
    }

    private static boolean isInRange(TeslaTower teslaTower, int x, int y, int z, int range) {
        return calculateDistance(x, y, z, teslaTower.getWorldData()[1], teslaTower.getWorldData()[2], teslaTower.getWorldData()[3]) <= range;
    }


    public static float calculateDistance(int x, int y, int z, int towerX, int towerY, int towerZ) {
        float xPower = (float) Math.pow((x - towerX), 2);
        float yPower = (float) Math.pow((y - towerY), 2);
        float zPower = (float) Math.pow((z - towerZ), 2);

        return (float) Math.sqrt(xPower + yPower + zPower);
    }

    public static float calculateDistance(double x, double y, double z, double towerX, double towerY, double towerZ) {
        return calculateDistance((int) x, (int) y, (int) z, (int) towerX, (int) towerY, (int) towerZ);
    }
}
