/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import GUI.PlatAPreparerDialog;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author jeanm
 */
public class DishReadyBean implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        PlatAPreparerDialog dial = new PlatAPreparerDialog(null, false, (PlatAPreparer)pce.getNewValue());
        dial.setVisible(true);
    }
    
}
