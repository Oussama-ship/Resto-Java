/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto;

import java.io.Serializable;

/**
 *
 * @author Adrien
 */
public class CommandePlat implements Serializable {

    private Plat plat;
    private int nombre;
     
    public CommandePlat(Plat p, int n)
    {
       plat = p;
       nombre = n;
    }
    public CommandePlat(CommandePlat c)
    {
        if(c.getPlat() instanceof PlatPrincipal)
            plat = new PlatPrincipal((PlatPrincipal)c.getPlat());
        if(c.getPlat() instanceof Dessert)
            plat = new Dessert((Dessert)c.getPlat());
        
        nombre = c.nombre;
    }
    
    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    {
        return getPlat() + "*" + getNombre();
    }
}
