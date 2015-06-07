/*
 * Created by : Edward Leonardi
 */

package view;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import javax.swing.UIManager;

public class Synthetica 
{
    public Synthetica()
    {
        try 
        {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
