package com.company;

/**
 * Created by Genide on 4/25/2015.
 */
public class Gene {
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

    //There may be some problems with this piece of code.
    public void random(int length){
        while((length--)!=0){
            this.code += Character.toString((char) Math.floor(Math.random()*255));
        }
    }

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

    //This is probably incorrect
    public String mate(Gene gene){
        //Should we make the pivot point random?
        int pivot = Math.round(this.code.length() / 2) - 1;

        String child1 = (this.code.substring(0, pivot) + gene.code.substring(pivot));
        String child2 = (gene.code.substring(0, pivot) + this.code.substring(pivot));

        this.code = child1;
        return child2;
    }

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
}
