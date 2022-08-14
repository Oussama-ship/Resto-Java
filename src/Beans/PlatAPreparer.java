/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author jeanm
 */
public class PlatAPreparer {

    /**
     * @return the NomPlat
     */
    public String getNomPlat() {
        return NomPlat;
    }

    /**
     * @param NomPlat the NomPlat to set
     */
    public void setNomPlat(String NomPlat) {
        this.NomPlat = NomPlat;
    }

    /**
     * @return the temps
     */
    public float getTemps() {
        return temps;
    }

    /**
     * @param temps the temps to set
     */
    public void setTemps(float temps) {
        this.temps = temps;
    }
    private String NomPlat;
    private float temps;
    
    public PlatAPreparer(String n, float t)
    {
        NomPlat = n;
        temps = t;
    }
}
