/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.TooManyCoversException;
import MyUtils.StringSlicer;
import Resto.CommandePlat;
import Resto.Dessert;
import Resto.Plat;
import Resto.PlatPrincipal;
import Resto.Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import network.NetworkBasicServer;
import network.NetworkBasicClient;

/**
 *
 * @author Adrien et Jean
 */
public class MainSalle extends javax.swing.JFrame {
    
    private NetworkBasicServer ServSalle;
    private NetworkBasicClient ClientSalle;
    
    /**
     * @return the ServeurEnCours
     */
    public String getServeurEnCours() {
        return ServeurEnCours;
    }

    /**
     * @param ServeurEnCours the ServeurEnCours to set
     */
    public void setServeurEnCours(String ServeurEnCours) {
        this.ServeurEnCours = ServeurEnCours;
    }

    /**
     * Creates new form MainSalle
     */
    
    private List<Table> listeTable;
    private List<PlatPrincipal> listePlatPrincipal;
    private List<Dessert> listeDessert;
    
    private LinkedHashMap<String, PlatPrincipal> hashPlatPrincipal;
    private LinkedHashMap<String, Dessert> hashDessert;
    private LinkedHashMap<String, Table> hashTableTable;
    
    private Properties propLogin;
    private Properties prop;
    
    /**
     * @return the prop
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * @param prop the prop to set
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
    
    private String ServeurEnCours;
    
    public MainSalle(String s) {
        prop = new Properties();
        String outfile = System.getProperty("user.dir") + "\\config.properties";
        File monFile = new File(outfile);
        try
        {
            prop.load (new FileInputStream (monFile));
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !"); }
        catch (IOException e) { System.out.println("Aie : " + e.getMessage()); }
        
        propLogin = new Properties();
        outfile = System.getProperty("user.dir") + "\\Login.properties";
        monFile = new File(outfile);
        try
        {
            propLogin.load (new FileInputStream (monFile));
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !"); }
        catch (IOException e) { System.out.println("Aie : " + e.getMessage()); }
        
        ServeurEnCours = s;
        setTitle("Restaurant \"" + prop.getProperty("nomRestaurant") + "\" : " + ServeurEnCours);
        initComponents();
        initResto();
        ServSalle = new NetworkBasicServer(Integer.parseInt(getProp().getProperty("Port2")), platsPretsCheckBox);
        
        jMenuBar1.add(Box.createHorizontalGlue());
        
        JMenu jMenuParametres = new JMenu("Paramètres");
        jMenuBar1.add(jMenuParametres);
        JMenuItem jMenuItemSys = new JMenuItem("Infos système");
        
        jMenuItemSys.addActionListener(new java.awt.event.ActionListener() {
       
            public void actionPerformed(ActionEvent ae) {
               
                jMenuItemSysActionPerformed();
            }
        });
        
        jMenuParametres.add(jMenuItemSys);
        JMenuItem jMenuItemHeure = new JMenuItem("Paramètres de date-heure");
        jMenuParametres.add(jMenuItemHeure);
        
        jMenuItemHeure.addActionListener(new java.awt.event.ActionListener() {
       
            public void actionPerformed(ActionEvent ae) {
               
                jMenuItemHeureActionPerformed();
            }
        });
        
        JMenu jMenuAide = new JMenu("Aide");
        jMenuBar1.add(jMenuAide);
        JMenuItem jMenuItemDebut = new JMenuItem("Pour débuter");
        jMenuAide.add(jMenuItemDebut);
        
        jMenuItemDebut.addActionListener(new java.awt.event.ActionListener() {
       
            public void actionPerformed(ActionEvent ae) {
               
                jMenuItemDebutActionPerformed();
            }
        });
        
        JSeparator sep = new JSeparator();
        jMenuAide.add(sep);
        JMenuItem jMenuItemPropos = new JMenuItem("A propos de...");
        jMenuAide.add(jMenuItemPropos);
        
        jMenuItemPropos.addActionListener(new java.awt.event.ActionListener() {
       
            public void actionPerformed(ActionEvent ae) {
               
                jMenuItemProposActionPerformed();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        tableLabel = new javax.swing.JLabel();
        tableComboBox = new javax.swing.JComboBox<>();
        nbMaxCouvertTextLabel = new javax.swing.JLabel();
        nbMaxCouvertLabel = new javax.swing.JLabel();
        nbCouvertTextLabel = new javax.swing.JLabel();
        nbCouvertLabel = new javax.swing.JLabel();
        platsServisLabel = new javax.swing.JLabel();
        platsServisScrollPane = new javax.swing.JScrollPane();
        platsServisTextArea = new javax.swing.JTextArea();
        boissonsBarLabel = new javax.swing.JLabel();
        boissonsBarField = new javax.swing.JTextField();
        deviseLabel = new javax.swing.JLabel();
        ajouterButton = new javax.swing.JButton();
        additionLabel = new javax.swing.JLabel();
        estPayeeLabel = new javax.swing.JLabel();
        encaisserButton = new javax.swing.JButton();
        encodageDesCommandesLabel = new javax.swing.JLabel();
        platsDispoLabel = new javax.swing.JLabel();
        platsDispoComboBox = new javax.swing.JComboBox<>();
        quantitePlatLabel = new javax.swing.JLabel();
        quantitePlatField = new javax.swing.JTextField();
        commanderPlatsButton = new javax.swing.JButton();
        remarquesLabel = new javax.swing.JLabel();
        remarquesField = new javax.swing.JTextField();
        dessertsDispoLabel = new javax.swing.JLabel();
        dessertsDispoComboBox = new javax.swing.JComboBox<>();
        commanderDessertsButton = new javax.swing.JButton();
        quantiteDessertLabel = new javax.swing.JLabel();
        quantiteDessertField = new javax.swing.JTextField();
        separateur = new javax.swing.JSeparator();
        commandeAEnvoyerLabel = new javax.swing.JLabel();
        commandeAEnvoyerScrollPane = new javax.swing.JScrollPane();
        commandeAEnvoyerTextArea = new javax.swing.JTextArea();
        envoyerButton = new javax.swing.JButton();
        commandeEnvoyeeCheckBox = new javax.swing.JCheckBox();
        platsPretsCheckBox = new javax.swing.JCheckBox();
        lirePlatsDispoButton = new javax.swing.JButton();
        imgPngLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png")).getImage());

        tableLabel.setText("Table:");

        tableComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "?" }));
        tableComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableComboBoxActionPerformed(evt);
            }
        });

        nbMaxCouvertTextLabel.setText("Nombre maximum de couverts :");

        nbMaxCouvertLabel.setText("?");

        nbCouvertTextLabel.setText("Nombre de couverts :");

        nbCouvertLabel.setText("?");

        platsServisLabel.setText("Plats servis:");

        platsServisTextArea.setEditable(false);
        platsServisTextArea.setColumns(20);
        platsServisTextArea.setRows(5);
        platsServisTextArea.setText("RIEN");
        platsServisTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        platsServisScrollPane.setViewportView(platsServisTextArea);

        boissonsBarLabel.setText("Boissons (bar) :");

        boissonsBarField.setText("?");
        boissonsBarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boissonsBarFieldActionPerformed(evt);
            }
        });

        deviseLabel.setText("EUR");

        ajouterButton.setText("ajouter");
        ajouterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterButtonActionPerformed(evt);
            }
        });

        additionLabel.setText("Addition :");

        estPayeeLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        estPayeeLabel.setText("NON PAYEE");

        encaisserButton.setText("Encaisser");
        encaisserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        encaisserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encaisserButtonActionPerformed(evt);
            }
        });

        encodageDesCommandesLabel.setText("Encodage des commandes:");

        platsDispoLabel.setText("Plats :");

        platsDispoComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        platsDispoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platsDispoComboBoxActionPerformed(evt);
            }
        });

        quantitePlatLabel.setText("Quantité:");

        quantitePlatField.setText("?");
        quantitePlatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitePlatFieldActionPerformed(evt);
            }
        });

        commanderPlatsButton.setText("Commander plats");
        commanderPlatsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        commanderPlatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commanderPlatsButtonActionPerformed(evt);
            }
        });

        remarquesLabel.setText("Remarques :");

        remarquesField.setText("?");

        dessertsDispoLabel.setText("Desserts :");

        dessertsDispoComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        commanderDessertsButton.setText("Commander desserts");
        commanderDessertsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        commanderDessertsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commanderDessertsButtonActionPerformed(evt);
            }
        });

        quantiteDessertLabel.setText("Quantité:");

        quantiteDessertField.setText("?");
        quantiteDessertField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantiteDessertFieldActionPerformed(evt);
            }
        });

        commandeAEnvoyerLabel.setText("Commandes à envoyer :");

        commandeAEnvoyerTextArea.setEditable(false);
        commandeAEnvoyerTextArea.setColumns(20);
        commandeAEnvoyerTextArea.setRows(5);
        commandeAEnvoyerTextArea.setText("RIEN");
        commandeAEnvoyerTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        commandeAEnvoyerScrollPane.setViewportView(commandeAEnvoyerTextArea);

        envoyerButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        envoyerButton.setText("Envoyer");
        envoyerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        envoyerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerButtonActionPerformed(evt);
            }
        });

        commandeEnvoyeeCheckBox.setText("Commande envoyée");
        commandeEnvoyeeCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        commandeEnvoyeeCheckBox.setEnabled(false);
        commandeEnvoyeeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandeEnvoyeeCheckBoxActionPerformed(evt);
            }
        });

        platsPretsCheckBox.setText("Plats prêts");
        platsPretsCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        platsPretsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platsPretsCheckBoxActionPerformed(evt);
            }
        });

        lirePlatsDispoButton.setText("Lire plats disponibles");
        lirePlatsDispoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lirePlatsDispoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lirePlatsDispoButtonActionPerformed(evt);
            }
        });

        imgPngLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img.png"))); // NOI18N

        jMenu1.setText("Serveur");

        jMenuItem3.setText("Modifier mot de passe");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Ajouter un nouveau serveur");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tables");

        jMenuItem5.setText("Liste des tables");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Nombre total clients");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Somme des additions");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Plats");

        jMenuItem2.setText("Liste plats");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem8.setText("Liste desserts");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);
        jMenu4.add(jSeparator1);

        jMenuItem9.setText("Créer un plat");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Supprimer un plat");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separateur)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(platsServisLabel)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nbCouvertTextLabel)
                                            .addComponent(encodageDesCommandesLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nbCouvertLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nbMaxCouvertTextLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(nbMaxCouvertLabel)))
                                .addGap(179, 179, 179)))
                        .addComponent(platsServisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boissonsBarField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(deviseLabel))
                            .addComponent(boissonsBarLabel)
                            .addComponent(ajouterButton)
                            .addComponent(additionLabel)
                            .addComponent(estPayeeLabel)
                            .addComponent(encaisserButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dessertsDispoLabel)
                            .addComponent(platsDispoLabel)
                            .addComponent(commandeAEnvoyerLabel)
                            .addComponent(envoyerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(commanderDessertsButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(commanderPlatsButton)
                                            .addComponent(platsDispoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dessertsDispoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(156, 156, 156)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(remarquesLabel)
                                            .addComponent(quantitePlatLabel)
                                            .addComponent(quantiteDessertLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantiteDessertField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantitePlatField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(remarquesField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(commandeEnvoyeeCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(platsPretsCheckBox)
                                        .addGap(28, 28, 28)
                                        .addComponent(lirePlatsDispoButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(commandeAEnvoyerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(imgPngLabel)
                                        .addGap(48, 48, 48)))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tableLabel)
                                .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(platsServisLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nbMaxCouvertTextLabel)
                            .addComponent(nbMaxCouvertLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nbCouvertTextLabel)
                            .addComponent(nbCouvertLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boissonsBarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviseLabel)
                            .addComponent(boissonsBarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ajouterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(additionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estPayeeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encaisserButton))
                    .addComponent(platsServisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(encodageDesCommandesLabel)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(platsDispoLabel)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(platsDispoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addComponent(commanderPlatsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantitePlatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantitePlatLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(remarquesLabel)
                            .addComponent(remarquesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dessertsDispoLabel)
                    .addComponent(dessertsDispoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantiteDessertLabel)
                    .addComponent(quantiteDessertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(commanderDessertsButton)
                .addGap(18, 18, 18)
                .addComponent(separateur, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandeAEnvoyerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commandeAEnvoyerLabel)
                        .addGap(99, 99, 99)
                        .addComponent(envoyerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(imgPngLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandeEnvoyeeCheckBox)
                    .addComponent(platsPretsCheckBox)
                    .addComponent(lirePlatsDispoButton))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boissonsBarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boissonsBarFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_boissonsBarFieldActionPerformed

    private void encaisserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encaisserButtonActionPerformed
        // TODO add your handling code here:
        
        Table tmpTable = hashTableTable.get(tableComboBox.getSelectedItem());
        
        if(nbCouvertLabel.getText().equals("?") || tmpTable.getNbCouvertsEnCours() == 0)
        {
           JOptionPane.showMessageDialog(null, "Aucune addition à encaisser.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            EncaisserFrame encaisser = new EncaisserFrame(null, true, tmpTable);
            encaisser.setVisible(true);
            
            if(encaisser.isEncaisser())
            {
                estPayeeLabel.setText("PAYEE");
                nbCouvertLabel.setText("0");
            }
            updatePlatServis(tmpTable);
            updatePlatCommander(tmpTable);
        }   
    }//GEN-LAST:event_encaisserButtonActionPerformed

    private void quantitePlatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitePlatFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitePlatFieldActionPerformed

    private void quantiteDessertFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantiteDessertFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantiteDessertFieldActionPerformed

    private void envoyerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerButtonActionPerformed
        // TODO add your handling code here:
        
        commandeAEnvoyerTextArea.setText("RIEN");
        commandeEnvoyeeCheckBox.setSelected(false);
        
        Table tmpTable = hashTableTable.get(tableComboBox.getSelectedItem());
        
        
        SimpleDateFormat h = new SimpleDateFormat ("HH:mm");
        Date heure = new Date();
        String allCommandes = tmpTable.getNumTable();
        for(CommandePlat i : tmpTable.getCommandesPlat())
        {
            allCommandes += "/";
            allCommandes += i.toString();
        }
        allCommandes += "/";
        allCommandes += h.format(heure);
        String reponse = ClientSalle.sendString(allCommandes);
        if(!reponse.equals(""))
        {
            commandeEnvoyeeCheckBox.setSelected(true);
            StringSlicer slice = new StringSlicer(reponse, ":");
            LinkedHashSet<String> plat = slice.listUniqueComponents();
            for(String i : plat)
            {
                if(!i.equals(""))
                {
                    StringSlicer parse = new StringSlicer(i, "@");
                    List<String> codePlat = parse.listComponents();
                    for(CommandePlat j : tmpTable.getCommandesPlat())
                    {
                        if(j.getPlat().getCode().equals(codePlat.get(0)) && tmpTable.getNumTable().equals(codePlat.get(1)))
                        {
                            tmpTable.AjouterPlatServi(j);
                        }
                    }
                    codePlat.clear();
                }
            }
            tmpTable.getCommandesPlat().clear();
            updatePlatServis(tmpTable);
            saveTable();
            JOptionPane.showMessageDialog(this, "Commande recue!");
        }
    }//GEN-LAST:event_envoyerButtonActionPerformed

    private void commandeEnvoyeeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandeEnvoyeeCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commandeEnvoyeeCheckBoxActionPerformed

    private void platsDispoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platsDispoComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_platsDispoComboBoxActionPerformed

    private void tableComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboBoxActionPerformed
        // TODO add your handling code here:
        if(ClientSalle == null)
        {
            ClientSalle = new NetworkBasicClient("localhost", Integer.parseInt(getProp().getProperty("Port1")));
        }
        if(tableComboBox.getSelectedItem() == "?")
            nbMaxCouvertLabel.setText("?");
        
        else
        {
            ServeurEnCours changerServeur = new ServeurEnCours(null, true, this);
            changerServeur.setVisible(true);    
            Table tmpTable = hashTableTable.get(tableComboBox.getSelectedItem());
            nbCouvertLabel.setText(String.valueOf(tmpTable.getNbCouvertsEnCours()));
            int tmpNbCouvert = tmpTable.getNbMaxCouvert();
            nbMaxCouvertLabel.setText(String.valueOf(tmpNbCouvert));
            updatePlatServis(tmpTable);
            updatePlatCommander(tmpTable);
            saveTable();
        }
    }//GEN-LAST:event_tableComboBoxActionPerformed

    private void commanderPlatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commanderPlatsButtonActionPerformed
        // TODO add your handling code here:
        
        if(tableComboBox.getSelectedItem() != "?" && !(quantitePlatField.getText().equals("?")))
        {
            try{
                addCouvert(parseInt(quantitePlatField.getText()));
                Table tmpTable = hashTableTable.get(tableComboBox.getSelectedItem());
                tmpTable.setNbCouvertsEnCours(parseInt(nbCouvertLabel.getText()));
                
                String tmpString = platsDispoComboBox.getSelectedItem().toString();
                String[] tmpCode = tmpString.split("\\:");
                PlatPrincipal tmpPlatPrincipal = hashPlatPrincipal.get(tmpCode[0]);
                boolean trouve = false;
                
                for(CommandePlat i : tmpTable.getCommandesPlat())
                {
                    if(i.getPlat().getCode().equals(tmpPlatPrincipal.getCode()))
                    {
                        i.setNombre(i.getNombre() + parseInt(quantitePlatField.getText()));
                        trouve = true;
                        break;
                    }
                }

                if(!trouve)
                {
                    CommandePlat tmpCommande = new CommandePlat(tmpPlatPrincipal, parseInt(quantitePlatField.getText()));
                    tmpTable.AjouterCommande(tmpCommande);  
                }
                
                String listePlat = "";

                for(CommandePlat i : tmpTable.getCommandesPlat())
                {
                    listePlat += i.getNombre() + " " + i.getPlat() + "\n";
                }

                commandeAEnvoyerTextArea.setText(listePlat);
                estPayeeLabel.setText("NON PAYEE");
                saveTable();
            
            }catch(TooManyCoversException e){
                
                 JOptionPane.showMessageDialog(null, "Nombre de couvert max : " + e.getCouvert(), "Trop de couvert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_commanderPlatsButtonActionPerformed

    private void addCouvert(int couvert) throws TooManyCoversException
    {
        int tmpNbCouvert = 0;
        
        if(!(nbCouvertLabel.getText().equals("?")))
           tmpNbCouvert += parseInt(nbCouvertLabel.getText());
        
        if(tmpNbCouvert + couvert > parseInt(nbMaxCouvertLabel.getText()))
            throw new TooManyCoversException(parseInt(nbMaxCouvertLabel.getText()));
        else
        {
            tmpNbCouvert += couvert;
            nbCouvertLabel.setText(String.valueOf(tmpNbCouvert));
        }
    }
    
    private void commanderDessertsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commanderDessertsButtonActionPerformed
        // TODO add your handling code here:
        
        if(tableComboBox.getSelectedItem() != "?" && !(quantiteDessertField.getText().equals("?")))
        {
            String tmpString = dessertsDispoComboBox.getSelectedItem().toString();
            String[] tmpCode = tmpString.split("\\:");
            Dessert tmpDessert = hashDessert.get(tmpCode[0]);
            Table tmpTable = hashTableTable.get(tableComboBox.getSelectedItem());
            
            boolean trouve = false;
                
            for(CommandePlat i : tmpTable.getCommandesPlat())
            {
                if(i.getPlat().getCode().equals(tmpDessert.getCode()))
                {
                    i.setNombre(i.getNombre() + parseInt(quantiteDessertField.getText()));
                    trouve = true;
                    break;
                }
            }

            if(!trouve)
            {
                CommandePlat tmpCommande = new CommandePlat(tmpDessert, parseInt(quantiteDessertField.getText()));
                tmpTable.AjouterCommande(tmpCommande);  
            }
            
            String listePlat = "";
            
            for(CommandePlat i : tmpTable.getCommandesPlat())
            {
                listePlat += i.getNombre() + " " + i.getPlat() + "\n";
            }
            
            commandeAEnvoyerTextArea.setText(listePlat);
            saveTable();
        }
    }//GEN-LAST:event_commanderDessertsButtonActionPerformed

    private void ajouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterButtonActionPerformed
        // TODO add your handling code here:
        float prixTot = hashTableTable.get(tableComboBox.getSelectedItem()).getPrixBoissons() + parseFloat(boissonsBarField.getText());
        hashTableTable.get(tableComboBox.getSelectedItem()).setPrixBoissons(prixTot);
        
        updatePlatServis(hashTableTable.get(tableComboBox.getSelectedItem()));
        saveTable();
    }//GEN-LAST:event_ajouterButtonActionPerformed

    private void platsPretsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platsPretsCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platsPretsCheckBoxActionPerformed

    private void lirePlatsDispoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lirePlatsDispoButtonActionPerformed
        // TODO add your handling code here:
        String message = ServSalle.getMessage();
        StringSlicer slice = new StringSlicer(message, ",");
        List<String> ligne = slice.listComponents();
        String show = "";
        for(String i : ligne)
        {
            StringSlicer parce = new StringSlicer(i, ":");
            List<String> morceau = parce.listComponents();
            String nomPlat;
           if(morceau.get(1).contains("PP_"))
               nomPlat = hashPlatPrincipal.get(morceau.get(1)).getLibelle();
           else
               nomPlat = hashDessert.get(morceau.get(1)).getLibelle();
            
            show += morceau.get(0) + " " + nomPlat + ", ";
        }
        show += "à enlever";
        JOptionPane.showMessageDialog(this, show);
    }//GEN-LAST:event_lirePlatsDispoButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        String oldMP = propLogin.getProperty(getServeurEnCours());
        ChangePassword changePW = new ChangePassword(null, true, oldMP);
        changePW.setVisible(true);
        if(changePW.IsPWGood())
        {
            String outfile = System.getProperty("user.dir") + "\\Login.properties";
             File FileParam = new File(outfile);
             try (OutputStream output = new FileOutputStream(FileParam)) 
            {
                propLogin.setProperty(getServeurEnCours(), changePW.getNewPassWord());
                propLogin.store(output, null);
                System.out.println(propLogin);
            } catch (IOException io) {
                io.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Mot de passe changer");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        ArrayList<Plat> tmpListe = new ArrayList<>(listePlatPrincipal);
        tmpListe.addAll(listeDessert);

        SupprimePlat suppPlat = new SupprimePlat(null, true, tmpListe);
        suppPlat.setVisible(true);
        
        if(suppPlat.isaSupprimer())
        {
            if(suppPlat.getTmpPlat() instanceof PlatPrincipal)
            {
               DefaultComboBoxModel comboBoxPlat = (DefaultComboBoxModel) this.platsDispoComboBox.getModel();
               listePlatPrincipal.remove(suppPlat.getTmpPlat());
               comboBoxPlat.removeElement(suppPlat.getTmpPlat());
            }
            else
            {
               DefaultComboBoxModel comboBoxPlat = (DefaultComboBoxModel) this.dessertsDispoComboBox.getModel();
               listeDessert.remove(suppPlat.getTmpPlat());
               comboBoxPlat.removeElement(suppPlat.getTmpPlat());
            }
            
            try
            {
                String outFile = System.getProperty("user.dir") + "\\plats.txt";
                File file = new File(outFile);    
                // Créer l'objet File Reader
                FileWriter fr = new FileWriter(file);  
                // Créer l'objet BufferedReader        
                BufferedWriter br = new BufferedWriter(fr);  
                
                for(PlatPrincipal p : listePlatPrincipal)
                {

                    br.write("PP" + " & \"" + p.getLibelle() + "\" & " + p.getPrix() + "f");
                    br.newLine();
                }
                
                for(Dessert p : listeDessert)
                {

                    br.write("D" + " & \"" + p.getLibelle() + "\" & " + p.getPrix() + "f");
                    br.newLine();
                }
                
                br.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, "Le plat a été correctement supprimé.");
        }  
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        NewServeur NewServ = new NewServeur(null, true);
        NewServ.setVisible(true);
        if(NewServ.isValider())
        {
            String outfile = System.getProperty("user.dir") + "\\Login.properties";
            File FileParam = new File(outfile);
            try (OutputStream output = new FileOutputStream(FileParam)) 
            {
                propLogin.setProperty(NewServ.getNom(), NewServ.getMP());
                propLogin.store(output, null);
                System.out.println(propLogin);
            } catch (IOException io) {
                io.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Serveur enregistrer");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        String message = "";
        for(Table t : hashTableTable.values())
        {
            message += "Table " + t.getNumTable() + " :\n";
            message += "\tPlats commandé :\n";
            for(CommandePlat c : t.getCommandesPlat())
            {
                message += "\t\t- " + c.toString() + "\n";
            }
            message += "\tPlats servis :\n";
            for(CommandePlat c : t.getPlatServi())
            {
                message += "\t\t- " + c.toString() + "\n";
            }
            message += "\tAddistion : " + t.getAddition() + " EUR\n\n";
        }
        ListeTable liste = new ListeTable(null, true, message);
        liste.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        int nbClient = 0;
        for(Table t : hashTableTable.values())
        {
            nbClient += t.getNbCouvertsEnCours();
        }
        JOptionPane.showMessageDialog(this, "Nombre de clients: " + nbClient);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        float totAdd = 0;
        for(Table t : hashTableTable.values())
        {
            totAdd += t.getAddition();
        }
        JOptionPane.showMessageDialog(this, "Somme des additions: " + totAdd + " EUR");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String message = "";
        for(PlatPrincipal p : listePlatPrincipal)
        {
            message += "- " + p.toString() + "\n";
        }
        ListeTable liste = new ListeTable(null, true, message);
        liste.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        String message = "";
        for(Dessert d : listeDessert)
        {
            message += "- " + d.toString() + "\n";
        }
        ListeTable liste = new ListeTable(null, true, message);
        liste.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        AjoutPlat ajoutPlat = new AjoutPlat(null, true);
        ajoutPlat.setVisible(true);
        
        if(ajoutPlat.isAccepte())
        {
            
            String code = "";
            
            if(ajoutPlat.getTypePlat().equals("Plat principal")){
                
                code = "PP";
                DefaultComboBoxModel comboBoxPlat = (DefaultComboBoxModel) this.platsDispoComboBox.getModel();
                PlatPrincipal platTmp = new PlatPrincipal(ajoutPlat.getNomPlat(), ajoutPlat.getPrixPlat());
               
                AjoutePlatPrincipal(platTmp);
                hashPlatPrincipal.put(platTmp.getCode(), platTmp);
                comboBoxPlat.addElement(platTmp); 
            }
            
            else{
                
                code = "D";
                DefaultComboBoxModel comboBoxPlat = (DefaultComboBoxModel) this.dessertsDispoComboBox.getModel();
                Dessert dessertTmp = new Dessert(ajoutPlat.getNomPlat(), ajoutPlat.getPrixPlat());
               
                AjouteDessert(dessertTmp);
                hashDessert.put(dessertTmp.getCode(), dessertTmp);
                comboBoxPlat.addElement(dessertTmp); 
            }
           
            try
            {
                String outFile = System.getProperty("user.dir") + "\\plats.txt";
                File file = new File(outFile);    
                // Créer l'objet File Reader
                FileWriter fr = new FileWriter(file, true);  
                // Créer l'objet BufferedReader        
                BufferedWriter br = new BufferedWriter(fr);  
                
                br.write(code + " & \"" + ajoutPlat.getNomPlat() + "\" & " + ajoutPlat.getPrixPlat() + "f");
                br.newLine();
                
                
                br.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, "Plat ajouté avec succès!");
            
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    
    public void setServeurTable()
    {
        hashTableTable.get(tableComboBox.getSelectedItem()).setNomServeur(getServeurEnCours());
    }
    
    public void updateServeur(String newS)
    {
        setServeurEnCours(newS);
        setTitle("Restaurant \"Le gourmet audacieux\" : " + ServeurEnCours);
    }
    
    private void updatePlatServis(Table t)
    {
        String listePlat = "";
            
        for(CommandePlat i : t.getPlatServi())
        {
            listePlat += i.getNombre() + " " + i.getPlat() + "\n";
        }
        
        if(hashTableTable.get(tableComboBox.getSelectedItem()).getPrixBoissons() > 0)
        {
            listePlat += "Boissons avec repas (" + hashTableTable.get(tableComboBox.getSelectedItem()).getPrixBoissons() + " EUR)\n";
        }
        platsServisTextArea.setText(listePlat);
    }
    
    private void updatePlatCommander(Table t)
    {
        String listePlat = "";
            
        for(CommandePlat i : t.getCommandesPlat())
        {
            listePlat += i.getNombre() + " " + i.getPlat() + "\n";
        }
        
        commandeAEnvoyerTextArea.setText(listePlat);
    }
    
    public void AjouteTable(Table t) {
        
        listeTable.add(t);
    }
    
    private void creationHashMapTable()
    {
        for(Table i : listeTable)
        {
            hashTableTable.put(String.valueOf(i.getNumTable()), i);
        }
    }
    
     public void AjoutePlatPrincipal(PlatPrincipal p) {
        
        listePlatPrincipal.add(p);
    }
    
    private void creationHashMapPlatPrincipal()
    {
        for(PlatPrincipal i : listePlatPrincipal)
        {
            hashPlatPrincipal.put(i.getCode(), i);
        }
    }
    
     public void AjouteDessert(Dessert d) {
        
        listeDessert.add(d);
    }
    
    private void creationHashMapDessert()
    {
        for(Dessert i : listeDessert)
        {
            hashDessert.put(i.getCode(), i);
        }
    }
    
    private void initResto()
    {
        String outFile = System.getProperty("user.dir") + "\\tables.data";
        File fichierTable = new File(outFile);
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichierTable))) 
        {
            hashTableTable = (LinkedHashMap<String, Table>)input.readObject();
        } 
        catch (FileNotFoundException e) {
            System.err.println("Erreur fichier non trouvé! [" + e + "]");
        }
        catch (IOException io) {
            io.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MainSalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        listePlatPrincipal = new ArrayList();
        listeDessert = new ArrayList();
        
        if(hashTableTable == null)
        {
            hashTableTable = new LinkedHashMap<>();
            listeTable = new ArrayList();
            AjouteTable(new Table("G1" , 4));
            AjouteTable(new Table("G2" , 4));
            AjouteTable(new Table("G3" , 4));
            AjouteTable(new Table("C11" , 4));
            AjouteTable(new Table("C12" , 6));
            AjouteTable(new Table("C13" , 4));
            AjouteTable(new Table("C21" , 6));
            AjouteTable(new Table("C22" , 6));
            AjouteTable(new Table("D1" , 4));
            AjouteTable(new Table("D2" , 2));
            AjouteTable(new Table("D3" , 2));
            AjouteTable(new Table("D4" , 2));
            AjouteTable(new Table("D5" , 2));

            creationHashMapTable();
        }
        
        
        try
        {
          outFile = System.getProperty("user.dir") + "\\plats.txt";
          File file = new File(outFile);    
          // Créer l'objet File Reader
          FileReader fr = new FileReader(file);  
          // Créer l'objet BufferedReader        
          BufferedReader br = new BufferedReader(fr);   
          String line;
          while((line = br.readLine()) != null)
          {
              StringSlicer ligne = new StringSlicer(line, "&");
              List<String> composants = ligne.listComponents();
              String Code = composants.get(0);
              StringSlicer nom = new StringSlicer(composants.get(1), "\"");
              String nomPlat = nom.listComponents().get(1);
              float prix = Float.parseFloat(composants.get(2));
              if(Code.contains("PP"))
                   AjoutePlatPrincipal(new PlatPrincipal(nomPlat, prix));
              else
                  AjouteDessert(new Dessert(nomPlat , prix));
          }
          fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        hashPlatPrincipal = new LinkedHashMap<>();
        creationHashMapPlatPrincipal();
        
        hashDessert = new LinkedHashMap<>();
        creationHashMapDessert();
        
        
        remplirComboBox();
    }
    
    private void saveTable()
    {
        String outFile = System.getProperty("user.dir") + "\\tables.data";
        File fichierTable = new File(outFile);
        try (ObjectOutputStream input = new ObjectOutputStream(new FileOutputStream(fichierTable))) 
        {
             input.writeObject(hashTableTable);
             input.flush();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur fichier non trouvé! [" + e + "]");
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    private void remplirComboBox()
    {
        
        DefaultComboBoxModel comboBoxTable = (DefaultComboBoxModel) this.tableComboBox.getModel();
        
        for(Map.Entry<String, Table> i : hashTableTable.entrySet()) 
        {
            comboBoxTable.addElement(i.getKey());
	}
        
        DefaultComboBoxModel comboBoxPlat = (DefaultComboBoxModel) this.platsDispoComboBox.getModel();
        comboBoxPlat.removeAllElements();
        
        for(Map.Entry<String, PlatPrincipal> i : hashPlatPrincipal.entrySet()) 
        {
            comboBoxPlat.addElement(i.getValue());
	}
        
        DefaultComboBoxModel comboBoxDessert = (DefaultComboBoxModel) this.dessertsDispoComboBox.getModel();
        comboBoxDessert.removeAllElements();
        
        for(Map.Entry<String, Dessert> i : hashDessert.entrySet()) 
        {
            comboBoxDessert.addElement(i.getValue());
	}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSalle("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel additionLabel;
    private javax.swing.JButton ajouterButton;
    private javax.swing.JTextField boissonsBarField;
    private javax.swing.JLabel boissonsBarLabel;
    private javax.swing.JLabel commandeAEnvoyerLabel;
    private javax.swing.JScrollPane commandeAEnvoyerScrollPane;
    private javax.swing.JTextArea commandeAEnvoyerTextArea;
    private javax.swing.JCheckBox commandeEnvoyeeCheckBox;
    private javax.swing.JButton commanderDessertsButton;
    private javax.swing.JButton commanderPlatsButton;
    private javax.swing.JComboBox<String> dessertsDispoComboBox;
    private javax.swing.JLabel dessertsDispoLabel;
    private javax.swing.JLabel deviseLabel;
    private javax.swing.JButton encaisserButton;
    private javax.swing.JLabel encodageDesCommandesLabel;
    private javax.swing.JButton envoyerButton;
    private javax.swing.JLabel estPayeeLabel;
    private javax.swing.JLabel imgPngLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton lirePlatsDispoButton;
    private javax.swing.JLabel nbCouvertLabel;
    private javax.swing.JLabel nbCouvertTextLabel;
    private javax.swing.JLabel nbMaxCouvertLabel;
    private javax.swing.JLabel nbMaxCouvertTextLabel;
    private javax.swing.JComboBox<String> platsDispoComboBox;
    private javax.swing.JLabel platsDispoLabel;
    private javax.swing.JCheckBox platsPretsCheckBox;
    private javax.swing.JLabel platsServisLabel;
    private javax.swing.JScrollPane platsServisScrollPane;
    private javax.swing.JTextArea platsServisTextArea;
    private javax.swing.JTextField quantiteDessertField;
    private javax.swing.JLabel quantiteDessertLabel;
    private javax.swing.JTextField quantitePlatField;
    private javax.swing.JLabel quantitePlatLabel;
    private javax.swing.JTextField remarquesField;
    private javax.swing.JLabel remarquesLabel;
    private javax.swing.JSeparator separateur;
    private javax.swing.JComboBox<String> tableComboBox;
    private javax.swing.JLabel tableLabel;
    // End of variables declaration//GEN-END:variables

    private void jMenuItemSysActionPerformed() {
        
       String infos = "Système d'exploitation : " + System.getProperty("os.name") + "\nRepertoire courant : " + System.getProperty("user.dir") + "\nVersion Java : " + System.getProperty("java.version");
       JOptionPane.showMessageDialog(this, infos);
    }
    private void jMenuItemHeureActionPerformed() 
    {
        demanderFormat dm = new demanderFormat(null, true, prop.getProperty("date.format"));
        dm.setVisible(true);
        
        if(dm.isValider())
        {
            String outfile = System.getProperty("user.dir") + "\\config.properties";
            File FileParam = new File(outfile);
            try (OutputStream output = new FileOutputStream(FileParam)) 
           {
               prop.setProperty("date.format", dm.getFormat());
               prop.store(output, null);
               System.out.println(prop);
           } catch (IOException io) {
               io.printStackTrace();
           }
           JOptionPane.showMessageDialog(this, "Format changé.");
        }
    }
    
    private void jMenuItemDebutActionPerformed() {
        
       String infos = "Pour une utilisation optimale de l'application, les applications peuvent être lancées dans n'importe quel ordre, car nous sommes des programmateurs de GÉNIE.\nCependant, assurez-vous d'avoir lancer l'application Cuisine avant de sélectionner une table dans l'application Salle.";
       JOptionPane.showMessageDialog(this, infos);
    }
    
     private void jMenuItemProposActionPerformed() {
        
       String infos = "Cette application a été développée dans une ambiance joyeuse et studieuse (merci Stack Overflow et les vidéos explicative de Sir Wagner).\nLe résultat devrait vous séduire ...\nEt vous devriez donc être obligé d'attribuer une (très) belle cote à ce travail\n\n(c) Martin Jean et Termini Adrien";
       JOptionPane.showMessageDialog(this, infos);
    }
}
