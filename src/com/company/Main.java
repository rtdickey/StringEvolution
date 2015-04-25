package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Gene test1 = new Gene();
        Gene test2 = new Gene();
        String line = "Hello World";
        test1.random(line.length());
        test1.calcCost(line);
        test2.random(line.length());
        test2.calcCost(line);
        System.out.println(test1.toString());
        System.out.println(test2.toString());

        test2.setCode(test1.mate(test2));
        test1.calcCost(line);
        test2.calcCost(line);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
    }
}
