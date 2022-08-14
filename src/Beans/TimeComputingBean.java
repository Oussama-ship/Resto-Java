/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author jeanm
 */
public class TimeComputingBean implements Serializable, IngredientListener {
    
    private PlatAPreparer platAPreparer;
    
    private PropertyChangeSupport propertySupport;
    
    public TimeComputingBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    public void IngredientReceived(IngredientEvent e)
    {
        float tmp = (((float)e.getIngredients().size()/3)*10)*e.getNbPlat();
        String nom = e.getNomPlat();
        setPlatAPreparer(new PlatAPreparer(nom, tmp));
    }
    
    public PlatAPreparer getPlatAPreparer() {
        return platAPreparer;
    }
    
    public void setPlatAPreparer(PlatAPreparer value) {
        PlatAPreparer oldValue = platAPreparer;
        platAPreparer = value;
        propertySupport.firePropertyChange("platAPreparer", oldValue, platAPreparer);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
