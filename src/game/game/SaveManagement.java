package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class SaveManagement {

    private static final String DIRECTORY = "inc/data/saves/";

    public void save(String filename, CountryRessources myCountryRessources)
    {
        // Crée un fichier texte
        String fullPath = DIRECTORY + "/" + filename;
        try(PrintWriter ecri = new PrintWriter(new FileWriter(fullPath))){
                ecri.print(myCountryRessources.getAvailWater() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getRequiredWater() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getPopulation() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getStatisfPop() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getFoodQuantity() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getElectricity() + System.getProperty("line.separator" ));
                ecri.print(myCountryRessources.getHousing());
                ecri.flush();
                ecri.close();
            }
            catch (java.io.IOException e) {
                e.printStackTrace();
                System.err.println("Erreur lors de la sauvegarde dans le fichier : " + filename);
            }
    }

    public CountryRessources load(String filename){
        String fullPath = DIRECTORY + "/" + filename;
        try (BufferedReader lecteur = new BufferedReader(new FileReader(fullPath))) {
            double availWater = Double.parseDouble(lecteur.readLine());
            double requiredWater = Double.parseDouble(lecteur.readLine());
            int population = Integer.parseInt(lecteur.readLine());
            int statisfPop = Integer.parseInt(lecteur.readLine());
            int foodQuantity = Integer.parseInt(lecteur.readLine());
            int electricity = Integer.parseInt(lecteur.readLine());
            int housing = Integer.parseInt(lecteur.readLine());
            return new CountryRessources(availWater, requiredWater,population,statisfPop,foodQuantity,electricity,housing);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement du fichier : " + fullPath);
        }
        return null;
    }

    public void deleteFile(String filename) {
        String fullPath = DIRECTORY + "/" + filename;
        File file = new File(fullPath);

        // Verify the existence of the file
        if (file.exists()) {
            try {
                if (file.delete()) {
                    System.out.println("Le fichier a été supprimé avec succès.");
                } else {
                    System.out.println("La suppression du fichier a échoué.");
                }
            } catch (SecurityException e) {
                System.out.println("Permission refusée pour supprimer le fichier.");
            }
        } else {
            System.out.println("Le fichier n'existe pas.");
        }
    }
    public static void main(String[] args){
    }

}
