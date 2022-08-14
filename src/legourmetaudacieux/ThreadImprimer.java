/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legourmetaudacieux;

import GUI.ImpressionEnCours;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeanm
 */
public class ThreadImprimer extends Thread {
    
    private String FormatDate;
    
    public ThreadImprimer(String format)
    {
        FormatDate = format;
    }
    
    @Override
    public void run()
    {
        ImpressionEnCours imp = new ImpressionEnCours(null, false, FormatDate);
        imp.setVisible(true);
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadImprimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        imp.dispose();
    }

    /**
     * @return the FormatDate
     */
    public String getFormatDate() {
        return FormatDate;
    }

    /**
     * @param FormatDate the FormatDate to set
     */
    public void setFormatDate(String FormatDate) {
        this.FormatDate = FormatDate;
    }
}
