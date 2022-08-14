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
public class PlatPrincipal extends Plat{
    
    public PlatPrincipal(String l, float p)
    {
        libelle = l;
        code = getCode();
        prix = p;
        categorie = CategoriePlat.PLATPRINCIPAL;
    }
    public PlatPrincipal(PlatPrincipal p)
    {
        super(p);
    }

    @Override
    public String getCode() {
       
        if(libelle.isEmpty())
            throw new UnsupportedOperationException("Impossible de generer le code : le libelle est vide");
       
        String tmp = libelle.replaceAll("\\B.|\\P{L}", "").toUpperCase();
    
        return "PP_" + tmp;
    }  
}
