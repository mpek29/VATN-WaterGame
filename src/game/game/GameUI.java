package game;

import main_menu.MainMenuUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class GameUI extends JFrame {

    public GameUI(String name, CountryRessources country_ressources) {
        String gameName = MainMenuUI.name;    	
    	String[] answerOptions = {"Utiliser l'eau sans retenu","Prioriser les installations essentielles","Garder l'eau pour les animaux","Ne rien faire"};
    	CountryRessources[] answerChange = {new CountryRessources(1.0 , 1.0, 6, 10, 10, 10, 10),
    			new CountryRessources(2.0 , 1.0, 6, 10, 10, 10, 10),
    			new CountryRessources(3.0 , 1.0, 6, 10, 10, 10, 10),
    			new CountryRessources(4.0 , 1.0, 6, 10, 10, 10, 10)};
    	
    	QuizQuestion quiz_question = new QuizQuestion(
    		0,
    		"Votre pays fait face à un grand nombre de feu de forêt:",
    	    answerOptions,
    		answerChange);
   	
        // Config of the window
        setTitle("VATN : Jeu de sensibilisation à la gestion de l’eau"); // Title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 390); // Windows size
        setLocationRelativeTo(null); // Center the window at the screen
        getContentPane().setBackground(new java.awt.Color(170, 214, 243)); // Cyan color
        
		// Add of the title on the window
     // Mise à jour du titre avec le nom du jour en couleur
     
        
        JLabel labelTitle = new JLabel("VATN Jour " + quiz_question.getNumberQuestion()+name, JLabel.CENTER);
        labelTitle.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));

        // Ajout de la couleur au texte du jour
        labelTitle.setForeground(Color.white);  // Vous pouvez choisir une autre couleur

        add(labelTitle, java.awt.BorderLayout.NORTH);
        
        // Add of some information at the left part of the screen
        JPanel panelIndicationLeft = new JPanel();
        panelIndicationLeft.setPreferredSize(new Dimension(220, 10));

        JLabel availWaterLabel = new JLabel("Eau disponible : " + country_ressources.getAvailWater() + "L");
        JLabel requiredWaterLabel = new JLabel("Eau nécessaire : " + country_ressources.getRequiredWater() + "L");
        JLabel populationLabel = new JLabel("Population : " + country_ressources.getPopulation() + " millions");

        panelIndicationLeft.add(availWaterLabel);
        panelIndicationLeft.add(requiredWaterLabel);
        panelIndicationLeft.add(populationLabel);

        add(panelIndicationLeft, java.awt.BorderLayout.WEST);
        
        // Add of some information at the right part of the screen
        JPanel panelIndicationRight = new JPanel();
        panelIndicationRight.setPreferredSize(new Dimension(220, 10));

        JLabel satisfactionPopulationLabel = new JLabel("Satisfaction population : " + country_ressources.getStatisfPop() + "%");
        JLabel electricityLabel = new JLabel("Electricité : " + country_ressources.getElectricity() + "%");
        JLabel habitatLabel = new JLabel("Habitat : " + country_ressources.getHousing() + "%");
        JLabel foodLabel = new JLabel("Nourriture : " + country_ressources.getFoodQuantity() + "%");

        panelIndicationRight.add(satisfactionPopulationLabel);
        panelIndicationRight.add(electricityLabel);
        panelIndicationRight.add(habitatLabel);
        panelIndicationRight.add(foodLabel);

        add(panelIndicationRight, java.awt.BorderLayout.EAST);
        
        // Add of the question and the proposed replies at the center of the screen
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(quiz_question.getQuestionStatement());
        questionLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        questionPanel.add(questionLabel);
        
        
        JRadioButton optionA = new JRadioButton("A: " + quiz_question.getAnswerOptions()[0]);
        JRadioButton optionB = new JRadioButton("B: " + quiz_question.getAnswerOptions()[1]);
        JRadioButton optionC = new JRadioButton("C: " + quiz_question.getAnswerOptions()[2]);
        JRadioButton optionD = new JRadioButton("D: " + quiz_question.getAnswerOptions()[3]);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(optionA);
        buttonGroup.add(optionB);
        buttonGroup.add(optionC);
        buttonGroup.add(optionD);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.add(optionA);
        optionsPanel.add(optionB);
        optionsPanel.add(optionC);
        optionsPanel.add(optionD);

        questionPanel.add(optionsPanel);
        add(questionPanel, java.awt.BorderLayout.CENTER);

        JButton bouton = new JButton("Valider");

        bouton.setPreferredSize(new Dimension(200, 100));
        bouton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));

        questionPanel.add(bouton);

        // Gestion de l'exécution de l'action lorsque le bouton est cliqué.
        bouton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Vérifiez la réponse sélectionnée
                        if (optionA.isSelected()) {
                            processSelectedAnswer(0);
                        } else if (optionB.isSelected()) {
                            processSelectedAnswer(1);
                        } else if (optionC.isSelected()) {
                            processSelectedAnswer(2);
                        } else if (optionD.isSelected()) {
                            processSelectedAnswer(3);
                        }
                     // Mettez à jour des nouvelles valeurs des ressources
                        availWaterLabel.setText("Eau disponible : " + country_ressources.getAvailWater() + "L");
                        requiredWaterLabel.setText("Eau nécessaire : " + country_ressources.getRequiredWater() + "L");
                        populationLabel.setText("Population : " + country_ressources.getPopulation() + " millions");
                        satisfactionPopulationLabel.setText("Satisfaction Population : " + country_ressources.getStatisfPop() + "%");
                        electricityLabel.setText("Electricité : " + country_ressources.getElectricity() + "%");
                        habitatLabel.setText("Habitat : " + country_ressources.getHousing() + "%");
                        foodLabel.setText("Nourriture : " + country_ressources.getFoodQuantity() + "%");
                    }

                    private void processSelectedAnswer(int selectedAnswerIndex) {
                        // Utilisez selectedAnswerIndex où vous en avez besoin
                        System.out.println("Numéro de la réponse choisie : " + selectedAnswerIndex);

                        // À la place de 2, utilisez selectedAnswerIndex pour obtenir la ressource correcte
                        country_ressources.changeRessources(quiz_question.getCountryRessources(selectedAnswerIndex));
                        System.out.println("Eau disponible après changement : " + country_ressources.getAvailWater());
                    }
                }
        );

        JButton saveButton = new JButton("Sauvegarder");

        saveButton.setPreferredSize(new Dimension(20, 10));
        saveButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        saveButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    SaveManagement saveTools = new SaveManagement();
                    saveTools.save(gameName,country_ressources);
                }
            }
        );
        
        questionPanel.add(saveButton);
        // Affichage de la fenêtre
        setVisible(true);
    }
}