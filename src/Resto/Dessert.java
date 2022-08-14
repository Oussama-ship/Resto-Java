/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto;

/**
 *
 * @author Adrien
 */
public class Dessert extends Plat{
    
     public Dessert(String l, float p)
    {
        libelle = l;
        code = getCode();
        prix = p;
        categorie = CategoriePlat.DESSERT;
    }
     
     public Dessert(Dessert d)
     {
            super(d);
     }
     
    @Override
    public String getCode() {
       
        if(libelle.isEmpty())
            throw new UnsupportedOperationException("Impossible de generer le code : le libelle est vide");
        
        String tmp = libelle.replaceAll("\\B.|\\P{L}", "").toUpperCase();
        
        return "D_" + tmp;
    }  
}
