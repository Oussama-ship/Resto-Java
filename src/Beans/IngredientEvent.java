/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author jeanm
 */
public class IngredientEvent {
    private List<String> Ingredients;
    private String NomPlat;
    private int nbPlat;
    
    public List<String> getIngredients()
    {
        return Ingredients;
    }
    
    public int getNbPlat()
    {
        return nbPlat;
    }
    
    public IngredientEvent(List<String> l, int nb, String n)
    {
        Ingredients = l;
        nbPlat = nb;
        NomPlat = n;
    }

    /**
     * @return the NomPlat
     */
    public String getNomPlat() {
        return NomPlat;
    }
}
