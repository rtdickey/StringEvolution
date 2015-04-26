package com.company;

import java.util.Arrays;

/**
 * Created by Daniel Nguyen on 4/25/2015.
 */
public class Population {
    private int size;
    private Gene[] town;
    private double chance;
    private String goalString;
    private int generationNum;
    private int initialCost;
    private double percentComplete;

    public Population(int size, String goalString, double chance) {
        this.size = size;
        this.goalString = goalString;
        this.chance = chance;
        this.generationNum = 0;
        generateTown();
        this.initialCost = town[0].getCost();
        this.percentComplete = 0;
    }

    //This function creates the town for the constructor
    private void generateTown(){
        Gene[] town = new Gene[this.size];
        int length = goalString.length();
        for(int i=0; i<this.size; i++){
            town[i] = new Gene();
            town[i].random(length);
            town[i].calcCost(goalString);
        }
        Arrays.sort(town);
        this.town = town;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public String getGoalString() {
        return goalString;
    }

    public void setGoalString(String goalString) {
        this.goalString = goalString;
    }

    public int getGenerationNum() {
        return generationNum;
    }

    public void setGenerationNum(int generationNum) {
        this.generationNum = generationNum;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(int initialCost) {
        this.initialCost = initialCost;
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(double percentComplete) {
        this.percentComplete = percentComplete;
    }

    //This function returns a string of the entire town
    public String printTown(){
        String output = "";
        for(int i=0; i<this.size; i++){
            output += this.town[i].toString() + "\n";
        }
        return output;
    }

    @Override
    public String toString() {
        Arrays.sort(town);
        return "Population{" +
                "size=" + size +
                ", chance=" + chance +
                ", goalString='" + goalString +
                ", generationNum=" + generationNum +
                ", initalCost=" + initialCost +
                ", percentComplete=" + percentComplete +
                '}' + "\n" +
                printTown();
    }

    //This function calculates the cost for each town member
    public void calcTownCost(){
        for(int i = 0; i < size; i++){
            town[i].calcCost(goalString);
        }
    }

    //This function creates the next generation of the town.
    //It mates the top 2 lowest costing members and replaces the 2 highest cost members
    // with their children.
    public boolean generation(){
        calcTownCost();

        Arrays.sort(town);

        calculatePercentComplete(town[0].getCost());

        Gene []children = (town[0].mate(town[1]));
        town[size-2] = children[0];
        town[size-1] = children[1];

        for(int i=0; i < size; i++){
            town[i].mutate(chance);
            town[i].calcCost(goalString);
            if(town[i].getCode().equals(goalString)) {
                Arrays.sort(town);
                calcTownCost();
                calculatePercentComplete(town[0].getCost());
                System.out.println(this.toString());
                return true;
            }
        }

        generationNum++;
        return false;
    }

    public void calculatePercentComplete(int currentBest){
        this.percentComplete = (this.initialCost - currentBest)/(double)this.initialCost;
    }
}
