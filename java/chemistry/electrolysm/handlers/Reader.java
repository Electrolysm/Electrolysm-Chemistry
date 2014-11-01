package chemistry.electrolysm.handlers;

import chemistry.electrolysm.handlers.Downloader;
import net.minecraft.item.ItemStack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Clarky158 on 01/11/2014.
 */
public class Reader
{
    public static int getFuelValue(ItemStack stack) {
        String csvFile = "config/electrolysm/fuelValue.csv";
        String line = "";
        String fuelName = stack.getDisplayName().toLowerCase();
        BufferedReader br = null;
        Downloader.downloadURL("https://raw.githubusercontent.com/Electrolysm/Electrolysm-Chemistry/master/resources/assets/chemistry/fuelValue.csv",
                csvFile);

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fuel = line.split(",");

                System.out.println("name= " + fuel[0] + ", fuelValue= " + fuel[1]);

                if(fuel[0].equals(fuelName)){
                    return Integer.parseInt(fuel[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
