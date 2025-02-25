package game;

import javax.swing.SwingUtilities;

import main_menu.MainMenuUI;
import ranking.RankUI;

public class CountryRessources {
    private double availWater;
    private double requiredWater;
    private int population;
    private int statisfPop;
    private int foodQuantity;
    private int electricity;
    private int housing;

    // Constructor
    public CountryRessources(double availWater, double requiredWater, int population, int statisfPop, int foodQuantity, int electricity, int housing) {
        this.availWater = availWater;
        this.requiredWater = requiredWater;
        this.population = population;
        this.statisfPop = statisfPop;
        this.foodQuantity = foodQuantity;
        this.electricity = electricity;
        this.housing = housing;
    }

    // Getters and Setters
    public double getAvailWater() {
    	if (availWater<0){
    		SwingUtilities.invokeLater(() -> new RankUI());
            SaveManagement savetool = new SaveManagement();
            savetool.deleteFile(MainMenuUI.name);
    	}
		return availWater;
        
    }

    public void setAvailWater(double availWater) {
    		this.availWater = availWater;
    }

    public double getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(double requiredWater) {
        this.requiredWater = requiredWater;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getStatisfPop() {
        return statisfPop;
    }

    public void setStatisfPop(int statisfPop) {
        this.statisfPop = statisfPop;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuality(int foodQuality) {
        this.foodQuantity = foodQuality;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getHousing() {
        return housing;
    }

    public void setHousing(int housing) {
        this.housing = housing;
    }
    
    public void changeRessources(CountryRessources Change) {
    	this.availWater -= Change.getAvailWater();
        this.requiredWater -= Change.getRequiredWater();
        this.population -= Change.getPopulation();
        this.statisfPop -= Change.getStatisfPop();
        this.foodQuantity -= Change.getFoodQuantity();
        this.electricity -= Change.getElectricity();
        this.housing -= Change.getHousing();
    }
    
    //country_ressources.changeRessources(QuizQuestion.getCountryRessources(int index))
}
