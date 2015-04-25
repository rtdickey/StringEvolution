package com.company;

/**
 * Created by Daniel Nguyen on 4/25/2015.
 */
public class Gene implements Comparable<Gene>{
    private String code;
    private int cost;

    public Gene() {
        code = "";
        cost = 9999;
    }

    public Gene(String code) {
        this.code = code;
        cost = 9999;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    //This function takes a int and generates a string that will be the code for the gene.
    public void random(int length){
        while((length--)!=0){
            this.code += Character.toString((char) Math.floor(Math.random()*255));
        }
    }

    //This function takes the original line and calculates the distance from the goal
    // string to it's current string.
    public void calcCost(String compareTo){
        int total = 0;
        for(int i = 0; i < this.code.length(); i++){
            total += (this.code.charAt(i) - compareTo.charAt(i)) * (this.code.charAt(i) - compareTo.charAt(i));
        }
        this.cost = total;
    }

    @Override
    public String toString() {
        return "Gene{" +
                "code='" + code + '\'' +
                ", cost=" + cost +
                '}';
    }

    //The mating function takes another chromosome as an argument, finds the center point
    // and returns the 2 children in an array of size 2
    public Gene[] mate(Gene gene){
        //Should we make the pivot point random?
        int pivot = Math.round(this.code.length() / 2) - 1;

        String child1 = (this.code.substring(0, pivot) + gene.code.substring(pivot));
        String child2 = (gene.code.substring(0, pivot) + this.code.substring(pivot));

        Gene []children = new Gene[2];
        children[0] = new Gene(child1);
        children[1] = new Gene(child2);

        return children;
    }

    //This function takes a percent chance as the argument. If the gene is to mutate,
    // the function randomly decides if we're going to add or subtract from the
    // randomly selected character.
    public void mutate(double chance){
        if(Math.random() > chance){
            return;
        }

        int index = (int) Math.floor(Math.random()*this.code.length());
        int upOrDown = (int) Math.round(Math.random());

        String newCode;
        if(upOrDown==0){
            //bring the character at the index down by one.
            if(code.charAt(index)==(char)0){
                newCode = this.code.substring(0,index) + (char)255 + this.code.substring(index+1);
            }
            else{
                newCode = this.code.substring(0,index) + (char)(code.charAt(index)-1) + this.code.substring((index+1));
            }
        }
        else{
            //bring the character at the index up by one
            if(code.charAt(index)==(char)255){
                newCode = this.code.substring(0,index) + (char)0 + this.code.substring(index+1);
            }
            else{
                newCode = this.code.substring(0,index) + (char)(code.charAt(index)+1) + this.code.substring((index+1));
            }
        }
        setCode(newCode);
    }

    @Override
    public int compareTo(Gene compareGene) {
        int compareCost = compareGene.getCost();
        return this.cost - compareCost;
    }
}
