package main_menu;

import javax.swing.*;

import game.CountryRessources;
import game.GameUI;
import game.SaveManagement;
import ranking.RankUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MainMenuUI extends JFrame {
    public static String name;

    public MainMenuUI() {
       
        // Créer un objet JFrame
        super("VATN");
        // Configurer la taille de la fenêtre
        setSize(1080, 720);
        // Définir le comportement de fermeture
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(170, 214, 243)); // Cyan color
        

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gb);
        
        // Définir la police de caractères pour les boutons
        Font boutonFont = new Font("Arial", Font.PLAIN, 20);
        
        //Titre jeu
        JLabel label = new JLabel("VATN");
        
        //Définir la police de caractères pour le label
        label.setFont(new Font("Arial", Font.PLAIN, 50));

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 200, 0);
        gbc.gridx=0;
        gbc.gridy=0;
        add(label,gbc);
        
        // Lancer
        JButton bouton1 = new JButton("Lancer");
        bouton1.setFont(boutonFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.gridx=0;
        gbc.gridy=1;
        add(bouton1,gbc);
        
        // Entrée nom
        JTextField textField = new JTextField("Entrée un nom");
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 30, 0);
        gbc.gridx=2;
        gbc.gridy=1;
        add(textField,gbc);
        
        // Valider
        JButton bouton4 = new JButton("Valider");
        bouton4.setFont(boutonFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.gridx=3;
        gbc.gridy=1;
        add(bouton4,gbc);
        
        
        //Reprise partie
        JButton bouton3 = new JButton("Reprise de partie");
        bouton3.setFont(boutonFont);
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.gridx=0;
        gbc.gridy=2;
        add(bouton3,gbc);
        
        //Classement
        JButton bouton2 = new JButton("Classement");
        bouton2.setFont(boutonFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx=0;
        gbc.gridy=3;
        add(bouton2,gbc);   
        
       

        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifier si le nom est valide avant de lancer GameUI
                if (name != null && !name.isEmpty() && !name.equals("Entrée un nom")) {
                    CountryRessources countryRessources = new CountryRessources(10, 10, 60, 100, 100, 100, 100);
                    SwingUtilities.invokeLater(() -> new GameUI(name, countryRessources));
                } else {
                    // Afficher un message d'erreur si le nom n'est pas valide
                    JOptionPane.showMessageDialog(MainMenuUI.this, "Veuillez entrer un nom valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        bouton2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(() -> new RankUI());
                    }
                }
        );

        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifier si le nom est valide avant de lancer GameUI
                if (name != null && !name.isEmpty() && !name.equals("Entrée un nom")) {
                    SaveManagement saveTool = new SaveManagement();
                    CountryRessources countryRessources = saveTool.load(name);
                    System.out.println(countryRessources.getAvailWater());
                    SwingUtilities.invokeLater(() -> new GameUI(name, countryRessources));
                } else {
                    // Afficher un message d'erreur si le nom n'est pas valide
                    JOptionPane.showMessageDialog(MainMenuUI.this, "Veuillez entrer un nom valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        // Ajouter un FocusListener pour gérer le texte par défaut
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Entrée un nom")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Vous pouvez choisir de rétablir le texte par défaut si nécessaire
                // par exemple, si l'utilisateur laisse la zone de texte vide
                if (textField.getText().isEmpty()) {
                    textField.setText("Entrée un nom");
                }
            }
        });
        
     // Ajouter un ActionListener pour détecter le clic sur le bouton "Valider"
        bouton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le nom lorsque le bouton "Valider" est cliqué
                String nomSaisi = textField.getText();
                name = nomSaisi;

            }
        });
        
        

        // Rendre la fenêtre visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new MainMenuUI());
    }
}