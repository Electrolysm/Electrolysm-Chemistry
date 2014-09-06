package chemistry.electrolysm.chemicals.Core;

/**
 * Created by Clarky158 on 14/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class IllformedEquationException extends Exception
{
    public String message;

    public IllformedEquationException(String msg)
    {
        message = msg;
    }

    @Override
    public void printStackTrace() {
        System.out.println("IllformedEquationException: An incorrect equation syntax has be used!");
        System.out.println("IllformedEquationException: Details: " + message);
        //super.printStackTrace();
    }
}
