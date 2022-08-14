/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import MyUtils.StringSlicer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author jeanm
 */
public class GetRecipeBean implements TableModelListener {
    private ArrayList<IngredientListener> mailingList;
    
    public GetRecipeBean()
    {
        mailingList = new ArrayList<>();
    }
    
    public void addIngredientListener(IngredientListener e)
    {
        mailingList.add(e);
    }
    
    public void removeIngredientListener(IngredientListener e)
    {
        mailingList.remove(e);
    }
    
    public void notifyIngredientEvent(List<String> l, int nb, String n)
    {
        IngredientEvent e = new IngredientEvent(l, nb, n);
        
        for(IngredientListener i : mailingList)
            i.IngredientReceived(e);
    }
    
    public void tableChanged(TableModelEvent e)
    {
        TableModel model = (TableModel) e.getSource();
        Properties prop = new Properties();
        if(e.getColumn() == 4 && (boolean)model.getValueAt(e.getFirstRow(), 4) == true)
        {
            String outfile = System.getProperty("user.dir") + "\\Ingredients.properties";
            File monFile = new File(outfile);
            try
            {
                prop.load (new FileInputStream (monFile));
            }
            catch (FileNotFoundException c) { System.out.println("Fichier de propriétés non trouvé !"); }
            catch (IOException c) { System.out.println("Aie : " + c.getMessage()); }
            
            String Ingredients = prop.getProperty(model.getValueAt(e.getFirstRow(), 1).toString());
            StringSlicer slice = new StringSlicer(Ingredients, ";");
            List<String> listeIngredients = slice.listComponents();
            
            notifyIngredientEvent(listeIngredients, Integer.parseInt(model.getValueAt(e.getFirstRow(), 0).toString()), model.getValueAt(e.getFirstRow(), 1).toString());
        }
    }
}
