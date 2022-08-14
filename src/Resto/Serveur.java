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
public class Serveur 
{

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private String nom;
    private String prenom;
    private String login;
    private String carteID;
    private String password;
    
    public Serveur(String n, String p, String pw, String c)
    {
        nom = n;
        prenom = p;
        password = pw;
        login = genererLogin();
        carteID = c;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
        login = genererLogin();
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
        login = genererLogin();
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        if(nom.isEmpty() || prenom.isEmpty())
            throw new UnsupportedOperationException("Erreur login");
        
        return login;
    }

    /**
     * @return the carteID
     */
    public String getCarteID() {
        return carteID;
    }

    /**
     * @param carteID the carteID to set
     */
    public void setCarteID(String carteID) {
        this.carteID = carteID;
    }
    
    /**
     * Surcharge de la methode toString
     */
    
    @Override
    public String toString()
    {
        return nom + " " + prenom + " " + login + " " + carteID;
    }
    
    private String genererLogin()
    {
        if(nom.isEmpty() || prenom.isEmpty())
            throw new UnsupportedOperationException("Impossible de generer le login : le nom et/ou le prenom sont vides");
        
        String tmp = nom + prenom.substring(0, 2);
        
        return tmp.toLowerCase();
    }  
}
