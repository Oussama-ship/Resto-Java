/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Adrien et Jean
 */
public class Table implements Serializable{
    
    private String numTable;
    private List<CommandePlat> commandesPlat;
    private List<CommandePlat> platServi;
    private int nbMaxCouvert;
    private float addition;
    private boolean paye;
    private String nomServeur;
    private int nbCouvertsEnCours;
    private float prixBoissons;
    
    public Table(String n, int couvert)
    {
        numTable = n;
        commandesPlat = new ArrayList();
        platServi = new ArrayList();
        nbMaxCouvert = couvert;
        paye = false;
        prixBoissons = 0;
    }
    
    public Table(Table t)
    {
        numTable = t.getNumTable();
        commandesPlat = new ArrayList(t.getCommandesPlat());
        platServi = new ArrayList(t.getPlatServi());
        nbMaxCouvert = t.getNbMaxCouvert();
        addition = t.getAddition();
        nbCouvertsEnCours = t.getNbCouvertsEnCours();
        paye = t.isPaye();
        nomServeur = t.getNomServeur();
        prixBoissons = t.getPrixBoissons();
    }
    
    public String getNumTable() {
        return numTable;
    }

    public void setNumTable(String numTable) {
        this.numTable = numTable;
    }

    public int getNbMaxCouvert() {
        return nbMaxCouvert;
    }

    public void setNbMaxCouvert(int nbMaxCouvert) {
        this.nbMaxCouvert = nbMaxCouvert;
    }

    public float getAddition() {
        
        addition = 0f;
        
        for(CommandePlat i : platServi)
        {
            addition += (i.getPlat().getPrix())*i.getNombre();
        }
       
        return addition;
    }
    
    public void setAddition(float add)
    {
        this.addition = add;
    }
    
    public int getNbCouvertsEnCours() {
        return nbCouvertsEnCours;
    }
    public void setNbCouvertsEnCours(int nb)
    {
        nbCouvertsEnCours = nb;
    }
    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }
    
     public void AjouterCommande(CommandePlat cmd) {
         
         commandesPlat.add(cmd);
     }
     
     public List<CommandePlat> getCommandesPlat() {
        
         return commandesPlat;
    }
     
    public void AjouterPlatServi(CommandePlat cmd) {
         CommandePlat nouveau = new CommandePlat(cmd);
         platServi.add(nouveau);
    } 
     
     public List<CommandePlat> getPlatServi() {
        
         return platServi;
    }
     
     
     public void ListerCommande() {
         
         for(CommandePlat i : commandesPlat)
         {
             System.out.print(i.getPlat().getLibelle() + " (" + i.getPlat().getPrix() + " EUR) ");
             System.out.println("Quantité : " + i.getNombre());
         }
     }
     
     public void Recapitulatif(){
     
        System.out.println("Numero de table : " + numTable);
        System.out.println("Nombre max de couvert : " + nbMaxCouvert);
        System.out.println("Récapitulatif des commandes : ");
        ListerCommande();
        System.out.println("Montant a payer : " + getAddition());
        
        if(paye)
             System.out.println("L'addition a été réglée.");
        else
             System.out.println("L'addition n'a pas encore été réglée.");
        
        System.out.println("Vous avez été servi par : " + nomServeur);
     }
     
     public static void main(String[] args) {
        // TODO code application logic here
        
        PlatPrincipal p = new PlatPrincipal ("Poulet aux quatre poivres" , 17.50f);
        Dessert d = new Dessert ("Mousse au chocolat salée" , 5.00f);
        PlatPrincipal p2 = new PlatPrincipal ("Boulet sauce lapin" , 12.50f);
        Dessert d2 = new Dessert ("Crêpe au sucre" , 6.00f);
        CommandePlat C1 = new CommandePlat(p, 1);
        CommandePlat C2 = new CommandePlat(d, 1);
        CommandePlat C3 = new CommandePlat(p2, 1);
        CommandePlat C4 = new CommandePlat(d2, 2);
        Table t = new Table("G3", 4);
        
        t.AjouterCommande(C1);
        t.AjouterCommande(C2);
        t.AjouterCommande(C3);  
        t.AjouterCommande(C4);
        t.AjouterPlatServi(C1);
        t.AjouterPlatServi(C2);
        t.AjouterPlatServi(C3);
        t.AjouterPlatServi(C4);
        
        t.Recapitulatif();     
        
    }

    /**
     * @return the prixBoissons
     */
    public float getPrixBoissons() {
        return prixBoissons;
    }

    /**
     * @param prixBoissons the prixBoissons to set
     */
    public void setPrixBoissons(float prixBoissons) {
        this.prixBoissons = prixBoissons;
    }
}
