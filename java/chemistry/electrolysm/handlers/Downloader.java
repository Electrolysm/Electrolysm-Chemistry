package chemistry.electrolysm.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Clarky158 on 01/11/2014.
 */
public class Downloader
{
    public static void downloadURL(String url, String downLoc){
        try
        {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(new File(downLoc));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch(FileNotFoundException e) { }
        catch (MalformedURLException e) { }
        catch (IOException e){ }
    }
}
