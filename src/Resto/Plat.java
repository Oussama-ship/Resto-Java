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
public abstract class Plat implements Service, Serializable{
    
    
    protected double prix;
    protected String libelle;
    protected String code;
    protected CategoriePlat categorie;
    
    public Plat() {}
    public Plat(Plat p) 
    {
        prix = p.getPrix();
        libelle = p.getLibelle();
        code = p.getCode();
        categorie = p.getCategorie();
    }
    
    public abstract String getCode();
    
    @Override
    public double getPrix() {
        
        return prix;
    }

    @Override
    public String getLibelle() {
       
        return libelle;
    }

    @Override
    public String getNomCategorie() {
        
        return categorie.getNomCategorie();
    }
    
    @Override
    public String toString()
    {
        return getCode() + ": " + libelle + " (" + prix + " EUR) ";
    }

    public CategoriePlat getCategorie() {
        return categorie;
    }
}
