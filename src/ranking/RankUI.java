package ranking;

import javax.swing.*;

import main_menu.MainMenuUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankUI extends JPanel {
    private static List<List<Object>> listOfLists;
    private List<JLabel> labels;

    public void creerListe(String filename, int days) {
        List<Object> nouvelleListe = new ArrayList<>();
        nouvelleListe.add(filename);
        nouvelleListe.add(days);
        listOfLists.add(nouvelleListe);
    }

    static class DaysComparator implements Comparator<List<Object>> {
        @Override
        public int compare(List<Object> liste1, List<Object> liste2) {
            Integer save1Days = (Integer) liste1.get(1);
            Integer save2Days = (Integer) liste2.get(1);
            return save2Days.compareTo(save1Days);
        }
    }

    public RankUI() {
        listOfLists = new ArrayList<>();
        labels = new ArrayList<>();

        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout

        JButton button = new JButton("Close ranking");
        button.setPreferredSize(new Dimension(150, 30));

        button.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
            frame.dispose();
        });

        // Configurer la contrainte pour le bouton
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonConstraints.anchor = GridBagConstraints.WEST;
        buttonConstraints.insets = new Insets(10, 10, 10, 10); // Marges
        
        add(button, buttonConstraints);

        creerListe("Playerx", 10);
        creerListe("Playerx", 6);
        creerListe("Playerx", 30);
        creerListe("Playerx", 555);
        creerListe("Playerx", 87);
        creerListe("Playerx", 3);

        trierListes();
        writeInLabel();

        JFrame frame = new JFrame("Ranking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void writeInLabel() {
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(5, 10, 5, 10);

        for (List<Object> liste : listOfLists) {
            JLabel label = new JLabel(String.format("%-15s => %d days", liste.get(0), liste.get(1)));
            labels.add(label);
            labelConstraints.gridy++;
            add(label, labelConstraints);
        }
    }

    public void trierListes() {
        Collections.sort(listOfLists, new DaysComparator());
    }

    public List<JLabel> getLabels() {
        return labels;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenuUI());
    }
}