/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legourmetaudacieux;

import GUI.DialogLogin;
import GUI.MainCuisine;
import GUI.MainSalle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Adrien et Jean
 */
public class LeGourmetAudacieux {

    /**
     * @param args the command line arguments
     */
    private static MainSalle salle;
    
    
     public static void main(String[] args) {
        // TODO code application logic here
//        String outfile = System.getProperty("user.dir") + "\\config.properties";
//        File FileParam = new File(outfile);
//        Properties prop = new Properties();
//        try (OutputStream output = new FileOutputStream(FileParam)) 
//        {
//            // set the properties value
//            prop.setProperty("nomRestaurant", "Le gourmet audacieux");
//            prop.setProperty("Port1","11000");
//            prop.setProperty("Port2","12000");
//            prop.setProperty("date.format", "HH:mm");
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//        
//        outfile = System.getProperty("user.dir") + "\\Login.properties";
//        FileParam = new File(outfile);
//        prop = new Properties();
//        try (OutputStream output = new FileOutputStream(FileParam)) 
//        {
//            prop.setProperty("Adrien","123");
//            prop.setProperty("Jean","456");
//            prop.setProperty("Wagner","789");
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }



//        String outfile = System.getProperty("user.dir") + "\\Ingredients.properties";
//        File FileParam = new File(outfile);
//        Properties prop = new Properties();
//        try (OutputStream output = new FileOutputStream(FileParam)) 
//        {
//            // set the properties value
//            prop.setProperty("PP_BSL", "viande hachee; sauce lapin; frite; salade");
//            prop.setProperty("PP_VAVSC","Vol;Vent;Champigions;pate feuillettee; croquettes");
//            prop.setProperty("PP_SAP","steak;peper;pate;roquette");
//            prop.setProperty("PP_PAFDM", "Paella;fruits;eau sallee; poisson rouge; etoile de mer");
//            prop.setProperty("D_MAC", "Mousse;Chocolat");
//            prop.setProperty("D_CAS", "Crepe;sucre");
//            prop.setProperty("D_DB", "Damme;blanche neige; chocolat");
//            prop.setProperty("D_SDF", "Salade;fruits");
//            prop.setProperty("D_FAC", "chocolat;Chocolat fondu");
//            prop.setProperty("D_CB", "Creme");
//            prop.setProperty("D_GDL", "gauffres;liegois");
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
        
//        outfile = System.getProperty("user.dir") + "\\Login.properties";
//        FileParam = new File(outfile);
//        prop = new Properties();
//        try (OutputStream output = new FileOutputStream(FileParam)) 
//        {
//            prop.setProperty("Adrien","123");
//            prop.setProperty("Jean","456");
//            prop.setProperty("Wagner","789");
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }



        
         DialogLogin firstlog = new DialogLogin(null, true);
         firstlog.setVisible(true);
         
         if(firstlog.isMPgood())
         {
            salle = new MainSalle(firstlog.getNomServeur());
            salle.setVisible(true);  
            salle.toFront();
         }
    }   
}
